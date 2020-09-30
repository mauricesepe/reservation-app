import React from 'react';
import ReactDOM from 'react-dom';

import ClayButton, { ClayButtonWithIcon } from '@clayui/button';
import ClayTable from '@clayui/table';
import {ClayPaginationBarWithBasicItems} from '@clayui/pagination-bar';

import BookingReservationInformation from './BookingReservationInformation';
import BookingEdit from './BookingEdit';

import { properties } from '../../properties.js';
import './style/booking.css';

const bookingsEndpoint = properties.bookingsEndpoint + "&sort=startDate&filter=startDate ge " + new Date().toJSON();
const roomsEndpoint = properties.roomsEndpoint;

const requestOptions = {
  "async": true,
  "crossDomain": true,
  "method": "GET",
  "headers": {
    Pragma: 'no-cache',
    "cache-control": "no-cache",
  }
}

const deleteOptions = {
  "async": true,
  "crossDomain": true,
  "method": "DELETE",
  "headers": {
    Pragma: 'no-cache',
    "cache-control": "no-cache",
  }
}

export default class BookingReservationTable extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      activePage: 1,
      activeDelta: 10,
      totalItems: 0,
      bookings: [],
    }
    this.createTableRows = this.createTableRows.bind(this);
    this.getReservationInformation = this.getReservationInformation.bind(this);
    this.constructTimeRange = this.constructTimeRange.bind(this)
    this.deleteEntry = this.deleteEntry.bind(this);
    this.editEntry = this.editEntry.bind(this);
  }

  deleteEntry(name, id) {
    var bookingsUrl = bookingsEndpoint;
    bookingsUrl = bookingsUrl.split('?');
    bookingsUrl = bookingsUrl[0] + '/' + id + '?' + bookingsUrl[1];
    console.log(bookingsUrl)
    if(window.confirm(name + ": " + Liferay.Language.get('delete'))) {
      fetch(bookingsUrl, deleteOptions)
      .then(() => 
        this.fetchBookings(this.constructBookingsEndpoint()))
      .catch((err) => {
        console.log(err);
      });
    }
  }

  editEntry(booking) {
    this.props.breadcrumb.push({"label": booking.title})
    ReactDOM.render(<BookingEdit
      breadcrumb={this.props.breadcrumb}
      booking={booking}
      elementId={this.props.elementId}/>, 
      document.getElementById(this.props.elementId));
  }

  constructTimeRange(booking) {
    var startTime = booking.startTime
    var strStartTime = startTime.hours
        + ":" + startTime.minutes.padStart(2, '0') + startTime.ampm;
    var endTime = booking.endTime
    var strEndTime = endTime.hours
        + ":" + endTime.minutes.padStart(2, '0') + endTime.ampm;
    return strStartTime + " - " + strEndTime;
  }

  getReservationInformation(booking) {
    var roomsUrl = roomsEndpoint;
    roomsUrl = roomsUrl. split('?');
    roomsUrl = roomsUrl[0] + '/' + booking.roomId + '?' + roomsUrl[1];
    console.log(roomsUrl)
    fetch(roomsUrl, requestOptions)
    .then(async response => {
      const data = await response.json();
      if (response.ok) {
        this.props.breadcrumb.push({"label": booking.title})
        ReactDOM.render(<BookingReservationInformation
          breadcrumb={this.props.breadcrumb}
          booking={booking} 
          room={data}
          elementId={this.props.elementId}/>, document.getElementById(this.props.elementId));
      } else {
        const error = (data && data.title) || response.status;
        return Promise.reject(error);
      }
    })
    .catch(error => {
      this.setState({ errorMessage: error });
      alert(error);
    });
  }

  createTableRows() {
    var body = [];
    this.state.bookings.map((booking, i) => {
      body.push(
        <ClayTable.Row data={booking}>
          <ClayTable.Cell align={'left'}>
            <ClayButton 
              displayType="unstyled" 
              style={{textDecoration: "underline"}}
              onClick={() => this.getReservationInformation(booking)}
              >
              {booking.title}
            </ClayButton>
          </ClayTable.Cell>
          <ClayTable.Cell align={'left'}>{booking.officeName + " - " + booking.roomName}</ClayTable.Cell>
          <ClayTable.Cell align={'left'}>{booking.date}</ClayTable.Cell>
          <ClayTable.Cell align={'left'}>{this.constructTimeRange(booking)}</ClayTable.Cell>
          <ClayTable.Cell align={'left'}>{booking.userName}</ClayTable.Cell>
          <ClayTable.Cell align={'right'}>
            <ClayButtonWithIcon 
              symbol="pencil" 
              spritemap={properties.icons} 
              displayType={'unstyled'} 
              style={{padding: '0', margin: '0', height: '1rem'}}
              onClick={() => this.editEntry(booking)}/>
            <ClayButtonWithIcon 
              symbol="trash" 
              spritemap={properties.icons} 
              displayType={'unstyled'} 
              style={{padding: '0', margin: '0', height: '1rem'}}
              onClick={() => this.deleteEntry(booking.title, booking.bookingId)}/>
          </ClayTable.Cell>
        </ClayTable.Row>
      )
    });
    return body;
  }

  fetchBookings(url) {
    fetch(url, requestOptions)
    .then((res) => { 
        if (!res.ok) throw new Error();
          else return res.json();
    })
    .then((data) => {
      this.setState({ 
        bookings: data.items,
        activePage: (data.lastPage >= data.page) ? data.page : data.lastPage,
        totalItems: data.totalCount
      })
    });
  }

  componentDidUpdate(prevProps, prevState) {
    if (prevProps != this.props
        || prevState.activePage != this.state.activePage
        || prevState.activeDelta != this.state.activeDelta
        || prevState.totalItems != this.state.totalItems) {
      var url = this.constructBookingsEndpoint()
      if (this.props.keywords != "") {
        url = url + "&search='" + this.props.keywords + "'";
      }
      this.fetchBookings(url);
    }
  }

  constructBookingsEndpoint() {
    return bookingsEndpoint + "&pageSize=" + this.state.activeDelta + "&page=" + this.state.activePage;
  }

  componentDidMount() {
    this.fetchBookings(this.constructBookingsEndpoint());
  }

  render() {
    const rows = this.createTableRows();

    return (
      <div className="booking events contents">
        <ClayTable>
          <ClayTable.Head>
            <ClayTable.Row>
              <ClayTable.Cell headingCell headingTitle>
                {Liferay.Language.get("meeting-name")}
              </ClayTable.Cell>
              <ClayTable.Cell headingCell headingTitle>
                {Liferay.Language.get('location')}
              </ClayTable.Cell>
              <ClayTable.Cell headingCell headingTitle>
                {Liferay.Language.get('date')}
              </ClayTable.Cell>
              <ClayTable.Cell headingCell headingTitle>
                {Liferay.Language.get('time')}
              </ClayTable.Cell>
              <ClayTable.Cell headingCell headingTitle>
                {Liferay.Language.get('organizer')}
              </ClayTable.Cell>
              <ClayTable.Cell headingCell headingTitle>
                {''}
              </ClayTable.Cell>
            </ClayTable.Row>
          </ClayTable.Head>
          <ClayTable.Body>
            {rows}
          </ClayTable.Body>
        </ClayTable>
        <ClayPaginationBarWithBasicItems
          activePage={this.state.activePage}
          activeDelta={this.state.activeDelta}
          totalItems={this.state.totalItems}
          onPageChange={(page) => this.setState({activePage: page})}
          onDeltaChange={(delta) => this.setState({activeDelta: delta})}
          spritemap={properties.icons}
        />
      </div>
    )
  }
}