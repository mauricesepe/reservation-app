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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for PersistedRoom. This utility wraps
 * <code>jp.co.liferay.reservation.service.impl.PersistedRoomServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedRoomService
 * @generated
 */
public class PersistedRoomServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedRoomServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static jp.co.liferay.reservation.model.PersistedRoom
			addPersistedRoom(
				String name, String photoPath, boolean availableSunday,
				boolean availableMonday, boolean availableTuesday,
				boolean availableWednesday, boolean availableThursday,
				boolean availableFriday, boolean availableSaturday,
				int availableStartTime, int availableEndTime, long officeId,
				double capacitySquareMeters, int capacityPeople,
				int phoneExtension, String wifiSSID, int wifiSecurityType,
				String wifiPassword, long[] amenitiesIds, long[] purposeIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addPersistedRoom(
			name, photoPath, availableSunday, availableMonday, availableTuesday,
			availableWednesday, availableThursday, availableFriday,
			availableSaturday, availableStartTime, availableEndTime, officeId,
			capacitySquareMeters, capacityPeople, phoneExtension, wifiSSID,
			wifiSecurityType, wifiPassword, amenitiesIds, purposeIds,
			serviceContext);
	}

	public static jp.co.liferay.reservation.model.PersistedRoom deleteRoom(
			long roomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteRoom(roomId);
	}

	public static jp.co.liferay.reservation.model.PersistedRoom
		fetchPersistedRoom(long roomId) {

		return getService().fetchPersistedRoom(roomId);
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		findAll() {

		return getService().findAll();
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		findByCalendarId(long calendarId) {

		return getService().findByCalendarId(calendarId);
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		findByOfficeId(long officeId) {

		return getService().findByOfficeId(officeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedAmenityPersistedRooms(long amenityId) {

		return getService().getPersistedAmenityPersistedRooms(amenityId);
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedPurposePersistedRooms(long purposeId) {

		return getService().getPersistedPurposePersistedRooms(purposeId);
	}

	public static jp.co.liferay.reservation.model.PersistedRoom updateRoom(
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

		return getService().updateRoom(
			roomId, name, photoPath, availableSunday, availableMonday,
			availableTuesday, availableWednesday, availableThursday,
			availableFriday, availableSaturday, availableStartTime,
			availableEndTime, officeId, capacitySquareMeters, capacityPeople,
			phoneExtension, wifiSSID, wifiSecurityType, wifiPassword,
			amenitiesIds, purposeIds, serviceContext);
	}

	public static PersistedRoomService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PersistedRoomService, PersistedRoomService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PersistedRoomService.class);

		ServiceTracker<PersistedRoomService, PersistedRoomService>
			serviceTracker =
				new ServiceTracker<PersistedRoomService, PersistedRoomService>(
					bundle.getBundleContext(), PersistedRoomService.class,
					null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}