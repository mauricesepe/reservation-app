import React from 'react';
import ReactDOM from 'react-dom';

import './style/booking.css';

import ClayForm, {ClayInput} from '@clayui/form';
import ClayButton, { ClayButtonWithIcon } from '@clayui/button';

import PostToast from '../Clay/PostToast';
import DatePicker from '../Clay/DatePicker';
import StartEndTime from '../Clay/StartEndTime';
import AdaptiveBreadcrumb from '../Clay/AdaptiveBreadcrumb';

import BookingReservations from './BookingReservations';

import ParticipantEntry from '../Participants/ParticipantEntry';
import AddParticipant from '../Participants/AddParticipant';

import isEqual from 'lodash/isEqual';

import { properties } from '../../properties.js';

const bookingsEndpoint = properties.bookingsEndpoint;
const participantsEndpoint = properties.participantsEndpoint;
const requestOptions = {
  "async": true,
  "crossDomain": true,
  "method": "GET",
  "headers": {
    Pragma: 'no-cache',
    "cache-control": "no-cache",
  }
}

export default class BookingEdit extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      roomId: this.props.booking.roomId,
      bookingId: this.props.booking.bookingId,
      title: this.props.booking.title,
      date: this.props.booking.date,
      startTime: this.props.booking.startTime,
      endTime: this.props.booking.endTime,
      description: this.props.booking.description,
      participantIds: this.props.booking.participantIds,
      participants: []
    }
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleCancel = this.handleCancel.bind(this);
    this.getDate = this.getDate.bind(this);
    this.getTimes = this.getTimes.bind(this);
    //this.getParticipants = this.getParticipants.bind(this);
    this.changeDate = this.changeDate.bind(this);
    this.renderParticipants = this.renderParticipants.bind(this);
    this.isTimeValid = this.isTimeValid.bind(this);
  } 
  
  handleChange(evt) {
    const value = evt.target.value;
    this.setState({
      [evt.target.name]: value
    });
  }

  getDate = (datepicked) => {
    this.setState({
      date: this.changeDate(datepicked)
    })
  }

  changeDate(data) {
    var date = ''
    if((typeof data) === 'object') {
      date = data.getFullYear() 
          + '-' + (data.getMonth() + 1).toString().padStart(2,'0') 
          + '-' + data.getDate().toString().padStart(2,'0');
    } else if ((typeof data) === 'string') {
      date = data
    }
    return date;
  }

  getTimes = (start, end) => {
    this.setState({
      startTime: start,
      endTime: end
    });
  }

  isTimeValid() {
    if (this.state.startTime.hours == '--' || this.state.startTime.minutes == '--' || this.state.startTime.ampm == '--'
        || this.state.endTime.hours == '--' || this.state.endTime.minutes == '--' || this.state.endTime.ampm == '--') {
      return false;
    }
    return true;
  }
  
  /*
  getParticipants = (participants) => {
    var participantIds = [];
    participants.forEach(participant => {
      participantIds.push(participant.participantId);
    });
    this.setState({
      participants: participants,
      participantIds: participantIds
    })
  }
  */

  renderParticipants() {
    var stickers = []
    if (this.state.participants != null) {
      this.state.participants.forEach(participant => {
        stickers.push(<ParticipantEntry checkboxes={false} name={participant.fullName} id={participant.participantId} />);
      })
    }
    return stickers;
  }

  handleSubmit() {
    if (!isEqual({
      title: this.props.booking.title,
      date: this.props.booking.date,
      description: this.props.booking.description,
      start: {
        hours: parseInt(this.props.booking.startTime.hours),
        minutes: parseInt(this.props.booking.startTime.minutes),
        ampm: this.props.booking.startTime.ampm.toUpperCase(),
      },
      end: {
        hours: parseInt(this.props.booking.endTime.hours),
        minutes: parseInt(this.props.booking.endTime.minutes),
        ampm: this.props.booking.endTime.ampm.toUpperCase(),
      }
    },{
      title: this.state.title,
      date: this.state.date,
      description: this.state.description,
      start: {
        hours: parseInt(this.state.startTime.hours),
        minutes: parseInt(this.state.startTime.minutes),
        ampm: this.state.startTime.ampm.toUpperCase(),
      },
      end: {
        hours: parseInt(this.state.endTime.hours),
        minutes: parseInt(this.state.endTime.minutes),
        ampm: this.state.endTime.ampm.toUpperCase(),
      }
    })) {
      if (this.state.title == '' 
      || this.state.description == '' 
      || this.state.date == '' 
      || !this.isTimeValid()) {
        console.log("missing required input")
      } else {
        var url = bookingsEndpoint;
        url = url.split('?');
        url = url[0] + '/' + this.state.bookingId + '?' + url[1];
        fetch(url, {
          "async": true,
          "crossDomain": true,
          "method": "PUT",
          "headers": {
            Pragma: 'no-cache',
            "cache-control": "no-cache",
            'Content-Type': 'application/json',
            Accept: 'application/json',
          },
          body: JSON.stringify({
            roomId: this.state.roomId,
            bookingId: this.state.bookingId,
            title: this.state.title,
            description: this.state.description,
            date: this.state.date,
            startTime: this.state.startTime,
            endTime: this.state.endTime,
            participantIds: this.state.participantIds
          })
        })
        .then(async response => {
          const data = await response.json();
          if (!response.ok) {
            console.log(data)
            const error = (data && data.title) || response.status;
            return Promise.reject(error);
          }
          if (response.ok) {
            ReactDOM.render(<div>
              <BookingReservations
                breadcrumb={[{"label": Liferay.Language.get("home")}]}
                elementId={this.props.elementId}
                />
              <PostToast 
                alert={true} 
                name={this.state.title} 
                type={" updated booking"} 
                key={this.state.title} />
            </div>,document.getElementById(this.props.elementId))
          }
        }).catch(error => {
          alert(error)
        })
      }
    } else {
      alert("no changes detected...")
    }
  }

  handleCancel() {
    ReactDOM.render(<BookingReservations
      breadcrumb={[{"label": Liferay.Language.get("home")}]}
      elementId={this.props.elementId}
    />,document.getElementById(this.props.elementId));
  }

  fetchParticipants() {
    var array = [];
    if (this.state.participantIds != null) {
      this.state.participantIds.forEach(id => {
        var url = participantsEndpoint;
        url = url.split('?');
        url = url[0] + '/' + id + '?' + url[1];
        fetch(url, requestOptions)
        .then(async response => {
          const data = await response.json();
          if (response.ok) {
            array.push(data);
          } else {
            const error = (data && data.title) || response.status;
            return Promise.reject(error);
          }
  
          if (array.length == this.state.participantIds.length) {
            this.setState({
              participants: array
            })
          }
        })
        .catch(error => {
          console.log(error);
        });
      })
    }
  }

  componentDidMount() {
    this.fetchParticipants();
  }

  render() {
    const spritemap = properties.icons;
    const stickers = this.renderParticipants();
    return(
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
                  <ClayForm.Group className={(this.state.title == '' ? 'has-error' : '')}>
                    <ClayInput className="meeting-title"
                      id="meeting title"
                      onChange={this.handleChange}
                      name="title"
                      value={this.state.title}
                      placeholder={Liferay.Language.get('meeting-title')}
                      type="text"
                    />
                    <ClayForm.FeedbackItem className={(this.state.title == '' ? '' : 'empty')}>
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
                  <ClayForm.Group className={(this.state.date == '' ? 'has-error' : '')}>
                    <DatePicker 
                      parentCallback={this.getDate} 
                      date={this.state.date}/>
                    <ClayForm.FeedbackItem className={(this.state.date == '' ? '' : 'empty')}>
                      <ClayForm.FeedbackIndicator
                        spritemap={spritemap}
                        symbol="exclamation-full"
                      />
                      {Liferay.Language.get('warn-must-not-be-blank')}
                    </ClayForm.FeedbackItem>
                  </ClayForm.Group>

                  <ClayForm.Group className={(!this.isTimeValid() ? 'has-error' : '')}>
                    <StartEndTime 
                      parentCallback={this.getTimes} 
                      start={this.state.startTime}
                      end={this.state.endTime} />
                    <ClayForm.FeedbackItem style={{clear:'both',paddingTop:'0.5rem'}}
                        className={(!this.isTimeValid() ? '' : 'empty')}>
                      <ClayForm.FeedbackIndicator
                        spritemap={spritemap}
                        symbol="exclamation-full"
                      />
                      {Liferay.Language.get('warn-must-not-be-blank')}
                    </ClayForm.FeedbackItem>
                  </ClayForm.Group>
                </div>

                <div className="sheet-section">
                  <label for="basicInputTypeText">{Liferay.Language.get('description')}</label>
                  <ClayForm.Group className={(this.state.description == '' ? 'has-error' : '')}>
                  <ClayInput
                    className="description"
                    component="textarea"
                    name="description"
                    onChange={this.handleChange}
                    value={this.state.description}
                    placeholder={Liferay.Language.get('description')}
                    type="text"
                  />
                  <ClayForm.FeedbackItem className={(this.state.description == '' ? '' : 'empty')}>
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
                    <ClayButton displayType="primary" onClick={this.handleSubmit}>{Liferay.Language.get('save')}</ClayButton>
                    <ClayButton displayType="secondary" onClick={this.handleCancel}>{Liferay.Language.get('cancel')}</ClayButton>
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