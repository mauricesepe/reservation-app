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
 * Provides the local service utility for PersistedOffice. This utility wraps
 * <code>jp.co.liferay.reservation.service.impl.PersistedOfficeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedOfficeLocalService
 * @generated
 */
@ProviderType
public class PersistedOfficeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedOfficeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the persisted office to the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedOffice the persisted office
	 * @return the persisted office that was added
	 */
	public static jp.co.liferay.reservation.model.PersistedOffice
		addPersistedOffice(
			jp.co.liferay.reservation.model.PersistedOffice persistedOffice) {

		return getService().addPersistedOffice(persistedOffice);
	}

	public static jp.co.liferay.reservation.model.PersistedOffice
			addPersistedOffice(
				String name, String location,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addPersistedOffice(name, location, serviceContext);
	}

	/**
	 * Creates a new persisted office with the primary key. Does not add the persisted office to the database.
	 *
	 * @param officeId the primary key for the new persisted office
	 * @return the new persisted office
	 */
	public static jp.co.liferay.reservation.model.PersistedOffice
		createPersistedOffice(long officeId) {

		return getService().createPersistedOffice(officeId);
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
	 * Deletes the persisted office with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officeId the primary key of the persisted office
	 * @return the persisted office that was removed
	 * @throws PortalException if a persisted office with the primary key could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedOffice
			deletePersistedOffice(long officeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedOffice(officeId);
	}

	/**
	 * Deletes the persisted office from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedOffice the persisted office
	 * @return the persisted office that was removed
	 */
	public static jp.co.liferay.reservation.model.PersistedOffice
		deletePersistedOffice(
			jp.co.liferay.reservation.model.PersistedOffice persistedOffice) {

		return getService().deletePersistedOffice(persistedOffice);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedOfficeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedOfficeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static jp.co.liferay.reservation.model.PersistedOffice
		fetchPersistedOffice(long officeId) {

		return getService().fetchPersistedOffice(officeId);
	}

	/**
	 * Returns the persisted office with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted office's external reference code
	 * @return the matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedOffice
		fetchPersistedOfficeByReferenceCode(
			long companyId, String externalReferenceCode) {

		return getService().fetchPersistedOfficeByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted office with the matching UUID and company.
	 *
	 * @param uuid the persisted office's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedOffice
		fetchPersistedOfficeByUuidAndCompanyId(String uuid, long companyId) {

		return getService().fetchPersistedOfficeByUuidAndCompanyId(
			uuid, companyId);
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedOffice> findAll() {

		return getService().findAll();
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

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the persisted office with the primary key.
	 *
	 * @param officeId the primary key of the persisted office
	 * @return the persisted office
	 * @throws PortalException if a persisted office with the primary key could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedOffice
			getPersistedOffice(long officeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedOffice(officeId);
	}

	/**
	 * Returns the persisted office with the matching UUID and company.
	 *
	 * @param uuid the persisted office's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted office
	 * @throws PortalException if a matching persisted office could not be found
	 */
	public static jp.co.liferay.reservation.model.PersistedOffice
			getPersistedOfficeByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedOfficeByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of all the persisted offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedOfficeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @return the range of persisted offices
	 */
	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedOffice> getPersistedOffices(
			int start, int end) {

		return getService().getPersistedOffices(start, end);
	}

	/**
	 * Returns the number of persisted offices.
	 *
	 * @return the number of persisted offices
	 */
	public static int getPersistedOfficesCount() {
		return getService().getPersistedOfficesCount();
	}

	public static jp.co.liferay.reservation.model.PersistedOffice
			updatePersistedOffice(
				long officeId, String name, String location,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updatePersistedOffice(
			officeId, name, location, serviceContext);
	}

	/**
	 * Updates the persisted office in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param persistedOffice the persisted office
	 * @return the persisted office that was updated
	 */
	public static jp.co.liferay.reservation.model.PersistedOffice
		updatePersistedOffice(
			jp.co.liferay.reservation.model.PersistedOffice persistedOffice) {

		return getService().updatePersistedOffice(persistedOffice);
	}

	public static PersistedOfficeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedOfficeLocalService, PersistedOfficeLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PersistedOfficeLocalService.class);

		ServiceTracker<PersistedOfficeLocalService, PersistedOfficeLocalService>
			serviceTracker =
				new ServiceTracker
					<PersistedOfficeLocalService, PersistedOfficeLocalService>(
						bundle.getBundleContext(),
						PersistedOfficeLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}