import React from 'react';
import ReactDOM from 'react-dom';

import axios, { post } from 'axios';

import './style/room.css';

import ClayForm, {ClayInput, ClayToggle} from '@clayui/form';
import ClayButton from '@clayui/button';

import Room from './Room';
import CreateRoomSecuritySelect from './CreateRoomSecuritySelect';

import FacilityList from '../Facility/FacilityList';
import FacilityModal from '../Facility/FacilityModal';

import OfficeSelection from '../Office/OfficeSelection';
import OfficeModal from '../Office/OfficeModal';

import PurposeSelector from '../Purpose/PurposeSelector';

import StartEndTime from '../Clay/StartEndTime';

import PostToast from '../Clay/PostToast';

import { properties } from '../../properties.js';

const roomsEndpoint = properties.roomsEndpoint;
const officesEndpoint = properties.officesEndpoint;
const amenitiesEndpoint = properties.amenitiesEndpoint;
const documentsEndpoint = properties.documentsEndpoint;

export default class CreateRoom extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      roomName: '',
      capacitySquareMeters: 0,
      capacityPeople: 0,
      phoneExtension: 0,
      availableFriday :  false,
      availableMonday :  false,
      availableSaturday :  false,
      availableSunday :  false,
      availableThursday :  false,
      availableTuesday :  false,
      availableWednesday :  false,
      officeId: 1,
      availableEndTime: [],
      availableStartTime: [],
      wifiPassword: '',
      wifiSSID: '',
      wifiSecurityType: 0,
      amenityIds: [],
      purposeIds: [],
      facilities: [],
      offices: [],
      path: 'path',
      thumbnail: '',
      image: null,
    }
    this.cancelCreate = this.cancelCreate.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.handleChangeInt = this.handleChangeInt.bind(this); 
    this.clearStates = this.clearStates.bind(this);
  }  

  cancelCreate() {
    ReactDOM.render(<Room elementId={this.props.elementId} />, document.getElementById(this.props.elementId));
  }

  initializeOptions() {
    return {
      "method": "POST",
      "headers": {
        Pragma: 'no-cache',
        "cache-control": "no-cache",
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        amenityIds: this.state.amenityIds,
        availableEndTime: this.state.availableEndTime,
        availableMonday: this.state.availableMonday,
        availableTuesday: this.state.availableTuesday,
        availableWednesday: this.state.availableTuesday,
        availableThursday: this.state.availableThursday,
        availableFriday: this.state.availableFriday,
        availableSaturday: this.state.availableSaturday,
        availableSunday: this.state.availableSunday,
        availableStartTime: this.state.availableStartTime,
        capacityPeople: this.state.capacityPeople,
        capacitySquareMeters: this.state.capacitySquareMeters,
        name: this.state.roomName,
        officeId: this.state.officeId,
        phoneExtension: this.state.phoneExtension,
        photoPath: this.state.path,
        purposeIds: this.state.purposeIds,
        wifiPassword: this.state.wifiPassword,
        wifiSSID: this.state.wifiSSID,
        wifiSecurityType: this.state.wifiSecurityType
      })
    }
  }

  handleSubmit() {
    fetch(roomsEndpoint, this.initializeOptions())
    .then(async response => {
      const data = await response.json();
      if (!response.ok) {
          const error = (data && data.message) || response.status;
          alert(data.title)
          return Promise.reject(error);
      }
      if(response.ok) {
        if (this.state.image != null 
            && this.state.image !== []) {
          this.uploadPhoto(data);
        } else {
          console.log("no photo selected")
          this.clearStates();
          ReactDOM.render(<div>
            <Room elementId={this.props.elementId} />
            <PostToast alert={true} name={data.name} type={" room"} key={data.name} />
            </div>, document.getElementById(this.props.elementId));
        }
      }
    }).catch(error => {
      console.log(error)
    });
  }

  uploadPhoto(room) {
    const formData = new FormData();
    const document = JSON.stringify({
      title: room.roomId
    });
    formData.append('file', this.state.image)
    formData.append('document', document)
    const config = {
      headers: {
          'content-type': 'multipart/form-data',
      }
    }
    axios.post(documentsEndpoint, formData, config
    ).then(response =>{
      this.setState({
        path: properties.portalURL + response.data.contentUrl
      }, () => {
        room.photoPath = this.state.path;
        this.attachPhoto(room)
      });
    }).catch(err => {
      console.log(err);
    })
  }

  attachPhoto(room) {
    var roomsUrl = roomsEndpoint;
    roomsUrl = roomsUrl.split('?');
    roomsUrl = roomsUrl[0] + '/' + room.roomId + '?' + roomsUrl[1];
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
      body: JSON.stringify(room) 
    }).then( response => {
      if (response.ok) {
        this.clearStates();
        ReactDOM.render(<div>
          <Room elementId={this.props.elementId} />
          <PostToast alert={true} name={room.name} type={" room"} key={room.name} />
          </div>, document.getElementById(this.props.elementId));
      }
    }).catch(error => {
      console.log(error)
    });
  }

  handleChange(evt) {
    const value = evt.target.value;
    this.setState({
      [evt.target.name]: value
    });
  }

  handleChangeInt(evt) {
    const value = evt.target.value;
    if (!isNaN(value)) {
      this.setState({
        [evt.target.name]: value
      });
    }
  }

  retrieveOffice = (childData) => {
    this.setState({officeId: (childData)})
  }

  retrieveSecurity = (childData) => {
    this.setState({wifiSecurityType: Number(childData)})
  }

  retrieveFacilities = (childData) => {
    let r = [];
    this.state.amenityIds.concat(Number(childData)).forEach (item => {
      if (r.indexOf(item) == -1) {
        r.push(item);
      }
    });
    this.setState({amenityIds: r})
  }

  retrievePurposes = (childData) => {
    this.setState({purposeIds: (childData)})
  }
  
  getTimes = (start, end) => {
    this.setState({
      availableStartTime: start,
      availableEndTime: end
    });
  }

  setFacilities = () => {
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
        facilities: data.items
      });
      console.log("redons")
    });
  }

  setOffices = () => {
    fetch(officesEndpoint, {
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
        offices: data.items
      });
    });
  }

  clearStates() {
    this.setState({
      roomName: '',
      capacitySquareMeters: 0,
      capacityPeople: 0,
      phoneExtension: 0,
      availableFriday :  false,
      availableMonday :  false,
      availableSaturday :  false,
      availableSunday :  false,
      availableThursday :  false,
      availableTuesday :  false,
      availableWednesday :  false,
      officeId: 1,
      availableEndTime: [],
      availableStartTime: [],
      wifiPassword: '',
      wifiSSID: '',
      wifiSecurityType: 0,
      amenityIds: [],
      purposeIds: []
    })
  }

  getImage = () => {
    document.getElementById('fileButton').click();
  }

  getImageEx = (event) => {
    console.log(event.target.files[0])
    if(event.target.files[0] != null) {
      this.setState({
        thumbnail: URL.createObjectURL(event.target.files[0]),
        image: event.target.files[0],
      });
    } else {
      return;
    }
  }

  componentWillMount() {
    const requestOptions = {
      "async": true,
      "crossDomain": true,
      "method": "GET",
      "headers": {
        Pragma: 'no-cache',
        "cache-control": "no-cache",
      }
    }

    Promise.all([
      fetch(amenitiesEndpoint, requestOptions),
      fetch(officesEndpoint, requestOptions)
    ])
    .then(([amenitiesRes, officeRes]) => { 
      if (!amenitiesRes.ok || !officeRes.ok) throw new Error();
        else return Promise.all([amenitiesRes.json(), officeRes.json()]);
    })
    .then(([amenities, offices]) => {
      this.setState({ 
        facilities: amenities.items,
        offices: offices.items,
        officeId: offices.items[0].officeId
      })
    }).catch((err) => {
      console.log(err);
    });
  }

  render() {
    const spritemap = properties.icons;    
    const { availableFriday, availableMonday, availableSaturday, 
      availableSunday, availableThursday, availableTuesday, availableWednesday} = this.state;
      console.log(this.state.offices);

    return (
      <div className="createroom">
        <div className="createroom body">
          <div class="createroom sheet sheet-lg">

            <div class="createroom sheet-header">
              <h2 class="createroom sheet-title">{Liferay.Language.get('new-room')}</h2>
            </div>

            <div class="createroom sheet-section">
              <h3 class="createroom sheet-subtitle">{Liferay.Language.get('basic-info')}</h3>
            </div>

            <div classname="creatroom sheet-section">
              <h4 class="createroom">{Liferay.Language.get('room-picture')}</h4>
              <div class="createroom upload">
                <input id="fileButton" type="file" onChange={this.getImageEx} hidden />
                <ClayButton className='button' displayType="secondary" onClick={this.getImage}>{Liferay.Language.get('browse-files')}</ClayButton>
                <div className='thumbnail'>
                  <img src={this.state.thumbnail} />
                </div>
              </div>
            </div>

            <ClayForm.Group>
              <label htmlFor="basicInputText">{Liferay.Language.get('room-name')}</label>
              <ClayInput
                id="create-room name"
                name="roomName"
                value={this.state.roomName}
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
                  <StartEndTime parentCallback={this.getTimes}/>
                </div>
              </div>
            </div>

            <div class="createroom sheet-section">
              <OfficeSelection offices={this.state.offices} parentCallback={this.retrieveOffice}/>
              {<OfficeModal parentCallback={this.setOffices}/>}
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
              <FacilityList facilities={this.state.facilities} type="List" parentCallback={this.retrieveFacilities}/>
              {<FacilityModal type="modal" parentCallback={this.setFacilities}/>}
            </div>

            <div className="createroom sheet-section">
              <label for="basicInputTypeText">{Liferay.Language.get('utilization')}</label>
              <PurposeSelector parentCallback={this.retrievePurposes} />
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
                <CreateRoomSecuritySelect parentCallback={this.retrieveSecurity}/>
              </div>
            </div>

            <div className="createroom sheet-section">
              <div className="createroom endbutton">
                <ClayButton displayType="primary" onClick={this.handleSubmit} className="createroom endbutton save">{Liferay.Language.get('save')}</ClayButton>
                <ClayButton onClick={this.cancelCreate} displayType="secondary" className="createroom endbutton cancel">{Liferay.Language.get('cancel')}</ClayButton>
              </div>
            </div>
          </div>
      </div>
    </div>
    )
  }
}
  