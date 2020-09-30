import React from 'react';
import ReactDOM from 'react-dom';

import './style/booking.css';
import { properties } from '../../properties';

import ClayButton from '@clayui/button';
import ClayLabel from '@clayui/label';
import ClayIcon from '@clayui/icon';
import ClayTable from '@clayui/table';


import BookingCreate from './BookingCreate';

import AdaptiveBreadcrumb from '../Clay/AdaptiveBreadcrumb';

const amenitiesEndpoint = properties.amenitiesEndpoint;

export default class BookingRoomInformation extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      amenities: [],
      facilities: [],
      roomName: this.props.data.name,
      capacity: this.props.data.capacityPeople,
      roomSize: this.props.data.capacitySquareMeters,
      startTime: this.props.data.availableStartTime,
      endTime: this.props.data.availableEndTime,
      ext: this.props.data.phoneExtension,
      ntwkName: this.props.data.wifiSSID,
      sec: this.props.data.wifiSecurityType,
      pwd: this.props.data.wifiPassword
    }
    this.buildTimeString = this.buildTimeString.bind(this);
    this.identifyAmenities = this.identifyAmenities.bind(this);
    this.bookRoom = this.bookRoom.bind(this);
  }

  identifyAmenities() {
    var amenities = [];
    if (this.props.data.amenityIds != null
        && this.state.amenities != null) {
      for (var i = 0; i < this.props.data.amenityIds.length; i++) {
        for (var j = 0; j < this.state.amenities.length; j++) {
          if (this.props.data.amenityIds[i] == this.state.amenities[j].amenityId) {
            amenities.push(this.state.amenities[j].name);
          }
        }
      }
    }
    this.setState({facilities: amenities});
  }

  componentDidMount() {
    fetch(amenitiesEndpoint, {
      "async": true,
      "crossDomain": true,
      "method": "GET",
      "headers": {
        Pragma: 'no-cache',
        "cache-control": "no-cache",
      }
    })
    .then((res) => { 
      if (!res.ok) throw new Error();
        else return res.json();
    })
    .then((data) => {
      this.setState({ 
        amenities: data.items,
      }, () => this.identifyAmenities())
    });
  }

  createFacilityTags() {
    var tags = [];
    if (this.state.facilities != null) {
      for(var i = 0; i < this.state.facilities.length; i++) {
        tags.push(
          <ClayLabel displayType="success" spritemap={properties.icons}>
            {this.state.facilities[i]}
          </ClayLabel>
        );
      }
    }
    return tags;
  }

  bookRoom(data) {
    this.props.breadcrumb.push({"label": Liferay.Language.get("book-room")})
    ReactDOM.render(
    <BookingCreate 
      breadcrumb={this.props.breadcrumb}
      data={data} 
      office={this.props.office} 
      elementId={this.props.elementId} />, document.getElementById(this.props.elementId));
  }

  buildTimeString(start, end) {
    return (
      start.hours + ':' + start.minutes.padStart(2, '0') + start.ampm + ' - ' + end.hours + ':' + end.minutes.padStart(2, '0') + end.ampm
    )
  }

  buildSecString(securityid) {
    var keys = ["WEP", "WPA/WPA2 Personal", "WPA2 Personal", "Dynamic WEP", "WPA/WPA2 Enterprise", "WPA2 Enterprise"];
    return keys[securityid];
  }

  render() {
    const spritemap = properties.icons;  
    return (
      <div className="booking-info">
        <div className="breadcrumb-sect">
          <div className="crumbs">
            <AdaptiveBreadcrumb breadcrumb={this.props.breadcrumb}/>
          </div>
        </div>

        <div className="contents">
          <div className="general">
            <div className="general-contents">
              <div className="sheet">
                <img src={this.props.data.photoPath === 'path' ? '/o/reservation-react-user/media/default-room.jpeg' : this.props.data.photoPath} 
                    className="fillout-contents img" />
                <div className="btn-row">
                  <h2 className="sheet-title">
                    {this.props.data.name}
                  </h2>
                  <ClayButton 
                    displayType="primary" 
                    style={{float: "right", marginTop: "15px"}}
                    onClick={() => this.bookRoom(this.props.data)}
                  > 
                  {Liferay.Language.get("book-room")} 
                  </ClayButton>
                </div>
                
                <div className="location">
                  <ClayIcon symbol="geolocation" spritemap={spritemap} /> {this.props.office}
                </div>
              </div>
            </div>
          </div>

          <div className="amenities">
            <div className="amenities-contents">
              <div className="sheet">
                <div className="sheet-section">
                  <ClayButton displayType="unstyled" className="info">{Liferay.Language.get("room-facilities")}</ClayButton>
                  <div className="form-group">
                    {this.createFacilityTags()}
                  </div>
                </div>                
              </div>

              <div className="sheet">
                <ClayButton displayType="unstyled" className="info">{Liferay.Language.get("generalDetails")}</ClayButton>
                <ClayTable borderless className="info-table">
                <ClayTable.Body>
                  <ClayTable.Row>
                    <ClayTable.Cell headingTitle>{Liferay.Language.get("capacity")}</ClayTable.Cell>
                    <ClayTable.Cell>{this.state.capacity + " " + Liferay.Language.get("people")}</ClayTable.Cell>
                  </ClayTable.Row>
                  <ClayTable.Row>
                    <ClayTable.Cell headingTitle>{Liferay.Language.get("room-size")}</ClayTable.Cell>
                    <ClayTable.Cell>{this.state.roomSize + " " + Liferay.Language.get("square-meter")}</ClayTable.Cell>
                  </ClayTable.Row>
                  <ClayTable.Row>
                    <ClayTable.Cell headingTitle>{Liferay.Language.get("avail-time")}</ClayTable.Cell>
                    <ClayTable.Cell>{this.buildTimeString(this.state.startTime, this.state.endTime)}</ClayTable.Cell>
                  </ClayTable.Row>
                  <ClayTable.Row>
                    <ClayTable.Cell headingTitle>{Liferay.Language.get("ext")}</ClayTable.Cell>
                    <ClayTable.Cell>{this.state.ext}</ClayTable.Cell>
                  </ClayTable.Row>
                </ClayTable.Body>
                </ClayTable>
              </div>

              <div className="sheet">
                <ClayButton displayType="unstyled" className="info">{Liferay.Language.get("network")}</ClayButton>
                <ClayTable borderless className="info-table">
                <ClayTable.Body>
                  <ClayTable.Row>
                    <ClayTable.Cell headingTitle>{Liferay.Language.get("network-name")}</ClayTable.Cell>
                    <ClayTable.Cell>{this.state.ntwkName}</ClayTable.Cell>
                  </ClayTable.Row>
                  <ClayTable.Row>
                    <ClayTable.Cell headingTitle>{Liferay.Language.get("security")}</ClayTable.Cell>
                    <ClayTable.Cell>{this.buildSecString(this.state.sec)}</ClayTable.Cell>
                  </ClayTable.Row>
                  <ClayTable.Row>
                    <ClayTable.Cell headingTitle>{Liferay.Language.get("password")}</ClayTable.Cell>
                    <ClayTable.Cell>{this.state.pwd}</ClayTable.Cell>
                  </ClayTable.Row>
                </ClayTable.Body>
                </ClayTable>
              </div>
            </div>
          </div>
        </div>
      </div>
    )
  }
}