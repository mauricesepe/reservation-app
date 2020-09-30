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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import com.liferay.calendar.model.Calendar;
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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jp.co.liferay.reservation.model.PersistedOffice;
import jp.co.liferay.reservation.model.PersistedRoom;
import jp.co.liferay.reservation.service.base.PersistedRoomLocalServiceBaseImpl;
import jp.co.liferay.reservation.service.util.PersistedRoomValidator;

/**
 * The implementation of the persisted room local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>jp.co.liferay.reservation.service.PersistedRoomLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedRoomLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=jp.co.liferay.reservation.model.PersistedRoom",
	service = AopService.class
)
public class PersistedRoomLocalServiceImpl
	extends PersistedRoomLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>jp.co.liferay.reservation.service.PersistedRoomLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>jp.co.liferay.reservation.service.PersistedRoomLocalServiceUtil</code>.
	 */

    public List<PersistedRoom> findAll() {
        return persistedRoomPersistence.findAll();
    }

    public List<PersistedRoom> findByOfficeId(long officeId) {
        return persistedRoomPersistence.findByOfficeId(officeId);
    }

    public List<PersistedRoom> findByCalendarId(long calendarId) {
        return persistedRoomPersistence.findByCalendarId(calendarId);
    }

    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
    @Override
    public PersistedRoom addPersistedRoom(String name, String photoPath, boolean availableSunday, boolean availableMonday, boolean availableTuesday,
            boolean availableWednesday, boolean availableThursday, boolean availableFriday, boolean availableSaturday, int availableStartTime, 
            int availableEndTime, long officeId, double capacitySquareMeters, int capacityPeople, int phoneExtension, String wifiSSID,
            int wifiSecurityType, String wifiPassword, long[] amenitiesIds, long[] purposeIds, ServiceContext serviceContext) throws PortalException {
        
        long roomId = counterLocalService.increment(PersistedRoom.class.getName());

        PersistedRoom entry = createPersistedRoom(roomId);
        entry.setName(name);
        entry.setPhotoPath(photoPath);
        entry.setAvailableSunday(availableSunday);
        entry.setAvailableMonday(availableMonday);
        entry.setAvailableTuesday(availableTuesday);
        entry.setAvailableWednesday(availableWednesday);
        entry.setAvailableThursday(availableThursday);
        entry.setAvailableFriday(availableFriday);
        entry.setAvailableSaturday(availableSaturday);
        entry.setAvailableStartTime(availableStartTime);
        entry.setAvailableEndTime(availableEndTime);
        entry.setOfficeId(officeId);
        entry.setCapacitySquareMeters(capacitySquareMeters);
        entry.setCapacityPeople(capacityPeople);
        entry.setPhoneExtension(phoneExtension);
        entry.setWifiSSID(wifiSSID);
        entry.setWifiSecurityType(wifiSecurityType);
        entry.setWifiPassword(wifiPassword);

        _validate(entry);
        
        entry = _addPersistedRoom(entry, serviceContext);
        if (amenitiesIds != null && amenitiesIds.length > 0){
            persistedRoomPersistence.addPersistedAmenities(entry.getRoomId(), amenitiesIds);
        }
        if (purposeIds != null && purposeIds.length > 0) {
            persistedRoomPersistence.addPersistedPurposes(entry.getRoomId(), purposeIds);
        }
		return entry;
	}

    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
    @Override
    public PersistedRoom updatePersistedRoom(long roomId, String name, String photoPath, boolean availableSunday, boolean availableMonday, 
            boolean availableTuesday, boolean availableWednesday, boolean availableThursday, boolean availableFriday, boolean availableSaturday,
            int availableStartTime, int availableEndTime, long officeId, double capacitySquareMeters, int capacityPeople, int phoneExtension, String wifiSSID,
            int wifiSecurityType, String wifiPassword, long[] amenitiesIds, long[] purposeIds, ServiceContext serviceContext) throws PortalException {
        
        PersistedRoom entry = getPersistedRoom(roomId);
        entry.setName(name);
        entry.setPhotoPath(photoPath);
        entry.setAvailableSunday(availableSunday);
        entry.setAvailableMonday(availableMonday);
        entry.setAvailableTuesday(availableTuesday);
        entry.setAvailableWednesday(availableWednesday);
        entry.setAvailableThursday(availableThursday);
        entry.setAvailableFriday(availableFriday);
        entry.setAvailableSaturday(availableSaturday);
        entry.setAvailableStartTime(availableStartTime);
        entry.setAvailableEndTime(availableEndTime);
        entry.setOfficeId(officeId);
        entry.setCapacitySquareMeters(capacitySquareMeters);
        entry.setCapacityPeople(capacityPeople);
        entry.setPhoneExtension(phoneExtension);
        entry.setWifiSSID(wifiSSID);
        entry.setWifiSecurityType(wifiSecurityType);
        entry.setWifiPassword(wifiPassword);

        _validate(entry);

        entry = _updatePersistedRoom(entry, serviceContext);

        if (amenitiesIds != null && amenitiesIds.length >= 0){
            persistedRoomPersistence.clearPersistedAmenities(entry.getRoomId());
            persistedRoomPersistence.addPersistedAmenities(entry.getRoomId(), amenitiesIds);
        }
        if (purposeIds != null && purposeIds.length >= 0) {
            persistedRoomPersistence.clearPersistedPurposes(entry.getRoomId());
            persistedRoomPersistence.addPersistedPurposes(entry.getRoomId(), purposeIds);
        }
		return entry;
    }

    @Indexable(type = IndexableType.DELETE)
    @Override
    public PersistedRoom deletePersistedRoom(long roomId) throws PortalException {
        PersistedRoom entry = getPersistedRoom(roomId);
        long calendarId = entry.getCalendarId();
        _calendarLocalService.deleteCalendar(calendarId);
        
        persistedRoomPersistence.clearPersistedAmenities(roomId);
        persistedRoomPersistence.clearPersistedPurposes(roomId);
        return super.deletePersistedRoom(roomId);
    }
    
    protected void _validate(PersistedRoom room) throws PortalException {
        
        ModelValidator<PersistedRoom> validator = new PersistedRoomValidator();
        validator.validate(room);

        /* Check if office exists, will throw Exception if not found */
        persistedOfficePersistence.findByPrimaryKey(room.getOfficeId());
    }

	protected PersistedRoom _addPersistedRoom(PersistedRoom room, ServiceContext serviceContext) throws PortalException {

        long companyId = serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();
        User user = userLocalService.getUser(userId);
        room.setCompanyId(companyId);
        room.setUserId(userId);
        room.setUserName(user.getFullName());

		Date now = new Date();
		room.setCreateDate(now);
        room.setModifiedDate(now);
        
        Calendar calendar = _setCalendar(room, serviceContext);
        room.setCalendarId(calendar.getCalendarId());

		return super.addPersistedRoom(room);
	}

	protected PersistedRoom _updatePersistedRoom(PersistedRoom room, ServiceContext serviceContext) throws PortalException {

        long companyId = serviceContext.getCompanyId();
		long userId = serviceContext.getUserId();
        User user = userLocalService.getUser(userId);
        room.setCompanyId(companyId);
        room.setUserId(userId);
        room.setUserName(user.getFullName());

        Date now = new Date();
        room.setModifiedDate(now);

        Calendar calendar = _setCalendar(room, serviceContext);
        room.setCalendarId(calendar.getCalendarId());
        
		return super.updatePersistedRoom(room);
    }

    protected Calendar _setCalendar(PersistedRoom room, ServiceContext serviceContext) throws PortalException {
        
        long calendarId = room.getCalendarId();
		long userId = room.getUserId();
        long groupId = userLocalService.getUserById(userId).getGroupId();

        PersistedOffice office = persistedOfficePersistence.findByPrimaryKey(room.getOfficeId());
        long calendarResourceId = office.getCalendarResourceId();

        TimeZone timeZone = TimeZoneUtil.getDefault();
        String timeZoneId = timeZone.getID();

		Map<Locale, String> nameMap = new HashMap<>();
        nameMap.put(LocaleUtil.getDefault(), room.getName());
        
        Calendar calendar;
        if (calendarId == 0) {
			calendar = _calendarLocalService.addCalendar(
					userId, groupId, calendarResourceId, nameMap,  null,
					timeZoneId, 0, false, false,
					false, serviceContext);
		} else {
			calendar = _calendarLocalService.updateCalendar(
					calendarId, nameMap, null, 0,
					serviceContext);
        }
		return calendar;
    }

    @Reference
    CalendarLocalService _calendarLocalService;
}