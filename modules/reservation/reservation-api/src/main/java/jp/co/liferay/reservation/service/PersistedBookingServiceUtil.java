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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for PersistedBooking. This utility wraps
 * <code>jp.co.liferay.reservation.service.impl.PersistedBookingServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedBookingService
 * @generated
 */
@ProviderType
public class PersistedBookingServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedBookingServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static jp.co.liferay.reservation.model.PersistedBooking
			addPersistedBooking(
				String title, java.util.Date startDt, java.util.Date endDt,
				long roomId, String description, long[] participantIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addPersistedBooking(
			title, startDt, endDt, roomId, description, participantIds,
			serviceContext);
	}

	public static jp.co.liferay.reservation.model.PersistedBooking
			deletePersistedBooking(long bookingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedBooking(bookingId);
	}

	public static jp.co.liferay.reservation.model.PersistedBooking
		fetchPersistedBooking(long bookingId) {

		return getService().fetchPersistedBooking(bookingId);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedBooking> findAll() {

		return getService().findAll();
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedBooking> findByRoomId(
			long roomId) {

		return getService().findByRoomId(roomId);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedBooking> findByUserId(
			long userId) {

		return getService().findByUserId(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedBooking>
			getPersistedParticipantPersistedBookings(long participantId) {

		return getService().getPersistedParticipantPersistedBookings(
			participantId);
	}

	public static jp.co.liferay.reservation.model.PersistedBooking
			updatePersistedBooking(
				long bookingId, String title, java.util.Date startDt,
				java.util.Date endDt, long roomId, String description,
				long[] participantIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updatePersistedBooking(
			bookingId, title, startDt, endDt, roomId, description,
			participantIds, serviceContext);
	}

	public static PersistedBookingService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedBookingService, PersistedBookingService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PersistedBookingService.class);

		ServiceTracker<PersistedBookingService, PersistedBookingService>
			serviceTracker =
				new ServiceTracker
					<PersistedBookingService, PersistedBookingService>(
						bundle.getBundleContext(),
						PersistedBookingService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}