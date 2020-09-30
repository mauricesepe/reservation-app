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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import jp.co.liferay.reservation.model.PersistedRoom;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for PersistedRoom. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see PersistedRoomServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PersistedRoomService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersistedRoomServiceUtil} to access the persisted room remote service. Add custom service methods to <code>jp.co.liferay.reservation.service.impl.PersistedRoomServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
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

	public PersistedRoom deleteRoom(long roomId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedRoom fetchPersistedRoom(long roomId);

	public List<PersistedRoom> findAll();

	public List<PersistedRoom> findByCalendarId(long calendarId);

	public List<PersistedRoom> findByOfficeId(long officeId);

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
	public List<PersistedRoom> getPersistedPurposePersistedRooms(
		long purposeId);

	public PersistedRoom updateRoom(
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

}