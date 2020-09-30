package com.liferay.calendar.service.wrapper;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalService;
import com.liferay.calendar.service.CalendarBookingLocalServiceWrapper;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.calendar.web.custom.util.CalendarExpandoHelper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jp.co.liferay.reservation.model.PersistedRoom;
import jp.co.liferay.reservation.service.PersistedRoomLocalService;

/**
 * @author gabriel
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class CustomCalendarBookingLocalServiceImpl extends CalendarBookingLocalServiceWrapper {

	public CustomCalendarBookingLocalServiceImpl() {
		super(null);
	}

	@Override
	public CalendarBooking addCalendarBooking(long userId, long calendarId, long[] childCalendarIds,
			long parentCalendarBookingId, long recurringCalendarBookingId, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, String location, long startTime, long endTime,
			boolean allDay, String recurrence, long firstReminder, String firstReminderType,
			long secondReminder, String secondReminderType, ServiceContext serviceContext)
		throws PortalException {

		checkOverlappingBookings(calendarId, startTime, endTime);

		return super.addCalendarBooking(userId, calendarId, childCalendarIds, parentCalendarBookingId,
			recurringCalendarBookingId, titleMap, descriptionMap, location, startTime, endTime,
			allDay, recurrence, firstReminder, firstReminderType, secondReminder, secondReminderType,
			serviceContext);
	}

	@Override
	public CalendarBooking updateCalendarBooking(long userId, long calendarBookingId, long calendarId,
			long[] childCalendarIds, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, String location, long startTime,
			long endTime, boolean allDay, String recurrence, long firstReminder,
			String firstReminderType, long secondReminder,
			String secondReminderType, ServiceContext serviceContext)
		throws PortalException {

		checkOverlappingBookings(calendarId, startTime, endTime);

		return super.updateCalendarBooking(userId, calendarBookingId, calendarId, childCalendarIds,
			titleMap, descriptionMap, location, startTime, endTime, allDay, recurrence,
			firstReminder, firstReminderType, secondReminder, secondReminderType, serviceContext);
	}

	public void updateLastInstanceCalendarBookingRecurrence(
		CalendarBooking calendarBooking, String recurrence) {

		try {
			checkOverlappingBookings(calendarBooking.getCalendarId(),
				calendarBooking.getStartTime(), calendarBooking.getEndTime());
		} catch (PortalException e) {
			_log.error("No overlapping events allowed", e);
			return;
		}

		super.updateLastInstanceCalendarBookingRecurrence(calendarBooking, recurrence);
	}

	private void checkOverlappingBookings(long calendarId, long startTime, long endTime)
		throws PortalException {

		Calendar calendar = CalendarLocalServiceUtil.getCalendar(calendarId);

        List<PersistedRoom> rooms = _persistedRoomLocalService.findByCalendarId(calendarId);
		if (!CalendarExpandoHelper.isOverlapDisabled(
			calendar.getCompanyId(), calendarId) && rooms.isEmpty()) {
			return;
		}

		if (hasExclusiveCalendarBooking(calendar, startTime, endTime)) {
			throw new PortalException("calendar-booking-overlap");
		}
	}

	@Reference(unbind = "-")
	private void serviceSetter(CalendarBookingLocalService calendarBookingLocalService) {
		setWrappedService(calendarBookingLocalService);
    }
    
    @Reference
    private PersistedRoomLocalService _persistedRoomLocalService;

	private static Log _log = LogFactoryUtil.getLog(CustomCalendarBookingLocalServiceImpl.class);

}