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

import jp.co.liferay.reservation.model.PersistedPurpose;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for PersistedPurpose. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedPurposeLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PersistedPurposeLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedPurposeLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the persisted purpose local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link PersistedPurposeLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the persisted purpose to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedPurposeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedPurpose the persisted purpose
	 * @return the persisted purpose that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PersistedPurpose addPersistedPurpose(
		PersistedPurpose persistedPurpose);

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedPurpose addPersistedPurpose(
			String name, ServiceContext serviceContext)
		throws PortalException;

	public void addPersistedRoomPersistedPurpose(long roomId, long purposeId);

	public void addPersistedRoomPersistedPurpose(
		long roomId, PersistedPurpose persistedPurpose);

	public void addPersistedRoomPersistedPurposes(
		long roomId, List<PersistedPurpose> persistedPurposes);

	public void addPersistedRoomPersistedPurposes(
		long roomId, long[] purposeIds);

	public void clearPersistedRoomPersistedPurposes(long roomId);

	/**
	 * Creates a new persisted purpose with the primary key. Does not add the persisted purpose to the database.
	 *
	 * @param purposeId the primary key for the new persisted purpose
	 * @return the new persisted purpose
	 */
	@Transactional(enabled = false)
	public PersistedPurpose createPersistedPurpose(long purposeId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the persisted purpose with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedPurposeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purposeId the primary key of the persisted purpose
	 * @return the persisted purpose that was removed
	 * @throws PortalException if a persisted purpose with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public PersistedPurpose deletePersistedPurpose(long purposeId)
		throws PortalException;

	@Indexable(type = IndexableType.DELETE)
	public PersistedPurpose deletePersistedPurpose(
			long purposeId, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Deletes the persisted purpose from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedPurposeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedPurpose the persisted purpose
	 * @return the persisted purpose that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public PersistedPurpose deletePersistedPurpose(
		PersistedPurpose persistedPurpose);

	public void deletePersistedRoomPersistedPurpose(
		long roomId, long purposeId);

	public void deletePersistedRoomPersistedPurpose(
		long roomId, PersistedPurpose persistedPurpose);

	public void deletePersistedRoomPersistedPurposes(
		long roomId, List<PersistedPurpose> persistedPurposes);

	public void deletePersistedRoomPersistedPurposes(
		long roomId, long[] purposeIds);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedPurposeModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedPurposeModelImpl</code>.
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
	public PersistedPurpose fetchPersistedPurpose(long purposeId);

	/**
	 * Returns the persisted purpose with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted purpose's external reference code
	 * @return the matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedPurpose fetchPersistedPurposeByReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the persisted purpose with the matching UUID and company.
	 *
	 * @param uuid the persisted purpose's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedPurpose fetchPersistedPurposeByUuidAndCompanyId(
		String uuid, long companyId);

	public List<PersistedPurpose> findAll();

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
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the persisted purpose with the primary key.
	 *
	 * @param purposeId the primary key of the persisted purpose
	 * @return the persisted purpose
	 * @throws PortalException if a persisted purpose with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedPurpose getPersistedPurpose(long purposeId)
		throws PortalException;

	/**
	 * Returns the persisted purpose with the matching UUID and company.
	 *
	 * @param uuid the persisted purpose's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted purpose
	 * @throws PortalException if a matching persisted purpose could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedPurpose getPersistedPurposeByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException;

	/**
	 * Returns a range of all the persisted purposes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedPurposeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @return the range of persisted purposes
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedPurpose> getPersistedPurposes(int start, int end);

	/**
	 * Returns the number of persisted purposes.
	 *
	 * @return the number of persisted purposes
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPersistedPurposesCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedPurpose> getPersistedRoomPersistedPurposes(
		long roomId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedPurpose> getPersistedRoomPersistedPurposes(
		long roomId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedPurpose> getPersistedRoomPersistedPurposes(
		long roomId, int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPersistedRoomPersistedPurposesCount(long roomId);

	/**
	 * Returns the roomIds of the persisted rooms associated with the persisted purpose.
	 *
	 * @param purposeId the purposeId of the persisted purpose
	 * @return long[] the roomIds of persisted rooms associated with the persisted purpose
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getPersistedRoomPrimaryKeys(long purposeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPersistedRoomPersistedPurpose(
		long roomId, long purposeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPersistedRoomPersistedPurposes(long roomId);

	public void setPersistedRoomPersistedPurposes(
		long roomId, long[] purposeIds);

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedPurpose updatePersistedPurpose(
			long purposeId, String name, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Updates the persisted purpose in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PersistedPurposeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param persistedPurpose the persisted purpose
	 * @return the persisted purpose that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PersistedPurpose updatePersistedPurpose(
		PersistedPurpose persistedPurpose);

}