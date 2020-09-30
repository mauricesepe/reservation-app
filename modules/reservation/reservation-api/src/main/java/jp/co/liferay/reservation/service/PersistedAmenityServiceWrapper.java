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
 * Provides a wrapper for {@link PersistedAmenityService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedAmenityService
 * @generated
 */
@ProviderType
public class PersistedAmenityServiceWrapper
	implements PersistedAmenityService,
			   ServiceWrapper<PersistedAmenityService> {

	public PersistedAmenityServiceWrapper(
		PersistedAmenityService persistedAmenityService) {

		_persistedAmenityService = persistedAmenityService;
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity addPersistedAmenity(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedAmenityService.addPersistedAmenity(
			name, serviceContext);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity
			deletePersistedAmenity(long amenityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedAmenityService.deletePersistedAmenity(amenityId);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity
		fetchPersistedAmenity(long amenityId) {

		return _persistedAmenityService.fetchPersistedAmenity(amenityId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
		findAll() {

		return _persistedAmenityService.findAll();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedAmenityService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
		getPersistedRoomPersistedAmenities(long roomId) {

		return _persistedAmenityService.getPersistedRoomPersistedAmenities(
			roomId);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity
			updatePersistedAmenity(
				long amenityId, String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedAmenityService.updatePersistedAmenity(
			amenityId, name, serviceContext);
	}

	@Override
	public PersistedAmenityService getWrappedService() {
		return _persistedAmenityService;
	}

	@Override
	public void setWrappedService(
		PersistedAmenityService persistedAmenityService) {

		_persistedAmenityService = persistedAmenityService;
	}

	private PersistedAmenityService _persistedAmenityService;

}