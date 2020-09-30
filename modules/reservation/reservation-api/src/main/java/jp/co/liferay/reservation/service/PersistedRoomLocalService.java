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

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
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

import jp.co.liferay.reservation.model.PersistedRoom;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for PersistedRoom. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedRoomLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PersistedRoomLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersistedRoomLocalServiceUtil} to access the persisted room local service. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedRoomLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public void addPersistedAmenityPersistedRoom(long amenityId, long roomId);

	public void addPersistedAmenityPersistedRoom(
		long amenityId, PersistedRoom persistedRoom);

	public void addPersistedAmenityPersistedRooms(
		long amenityId, List<PersistedRoom> persistedRooms);

	public void addPersistedAmenityPersistedRooms(
		long amenityId, long[] roomIds);

	public void addPersistedPurposePersistedRoom(long purposeId, long roomId);

	public void addPersistedPurposePersistedRoom(
		long purposeId, PersistedRoom persistedRoom);

	public void addPersistedPurposePersistedRooms(
		long purposeId, List<PersistedRoom> persistedRooms);

	public void addPersistedPurposePersistedRooms(
		long purposeId, long[] roomIds);

	/**
	 * Adds the persisted room to the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedRoom the persisted room
	 * @return the persisted room that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PersistedRoom addPersistedRoom(PersistedRoom persistedRoom);

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedRoom addPersistedRoom(
			String name, String photoPath, boolean availableSunday,
			boolean availableMonday, boolean availableTuesday,
			boolean availableWednesday, boolean availableThursday,
			boolean availableFriday, boolean availableSaturday,
			int availableStartTime, int availableEndTime, long officeId,
			double capacitySquareMeters, int capacityPeople, int phoneExtension,
			String wifiSSID, int wifiSecurityType, String wifiPassword,
			long[] amenitiesIds, long[] purposeIds,
			ServiceContext serviceContext)
		throws PortalException;

	public void clearPersistedAmenityPersistedRooms(long amenityId);

	public void clearPersistedPurposePersistedRooms(long purposeId);

	/**
	 * Creates a new persisted room with the primary key. Does not add the persisted room to the database.
	 *
	 * @param roomId the primary key for the new persisted room
	 * @return the new persisted room
	 */
	@Transactional(enabled = false)
	public PersistedRoom createPersistedRoom(long roomId);

	public void deletePersistedAmenityPersistedRoom(
		long amenityId, long roomId);

	public void deletePersistedAmenityPersistedRoom(
		long amenityId, PersistedRoom persistedRoom);

	public void deletePersistedAmenityPersistedRooms(
		long amenityId, List<PersistedRoom> persistedRooms);

	public void deletePersistedAmenityPersistedRooms(
		long amenityId, long[] roomIds);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public void deletePersistedPurposePersistedRoom(
		long purposeId, long roomId);

	public void deletePersistedPurposePersistedRoom(
		long purposeId, PersistedRoom persistedRoom);

	public void deletePersistedPurposePersistedRooms(
		long purposeId, List<PersistedRoom> persistedRooms);

	public void deletePersistedPurposePersistedRooms(
		long purposeId, long[] roomIds);

	/**
	 * Deletes the persisted room with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roomId the primary key of the persisted room
	 * @return the persisted room that was removed
	 * @throws PortalException if a persisted room with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public PersistedRoom deletePersistedRoom(long roomId)
		throws PortalException;

	/**
	 * Deletes the persisted room from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedRoom the persisted room
	 * @return the persisted room that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public PersistedRoom deletePersistedRoom(PersistedRoom persistedRoom);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public PersistedRoom fetchPersistedRoom(long roomId);

	/**
	 * Returns the persisted room with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted room's external reference code
	 * @return the matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedRoom fetchPersistedRoomByReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the persisted room with the matching UUID and company.
	 *
	 * @param uuid the persisted room's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedRoom fetchPersistedRoomByUuidAndCompanyId(
		String uuid, long companyId);

	public List<PersistedRoom> findAll();

	public List<PersistedRoom> findByCalendarId(long calendarId);

	public List<PersistedRoom> findByOfficeId(long officeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedRoom> getPersistedAmenityPersistedRooms(
		long amenityId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedRoom> getPersistedAmenityPersistedRooms(
		long amenityId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedRoom> getPersistedAmenityPersistedRooms(
		long amenityId, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPersistedAmenityPersistedRoomsCount(long amenityId);

	/**
	 * Returns the amenityIds of the persisted amenities associated with the persisted room.
	 *
	 * @param roomId the roomId of the persisted room
	 * @return long[] the amenityIds of persisted amenities associated with the persisted room
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getPersistedAmenityPrimaryKeys(long roomId);

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedRoom> getPersistedPurposePersistedRooms(
		long purposeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedRoom> getPersistedPurposePersistedRooms(
		long purposeId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedRoom> getPersistedPurposePersistedRooms(
		long purposeId, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPersistedPurposePersistedRoomsCount(long purposeId);

	/**
	 * Returns the purposeIds of the persisted purposes associated with the persisted room.
	 *
	 * @param roomId the roomId of the persisted room
	 * @return long[] the purposeIds of persisted purposes associated with the persisted room
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getPersistedPurposePrimaryKeys(long roomId);

	/**
	 * Returns the persisted room with the primary key.
	 *
	 * @param roomId the primary key of the persisted room
	 * @return the persisted room
	 * @throws PortalException if a persisted room with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedRoom getPersistedRoom(long roomId) throws PortalException;

	/**
	 * Returns the persisted room with the matching UUID and company.
	 *
	 * @param uuid the persisted room's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted room
	 * @throws PortalException if a matching persisted room could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedRoom getPersistedRoomByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException;

	/**
	 * Returns a range of all the persisted rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of persisted rooms
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedRoom> getPersistedRooms(int start, int end);

	/**
	 * Returns the number of persisted rooms.
	 *
	 * @return the number of persisted rooms
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPersistedRoomsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPersistedAmenityPersistedRoom(
		long amenityId, long roomId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPersistedAmenityPersistedRooms(long amenityId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPersistedPurposePersistedRoom(
		long purposeId, long roomId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPersistedPurposePersistedRooms(long purposeId);

	public void setPersistedAmenityPersistedRooms(
		long amenityId, long[] roomIds);

	public void setPersistedPurposePersistedRooms(
		long purposeId, long[] roomIds);

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedRoom updatePersistedRoom(
			long roomId, String name, String photoPath, boolean availableSunday,
			boolean availableMonday, boolean availableTuesday,
			boolean availableWednesday, boolean availableThursday,
			boolean availableFriday, boolean availableSaturday,
			int availableStartTime, int availableEndTime, long officeId,
			double capacitySquareMeters, int capacityPeople, int phoneExtension,
			String wifiSSID, int wifiSecurityType, String wifiPassword,
			long[] amenitiesIds, long[] purposeIds,
			ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Updates the persisted room in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param persistedRoom the persisted room
	 * @return the persisted room that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PersistedRoom updatePersistedRoom(PersistedRoom persistedRoom);

}