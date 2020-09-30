import React from 'react';

import './style/room.css';

import {ClaySelect} from '@clayui/form';

export default class CreateRoomSecurity extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      selected: (this.props.selected != null) ? this.props.selected : 0
    }
    this.handleChange = this.handleChange.bind(this);
  }  

  handleChange(event) {
    this.setState({selected: event.target.value});
    this.props.parentCallback(event.target.value);
  }

  render() {
    var list = [];
    const security = ["WEP", "WPA/WPA2 Personal", "WPA2 Personal", "Dynamic WEP", "WPA/WPA2 Enterprise", "WPA2 Enterprise"];

    {
      for(var i = 0; i < security.length; i++) {
        list.push(
          <ClaySelect.Option
            label={security[i]}
            id={[i]}
            value={i}
          />
        )
      }
    }
    
    return (
      <div className="createroom security">
      <ClaySelect aria-label="Security Select" value={this.state.selected} onChange={this.handleChange}>
        {list}
      </ClaySelect>
    </div>
    )
  }
}
  