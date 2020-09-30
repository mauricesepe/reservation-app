import ClayBreadcrumb from '@clayui/breadcrumb';
import React from 'react';

import './style/booking.css';
import { properties } from '../../properties';

const BookingBreadcrumb = () => {
  const spritemap = properties.icons;
  return (
    <ClayBreadcrumb
      ellipsisBuffer={1}
      items={[
        {
          href: "#1",
          label: "Find A Room"
        },
        {
          active: true,
          href: "#2",
          label: "Conference Room A"
        }
      ]}
      spritemap={spritemap}
    />
  );
};

export default BookingBreadcrumb;