import React, {useState, useEffect} from 'react';

import {properties} from '../../properties.js';
import './style/participants.css';

import ClayTable from '@clayui/table';
import {ClayCheckbox} from '@clayui/form';
import ClaySticker from '@clayui/sticker';

const ParticipantEntry = (props) => {
  const spritemap = properties.icons;
  const [value, setValue] = useState(false);

  return (
    <div className="autofit-row">
      <div className="autofit-col">
        <ClaySticker className="sticker-user-icon" size="xl">
          <div className="sticker-overlay">
            <img className="sticker-img" src='/o/reservation-react-user/media/default-user.jpeg' />
          </div>
        </ClaySticker>
      </div>

      <div className="autofit-col autofit-col-expand name">
        <div className="sticker-name">
          {props.name}
        </div>
      </div>

      <div className="autofit-col check">
        <div className={props.checkboxes === true ? "participant-check" : "participant-check false"}
          style={props.checkboxes === false ? {display: "none"} : {display: "block"}}>
          <ClayCheckbox 
            id={"participantcheck-" + props.id}
            checked={value}
            onChange={() => setValue(val => !val)}
          />
        </div>
      </div>
    </div>
  );
};

export default ParticipantEntry;
