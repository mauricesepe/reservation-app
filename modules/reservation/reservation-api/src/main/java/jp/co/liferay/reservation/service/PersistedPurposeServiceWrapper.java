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
 * Provides a wrapper for {@link PersistedPurposeService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedPurposeService
 * @generated
 */
@ProviderType
public class PersistedPurposeServiceWrapper
	implements PersistedPurposeService,
			   ServiceWrapper<PersistedPurposeService> {

	public PersistedPurposeServiceWrapper(
		PersistedPurposeService persistedPurposeService) {

		_persistedPurposeService = persistedPurposeService;
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose addPersistedPurpose(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedPurposeService.addPersistedPurpose(
			name, serviceContext);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose
			deletePersistedPurpose(
				long purposeId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedPurposeService.deletePersistedPurpose(
			purposeId, serviceContext);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose
		fetchPersistedPurpose(long purposeId) {

		return _persistedPurposeService.fetchPersistedPurpose(purposeId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedPurpose>
		findAll() {

		return _persistedPurposeService.findAll();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedPurposeService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedPurpose>
		getPersistedRoomPersistedPurposes(long roomId) {

		return _persistedPurposeService.getPersistedRoomPersistedPurposes(
			roomId);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose
			updatePersistedPurpose(
				long purposeId, String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedPurposeService.updatePersistedPurpose(
			purposeId, name, serviceContext);
	}

	@Override
	public PersistedPurposeService getWrappedService() {
		return _persistedPurposeService;
	}

	@Override
	public void setWrappedService(
		PersistedPurposeService persistedPurposeService) {

		_persistedPurposeService = persistedPurposeService;
	}

	private PersistedPurposeService _persistedPurposeService;

}