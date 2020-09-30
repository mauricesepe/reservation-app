import ClayDatePicker from '@clayui/date-picker';
import React, {useState, useEffect, useRef} from 'react';
import {properties} from '../../properties.js';

import './style/custom.css';

import ClayTimePicker from '@clayui/time-picker';
import OfficeSelection from '../Office/OfficeSelection';

const StartEndTime = ({ parentCallback, start, end }) => {
  const [startValue, startSetValue] = useState({
    hours: (start == null) ? "--" : start.hours,
    minutes: (start == null) ? "--" : start.minutes,
    ampm: (start == null) ? "--" : start.ampm.toUpperCase()
  });
  const [endValue, endSetValue] = useState({
    hours: (end == null) ? "--" : end.hours,
    minutes: (end == null) ? "--" : end.minutes,
    ampm: (end == null) ? "--" : end.ampm.toUpperCase()
  });
  const spritemap = properties.icons;

  useEffect(() => {
    parentCallback(startValue, endValue)
  }, [startValue, endValue]);

  return (
    <div className="time">
      <div className="start">
        <label for="basicInputTypeText" className="title">{Liferay.Language.get('start-time')}</label>
        <ClayTimePicker
          spritemap={spritemap}
          onInputChange={startSetValue}
          values={{
            hours: startValue.hours.padStart(2,0),
            minutes: startValue.minutes.padStart(2,0),
            ampm: startValue.ampm
          }}
          use12Hours
          />    
      </div>
      
      <div className="end">
        <label for="basicInputTypeText" className="title">{Liferay.Language.get('end-time')}</label>
        <ClayTimePicker
          spritemap={spritemap}
          onInputChange={endSetValue}
          values={{
            hours: endValue.hours.padStart(2,0),
            minutes: endValue.minutes.padStart(2,0),
            ampm: endValue.ampm
          }}
          use12Hours
          />
      </div>
    </div>
  );
};

export default StartEndTime;