import React from 'react';
import ReactDOM from 'react-dom';

import ClayForm, {ClayInput} from '@clayui/form';
import ClayButton from '@clayui/button';
import PostToast from '../Clay/PostToast';

import Office from './Office';

import isEqual from 'lodash/isEqual';

import { properties } from '../../properties.js';

const officesEndpoint = properties.officesEndpoint;

export default class OfficeEdit extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      id: this.props.office.id,
      name: this.props.office.name,
      location: this.props.office.location,
      nameIndicator: false,
      locIndicator: false
    }
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleCancel = this.handleCancel.bind(this);
  }

  handleChange(evt) {
    const value = evt.target.value;
    this.setState({
        [evt.target.name]: value,
    });
  }

  handleCancel() {
    ReactDOM.render(<Office elementId={this.props.elementId} />, document.getElementById(this.props.elementId))
  }

  handleSubmit() {
    var a = false;
    var b = false;
    if (this.state.name === '') {
      a = true;
    }
    if (this.state.location === '') {
      b = true;
    }
    this.setState({
      nameIndicator: a,
      locIndicator: b
    })

    if (!a && !b) {
      if (!isEqual(
        { id: this.state.id,
          name: this.state.name,
          location: this.state.location
        },this.props.office)) {
          var officesUrl = officesEndpoint;
          officesUrl = officesUrl.split('?');
          officesUrl = officesUrl[0] + '/' + this.state.id + '?' + officesUrl[1];
          fetch(officesUrl, {
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
              name: this.state.name,
              location: this.state.location
            })
          })    
          .then(async response => {
            const data = await response.json();
            if (!response.ok) {
              const error = (data && data.message) || response.status;
              return Promise.reject(error);
            }
            if(response.ok) {
              const name = this.state.name;
              ReactDOM.render(<div>
                <Office elementId={this.props.elementId} />
                <PostToast alert={true} name={name} type={"n edited office"} key={name} />
                </div>, document.getElementById(this.props.elementId));
            }
          })
          .catch(error => {
              this.setState({ errorMessage: error });
              console.error('There was an error!', error);
          });
        } else {
          alert("no changes detected...")
        }
    }
  }

  render() {
    const spritemap = properties.icons;
    return (
      <div className="office">
      <div className="body">
        <div className="sheet sheet-lg">
          <div className="sheet-header">
            <h2 className="sheet-title">{Liferay.Language.get('update-office')}</h2>
          </div>
          <ClayForm.Group>

            <ClayForm.Group className={((this.state.nameIndicator === true ? 'has-error' : ''))}>
            <label htmlFor="basicInputText">{Liferay.Language.get('office-name')}</label>
            <ClayInput
              id="office create name"
              placeholder={Liferay.Language.get('office-name')}
              type="text"
              className="office input"
              name="name"
              value={this.state.name}
              onChange={this.handleChange}
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
              name="location"
              className="office input"
              value={this.state.location}
              onChange={this.handleChange}
            />
            <ClayForm.FeedbackItem className={(this.state.locIndicator === false ? 'empty' : '')}>
              <ClayForm.FeedbackIndicator
                spritemap={spritemap}
                symbol="exclamation-full"
              />
              {Liferay.Language.get('warn-must-not-be-blank')}
            </ClayForm.FeedbackItem>
            </ClayForm.Group>
            <div className="office buttongroup">
              <ClayButton displayType="primary" 
                className="buttongroup button"
                onClick={this.handleSubmit}  
              >{Liferay.Language.get('save')}</ClayButton>
              <ClayButton displayType="secondary" 
                className="buttongroup button"
                onClick={this.handleCancel}
              >{Liferay.Language.get('cancel')}</ClayButton>
            </div>

          </ClayForm.Group>
        </div>
      </div>
    </div>);
  }
}