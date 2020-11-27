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
 * Provides the local service utility for PersistedRoom. This utility wraps
 * <code>jp.co.liferay.reservation.service.impl.PersistedRoomLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedRoomLocalService
 * @generated
 */
public class PersistedRoomLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedRoomLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addPersistedAmenityPersistedRoom(
		long amenityId, long roomId) {

		getService().addPersistedAmenityPersistedRoom(amenityId, roomId);
	}

	public static void addPersistedAmenityPersistedRoom(
		long amenityId,
		jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		getService().addPersistedAmenityPersistedRoom(amenityId, persistedRoom);
	}

	public static void addPersistedAmenityPersistedRooms(
		long amenityId,
		java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
			persistedRooms) {

		getService().addPersistedAmenityPersistedRooms(
			amenityId, persistedRooms);
	}

	public static void addPersistedAmenityPersistedRooms(
		long amenityId, long[] roomIds) {

		getService().addPersistedAmenityPersistedRooms(amenityId, roomIds);
	}

	public static void addPersistedPurposePersistedRoom(
		long purposeId, long roomId) {

		getService().addPersistedPurposePersistedRoom(purposeId, roomId);
	}

	public static void addPersistedPurposePersistedRoom(
		long purposeId,
		jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		getService().addPersistedPurposePersistedRoom(purposeId, persistedRoom);
	}

	public static void addPersistedPurposePersistedRooms(
		long purposeId,
		java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
			persistedRooms) {

		getService().addPersistedPurposePersistedRooms(
			purposeId, persistedRooms);
	}

	public static void addPersistedPurposePersistedRooms(
		long purposeId, long[] roomIds) {

		getService().addPersistedPurposePersistedRooms(purposeId, roomIds);
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
	public static jp.co.liferay.reservation.model.PersistedRoom
		addPersistedRoom(
			jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		return getService().addPersistedRoom(persistedRoom);
	}

	public static jp.co.liferay.reservation.model.PersistedRoom
			addPersistedRoom(
				String name, String photoPath, boolean availableSunday,
				boolean availableMonday, boolean availableTuesday,
				boolean availableWednesday, boolean availableThursday,
				boolean availableFriday, boolean availableSaturday,
				int availableStartTime, int availableEndTime, long officeId,
				double capacitySquareMeters, int capacityPeople,
				int phoneExtension, String wifiSSID, int wifiSecurityType,
				String wifiPassword, long[] amenitiesIds, long[] purposeIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addPersistedRoom(
			name, photoPath, availableSunday, availableMonday, availableTuesday,
			availableWednesday, availableThursday, availableFriday,
			availableSaturday, availableStartTime, availableEndTime, officeId,
			capacitySquareMeters, capacityPeople, phoneExtension, wifiSSID,
			wifiSecurityType, wifiPassword, amenitiesIds, purposeIds,
			serviceContext);
	}

	public static void clearPersistedAmenityPersistedRooms(long amenityId) {
		getService().clearPersistedAmenityPersistedRooms(amenityId);
	}

	public static void clearPersistedPurposePersistedRooms(long purposeId) {
		getService().clearPersistedPurposePersistedRooms(purposeId);
	}

	/**
	 * Creates a new persisted room with the primary key. Does not add the persisted room to the database.
	 *
	 * @param roomId the primary key for the new persisted room
	 * @return the new persisted room
	 */
	public static jp.co.liferay.reservation.model.PersistedRoom
		createPersistedRoom(long roomId) {

		return getService().createPersistedRoom(roomId);
	}

	public static void deletePersistedAmenityPersistedRoom(
		long amenityId, long roomId) {

		getService().deletePersistedAmenityPersistedRoom(amenityId, roomId);
	}

	public static void deletePersistedAmenityPersistedRoom(
		long amenityId,
		jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		getService().deletePersistedAmenityPersistedRoom(
			amenityId, persistedRoom);
	}

	public static void deletePersistedAmenityPersistedRooms(
		long amenityId,
		java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
			persistedRooms) {

		getService().deletePersistedAmenityPersistedRooms(
			amenityId, persistedRooms);
	}

	public static void deletePersistedAmenityPersistedRooms(
		long amenityId, long[] roomIds) {

		getService().deletePersistedAmenityPersistedRooms(amenityId, roomIds);
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

	public static void deletePersistedPurposePersistedRoom(
		long purposeId, long roomId) {

		getService().deletePersistedPurposePersistedRoom(purposeId, roomId);
	}

	public static void deletePersistedPurposePersistedRoom(
		long purposeId,
		jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		getService().deletePersistedPurposePersistedRoom(
			purposeId, persistedRoom);
	}

	public static void deletePersistedPurposePersistedRooms(
		long purposeId,
		java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
			persistedRooms) {

		getService().deletePersistedPurposePersistedRooms(
			purposeId, persistedRooms);
	}

	public static void deletePersistedPurposePersistedRooms(
		long purposeId, long[] roomIds) {

		getService().deletePersistedPurposePersistedRooms(purposeId, roomIds);
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
	public static jp.co.liferay.reservation.model.PersistedRoom
			deletePersistedRoom(long roomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedRoom(roomId);
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
	public static jp.co.liferay.reservation.model.PersistedRoom
		deletePersistedRoom(
			jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		return getService().deletePersistedRoom(persistedRoom);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedRoomModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedRoomModelImpl</code>.
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

	public static jp.co.liferay.reservation.model.PersistedRoom
		fetchPersistedRoom(long roomId) {

		return getService().fetchPersistedRoom(roomId);
	}

	/**
	 * Returns the persisted room with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted room's external reference code
	 * @return the matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedRoom
		fetchPersistedRoomByReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchPersistedRoomByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted room with the matching UUID and company.
	 *
	 * @param uuid the persisted room's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedRoom
		fetchPersistedRoomByUuidAndCompanyId(String uuid, long companyId) {

		return getService().fetchPersistedRoomByUuidAndCompanyId(
			uuid, companyId);
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		findAll() {

		return getService().findAll();
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		findByCalendarId(long calendarId) {

		return getService().findByCalendarId(calendarId);
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		findByOfficeId(long officeId) {

		return getService().findByOfficeId(officeId);
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

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedAmenityPersistedRooms(long amenityId) {

		return getService().getPersistedAmenityPersistedRooms(amenityId);
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedAmenityPersistedRooms(long amenityId, int start, int end) {

		return getService().getPersistedAmenityPersistedRooms(
			amenityId, start, end);
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedAmenityPersistedRooms(
			long amenityId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<jp.co.liferay.reservation.model.PersistedRoom>
					orderByComparator) {

		return getService().getPersistedAmenityPersistedRooms(
			amenityId, start, end, orderByComparator);
	}

	public static int getPersistedAmenityPersistedRoomsCount(long amenityId) {
		return getService().getPersistedAmenityPersistedRoomsCount(amenityId);
	}

	/**
	 * Returns the amenityIds of the persisted amenities associated with the persisted room.
	 *
	 * @param roomId the roomId of the persisted room
	 * @return long[] the amenityIds of persisted amenities associated with the persisted room
	 */
	public static long[] getPersistedAmenityPrimaryKeys(long roomId) {
		return getService().getPersistedAmenityPrimaryKeys(roomId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedPurposePersistedRooms(long purposeId) {

		return getService().getPersistedPurposePersistedRooms(purposeId);
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedPurposePersistedRooms(long purposeId, int start, int end) {

		return getService().getPersistedPurposePersistedRooms(
			purposeId, start, end);
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedPurposePersistedRooms(
			long purposeId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<jp.co.liferay.reservation.model.PersistedRoom>
					orderByComparator) {

		return getService().getPersistedPurposePersistedRooms(
			purposeId, start, end, orderByComparator);
	}

	public static int getPersistedPurposePersistedRoomsCount(long purposeId) {
		return getService().getPersistedPurposePersistedRoomsCount(purposeId);
	}

	/**
	 * Returns the purposeIds of the persisted purposes associated with the persisted room.
	 *
	 * @param roomId the roomId of the persisted room
	 * @return long[] the purposeIds of persisted purposes associated with the persisted room
	 */
	public static long[] getPersistedPurposePrimaryKeys(long roomId) {
		return getService().getPersistedPurposePrimaryKeys(roomId);
	}

	/**
	 * Returns the persisted room with the primary key.
	 *
	 * @param roomId the primary key of the persisted room
	 * @return the persisted room
	 * @throws PortalException if a persisted room with the primary key could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedRoom
			getPersistedRoom(long roomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedRoom(roomId);
	}

	/**
	 * Returns the persisted room with the matching UUID and company.
	 *
	 * @param uuid the persisted room's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted room
	 * @throws PortalException if a matching persisted room could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedRoom
			getPersistedRoomByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedRoomByUuidAndCompanyId(uuid, companyId);
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
	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedRooms(int start, int end) {

		return getService().getPersistedRooms(start, end);
	}

	/**
	 * Returns the number of persisted rooms.
	 *
	 * @return the number of persisted rooms
	 */
	public static int getPersistedRoomsCount() {
		return getService().getPersistedRoomsCount();
	}

	public static boolean hasPersistedAmenityPersistedRoom(
		long amenityId, long roomId) {

		return getService().hasPersistedAmenityPersistedRoom(amenityId, roomId);
	}

	public static boolean hasPersistedAmenityPersistedRooms(long amenityId) {
		return getService().hasPersistedAmenityPersistedRooms(amenityId);
	}

	public static boolean hasPersistedPurposePersistedRoom(
		long purposeId, long roomId) {

		return getService().hasPersistedPurposePersistedRoom(purposeId, roomId);
	}

	public static boolean hasPersistedPurposePersistedRooms(long purposeId) {
		return getService().hasPersistedPurposePersistedRooms(purposeId);
	}

	public static void setPersistedAmenityPersistedRooms(
		long amenityId, long[] roomIds) {

		getService().setPersistedAmenityPersistedRooms(amenityId, roomIds);
	}

	public static void setPersistedPurposePersistedRooms(
		long purposeId, long[] roomIds) {

		getService().setPersistedPurposePersistedRooms(purposeId, roomIds);
	}

	public static jp.co.liferay.reservation.model.PersistedRoom
			updatePersistedRoom(
				long roomId, String name, String photoPath,
				boolean availableSunday, boolean availableMonday,
				boolean availableTuesday, boolean availableWednesday,
				boolean availableThursday, boolean availableFriday,
				boolean availableSaturday, int availableStartTime,
				int availableEndTime, long officeId,
				double capacitySquareMeters, int capacityPeople,
				int phoneExtension, String wifiSSID, int wifiSecurityType,
				String wifiPassword, long[] amenitiesIds, long[] purposeIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updatePersistedRoom(
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
	public static jp.co.liferay.reservation.model.PersistedRoom
		updatePersistedRoom(
			jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		return getService().updatePersistedRoom(persistedRoom);
	}

	public static PersistedRoomLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedRoomLocalService, PersistedRoomLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PersistedRoomLocalService.class);

		ServiceTracker<PersistedRoomLocalService, PersistedRoomLocalService>
			serviceTracker =
				new ServiceTracker
					<PersistedRoomLocalService, PersistedRoomLocalService>(
						bundle.getBundleContext(),
						PersistedRoomLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}