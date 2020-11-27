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
 * Provides the remote service utility for PersistedOffice. This utility wraps
 * <code>jp.co.liferay.reservation.service.impl.PersistedOfficeServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedOfficeService
 * @generated
 */
public class PersistedOfficeServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedOfficeServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static jp.co.liferay.reservation.model.PersistedOffice
			addPersistedOffice(
				String name, String location,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addPersistedOffice(name, location, serviceContext);
	}

	public static jp.co.liferay.reservation.model.PersistedOffice
			deletePersistedOffice(long officeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedOffice(officeId);
	}

	public static jp.co.liferay.reservation.model.PersistedOffice
		fetchPersistedOffice(long officeId) {

		return getService().fetchPersistedOffice(officeId);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedOffice> findAll() {

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

	public static jp.co.liferay.reservation.model.PersistedOffice
			updatePersistedOffice(
				long officeId, String name, String location,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updatePersistedOffice(
			officeId, name, location, serviceContext);
	}

	public static PersistedOfficeService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedOfficeService, PersistedOfficeService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PersistedOfficeService.class);

		ServiceTracker<PersistedOfficeService, PersistedOfficeService>
			serviceTracker =
				new ServiceTracker
					<PersistedOfficeService, PersistedOfficeService>(
						bundle.getBundleContext(), PersistedOfficeService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}