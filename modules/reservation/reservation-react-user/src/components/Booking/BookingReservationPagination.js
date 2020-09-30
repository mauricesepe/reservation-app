import {ClayPaginationWithBasicItems} from '@clayui/pagination';
import React, {useState} from 'react';

import './style/booking.css';
import { properties } from '../../properties';

const BookingReservationPagination = () => {
  const [active, setActive] = useState(1);
  const spritemap = properties.icons;

  return (
    <ClayPaginationWithBasicItems
      activePage={active}
      ellipsisBuffer={2}
      onPageChange={setActive}
      spritemap={spritemap}
      totalPages={10}
    />
  );
};
export default BookingReservationPagination;