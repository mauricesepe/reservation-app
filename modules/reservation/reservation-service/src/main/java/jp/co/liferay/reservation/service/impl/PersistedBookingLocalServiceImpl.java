/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package jp.co.liferay.reservation.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalService;
import com.liferay.calendar.service.CalendarLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jp.co.liferay.reservation.model.PersistedBooking;
import jp.co.liferay.reservation.model.PersistedRoom;
import jp.co.liferay.reservation.service.base.PersistedBookingLocalServiceBaseImpl;
import jp.co.liferay.reservation.service.util.PersistedBookingValidator;

/**
 * The implementation of the persisted booking local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>jp.co.liferay.reservation.service.PersistedBookingLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedBookingLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=jp.co.liferay.reservation.model.PersistedBooking",
	service = AopService.class
)
public class PersistedBookingLocalServiceImpl
	extends PersistedBookingLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>jp.co.liferay.reservation.service.PersistedBookingLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>jp.co.liferay.reservation.service.PersistedBookingLocalServiceUtil</code>.
	 */

    public List<PersistedBooking> findAll() {
		return persistedBookingPersistence.findAll();
    }
    
    public List<PersistedBooking> findByUserId(long userId) {
        return persistedBookingPersistence.findByUserId(userId);
    }

    public List<PersistedBooking> findByRoomId(long roomId) {
        return persistedBookingPersistence.findByRoomId(roomId);
    }

    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
    @Override
    public PersistedBooking addPersistedBooking(String title, Date startDt, Date endDt, long roomId, String description, 
            long[] participantIds, ServiceContext serviceContext) throws PortalException {

        long bookingId = counterLocalService.increment(PersistedBooking.class.getName());

        PersistedBooking entry = createPersistedBooking(bookingId);
        entry.setTitle(title);
        entry.setStartDate(startDt);
        entry.setEndDate(endDt);
        entry.setRoomId(roomId);
        entry.setDescription(description);

		_validate(entry);

        entry = _addPersistedBooking(entry, serviceContext);
        if (participantIds != null && participantIds.length > 0) {
            persistedBookingPersistence.addPersistedParticipants(entry.getBookingId(), participantIds);
        }
		return entry;
	}

    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
    @Override
    public PersistedBooking updatePersistedBooking(long bookingId, String title, Date startDt, Date endDt, long roomId, String description,
            long[] participantIds, ServiceContext serviceContext) throws PortalException {

        PersistedBooking entry = getPersistedBooking(bookingId);
        entry.setTitle(title);
        entry.setStartDate(startDt);
        entry.setEndDate(endDt);
        entry.setRoomId(roomId);
        entry.setDescription(description);

		_validate(entry);

        _updatePersistedBooking(entry, serviceContext);
        if (participantIds != null && participantIds.length > 0) {
            persistedBookingPersistence.clearPersistedParticipants(entry.getBookingId());
            persistedBookingPersistence.addPersistedParticipants(entry.getBookingId(), participantIds);
        }
		return entry;
    }

    @Indexable(type = IndexableType.DELETE)
    @Override
    public PersistedBooking deletePersistedBooking(long bookingId) throws PortalException {

        PersistedBooking entry = getPersistedBooking(bookingId);
        long calendarBookingId = entry.getCalendarBookingId();
        try {
            _calendarBookingLocalService.deleteCalendarBooking(calendarBookingId);
        } catch (PortalException e) {}
        
        persistedBookingPersistence.clearPersistedParticipants(bookingId);
        return super.deletePersistedBooking(bookingId);
    }
    
    protected void _validate(PersistedBooking booking) throws PortalException {
        ModelValidator<PersistedBooking> validator = new PersistedBookingValidator();
        validator.validate(booking);

        _checkRoomAvailability(booking);
    }

    protected void _checkRoomAvailability(PersistedBooking booking) throws PortalException {

        PersistedRoom room = persistedRoomPersistence.findByPrimaryKey(booking.getRoomId());

        Map<Integer, Boolean> availabilityMap  = new HashMap<Integer, Boolean>() {{
            put(Calendar.SUNDAY, room.getAvailableSunday());
            put(Calendar.MONDAY, room.getAvailableMonday());
            put(Calendar.TUESDAY, room.getAvailableTuesday());
            put(Calendar.WEDNESDAY, room.getAvailableWednesday());
            put(Calendar.THURSDAY, room.getAvailableThursday());
            put(Calendar.FRIDAY, room.getAvailableFriday());
            put(Calendar.SATURDAY, room.getAvailableSaturday());
        }};

        {
            TimeZone tz = TimeZoneUtil.getDefault();
            Calendar cal = CalendarFactoryUtil.getCalendar(tz);
            cal.setTime(booking.getStartDate());
            
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (!availabilityMap.get(dayOfWeek)) {
                throw new PortalException("room-unavailable-at-specified-start-date");
            }
            int hours = cal.get(Calendar.HOUR_OF_DAY);
            int minutes = cal.get(Calendar.MINUTE);
            int start = (hours * 60) + minutes;
            if (start < room.getAvailableStartTime()) {
                throw new PortalException("room-unavailable-at-specified-start-time");
            }
        }

        {
            TimeZone tz = TimeZoneUtil.getDefault();
            Calendar cal = CalendarFactoryUtil.getCalendar(tz);
            cal.setTime(booking.getEndDate());
            
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            if (!availabilityMap.get(dayOfWeek)) {
                throw new PortalException("room-unavailable-at-specified-end-date");
            }
            int hours = cal.get(Calendar.HOUR_OF_DAY);
            int minutes = cal.get(Calendar.MINUTE);
            int end = (hours * 60) + minutes;
            if (end > room.getAvailableEndTime()) {
                throw new PortalException("room-unavailable-at-specified-end-time");
            }
        }
    }

	protected PersistedBooking _addPersistedBooking(PersistedBooking booking, ServiceContext serviceContext) throws PortalException {

        long companyId = serviceContext.getCompanyId();
        long userId = serviceContext.getUserId();
        User user = userLocalService.getUser(userId);
        booking.setCompanyId(companyId);
        booking.setUserId(userId);
        booking.setUserName(user.getFullName());

        Date now = new Date();
        booking.setCreateDate(now);
        booking.setModifiedDate(now);

        CalendarBooking calendarBooking = _setCalendarBooking(booking, serviceContext);
        booking.setCalendarBookingId(calendarBooking.getCalendarBookingId());

		return super.addPersistedBooking(booking);
	}

	protected PersistedBooking _updatePersistedBooking(PersistedBooking booking, ServiceContext serviceContext) throws PortalException {

        long companyId = serviceContext.getCompanyId();
        long userId = serviceContext.getUserId();
        User user = userLocalService.getUser(userId);
        booking.setCompanyId(companyId);
        booking.setUserId(userId);
        booking.setUserName(user.getFullName());

        Date now = new Date();
        booking.setModifiedDate(now);

        CalendarBooking calendarBooking = _setCalendarBooking(booking, serviceContext);
        booking.setCalendarBookingId(calendarBooking.getCalendarBookingId());
   
        return super.updatePersistedBooking(booking);
    }

    protected CalendarBooking _setCalendarBooking(PersistedBooking booking, ServiceContext serviceContext) throws PortalException {
        
        Map<Locale, String> titleMap = new HashMap<>();
		titleMap.put(serviceContext.getLocale(), booking.getTitle());
		Map<Locale, String> descriptionMap = new HashMap<>();
        descriptionMap.put(serviceContext.getLocale(), booking.getDescription());
        
        PersistedRoom room = persistedRoomPersistence.findByPrimaryKey(booking.getRoomId());
        String location = room.getName();
        long calendarId = room.getCalendarId();

        long calendarBookingId = booking.getCalendarBookingId();
		long userId = booking.getUserId();

        long startTime = booking.getStartDate().getTime();
        long endTime = booking.getEndDate().getTime();
        
        CalendarBooking calendarBooking;
        if (calendarBookingId == 0) {
            User user = userLocalService.getUser(userId);
			com.liferay.calendar.model.Calendar userCalendar = _calendarLocalService.fetchGroupCalendar(
                    user.getCompanyId(), user.getGroupId(), user.getFullName());
                    
            long[] calendarList = (userCalendar != null) ? new long[]{userCalendar.getCalendarId()} : new long[]{};

            calendarBooking = _calendarBookingLocalService.addCalendarBooking(
					userId, calendarId, calendarList,
					0, 0, titleMap,
					descriptionMap, location, startTime, endTime, false,
					null, 0, null,
					0, null, serviceContext);
        } else {
            calendarBooking =_calendarBookingLocalService.updateCalendarBooking(
					userId, calendarBookingId, calendarId, titleMap,
					descriptionMap, location, startTime, endTime,
					false, null, 0, null,
					0, null, serviceContext);
        }
        return calendarBooking;
    }

    @Reference
    CalendarLocalService _calendarLocalService;

    @Reference
    CalendarBookingLocalService _calendarBookingLocalService;
}