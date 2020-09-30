import React, {useState} from 'react';
import './style/booking.css';
import { properties } from '../../properties';
import ClayCard, {ClayCardWithNavigation} from '@clayui/card';

import BookingRoomInformation from './BookingRoomInformation';

import ReactDOM from 'react-dom';

const officesEndpoint = properties.officesEndpoint;
  
export default class BookingRenderCards extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      cards: 21,
      rooms: [],
      offices: [],
      crumb: [{
        label: Liferay.Language.get('search')
      }]
    }
    this.getOfficeName = this.getOfficeName.bind(this);
    this.createCards = this.createCards.bind(this);
    this.createCardRows = this.createCardRows.bind(this);
  }  

  createCards() {
    const cards = [];
    if(this.state.rooms !== null) {
      this.state.rooms.map((room) => {
        var office = this.getOfficeName(room.officeId);
        console.log(room.photoPath);
        cards.push(
          <div className="col-md-4">
          <ClayCardWithNavigation
            title={room.name}
            description={office}
            onClick={() => this.goToBookingScreen(office, room)}
          >
            <img style={{width:"100%"}} src={room.photoPath === 'path' ? '/o/reservation-react-user/media/default-room.jpeg' : room.photoPath}/>
          </ClayCardWithNavigation>
          </div>
        )}
      )
      return cards;
    }
  }

  createCardRows(cards) {
    const rows = [];
    const created = [];

    while(cards.length > 0) {
      rows.push(cards.splice(0, 3));
    }
    
    for(var i = 0; i < rows.length; i++) {
      created.push(
        <div className="booking filtered row">
          {rows[i]}
        </div>
      );
    }
    return created;
  }

  getOfficeName(id) {
    if(this.state.offices !== []) {
      for(var i = 0; i < this.state.offices.length; i++) {
        if(id === this.state.offices[i].officeId) 
          return this.state.offices[i].name;
      }
    }
  }

  goToBookingScreen(office, data) {
    var crumbs = this.state.crumb.concat({"label": data.name})
    ReactDOM.render(<BookingRoomInformation 
      breadcrumb={crumbs}
      elementId={this.props.elementId} 
      office={office} 
      data={data} />, document.getElementById(this.props.elementId))
  }

  componentWillReceiveProps() {
    fetch(officesEndpoint, {
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
        offices: data.items,
        rooms: this.props.data
      })
    });
  }

  render() {
    const spritemap = properties.icons;
    return (
      <div className="booking cards">
        {this.createCardRows(this.createCards())}
      </div>
  )};
}