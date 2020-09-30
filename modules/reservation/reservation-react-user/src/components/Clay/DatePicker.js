import ClayDatePicker from '@clayui/date-picker';
import ClayForm, {ClayInput} from '@clayui/form';
import React, {useState, useEffect} from 'react';
import {properties} from '../../properties.js';

const DatePicker = ({ parentCallback, date }) => {
  const [datepicked, setDatepicked] = useState((date !=null) ? date : '');
  const spritemap = properties.icons;
    
  useEffect(() => {
    parentCallback(datepicked);
  }, [datepicked]);
  
  return (
    <div>
      <label for="basicInputTypeText" className="title">{Liferay.Language.get("date")}</label>
      <ClayDatePicker inputName="date"
        onValueChange={setDatepicked}
        placeholder="YYYY-MM-DD"
        spritemap={spritemap}
        dateFormat={'YYYY-MM-DD'}
        value={datepicked}
      />
    </div>
  );
};

export default DatePicker;