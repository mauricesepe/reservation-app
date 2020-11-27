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
 * Provides a wrapper for {@link PersistedOfficeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedOfficeLocalService
 * @generated
 */
public class PersistedOfficeLocalServiceWrapper
	implements PersistedOfficeLocalService,
			   ServiceWrapper<PersistedOfficeLocalService> {

	public PersistedOfficeLocalServiceWrapper(
		PersistedOfficeLocalService persistedOfficeLocalService) {

		_persistedOfficeLocalService = persistedOfficeLocalService;
	}

	/**
	 * Adds the persisted office to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedOfficeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedOffice the persisted office
	 * @return the persisted office that was added
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedOffice addPersistedOffice(
		jp.co.liferay.reservation.model.PersistedOffice persistedOffice) {

		return _persistedOfficeLocalService.addPersistedOffice(persistedOffice);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedOffice addPersistedOffice(
			String name, String location,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedOfficeLocalService.addPersistedOffice(
			name, location, serviceContext);
	}

	/**
	 * Creates a new persisted office with the primary key. Does not add the persisted office to the database.
	 *
	 * @param officeId the primary key for the new persisted office
	 * @return the new persisted office
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedOffice
		createPersistedOffice(long officeId) {

		return _persistedOfficeLocalService.createPersistedOffice(officeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedOfficeLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the persisted office with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedOfficeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param officeId the primary key of the persisted office
	 * @return the persisted office that was removed
	 * @throws PortalException if a persisted office with the primary key could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedOffice
			deletePersistedOffice(long officeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedOfficeLocalService.deletePersistedOffice(officeId);
	}

	/**
	 * Deletes the persisted office from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedOfficeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedOffice the persisted office
	 * @return the persisted office that was removed
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedOffice
		deletePersistedOffice(
			jp.co.liferay.reservation.model.PersistedOffice persistedOffice) {

		return _persistedOfficeLocalService.deletePersistedOffice(
			persistedOffice);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _persistedOfficeLocalService.dynamicQuery();
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

		return _persistedOfficeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedOfficeModelImpl</code>.
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

		return _persistedOfficeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedOfficeModelImpl</code>.
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

		return _persistedOfficeLocalService.dynamicQuery(
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

		return _persistedOfficeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _persistedOfficeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedOffice fetchPersistedOffice(
		long officeId) {

		return _persistedOfficeLocalService.fetchPersistedOffice(officeId);
	}

	/**
	 * Returns the persisted office with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted office's external reference code
	 * @return the matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedOffice
		fetchPersistedOfficeByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _persistedOfficeLocalService.fetchPersistedOfficeByReferenceCode(
			companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted office with the matching UUID and company.
	 *
	 * @param uuid the persisted office's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedOffice
		fetchPersistedOfficeByUuidAndCompanyId(String uuid, long companyId) {

		return _persistedOfficeLocalService.
			fetchPersistedOfficeByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedOffice>
		findAll() {

		return _persistedOfficeLocalService.findAll();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _persistedOfficeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _persistedOfficeLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _persistedOfficeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedOfficeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedOfficeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the persisted office with the primary key.
	 *
	 * @param officeId the primary key of the persisted office
	 * @return the persisted office
	 * @throws PortalException if a persisted office with the primary key could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedOffice getPersistedOffice(
			long officeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedOfficeLocalService.getPersistedOffice(officeId);
	}

	/**
	 * Returns the persisted office with the matching UUID and company.
	 *
	 * @param uuid the persisted office's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted office
	 * @throws PortalException if a matching persisted office could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedOffice
			getPersistedOfficeByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedOfficeLocalService.
			getPersistedOfficeByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of all the persisted offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedOfficeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @return the range of persisted offices
	 */
	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedOffice>
		getPersistedOffices(int start, int end) {

		return _persistedOfficeLocalService.getPersistedOffices(start, end);
	}

	/**
	 * Returns the number of persisted offices.
	 *
	 * @return the number of persisted offices
	 */
	@Override
	public int getPersistedOfficesCount() {
		return _persistedOfficeLocalService.getPersistedOfficesCount();
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedOffice
			updatePersistedOffice(
				long officeId, String name, String location,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedOfficeLocalService.updatePersistedOffice(
			officeId, name, location, serviceContext);
	}

	/**
	 * Updates the persisted office in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedOfficeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedOffice the persisted office
	 * @return the persisted office that was updated
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedOffice
		updatePersistedOffice(
			jp.co.liferay.reservation.model.PersistedOffice persistedOffice) {

		return _persistedOfficeLocalService.updatePersistedOffice(
			persistedOffice);
	}

	@Override
	public PersistedOfficeLocalService getWrappedService() {
		return _persistedOfficeLocalService;
	}

	@Override
	public void setWrappedService(
		PersistedOfficeLocalService persistedOfficeLocalService) {

		_persistedOfficeLocalService = persistedOfficeLocalService;
	}

	private PersistedOfficeLocalService _persistedOfficeLocalService;

}