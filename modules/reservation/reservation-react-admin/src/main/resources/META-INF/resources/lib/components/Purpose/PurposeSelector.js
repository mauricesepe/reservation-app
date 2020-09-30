import React from 'react';

import ClayMultiSelect from '@clayui/multi-select';

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

const purposesEndpoint = properties.purposesEndpoint;

export default class PurposeSelector extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      purposes: [],
      isLoaded: false,
      value: "",
      items: []
    }
    this.handleValueChange = this.handleValueChange.bind(this);
    this.handleItemsChange = this.handleItemsChange.bind(this);
  }
  
  componentDidMount() {
    fetch(purposesEndpoint, requestOptions)
    .then((res) => { 
      if (!res.ok) throw new Error();
        else return res.json();
    })
    .then((data) => {
      this.setState({ 
        purposes: data.items.map(items => ({
          label: items.name,
          value: items.purposeId
        })),
        isLoaded: true
      }, () => {
        if (this.props.selected != null) {
          var joined = [];
          this.props.selected.forEach(selected => {
            this.state.purposes.forEach(purpose => {
              if (selected == purpose.value) {
                joined = joined.concat(purpose)
                this.setState({
                  items: joined
                });
              }
            })
          })
        }
      })
    });
  }

  handleValueChange(e) {
    this.setState({
        value: e
    });
  }

  handleItemsChange(e) {
    if (e != null) {
      const result = this.state.purposes.filter(o1 => e.some(o2 => o1.value === o2.value));
      this.setState({
        items: result
      }, function () {
        const finalArray = this.state.items.map(function (obj) {
          return obj.value;
        });
        this.props.parentCallback(finalArray);
      })
    }
  }

  render() {
    const spritemap = properties.icons;    
    return (
      <div className="purposeSelector">
        <ClayMultiSelect
          spritemap = {spritemap}
          inputValue = {this.state.value}
          items = {this.state.items}
          onChange={this.handleValueChange}
          onItemsChange={this.handleItemsChange}
          sourceItems = {this.state.purposes}
        />
      </div>
    )
  }
}