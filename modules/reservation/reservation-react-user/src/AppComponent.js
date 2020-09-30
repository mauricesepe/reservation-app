import React from "react";
import ReactDOM from "react-dom";
import {properties} from './properties.js';

import Booking from './components/Booking/Booking';


export default class extends React.Component {
  constructor(props) {
    super(props);
  }  

  render() {
    const spritemap = properties.icons;

    return (
        <div>
          <div>
            <Booking />
          </div>
          <div>
            <span className="tag">Portlet Namespace:</span>
            <span className="value">{this.props.portletNamespace}</span>
          </div>
          <div>
            <span className="tag">Context Path:</span>
            <span className="value">{this.props.contextPath}</span>
          </div>
          <div>
            <span className="tag">Portlet Element Id:</span>
            <span className="value">{this.props.portletElementId}</span>
          </div>
        </div>
    );
  }
}
