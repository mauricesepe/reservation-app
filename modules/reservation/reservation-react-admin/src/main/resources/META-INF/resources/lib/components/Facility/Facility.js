import React from 'react';

import ClayForm, {ClayInput} from '@clayui/form';
import ClayButton from '@clayui/button';
import PostToast from '../Clay/PostToast';

import './style/facility.css';

import { properties } from '../../properties.js';

const amenitiesEndpoint = properties.amenitiesEndpoint;

export default class Facility extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      facility: '',
      indicator: false,
      name: '',
      alert: false
    }
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.createFacility = this.createFacility.bind(this);
    this.clearStates = this.clearStates.bind(this);
    this.callSuccessful = this.callSuccessful.bind(this);
  }  

  clearStates() {
    this.setState({
      facility: '',
      indicator: false,
      name: '',
      alert: false
    })
  }

  handleChange(event) {
    this.setState({facility: event.target.value});
  }

  callSuccessful(name) {
    //code that alerts success
    this.setState({
      name: name,
      alert: true,
      facility: ''
    }, function () {
      console.log("facility created");
    });
  }

  createFacility() {
    const requestOptions = {
      "method": "POST",
      "headers": {
        Pragma: 'no-cache',
        "cache-control": "no-cache",
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        name: this.state.facility
      })
    }
    fetch(amenitiesEndpoint, requestOptions)
    .then(async response => {
      const data = await response.json();
      // check for error response
      if (!response.ok) {
          // get error message from body or default to response status
          const error = (data && data.message) || response.status;
          return Promise.reject(error);
      }
      if(response.ok) {
        this.callSuccessful(data.name);
      }
    })
    .catch(error => {
      this.setState({ errorMessage: error });
      console.error('There was an error!', error);
    });
  }

  handleSubmit() {
    if(this.state.facility !== '') {
      this.createFacility();
    } else if(this.state.facility === '') {
      this.setState({
        indicator: true
      });
    }
  }
  
  render() {
    const spritemap = properties.icons;
    var buttonRegular = null;

    if(this.props.type === "regular") {
      buttonRegular = (
        <div className="facility buttongroup">
          <ClayButton displayType="primary" 
            className="buttongroup button"
            onClick={this.handleSubmit}
          >{Liferay.Language.get('save')}</ClayButton>
          <ClayButton displayType="secondary"
            className="buttongroup button"
            onClick={this.clearStates}
          >{Liferay.Language.get('cancel')}</ClayButton>
        </div>
      )
    } else {
      buttonRegular = "";
    }

    return (
      <div className="facility">
        <div className="sheet sheet-lg">
          <div className="sheet-header">
            <h2 className="sheet-title">{Liferay.Language.get('new-facility')}</h2>
          </div>
          <ClayForm.Group className={(this.state.indicator === true ? 'has-error' : '')}>
            <ClayForm.Group>
              <label htmlFor="basicInputText">{Liferay.Language.get('facility')}</label>
              <ClayInput
                id="facility input"
                placeholder={Liferay.Language.get('new-facility')}
                type="text"
                className="facility input"
                value={this.state.facility}
                onChange={this.handleChange}
              />
              <ClayForm.FeedbackItem className={(this.state.indicator === false ? 'empty' : '')}>
                <ClayForm.FeedbackIndicator
                  spritemap={spritemap}
                  symbol="exclamation-full"
                />
                {Liferay.Language.get('warn-must-not-be-blank')}
              </ClayForm.FeedbackItem>
            </ClayForm.Group>
            <ClayForm.Group>
              {buttonRegular}
            </ClayForm.Group>
          </ClayForm.Group>
        </div>
        <PostToast alert={this.state.alert} name={this.state.name} type={" facility"} key={this.state.name} />
      </div>
    )
  }
}
  