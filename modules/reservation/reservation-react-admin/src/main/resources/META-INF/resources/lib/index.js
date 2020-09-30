import React from 'react';
import ReactDOM from 'react-dom';

import Admin from './components/Admin/Admin'

import "core-js/stable";
import "regenerator-runtime/runtime";

/**
 * This is the main entry point of the portlet.
**/
export default function(elementId) {

  const header_id = elementId + "-header";
  const content_id = elementId + "-content";

  ReactDOM.render(
  <div>
    <div id={header_id}>
      <Admin elementId={content_id} />
    </div>
    <div id ={content_id}>
    </div>
  </div>
  , document.getElementById(elementId));
}