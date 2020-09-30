import ClayBreadcrumb from '@clayui/breadcrumb';

import React from 'react';
import ReactDOM from 'react-dom';

import {properties} from '../../properties.js';

export default class AdaptiveBreadcrumb extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
    }
  }  

  render() {
    const spritemap = properties.icons;
    const booking = [
      {
        href: "#1",
        label: "Find A Room"
      },
      {
        href: "#2",
        label: "Conference Room A"
      },
      {
        href: "#3",
        label: "Book Room"
      }
    ];

    const conference = [
      {
        href: "#1",
        label: "Find A Room"
      },
      {
        href: "#2",
        label: "Conference Room A"
      }
    ]
  
    const event = [
      {
        href: "#1",
        label: "Home"
      },
      {
        href: "#2",
        label: "Conference Room A"
      }
    ]

    var returned = [];
    if(this.props.typeReturn === 'event') {
      returned = event;
    }else if(this.props.typeReturn === 'booking') {
      returned = booking;
    }else if(this.props.typeReturn === 'conference') {
      returned = conference;
    }

    return (
      <ClayBreadcrumb
        ellipsisBuffer={1}
        items={returned}
        spritemap={spritemap}
      />
    )
  }
}
