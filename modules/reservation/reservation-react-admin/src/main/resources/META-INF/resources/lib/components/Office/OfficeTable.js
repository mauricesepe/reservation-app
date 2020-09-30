import React from 'react';
import ReactDOM from 'react-dom';

import ClayTable from '@clayui/table';
import {ClayPaginationBarWithBasicItems} from '@clayui/pagination-bar';

import OfficeEdit from './OfficeEdit';
import OfficeTableCell from './OfficeTableCell';

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

const officesEndpoint = properties.officesEndpoint;

export default class OfficeTable extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      activePage: 1,
      activeDelta: 10,
      totalItems: 0,
      offices: []
    }
    this.deleteEntry = this.deleteEntry.bind(this);
    this.editEntry = this.editEntry.bind(this);

  }  

  deleteEntry(name, id) {
    var officeUrl = officesEndpoint;
    officeUrl = officeUrl.split('?');
    officeUrl = officeUrl[0] + '/' + id + '?' + officeUrl[1];
    console.log(officeUrl)
    if(window.confirm(name + ": " + Liferay.Language.get('delete'))) {
      fetch(officeUrl, deleteOptions)
      .then(() => 
        this.fetchOffices(this.constructOfficesEndpoint()))
      .catch((err) => {
        console.log(err);
      });
    }
  }

  editEntry(id, name, location) {
    ReactDOM.render(<OfficeEdit 
      elementId={this.props.elementId}
      office={{
        id: id, 
        name: name, 
        location: location
      }}
    />, document.getElementById(this.props.elementId));
  }

  createTableRows() {
    var body = [];
    this.state.offices.map((office, i) => {
      body.push(
        <OfficeTableCell id={office.officeId} name={office.name} loc={office.location} deleteEntry={this.deleteEntry} editEntry={this.editEntry}/>
      )
    });
    return body;
  }

  fetchOffices(url) {
    fetch(url, requestOptions)
    .then((res) => { 
        if (!res.ok) throw new Error();
          else return res.json();
    })
    .then((data) => {
      this.setState({ 
        offices: data.items,
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
      var url = this.constructOfficesEndpoint()
      if (this.props.keywords != "") {
        url = url + "&search='" + this.props.keywords + "'";
      }
      this.fetchOffices(url);
    }
  }

  componentDidMount() {
    this.fetchOffices(this.constructOfficesEndpoint());
  }

  constructOfficesEndpoint() {
    return officesEndpoint + "&pageSize=" + this.state.activeDelta + "&page=" + this.state.activePage;
  }
  
  render() {
    const spritemap = properties.icons;
    
    return (
      <div className="room body table">
        <ClayTable>
            <ClayTable.Head>
              <ClayTable.Row>
                <ClayTable.Cell headingCell headingTitle>
                  {Liferay.Language.get('office-name')}
                </ClayTable.Cell>
                <ClayTable.Cell headingCell headingTitle>
                  {Liferay.Language.get('office-location')}
                </ClayTable.Cell>
                <ClayTable.Cell headingCell headingTitle>
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
  

            