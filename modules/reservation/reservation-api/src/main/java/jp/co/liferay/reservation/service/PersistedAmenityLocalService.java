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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import jp.co.liferay.reservation.model.PersistedAmenity;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for PersistedAmenity. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedAmenityLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PersistedAmenityLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedAmenityLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the persisted amenity local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link PersistedAmenityLocalServiceUtil} if injection and service tracking are not available.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	public PersistedAmenity addPersistedAmenity(
		PersistedAmenity persistedAmenity);

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedAmenity addPersistedAmenity(
			String name, ServiceContext serviceContext)
		throws PortalException;

	public void addPersistedRoomPersistedAmenities(
		long roomId, List<PersistedAmenity> persistedAmenities);

	public void addPersistedRoomPersistedAmenities(
		long roomId, long[] amenityIds);

	public void addPersistedRoomPersistedAmenity(long roomId, long amenityId);

	public void addPersistedRoomPersistedAmenity(
		long roomId, PersistedAmenity persistedAmenity);

	public void clearPersistedRoomPersistedAmenities(long roomId);

	/**
	 * Creates a new persisted amenity with the primary key. Does not add the persisted amenity to the database.
	 *
	 * @param amenityId the primary key for the new persisted amenity
	 * @return the new persisted amenity
	 */
	@Transactional(enabled = false)
	public PersistedAmenity createPersistedAmenity(long amenityId);

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
	@Indexable(type = IndexableType.DELETE)
	public PersistedAmenity deletePersistedAmenity(long amenityId)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public PersistedAmenity deletePersistedAmenity(
		PersistedAmenity persistedAmenity);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public void deletePersistedRoomPersistedAmenities(
		long roomId, List<PersistedAmenity> persistedAmenities);

	public void deletePersistedRoomPersistedAmenities(
		long roomId, long[] amenityIds);

	public void deletePersistedRoomPersistedAmenity(
		long roomId, long amenityId);

	public void deletePersistedRoomPersistedAmenity(
		long roomId, PersistedAmenity persistedAmenity);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedAmenity fetchPersistedAmenity(long amenityId);

	/**
	 * Returns the persisted amenity with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted amenity's external reference code
	 * @return the matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedAmenity fetchPersistedAmenityByReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the persisted amenity with the matching UUID and company.
	 *
	 * @param uuid the persisted amenity's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedAmenity fetchPersistedAmenityByUuidAndCompanyId(
		String uuid, long companyId);

	public List<PersistedAmenity> findAll();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedAmenity> getPersistedAmenities(int start, int end);

	/**
	 * Returns the number of persisted amenities.
	 *
	 * @return the number of persisted amenities
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPersistedAmenitiesCount();

	/**
	 * Returns the persisted amenity with the primary key.
	 *
	 * @param amenityId the primary key of the persisted amenity
	 * @return the persisted amenity
	 * @throws PortalException if a persisted amenity with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedAmenity getPersistedAmenity(long amenityId)
		throws PortalException;

	/**
	 * Returns the persisted amenity with the matching UUID and company.
	 *
	 * @param uuid the persisted amenity's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted amenity
	 * @throws PortalException if a matching persisted amenity could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedAmenity getPersistedAmenityByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedAmenity> getPersistedRoomPersistedAmenities(
		long roomId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedAmenity> getPersistedRoomPersistedAmenities(
		long roomId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedAmenity> getPersistedRoomPersistedAmenities(
		long roomId, int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPersistedRoomPersistedAmenitiesCount(long roomId);

	/**
	 * Returns the roomIds of the persisted rooms associated with the persisted amenity.
	 *
	 * @param amenityId the amenityId of the persisted amenity
	 * @return long[] the roomIds of persisted rooms associated with the persisted amenity
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getPersistedRoomPrimaryKeys(long amenityId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPersistedRoomPersistedAmenities(long roomId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPersistedRoomPersistedAmenity(
		long roomId, long amenityId);

	public void setPersistedRoomPersistedAmenities(
		long roomId, long[] amenityIds);

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedAmenity updatePersistedAmenity(
			long amenityId, String name, ServiceContext serviceContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public PersistedAmenity updatePersistedAmenity(
		PersistedAmenity persistedAmenity);

}