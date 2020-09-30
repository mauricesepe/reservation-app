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
    return (
      <ClayBreadcrumb
        ellipsisBuffer={1}
        items={this.props.breadcrumb}
        spritemap={spritemap}
      />
    )
  }
}
