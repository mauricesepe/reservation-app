import React from 'react';
import ReactDOM from 'react-dom';

import ClayNavigationBar from '@clayui/navigation-bar';

import Room from "../Room/Room";
import Office from "../Office/Office";
import Facility from "../Facility/Facility";
import Purpose from "../Purpose/Purpose";

import {properties} from '../../properties.js';

export default class AdminPanel extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      selected: ""
    }
    this.callAdminRoom = this.callAdminRoom.bind(this);
    this.callOffice = this.callOffice.bind(this);
    this.callPurpose = this.callPurpose.bind(this);
    this.callFacility = this.callFacility.bind(this);
  }  

  callAdminRoom() {
    this.setState({
      selected: "部屋"
    });
    ReactDOM.render(<Room elementId={this.props.elementId} />, document.getElementById(this.props.elementId));
  }

  callOffice() {
    this.setState({
      selected: "オフィス"
    });
    ReactDOM.render(<Office type="regular" elementId={this.props.elementId} />,document.getElementById(this.props.elementId));
  }

  callFacility() {
    this.setState({
      selected: "施設"
    });
    ReactDOM.render(<Facility type="regular" elementId={this.props.elementId} />, document.getElementById(this.props.elementId));
  }

  callPurpose() {
    this.setState({
      selected: "目的"
    });
    ReactDOM.render(<Purpose elementId={this.props.elementId} />, document.getElementById(this.props.elementId));
  }

  componentDidMount() {
    this.callAdminRoom();
  }

  render() {
    const spritemap = properties.icons;
    const active = "admin-header-active btn btn-unstyled btn-block btn-sm";
    const regular = "admin-header btn btn-unstyled btn-block btn-sm";

    const btnStyle = {
      padding: "15px 25px 15px 25px",
    };

    return (
      <div className="admin header">
        <ClayNavigationBar triggerLabel="Mobile View" spritemap={spritemap} inverted={true}>
          <ClayNavigationBar.Item>
            <button
              className={(this.state.selected === "部屋") ? active : regular}
              style={btnStyle}
              type="button"
              onClick={this.callAdminRoom}
            >
              {Liferay.Language.get('room')}
            </button>
          </ClayNavigationBar.Item>
          <ClayNavigationBar.Item>
            <button
              className={(this.state.selected === "オフィス") ? active : regular}
              style={btnStyle}
              type="button"
              onClick={this.callOffice}
            >
              {Liferay.Language.get('offices')}
            </button>
          </ClayNavigationBar.Item>
          <ClayNavigationBar.Item>
            <button
              className={(this.state.selected === "施設") ? active : regular}
              style={btnStyle}
              type="button"
              onClick={this.callFacility}
            >
              {Liferay.Language.get('facility')}
            </button>
          </ClayNavigationBar.Item>
          <ClayNavigationBar.Item>
            <button
              className={(this.state.selected === "目的") ? active : regular}
              style={btnStyle}
              type="button"
              onClick={this.callPurpose}
            >
              {Liferay.Language.get('purpose')}
            </button>
          </ClayNavigationBar.Item>
        </ClayNavigationBar>
      </div>
    )
  }
  }
  