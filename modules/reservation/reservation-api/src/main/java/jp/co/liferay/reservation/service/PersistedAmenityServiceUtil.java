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
 * Provides the remote service utility for PersistedAmenity. This utility wraps
 * <code>jp.co.liferay.reservation.service.impl.PersistedAmenityServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedAmenityService
 * @generated
 */
@ProviderType
public class PersistedAmenityServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedAmenityServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static jp.co.liferay.reservation.model.PersistedAmenity
			addPersistedAmenity(
				String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addPersistedAmenity(name, serviceContext);
	}

	public static jp.co.liferay.reservation.model.PersistedAmenity
			deletePersistedAmenity(long amenityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedAmenity(amenityId);
	}

	public static jp.co.liferay.reservation.model.PersistedAmenity
		fetchPersistedAmenity(long amenityId) {

		return getService().fetchPersistedAmenity(amenityId);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedAmenity> findAll() {

		return getService().findAll();
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
		<jp.co.liferay.reservation.model.PersistedAmenity>
			getPersistedRoomPersistedAmenities(long roomId) {

		return getService().getPersistedRoomPersistedAmenities(roomId);
	}

	public static jp.co.liferay.reservation.model.PersistedAmenity
			updatePersistedAmenity(
				long amenityId, String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updatePersistedAmenity(
			amenityId, name, serviceContext);
	}

	public static PersistedAmenityService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedAmenityService, PersistedAmenityService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PersistedAmenityService.class);

		ServiceTracker<PersistedAmenityService, PersistedAmenityService>
			serviceTracker =
				new ServiceTracker
					<PersistedAmenityService, PersistedAmenityService>(
						bundle.getBundleContext(),
						PersistedAmenityService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}