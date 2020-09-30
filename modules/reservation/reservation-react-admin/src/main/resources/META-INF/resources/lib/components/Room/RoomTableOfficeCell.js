import React, {useState, useEffect} from 'react';

import ClayTable from '@clayui/table';

import { properties } from '../../properties.js';

const roomsEndpoint = properties.roomsEndpoint;

const RoomTableOfficeCell = ( props ) => {
  const [value, setValue] = useState("one");

  useEffect(() => {
    fetch(roomsEndpoint, {
      "async": true,
      "crossDomain": true,
      "method": "GET",
      "headers": {
        Pragma: 'no-cache',
        "cache-control": "no-cache",
      }
    })
    .then((res) => { 
      if (!res.ok) throw new Error();
        else return res.json();
    })
    .then((data) => {
      console.log(data)
    });
  });

  return (
    <ClayTable.Cell align={'left'}>{value}</ClayTable.Cell>
  );
};

export default RoomTableOfficeCell;