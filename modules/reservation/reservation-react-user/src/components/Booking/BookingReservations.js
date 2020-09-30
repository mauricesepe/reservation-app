import React from 'react';
import './style/booking.css';
import { properties } from '../../properties';

import ClayForm, {ClayInput} from '@clayui/form';
import ClayButton from '@clayui/button';

import BookingReservationTable from './BookingReservationTable';
import BookingReservationHeader from './BookingReservationHeader';

export default class BookingReservations extends React.Component {
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
      <div className="booking events">
      <BookingReservationHeader callback={this.handleChange.bind(this)} elementId={this.props.elementId} />
      <div className="container-fluid container-fluid-max-xl container-view">
        <div className="booking events sheet">
          <div className="booking events sheet-section">
            <ClayButton displayType="unstyled" className="booking events day">{Liferay.Language.get('meetings')}</ClayButton>
          </div>

          <div className="booking events sheet-section">
            <BookingReservationTable keywords={this.state.keywords} elementId={this.props.elementId} breadcrumb={this.props.breadcrumb} />
          </div>

        </div>
      </div>
    </div>
    )
  }
}
  
