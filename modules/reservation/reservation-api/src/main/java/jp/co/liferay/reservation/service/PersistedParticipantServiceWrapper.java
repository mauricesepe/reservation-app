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

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link PersistedParticipantService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedParticipantService
 * @generated
 */
@ProviderType
public class PersistedParticipantServiceWrapper
	implements PersistedParticipantService,
			   ServiceWrapper<PersistedParticipantService> {

	public PersistedParticipantServiceWrapper(
		PersistedParticipantService persistedParticipantService) {

		_persistedParticipantService = persistedParticipantService;
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
			addPersistedParticipant(
				long userId, String fullName, String companyName,
				String emailAddress,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedParticipantService.addPersistedParticipant(
			userId, fullName, companyName, emailAddress, serviceContext);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
			deletePersistedParticipant(long participantId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedParticipantService.deletePersistedParticipant(
			participantId);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
		fetchPersistedParticipant(long participantId) {

		return _persistedParticipantService.fetchPersistedParticipant(
			participantId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedParticipant>
		findAll() {

		return _persistedParticipantService.findAll();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedParticipantService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedParticipant>
		getPersistedBookingPersistedParticipants(long bookingId) {

		return _persistedParticipantService.
			getPersistedBookingPersistedParticipants(bookingId);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
			updatePersistedParticipant(
				long participantId, long userId, String fullName,
				String companyName, String emailAddress,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedParticipantService.updatePersistedParticipant(
			participantId, userId, fullName, companyName, emailAddress,
			serviceContext);
	}

	@Override
	public PersistedParticipantService getWrappedService() {
		return _persistedParticipantService;
	}

	@Override
	public void setWrappedService(
		PersistedParticipantService persistedParticipantService) {

		_persistedParticipantService = persistedParticipantService;
	}

	private PersistedParticipantService _persistedParticipantService;

}