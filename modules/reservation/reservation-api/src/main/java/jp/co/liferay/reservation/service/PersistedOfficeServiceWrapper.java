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
 * Provides a wrapper for {@link PersistedOfficeService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedOfficeService
 * @generated
 */
@ProviderType
public class PersistedOfficeServiceWrapper
	implements PersistedOfficeService, ServiceWrapper<PersistedOfficeService> {

	public PersistedOfficeServiceWrapper(
		PersistedOfficeService persistedOfficeService) {

		_persistedOfficeService = persistedOfficeService;
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedOffice addPersistedOffice(
			String name, String location,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedOfficeService.addPersistedOffice(
			name, location, serviceContext);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedOffice
			deletePersistedOffice(long officeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedOfficeService.deletePersistedOffice(officeId);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedOffice fetchPersistedOffice(
		long officeId) {

		return _persistedOfficeService.fetchPersistedOffice(officeId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedOffice>
		findAll() {

		return _persistedOfficeService.findAll();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedOfficeService.getOSGiServiceIdentifier();
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedOffice
			updatePersistedOffice(
				long officeId, String name, String location,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedOfficeService.updatePersistedOffice(
			officeId, name, location, serviceContext);
	}

	@Override
	public PersistedOfficeService getWrappedService() {
		return _persistedOfficeService;
	}

	@Override
	public void setWrappedService(
		PersistedOfficeService persistedOfficeService) {

		_persistedOfficeService = persistedOfficeService;
	}

	private PersistedOfficeService _persistedOfficeService;

}