import React from 'react';
import AdminHeader from './AdminHeader';

export default class AdminPanel extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
    }
  }  
  render() {
    return (
      <div className="admin">
        <AdminHeader elementId={this.props.elementId} />
      </div>
    )
  }
}
  