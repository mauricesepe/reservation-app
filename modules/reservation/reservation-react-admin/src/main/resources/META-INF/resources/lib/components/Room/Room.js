import React from 'react';

import './style/room.css';

import RoomTable from './RoomTable';
import RoomHeader from './RoomHeader'

export default class Room extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      testRows: 15,
      keywords: "",
      data: {

      }
    }
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(value){
    this.setState({keywords: value});
  }

  render() {
    return (
      <div className="room">
        <RoomHeader elementId={this.props.elementId} callback={this.handleChange.bind(this)} />
          <div className="room body">
            <div className="container-fluid container-fluid-max-xl container-view">
              <RoomTable keywords={this.state.keywords} elementId={this.props.elementId} />
            </div>
          </div>
      </div>
    )
  }
}
  