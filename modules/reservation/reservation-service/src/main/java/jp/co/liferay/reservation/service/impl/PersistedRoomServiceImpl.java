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

import java.util.List;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

import jp.co.liferay.reservation.model.PersistedRoom;
import jp.co.liferay.reservation.service.base.PersistedRoomServiceBaseImpl;

/**
 * The implementation of the persisted room remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>jp.co.liferay.reservation.service.PersistedRoomService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedRoomServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=reservation",
		"json.web.service.context.path=PersistedRoom"
	},
	service = AopService.class
)
public class PersistedRoomServiceImpl extends PersistedRoomServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>jp.co.liferay.reservation.service.PersistedRoomServiceUtil</code> to access the persisted room remote service.
	 */

    public PersistedRoom fetchPersistedRoom(long roomId) {
        return persistedRoomLocalService.fetchPersistedRoom(roomId);
    }

    public List<PersistedRoom> findAll() {
		return persistedRoomLocalService.findAll();
    }

    public List<PersistedRoom> findByOfficeId(long officeId) {
        return persistedRoomLocalService.findByOfficeId(officeId);
    }

    public List<PersistedRoom> findByCalendarId(long calendarId) {
        return persistedRoomLocalService.findByCalendarId(calendarId);
    }

    public List<PersistedRoom> getPersistedAmenityPersistedRooms (long amenityId) {
        return persistedRoomLocalService.getPersistedAmenityPersistedRooms(amenityId);
    }

    public List<PersistedRoom> getPersistedPurposePersistedRooms (long purposeId) {
        return persistedRoomLocalService.getPersistedPurposePersistedRooms(purposeId);
    }

	public PersistedRoom addPersistedRoom(String name, String photoPath, boolean availableSunday, boolean availableMonday, 
            boolean availableTuesday, boolean availableWednesday, boolean availableThursday, boolean availableFriday, boolean availableSaturday,
            int availableStartTime, int availableEndTime, long officeId, double capacitySquareMeters, int capacityPeople, int phoneExtension, String wifiSSID,
            int wifiSecurityType, String wifiPassword, long[] amenitiesIds, long[] purposeIds, ServiceContext serviceContext) throws PortalException {
        
        return persistedRoomLocalService.addPersistedRoom(name, photoPath, availableSunday, availableMonday, availableTuesday, availableWednesday,
                availableThursday, availableFriday, availableSaturday, availableStartTime, availableEndTime, officeId, capacitySquareMeters, capacityPeople,
                phoneExtension, wifiSSID, wifiSecurityType, wifiPassword, amenitiesIds, purposeIds, serviceContext);
	}

	public PersistedRoom updateRoom(long roomId, String name, String photoPath, boolean availableSunday, boolean availableMonday, 
            boolean availableTuesday, boolean availableWednesday, boolean availableThursday, boolean availableFriday, boolean availableSaturday,
            int availableStartTime, int availableEndTime, long officeId, double capacitySquareMeters, int capacityPeople, int phoneExtension, String wifiSSID,
            int wifiSecurityType, String wifiPassword, long[] amenitiesIds, long[] purposeIds, ServiceContext serviceContext) throws PortalException {
        
        return persistedRoomLocalService.updatePersistedRoom(roomId, name, photoPath, availableSunday, availableMonday, availableTuesday, availableWednesday,
                availableThursday, availableFriday, availableSaturday, availableStartTime, availableEndTime, officeId, capacitySquareMeters, capacityPeople,
                phoneExtension, wifiSSID, wifiSecurityType, wifiPassword, amenitiesIds, purposeIds, serviceContext);
	}

	public PersistedRoom deleteRoom(long roomId) throws PortalException {
		return persistedRoomLocalService.deletePersistedRoom(roomId);
	}
}