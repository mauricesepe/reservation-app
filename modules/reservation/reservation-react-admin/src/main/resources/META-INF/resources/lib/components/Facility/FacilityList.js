import React from 'react';

import {ClayCheckbox} from '@clayui/form';

import {properties} from '../../properties.js';

const amenitiesEndpoint = properties.amenitiesEndpoint;

export default class FacilityList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      facilities: [],
      isLoaded: false,
      selected: [],
      fetch: []
    }
    this.handleChange = this.handleChange.bind(this);
  }  

  componentDidMount(prevProps) {
    if (this.props.facilities != null) {
      this.setState({ 
        facilities: this.props.facilities,
        isLoaded: true
      })
    } else {
      fetch(amenitiesEndpoint, {
        "async": true,
        "crossDomain": true,
        "method": "GET",
        "headers": {
          Pragma: 'no-cache',
          "cache-control": "no-cache",
        }
      })
      .then((res) => { 
        if (!res.ok) throw new Error();
          else return res.json();
      })
      .then((data) => {
        var facilities = data.items.map((item) => ({
          amenityId: parseInt(item.amenityId),
          name: item.name,
          checked: (this.props.selected != null && this.props.selected.indexOf(item.amenityId) != -1) ? true : false
        }))
        this.setState({ 
          facilities: facilities,
          isLoaded: true
        })
      });
    }
  }

  componentDidUpdate(prevProps) {
    // Typical usage (don't forget to compare props):
    if (this.props.facilities !== prevProps.facilities) {
      this.setState({ 
        facilities: this.props.facilities
      })
    }
  }

  handleChange(event) {
    var index = this.state.facilities.findIndex(x => x.amenityId === parseInt(event.target.value));
    if (index != -1) {
      var array = this.state.facilities;
      array[index].checked = !array[index].checked
      this.setState({
        facilities: array
     })
    }
    this.props.parentCallback(parseInt(event.target.value))
  }

  render() {
    const list = [];
    const { facitilies, isLoaded, selected } = this.state;
    if(this.state.facilities !== null && this.state.isLoaded === true) {
      this.state.facilities.map((post) => 
        list.push(
        <ClayCheckbox 
          id={post.amenityId}
          value={post.amenityId} 
          label={post.name}
          onChange={this.handleChange}
          checked={post.checked}
          inline/>)
      )
    }

    return (
      <div className="facilitylist">
        <label for="basicInputTypeText">{Liferay.Language.get('facility')} ({this.state.facilities.length})</label>
        <div className="facilitylist list">
          {list}
        </div>
      </div>
    )
  }
}
  