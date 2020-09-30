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
 * Provides a wrapper for {@link PersistedBookingLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedBookingLocalService
 * @generated
 */
@ProviderType
public class PersistedBookingLocalServiceWrapper
	implements PersistedBookingLocalService,
			   ServiceWrapper<PersistedBookingLocalService> {

	public PersistedBookingLocalServiceWrapper(
		PersistedBookingLocalService persistedBookingLocalService) {

		_persistedBookingLocalService = persistedBookingLocalService;
	}

	/**
	 * Adds the persisted booking to the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedBooking the persisted booking
	 * @return the persisted booking that was added
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedBooking addPersistedBooking(
		jp.co.liferay.reservation.model.PersistedBooking persistedBooking) {

		return _persistedBookingLocalService.addPersistedBooking(
			persistedBooking);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedBooking addPersistedBooking(
			String title, java.util.Date startDt, java.util.Date endDt,
			long roomId, String description, long[] participantIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedBookingLocalService.addPersistedBooking(
			title, startDt, endDt, roomId, description, participantIds,
			serviceContext);
	}

	@Override
	public void addPersistedParticipantPersistedBooking(
		long participantId, long bookingId) {

		_persistedBookingLocalService.addPersistedParticipantPersistedBooking(
			participantId, bookingId);
	}

	@Override
	public void addPersistedParticipantPersistedBooking(
		long participantId,
		jp.co.liferay.reservation.model.PersistedBooking persistedBooking) {

		_persistedBookingLocalService.addPersistedParticipantPersistedBooking(
			participantId, persistedBooking);
	}

	@Override
	public void addPersistedParticipantPersistedBookings(
		long participantId,
		java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
			persistedBookings) {

		_persistedBookingLocalService.addPersistedParticipantPersistedBookings(
			participantId, persistedBookings);
	}

	@Override
	public void addPersistedParticipantPersistedBookings(
		long participantId, long[] bookingIds) {

		_persistedBookingLocalService.addPersistedParticipantPersistedBookings(
			participantId, bookingIds);
	}

	@Override
	public void clearPersistedParticipantPersistedBookings(long participantId) {
		_persistedBookingLocalService.
			clearPersistedParticipantPersistedBookings(participantId);
	}

	/**
	 * Creates a new persisted booking with the primary key. Does not add the persisted booking to the database.
	 *
	 * @param bookingId the primary key for the new persisted booking
	 * @return the new persisted booking
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedBooking
		createPersistedBooking(long bookingId) {

		return _persistedBookingLocalService.createPersistedBooking(bookingId);
	}

	/**
	 * Deletes the persisted booking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingId the primary key of the persisted booking
	 * @return the persisted booking that was removed
	 * @throws PortalException if a persisted booking with the primary key could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedBooking
			deletePersistedBooking(long bookingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedBookingLocalService.deletePersistedBooking(bookingId);
	}

	/**
	 * Deletes the persisted booking from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedBooking the persisted booking
	 * @return the persisted booking that was removed
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedBooking
		deletePersistedBooking(
			jp.co.liferay.reservation.model.PersistedBooking persistedBooking) {

		return _persistedBookingLocalService.deletePersistedBooking(
			persistedBooking);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedBookingLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public void deletePersistedParticipantPersistedBooking(
		long participantId, long bookingId) {

		_persistedBookingLocalService.
			deletePersistedParticipantPersistedBooking(
				participantId, bookingId);
	}

	@Override
	public void deletePersistedParticipantPersistedBooking(
		long participantId,
		jp.co.liferay.reservation.model.PersistedBooking persistedBooking) {

		_persistedBookingLocalService.
			deletePersistedParticipantPersistedBooking(
				participantId, persistedBooking);
	}

	@Override
	public void deletePersistedParticipantPersistedBookings(
		long participantId,
		java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
			persistedBookings) {

		_persistedBookingLocalService.
			deletePersistedParticipantPersistedBookings(
				participantId, persistedBookings);
	}

	@Override
	public void deletePersistedParticipantPersistedBookings(
		long participantId, long[] bookingIds) {

		_persistedBookingLocalService.
			deletePersistedParticipantPersistedBookings(
				participantId, bookingIds);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _persistedBookingLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _persistedBookingLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _persistedBookingLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _persistedBookingLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _persistedBookingLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _persistedBookingLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedBooking
		fetchPersistedBooking(long bookingId) {

		return _persistedBookingLocalService.fetchPersistedBooking(bookingId);
	}

	/**
	 * Returns the persisted booking with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted booking's external reference code
	 * @return the matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedBooking
		fetchPersistedBookingByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _persistedBookingLocalService.
			fetchPersistedBookingByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted booking with the matching UUID and company.
	 *
	 * @param uuid the persisted booking's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedBooking
		fetchPersistedBookingByUuidAndCompanyId(String uuid, long companyId) {

		return _persistedBookingLocalService.
			fetchPersistedBookingByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
		findAll() {

		return _persistedBookingLocalService.findAll();
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
		findByRoomId(long roomId) {

		return _persistedBookingLocalService.findByRoomId(roomId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
		findByUserId(long userId) {

		return _persistedBookingLocalService.findByUserId(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _persistedBookingLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _persistedBookingLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _persistedBookingLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedBookingLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the persisted booking with the primary key.
	 *
	 * @param bookingId the primary key of the persisted booking
	 * @return the persisted booking
	 * @throws PortalException if a persisted booking with the primary key could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedBooking getPersistedBooking(
			long bookingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedBookingLocalService.getPersistedBooking(bookingId);
	}

	/**
	 * Returns the persisted booking with the matching UUID and company.
	 *
	 * @param uuid the persisted booking's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted booking
	 * @throws PortalException if a matching persisted booking could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedBooking
			getPersistedBookingByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedBookingLocalService.
			getPersistedBookingByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
		getPersistedBookings(int start, int end) {

		return _persistedBookingLocalService.getPersistedBookings(start, end);
	}

	/**
	 * Returns the number of persisted bookings.
	 *
	 * @return the number of persisted bookings
	 */
	@Override
	public int getPersistedBookingsCount() {
		return _persistedBookingLocalService.getPersistedBookingsCount();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedBookingLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
		getPersistedParticipantPersistedBookings(long participantId) {

		return _persistedBookingLocalService.
			getPersistedParticipantPersistedBookings(participantId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
		getPersistedParticipantPersistedBookings(
			long participantId, int start, int end) {

		return _persistedBookingLocalService.
			getPersistedParticipantPersistedBookings(participantId, start, end);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
		getPersistedParticipantPersistedBookings(
			long participantId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<jp.co.liferay.reservation.model.PersistedBooking>
					orderByComparator) {

		return _persistedBookingLocalService.
			getPersistedParticipantPersistedBookings(
				participantId, start, end, orderByComparator);
	}

	@Override
	public int getPersistedParticipantPersistedBookingsCount(
		long participantId) {

		return _persistedBookingLocalService.
			getPersistedParticipantPersistedBookingsCount(participantId);
	}

	/**
	 * Returns the participantIds of the persisted participants associated with the persisted booking.
	 *
	 * @param bookingId the bookingId of the persisted booking
	 * @return long[] the participantIds of persisted participants associated with the persisted booking
	 */
	@Override
	public long[] getPersistedParticipantPrimaryKeys(long bookingId) {
		return _persistedBookingLocalService.getPersistedParticipantPrimaryKeys(
			bookingId);
	}

	@Override
	public boolean hasPersistedParticipantPersistedBooking(
		long participantId, long bookingId) {

		return _persistedBookingLocalService.
			hasPersistedParticipantPersistedBooking(participantId, bookingId);
	}

	@Override
	public boolean hasPersistedParticipantPersistedBookings(
		long participantId) {

		return _persistedBookingLocalService.
			hasPersistedParticipantPersistedBookings(participantId);
	}

	@Override
	public void setPersistedParticipantPersistedBookings(
		long participantId, long[] bookingIds) {

		_persistedBookingLocalService.setPersistedParticipantPersistedBookings(
			participantId, bookingIds);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedBooking
			updatePersistedBooking(
				long bookingId, String title, java.util.Date startDt,
				java.util.Date endDt, long roomId, String description,
				long[] participantIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedBookingLocalService.updatePersistedBooking(
			bookingId, title, startDt, endDt, roomId, description,
			participantIds, serviceContext);
	}

	/**
	 * Updates the persisted booking in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param persistedBooking the persisted booking
	 * @return the persisted booking that was updated
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedBooking
		updatePersistedBooking(
			jp.co.liferay.reservation.model.PersistedBooking persistedBooking) {

		return _persistedBookingLocalService.updatePersistedBooking(
			persistedBooking);
	}

	@Override
	public PersistedBookingLocalService getWrappedService() {
		return _persistedBookingLocalService;
	}

	@Override
	public void setWrappedService(
		PersistedBookingLocalService persistedBookingLocalService) {

		_persistedBookingLocalService = persistedBookingLocalService;
	}

	private PersistedBookingLocalService _persistedBookingLocalService;

}