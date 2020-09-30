# Liferay 7.1 Calendar Customization - Disable Overlapping Events
This plugin will provide an option for disabling overlapping events in Liferay's Calendar app.

## Requirement
* Liferay 7.1.10

## Usage
* Under Calendar Settings, a new checkbox should appear. When checked, that specific calendar would disable overlapping events.
* When overlapping events are disabled, the calendar will be unable to add or modify any event that conflicts with another existing event.

## Modules
The plugin contains three modules:
* ```calendar-booking-custom-service``` - Custom service wrapper (```CalendarBookingLocalService```) that injects code that checks for overlapping events whenever a CalendarBooking is updated.
* ```calendar-overlap-action``` - Contains a custom MVC action for disabling overlapping events and a helper class that is leveraged throughout this plugin. This module must be deployed for the others to work.
* ```calendar-overlap-jsp-fragment``` - Modified UI that adds a checkbox for disabling overlapping events.

## How to Deploy the module
Run ```blade deploy``` for all three modules will be deployed.
