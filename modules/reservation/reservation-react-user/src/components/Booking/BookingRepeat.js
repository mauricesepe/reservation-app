import ClayModal, {useModal} from '@clayui/modal';
import {ClayCheckbox} from '@clayui/form';
import ClayButton from '@clayui/button';
import {ClaySelect} from '@clayui/form';

import React, {useState, useEffect} from 'react';
import './style/booking.css';
import { properties } from '../../properties';

const BookingRepeat = () => {
  const [visible, setVisible] = useState(false);
  const [checkValue, setCheck] = useState(false);
  const { observer, onClose } = useModal({
    onClose: () => setVisible(false)
  });
  const [custom, setCustom] = useState(0);

  const spritemap = properties.icons;

  const options = [
    {
      label: "毎日",
      value: "1"
    },
    {
      label: "平日だけ",
      value: "2"
    },
        {
      label: "毎週の水曜日",
      value: "3"
    },
    {
      label: "毎月に最後の水曜日",
      value: "4"
    },
    {
      label: "カスタム...",
      value: "5"
    }
  ];

  const selectRepeat = (
    <ClaySelect aria-label="Select Label" id="mySelectId">
      {options.map(item => (
      <ClaySelect.Option
        key={item.value}
        label={item.label}
        value={item.value}
      />
      ))}
    </ClaySelect>
  )

  return (
    <>
      {visible && (
        <ClayModal
          observer={observer}
          size="lg"
          spritemap={spritemap}
          status="info"
        >
          <ClayModal.Header>{"Customized Repeat Event"}</ClayModal.Header>
          <ClayModal.Body>
            <div className="sheet-section">
              <label htmlFor="basicInputText">Repeat every</label>

            </div>
          </ClayModal.Body>
          <ClayModal.Footer
          last={
            <div>
              <ClayButton displayType="primary" style={{marginRight: "10px"}}>{"セイブ"}</ClayButton>
              <ClayButton displayType="secondary" onClick={onClose}>{"キャンセル"}</ClayButton>
            </div>
          }
          />
        </ClayModal>
      )}
      <div className="repeat">
        <div className="row">
          <div className="col-4">
            <ClayCheckbox 
            checked={checkValue} 
            onChange={() => setCheck(val => !val)}
            label="Repeat Event"/>
          </div>
          <div className="col-8">
            {checkValue === true ? selectRepeat : ''}
          </div>
        </div>
      </div>
    </>
  );
};

export default BookingRepeat; 