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

import jp.co.liferay.reservation.model.PersistedParticipant;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for PersistedParticipant. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedParticipantLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PersistedParticipantLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersistedParticipantLocalServiceUtil} to access the persisted participant local service. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedParticipantLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public void addPersistedBookingPersistedParticipant(
		long bookingId, long participantId);

	public void addPersistedBookingPersistedParticipant(
		long bookingId, PersistedParticipant persistedParticipant);

	public void addPersistedBookingPersistedParticipants(
		long bookingId, List<PersistedParticipant> persistedParticipants);

	public void addPersistedBookingPersistedParticipants(
		long bookingId, long[] participantIds);

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedParticipant addPersistedParticipant(
			long userId, String fullName, String companyName,
			String emailAddress, ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Adds the persisted participant to the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedParticipant the persisted participant
	 * @return the persisted participant that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PersistedParticipant addPersistedParticipant(
		PersistedParticipant persistedParticipant);

	public void clearPersistedBookingPersistedParticipants(long bookingId);

	/**
	 * Creates a new persisted participant with the primary key. Does not add the persisted participant to the database.
	 *
	 * @param participantId the primary key for the new persisted participant
	 * @return the new persisted participant
	 */
	@Transactional(enabled = false)
	public PersistedParticipant createPersistedParticipant(long participantId);

	public void deletePersistedBookingPersistedParticipant(
		long bookingId, long participantId);

	public void deletePersistedBookingPersistedParticipant(
		long bookingId, PersistedParticipant persistedParticipant);

	public void deletePersistedBookingPersistedParticipants(
		long bookingId, List<PersistedParticipant> persistedParticipants);

	public void deletePersistedBookingPersistedParticipants(
		long bookingId, long[] participantIds);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the persisted participant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param participantId the primary key of the persisted participant
	 * @return the persisted participant that was removed
	 * @throws PortalException if a persisted participant with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public PersistedParticipant deletePersistedParticipant(long participantId)
		throws PortalException;

	/**
	 * Deletes the persisted participant from the database. Also notifies the appropriate model listeners.
	 *
	 * @param persistedParticipant the persisted participant
	 * @return the persisted participant that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public PersistedParticipant deletePersistedParticipant(
		PersistedParticipant persistedParticipant);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public PersistedParticipant fetchPersistedParticipant(long participantId);

	/**
	 * Returns the persisted participant with the matching external reference code and company.
	 *
	 * @param companyId the primary key of the company
	 * @param externalReferenceCode the persisted participant's external reference code
	 * @return the matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedParticipant fetchPersistedParticipantByReferenceCode(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the persisted participant with the matching UUID and company.
	 *
	 * @param uuid the persisted participant's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedParticipant fetchPersistedParticipantByUuidAndCompanyId(
		String uuid, long companyId);

	public List<PersistedParticipant> findAll();

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedParticipant> getPersistedBookingPersistedParticipants(
		long bookingId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedParticipant> getPersistedBookingPersistedParticipants(
		long bookingId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedParticipant> getPersistedBookingPersistedParticipants(
		long bookingId, int start, int end,
		OrderByComparator<PersistedParticipant> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPersistedBookingPersistedParticipantsCount(long bookingId);

	/**
	 * Returns the bookingIds of the persisted bookings associated with the persisted participant.
	 *
	 * @param participantId the participantId of the persisted participant
	 * @return long[] the bookingIds of persisted bookings associated with the persisted participant
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getPersistedBookingPrimaryKeys(long participantId);

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the persisted participant with the primary key.
	 *
	 * @param participantId the primary key of the persisted participant
	 * @return the persisted participant
	 * @throws PortalException if a persisted participant with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedParticipant getPersistedParticipant(long participantId)
		throws PortalException;

	/**
	 * Returns the persisted participant with the matching UUID and company.
	 *
	 * @param uuid the persisted participant's UUID
	 * @param companyId the primary key of the company
	 * @return the matching persisted participant
	 * @throws PortalException if a matching persisted participant could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedParticipant getPersistedParticipantByUuidAndCompanyId(
			String uuid, long companyId)
		throws PortalException;

	/**
	 * Returns a range of all the persisted participants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>jp.co.liferay.reservation.model.impl.PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @return the range of persisted participants
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PersistedParticipant> getPersistedParticipants(
		int start, int end);

	/**
	 * Returns the number of persisted participants.
	 *
	 * @return the number of persisted participants
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPersistedParticipantsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPersistedBookingPersistedParticipant(
		long bookingId, long participantId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasPersistedBookingPersistedParticipants(long bookingId);

	public void setPersistedBookingPersistedParticipants(
		long bookingId, long[] participantIds);

	@Indexable(type = IndexableType.REINDEX)
	@SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedParticipant updatePersistedParticipant(
			long participantId, long userId, String fullName,
			String companyName, String emailAddress,
			ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Updates the persisted participant in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param persistedParticipant the persisted participant
	 * @return the persisted participant that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PersistedParticipant updatePersistedParticipant(
		PersistedParticipant persistedParticipant);

}