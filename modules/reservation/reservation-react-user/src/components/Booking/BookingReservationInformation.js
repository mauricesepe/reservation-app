import React, {useState, useEffect} from 'react';
import ReactDOM from 'react-dom';
import './style/booking.css';
import { properties } from '../../properties';

import ClayIcon from '@clayui/icon';
import ClayButton from '@clayui/button';

import AdaptiveBreadcrumb from '../Clay/AdaptiveBreadcrumb';

import ParticipantList from '../Participants/ParticipantsList';
  
const BookingReservationInformation = (props) => {
  const spritemap = properties.icons;
  return (
    <div className="booking-reservation">
        <div className="breadcrumb-sect">
          <div className="crumbs">
            <AdaptiveBreadcrumb breadcrumb={props.breadcrumb}/>
          </div>
        </div>

        <div className="contents">
          <div className="general">
            <div className="general-contents">
              <div className="sheet">

                <img src={props.room.photoPath} 
                  className="fillout-contents img" 
                />

                <div className="sheet-header">
                  <h2 className="sheet-title"> {props.booking.title} </h2>
                </div>

                <div className="sheet-section detail" style={{marginBottom: '1rem'}}>
                  {props.booking.date}
                </div>

                <div className="sheet-section detail" style={{marginBottom: '2rem'}}>
                  <ClayIcon symbol="geolocation" spritemap={spritemap} /> {props.room.name} - {props.room.officeName}
                </div>

                <div className="sheet-section description">
                  {props.booking.description}
                </div>
              </div>
            </div>
          </div>

          <div className="participants">
            <div className="participants-contents">
              <h1>{Liferay.Language.get('participant')}</h1>
              <div className="sheet">
                <div className="sheet-section">
                  <ClayButton displayType="unstyled" className="participants" style={{padding: '10px'}}>{Liferay.Language.get('employee')}</ClayButton>
                </div>                
                <ParticipantList participants={props.booking.participantIds}/>
              </div>

              {/* <div className="sheet">
                <div className="sheet-section">
                  <ClayButton displayType="unstyled" className="participants">会社</ClayButton>
                </div>                
                <ParticipantList checkboxes={true}/>
              </div> */}
            </div>
          </div>
        </div>
      </div>
  );
};

export default BookingReservationInformation;
