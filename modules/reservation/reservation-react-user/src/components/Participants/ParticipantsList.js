import React, {useState, useEffect} from 'react';
import ReactDOM from 'react-dom';

import {properties} from '../../properties.js';
import './style/participants.css';

import ParticipantEntry from './ParticipantEntry';

const participantsEndpoint = properties.participantsEndpoint;

export default class ParticipantList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      selected: [],
      participants: null
    }
    this.renderParticipantStickers = this.renderParticipantStickers.bind(this);
  }  

  renderParticipantStickers() {
    var names = []

    this.state.participants.map((person) => {
      for(var i = 0; i < this.state.selected.length; i++) {
        if(person.participantId === this.state.selected[i]) {
          names.push(person.name)
        }
      }
    })
    return names;
  }

  componentDidMount() {    
    fetch(participantsEndpoint, {
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
      this.setState({ 
        participants: data.items,
        selected: this.props.participants
      })
    });
  }

  render() {
    const spritemap = properties.icons;    
    var stickers = [];
    const { selected, participants } = this.state;

    if(selected != null && participants != null) {
      participants.map((person) => {
        for(var i = 0; i < selected.length; i++) {
          if(person.participantId === selected[i]) {
            stickers.push(
              <ParticipantEntry checkboxes={this.props.checkboxes} id={person.participantId} name={person.fullName} />
            )
          }
        }
      })
    } else if(selected === null) {
      stickers.push('')
    }

    return (
      <div className="participant-list">
        {stickers}
      </div>
    )
  }
}

