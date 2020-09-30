import React from 'react';

import {ClaySelect} from '@clayui/form';

import { properties } from '../../properties.js';
import './style/office.css';

export default class OfficeSelection extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      offices: [],
      selected: ''
    }
    this.handleChange = this.handleChange.bind(this);
  }  
  
  componentDidMount(prevProps) {
    this.setState({ 
      offices: this.props.offices,
      isLoaded: true
    })
  }

  componentDidUpdate(prevProps) {
    // Typical usage (don't forget to compare props):
    if (this.props.offices !== prevProps.offices) {
      this.setState({ 
        offices: this.props.offices
      })
    }
  }

  handleChange(event) {
    this.setState({selected: event.target.value});
    this.props.parentCallback(event.target.value);
  }

  render() {
    return (
      <div className="office-select">
        <label for="basicInputTypeText">{Liferay.Language.get("offices")}</label>
        <ClaySelect aria-label="Office Select" value={this.state.selected} onChange={this.handleChange}>
        {this.state.offices.map((office) => 
          <ClaySelect.Option
            value={office.officeId}
            label={office.name}
          />
        )}
        </ClaySelect>
      </div>
    )
  }
}
  