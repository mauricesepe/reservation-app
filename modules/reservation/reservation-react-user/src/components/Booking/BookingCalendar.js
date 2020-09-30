import React, {useState} from 'react';
import './style/booking.css';
import { properties } from '../../properties';

const BookingCalendar = () => {
  const spritemap = properties.icons;
  return (
    <div className="calendar">
      <div className="sheet-section">
        <div className="actual">
        </div>
      </div>
      
      <div className="sheet-section">
      </div>
    </div>
  );
};

export default BookingCalendar;
