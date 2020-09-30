import React from 'react';

import OfficeTable from './OfficeTable';
import OfficeTableHeader from './OfficeTableHeader'

export default class Office extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      testRows: 15,
      keywords: "",
      data: {
      }
    }
  }  

  handleChange(value){
    this.setState({keywords: value});
  }

  render() {
    return (
      <div className="room">
        <OfficeTableHeader callback={this.handleChange.bind(this)} elementId={this.props.elementId} />
          <div className="room body">
            <div className="container-fluid container-fluid-max-xl container-view">
              <OfficeTable keywords={this.state.keywords} elementId={this.props.elementId} />
            </div>
          </div>
      </div>
    )
  }
}
  