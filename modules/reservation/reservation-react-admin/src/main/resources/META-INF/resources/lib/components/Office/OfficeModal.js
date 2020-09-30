import React, {useState, useEffect} from 'react';

import ClayButton from '@clayui/button';
import ClayModal, {useModal} from '@clayui/modal';
import ClayForm, {ClayInput} from '@clayui/form';

import './style/office.css';

import { properties } from '../../properties.js';

const officesEndpoint = properties.officesEndpoint;

const OfficeModal = ({ parentCallback })  => {
  const [loaded, setLoaded] = useState(false);
  const [visible, setVisible] = useState(false);
  const { observer, onClose } = useModal({
    onClose: () => {
      setLoaded(false)
      setName('')
      setLocation('')
      setVisible(false)
    }
  });
  const spritemap = properties.icons;
  
  const [name, setName] = useState('');
  const [location, setLocation] = useState('');

  const post = () => {
    setLoaded(true);

    if (name == '' || location == '') {
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
        name: name,
        location: location
      })
    }
    fetch(officesEndpoint, requestOptions) 
    .then(async response => {
      const data = await response.json();
      
      // check for error response
      if (!response.ok) {
          // get error message from body or default to response status
          const error = (data && data.message) || response.status;
          return Promise.reject(error);
      }
      if(response.ok) {
        alert('Created Offices Successfully!');
        setName('');
        setLocation('')
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
          className="modal office"
        >
        <div className="office">
          <div className="body">
            <div className="sheet sheet-lg">
              <div className="sheet-header">
                <h2 className="sheet-title">{Liferay.Language.get('new-office')}</h2>
              </div>
                <ClayForm.Group className={(loaded == true && name == '' ? 'has-error' : '')}>
                  <label htmlFor="basicInputText">{Liferay.Language.get('office-name')}</label>
                  <ClayInput
                    id="office create name"
                    placeholder={Liferay.Language.get('office-name')}
                    type="text"
                    className="office input"
                    value={name}
                    onChange={e => setName(e.target.value)}
                  />
                  <ClayForm.FeedbackItem className={(loaded == true && name == '' ? '' : 'empty')}>
                    <ClayForm.FeedbackIndicator
                      spritemap={spritemap}
                      symbol="exclamation-full"
                    />
                    {Liferay.Language.get('warn-must-not-be-blank')}
                  </ClayForm.FeedbackItem>
                </ClayForm.Group>

                <ClayForm.Group className={(loaded == true && location == '' ? 'has-error' : '')}>
                  <label htmlFor="basicInputText">{Liferay.Language.get('office-location')}</label>
                  <ClayInput
                    id="office create location"
                    placeholder={Liferay.Language.get('office-location')}
                    type="text"
                    className="office input"
                    value={location}
                    onChange={e => setLocation(e.target.value)}
                  />
                  <ClayForm.FeedbackItem className={(loaded == true && location == '' ? '' : 'empty')}>
                    <ClayForm.FeedbackIndicator
                      spritemap={spritemap}
                      symbol="exclamation-full"
                    />
                    {Liferay.Language.get('warn-must-not-be-blank')}
                  </ClayForm.FeedbackItem>
                </ClayForm.Group>
                </div>
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
      <ClayButton displayType="secondary" onClick={() => setVisible(true)}>{Liferay.Language.get('new-office')}</ClayButton>
    </>
  );
};

export default OfficeModal;