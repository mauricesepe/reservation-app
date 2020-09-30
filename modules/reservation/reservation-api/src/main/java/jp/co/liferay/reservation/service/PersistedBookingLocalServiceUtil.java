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
 * Provides the local service utility for PersistedBooking. This utility wraps
 * <code>jp.co.liferay.reservation.service.impl.PersistedBookingLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedBookingLocalService
 * @generated
 */
@ProviderType
public class PersistedBookingLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedBookingLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the persisted booking to the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedBooking the persisted booking
	 * @return the persisted booking that was added
	 */
	public static jp.co.liferay.reservation.model.PersistedBooking
		addPersistedBooking(
			jp.co.liferay.reservation.model.PersistedBooking persistedBooking) {

		return getService().addPersistedBooking(persistedBooking);
	}

	public static jp.co.liferay.reservation.model.PersistedBooking
			addPersistedBooking(
				String title, java.util.Date startDt, java.util.Date endDt,
				long roomId, String description, long[] participantIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addPersistedBooking(
			title, startDt, endDt, roomId, description, participantIds,
			serviceContext);
	}

	public static void addPersistedParticipantPersistedBooking(
		long participantId, long bookingId) {

		getService().addPersistedParticipantPersistedBooking(
			participantId, bookingId);
	}

	public static void addPersistedParticipantPersistedBooking(
		long participantId,
		jp.co.liferay.reservation.model.PersistedBooking persistedBooking) {

		getService().addPersistedParticipantPersistedBooking(
			participantId, persistedBooking);
	}

	public static void addPersistedParticipantPersistedBookings(
		long participantId,
		java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
			persistedBookings) {

		getService().addPersistedParticipantPersistedBookings(
			participantId, persistedBookings);
	}

	public static void addPersistedParticipantPersistedBookings(
		long participantId, long[] bookingIds) {

		getService().addPersistedParticipantPersistedBookings(
			participantId, bookingIds);
	}

	public static void clearPersistedParticipantPersistedBookings(
		long participantId) {

		getService().clearPersistedParticipantPersistedBookings(participantId);
	}

	/**
	 * Creates a new persisted booking with the primary key. Does not add the persisted booking to the database.
	 *
	 * @param bookingId the primary key for the new persisted booking
	 * @return the new persisted booking
	 */
	public static jp.co.liferay.reservation.model.PersistedBooking
		createPersistedBooking(long bookingId) {

		return getService().createPersistedBooking(bookingId);
	}

	/**
	 * Deletes the persisted booking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingId the primary key of the persisted booking
	 * @return the persisted booking that was removed
	 * @throws PortalException if a persisted booking with the primary key could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedBooking
			deletePersistedBooking(long bookingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedBooking(bookingId);
	}

	/**
	 * Deletes the persisted booking from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedBooking the persisted booking
	 * @return the persisted booking that was removed
	 */
	public static jp.co.liferay.reservation.model.PersistedBooking
		deletePersistedBooking(
			jp.co.liferay.reservation.model.PersistedBooking persistedBooking) {

		return getService().deletePersistedBooking(persistedBooking);
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

	public static void deletePersistedParticipantPersistedBooking(
		long participantId, long bookingId) {

		getService().deletePersistedParticipantPersistedBooking(
			participantId, bookingId);
	}

	public static void deletePersistedParticipantPersistedBooking(
		long participantId,
		jp.co.liferay.reservation.model.PersistedBooking persistedBooking) {

		getService().deletePersistedParticipantPersistedBooking(
			participantId, persistedBooking);
	}

	public static void deletePersistedParticipantPersistedBookings(
		long participantId,
		java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
			persistedBookings) {

		getService().deletePersistedParticipantPersistedBookings(
			participantId, persistedBookings);
	}

	public static void deletePersistedParticipantPersistedBookings(
		long participantId, long[] bookingIds) {

		getService().deletePersistedParticipantPersistedBookings(
			participantId, bookingIds);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static jp.co.liferay.reservation.model.PersistedBooking
		fetchPersistedBooking(long bookingId) {

		return getService().fetchPersistedBooking(bookingId);
	}

	/**
	 * Returns the persisted booking with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted booking's external reference code
	 * @return the matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedBooking
		fetchPersistedBookingByReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchPersistedBookingByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted booking with the matching UUID and company.
	 *
	 * @param uuid the persisted booking's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedBooking
		fetchPersistedBookingByUuidAndCompanyId(String uuid, long companyId) {

		return getService().fetchPersistedBookingByUuidAndCompanyId(
			uuid, companyId);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedBooking> findAll() {

		return getService().findAll();
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedBooking> findByRoomId(
			long roomId) {

		return getService().findByRoomId(roomId);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedBooking> findByUserId(
			long userId) {

		return getService().findByUserId(userId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
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

	/**
	 * Returns the persisted booking with the primary key.
	 *
	 * @param bookingId the primary key of the persisted booking
	 * @return the persisted booking
	 * @throws PortalException if a persisted booking with the primary key could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedBooking
			getPersistedBooking(long bookingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedBooking(bookingId);
	}

	/**
	 * Returns the persisted booking with the matching UUID and company.
	 *
	 * @param uuid the persisted booking's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted booking
	 * @throws PortalException if a matching persisted booking could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedBooking
			getPersistedBookingByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedBookingByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the persisted bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @return the range of persisted bookings
	 */
	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedBooking> getPersistedBookings(
			int start, int end) {

		return getService().getPersistedBookings(start, end);
	}

	/**
	 * Returns the number of persisted bookings.
	 *
	 * @return the number of persisted bookings
	 */
	public static int getPersistedBookingsCount() {
		return getService().getPersistedBookingsCount();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedBooking>
			getPersistedParticipantPersistedBookings(long participantId) {

		return getService().getPersistedParticipantPersistedBookings(
			participantId);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedBooking>
			getPersistedParticipantPersistedBookings(
				long participantId, int start, int end) {

		return getService().getPersistedParticipantPersistedBookings(
			participantId, start, end);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedBooking>
			getPersistedParticipantPersistedBookings(
				long participantId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<jp.co.liferay.reservation.model.PersistedBooking>
						orderByComparator) {

		return getService().getPersistedParticipantPersistedBookings(
			participantId, start, end, orderByComparator);
	}

	public static int getPersistedParticipantPersistedBookingsCount(
		long participantId) {

		return getService().getPersistedParticipantPersistedBookingsCount(
			participantId);
	}

	/**
	 * Returns the participantIds of the persisted participants associated with the persisted booking.
	 *
	 * @param bookingId the bookingId of the persisted booking
	 * @return long[] the participantIds of persisted participants associated with the persisted booking
	 */
	public static long[] getPersistedParticipantPrimaryKeys(long bookingId) {
		return getService().getPersistedParticipantPrimaryKeys(bookingId);
	}

	public static boolean hasPersistedParticipantPersistedBooking(
		long participantId, long bookingId) {

		return getService().hasPersistedParticipantPersistedBooking(
			participantId, bookingId);
	}

	public static boolean hasPersistedParticipantPersistedBookings(
		long participantId) {

		return getService().hasPersistedParticipantPersistedBookings(
			participantId);
	}

	public static void setPersistedParticipantPersistedBookings(
		long participantId, long[] bookingIds) {

		getService().setPersistedParticipantPersistedBookings(
			participantId, bookingIds);
	}

	public static jp.co.liferay.reservation.model.PersistedBooking
			updatePersistedBooking(
				long bookingId, String title, java.util.Date startDt,
				java.util.Date endDt, long roomId, String description,
				long[] participantIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updatePersistedBooking(
			bookingId, title, startDt, endDt, roomId, description,
			participantIds, serviceContext);
	}

	/**
	 * Updates the persisted booking in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param persistedBooking the persisted booking
	 * @return the persisted booking that was updated
	 */
	public static jp.co.liferay.reservation.model.PersistedBooking
		updatePersistedBooking(
			jp.co.liferay.reservation.model.PersistedBooking persistedBooking) {

		return getService().updatePersistedBooking(persistedBooking);
	}

	public static PersistedBookingLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedBookingLocalService, PersistedBookingLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PersistedBookingLocalService.class);

		ServiceTracker
			<PersistedBookingLocalService, PersistedBookingLocalService>
				serviceTracker =
					new ServiceTracker
						<PersistedBookingLocalService,
						 PersistedBookingLocalService>(
							 bundle.getBundleContext(),
							 PersistedBookingLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}