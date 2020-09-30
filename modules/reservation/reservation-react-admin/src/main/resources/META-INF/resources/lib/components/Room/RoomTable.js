import React from 'react';
import ReactDOM from 'react-dom';

import './style/room.css';

import ClayUpperToolbar from '@clayui/upper-toolbar';
import ClayTable from '@clayui/table';
import ClayButton, { ClayButtonWithIcon } from '@clayui/button';

import {ClayPaginationBarWithBasicItems} from '@clayui/pagination-bar';

import EditRoom from './EditRoom.js'

import { properties } from '../../properties.js';

const requestOptions = {
  "async": true,
  "crossDomain": true,
  "method": "GET",
  "headers": {
    Pragma: 'no-cache',
    "cache-control": "no-cache",
  }
}

const deleteOptions = {
  "async": true,
  "crossDomain": true,
  "method": "DELETE",
  "headers": {
    Pragma: 'no-cache',
    "cache-control": "no-cache",
  }
}

const roomsEndpoint = properties.roomsEndpoint;
const spritemap = properties.icons;

export default class RoomTable extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      activePage: 1,
      activeDelta: 10,
      totalItems: 0,
      rooms: []
    }
    this.deleteEntry = this.deleteEntry.bind(this);
  }  

  deleteEntry(name, id) {
    var roomsUrl = roomsEndpoint;
    roomsUrl = roomsUrl.split('?');
    roomsUrl = roomsUrl[0] + '/' + id + '?' + roomsUrl[1];
    
    if(window.confirm(name + ": " + Liferay.Language.get('delete'))) {
      fetch(roomsUrl, deleteOptions)
      .then(() => 
        this.fetchRooms(this.constructRoomsEndpoint()))
      .catch((err) => {
        console.log(err);
      });
    }
  }

  editEntry(entry) {
    ReactDOM.render(<EditRoom elementId={this.props.elementId} room={entry} />, document.getElementById(this.props.elementId));
  }

  createTableRows() {
    var body = [];
    body = this.state.rooms.map((entry, i) => {
      return (
        <ClayTable.Row>
          <ClayTable.Cell align={'left'}>{entry.name}</ClayTable.Cell>
          <ClayTable.Cell align={'left'}>{entry.officeName}</ClayTable.Cell>
          <ClayTable.Cell align={'left'}>{entry.capacityPeople}</ClayTable.Cell>
          <ClayTable.Cell align={'right'}>
            <ClayButtonWithIcon 
                symbol="pencil" 
                spritemap={properties.icons} 
                displayType={'unstyled'} 
                style={{padding: '0', margin: '0', height: '1rem'}}
                onClick={() => this.editEntry(entry)}/>
            <ClayButtonWithIcon 
              symbol="trash" 
              spritemap={properties.icons} 
              displayType={'unstyled'} 
              style={{padding: '0', margin: '0', height: '1rem'}}
              onClick={() => this.deleteEntry(entry.name, entry.roomId)}/>
          </ClayTable.Cell>
        </ClayTable.Row>
      )
    });
    return body;
  }

  fetchRooms(url) {
    fetch(url, requestOptions)
    .then((res) => { 
      if (!res.ok) throw new Error();
        else return res.json();
    })
    .then((data) => {
      this.setState({ 
        rooms: data.items,
        activePage: (data.lastPage >= data.page) ? data.page : data.lastPage,
        totalItems: data.totalCount
      })
    });
  }

  componentDidUpdate(prevProps, prevState) {
    if (prevProps != this.props
        || prevState.activePage != this.state.activePage
        || prevState.activeDelta != this.state.activeDelta
        || prevState.totalItems != this.state.totalItems) {
      var url = this.constructRoomsEndpoint()
      if (this.props.keywords != "") {
        url = url + "&search='" + this.props.keywords + "'";
      } 
      this.fetchRooms(url);
    }
  }

  componentDidMount() {
    this.fetchRooms(this.constructRoomsEndpoint());
  }

  constructRoomsEndpoint() {
    return roomsEndpoint + "&pageSize=" + this.state.activeDelta + "&page=" + this.state.activePage;
  }
  
  render() {
    return (
      <div className="room body table">
        <ClayTable>
            <ClayTable.Head>
              <ClayTable.Row>
                <ClayTable.Cell headingCell headingTitle>
                  {Liferay.Language.get('room-name')}
                </ClayTable.Cell>
                <ClayTable.Cell headingCell headingTitle>
                  {Liferay.Language.get('offices')}
                </ClayTable.Cell>
                <ClayTable.Cell headingCell headingTitle>
                  {Liferay.Language.get('max-cap')}
                </ClayTable.Cell>
                <ClayTable.Cell headingCell headingTitle align={'right'}>
                  {""}
                </ClayTable.Cell>
              </ClayTable.Row>
            </ClayTable.Head>
            <ClayTable.Body>
              {this.createTableRows()}
            </ClayTable.Body>
          </ClayTable>
          <ClayPaginationBarWithBasicItems
            activePage={this.state.activePage}
            activeDelta={this.state.activeDelta}
            totalItems={this.state.totalItems}
            onPageChange={(page) => this.setState({activePage: page})}
            onDeltaChange={(delta) => this.setState({activeDelta: delta})}
            spritemap={spritemap}
          />
      </div>
    )
  }
}
  

            