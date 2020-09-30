import React from 'react';

import ClayForm, {ClayInput} from '@clayui/form';
import ClayButton from '@clayui/button';

import PostToast from '../Clay/PostToast';

import './style/purpose.css';

import { properties } from '../../properties.js';

const purposesEndpoint = properties.purposesEndpoint;

export default class Purpose extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      purpose: '',
      name: '',
      indicator: false,
      alert: false
    }
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.createPurpose = this.createPurpose.bind(this);
    this.clearStates = this.clearStates.bind(this);
    this.callSuccessful = this.callSuccessful.bind(this);
  }  

  handleChange(event) {
    this.setState({
      purpose: event.target.value,
      alert: false
    });
  }

  handleSubmit() {
    if(this.state.purpose !== '') {
      this.createPurpose();
      this.clearStates();
    } else if(this.state.purpose === '') {
      this.setState({
        indicator: true
      });
    }
  }

  callSuccessful(name) {
    this.setState({
        name: name,
        alert: true
    }, function () {
        console.log("purpose created");
    }); 
  }

  createPurpose() {
    const requestOptions = {
      "method": "POST",
      "headers": {
        Pragma: 'no-cache',
        "cache-control": "no-cache",
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        name: this.state.purpose
      })
    }
    fetch(purposesEndpoint, requestOptions)
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

  clearStates() {
    this.setState({
      purpose: '',
      name: '',
      indicator: false,
      alert: false
    })
  }
  
  render() {
    const spritemap = properties.icons;
    return (
      <div className="purpose">
        <div className="sheet sheet-lg">
          <div className="sheet-header">
            <h2 className="sheet-title">{Liferay.Language.get('new-purpose')}</h2>
          </div>
          <ClayForm.Group className={(this.state.indicator === true ? 'has-error' : '')}>
            <ClayForm.Group>
              <label htmlFor="basicInputText">{Liferay.Language.get('purpose')}</label>
              <ClayInput
                id="purpose input"
                placeholder={Liferay.Language.get('new-purpose')}
                type="text"
                className="purpose input"
                value={this.state.purpose}
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
              <div className="purpose buttongroup">
                <ClayButton displayType="primary" 
                  className="purpose buttongroup button"
                  onClick={this.handleSubmit}  
                >{Liferay.Language.get('save')}</ClayButton>
                <ClayButton displayType="secondary" 
                  className="purpose buttongroup button"
                  onClick={this.clearStates}
                  >{Liferay.Language.get('cancel')}</ClayButton>
              </div>
            </ClayForm.Group>
          </ClayForm.Group>
        </div>
        <PostToast alert={this.state.alert} name={this.state.name} type={" purpose"} key={this.state.name} />
      </div>
    )
  }
}
  