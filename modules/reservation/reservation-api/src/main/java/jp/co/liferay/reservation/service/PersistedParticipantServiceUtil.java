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
 * Provides the remote service utility for PersistedParticipant. This utility wraps
 * <code>jp.co.liferay.reservation.service.impl.PersistedParticipantServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedParticipantService
 * @generated
 */
@ProviderType
public class PersistedParticipantServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedParticipantServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static jp.co.liferay.reservation.model.PersistedParticipant
			addPersistedParticipant(
				long userId, String fullName, String companyName,
				String emailAddress,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addPersistedParticipant(
			userId, fullName, companyName, emailAddress, serviceContext);
	}

	public static jp.co.liferay.reservation.model.PersistedParticipant
			deletePersistedParticipant(long participantId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedParticipant(participantId);
	}

	public static jp.co.liferay.reservation.model.PersistedParticipant
		fetchPersistedParticipant(long participantId) {

		return getService().fetchPersistedParticipant(participantId);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedParticipant> findAll() {

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
		<jp.co.liferay.reservation.model.PersistedParticipant>
			getPersistedBookingPersistedParticipants(long bookingId) {

		return getService().getPersistedBookingPersistedParticipants(bookingId);
	}

	public static jp.co.liferay.reservation.model.PersistedParticipant
			updatePersistedParticipant(
				long participantId, long userId, String fullName,
				String companyName, String emailAddress,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updatePersistedParticipant(
			participantId, userId, fullName, companyName, emailAddress,
			serviceContext);
	}

	public static PersistedParticipantService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedParticipantService, PersistedParticipantService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PersistedParticipantService.class);

		ServiceTracker<PersistedParticipantService, PersistedParticipantService>
			serviceTracker =
				new ServiceTracker
					<PersistedParticipantService, PersistedParticipantService>(
						bundle.getBundleContext(),
						PersistedParticipantService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}