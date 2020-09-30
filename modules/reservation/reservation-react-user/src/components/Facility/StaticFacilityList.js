import React from 'react';
import { properties } from '../../properties.js';

import {ClayCheckbox} from '@clayui/form';

const amenitiesEndpoint = properties.amenitiesEndpoint;

export default class StaticFacilityList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      facilities: [],
      selected: this.props.selected
    }
    this.renderStaticFacilities = this.renderStaticFacilities.bind(this);
    this.renderStaticFacilitiesCheck = this.renderStaticFacilitiesCheck.bind(this);
  }  

  componentDidMount() {
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
      this.setState({ 
        facilities: data.items
      })
    });
  }

  renderStaticFacilities(id) {
    if(this.state.facilities !== []) {
      var name = '';
      this.state.facilities.map((facility) => {
        if(facility.amenityId === id) {
          name = facility.name;
        }
      })
    }
    return name;
  }

  renderStaticFacilitiesCheck() {
    var list = [];
    if(this.state.facilities !== null && this.state.selected !== null) {
      for(var i = 0; i < this.state.selected.length; i++) {
        list.push(
          <ClayCheckbox 
          label={this.renderStaticFacilities(this.state.selected[i])}
          inline readOnly checked/>
        )
      }
    }
    return list;
  }
  
  render() {

    return (
      <div>
        {this.state.selected != null &&
          <div className="facilitylist">
            <label for="basicInputTypeText">{Liferay.Language.get('room-facilities')}</label>
            <div className="facilitylist list">
              {this.renderStaticFacilitiesCheck()}
            </div>
          </div>
        }
      </div> 
    )
  }
}
  
