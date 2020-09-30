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
 * Provides the remote service utility for PersistedPurpose. This utility wraps
 * <code>jp.co.liferay.reservation.service.impl.PersistedPurposeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedPurposeService
 * @generated
 */
@ProviderType
public class PersistedPurposeServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedPurposeServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static jp.co.liferay.reservation.model.PersistedPurpose
			addPersistedPurpose(
				String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addPersistedPurpose(name, serviceContext);
	}

	public static jp.co.liferay.reservation.model.PersistedPurpose
			deletePersistedPurpose(
				long purposeId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedPurpose(purposeId, serviceContext);
	}

	public static jp.co.liferay.reservation.model.PersistedPurpose
		fetchPersistedPurpose(long purposeId) {

		return getService().fetchPersistedPurpose(purposeId);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedPurpose> findAll() {

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
		<jp.co.liferay.reservation.model.PersistedPurpose>
			getPersistedRoomPersistedPurposes(long roomId) {

		return getService().getPersistedRoomPersistedPurposes(roomId);
	}

	public static jp.co.liferay.reservation.model.PersistedPurpose
			updatePersistedPurpose(
				long purposeId, String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updatePersistedPurpose(
			purposeId, name, serviceContext);
	}

	public static PersistedPurposeService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedPurposeService, PersistedPurposeService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PersistedPurposeService.class);

		ServiceTracker<PersistedPurposeService, PersistedPurposeService>
			serviceTracker =
				new ServiceTracker
					<PersistedPurposeService, PersistedPurposeService>(
						bundle.getBundleContext(),
						PersistedPurposeService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}