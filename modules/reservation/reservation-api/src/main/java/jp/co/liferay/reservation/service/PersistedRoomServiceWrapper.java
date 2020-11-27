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

package jp.co.liferay.reservation.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PersistedRoomService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedRoomService
 * @generated
 */
public class PersistedRoomServiceWrapper
	implements PersistedRoomService, ServiceWrapper<PersistedRoomService> {

	public PersistedRoomServiceWrapper(
		PersistedRoomService persistedRoomService) {

		_persistedRoomService = persistedRoomService;
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedRoom addPersistedRoom(
			String name, String photoPath, boolean availableSunday,
			boolean availableMonday, boolean availableTuesday,
			boolean availableWednesday, boolean availableThursday,
			boolean availableFriday, boolean availableSaturday,
			int availableStartTime, int availableEndTime, long officeId,
			double capacitySquareMeters, int capacityPeople, int phoneExtension,
			String wifiSSID, int wifiSecurityType, String wifiPassword,
			long[] amenitiesIds, long[] purposeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedRoomService.addPersistedRoom(
			name, photoPath, availableSunday, availableMonday, availableTuesday,
			availableWednesday, availableThursday, availableFriday,
			availableSaturday, availableStartTime, availableEndTime, officeId,
			capacitySquareMeters, capacityPeople, phoneExtension, wifiSSID,
			wifiSecurityType, wifiPassword, amenitiesIds, purposeIds,
			serviceContext);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedRoom deleteRoom(long roomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedRoomService.deleteRoom(roomId);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedRoom fetchPersistedRoom(
		long roomId) {

		return _persistedRoomService.fetchPersistedRoom(roomId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		findAll() {

		return _persistedRoomService.findAll();
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		findByCalendarId(long calendarId) {

		return _persistedRoomService.findByCalendarId(calendarId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		findByOfficeId(long officeId) {

		return _persistedRoomService.findByOfficeId(officeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedRoomService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedAmenityPersistedRooms(long amenityId) {

		return _persistedRoomService.getPersistedAmenityPersistedRooms(
			amenityId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedPurposePersistedRooms(long purposeId) {

		return _persistedRoomService.getPersistedPurposePersistedRooms(
			purposeId);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedRoom updateRoom(
			long roomId, String name, String photoPath, boolean availableSunday,
			boolean availableMonday, boolean availableTuesday,
			boolean availableWednesday, boolean availableThursday,
			boolean availableFriday, boolean availableSaturday,
			int availableStartTime, int availableEndTime, long officeId,
			double capacitySquareMeters, int capacityPeople, int phoneExtension,
			String wifiSSID, int wifiSecurityType, String wifiPassword,
			long[] amenitiesIds, long[] purposeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedRoomService.updateRoom(
			roomId, name, photoPath, availableSunday, availableMonday,
			availableTuesday, availableWednesday, availableThursday,
			availableFriday, availableSaturday, availableStartTime,
			availableEndTime, officeId, capacitySquareMeters, capacityPeople,
			phoneExtension, wifiSSID, wifiSecurityType, wifiPassword,
			amenitiesIds, purposeIds, serviceContext);
	}

	@Override
	public PersistedRoomService getWrappedService() {
		return _persistedRoomService;
	}

	@Override
	public void setWrappedService(PersistedRoomService persistedRoomService) {
		_persistedRoomService = persistedRoomService;
	}

	private PersistedRoomService _persistedRoomService;

}