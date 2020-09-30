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
 * Provides the local service utility for PersistedPurpose. This utility wraps
 * <code>jp.co.liferay.reservation.service.impl.PersistedPurposeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedPurposeLocalService
 * @generated
 */
@ProviderType
public class PersistedPurposeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedPurposeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the persisted purpose to the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedPurpose the persisted purpose
	 * @return the persisted purpose that was added
	 */
	public static jp.co.liferay.reservation.model.PersistedPurpose
		addPersistedPurpose(
			jp.co.liferay.reservation.model.PersistedPurpose persistedPurpose) {

		return getService().addPersistedPurpose(persistedPurpose);
	}

	public static jp.co.liferay.reservation.model.PersistedPurpose
			addPersistedPurpose(
				String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addPersistedPurpose(name, serviceContext);
	}

	public static void addPersistedRoomPersistedPurpose(
		long roomId, long purposeId) {

		getService().addPersistedRoomPersistedPurpose(roomId, purposeId);
	}

	public static void addPersistedRoomPersistedPurpose(
		long roomId,
		jp.co.liferay.reservation.model.PersistedPurpose persistedPurpose) {

		getService().addPersistedRoomPersistedPurpose(roomId, persistedPurpose);
	}

	public static void addPersistedRoomPersistedPurposes(
		long roomId,
		java.util.List<jp.co.liferay.reservation.model.PersistedPurpose>
			persistedPurposes) {

		getService().addPersistedRoomPersistedPurposes(
			roomId, persistedPurposes);
	}

	public static void addPersistedRoomPersistedPurposes(
		long roomId, long[] purposeIds) {

		getService().addPersistedRoomPersistedPurposes(roomId, purposeIds);
	}

	public static void clearPersistedRoomPersistedPurposes(long roomId) {
		getService().clearPersistedRoomPersistedPurposes(roomId);
	}

	/**
	 * Creates a new persisted purpose with the primary key. Does not add the persisted purpose to the database.
	 *
	 * @param purposeId the primary key for the new persisted purpose
	 * @return the new persisted purpose
	 */
	public static jp.co.liferay.reservation.model.PersistedPurpose
		createPersistedPurpose(long purposeId) {

		return getService().createPersistedPurpose(purposeId);
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
	 * Deletes the persisted purpose with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param purposeId the primary key of the persisted purpose
	 * @return the persisted purpose that was removed
	 * @throws PortalException if a persisted purpose with the primary key could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedPurpose
			deletePersistedPurpose(long purposeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedPurpose(purposeId);
	}

	public static jp.co.liferay.reservation.model.PersistedPurpose
			deletePersistedPurpose(
				long purposeId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedPurpose(purposeId, serviceContext);
	}

	/**
	 * Deletes the persisted purpose from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedPurpose the persisted purpose
	 * @return the persisted purpose that was removed
	 */
	public static jp.co.liferay.reservation.model.PersistedPurpose
		deletePersistedPurpose(
			jp.co.liferay.reservation.model.PersistedPurpose persistedPurpose) {

		return getService().deletePersistedPurpose(persistedPurpose);
	}

	public static void deletePersistedRoomPersistedPurpose(
		long roomId, long purposeId) {

		getService().deletePersistedRoomPersistedPurpose(roomId, purposeId);
	}

	public static void deletePersistedRoomPersistedPurpose(
		long roomId,
		jp.co.liferay.reservation.model.PersistedPurpose persistedPurpose) {

		getService().deletePersistedRoomPersistedPurpose(
			roomId, persistedPurpose);
	}

	public static void deletePersistedRoomPersistedPurposes(
		long roomId,
		java.util.List<jp.co.liferay.reservation.model.PersistedPurpose>
			persistedPurposes) {

		getService().deletePersistedRoomPersistedPurposes(
			roomId, persistedPurposes);
	}

	public static void deletePersistedRoomPersistedPurposes(
		long roomId, long[] purposeIds) {

		getService().deletePersistedRoomPersistedPurposes(roomId, purposeIds);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedPurposeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedPurposeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static jp.co.liferay.reservation.model.PersistedPurpose
		fetchPersistedPurpose(long purposeId) {

		return getService().fetchPersistedPurpose(purposeId);
	}

	/**
	 * Returns the persisted purpose with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted purpose's external reference code
	 * @return the matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedPurpose
		fetchPersistedPurposeByReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchPersistedPurposeByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted purpose with the matching UUID and company.
	 *
	 * @param uuid the persisted purpose's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedPurpose
		fetchPersistedPurposeByUuidAndCompanyId(String uuid, long companyId) {

		return getService().fetchPersistedPurposeByUuidAndCompanyId(
			uuid, companyId);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedPurpose> findAll() {

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

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the persisted purpose with the primary key.
	 *
	 * @param purposeId the primary key of the persisted purpose
	 * @return the persisted purpose
	 * @throws PortalException if a persisted purpose with the primary key could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedPurpose
			getPersistedPurpose(long purposeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedPurpose(purposeId);
	}

	/**
	 * Returns the persisted purpose with the matching UUID and company.
	 *
	 * @param uuid the persisted purpose's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted purpose
	 * @throws PortalException if a matching persisted purpose could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedPurpose
			getPersistedPurposeByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedPurposeByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the persisted purposes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedPurposeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @return the range of persisted purposes
	 */
	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedPurpose> getPersistedPurposes(
			int start, int end) {

		return getService().getPersistedPurposes(start, end);
	}

	/**
	 * Returns the number of persisted purposes.
	 *
	 * @return the number of persisted purposes
	 */
	public static int getPersistedPurposesCount() {
		return getService().getPersistedPurposesCount();
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedPurpose>
			getPersistedRoomPersistedPurposes(long roomId) {

		return getService().getPersistedRoomPersistedPurposes(roomId);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedPurpose>
			getPersistedRoomPersistedPurposes(long roomId, int start, int end) {

		return getService().getPersistedRoomPersistedPurposes(
			roomId, start, end);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedPurpose>
			getPersistedRoomPersistedPurposes(
				long roomId, int start, int end,
				com.liferay.portal.kernel.util.OrderByComparator
					<jp.co.liferay.reservation.model.PersistedPurpose>
						orderByComparator) {

		return getService().getPersistedRoomPersistedPurposes(
			roomId, start, end, orderByComparator);
	}

	public static int getPersistedRoomPersistedPurposesCount(long roomId) {
		return getService().getPersistedRoomPersistedPurposesCount(roomId);
	}

	/**
	 * Returns the roomIds of the persisted rooms associated with the persisted purpose.
	 *
	 * @param purposeId the purposeId of the persisted purpose
	 * @return long[] the roomIds of persisted rooms associated with the persisted purpose
	 */
	public static long[] getPersistedRoomPrimaryKeys(long purposeId) {
		return getService().getPersistedRoomPrimaryKeys(purposeId);
	}

	public static boolean hasPersistedRoomPersistedPurpose(
		long roomId, long purposeId) {

		return getService().hasPersistedRoomPersistedPurpose(roomId, purposeId);
	}

	public static boolean hasPersistedRoomPersistedPurposes(long roomId) {
		return getService().hasPersistedRoomPersistedPurposes(roomId);
	}

	public static void setPersistedRoomPersistedPurposes(
		long roomId, long[] purposeIds) {

		getService().setPersistedRoomPersistedPurposes(roomId, purposeIds);
	}

	public static jp.co.liferay.reservation.model.PersistedPurpose
			updatePersistedPurpose(
				long purposeId, String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updatePersistedPurpose(
			purposeId, name, serviceContext);
	}

	/**
	 * Updates the persisted purpose in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param persistedPurpose the persisted purpose
	 * @return the persisted purpose that was updated
	 */
	public static jp.co.liferay.reservation.model.PersistedPurpose
		updatePersistedPurpose(
			jp.co.liferay.reservation.model.PersistedPurpose persistedPurpose) {

		return getService().updatePersistedPurpose(persistedPurpose);
	}

	public static PersistedPurposeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedPurposeLocalService, PersistedPurposeLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PersistedPurposeLocalService.class);

		ServiceTracker
			<PersistedPurposeLocalService, PersistedPurposeLocalService>
				serviceTracker =
					new ServiceTracker
						<PersistedPurposeLocalService,
						 PersistedPurposeLocalService>(
							 bundle.getBundleContext(),
							 PersistedPurposeLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}