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
 * Provides a wrapper for {@link PersistedBookingService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedBookingService
 * @generated
 */
public class PersistedBookingServiceWrapper
	implements PersistedBookingService,
			   ServiceWrapper<PersistedBookingService> {

	public PersistedBookingServiceWrapper(
		PersistedBookingService persistedBookingService) {

		_persistedBookingService = persistedBookingService;
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedBooking addPersistedBooking(
			String title, java.util.Date startDt, java.util.Date endDt,
			long roomId, String description, long[] participantIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedBookingService.addPersistedBooking(
			title, startDt, endDt, roomId, description, participantIds,
			serviceContext);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedBooking
			deletePersistedBooking(long bookingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedBookingService.deletePersistedBooking(bookingId);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedBooking
		fetchPersistedBooking(long bookingId) {

		return _persistedBookingService.fetchPersistedBooking(bookingId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
		findAll() {

		return _persistedBookingService.findAll();
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
		findByRoomId(long roomId) {

		return _persistedBookingService.findByRoomId(roomId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
		findByUserId(long userId) {

		return _persistedBookingService.findByUserId(userId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedBookingService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
		getPersistedParticipantPersistedBookings(long participantId) {

		return _persistedBookingService.
			getPersistedParticipantPersistedBookings(participantId);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedBooking
			updatePersistedBooking(
				long bookingId, String title, java.util.Date startDt,
				java.util.Date endDt, long roomId, String description,
				long[] participantIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedBookingService.updatePersistedBooking(
			bookingId, title, startDt, endDt, roomId, description,
			participantIds, serviceContext);
	}

	@Override
	public PersistedBookingService getWrappedService() {
		return _persistedBookingService;
	}

	@Override
	public void setWrappedService(
		PersistedBookingService persistedBookingService) {

		_persistedBookingService = persistedBookingService;
	}

	private PersistedBookingService _persistedBookingService;

}