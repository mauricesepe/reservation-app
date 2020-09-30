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
 * Provides a wrapper for {@link PersistedParticipantLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedParticipantLocalService
 * @generated
 */
@ProviderType
public class PersistedParticipantLocalServiceWrapper
	implements PersistedParticipantLocalService,
			   ServiceWrapper<PersistedParticipantLocalService> {

	public PersistedParticipantLocalServiceWrapper(
		PersistedParticipantLocalService persistedParticipantLocalService) {

		_persistedParticipantLocalService = persistedParticipantLocalService;
	}

	@Override
	public void addPersistedBookingPersistedParticipant(
		long bookingId, long participantId) {

		_persistedParticipantLocalService.
			addPersistedBookingPersistedParticipant(bookingId, participantId);
	}

	@Override
	public void addPersistedBookingPersistedParticipant(
		long bookingId,
		jp.co.liferay.reservation.model.PersistedParticipant
			persistedParticipant) {

		_persistedParticipantLocalService.
			addPersistedBookingPersistedParticipant(
				bookingId, persistedParticipant);
	}

	@Override
	public void addPersistedBookingPersistedParticipants(
		long bookingId,
		java.util.List<jp.co.liferay.reservation.model.PersistedParticipant>
			persistedParticipants) {

		_persistedParticipantLocalService.
			addPersistedBookingPersistedParticipants(
				bookingId, persistedParticipants);
	}

	@Override
	public void addPersistedBookingPersistedParticipants(
		long bookingId, long[] participantIds) {

		_persistedParticipantLocalService.
			addPersistedBookingPersistedParticipants(bookingId, participantIds);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
			addPersistedParticipant(
				long userId, String fullName, String companyName,
				String emailAddress,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedParticipantLocalService.addPersistedParticipant(
			userId, fullName, companyName, emailAddress, serviceContext);
	}

	/**
	 * Adds the persisted participant to the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedParticipant the persisted participant
	 * @return the persisted participant that was added
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
		addPersistedParticipant(
			jp.co.liferay.reservation.model.PersistedParticipant
				persistedParticipant) {

		return _persistedParticipantLocalService.addPersistedParticipant(
			persistedParticipant);
	}

	@Override
	public void clearPersistedBookingPersistedParticipants(long bookingId) {
		_persistedParticipantLocalService.
			clearPersistedBookingPersistedParticipants(bookingId);
	}

	/**
	 * Creates a new persisted participant with the primary key. Does not add the persisted participant to the database.
	 *
	 * @param participantId the primary key for the new persisted participant
	 * @return the new persisted participant
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
		createPersistedParticipant(long participantId) {

		return _persistedParticipantLocalService.createPersistedParticipant(
			participantId);
	}

	@Override
	public void deletePersistedBookingPersistedParticipant(
		long bookingId, long participantId) {

		_persistedParticipantLocalService.
			deletePersistedBookingPersistedParticipant(
				bookingId, participantId);
	}

	@Override
	public void deletePersistedBookingPersistedParticipant(
		long bookingId,
		jp.co.liferay.reservation.model.PersistedParticipant
			persistedParticipant) {

		_persistedParticipantLocalService.
			deletePersistedBookingPersistedParticipant(
				bookingId, persistedParticipant);
	}

	@Override
	public void deletePersistedBookingPersistedParticipants(
		long bookingId,
		java.util.List<jp.co.liferay.reservation.model.PersistedParticipant>
			persistedParticipants) {

		_persistedParticipantLocalService.
			deletePersistedBookingPersistedParticipants(
				bookingId, persistedParticipants);
	}

	@Override
	public void deletePersistedBookingPersistedParticipants(
		long bookingId, long[] participantIds) {

		_persistedParticipantLocalService.
			deletePersistedBookingPersistedParticipants(
				bookingId, participantIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedParticipantLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the persisted participant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param participantId the primary key of the persisted participant
	 * @return the persisted participant that was removed
	 * @throws PortalException if a persisted participant with the primary key could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
			deletePersistedParticipant(long participantId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedParticipantLocalService.deletePersistedParticipant(
			participantId);
	}

	/**
	 * Deletes the persisted participant from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedParticipant the persisted participant
	 * @return the persisted participant that was removed
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
		deletePersistedParticipant(
			jp.co.liferay.reservation.model.PersistedParticipant
				persistedParticipant) {

		return _persistedParticipantLocalService.deletePersistedParticipant(
			persistedParticipant);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _persistedParticipantLocalService.dynamicQuery();
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

		return _persistedParticipantLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _persistedParticipantLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _persistedParticipantLocalService.dynamicQuery(
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

		return _persistedParticipantLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _persistedParticipantLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
		fetchPersistedParticipant(long participantId) {

		return _persistedParticipantLocalService.fetchPersistedParticipant(
			participantId);
	}

	/**
	 * Returns the persisted participant with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted participant's external reference code
	 * @return the matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
		fetchPersistedParticipantByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _persistedParticipantLocalService.
			fetchPersistedParticipantByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted participant with the matching UUID and company.
	 *
	 * @param uuid the persisted participant's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
		fetchPersistedParticipantByUuidAndCompanyId(
			String uuid, long companyId) {

		return _persistedParticipantLocalService.
			fetchPersistedParticipantByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedParticipant>
		findAll() {

		return _persistedParticipantLocalService.findAll();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _persistedParticipantLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _persistedParticipantLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedParticipantLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedParticipant>
		getPersistedBookingPersistedParticipants(long bookingId) {

		return _persistedParticipantLocalService.
			getPersistedBookingPersistedParticipants(bookingId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedParticipant>
		getPersistedBookingPersistedParticipants(
			long bookingId, int start, int end) {

		return _persistedParticipantLocalService.
			getPersistedBookingPersistedParticipants(bookingId, start, end);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedParticipant>
		getPersistedBookingPersistedParticipants(
			long bookingId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<jp.co.liferay.reservation.model.PersistedParticipant>
					orderByComparator) {

		return _persistedParticipantLocalService.
			getPersistedBookingPersistedParticipants(
				bookingId, start, end, orderByComparator);
	}

	@Override
	public int getPersistedBookingPersistedParticipantsCount(long bookingId) {
		return _persistedParticipantLocalService.
			getPersistedBookingPersistedParticipantsCount(bookingId);
	}

	/**
	 * Returns the bookingIds of the persisted bookings associated with the persisted participant.
	 *
	 * @param participantId the participantId of the persisted participant
	 * @return long[] the bookingIds of persisted bookings associated with the persisted participant
	 */
	@Override
	public long[] getPersistedBookingPrimaryKeys(long participantId) {
		return _persistedParticipantLocalService.getPersistedBookingPrimaryKeys(
			participantId);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedParticipantLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the persisted participant with the primary key.
	 *
	 * @param participantId the primary key of the persisted participant
	 * @return the persisted participant
	 * @throws PortalException if a persisted participant with the primary key could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
			getPersistedParticipant(long participantId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedParticipantLocalService.getPersistedParticipant(
			participantId);
	}

	/**
	 * Returns the persisted participant with the matching UUID and company.
	 *
	 * @param uuid the persisted participant's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted participant
	 * @throws PortalException if a matching persisted participant could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
			getPersistedParticipantByUuidAndCompanyId(
				String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedParticipantLocalService.
			getPersistedParticipantByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the persisted participants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @return the range of persisted participants
	 */
	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedParticipant>
		getPersistedParticipants(int start, int end) {

		return _persistedParticipantLocalService.getPersistedParticipants(
			start, end);
	}

	/**
	 * Returns the number of persisted participants.
	 *
	 * @return the number of persisted participants
	 */
	@Override
	public int getPersistedParticipantsCount() {
		return _persistedParticipantLocalService.
			getPersistedParticipantsCount();
	}

	@Override
	public boolean hasPersistedBookingPersistedParticipant(
		long bookingId, long participantId) {

		return _persistedParticipantLocalService.
			hasPersistedBookingPersistedParticipant(bookingId, participantId);
	}

	@Override
	public boolean hasPersistedBookingPersistedParticipants(long bookingId) {
		return _persistedParticipantLocalService.
			hasPersistedBookingPersistedParticipants(bookingId);
	}

	@Override
	public void setPersistedBookingPersistedParticipants(
		long bookingId, long[] participantIds) {

		_persistedParticipantLocalService.
			setPersistedBookingPersistedParticipants(bookingId, participantIds);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
			updatePersistedParticipant(
				long participantId, long userId, String fullName,
				String companyName, String emailAddress,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedParticipantLocalService.updatePersistedParticipant(
			participantId, userId, fullName, companyName, emailAddress,
			serviceContext);
	}

	/**
	 * Updates the persisted participant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param persistedParticipant the persisted participant
	 * @return the persisted participant that was updated
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedParticipant
		updatePersistedParticipant(
			jp.co.liferay.reservation.model.PersistedParticipant
				persistedParticipant) {

		return _persistedParticipantLocalService.updatePersistedParticipant(
			persistedParticipant);
	}

	@Override
	public PersistedParticipantLocalService getWrappedService() {
		return _persistedParticipantLocalService;
	}

	@Override
	public void setWrappedService(
		PersistedParticipantLocalService persistedParticipantLocalService) {

		_persistedParticipantLocalService = persistedParticipantLocalService;
	}

	private PersistedParticipantLocalService _persistedParticipantLocalService;

}