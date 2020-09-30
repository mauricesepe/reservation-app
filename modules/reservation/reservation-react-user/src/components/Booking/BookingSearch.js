import React from 'react';
import './style/booking.css';
import { properties } from '../../properties';

import ClayButton from '@clayui/button';
import ClayManagementToolbar from '@clayui/management-toolbar';
import {ClayInput} from '@clayui/form';  
import {ClayButtonWithIcon} from '@clayui/button';

import OfficeSelection from '../Office/OfficeSelection';
import CapacitySlider from '../Clay/CapacitySlider';
import FacilityList from '../Facility/FacilityList';
import BookingRenderCards from './BookingRenderCards';
import DatePicker from '../Clay/DatePicker';
import StartEndTime from '../Clay/StartEndTime';

const requestOptions = {
    "async": true,
    "crossDomain": true,
    "method": "GET",
    "headers": {
      Pragma: 'no-cache',
      "cache-control": "no-cache",
    }
  }

const roomsEndpoint = properties.roomsEndpoint;
const officesEndpoint = properties.officesEndpoint;
const amenitiesEndpoint = properties.amenitiesEndpoint;

export default class BookingSearch extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      rooms: [],
      availableDay: '',
      availableStartTime: [],
      availableEndTime: [],
      officeId: [],
      amenityIds: [],
      capacity: 0,
      keyword: "",
      updated: false,
      facilities: [],
      offices: [{
        location: '--',
        name: '--',
        officeId: null
      }]
    }
    this.getDate = this.getDate.bind(this);
    this.getTimes = this.getTimes.bind(this);
    this.retrieveOffice = this.retrieveOffice.bind(this);
    this.retrieveFacilities = this.retrieveFacilities.bind(this);
    this.searchRooms = this.searchRooms.bind(this);
    this.filterRooms = this.filterRooms.bind(this);
    this.handleKeywordChange = this.handleKeywordChange.bind(this);
  }  

  getDate = (date) => {
    this.setState({
      availableDay: date.toString().substring(0,3)
    });
  }

  getTimes = (start, end) => {
    this.setState({
      availableStartTime: start,
      availableEndTime: end
    });
  }

  retrieveOffice = (childData) => {
    this.setState({officeId: (childData)})
  }

  retrieveFacilities = (childData) => {
    if(this.state.amenityIds[0] !== null && this.state.amenityIds.includes(childData)) {
      this.setState({
        amenityIds: this.state.amenityIds.filter(e => e !== childData)
      });
    } else if(!this.state.amenityIds.includes(childData)) {
      this.setState({
        amenityIds: this.state.amenityIds.concat(childData)
      });
    }
  }

  retrieveCapacity = (childData) => {
    this.setState({capacity: (childData)})
  }

  fetchRooms(url) {
    fetch(url,requestOptions)
    .then((res) => { 
      if (!res.ok) throw new Error();
        else return res.json();
    })
    .then((data) => {
      this.setState({ 
        rooms: data.items,
        updated: true
      })
    });
  }

  fetchFacilities(url) {
    console.log(url)
    fetch(url,requestOptions)
    .then((res) => { 
      if (!res.ok) throw new Error();
        else return res.json();
    })
    .then((data) => {
      this.setState({ 
        facilities: data.items,
        updated: true
      })
    });
  }

  fetchOffices(url) {
    console.log(url)
    fetch(url,requestOptions)
    .then((res) => { 
      if (!res.ok) throw new Error();
        else return res.json();
    })
    .then((data) => {
      this.setState({ 
        offices: this.state.offices.concat(data.items),
        // officeId: data.items[0].officeId,
        updated: true
      })
    });
  }

  filterRooms() {
    this.setState({
      keyword: ""
    });
    var query = this.constructQuery();
    this.fetchRooms(roomsEndpoint + query)
  }

  searchRooms() {
    this.fetchRooms(roomsEndpoint + "&search='" + this.state.keyword + "'")
  }

  convertTime(time) {
    var hours = parseInt(time.hours)
    var minutes = parseInt(time.minutes)
    var isPm = (time.ampm === "PM") ? true : false
    if (hours === NaN 
        || minutes === NaN 
        || (time.ampm != "PM" && time.ampm != "AM")) {
      return null
    } else {
      return (hours % 12 + (isPm ? 12 : 0)) * 60 + minutes;
    }
  }

  constructQuery() {
    var updated = false;
    var queryparams = "&filter=";

    var startTime = this.convertTime(this.state.availableStartTime)
    if (startTime != null) {
      queryparams = queryparams + "availableStartTime le " + startTime + " and "
      updated = true;
    }

    var endTime = this.convertTime(this.state.availableEndTime)
    if (endTime != null) {
      queryparams = queryparams + "availableEndTime ge " + endTime + " and "
      updated = true;
    }

    if (this.state.availableDay != '') {
      const mapping = {
        'Sun' : 'availableSunday eq true',
        'Mon' : 'availableMonday eq true',
        'Tue' : 'availableTuesday eq true',
        'Wed' : 'availableWednesday eq true',
        'Thu' : 'availableThursday eq true',
        'Fri' : 'availableFriday eq true',
        'Sat' : 'availableSaturday eq true',
      };
      queryparams = queryparams + mapping[this.state.availableDay] + " and "
      updated = true;
    }
    
    if (this.state.officeId != '' && !isNaN(this.state.officeId)) {
      queryparams = queryparams + "officeId eq '" + this.state.officeId + "' and "
      updated = true;
    }

    if (this.state.capacity > 0) {
      queryparams = queryparams + "capacityPeople ge " + this.state.capacity + " and "
      updated = true;
    }

    this.state.amenityIds.forEach(item =>{
      queryparams = queryparams + "amenityIds/any(k:k eq '" + item + "') and "
      updated = true;
    })

    if (!updated) {
      queryparams = "";
    }

    return queryparams.substring(0, queryparams.length-5);
  }

  // resetFilters() {
  //   fetch(url,requestOptions)
  //   .then((res) => { 
  //     if (!res.ok) throw new Error();
  //       else return res.json();
  //   })
  //   .then((data) => {
  //     this.setState({ 
  //       rooms: data.items,
  //       officeId: [],
  //       facilities: [],
  //       availableStartTime: [],
  //       availableEndTime: [],
  //       amenityIds: [],
  //       capacity: 0,
  //     })
  //   });
  // }

  componentDidMount() {
    this.fetchRooms(roomsEndpoint);
    this.fetchFacilities(amenitiesEndpoint);
    this.fetchOffices(officesEndpoint);
  }

  handleKeywordChange(event) {
    this.setState({
      keyword: event.target.value
    });
  }

  render() {
    const spritemap = properties.icons;
    console.log(this.state.availableDay);

    return (
      <div className="booking find">
        <div className="container-fluid container-fluid-max-xl booking find cont">
          <div className="booking find cont-1">
            <div className="booking find cont-1 contents">
              <div className="sheet sheet-lg">
                <div className="search sheet-section">
                  <ClayManagementToolbar>
                    <ClayManagementToolbar.Search>
                      <ClayInput.Group>
                        <ClayInput.GroupItem>
                          <ClayInput
                            aria-label="Search"
                            className="form-control input-group-inset input-group-inset-after"
                            placeholder={Liferay.Language.get('search-placeholder')}
                            type="text"
                            onChange={this.handleKeywordChange}
                            value={this.state.keyword}
                          />
                          <ClayInput.GroupInsetItem after tag="span">
                            <ClayButtonWithIcon 
                              displayType="unstyled"
                              spritemap={spritemap}
                              symbol="search"
                              onClick={() => this.searchRooms()}
                            />
                          </ClayInput.GroupInsetItem>
                        </ClayInput.GroupItem>
                      </ClayInput.Group>
                    </ClayManagementToolbar.Search>
                  </ClayManagementToolbar>
                </div>

                <div className="calendar">
                  <DatePicker parentCallback={this.getDate}/>
                  <StartEndTime parentCallback={this.getTimes}/>
                </div>
                
                <div className="sheet-section">
                  <div className="location">
                    <OfficeSelection offices={this.state.offices} parentCallback={this.retrieveOffice}/>
                  </div>
                </div>

                <div className="sheet-section">
                  <div className=" capacity">
                    <label for="slider" className=" capacity title">{Liferay.Language.get("capacity")}</label>
                    <CapacitySlider parentCallback={this.retrieveCapacity}/>
                  </div>
                </div>

                <div className=" facility sheet-section">
                  <FacilityList facilities={this.state.facilities} type="List" parentCallback={this.retrieveFacilities}/>
                </div>

                <div className="sheet-section"></div>
                  <ClayButton displayType="primary" onClick={() => this.filterRooms()}>{Liferay.Language.get("search")}</ClayButton>
                  <ClayButton displayType="primary" onClick={() => this.props.parentCallback(!this.props.reloadState)} style={{marginLeft: '10px'}}>{Liferay.Language.get("clear")}</ClayButton>
                <div className="sheet-section"></div>

              </div>
            </div>
          </div>
          <div class="booking-find cont-2">
            <div className="container-fluid container-fluid-max-xl">
              <div className="booking filtered sheet" style={{maxHeight: "860px", marginTop: "10px"}}>
                <div className="booking filtered sheet-section">
                  <ClayButton displayType="unstyled" className="booking filetered corner">{Liferay.Language.get("available-today")}</ClayButton>
                </div>

                <div className="booking filtered sheet-section">
                  <BookingRenderCards data={this.state.rooms} elementId={this.props.elementId}/>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    )
  }
}
  