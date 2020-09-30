import ClayDatePicker from '@clayui/date-picker';
import ClayForm, {ClayInput} from '@clayui/form';
import React, {useState, useEffect} from 'react';
import {properties} from '../../properties.js';

const DatePicker = ({ parentCallback }) => {
  const [datepicked, setDatepicked] = useState('');
  const spritemap = properties.icons;
    
  useEffect(() => {
    parentCallback(datepicked);
  }, [datepicked]);
  
  return (
    <div>
      <ClayDatePicker inputName="date"
        onValueChange={setDatepicked}
        placeholder="YYYY-MM-DD"
        spritemap={spritemap}
        dateFormat={'YYYY-MM-DD'}
        value={datepicked}
        years={{
          end: 2024,
          start: 1997
        }}
      />
    </div>
  );
};

export default DatePicker;