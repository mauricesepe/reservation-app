import React from 'react';
import ReactDOM from 'react-dom';

import './style/office.css';

import ClayForm, {ClayInput} from '@clayui/form';
import ClayButton from '@clayui/button';

import Office from './Office';
import PostToast from '../Clay/PostToast';

import { properties } from '../../properties.js';

const officesEndpoint = properties.officesEndpoint;

export default class OfficeCreate extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      location: '',
      nameIndicator: false,
      locIndicator: false
    }
    this.cancelCreate = this.cancelCreate.bind(this);
    this.handleNameChange = this.handleNameChange.bind(this);
    this.handleLocChange = this.handleLocChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.createOffice = this.createOffice.bind(this);
    this.clearOfficeStates = this.clearOfficeStates.bind(this);
  } 

  clearOfficeStates() {
    this.setState({
      name: '',
      location: '',
      nameIndicator: false,
      locIndicator: false
    });
  }

  cancelCreate() {
    ReactDOM.render(<Office type="regular" elementId={this.props.elementId} />, document.getElementById(this.props.elementId));
  }

  handleNameChange(event) {
    this.setState({name: event.target.value});
  }

  handleLocChange(event) {
    this.setState({location: event.target.value});
  }

  createOffice() {
    fetch(officesEndpoint, {
      "method": "POST",
      "headers": {
        Pragma: 'no-cache',
        "cache-control": "no-cache",
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        name: this.state.name,
        location: this.state.location
      })
    })    
    .then(async response => {
      const data = await response.json();
      
      // check for error response
      if (!response.ok) {
          // get error message from body or default to response status
          const error = (data && data.message) || response.status;
          return Promise.reject(error);
      }
      if(response.ok) {
        this.clearOfficeStates();
        ReactDOM.render(<div>
          <Office elementId={this.props.elementId} />
          <PostToast alert={true} name={data.name} type={"n office"} key={data.name} />
          </div>, document.getElementById(this.props.elementId));
      }
    })
    .catch(error => {
        this.setState({ errorMessage: error });
        console.error('There was an error!', error);
    });
  }

  handleSubmit() {
    if(this.state.name !== '' && this.state.location !== '') {
      this.createOffice();
    } else if (this.state.name === '' || this.state.location === '') {
      if(this.state.name === '' && this.state.location === '') {
        this.setState({
          nameIndicator: true,
          locIndicator: true
        })
      } else if(this.state.name === ''  && this.state.location !== '') {
        this.setState({
          nameIndicator: true,
          locIndicator: false
        })
      } else if(this.state.location === ''  && this.state.name !== '') {
        this.setState({
          locIndicator: true,
          nameIndicator: false
        })
      }
    }
  }

  render() {
    var buttonRegular = null;
    const spritemap = properties.icons;

    if(this.props.type === "regular") {
      buttonRegular = (
        <div className="office buttongroup">
          <ClayButton displayType="primary" 
            className="buttongroup button"
            onClick={this.handleSubmit}  
          >{Liferay.Language.get('save')}</ClayButton>
          <ClayButton displayType="secondary" 
            className="buttongroup button"
            onClick={this.cancelCreate}
          >
            {Liferay.Language.get('cancel')}
          </ClayButton>
        </div>
      )
    } else {
      buttonRegular = "";
    }

    return (
      <div className="office">
        <div className="body">
          <div className="sheet sheet-lg">
            <div className="sheet-header">
              <h2 className="sheet-title">{Liferay.Language.get('new-office')}</h2>
            </div>
            <ClayForm.Group>

              <ClayForm.Group className={((this.state.nameIndicator === true ? 'has-error' : ''))}>
              <label htmlFor="basicInputText">{Liferay.Language.get('office-name')}</label>
              <ClayInput
                id="office create name"
                placeholder={Liferay.Language.get('office-name')}
                type="text"
                className="office input"
                value={this.state.name}
                onChange={this.handleNameChange}
              />
              <ClayForm.FeedbackItem className={(this.state.nameIndicator === false ? 'empty' : '')}>
                <ClayForm.FeedbackIndicator
                  spritemap={spritemap}
                  symbol="exclamation-full"
                />
                {Liferay.Language.get('warn-must-not-be-blank')}
              </ClayForm.FeedbackItem >
              </ClayForm.Group>

              <ClayForm.Group className={((this.state.locIndicator === true) ? 'has-error' : '')}>
              <label htmlFor="basicInputText">{Liferay.Language.get('office-location')}</label>
              <ClayInput
                id="office create location"
                placeholder={Liferay.Language.get('office-location')}
                type="text"
                className="office input"
                value={this.state.location}
                onChange={this.handleLocChange}
              />
              <ClayForm.FeedbackItem className={(this.state.locIndicator === false ? 'empty' : '')}>
                <ClayForm.FeedbackIndicator
                  spritemap={spritemap}
                  symbol="exclamation-full"
                />
                {Liferay.Language.get('warn-must-not-be-blank')}
              </ClayForm.FeedbackItem>
              </ClayForm.Group>

              {buttonRegular}

            </ClayForm.Group>
          </div>
        </div>
      </div>
    )
  }
}
  