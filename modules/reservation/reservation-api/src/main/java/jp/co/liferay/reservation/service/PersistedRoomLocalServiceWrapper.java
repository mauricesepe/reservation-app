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

/**
 * Provides a wrapper for {@link PersistedRoomLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedRoomLocalService
 * @generated
 */
public class PersistedRoomLocalServiceWrapper
	implements PersistedRoomLocalService,
			   ServiceWrapper<PersistedRoomLocalService> {

	public PersistedRoomLocalServiceWrapper(
		PersistedRoomLocalService persistedRoomLocalService) {

		_persistedRoomLocalService = persistedRoomLocalService;
	}

	@Override
	public void addPersistedAmenityPersistedRoom(long amenityId, long roomId) {
		_persistedRoomLocalService.addPersistedAmenityPersistedRoom(
			amenityId, roomId);
	}

	@Override
	public void addPersistedAmenityPersistedRoom(
		long amenityId,
		jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		_persistedRoomLocalService.addPersistedAmenityPersistedRoom(
			amenityId, persistedRoom);
	}

	@Override
	public void addPersistedAmenityPersistedRooms(
		long amenityId,
		java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
			persistedRooms) {

		_persistedRoomLocalService.addPersistedAmenityPersistedRooms(
			amenityId, persistedRooms);
	}

	@Override
	public void addPersistedAmenityPersistedRooms(
		long amenityId, long[] roomIds) {

		_persistedRoomLocalService.addPersistedAmenityPersistedRooms(
			amenityId, roomIds);
	}

	@Override
	public void addPersistedPurposePersistedRoom(long purposeId, long roomId) {
		_persistedRoomLocalService.addPersistedPurposePersistedRoom(
			purposeId, roomId);
	}

	@Override
	public void addPersistedPurposePersistedRoom(
		long purposeId,
		jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		_persistedRoomLocalService.addPersistedPurposePersistedRoom(
			purposeId, persistedRoom);
	}

	@Override
	public void addPersistedPurposePersistedRooms(
		long purposeId,
		java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
			persistedRooms) {

		_persistedRoomLocalService.addPersistedPurposePersistedRooms(
			purposeId, persistedRooms);
	}

	@Override
	public void addPersistedPurposePersistedRooms(
		long purposeId, long[] roomIds) {

		_persistedRoomLocalService.addPersistedPurposePersistedRooms(
			purposeId, roomIds);
	}

	/**
	 * Adds the persisted room to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedRoomLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedRoom the persisted room
	 * @return the persisted room that was added
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedRoom addPersistedRoom(
		jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		return _persistedRoomLocalService.addPersistedRoom(persistedRoom);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedRoom addPersistedRoom(
			String name, String photoPath, boolean availableSunday,
			boolean availableMonday, boolean availableTuesday,
			boolean availableWednesday, boolean availableThursday,
			boolean availableFriday, boolean availableSaturday,
			int availableStartTime, int availableEndTime, long officeId,
			double capacitySquareMeters, int capacityPeople, int phoneExtension,
			String wifiSSID, int wifiSecurityType, String wifiPassword,
			long[] amenitiesIds, long[] purposeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedRoomLocalService.addPersistedRoom(
			name, photoPath, availableSunday, availableMonday, availableTuesday,
			availableWednesday, availableThursday, availableFriday,
			availableSaturday, availableStartTime, availableEndTime, officeId,
			capacitySquareMeters, capacityPeople, phoneExtension, wifiSSID,
			wifiSecurityType, wifiPassword, amenitiesIds, purposeIds,
			serviceContext);
	}

	@Override
	public void clearPersistedAmenityPersistedRooms(long amenityId) {
		_persistedRoomLocalService.clearPersistedAmenityPersistedRooms(
			amenityId);
	}

	@Override
	public void clearPersistedPurposePersistedRooms(long purposeId) {
		_persistedRoomLocalService.clearPersistedPurposePersistedRooms(
			purposeId);
	}

	/**
	 * Creates a new persisted room with the primary key. Does not add the persisted room to the database.
	 *
	 * @param roomId the primary key for the new persisted room
	 * @return the new persisted room
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedRoom createPersistedRoom(
		long roomId) {

		return _persistedRoomLocalService.createPersistedRoom(roomId);
	}

	@Override
	public void deletePersistedAmenityPersistedRoom(
		long amenityId, long roomId) {

		_persistedRoomLocalService.deletePersistedAmenityPersistedRoom(
			amenityId, roomId);
	}

	@Override
	public void deletePersistedAmenityPersistedRoom(
		long amenityId,
		jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		_persistedRoomLocalService.deletePersistedAmenityPersistedRoom(
			amenityId, persistedRoom);
	}

	@Override
	public void deletePersistedAmenityPersistedRooms(
		long amenityId,
		java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
			persistedRooms) {

		_persistedRoomLocalService.deletePersistedAmenityPersistedRooms(
			amenityId, persistedRooms);
	}

	@Override
	public void deletePersistedAmenityPersistedRooms(
		long amenityId, long[] roomIds) {

		_persistedRoomLocalService.deletePersistedAmenityPersistedRooms(
			amenityId, roomIds);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedRoomLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deletePersistedPurposePersistedRoom(
		long purposeId, long roomId) {

		_persistedRoomLocalService.deletePersistedPurposePersistedRoom(
			purposeId, roomId);
	}

	@Override
	public void deletePersistedPurposePersistedRoom(
		long purposeId,
		jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		_persistedRoomLocalService.deletePersistedPurposePersistedRoom(
			purposeId, persistedRoom);
	}

	@Override
	public void deletePersistedPurposePersistedRooms(
		long purposeId,
		java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
			persistedRooms) {

		_persistedRoomLocalService.deletePersistedPurposePersistedRooms(
			purposeId, persistedRooms);
	}

	@Override
	public void deletePersistedPurposePersistedRooms(
		long purposeId, long[] roomIds) {

		_persistedRoomLocalService.deletePersistedPurposePersistedRooms(
			purposeId, roomIds);
	}

	/**
	 * Deletes the persisted room with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedRoomLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param roomId the primary key of the persisted room
	 * @return the persisted room that was removed
	 * @throws PortalException if a persisted room with the primary key could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedRoom deletePersistedRoom(
			long roomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedRoomLocalService.deletePersistedRoom(roomId);
	}

	/**
	 * Deletes the persisted room from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedRoomLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedRoom the persisted room
	 * @return the persisted room that was removed
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedRoom deletePersistedRoom(
		jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		return _persistedRoomLocalService.deletePersistedRoom(persistedRoom);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _persistedRoomLocalService.dynamicQuery();
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

		return _persistedRoomLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedRoomModelImpl</code>.
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

		return _persistedRoomLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedRoomModelImpl</code>.
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

		return _persistedRoomLocalService.dynamicQuery(
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

		return _persistedRoomLocalService.dynamicQueryCount(dynamicQuery);
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

		return _persistedRoomLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedRoom fetchPersistedRoom(
		long roomId) {

		return _persistedRoomLocalService.fetchPersistedRoom(roomId);
	}

	/**
	 * Returns the persisted room with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted room's external reference code
	 * @return the matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedRoom
		fetchPersistedRoomByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _persistedRoomLocalService.fetchPersistedRoomByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted room with the matching UUID and company.
	 *
	 * @param uuid the persisted room's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedRoom
		fetchPersistedRoomByUuidAndCompanyId(String uuid, long companyId) {

		return _persistedRoomLocalService.fetchPersistedRoomByUuidAndCompanyId(
			uuid, companyId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		findAll() {

		return _persistedRoomLocalService.findAll();
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		findByCalendarId(long calendarId) {

		return _persistedRoomLocalService.findByCalendarId(calendarId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		findByOfficeId(long officeId) {

		return _persistedRoomLocalService.findByOfficeId(officeId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _persistedRoomLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _persistedRoomLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _persistedRoomLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedRoomLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedAmenityPersistedRooms(long amenityId) {

		return _persistedRoomLocalService.getPersistedAmenityPersistedRooms(
			amenityId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedAmenityPersistedRooms(long amenityId, int start, int end) {

		return _persistedRoomLocalService.getPersistedAmenityPersistedRooms(
			amenityId, start, end);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedAmenityPersistedRooms(
			long amenityId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<jp.co.liferay.reservation.model.PersistedRoom>
					orderByComparator) {

		return _persistedRoomLocalService.getPersistedAmenityPersistedRooms(
			amenityId, start, end, orderByComparator);
	}

	@Override
	public int getPersistedAmenityPersistedRoomsCount(long amenityId) {
		return _persistedRoomLocalService.
			getPersistedAmenityPersistedRoomsCount(amenityId);
	}

	/**
	 * Returns the amenityIds of the persisted amenities associated with the persisted room.
	 *
	 * @param roomId the roomId of the persisted room
	 * @return long[] the amenityIds of persisted amenities associated with the persisted room
	 */
	@Override
	public long[] getPersistedAmenityPrimaryKeys(long roomId) {
		return _persistedRoomLocalService.getPersistedAmenityPrimaryKeys(
			roomId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedRoomLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedPurposePersistedRooms(long purposeId) {

		return _persistedRoomLocalService.getPersistedPurposePersistedRooms(
			purposeId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedPurposePersistedRooms(long purposeId, int start, int end) {

		return _persistedRoomLocalService.getPersistedPurposePersistedRooms(
			purposeId, start, end);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedPurposePersistedRooms(
			long purposeId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<jp.co.liferay.reservation.model.PersistedRoom>
					orderByComparator) {

		return _persistedRoomLocalService.getPersistedPurposePersistedRooms(
			purposeId, start, end, orderByComparator);
	}

	@Override
	public int getPersistedPurposePersistedRoomsCount(long purposeId) {
		return _persistedRoomLocalService.
			getPersistedPurposePersistedRoomsCount(purposeId);
	}

	/**
	 * Returns the purposeIds of the persisted purposes associated with the persisted room.
	 *
	 * @param roomId the roomId of the persisted room
	 * @return long[] the purposeIds of persisted purposes associated with the persisted room
	 */
	@Override
	public long[] getPersistedPurposePrimaryKeys(long roomId) {
		return _persistedRoomLocalService.getPersistedPurposePrimaryKeys(
			roomId);
	}

	/**
	 * Returns the persisted room with the primary key.
	 *
	 * @param roomId the primary key of the persisted room
	 * @return the persisted room
	 * @throws PortalException if a persisted room with the primary key could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedRoom getPersistedRoom(
			long roomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedRoomLocalService.getPersistedRoom(roomId);
	}

	/**
	 * Returns the persisted room with the matching UUID and company.
	 *
	 * @param uuid the persisted room's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted room
	 * @throws PortalException if a matching persisted room could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedRoom
			getPersistedRoomByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedRoomLocalService.getPersistedRoomByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the persisted rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of persisted rooms
	 */
	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedRooms(int start, int end) {

		return _persistedRoomLocalService.getPersistedRooms(start, end);
	}

	/**
	 * Returns the number of persisted rooms.
	 *
	 * @return the number of persisted rooms
	 */
	@Override
	public int getPersistedRoomsCount() {
		return _persistedRoomLocalService.getPersistedRoomsCount();
	}

	@Override
	public boolean hasPersistedAmenityPersistedRoom(
		long amenityId, long roomId) {

		return _persistedRoomLocalService.hasPersistedAmenityPersistedRoom(
			amenityId, roomId);
	}

	@Override
	public boolean hasPersistedAmenityPersistedRooms(long amenityId) {
		return _persistedRoomLocalService.hasPersistedAmenityPersistedRooms(
			amenityId);
	}

	@Override
	public boolean hasPersistedPurposePersistedRoom(
		long purposeId, long roomId) {

		return _persistedRoomLocalService.hasPersistedPurposePersistedRoom(
			purposeId, roomId);
	}

	@Override
	public boolean hasPersistedPurposePersistedRooms(long purposeId) {
		return _persistedRoomLocalService.hasPersistedPurposePersistedRooms(
			purposeId);
	}

	@Override
	public void setPersistedAmenityPersistedRooms(
		long amenityId, long[] roomIds) {

		_persistedRoomLocalService.setPersistedAmenityPersistedRooms(
			amenityId, roomIds);
	}

	@Override
	public void setPersistedPurposePersistedRooms(
		long purposeId, long[] roomIds) {

		_persistedRoomLocalService.setPersistedPurposePersistedRooms(
			purposeId, roomIds);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedRoom updatePersistedRoom(
			long roomId, String name, String photoPath, boolean availableSunday,
			boolean availableMonday, boolean availableTuesday,
			boolean availableWednesday, boolean availableThursday,
			boolean availableFriday, boolean availableSaturday,
			int availableStartTime, int availableEndTime, long officeId,
			double capacitySquareMeters, int capacityPeople, int phoneExtension,
			String wifiSSID, int wifiSecurityType, String wifiPassword,
			long[] amenitiesIds, long[] purposeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedRoomLocalService.updatePersistedRoom(
			roomId, name, photoPath, availableSunday, availableMonday,
			availableTuesday, availableWednesday, availableThursday,
			availableFriday, availableSaturday, availableStartTime,
			availableEndTime, officeId, capacitySquareMeters, capacityPeople,
			phoneExtension, wifiSSID, wifiSecurityType, wifiPassword,
			amenitiesIds, purposeIds, serviceContext);
	}

	/**
	 * Updates the persisted room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedRoomLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedRoom the persisted room
	 * @return the persisted room that was updated
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedRoom updatePersistedRoom(
		jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		return _persistedRoomLocalService.updatePersistedRoom(persistedRoom);
	}

	@Override
	public PersistedRoomLocalService getWrappedService() {
		return _persistedRoomLocalService;
	}

	@Override
	public void setWrappedService(
		PersistedRoomLocalService persistedRoomLocalService) {

		_persistedRoomLocalService = persistedRoomLocalService;
	}

	private PersistedRoomLocalService _persistedRoomLocalService;

}