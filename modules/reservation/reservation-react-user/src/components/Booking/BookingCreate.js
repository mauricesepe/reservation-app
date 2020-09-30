import React, {useState, useEffect} from 'react';
import ReactDOM from 'react-dom';
import './style/booking.css';
import { properties } from '../../properties';

import ClayForm, {ClayInput} from '@clayui/form';
import ClayButton, { ClayButtonWithIcon } from '@clayui/button';

import BookingSearch from './BookingSearch';
import BookingReservations from './BookingReservations';

import PostToast from '../Clay/PostToast';
import DatePicker from '../Clay/DatePicker';
import StartEndTime from '../Clay/StartEndTime';
import AdaptiveBreadcrumb from '../Clay/AdaptiveBreadcrumb';

import ParticipantEntry from '../Participants/ParticipantEntry';
import AddParticipant from '../Participants/AddParticipant';

import StaticFacilityList from '../Facility/StaticFacilityList';
  
const participantsEndpoint = properties.participantsEndpoint;
const bookingsEndpoint = properties.bookingsEndpoint;

export default class BookingCreate extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      roomName: this.props.data.name,
      capacity: this.props.data.capacityPeople,
      office: this.props.office,
      startTime: [],
      endTime: [],
      title: '',
      date: '',
      description: '',
      roomId: this.props.data.roomId,
      participants: [],
      isValidated: false,
    }
    this.getDate = this.getDate.bind(this);
    this.getTimes = this.getTimes.bind(this);
    this.getParticipants = this.getParticipants.bind(this);
    this.changeDate = this.changeDate.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.createBooking = this.createBooking.bind(this);
    this.backToSearch = this.backToSearch.bind(this);
    this.clearStates = this.clearStates.bind(this);
    this.isTimeValid = this.isTimeValid.bind(this);
  }  

  backToSearch() {
    ReactDOM.render(<BookingSearch elementId={this.props.elementId} />, document.getElementById(this.props.elementId));
  }

  getDate = (datepicked) => {
    this.setState({
      date: this.changeDate(datepicked)
    })
  }

  getParticipants = (participants) => {
    this.setState({
      participants: participants
    })
  }
  
  getTimes = (start, end) => {
    this.setState({
      startTime: start,
      endTime: end
    });
  }

  changeDate(data) {
    var date = ''
    if((typeof data) === 'object') {
      date = new Date(data.toString());
      var day = date.getDate();
      var year = date.getFullYear();
      var month = date.getMonth() + 1;

      if(month < 10) {
        month = "0" + month
      }

      if(day < 10) {
        day = "0" + day
      }

      date = year + '-' + month + '-' + day;
    } else if ((typeof data) === 'string') {
      date = data
    }
    console.log(date);
    return date;
  }

  isTimeValid() {
    if (this.state.startTime.hours == '--' || this.state.startTime.minutes == '--' || this.state.startTime.ampm == '--'
        || this.state.endTime.hours == '--' || this.state.endTime.minutes == '--' || this.state.endTime.ampm == '--') {
      return false;
    }
    return true;
  }
  
  handleChange(evt) {
    const value = evt.target.value;
    this.setState({
      [evt.target.name]: value
    });
  }

  clearStates() {
    this.setState({
      title: '',
      date: '',
      description: '',
    });
  }

  createBooking() {
    this.setState({
      isValidated: true
    });

    if (this.state.title == '' 
        || this.state.description == '' 
        || this.state.date == '' 
        || !this.isTimeValid()) {
      console.log("missing required input")
    } else {
      var participantIds = [];
      this.state.participants.forEach(participant => {
        participantIds.push(participant.participantId);
      });
      const requestOptions = {
        "method": "POST",
        "headers": {
          Pragma: 'no-cache',
          "cache-control": "no-cache",
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          date: this.state.date,
          description: this.state.description,
          endTime: this.state.endTime,
          participantIds: participantIds,
          roomId: this.state.roomId,
          startTime: this.state.startTime,
          title: this.state.title
        })
      }
      fetch(bookingsEndpoint, requestOptions)
      .then(async response => {
        const data = await response.json();
        
        // check for error response
        if (!response.ok) {
            // get error message from body or default to response status
            const error = (data && data.title) || response.status;
            return Promise.reject(error);
        }
        if(response.ok) {
          this.clearStates();
          ReactDOM.render(
          <div>
            <BookingSearch elementId={this.props.elementId} />
            <PostToast alert={true} name={data.title} type={"n booking"} key={data.title} />
          </div>
          , document.getElementById(this.props.elementId));
        }
      })
      .catch(error => {
          this.setState({ errorMessage: error });
          alert(error);
      });
    }

    /*s
    var participantIds = [];
    this.state.participants.forEach(participant => {
      participantIds.push(participant.participantId);
    });
    const requestOptions = {
      "method": "POST",
      "headers": {
        "cache-control": "no-cache",
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        date: this.state.date,
        description: this.state.description,
        endTime: this.state.endTime,
        participantIds: participantIds,
        roomId: this.state.roomId,
        startTime: this.state.startTime,
        title: this.state.title
      })
    }
    fetch(bookingsEndpoint, requestOptions)
    .then(async response => {
      const data = await response.json();
      
      // check for error response
      if (!response.ok) {
          // get error message from body or default to response status
          const error = (data && data.title) || response.status;
          return Promise.reject(error);
      }
      if(response.ok) {
        this.clearStates();
        ReactDOM.render(
        <div>
          <BookingSearch elementId={this.props.elementId} />
          <PostToast alert={true} name={data.title} type={"n booking"} key={data.title} />
        </div>
        , document.getElementById(this.props.elementId));
      }
    })
    .catch(error => {
        this.setState({ errorMessage: error });
        alert(error);
    });
    */
  }

  renderParticipants() {
    var stickers = []
    if(this.state.participants !== []) {
      for (var i = 0; i< this.state.participants.length; i++) {
        var participant = this.state.participants[i];
        stickers.push(<ParticipantEntry checkboxes={false} name={participant.fullName} id={participant.participantId} />);
      }
    }
    return stickers;
  }

  render() {
    const spritemap = properties.icons;  
    const stickers = this.renderParticipants();

    return (
      <div className="booking-create">
      <div className="breadcrumb-sect">
        <div className="crumbs">
          <AdaptiveBreadcrumb breadcrumb={this.props.breadcrumb}/>
        </div>
      </div>

      <div className="contents">
        <div className="general">
          <div className="general-contents">
            <div className="sheet">
              <div className="sheet-header">
                <div className="sheet-title">
                  <ClayForm.Group className={(this.state.isValidated && this.state.title == '' ? 'has-error' : '')}>
                    <ClayInput className="meeting-title"
                      id="meeting title"
                      onChange={this.handleChange}
                      name="title"
                      value={this.state.title}
                      placeholder={Liferay.Language.get('meeting-title')}
                      type="text"
                    />
                    <ClayForm.FeedbackItem className={(this.state.isValidated && this.state.title == '' ? '' : 'empty')}>
                      <ClayForm.FeedbackIndicator
                        spritemap={spritemap}
                        symbol="exclamation-full"
                      />
                      {Liferay.Language.get('warn-must-not-be-blank')}
                    </ClayForm.FeedbackItem>
                  </ClayForm.Group>
                </div>
              </div>

              <div className="sheet-section">
                <ClayForm.Group className={(this.state.isValidated && this.state.date == '' ? 'has-error' : '')}>
                  <DatePicker parentCallback={this.getDate}/>
                  <ClayForm.FeedbackItem className={(this.state.isValidated && this.state.date == '' ? '' : 'empty')}>
                    <ClayForm.FeedbackIndicator
                      spritemap={spritemap}
                      symbol="exclamation-full"
                    />
                    {Liferay.Language.get('warn-must-not-be-blank')}
                  </ClayForm.FeedbackItem>
                </ClayForm.Group>

                <ClayForm.Group className={(this.state.isValidated && !this.isTimeValid() ? 'has-error' : '')}>
                  <StartEndTime parentCallback={this.getTimes} />
                  <ClayForm.FeedbackItem style={{clear:'both',paddingTop:'0.5rem'}}
                      className={(this.state.isValidated && !this.isTimeValid() ? '' : 'empty')}>
                    <ClayForm.FeedbackIndicator
                      spritemap={spritemap}
                      symbol="exclamation-full"
                    />
                    {Liferay.Language.get('warn-must-not-be-blank')}
                  </ClayForm.FeedbackItem>
                </ClayForm.Group>
              </div>

              <div className="sheet-section">
              <label for="basicInputTypeDate">{Liferay.Language.get('offices')}</label>
                <ClayInput className="office" readOnly
                  id="create office"
                  placeholder={this.state.office}
                  type="text"
                />
              </div>

              <div className="sheet-section">
                <label for="basicInputTypeText">{Liferay.Language.get('room-size')}</label>
                <ClayInput className="capacity" readOnly
                  id="create capacity"
                  placeholder={this.state.capacity}
                  type="text"
                />
              </div>

              <div className="sheet-section">
                <div className="room-facilities">
                  <StaticFacilityList selected={this.props.data.amenityIds} />
                </div>
              </div>

              <div className="sheet-section">
                <div className="line" />
              </div>

              <div className="sheet-section">
                <label for="basicInputTypeText">{Liferay.Language.get('room-name')}</label>
                <ClayInput className="roomOption" readOnly
                  id="create room"
                  placeholder={this.state.roomName}
                  type="text"
                />
              </div>

              <div className="sheet-section">
                <label for="basicInputTypeText">{Liferay.Language.get('description')}</label>
                <ClayForm.Group className={(this.state.isValidated && this.state.description == '' ? 'has-error' : '')}>
                  <ClayInput
                    className="description"
                    component="textarea"
                    name="description"
                    onChange={this.handleChange}
                    value={this.state.description}
                    placeholder={Liferay.Language.get('description')}
                    type="text"
                  />
                  <ClayForm.FeedbackItem className={(this.state.isValidated && this.state.description == '' ? '' : 'empty')}>
                    <ClayForm.FeedbackIndicator
                      spritemap={spritemap}
                      symbol="exclamation-full"
                    />
                    {Liferay.Language.get('warn-must-not-be-blank')}
                  </ClayForm.FeedbackItem>
                </ClayForm.Group>
              </div>

              <div className="sheet-section">
                <div className="endbutton">
                  <ClayButton displayType="primary" onClick={this.createBooking}>{Liferay.Language.get('save')}</ClayButton>
                  <ClayButton displayType="secondary" onClick={this.backToSearch}>{Liferay.Language.get('cancel')}</ClayButton>
                </div>
              </div>

            </div>
          </div>
        </div>

        <div className="participants">
          <div className="participants-contents">
            <div className="autofit-row" 
              style={{alignItems: "center"}}
            >
            </div>
              <div className="sheet">
                <div className="sheet-section">
                  <h1>{Liferay.Language.get('participant')}</h1> 
                  <AddParticipant parentCallback={this.getParticipants} className="participants"/>
                </div>
              </div>
              <div className="sheet">
                <div className="sheet-section">
                  <ClayButton  displayType="unstyled" className="participants" style={{padding: '10px'}}>{Liferay.Language.get('employee')}</ClayButton>
                </div>   
                <div className="participant-list">
                  {stickers}        
                </div>     
              </div>
          </div>
        </div>
      </div>
    </div>
    )
  }
}


