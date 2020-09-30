import React from 'react';
import ReactDOM from 'react-dom';

import ClayForm, {ClayInput, ClayToggle} from '@clayui/form';
import ClayButton from '@clayui/button';

import PostToast from '../Clay/PostToast';
import StartEndTime from '../Clay/StartEndTime';

import Room from './Room'
import CreateRoomSecuritySelect from './CreateRoomSecuritySelect';

import FacilityList from '../Facility/FacilityList';
import PurposeSelector from '../Purpose/PurposeSelector';

import isEqual from 'lodash/isEqual';

import { properties } from '../../properties.js';

const roomsEndpoint = properties.roomsEndpoint;

export default class CreateRoom extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      amenityIds: this.props.room.amenityIds,
      availableEndTime: this.props.room.availableEndTime,
      availableFriday: this.props.room.availableFriday,
      availableMonday: this.props.room.availableMonday,
      availableSaturday: this.props.room.availableSaturday,
      availableStartTime: this.props.room.availableStartTime,
      availableSunday: this.props.room.availableSunday,
      availableThursday: this.props.room.availableThursday,
      availableTuesday: this.props.room.availableTuesday,
      availableWednesday: this.props.room.availableWednesday,
      capacityPeople: parseInt(this.props.room.capacityPeople),
      capacitySquareMeters: parseInt(this.props.room.capacitySquareMeters),
      name: this.props.room.name,
      officeId: this.props.room.officeId,
      officeName: this.props.room.officeName,
      phoneExtension: this.props.room.phoneExtension,
      photoPath: this.props.room.photoPath,
      purposeIds: this.props.room.purposeIds,
      roomId: this.props.room.roomId,
      wifiPassword: this.props.room.wifiPassword,
      wifiSSID: this.props.room.wifiSSID,
      wifiSecurityType: this.props.room.wifiSecurityType,
    }
    this.handleChange = this.handleChange.bind(this);
    this.handleChangeInt = this.handleChangeInt.bind(this);
    this.updateRoom = this.updateRoom.bind(this);
    this.cancelEdit = this.cancelEdit.bind(this);
  }

  handleChange(evt) {
    const value = evt.target.value;
    this.setState({
        [evt.target.name]: value,
    });
  }

  handleChangeInt(evt) {
    const value = evt.target.value;
    if (!isNaN(value)) {
      this.setState({
          [evt.target.name]: (value == '') ? 0 : parseInt(value),
      });
    }
  }

  getTimes = (start, end) => {
    // remove trailing zeroes
    this.setState({
      availableStartTime: {
        hours: parseInt(start.hours).toString(),
        minutes: parseInt(start.minutes).toString(),
        ampm: start.ampm
      },
      availableEndTime: {
        hours: parseInt(end.hours).toString(),
        minutes: parseInt(end.minutes).toString(),
        ampm: end.ampm
      }
    });
  }

  retrieveSecurity = (childData) => {
    this.setState({wifiSecurityType: Number(childData)})
  }

  retrievePurposes = (childData) => {
    this.setState({purposeIds: (childData)})
  }

  retrieveFacilities = (childData) => {
    var amenityIds = (this.state.amenityIds == null) ? [] : this.state.amenityIds;
    if (amenityIds.indexOf(childData) > -1) {
      amenityIds = amenityIds.filter(e => e !== childData)
    } else {
      amenityIds = amenityIds.concat(childData);
    }
    this.setState({
      amenityIds: amenityIds
    })
  }

  updateRoom() {
    if (!isEqual(this.state,this.props.room)) {
      var roomsUrl = roomsEndpoint;
      roomsUrl = roomsUrl.split('?');
      roomsUrl = roomsUrl[0] + '/' + this.state.roomId + '?' + roomsUrl[1];
      fetch(roomsUrl, {
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
          amenityIds: this.state.amenityIds,
          availableEndTime: this.state.availableEndTime,
          availableMonday: this.state.availableMonday,
          availableTuesday: this.state.availableTuesday,
          availableWednesday: this.state.availableWednesday,
          availableThursday: this.state.availableThursday,
          availableFriday: this.state.availableFriday,
          availableSaturday: this.state.availableSaturday,
          availableSunday: this.state.availableSunday,
          availableStartTime: this.state.availableStartTime,
          capacityPeople: this.state.capacityPeople,
          capacitySquareMeters: this.state.capacitySquareMeters,
          name: this.state.name,
          officeId: this.state.officeId,
          phoneExtension: this.state.phoneExtension,
          photoPath: this.state.photoPath,
          purposeIds: this.state.purposeIds,
          wifiPassword: this.state.wifiPassword,
          wifiSSID: this.state.wifiSSID,
          wifiSecurityType: this.state.wifiSecurityType
        })
      }).then((res) => { 
        if (!res.ok) throw new Error();
          else return res.json();
      }).then((data) => {
        ReactDOM.render(<div>
          <Room elementId={this.props.elementId}/>
          <PostToast alert={true} name={data.name} type={" updated room"} key={data.name} />
        </div>, document.getElementById(this.props.elementId));
      })
      .catch(error => {
        alert("Unexpected error!")
        ReactDOM.render(<Room elementId={this.props.elementId} />, document.getElementById(this.props.elementId));
      });
    } else {
      alert("no changes detected...")
    }
  }

  cancelEdit() {
    ReactDOM.render(<Room elementId={this.props.elementId} />, document.getElementById(this.props.elementId));
  }

  componentDidMount() {
  }

  render() {
    const { availableFriday, availableMonday, availableSaturday, 
        availableSunday, availableThursday, availableTuesday, availableWednesday} = this.state;
    return (
      <div className="createroom">
      <div className="createroom body">
        <div class="createroom sheet sheet-lg">
          <div class="createroom sheet-header">
            <h2 class="createroom sheet-title">{Liferay.Language.get('update-room')}</h2>
          </div>
          <div class="createroom sheet-section">
            <h3 class="createroom sheet-subtitle">{Liferay.Language.get('basic-info')}</h3>
          </div>
          <ClayForm.Group>
              <label htmlFor="basicInputText">{Liferay.Language.get('room-name')}</label>
              <ClayInput
                id="create-room name"
                name="name"
                value={this.state.name}
                onChange={this.handleChange}
                type="text"
              />
            </ClayForm.Group>
          <div class="createroom sheet-section">
            <div class="form-group-autofit">
            <div class="form-group-item">
              <label for="basicInputTypeText">{Liferay.Language.get('avail-day')}</label>
              <ClayButton.Group spaced={false} className="daypicker">

                <ClayButton displayType={availableSunday ? "primary" : "secondary"}
                  onClick={() => this.setState({availableSunday: !availableSunday})}
                >{Liferay.Language.get('sun')}</ClayButton>

                <ClayButton displayType={availableMonday ? "primary" : "secondary"}
                  onClick={() => this.setState({availableMonday: !availableMonday})}
                >{Liferay.Language.get('mon')}</ClayButton>
        
                <ClayButton displayType={availableTuesday ? "primary" : "secondary"}
                  onClick={() => this.setState({availableTuesday: !availableTuesday})}
                >{Liferay.Language.get('tues')}</ClayButton>
        
                <ClayButton displayType={availableWednesday ? "primary" : "secondary"}
                  onClick={() => this.setState({availableWednesday: !availableWednesday})}
                >{Liferay.Language.get('wed')}</ClayButton>
        
                <ClayButton displayType={availableThursday ? "primary" : "secondary"}
                  onClick={() => this.setState({availableThursday: !availableThursday})}
                >{Liferay.Language.get('thurs')}</ClayButton>
        
                <ClayButton displayType={availableFriday ? "primary" : "secondary"}
                  onClick={() => this.setState({availableFriday: !availableFriday})}
                >{Liferay.Language.get('fri')}</ClayButton>
        
                <ClayButton displayType={availableSaturday ? "primary" : "secondary"}
                  onClick={() => this.setState({availableSaturday: !availableSaturday})}
                >{Liferay.Language.get('sat')}</ClayButton>
              </ClayButton.Group>
            </div>
            <div class="form-group-item">
              <StartEndTime parentCallback={this.getTimes} start={this.state.availableStartTime} end={this.state.availableEndTime}/>
            </div>
            </div>
            <div class="createroom sheet-section">
              <div class="form-group-autofit">
                <div class="form-group-item">
                <label for="basicInputTypeText">{Liferay.Language.get('room-size')}</label>
                  <ClayInput
                    id="create-room size"
                    name="capacitySquareMeters"
                    value={this.state.capacitySquareMeters}
                    placeholder="0"
                    onChange={this.handleChangeInt}
                    type="text"
                  />
                </div>
                <div class="form-group-item">
                <label for="basicInputTypeText">{Liferay.Language.get('max-cap')}</label>
                  <ClayInput
                    id="create-room max"
                    name="capacityPeople"
                    value={this.state.capacityPeople}
                    placeholder="0"
                    onChange={this.handleChangeInt}
                    type="text"
                  />
                </div>
              </div>
              <div class="form-group-autofit">
                <div class="form-group-item">
                <label for="basicInputTypeText">{Liferay.Language.get('ext')}</label>
                  <ClayInput
                    id="basicInputText"
                    name="phoneExtension"
                    value={this.state.phoneExtension}
                    onChange={this.handleChangeInt}
                    placeholder="0"
                    type="int"
                  />
                </div>
              </div>
            </div>

            <div className="createroom sheet-section">
              <label for="basicInputTypeText">{Liferay.Language.get('facility')}</label>
              <FacilityList type="List" parentCallback={this.retrieveFacilities} selected={this.state.amenityIds}/>
            </div>

            <div className="createroom sheet-section">
              <label for="basicInputTypeText">{Liferay.Language.get('utilization')}</label>
              <PurposeSelector parentCallback={this.retrievePurposes} selected={this.state.purposeIds} />
            </div>

            <div className="createroom sheet-section">
              <h3 className="createroom sheet-subtitle">{Liferay.Language.get('wifi')}</h3>
              {/* <ClayToggle label="部屋の"/> */}
            </div>

            <div className="createroom sheet-section">
              <div className="createroom network">
                <label for="basicInputTypeText">{Liferay.Language.get('network')}</label>
                <ClayInput
                  id="create-room ssid"
                  type="text"
                  name="wifiSSID"
                  value={this.state.wifiSSID}
                  onChange={this.handleChange}
                />
              </div>
            </div>

            <div className="createroom sheet-section">
              <div className="createroom password">
                <label for="basicInputTypeText">{Liferay.Language.get('password')}</label>
                <ClayInput
                  id="createroom password"
                  type="text"
                  name="wifiPassword"
                  value={this.state.wifiPassword}
                  onChange={this.handleChange}
                />
              </div>
            </div>

            <div className="createroom sheet-section">
              <div className="createroom network">
                <label for="basicInputTypeText">{Liferay.Language.get('security')}</label>
                <CreateRoomSecuritySelect parentCallback={this.retrieveSecurity} selected={this.state.wifiSecurityType}/>
              </div>
            </div>

            <div className="createroom sheet-section">
              <div className="createroom endbutton">
                <ClayButton displayType="primary" onClick={this.updateRoom} className="createroom endbutton save">{Liferay.Language.get('save')}</ClayButton>
                <ClayButton onClick={this.cancelEdit} displayType="secondary" className="createroom endbutton cancel">{Liferay.Language.get('cancel')}</ClayButton>
              </div>
            </div>
          </div>
        </div>
      </div>
      </div>
    )
  }
}