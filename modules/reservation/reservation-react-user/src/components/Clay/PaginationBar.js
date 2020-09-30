import ClayPaginationBar from '@clayui/pagination-bar';
import ClayPagination, {ClayPaginationWithBasicItems} from '@clayui/pagination';
import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';

import React, {useState} from 'react';
import {properties} from '../../properties.js';
import './style/custom.css';

const PaginationBar = () => {
  const spritemap = properties.icons;
  const [active, setActive] = useState(1);

  return (
    <div className="d-flex justify-content-between">
      <ClayPaginationBar>
        <ClayPaginationBar.DropDown
          items={[
            {
              label: "10",
              onClick: () => {}
            }
          ]}
          trigger={
            <ClayButton displayType="unstyled">
              {"10 items per page"}

              <ClayIcon spritemap={spritemap} symbol="caret-double-l" />
            </ClayButton>
          }
        />

        <ClayPaginationBar.Results>
          {"Showing 10 of 100 items"}
        </ClayPaginationBar.Results>
        <div className="d-flex justify-content-end">
          <ClayPaginationWithBasicItems
          activePage={active}
          ellipsisBuffer={2}
          onPageChange={setActive}
          spritemap={spritemap}
          totalPages={10}
          />
        </div>
      </ClayPaginationBar>
    </div>
  );
};

export default PaginationBar; 