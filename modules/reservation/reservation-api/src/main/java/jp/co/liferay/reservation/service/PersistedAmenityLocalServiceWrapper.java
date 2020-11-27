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
 * Provides a wrapper for {@link PersistedAmenityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedAmenityLocalService
 * @generated
 */
public class PersistedAmenityLocalServiceWrapper
	implements PersistedAmenityLocalService,
			   ServiceWrapper<PersistedAmenityLocalService> {

	public PersistedAmenityLocalServiceWrapper(
		PersistedAmenityLocalService persistedAmenityLocalService) {

		_persistedAmenityLocalService = persistedAmenityLocalService;
	}

	/**
	 * Adds the persisted amenity to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedAmenityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedAmenity the persisted amenity
	 * @return the persisted amenity that was added
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity addPersistedAmenity(
		jp.co.liferay.reservation.model.PersistedAmenity persistedAmenity) {

		return _persistedAmenityLocalService.addPersistedAmenity(
			persistedAmenity);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity addPersistedAmenity(
			String name,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedAmenityLocalService.addPersistedAmenity(
			name, serviceContext);
	}

	@Override
	public void addPersistedRoomPersistedAmenities(
		long roomId,
		java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
			persistedAmenities) {

		_persistedAmenityLocalService.addPersistedRoomPersistedAmenities(
			roomId, persistedAmenities);
	}

	@Override
	public void addPersistedRoomPersistedAmenities(
		long roomId, long[] amenityIds) {

		_persistedAmenityLocalService.addPersistedRoomPersistedAmenities(
			roomId, amenityIds);
	}

	@Override
	public void addPersistedRoomPersistedAmenity(long roomId, long amenityId) {
		_persistedAmenityLocalService.addPersistedRoomPersistedAmenity(
			roomId, amenityId);
	}

	@Override
	public void addPersistedRoomPersistedAmenity(
		long roomId,
		jp.co.liferay.reservation.model.PersistedAmenity persistedAmenity) {

		_persistedAmenityLocalService.addPersistedRoomPersistedAmenity(
			roomId, persistedAmenity);
	}

	@Override
	public void clearPersistedRoomPersistedAmenities(long roomId) {
		_persistedAmenityLocalService.clearPersistedRoomPersistedAmenities(
			roomId);
	}

	/**
	 * Creates a new persisted amenity with the primary key. Does not add the persisted amenity to the database.
	 *
	 * @param amenityId the primary key for the new persisted amenity
	 * @return the new persisted amenity
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity
		createPersistedAmenity(long amenityId) {

		return _persistedAmenityLocalService.createPersistedAmenity(amenityId);
	}

	/**
	 * Deletes the persisted amenity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedAmenityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amenityId the primary key of the persisted amenity
	 * @return the persisted amenity that was removed
	 * @throws PortalException if a persisted amenity with the primary key could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity
			deletePersistedAmenity(long amenityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedAmenityLocalService.deletePersistedAmenity(amenityId);
	}

	/**
	 * Deletes the persisted amenity from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedAmenityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedAmenity the persisted amenity
	 * @return the persisted amenity that was removed
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity
		deletePersistedAmenity(
			jp.co.liferay.reservation.model.PersistedAmenity persistedAmenity) {

		return _persistedAmenityLocalService.deletePersistedAmenity(
			persistedAmenity);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedAmenityLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public void deletePersistedRoomPersistedAmenities(
		long roomId,
		java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
			persistedAmenities) {

		_persistedAmenityLocalService.deletePersistedRoomPersistedAmenities(
			roomId, persistedAmenities);
	}

	@Override
	public void deletePersistedRoomPersistedAmenities(
		long roomId, long[] amenityIds) {

		_persistedAmenityLocalService.deletePersistedRoomPersistedAmenities(
			roomId, amenityIds);
	}

	@Override
	public void deletePersistedRoomPersistedAmenity(
		long roomId, long amenityId) {

		_persistedAmenityLocalService.deletePersistedRoomPersistedAmenity(
			roomId, amenityId);
	}

	@Override
	public void deletePersistedRoomPersistedAmenity(
		long roomId,
		jp.co.liferay.reservation.model.PersistedAmenity persistedAmenity) {

		_persistedAmenityLocalService.deletePersistedRoomPersistedAmenity(
			roomId, persistedAmenity);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _persistedAmenityLocalService.dynamicQuery();
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

		return _persistedAmenityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedAmenityModelImpl</code>.
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

		return _persistedAmenityLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedAmenityModelImpl</code>.
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

		return _persistedAmenityLocalService.dynamicQuery(
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

		return _persistedAmenityLocalService.dynamicQueryCount(dynamicQuery);
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

		return _persistedAmenityLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity
		fetchPersistedAmenity(long amenityId) {

		return _persistedAmenityLocalService.fetchPersistedAmenity(amenityId);
	}

	/**
	 * Returns the persisted amenity with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted amenity's external reference code
	 * @return the matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity
		fetchPersistedAmenityByReferenceCode(
			long companyId, String externalReferenceCode) {

		return _persistedAmenityLocalService.
			fetchPersistedAmenityByReferenceCode(
				companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted amenity with the matching UUID and company.
	 *
	 * @param uuid the persisted amenity's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity
		fetchPersistedAmenityByUuidAndCompanyId(String uuid, long companyId) {

		return _persistedAmenityLocalService.
			fetchPersistedAmenityByUuidAndCompanyId(uuid, companyId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
		findAll() {

		return _persistedAmenityLocalService.findAll();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _persistedAmenityLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _persistedAmenityLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _persistedAmenityLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns a range of all the persisted amenities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedAmenityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @return the range of persisted amenities
	 */
	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
		getPersistedAmenities(int start, int end) {

		return _persistedAmenityLocalService.getPersistedAmenities(start, end);
	}

	/**
	 * Returns the number of persisted amenities.
	 *
	 * @return the number of persisted amenities
	 */
	@Override
	public int getPersistedAmenitiesCount() {
		return _persistedAmenityLocalService.getPersistedAmenitiesCount();
	}

	/**
	 * Returns the persisted amenity with the primary key.
	 *
	 * @param amenityId the primary key of the persisted amenity
	 * @return the persisted amenity
	 * @throws PortalException if a persisted amenity with the primary key could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity getPersistedAmenity(
			long amenityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedAmenityLocalService.getPersistedAmenity(amenityId);
	}

	/**
	 * Returns the persisted amenity with the matching UUID and company.
	 *
	 * @param uuid the persisted amenity's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted amenity
	 * @throws PortalException if a matching persisted amenity could not be found
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity
			getPersistedAmenityByUuidAndCompanyId(String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedAmenityLocalService.
			getPersistedAmenityByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedAmenityLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
		getPersistedRoomPersistedAmenities(long roomId) {

		return _persistedAmenityLocalService.getPersistedRoomPersistedAmenities(
			roomId);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
		getPersistedRoomPersistedAmenities(long roomId, int start, int end) {

		return _persistedAmenityLocalService.getPersistedRoomPersistedAmenities(
			roomId, start, end);
	}

	@Override
	public java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
		getPersistedRoomPersistedAmenities(
			long roomId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<jp.co.liferay.reservation.model.PersistedAmenity>
					orderByComparator) {

		return _persistedAmenityLocalService.getPersistedRoomPersistedAmenities(
			roomId, start, end, orderByComparator);
	}

	@Override
	public int getPersistedRoomPersistedAmenitiesCount(long roomId) {
		return _persistedAmenityLocalService.
			getPersistedRoomPersistedAmenitiesCount(roomId);
	}

	/**
	 * Returns the roomIds of the persisted rooms associated with the persisted amenity.
	 *
	 * @param amenityId the amenityId of the persisted amenity
	 * @return long[] the roomIds of persisted rooms associated with the persisted amenity
	 */
	@Override
	public long[] getPersistedRoomPrimaryKeys(long amenityId) {
		return _persistedAmenityLocalService.getPersistedRoomPrimaryKeys(
			amenityId);
	}

	@Override
	public boolean hasPersistedRoomPersistedAmenities(long roomId) {
		return _persistedAmenityLocalService.hasPersistedRoomPersistedAmenities(
			roomId);
	}

	@Override
	public boolean hasPersistedRoomPersistedAmenity(
		long roomId, long amenityId) {

		return _persistedAmenityLocalService.hasPersistedRoomPersistedAmenity(
			roomId, amenityId);
	}

	@Override
	public void setPersistedRoomPersistedAmenities(
		long roomId, long[] amenityIds) {

		_persistedAmenityLocalService.setPersistedRoomPersistedAmenities(
			roomId, amenityIds);
	}

	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity
			updatePersistedAmenity(
				long amenityId, String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _persistedAmenityLocalService.updatePersistedAmenity(
			amenityId, name, serviceContext);
	}

	/**
	 * Updates the persisted amenity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedAmenityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedAmenity the persisted amenity
	 * @return the persisted amenity that was updated
	 */
	@Override
	public jp.co.liferay.reservation.model.PersistedAmenity
		updatePersistedAmenity(
			jp.co.liferay.reservation.model.PersistedAmenity persistedAmenity) {

		return _persistedAmenityLocalService.updatePersistedAmenity(
			persistedAmenity);
	}

	@Override
	public PersistedAmenityLocalService getWrappedService() {
		return _persistedAmenityLocalService;
	}

	@Override
	public void setWrappedService(
		PersistedAmenityLocalService persistedAmenityLocalService) {

		_persistedAmenityLocalService = persistedAmenityLocalService;
	}

	private PersistedAmenityLocalService _persistedAmenityLocalService;

}