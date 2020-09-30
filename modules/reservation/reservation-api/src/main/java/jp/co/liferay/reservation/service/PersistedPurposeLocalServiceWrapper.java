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
 * Provides a wrapper for {@link PersistedPurposeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedPurposeLocalService
 * @generated
 */
@ProviderType
public class PersistedPurposeLocalServiceWrapper
	implements PersistedPurposeLocalService,
			   ServiceWrapper<PersistedPurposeLocalService> {

	public PersistedPurposeLocalServiceWrapper(
		PersistedPurposeLocalService persistedPurposeLocalService) {

		_persistedPurposeLocalService = persistedPurposeLocalService;
	}

	/**
	 * Adds the persisted purpose to the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedPurpose the persisted purpose
	 * @return the persisted purpose that was added
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose addPersistedPurpose(
		jp.co.liferay.reservation.model.PersistedPurpose persistedPurpose) {

		return _persistedPurposeLocalService.addPersistedPurpose(
			persistedPurpose);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose addPersistedPurpose(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedPurposeLocalService.addPersistedPurpose(
			name, serviceContext);
	}

	@Override
	public void addPersistedRoomPersistedPurpose(long roomId, long purposeId) {
		_persistedPurposeLocalService.addPersistedRoomPersistedPurpose(
			roomId, purposeId);
	}

	@Override
	public void addPersistedRoomPersistedPurpose(
		long roomId,
		jp.co.liferay.reservation.model.PersistedPurpose persistedPurpose) {

		_persistedPurposeLocalService.addPersistedRoomPersistedPurpose(
			roomId, persistedPurpose);
	}

	@Override
	public void addPersistedRoomPersistedPurposes(
		long roomId,
		java.util.List<jp.co.liferay.reservation.model.PersistedPurpose>
			persistedPurposes) {

		_persistedPurposeLocalService.addPersistedRoomPersistedPurposes(
			roomId, persistedPurposes);
	}

	@Override
	public void addPersistedRoomPersistedPurposes(
		long roomId, long[] purposeIds) {

		_persistedPurposeLocalService.addPersistedRoomPersistedPurposes(
			roomId, purposeIds);
	}

	@Override
	public void clearPersistedRoomPersistedPurposes(long roomId) {
		_persistedPurposeLocalService.clearPersistedRoomPersistedPurposes(
			roomId);
	}

	/**
	 * Creates a new persisted purpose with the primary key. Does not add the persisted purpose to the database.
	 *
	 * @param purposeId the primary key for the new persisted purpose
	 * @return the new persisted purpose
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose
		createPersistedPurpose(long purposeId) {

		return _persistedPurposeLocalService.createPersistedPurpose(purposeId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedPurposeLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the persisted purpose with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param purposeId the primary key of the persisted purpose
	 * @return the persisted purpose that was removed
	 * @throws PortalException if a persisted purpose with the primary key could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose
			deletePersistedPurpose(long purposeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedPurposeLocalService.deletePersistedPurpose(purposeId);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose
			deletePersistedPurpose(
				long purposeId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedPurposeLocalService.deletePersistedPurpose(
			purposeId, serviceContext);
	}

	/**
	 * Deletes the persisted purpose from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedPurpose the persisted purpose
	 * @return the persisted purpose that was removed
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose
		deletePersistedPurpose(
			jp.co.liferay.reservation.model.PersistedPurpose persistedPurpose) {

		return _persistedPurposeLocalService.deletePersistedPurpose(
			persistedPurpose);
	}

	@Override
	public void deletePersistedRoomPersistedPurpose(
		long roomId, long purposeId) {

		_persistedPurposeLocalService.deletePersistedRoomPersistedPurpose(
			roomId, purposeId);
	}

	@Override
	public void deletePersistedRoomPersistedPurpose(
		long roomId,
		jp.co.liferay.reservation.model.PersistedPurpose persistedPurpose) {

		_persistedPurposeLocalService.deletePersistedRoomPersistedPurpose(
			roomId, persistedPurpose);
	}

	@Override
	public void deletePersistedRoomPersistedPurposes(
		long roomId,
		java.util.List<jp.co.liferay.reservation.model.PersistedPurpose>
			persistedPurposes) {

		_persistedPurposeLocalService.deletePersistedRoomPersistedPurposes(
			roomId, persistedPurposes);
	}

	@Override
	public void deletePersistedRoomPersistedPurposes(
		long roomId, long[] purposeIds) {

		_persistedPurposeLocalService.deletePersistedRoomPersistedPurposes(
			roomId, purposeIds);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _persistedPurposeLocalService.dynamicQuery();
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

		return _persistedPurposeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _persistedPurposeLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _persistedPurposeLocalService.dynamicQuery(
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

		return _persistedPurposeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _persistedPurposeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose
		fetchPersistedPurpose(long purposeId) {

		return _persistedPurposeLocalService.fetchPersistedPurpose(purposeId);
	}

	/**
	 * Returns the persisted purpose with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted purpose's external reference code
	 * @return the matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose
		fetchPersistedPurposeByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _persistedPurposeLocalService.
			fetchPersistedPurposeByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted purpose with the matching UUID and company.
	 *
	 * @param uuid the persisted purpose's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose
		fetchPersistedPurposeByUuidAndCompanyId(String uuid, long companyId) {

		return _persistedPurposeLocalService.
			fetchPersistedPurposeByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedPurpose>
		findAll() {

		return _persistedPurposeLocalService.findAll();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _persistedPurposeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _persistedPurposeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedPurposeLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedPurposeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the persisted purpose with the primary key.
	 *
	 * @param purposeId the primary key of the persisted purpose
	 * @return the persisted purpose
	 * @throws PortalException if a persisted purpose with the primary key could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose getPersistedPurpose(
			long purposeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedPurposeLocalService.getPersistedPurpose(purposeId);
	}

	/**
	 * Returns the persisted purpose with the matching UUID and company.
	 *
	 * @param uuid the persisted purpose's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted purpose
	 * @throws PortalException if a matching persisted purpose could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose
			getPersistedPurposeByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedPurposeLocalService.
			getPersistedPurposeByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedPurpose>
		getPersistedPurposes(int start, int end) {

		return _persistedPurposeLocalService.getPersistedPurposes(start, end);
	}

	/**
	 * Returns the number of persisted purposes.
	 *
	 * @return the number of persisted purposes
	 */
	@Override
	public int getPersistedPurposesCount() {
		return _persistedPurposeLocalService.getPersistedPurposesCount();
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedPurpose>
		getPersistedRoomPersistedPurposes(long roomId) {

		return _persistedPurposeLocalService.getPersistedRoomPersistedPurposes(
			roomId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedPurpose>
		getPersistedRoomPersistedPurposes(long roomId, int start, int end) {

		return _persistedPurposeLocalService.getPersistedRoomPersistedPurposes(
			roomId, start, end);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedPurpose>
		getPersistedRoomPersistedPurposes(
			long roomId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<jp.co.liferay.reservation.model.PersistedPurpose>
					orderByComparator) {

		return _persistedPurposeLocalService.getPersistedRoomPersistedPurposes(
			roomId, start, end, orderByComparator);
	}

	@Override
	public int getPersistedRoomPersistedPurposesCount(long roomId) {
		return _persistedPurposeLocalService.
			getPersistedRoomPersistedPurposesCount(roomId);
	}

	/**
	 * Returns the roomIds of the persisted rooms associated with the persisted purpose.
	 *
	 * @param purposeId the purposeId of the persisted purpose
	 * @return long[] the roomIds of persisted rooms associated with the persisted purpose
	 */
	@Override
	public long[] getPersistedRoomPrimaryKeys(long purposeId) {
		return _persistedPurposeLocalService.getPersistedRoomPrimaryKeys(
			purposeId);
	}

	@Override
	public boolean hasPersistedRoomPersistedPurpose(
		long roomId, long purposeId) {

		return _persistedPurposeLocalService.hasPersistedRoomPersistedPurpose(
			roomId, purposeId);
	}

	@Override
	public boolean hasPersistedRoomPersistedPurposes(long roomId) {
		return _persistedPurposeLocalService.hasPersistedRoomPersistedPurposes(
			roomId);
	}

	@Override
	public void setPersistedRoomPersistedPurposes(
		long roomId, long[] purposeIds) {

		_persistedPurposeLocalService.setPersistedRoomPersistedPurposes(
			roomId, purposeIds);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose
			updatePersistedPurpose(
				long purposeId, String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedPurposeLocalService.updatePersistedPurpose(
			purposeId, name, serviceContext);
	}

	/**
	 * Updates the persisted purpose in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param persistedPurpose the persisted purpose
	 * @return the persisted purpose that was updated
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedPurpose
		updatePersistedPurpose(
			jp.co.liferay.reservation.model.PersistedPurpose persistedPurpose) {

		return _persistedPurposeLocalService.updatePersistedPurpose(
			persistedPurpose);
	}

	@Override
	public PersistedPurposeLocalService getWrappedService() {
		return _persistedPurposeLocalService;
	}

	@Override
	public void setWrappedService(
		PersistedPurposeLocalService persistedPurposeLocalService) {

		_persistedPurposeLocalService = persistedPurposeLocalService;
	}

	private PersistedPurposeLocalService _persistedPurposeLocalService;

}