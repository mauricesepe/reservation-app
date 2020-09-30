import React, {useState, useEffect} from 'react';
import ClayIcon from '@clayui/icon'; 
import ClayButton, { ClayButtonWithIcon } from '@clayui/button';

import ClayTable from '@clayui/table';
import { properties } from '../../properties.js';

const OfficeTableCell = (props) => {
  return (
    <ClayTable.Row>
      <ClayTable.Cell align={'left'}>{props.name}</ClayTable.Cell>
      <ClayTable.Cell align={'left'}>{props.loc}</ClayTable.Cell>
      <ClayTable.Cell align={'right'}>
        <ClayButtonWithIcon 
          symbol="pencil" 
          spritemap={properties.icons} 
          displayType={'unstyled'} 
          style={{padding: '0', margin: '0', height: '1rem'}}
          onClick={() => props.editEntry(props.id, props.name, props.loc)}/>
        <ClayButtonWithIcon 
          symbol="trash" 
          spritemap={properties.icons} 
          displayType={'unstyled'} 
          style={{padding: '0', margin: '0', height: '1rem'}}
          onClick={() => props.deleteEntry(props.name, props.id)}/>
      </ClayTable.Cell>
    </ClayTable.Row>
  );
};

export default OfficeTableCell;
