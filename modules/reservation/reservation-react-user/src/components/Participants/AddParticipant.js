import React, {useState, useEffect} from 'react';

import ClayAutocomplete from '@clayui/autocomplete';
import ClayDropDown, {ClayDropDownWithItems} from '@clayui/drop-down';
import ClayButton, {ClayButtonWithIcon} from '@clayui/button';
import ClayForm, {ClayInput} from '@clayui/form';

import {useResource} from '@clayui/data-provider';

import PostToast from '../Clay/PostToast';

import { properties } from '../../properties.js';
import './style/participants.css';

const participantsEndpoint = properties.participantsEndpoint;

const AddParticipant = ({ parentCallback }) => {
  const spritemap = properties.icons;
  const [networkStatus, setNetworkStatus] = useState(4);
  const [popup, setPopup] = useState(false);
  const [name, setName] = useState("");
  const [value, setValue] = useState("");
  const [active, setActive] = useState();
  const [selected, setSelected] = useState([]);
  const { resource } = useResource({
    fetchPolicy: "cache-first",
    link: participantsEndpoint,
    onNetworkStatusChange: setNetworkStatus,
    variables: { search: value },
    fetchOptions : {
      "async": true,
      "crossDomain": true,
      "method": "GET",
      "headers": {
        Pragma: 'no-cache',
        "cache-control": "no-cache",
      }
    }
  });

  function addSelected(v) {
    let r = [];
    selected.concat(v).forEach (item => {
      if (r.indexOf(item) == -1) {
        r.push(item); 
      }
    });
    setSelected(r)
  }

  let companyName = React.createRef();
  let visitorName = React.createRef();
  let emailAddress = React.createRef();

  function postParticipant() {
    setPopup(false);
    const requestOptions = {
      "method": "POST",
      "headers": {
        Pragma: 'no-cache',
        "cache-control": "no-cache",
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        companyName: companyName.current.value,
        fullName: visitorName.current.value,
        emailAddress: emailAddress.current.value,
        userId: 0
      })
    }
    fetch(participantsEndpoint, requestOptions)
    .then(async response => {
      const data = await response.json();
      if (!response.ok) { 
        const error = (data && data.message) || response.status;
        return Promise.reject(error);
      }
      if(response.ok) {
        addSelected(data)
        setName(data.fullName)
        setPopup(true);
      }
    }).catch(error => {
      console.error('There was an error!', error);
    });
  }

  const initialLoading = networkStatus === 1;
  const loading = networkStatus < 4;
  const error = networkStatus === 5;

  useEffect(() => {
    parentCallback(selected);
  }, [selected]);
  
  return (
    <div className="addparticipant" style={{display: 'flex'}}>
      <div>
        <ClayAutocomplete>
          <ClayAutocomplete.Input
            placeholder={Liferay.Language.get('search')}
            value={value}
            onChange={event => setValue(event.target.value)}
          />
        <ClayAutocomplete.DropDown
          active={(!!resource && !!value) || initialLoading}
        >
        <ClayDropDown.ItemList >
          {(error || (resource != null && 0 == resource.items.length)) && (
            <ClayDropDown.Item className="disabled">
              {"No Results Found"}
            </ClayDropDown.Item>
          )}
          {!error &&
            resource &&
            resource.items &&
            resource.items.map(item => (
              <ClayAutocomplete.Item
                key={item.participantId}
                match={value}
                value={item.emailAddress}
                onClick={() => {
                  setValue("");
                  addSelected(item);
                  }}
              />
            ))}
        </ClayDropDown.ItemList>
        </ClayAutocomplete.DropDown>
        {loading && <ClayAutocomplete.LoadingIndicator />}
        </ClayAutocomplete>
      </div>
      
      <div>
        <ClayDropDown
          trigger={<ClayButtonWithIcon style={{marginLeft: "10px"}} 
          displayType="secondary" 
          spritemap={spritemap} 
          symbol="plus"
          />}
          active={active}
          onActiveChange={setActive}
        >
        <ClayDropDown.ItemList>
          <ClayDropDown.Group>
            <ClayDropDown.ItemList>
              <ClayDropDown.Item>
                <ClayInput
                id="visitor-company"
                placeholder={Liferay.Language.get('visitor-co')}
                type="text"
                ref={companyName}
                />
              </ClayDropDown.Item>
              <ClayDropDown.Item>
                <ClayInput
                id="visitor-name"
                placeholder={Liferay.Language.get('visitor-name')}
                type="text"
                ref={visitorName}
                />
              </ClayDropDown.Item>
              <ClayDropDown.Item>
                <ClayInput
                id="visitor-email"
                placeholder={Liferay.Language.get('visitor-mail')}
                type="text"
                ref={emailAddress}
                />
              </ClayDropDown.Item>
            </ClayDropDown.ItemList>
          </ClayDropDown.Group>
        </ClayDropDown.ItemList>
        <ClayDropDown.Group>
        <ClayDropDown.ItemList>
          <ClayDropDown.Item>
            <div className="dropbuttons">
              <ClayButton displayType="primary" onClick={() => {postParticipant(); setActive(false)}}>{Liferay.Language.get('save')}</ClayButton>
              <ClayButton displayType="secondary" onClick={() => setActive(false)}>{Liferay.Language.get('cancel')}</ClayButton>
            </div>
          </ClayDropDown.Item>
        </ClayDropDown.ItemList>
        </ClayDropDown.Group>
        </ClayDropDown>
        {(popup) && (
          <PostToast alert={true} name={name} type={" participant"}/>
        )}
      </div>
    </div>
  )};

export default AddParticipant;
