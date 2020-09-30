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
 * Provides the local service utility for PersistedAmenity. This utility wraps
 * <code>jp.co.liferay.reservation.service.impl.PersistedAmenityLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedAmenityLocalService
 * @generated
 */
@ProviderType
public class PersistedAmenityLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedAmenityLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the persisted amenity to the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedAmenity the persisted amenity
	 * @return the persisted amenity that was added
	 */
	public static jp.co.liferay.reservation.model.PersistedAmenity
		addPersistedAmenity(
			jp.co.liferay.reservation.model.PersistedAmenity persistedAmenity) {

		return getService().addPersistedAmenity(persistedAmenity);
	}

	public static jp.co.liferay.reservation.model.PersistedAmenity
			addPersistedAmenity(
				String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addPersistedAmenity(name, serviceContext);
	}

	public static void addPersistedRoomPersistedAmenities(
		long roomId,
		java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
			persistedAmenities) {

		getService().addPersistedRoomPersistedAmenities(
			roomId, persistedAmenities);
	}

	public static void addPersistedRoomPersistedAmenities(
		long roomId, long[] amenityIds) {

		getService().addPersistedRoomPersistedAmenities(roomId, amenityIds);
	}

	public static void addPersistedRoomPersistedAmenity(
		long roomId, long amenityId) {

		getService().addPersistedRoomPersistedAmenity(roomId, amenityId);
	}

	public static void addPersistedRoomPersistedAmenity(
		long roomId,
		jp.co.liferay.reservation.model.PersistedAmenity persistedAmenity) {

		getService().addPersistedRoomPersistedAmenity(roomId, persistedAmenity);
	}

	public static void clearPersistedRoomPersistedAmenities(long roomId) {
		getService().clearPersistedRoomPersistedAmenities(roomId);
	}

	/**
	 * Creates a new persisted amenity with the primary key. Does not add the persisted amenity to the database.
	 *
	 * @param amenityId the primary key for the new persisted amenity
	 * @return the new persisted amenity
	 */
	public static jp.co.liferay.reservation.model.PersistedAmenity
		createPersistedAmenity(long amenityId) {

		return getService().createPersistedAmenity(amenityId);
	}

	/**
	 * Deletes the persisted amenity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amenityId the primary key of the persisted amenity
	 * @return the persisted amenity that was removed
	 * @throws PortalException if a persisted amenity with the primary key could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedAmenity
			deletePersistedAmenity(long amenityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedAmenity(amenityId);
	}

	/**
	 * Deletes the persisted amenity from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedAmenity the persisted amenity
	 * @return the persisted amenity that was removed
	 */
	public static jp.co.liferay.reservation.model.PersistedAmenity
		deletePersistedAmenity(
			jp.co.liferay.reservation.model.PersistedAmenity persistedAmenity) {

		return getService().deletePersistedAmenity(persistedAmenity);
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

	public static void deletePersistedRoomPersistedAmenities(
		long roomId,
		java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
			persistedAmenities) {

		getService().deletePersistedRoomPersistedAmenities(
			roomId, persistedAmenities);
	}

	public static void deletePersistedRoomPersistedAmenities(
		long roomId, long[] amenityIds) {

		getService().deletePersistedRoomPersistedAmenities(roomId, amenityIds);
	}

	public static void deletePersistedRoomPersistedAmenity(
		long roomId, long amenityId) {

		getService().deletePersistedRoomPersistedAmenity(roomId, amenityId);
	}

	public static void deletePersistedRoomPersistedAmenity(
		long roomId,
		jp.co.liferay.reservation.model.PersistedAmenity persistedAmenity) {

		getService().deletePersistedRoomPersistedAmenity(
			roomId, persistedAmenity);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedAmenityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedAmenityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static jp.co.liferay.reservation.model.PersistedAmenity
		fetchPersistedAmenity(long amenityId) {

		return getService().fetchPersistedAmenity(amenityId);
	}

	/**
	 * Returns the persisted amenity with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted amenity's external reference code
	 * @return the matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedAmenity
		fetchPersistedAmenityByReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchPersistedAmenityByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted amenity with the matching UUID and company.
	 *
	 * @param uuid the persisted amenity's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedAmenity
		fetchPersistedAmenityByUuidAndCompanyId(String uuid, long companyId) {

		return getService().fetchPersistedAmenityByUuidAndCompanyId(
			uuid, companyId);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedAmenity> findAll() {

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

	/**
	 * Returns a range of all the persisted amenities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedAmenityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @return the range of persisted amenities
	 */
	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedAmenity>
			getPersistedAmenities(int start, int end) {

		return getService().getPersistedAmenities(start, end);
	}

	/**
	 * Returns the number of persisted amenities.
	 *
	 * @return the number of persisted amenities
	 */
	public static int getPersistedAmenitiesCount() {
		return getService().getPersistedAmenitiesCount();
	}

	/**
	 * Returns the persisted amenity with the primary key.
	 *
	 * @param amenityId the primary key of the persisted amenity
	 * @return the persisted amenity
	 * @throws PortalException if a persisted amenity with the primary key could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedAmenity
			getPersistedAmenity(long amenityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedAmenity(amenityId);
	}

	/**
	 * Returns the persisted amenity with the matching UUID and company.
	 *
	 * @param uuid the persisted amenity's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted amenity
	 * @throws PortalException if a matching persisted amenity could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedAmenity
			getPersistedAmenityByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedAmenityByUuidAndCompanyId(
			uuid, companyId);
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedAmenity>
			getPersistedRoomPersistedAmenities(long roomId) {

		return getService().getPersistedRoomPersistedAmenities(roomId);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedAmenity>
			getPersistedRoomPersistedAmenities(
				long roomId, int start, int end) {

		return getService().getPersistedRoomPersistedAmenities(
			roomId, start, end);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedAmenity>
			getPersistedRoomPersistedAmenities(
				long roomId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<jp.co.liferay.reservation.model.PersistedAmenity>
						orderByComparator) {

		return getService().getPersistedRoomPersistedAmenities(
			roomId, start, end, orderByComparator);
	}

	public static int getPersistedRoomPersistedAmenitiesCount(long roomId) {
		return getService().getPersistedRoomPersistedAmenitiesCount(roomId);
	}

	/**
	 * Returns the roomIds of the persisted rooms associated with the persisted amenity.
	 *
	 * @param amenityId the amenityId of the persisted amenity
	 * @return long[] the roomIds of persisted rooms associated with the persisted amenity
	 */
	public static long[] getPersistedRoomPrimaryKeys(long amenityId) {
		return getService().getPersistedRoomPrimaryKeys(amenityId);
	}

	public static boolean hasPersistedRoomPersistedAmenities(long roomId) {
		return getService().hasPersistedRoomPersistedAmenities(roomId);
	}

	public static boolean hasPersistedRoomPersistedAmenity(
		long roomId, long amenityId) {

		return getService().hasPersistedRoomPersistedAmenity(roomId, amenityId);
	}

	public static void setPersistedRoomPersistedAmenities(
		long roomId, long[] amenityIds) {

		getService().setPersistedRoomPersistedAmenities(roomId, amenityIds);
	}

	public static jp.co.liferay.reservation.model.PersistedAmenity
			updatePersistedAmenity(
				long amenityId, String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updatePersistedAmenity(
			amenityId, name, serviceContext);
	}

	/**
	 * Updates the persisted amenity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param persistedAmenity the persisted amenity
	 * @return the persisted amenity that was updated
	 */
	public static jp.co.liferay.reservation.model.PersistedAmenity
		updatePersistedAmenity(
			jp.co.liferay.reservation.model.PersistedAmenity persistedAmenity) {

		return getService().updatePersistedAmenity(persistedAmenity);
	}

	public static PersistedAmenityLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedAmenityLocalService, PersistedAmenityLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PersistedAmenityLocalService.class);

		ServiceTracker
			<PersistedAmenityLocalService, PersistedAmenityLocalService>
				serviceTracker =
					new ServiceTracker
						<PersistedAmenityLocalService,
						 PersistedAmenityLocalService>(
							 bundle.getBundleContext(),
							 PersistedAmenityLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}