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

package jp.co.liferay.reservation.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import jp.co.liferay.reservation.model.PersistedRoom;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the persisted room service. This utility wraps <code>jp.co.liferay.reservation.service.persistence.impl.PersistedRoomPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedRoomPersistence
 * @generated
 */
public class PersistedRoomUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(PersistedRoom persistedRoom) {
		getPersistence().clearCache(persistedRoom);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, PersistedRoom> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PersistedRoom> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PersistedRoom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PersistedRoom> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PersistedRoom update(PersistedRoom persistedRoom) {
		return getPersistence().update(persistedRoom);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PersistedRoom update(
		PersistedRoom persistedRoom, ServiceContext serviceContext) {

		return getPersistence().update(persistedRoom, serviceContext);
	}

	/**
	 * Returns all the persisted rooms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted rooms
	 */
	public static List<PersistedRoom> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the persisted rooms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of matching persisted rooms
	 */
	public static List<PersistedRoom> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted rooms
	 */
	public static List<PersistedRoom> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted rooms
	 */
	public static List<PersistedRoom> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public static PersistedRoom findByUuid_First(
			String uuid, OrderByComparator<PersistedRoom> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first persisted room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public static PersistedRoom fetchByUuid_First(
		String uuid, OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public static PersistedRoom findByUuid_Last(
			String uuid, OrderByComparator<PersistedRoom> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public static PersistedRoom fetchByUuid_Last(
		String uuid, OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the persisted rooms before and after the current persisted room in the ordered set where uuid = &#63;.
	 *
	 * @param roomId the primary key of the current persisted room
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted room
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	public static PersistedRoom[] findByUuid_PrevAndNext(
			long roomId, String uuid,
			OrderByComparator<PersistedRoom> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().findByUuid_PrevAndNext(
			roomId, uuid, orderByComparator);
	}

	/**
	 * Removes all the persisted rooms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of persisted rooms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted rooms
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the persisted rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted rooms
	 */
	public static List<PersistedRoom> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the persisted rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of matching persisted rooms
	 */
	public static List<PersistedRoom> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted rooms
	 */
	public static List<PersistedRoom> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted rooms
	 */
	public static List<PersistedRoom> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public static PersistedRoom findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersistedRoom> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first persisted room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public static PersistedRoom fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last persisted room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public static PersistedRoom findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersistedRoom> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last persisted room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public static PersistedRoom fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the persisted rooms before and after the current persisted room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param roomId the primary key of the current persisted room
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted room
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	public static PersistedRoom[] findByUuid_C_PrevAndNext(
			long roomId, String uuid, long companyId,
			OrderByComparator<PersistedRoom> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().findByUuid_C_PrevAndNext(
			roomId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the persisted rooms where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of persisted rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted rooms
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the persisted rooms where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the matching persisted rooms
	 */
	public static List<PersistedRoom> findByOfficeId(long officeId) {
		return getPersistence().findByOfficeId(officeId);
	}

	/**
	 * Returns a range of all the persisted rooms where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of matching persisted rooms
	 */
	public static List<PersistedRoom> findByOfficeId(
		long officeId, int start, int end) {

		return getPersistence().findByOfficeId(officeId, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted rooms
	 */
	public static List<PersistedRoom> findByOfficeId(
		long officeId, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().findByOfficeId(
			officeId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted rooms
	 */
	public static List<PersistedRoom> findByOfficeId(
		long officeId, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByOfficeId(
			officeId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted room in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public static PersistedRoom findByOfficeId_First(
			long officeId, OrderByComparator<PersistedRoom> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().findByOfficeId_First(
			officeId, orderByComparator);
	}

	/**
	 * Returns the first persisted room in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public static PersistedRoom fetchByOfficeId_First(
		long officeId, OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().fetchByOfficeId_First(
			officeId, orderByComparator);
	}

	/**
	 * Returns the last persisted room in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public static PersistedRoom findByOfficeId_Last(
			long officeId, OrderByComparator<PersistedRoom> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().findByOfficeId_Last(
			officeId, orderByComparator);
	}

	/**
	 * Returns the last persisted room in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public static PersistedRoom fetchByOfficeId_Last(
		long officeId, OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().fetchByOfficeId_Last(
			officeId, orderByComparator);
	}

	/**
	 * Returns the persisted rooms before and after the current persisted room in the ordered set where officeId = &#63;.
	 *
	 * @param roomId the primary key of the current persisted room
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted room
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	public static PersistedRoom[] findByOfficeId_PrevAndNext(
			long roomId, long officeId,
			OrderByComparator<PersistedRoom> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().findByOfficeId_PrevAndNext(
			roomId, officeId, orderByComparator);
	}

	/**
	 * Removes all the persisted rooms where officeId = &#63; from the database.
	 *
	 * @param officeId the office ID
	 */
	public static void removeByOfficeId(long officeId) {
		getPersistence().removeByOfficeId(officeId);
	}

	/**
	 * Returns the number of persisted rooms where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the number of matching persisted rooms
	 */
	public static int countByOfficeId(long officeId) {
		return getPersistence().countByOfficeId(officeId);
	}

	/**
	 * Returns all the persisted rooms where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @return the matching persisted rooms
	 */
	public static List<PersistedRoom> findByCalendarId(long calendarId) {
		return getPersistence().findByCalendarId(calendarId);
	}

	/**
	 * Returns a range of all the persisted rooms where calendarId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param calendarId the calendar ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of matching persisted rooms
	 */
	public static List<PersistedRoom> findByCalendarId(
		long calendarId, int start, int end) {

		return getPersistence().findByCalendarId(calendarId, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where calendarId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param calendarId the calendar ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted rooms
	 */
	public static List<PersistedRoom> findByCalendarId(
		long calendarId, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().findByCalendarId(
			calendarId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where calendarId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param calendarId the calendar ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted rooms
	 */
	public static List<PersistedRoom> findByCalendarId(
		long calendarId, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCalendarId(
			calendarId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted room in the ordered set where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public static PersistedRoom findByCalendarId_First(
			long calendarId, OrderByComparator<PersistedRoom> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().findByCalendarId_First(
			calendarId, orderByComparator);
	}

	/**
	 * Returns the first persisted room in the ordered set where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public static PersistedRoom fetchByCalendarId_First(
		long calendarId, OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().fetchByCalendarId_First(
			calendarId, orderByComparator);
	}

	/**
	 * Returns the last persisted room in the ordered set where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public static PersistedRoom findByCalendarId_Last(
			long calendarId, OrderByComparator<PersistedRoom> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().findByCalendarId_Last(
			calendarId, orderByComparator);
	}

	/**
	 * Returns the last persisted room in the ordered set where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public static PersistedRoom fetchByCalendarId_Last(
		long calendarId, OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().fetchByCalendarId_Last(
			calendarId, orderByComparator);
	}

	/**
	 * Returns the persisted rooms before and after the current persisted room in the ordered set where calendarId = &#63;.
	 *
	 * @param roomId the primary key of the current persisted room
	 * @param calendarId the calendar ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted room
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	public static PersistedRoom[] findByCalendarId_PrevAndNext(
			long roomId, long calendarId,
			OrderByComparator<PersistedRoom> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().findByCalendarId_PrevAndNext(
			roomId, calendarId, orderByComparator);
	}

	/**
	 * Removes all the persisted rooms where calendarId = &#63; from the database.
	 *
	 * @param calendarId the calendar ID
	 */
	public static void removeByCalendarId(long calendarId) {
		getPersistence().removeByCalendarId(calendarId);
	}

	/**
	 * Returns the number of persisted rooms where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @return the number of matching persisted rooms
	 */
	public static int countByCalendarId(long calendarId) {
		return getPersistence().countByCalendarId(calendarId);
	}

	/**
	 * Returns the persisted room where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedRoomException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public static PersistedRoom findByC_ERC(
			long companyId, String externalReferenceCode)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted room where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public static PersistedRoom fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted room where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public static PersistedRoom fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the persisted room where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted room that was removed
	 */
	public static PersistedRoom removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of persisted rooms where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted rooms
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the persisted room in the entity cache if it is enabled.
	 *
	 * @param persistedRoom the persisted room
	 */
	public static void cacheResult(PersistedRoom persistedRoom) {
		getPersistence().cacheResult(persistedRoom);
	}

	/**
	 * Caches the persisted rooms in the entity cache if it is enabled.
	 *
	 * @param persistedRooms the persisted rooms
	 */
	public static void cacheResult(List<PersistedRoom> persistedRooms) {
		getPersistence().cacheResult(persistedRooms);
	}

	/**
	 * Creates a new persisted room with the primary key. Does not add the persisted room to the database.
	 *
	 * @param roomId the primary key for the new persisted room
	 * @return the new persisted room
	 */
	public static PersistedRoom create(long roomId) {
		return getPersistence().create(roomId);
	}

	/**
	 * Removes the persisted room with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roomId the primary key of the persisted room
	 * @return the persisted room that was removed
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	public static PersistedRoom remove(long roomId)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().remove(roomId);
	}

	public static PersistedRoom updateImpl(PersistedRoom persistedRoom) {
		return getPersistence().updateImpl(persistedRoom);
	}

	/**
	 * Returns the persisted room with the primary key or throws a <code>NoSuchPersistedRoomException</code> if it could not be found.
	 *
	 * @param roomId the primary key of the persisted room
	 * @return the persisted room
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	public static PersistedRoom findByPrimaryKey(long roomId)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedRoomException {

		return getPersistence().findByPrimaryKey(roomId);
	}

	/**
	 * Returns the persisted room with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roomId the primary key of the persisted room
	 * @return the persisted room, or <code>null</code> if a persisted room with the primary key could not be found
	 */
	public static PersistedRoom fetchByPrimaryKey(long roomId) {
		return getPersistence().fetchByPrimaryKey(roomId);
	}

	/**
	 * Returns all the persisted rooms.
	 *
	 * @return the persisted rooms
	 */
	public static List<PersistedRoom> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the persisted rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of persisted rooms
	 */
	public static List<PersistedRoom> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the persisted rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted rooms
	 */
	public static List<PersistedRoom> findAll(
		int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted rooms
	 */
	public static List<PersistedRoom> findAll(
		int start, int end, OrderByComparator<PersistedRoom> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the persisted rooms from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of persisted rooms.
	 *
	 * @return the number of persisted rooms
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of persisted purposes associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return long[] of the primaryKeys of persisted purposes associated with the persisted room
	 */
	public static long[] getPersistedPurposePrimaryKeys(long pk) {
		return getPersistence().getPersistedPurposePrimaryKeys(pk);
	}

	/**
	 * Returns all the persisted room associated with the persisted purpose.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @return the persisted rooms associated with the persisted purpose
	 */
	public static List<PersistedRoom> getPersistedPurposePersistedRooms(
		long pk) {

		return getPersistence().getPersistedPurposePersistedRooms(pk);
	}

	/**
	 * Returns all the persisted room associated with the persisted purpose.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @return the range of persisted rooms associated with the persisted purpose
	 */
	public static List<PersistedRoom> getPersistedPurposePersistedRooms(
		long pk, int start, int end) {

		return getPersistence().getPersistedPurposePersistedRooms(
			pk, start, end);
	}

	/**
	 * Returns all the persisted room associated with the persisted purpose.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted rooms associated with the persisted purpose
	 */
	public static List<PersistedRoom> getPersistedPurposePersistedRooms(
		long pk, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().getPersistedPurposePersistedRooms(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persisted purposes associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return the number of persisted purposes associated with the persisted room
	 */
	public static int getPersistedPurposesSize(long pk) {
		return getPersistence().getPersistedPurposesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the persisted purpose is associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePK the primary key of the persisted purpose
	 * @return <code>true</code> if the persisted purpose is associated with the persisted room; <code>false</code> otherwise
	 */
	public static boolean containsPersistedPurpose(
		long pk, long persistedPurposePK) {

		return getPersistence().containsPersistedPurpose(
			pk, persistedPurposePK);
	}

	/**
	 * Returns <code>true</code> if the persisted room has any persisted purposes associated with it.
	 *
	 * @param pk the primary key of the persisted room to check for associations with persisted purposes
	 * @return <code>true</code> if the persisted room has any persisted purposes associated with it; <code>false</code> otherwise
	 */
	public static boolean containsPersistedPurposes(long pk) {
		return getPersistence().containsPersistedPurposes(pk);
	}

	/**
	 * Adds an association between the persisted room and the persisted purpose. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePK the primary key of the persisted purpose
	 */
	public static void addPersistedPurpose(long pk, long persistedPurposePK) {
		getPersistence().addPersistedPurpose(pk, persistedPurposePK);
	}

	/**
	 * Adds an association between the persisted room and the persisted purpose. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurpose the persisted purpose
	 */
	public static void addPersistedPurpose(
		long pk,
		jp.co.liferay.reservation.model.PersistedPurpose persistedPurpose) {

		getPersistence().addPersistedPurpose(pk, persistedPurpose);
	}

	/**
	 * Adds an association between the persisted room and the persisted purposes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePKs the primary keys of the persisted purposes
	 */
	public static void addPersistedPurposes(
		long pk, long[] persistedPurposePKs) {

		getPersistence().addPersistedPurposes(pk, persistedPurposePKs);
	}

	/**
	 * Adds an association between the persisted room and the persisted purposes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposes the persisted purposes
	 */
	public static void addPersistedPurposes(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedPurpose>
			persistedPurposes) {

		getPersistence().addPersistedPurposes(pk, persistedPurposes);
	}

	/**
	 * Clears all associations between the persisted room and its persisted purposes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room to clear the associated persisted purposes from
	 */
	public static void clearPersistedPurposes(long pk) {
		getPersistence().clearPersistedPurposes(pk);
	}

	/**
	 * Removes the association between the persisted room and the persisted purpose. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePK the primary key of the persisted purpose
	 */
	public static void removePersistedPurpose(
		long pk, long persistedPurposePK) {

		getPersistence().removePersistedPurpose(pk, persistedPurposePK);
	}

	/**
	 * Removes the association between the persisted room and the persisted purpose. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurpose the persisted purpose
	 */
	public static void removePersistedPurpose(
		long pk,
		jp.co.liferay.reservation.model.PersistedPurpose persistedPurpose) {

		getPersistence().removePersistedPurpose(pk, persistedPurpose);
	}

	/**
	 * Removes the association between the persisted room and the persisted purposes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePKs the primary keys of the persisted purposes
	 */
	public static void removePersistedPurposes(
		long pk, long[] persistedPurposePKs) {

		getPersistence().removePersistedPurposes(pk, persistedPurposePKs);
	}

	/**
	 * Removes the association between the persisted room and the persisted purposes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposes the persisted purposes
	 */
	public static void removePersistedPurposes(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedPurpose>
			persistedPurposes) {

		getPersistence().removePersistedPurposes(pk, persistedPurposes);
	}

	/**
	 * Sets the persisted purposes associated with the persisted room, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePKs the primary keys of the persisted purposes to be associated with the persisted room
	 */
	public static void setPersistedPurposes(
		long pk, long[] persistedPurposePKs) {

		getPersistence().setPersistedPurposes(pk, persistedPurposePKs);
	}

	/**
	 * Sets the persisted purposes associated with the persisted room, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposes the persisted purposes to be associated with the persisted room
	 */
	public static void setPersistedPurposes(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedPurpose>
			persistedPurposes) {

		getPersistence().setPersistedPurposes(pk, persistedPurposes);
	}

	/**
	 * Returns the primaryKeys of persisted amenities associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return long[] of the primaryKeys of persisted amenities associated with the persisted room
	 */
	public static long[] getPersistedAmenityPrimaryKeys(long pk) {
		return getPersistence().getPersistedAmenityPrimaryKeys(pk);
	}

	/**
	 * Returns all the persisted room associated with the persisted amenity.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @return the persisted rooms associated with the persisted amenity
	 */
	public static List<PersistedRoom> getPersistedAmenityPersistedRooms(
		long pk) {

		return getPersistence().getPersistedAmenityPersistedRooms(pk);
	}

	/**
	 * Returns all the persisted room associated with the persisted amenity.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @return the range of persisted rooms associated with the persisted amenity
	 */
	public static List<PersistedRoom> getPersistedAmenityPersistedRooms(
		long pk, int start, int end) {

		return getPersistence().getPersistedAmenityPersistedRooms(
			pk, start, end);
	}

	/**
	 * Returns all the persisted room associated with the persisted amenity.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted rooms associated with the persisted amenity
	 */
	public static List<PersistedRoom> getPersistedAmenityPersistedRooms(
		long pk, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return getPersistence().getPersistedAmenityPersistedRooms(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persisted amenities associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return the number of persisted amenities associated with the persisted room
	 */
	public static int getPersistedAmenitiesSize(long pk) {
		return getPersistence().getPersistedAmenitiesSize(pk);
	}

	/**
	 * Returns <code>true</code> if the persisted amenity is associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPK the primary key of the persisted amenity
	 * @return <code>true</code> if the persisted amenity is associated with the persisted room; <code>false</code> otherwise
	 */
	public static boolean containsPersistedAmenity(
		long pk, long persistedAmenityPK) {

		return getPersistence().containsPersistedAmenity(
			pk, persistedAmenityPK);
	}

	/**
	 * Returns <code>true</code> if the persisted room has any persisted amenities associated with it.
	 *
	 * @param pk the primary key of the persisted room to check for associations with persisted amenities
	 * @return <code>true</code> if the persisted room has any persisted amenities associated with it; <code>false</code> otherwise
	 */
	public static boolean containsPersistedAmenities(long pk) {
		return getPersistence().containsPersistedAmenities(pk);
	}

	/**
	 * Adds an association between the persisted room and the persisted amenity. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPK the primary key of the persisted amenity
	 */
	public static void addPersistedAmenity(long pk, long persistedAmenityPK) {
		getPersistence().addPersistedAmenity(pk, persistedAmenityPK);
	}

	/**
	 * Adds an association between the persisted room and the persisted amenity. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenity the persisted amenity
	 */
	public static void addPersistedAmenity(
		long pk,
		jp.co.liferay.reservation.model.PersistedAmenity persistedAmenity) {

		getPersistence().addPersistedAmenity(pk, persistedAmenity);
	}

	/**
	 * Adds an association between the persisted room and the persisted amenities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPKs the primary keys of the persisted amenities
	 */
	public static void addPersistedAmenities(
		long pk, long[] persistedAmenityPKs) {

		getPersistence().addPersistedAmenities(pk, persistedAmenityPKs);
	}

	/**
	 * Adds an association between the persisted room and the persisted amenities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenities the persisted amenities
	 */
	public static void addPersistedAmenities(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedAmenity>
			persistedAmenities) {

		getPersistence().addPersistedAmenities(pk, persistedAmenities);
	}

	/**
	 * Clears all associations between the persisted room and its persisted amenities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room to clear the associated persisted amenities from
	 */
	public static void clearPersistedAmenities(long pk) {
		getPersistence().clearPersistedAmenities(pk);
	}

	/**
	 * Removes the association between the persisted room and the persisted amenity. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPK the primary key of the persisted amenity
	 */
	public static void removePersistedAmenity(
		long pk, long persistedAmenityPK) {

		getPersistence().removePersistedAmenity(pk, persistedAmenityPK);
	}

	/**
	 * Removes the association between the persisted room and the persisted amenity. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenity the persisted amenity
	 */
	public static void removePersistedAmenity(
		long pk,
		jp.co.liferay.reservation.model.PersistedAmenity persistedAmenity) {

		getPersistence().removePersistedAmenity(pk, persistedAmenity);
	}

	/**
	 * Removes the association between the persisted room and the persisted amenities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPKs the primary keys of the persisted amenities
	 */
	public static void removePersistedAmenities(
		long pk, long[] persistedAmenityPKs) {

		getPersistence().removePersistedAmenities(pk, persistedAmenityPKs);
	}

	/**
	 * Removes the association between the persisted room and the persisted amenities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenities the persisted amenities
	 */
	public static void removePersistedAmenities(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedAmenity>
			persistedAmenities) {

		getPersistence().removePersistedAmenities(pk, persistedAmenities);
	}

	/**
	 * Sets the persisted amenities associated with the persisted room, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPKs the primary keys of the persisted amenities to be associated with the persisted room
	 */
	public static void setPersistedAmenities(
		long pk, long[] persistedAmenityPKs) {

		getPersistence().setPersistedAmenities(pk, persistedAmenityPKs);
	}

	/**
	 * Sets the persisted amenities associated with the persisted room, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenities the persisted amenities to be associated with the persisted room
	 */
	public static void setPersistedAmenities(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedAmenity>
			persistedAmenities) {

		getPersistence().setPersistedAmenities(pk, persistedAmenities);
	}

	public static PersistedRoomPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedRoomPersistence, PersistedRoomPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PersistedRoomPersistence.class);

		ServiceTracker<PersistedRoomPersistence, PersistedRoomPersistence>
			serviceTracker =
				new ServiceTracker
					<PersistedRoomPersistence, PersistedRoomPersistence>(
						bundle.getBundleContext(),
						PersistedRoomPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}