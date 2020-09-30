import React, {useState, useEffect} from 'react';

import ClayButton from '@clayui/button';
import ClayModal, {useModal} from '@clayui/modal';
import ClayForm, {ClayInput} from '@clayui/form';

import './style/facility.css';

import { properties } from '../../properties.js';

const amenitiesEndpoint = properties.amenitiesEndpoint;

const FacilityModal = ({ parentCallback }) => {
  const [loaded, setLoaded] = useState(false);
  const [visible, setVisible] = useState(false);
  const { observer, onClose } = useModal({
    onClose: () => {
      setLoaded(false)
      setFacility('')
      setVisible(false)
    }
  });
  const [facility, setFacility] = useState('');
  const spritemap = properties.icons;

  const post = () => {
    setLoaded(true);

    if (facility == '') {
      return;
    }

    const requestOptions = {
      "method": "POST",
      "headers": {
        Pragma: 'no-cache',
        "cache-control": "no-cache",
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        name: facility
      })
    }

    fetch(amenitiesEndpoint, requestOptions)
    .then(async response => {
      const data = await response.json();
      // check for error response
      if (!response.ok) {
          // get error message from body or default to response status
          const error = (data && data.message) || response.status;
          return Promise.reject(error);
      }
      if(response.ok) {
        alert('Created Amenity Successfully!');
        setFacility('');
      }
    })
    .catch(error => {
      this.setState({ errorMessage: error });
      console.error('There was an error!', error);
    });
  }

  useEffect(() => {
    parentCallback();
  }, [visible]);

  return (
    <>
      {visible && (
        <ClayModal
          observer={observer}
          size="lg"
          spritemap={spritemap}
          status="info"
        >
          <div className="facility">
            <div className="sheet-lg">
              <div className="sheet-header">
                <h2 className="sheet-title">{Liferay.Language.get('new-facility')}</h2>
              </div>
              <ClayForm.Group className={(loaded == true && facility == '' ? 'has-error' : '')}>
                <label htmlFor="basicInputText">{Liferay.Language.get('facility')}</label>
                <ClayInput
                  id="facility input"
                  placeholder={Liferay.Language.get('new-facility')}
                  type="text"
                  className="facility input"
                  value={facility}
                  onChange={e => setFacility(e.target.value)}
                />
                <ClayForm.FeedbackItem className={(loaded == true && facility == '' ? '' : 'empty')}>
                  <ClayForm.FeedbackIndicator
                    spritemap={spritemap}
                    symbol="exclamation-full"
                  />
                  {Liferay.Language.get('warn-must-not-be-blank')}
                </ClayForm.FeedbackItem>
              </ClayForm.Group>
          </div>
          <ClayModal.Footer
            first={
              <ClayButton.Group spaced>
                <ClayButton displayType="primary" onClick={post}>{Liferay.Language.get('save')}</ClayButton>
                <ClayButton displayType="secondary" onClick={onClose}>{Liferay.Language.get('cancel')}</ClayButton>
              </ClayButton.Group>
            }
          />
        </div>
        </ClayModal>
      )}
      <ClayButton displayType="secondary" onClick={() => setVisible(true)}>{Liferay.Language.get('new-facility')}</ClayButton>
    </>
  );
};

export default FacilityModal;