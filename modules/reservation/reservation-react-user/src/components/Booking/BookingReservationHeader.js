import React, {useState} from 'react';
import ReactDOM from 'react-dom';
import debounce from 'lodash.debounce';

import './style/booking.css';
import { properties } from '../../properties';

import {ClayCheckbox, ClayInput} from '@clayui/form';
import ClayIcon, {ClayIconSpriteContext} from '@clayui/icon';
import ClayUpperToolbar from '@clayui/upper-toolbar';
import {ClaySelect} from '@clayui/form';

import BookingCreate from './BookingCreate';

export default class BookingReservationHeader extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      keywords: ""
    }
    this.callCreateBooking = this.callCreateBooking.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.onChangeDebounced = debounce(this.onChangeDebounced, properties.queryTimeout)
  }

  callCreateBooking() {
    ReactDOM.render(<BookingCreate elementId={this.props.elementId} />, document.getElementById(this.props.elementId));
  }

  handleChange(e) {
    this.setState({
      keywords: e.target.value
    });
    this.onChangeDebounced(e);
  }

  onChangeDebounced(e) {
    this.props.callback(this.state.keywords)
  }

  render() {
    const spritemap = properties.icons;
    const options = [
      {
        label: Liferay.Language.get("filter"),
        value: "1"
      },
      {
        label: Liferay.Language.get("sort"),
        value: "2"
      }
    ];
  return (
    <ClayUpperToolbar className="header" >
      <ClayUpperToolbar.Item>
        <ClayCheckbox aria-label="bookingHeader" checked={false} readOnly />
      </ClayUpperToolbar.Item>
      <ClayUpperToolbar.Item>
        <ClaySelect aria-label="Select Label" id="mySelectId" className="select"> 
          {options.map(item => (
            <ClaySelect.Option
              key={item.value}
              label={item.label}
              value={item.value}
            />
          ))}
        </ClaySelect>
      </ClayUpperToolbar.Item>

      <ClayUpperToolbar.Item className="margin">
        <ClayIcon spritemap={spritemap} symbol="import-export" />
      </ClayUpperToolbar.Item>
      <ClayUpperToolbar.Input onChange={this.handleChange} placeholder={Liferay.Language.get("search-placeholder")} />
      
      <ClayUpperToolbar.Item className="margin">
        <ClayIcon spritemap={spritemap} symbol="info-circle-open" />
      </ClayUpperToolbar.Item>
      <ClayUpperToolbar.Item className="margin">
        <ClayIcon spritemap={spritemap} symbol="list" />
      </ClayUpperToolbar.Item>
    </ClayUpperToolbar> 
    )
  }
}