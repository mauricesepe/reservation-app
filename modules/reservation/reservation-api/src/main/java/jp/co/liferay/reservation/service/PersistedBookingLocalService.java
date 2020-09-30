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

import java.util.Date;
import java.util.List;

import jp.co.liferay.reservation.model.PersistedBooking;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for PersistedBooking. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedBookingLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PersistedBookingLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersistedBookingLocalServiceUtil} to access the persisted booking local service. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedBookingLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the persisted booking to the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedBooking the persisted booking
	 * @return the persisted booking that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PersistedBooking addPersistedBooking(
		PersistedBooking persistedBooking);

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedBooking addPersistedBooking(
			String title, Date startDt, Date endDt, long roomId,
			String description, long[] participantIds,
			ServiceContext serviceContext)
		throws PortalException;

	public void addPersistedParticipantPersistedBooking(
		long participantId, long bookingId);

	public void addPersistedParticipantPersistedBooking(
		long participantId, PersistedBooking persistedBooking);

	public void addPersistedParticipantPersistedBookings(
		long participantId, List<PersistedBooking> persistedBookings);

	public void addPersistedParticipantPersistedBookings(
		long participantId, long[] bookingIds);

	public void clearPersistedParticipantPersistedBookings(long participantId);

	/**
	 * Creates a new persisted booking with the primary key. Does not add the persisted booking to the database.
	 *
	 * @param bookingId the primary key for the new persisted booking
	 * @return the new persisted booking
	 */
	@Transactional(enabled = false)
	public PersistedBooking createPersistedBooking(long bookingId);

	/**
	 * Deletes the persisted booking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingId the primary key of the persisted booking
	 * @return the persisted booking that was removed
	 * @throws PortalException if a persisted booking with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public PersistedBooking deletePersistedBooking(long bookingId)
		throws PortalException;

	/**
	 * Deletes the persisted booking from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedBooking the persisted booking
	 * @return the persisted booking that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public PersistedBooking deletePersistedBooking(
		PersistedBooking persistedBooking);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public void deletePersistedParticipantPersistedBooking(
		long participantId, long bookingId);

	public void deletePersistedParticipantPersistedBooking(
		long participantId, PersistedBooking persistedBooking);

	public void deletePersistedParticipantPersistedBookings(
		long participantId, List<PersistedBooking> persistedBookings);

	public void deletePersistedParticipantPersistedBookings(
		long participantId, long[] bookingIds);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public PersistedBooking fetchPersistedBooking(long bookingId);

	/**
	 * Returns the persisted booking with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted booking's external reference code
	 * @return the matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedBooking fetchPersistedBookingByReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the persisted booking with the matching UUID and company.
	 *
	 * @param uuid the persisted booking's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedBooking fetchPersistedBookingByUuidAndCompanyId(
		String uuid, long companyId);

	public List<PersistedBooking> findAll();

	public List<PersistedBooking> findByRoomId(long roomId);

	public List<PersistedBooking> findByUserId(long userId);

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

	/**
	 * Returns the persisted booking with the primary key.
	 *
	 * @param bookingId the primary key of the persisted booking
	 * @return the persisted booking
	 * @throws PortalException if a persisted booking with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedBooking getPersistedBooking(long bookingId)
		throws PortalException;

	/**
	 * Returns the persisted booking with the matching UUID and company.
	 *
	 * @param uuid the persisted booking's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted booking
	 * @throws PortalException if a matching persisted booking could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedBooking getPersistedBookingByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException;

	/**
	 * Returns a range of all the persisted bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @return the range of persisted bookings
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedBooking> getPersistedBookings(int start, int end);

	/**
	 * Returns the number of persisted bookings.
	 *
	 * @return the number of persisted bookings
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPersistedBookingsCount();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedBooking> getPersistedParticipantPersistedBookings(
		long participantId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedBooking> getPersistedParticipantPersistedBookings(
		long participantId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedBooking> getPersistedParticipantPersistedBookings(
		long participantId, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPersistedParticipantPersistedBookingsCount(
		long participantId);

	/**
	 * Returns the participantIds of the persisted participants associated with the persisted booking.
	 *
	 * @param bookingId the bookingId of the persisted booking
	 * @return long[] the participantIds of persisted participants associated with the persisted booking
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getPersistedParticipantPrimaryKeys(long bookingId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPersistedParticipantPersistedBooking(
		long participantId, long bookingId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPersistedParticipantPersistedBookings(long participantId);

	public void setPersistedParticipantPersistedBookings(
		long participantId, long[] bookingIds);

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedBooking updatePersistedBooking(
			long bookingId, String title, Date startDt, Date endDt, long roomId,
			String description, long[] participantIds,
			ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Updates the persisted booking in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param persistedBooking the persisted booking
	 * @return the persisted booking that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PersistedBooking updatePersistedBooking(
		PersistedBooking persistedBooking);

}