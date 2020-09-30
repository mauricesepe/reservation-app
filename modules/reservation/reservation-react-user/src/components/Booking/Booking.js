import React, {useState, useEffect} from 'react';
import ReactDOM from 'react-dom';

import ClayTabs from '@clayui/tabs';

import BookingSearch from './BookingSearch';
import BookingReservations from './BookingReservations';

import './style/booking.css';
import { properties } from '../../properties';
  
const Booking = (props) => {
  const [activeTabKeyValue, setActiveTabKeyValue] = useState(0);
  const [reload, setReload] = useState(false);

  const bookingContent = ( 
    <div className="booking content">
      <ClayTabs.Content activeIndex={activeTabKeyValue} fade>
        <ClayTabs.TabPane aria-labelledby="tab-1" className="booking content contents">
          {<BookingReservations breadcrumb={[{"label": Liferay.Language.get("home")}]} elementId={props.elementId} />}
        </ClayTabs.TabPane>
        <ClayTabs.TabPane aria-labelledby="tab-2"  className="booking content contents">
        {<BookingSearch key={reload === true ? 1 : 2} parentCallback={setReload} reloadState={reload} elementId={props.elementId}/>}
        </ClayTabs.TabPane>
      </ClayTabs.Content>
    </div>
  );

  useEffect(() => {
    ReactDOM.render(bookingContent, document.getElementById(props.elementId || 'root'));
  });

  return (
    <div className="booking">
      <ClayTabs modern className="booking tabs">
        <ClayTabs.Item className="booking item"
          active={activeTabKeyValue == 0}
          innerProps={{
            "aria-controls": "tabpanel-1"
          }}
          onClick={() => setActiveTabKeyValue(0)}
        >
          {Liferay.Language.get("home")}
        </ClayTabs.Item>
        <ClayTabs.Item className="booking item"
          active={activeTabKeyValue == 1}
          innerProps={{
            "aria-controls": "tabpanel-2"
          }}
          onClick={() => setActiveTabKeyValue(1)}
        >
          {Liferay.Language.get("room-search")}
        </ClayTabs.Item>
      </ClayTabs>
    </div>
    // <BookingCreate />
  );
};

export default Booking;
