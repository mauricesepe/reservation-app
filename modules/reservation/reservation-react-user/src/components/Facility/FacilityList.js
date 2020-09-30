import React from 'react';

import { properties } from '../../properties.js';

import {ClayCheckbox} from '@clayui/form';

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
    this.setState({ 
      facilities: this.props.facilities,
      isLoaded: true
    })
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
    this.props.parentCallback(event.target.value)
  }

  render() {
    const list = [];
    const { facitilies, isLoaded, selected } = this.state;

    console.log("rerendered");

    if(this.state.facilities !== null && this.state.isLoaded === true) {
      this.state.facilities.map((post) => 
        list.push(
        <ClayCheckbox 
          id={post.amenityId}
          value={post.amenityId} 
          label={post.name}
          onChange={this.handleChange}
          inline/>)
      )
    }

    return (
      <div className="facilitylist">
        <label for="basicInputTypeText">{Liferay.Language.get("facility")} ({this.state.facilities.length})</label>
        <div className="facilitylist list">
          {list}
        </div>
      </div>
    )
  }
}
  