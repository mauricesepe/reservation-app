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
 * Provides the local service utility for PersistedParticipant. This utility wraps
 * <code>jp.co.liferay.reservation.service.impl.PersistedParticipantLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedParticipantLocalService
 * @generated
 */
public class PersistedParticipantLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedParticipantLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addPersistedBookingPersistedParticipant(
		long bookingId, long participantId) {

		getService().addPersistedBookingPersistedParticipant(
			bookingId, participantId);
	}

	public static void addPersistedBookingPersistedParticipant(
		long bookingId,
		jp.co.liferay.reservation.model.PersistedParticipant
			persistedParticipant) {

		getService().addPersistedBookingPersistedParticipant(
			bookingId, persistedParticipant);
	}

	public static void addPersistedBookingPersistedParticipants(
		long bookingId,
		java.util.List<jp.co.liferay.reservation.model.PersistedParticipant>
			persistedParticipants) {

		getService().addPersistedBookingPersistedParticipants(
			bookingId, persistedParticipants);
	}

	public static void addPersistedBookingPersistedParticipants(
		long bookingId, long[] participantIds) {

		getService().addPersistedBookingPersistedParticipants(
			bookingId, participantIds);
	}

	public static jp.co.liferay.reservation.model.PersistedParticipant
			addPersistedParticipant(
				long userId, String fullName, String companyName,
				String emailAddress,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addPersistedParticipant(
			userId, fullName, companyName, emailAddress, serviceContext);
	}

	/**
	 * Adds the persisted participant to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedParticipantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedParticipant the persisted participant
	 * @return the persisted participant that was added
	 */
	public static jp.co.liferay.reservation.model.PersistedParticipant
		addPersistedParticipant(
			jp.co.liferay.reservation.model.PersistedParticipant
				persistedParticipant) {

		return getService().addPersistedParticipant(persistedParticipant);
	}

	public static void clearPersistedBookingPersistedParticipants(
		long bookingId) {

		getService().clearPersistedBookingPersistedParticipants(bookingId);
	}

	/**
	 * Creates a new persisted participant with the primary key. Does not add the persisted participant to the database.
	 *
	 * @param participantId the primary key for the new persisted participant
	 * @return the new persisted participant
	 */
	public static jp.co.liferay.reservation.model.PersistedParticipant
		createPersistedParticipant(long participantId) {

		return getService().createPersistedParticipant(participantId);
	}

	public static void deletePersistedBookingPersistedParticipant(
		long bookingId, long participantId) {

		getService().deletePersistedBookingPersistedParticipant(
			bookingId, participantId);
	}

	public static void deletePersistedBookingPersistedParticipant(
		long bookingId,
		jp.co.liferay.reservation.model.PersistedParticipant
			persistedParticipant) {

		getService().deletePersistedBookingPersistedParticipant(
			bookingId, persistedParticipant);
	}

	public static void deletePersistedBookingPersistedParticipants(
		long bookingId,
		java.util.List<jp.co.liferay.reservation.model.PersistedParticipant>
			persistedParticipants) {

		getService().deletePersistedBookingPersistedParticipants(
			bookingId, persistedParticipants);
	}

	public static void deletePersistedBookingPersistedParticipants(
		long bookingId, long[] participantIds) {

		getService().deletePersistedBookingPersistedParticipants(
			bookingId, participantIds);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the persisted participant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedParticipantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param participantId the primary key of the persisted participant
	 * @return the persisted participant that was removed
	 * @throws PortalException if a persisted participant with the primary key could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedParticipant
			deletePersistedParticipant(long participantId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedParticipant(participantId);
	}

	/**
	 * Deletes the persisted participant from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedParticipantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedParticipant the persisted participant
	 * @return the persisted participant that was removed
	 */
	public static jp.co.liferay.reservation.model.PersistedParticipant
		deletePersistedParticipant(
			jp.co.liferay.reservation.model.PersistedParticipant
				persistedParticipant) {

		return getService().deletePersistedParticipant(persistedParticipant);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedParticipantModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedParticipantModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static jp.co.liferay.reservation.model.PersistedParticipant
		fetchPersistedParticipant(long participantId) {

		return getService().fetchPersistedParticipant(participantId);
	}

	/**
	 * Returns the persisted participant with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted participant's external reference code
	 * @return the matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedParticipant
		fetchPersistedParticipantByReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchPersistedParticipantByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted participant with the matching UUID and company.
	 *
	 * @param uuid the persisted participant's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedParticipant
		fetchPersistedParticipantByUuidAndCompanyId(
			String uuid, long companyId) {

		return getService().fetchPersistedParticipantByUuidAndCompanyId(
			uuid, companyId);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedParticipant> findAll() {

		return getService().findAll();
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
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

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedParticipant>
			getPersistedBookingPersistedParticipants(
				long bookingId, int start, int end) {

		return getService().getPersistedBookingPersistedParticipants(
			bookingId, start, end);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedParticipant>
			getPersistedBookingPersistedParticipants(
				long bookingId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<jp.co.liferay.reservation.model.PersistedParticipant>
						orderByComparator) {

		return getService().getPersistedBookingPersistedParticipants(
			bookingId, start, end, orderByComparator);
	}

	public static int getPersistedBookingPersistedParticipantsCount(
		long bookingId) {

		return getService().getPersistedBookingPersistedParticipantsCount(
			bookingId);
	}

	/**
	 * Returns the bookingIds of the persisted bookings associated with the persisted participant.
	 *
	 * @param participantId the participantId of the persisted participant
	 * @return long[] the bookingIds of persisted bookings associated with the persisted participant
	 */
	public static long[] getPersistedBookingPrimaryKeys(long participantId) {
		return getService().getPersistedBookingPrimaryKeys(participantId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the persisted participant with the primary key.
	 *
	 * @param participantId the primary key of the persisted participant
	 * @return the persisted participant
	 * @throws PortalException if a persisted participant with the primary key could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedParticipant
			getPersistedParticipant(long participantId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedParticipant(participantId);
	}

	/**
	 * Returns the persisted participant with the matching UUID and company.
	 *
	 * @param uuid the persisted participant's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted participant
	 * @throws PortalException if a matching persisted participant could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedParticipant
			getPersistedParticipantByUuidAndCompanyId(
				String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedParticipantByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the persisted participants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedParticipantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @return the range of persisted participants
	 */
	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedParticipant>
			getPersistedParticipants(int start, int end) {

		return getService().getPersistedParticipants(start, end);
	}

	/**
	 * Returns the number of persisted participants.
	 *
	 * @return the number of persisted participants
	 */
	public static int getPersistedParticipantsCount() {
		return getService().getPersistedParticipantsCount();
	}

	public static boolean hasPersistedBookingPersistedParticipant(
		long bookingId, long participantId) {

		return getService().hasPersistedBookingPersistedParticipant(
			bookingId, participantId);
	}

	public static boolean hasPersistedBookingPersistedParticipants(
		long bookingId) {

		return getService().hasPersistedBookingPersistedParticipants(bookingId);
	}

	public static void setPersistedBookingPersistedParticipants(
		long bookingId, long[] participantIds) {

		getService().setPersistedBookingPersistedParticipants(
			bookingId, participantIds);
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

	/**
	 * Updates the persisted participant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedParticipantLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedParticipant the persisted participant
	 * @return the persisted participant that was updated
	 */
	public static jp.co.liferay.reservation.model.PersistedParticipant
		updatePersistedParticipant(
			jp.co.liferay.reservation.model.PersistedParticipant
				persistedParticipant) {

		return getService().updatePersistedParticipant(persistedParticipant);
	}

	public static PersistedParticipantLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedParticipantLocalService, PersistedParticipantLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PersistedParticipantLocalService.class);

		ServiceTracker
			<PersistedParticipantLocalService, PersistedParticipantLocalService>
				serviceTracker =
					new ServiceTracker
						<PersistedParticipantLocalService,
						 PersistedParticipantLocalService>(
							 bundle.getBundleContext(),
							 PersistedParticipantLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}