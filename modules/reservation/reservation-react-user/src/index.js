
import React from 'react';
import ReactDOM from 'react-dom';

import AppComponent from './AppComponent';
import Booking from './components/Booking/Booking';

import "core-js/stable";
import "regenerator-runtime/runtime";

/**
 * This is the main entry point of the portlet.
 *
 * See https://tinyurl.com/js-ext-portlet-entry-point for the most recent 
 * information on the signature of this function.
 *
 * @param  {Object} params a hash with values of interest to the portlet
 * @return {void}
 */
export default function main({portletNamespace, contextPath, portletElementId}) {
    
  const header_id = portletElementId + "-header";
  const content_id = portletElementId + "-content";

  ReactDOM.render(
  <div>
    <div id={header_id}>
      <Booking elementId={content_id} />
    </div>
    <div id={content_id}>
    </div>
  </div>
  , document.getElementById(portletElementId));
}