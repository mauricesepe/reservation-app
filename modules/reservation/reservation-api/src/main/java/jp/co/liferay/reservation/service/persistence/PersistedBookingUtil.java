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

import jp.co.liferay.reservation.model.PersistedBooking;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the persisted booking service. This utility wraps <code>jp.co.liferay.reservation.service.persistence.impl.PersistedBookingPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedBookingPersistence
 * @generated
 */
public class PersistedBookingUtil {

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
	public static void clearCache(PersistedBooking persistedBooking) {
		getPersistence().clearCache(persistedBooking);
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
	public static Map<Serializable, PersistedBooking> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PersistedBooking> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PersistedBooking> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PersistedBooking> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PersistedBooking update(PersistedBooking persistedBooking) {
		return getPersistence().update(persistedBooking);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PersistedBooking update(
		PersistedBooking persistedBooking, ServiceContext serviceContext) {

		return getPersistence().update(persistedBooking, serviceContext);
	}

	/**
	 * Returns all the persisted bookings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted bookings
	 */
	public static List<PersistedBooking> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the persisted bookings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @return the range of matching persisted bookings
	 */
	public static List<PersistedBooking> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted bookings
	 */
	public static List<PersistedBooking> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted bookings
	 */
	public static List<PersistedBooking> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted booking in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public static PersistedBooking findByUuid_First(
			String uuid, OrderByComparator<PersistedBooking> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first persisted booking in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public static PersistedBooking fetchByUuid_First(
		String uuid, OrderByComparator<PersistedBooking> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted booking in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public static PersistedBooking findByUuid_Last(
			String uuid, OrderByComparator<PersistedBooking> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted booking in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public static PersistedBooking fetchByUuid_Last(
		String uuid, OrderByComparator<PersistedBooking> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the persisted bookings before and after the current persisted booking in the ordered set where uuid = &#63;.
	 *
	 * @param bookingId the primary key of the current persisted booking
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted booking
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	public static PersistedBooking[] findByUuid_PrevAndNext(
			long bookingId, String uuid,
			OrderByComparator<PersistedBooking> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().findByUuid_PrevAndNext(
			bookingId, uuid, orderByComparator);
	}

	/**
	 * Removes all the persisted bookings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of persisted bookings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted bookings
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the persisted bookings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted bookings
	 */
	public static List<PersistedBooking> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the persisted bookings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @return the range of matching persisted bookings
	 */
	public static List<PersistedBooking> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted bookings
	 */
	public static List<PersistedBooking> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted bookings
	 */
	public static List<PersistedBooking> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted booking in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public static PersistedBooking findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersistedBooking> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first persisted booking in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public static PersistedBooking fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersistedBooking> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last persisted booking in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public static PersistedBooking findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersistedBooking> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last persisted booking in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public static PersistedBooking fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersistedBooking> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the persisted bookings before and after the current persisted booking in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param bookingId the primary key of the current persisted booking
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted booking
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	public static PersistedBooking[] findByUuid_C_PrevAndNext(
			long bookingId, String uuid, long companyId,
			OrderByComparator<PersistedBooking> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().findByUuid_C_PrevAndNext(
			bookingId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the persisted bookings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of persisted bookings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted bookings
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the persisted bookings where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @return the matching persisted bookings
	 */
	public static List<PersistedBooking> findByRoomId(long roomId) {
		return getPersistence().findByRoomId(roomId);
	}

	/**
	 * Returns a range of all the persisted bookings where roomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param roomId the room ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @return the range of matching persisted bookings
	 */
	public static List<PersistedBooking> findByRoomId(
		long roomId, int start, int end) {

		return getPersistence().findByRoomId(roomId, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where roomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param roomId the room ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted bookings
	 */
	public static List<PersistedBooking> findByRoomId(
		long roomId, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator) {

		return getPersistence().findByRoomId(
			roomId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where roomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param roomId the room ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted bookings
	 */
	public static List<PersistedBooking> findByRoomId(
		long roomId, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRoomId(
			roomId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted booking in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public static PersistedBooking findByRoomId_First(
			long roomId, OrderByComparator<PersistedBooking> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().findByRoomId_First(roomId, orderByComparator);
	}

	/**
	 * Returns the first persisted booking in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public static PersistedBooking fetchByRoomId_First(
		long roomId, OrderByComparator<PersistedBooking> orderByComparator) {

		return getPersistence().fetchByRoomId_First(roomId, orderByComparator);
	}

	/**
	 * Returns the last persisted booking in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public static PersistedBooking findByRoomId_Last(
			long roomId, OrderByComparator<PersistedBooking> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().findByRoomId_Last(roomId, orderByComparator);
	}

	/**
	 * Returns the last persisted booking in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public static PersistedBooking fetchByRoomId_Last(
		long roomId, OrderByComparator<PersistedBooking> orderByComparator) {

		return getPersistence().fetchByRoomId_Last(roomId, orderByComparator);
	}

	/**
	 * Returns the persisted bookings before and after the current persisted booking in the ordered set where roomId = &#63;.
	 *
	 * @param bookingId the primary key of the current persisted booking
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted booking
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	public static PersistedBooking[] findByRoomId_PrevAndNext(
			long bookingId, long roomId,
			OrderByComparator<PersistedBooking> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().findByRoomId_PrevAndNext(
			bookingId, roomId, orderByComparator);
	}

	/**
	 * Removes all the persisted bookings where roomId = &#63; from the database.
	 *
	 * @param roomId the room ID
	 */
	public static void removeByRoomId(long roomId) {
		getPersistence().removeByRoomId(roomId);
	}

	/**
	 * Returns the number of persisted bookings where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @return the number of matching persisted bookings
	 */
	public static int countByRoomId(long roomId) {
		return getPersistence().countByRoomId(roomId);
	}

	/**
	 * Returns all the persisted bookings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching persisted bookings
	 */
	public static List<PersistedBooking> findByUserId(long userId) {
		return getPersistence().findByUserId(userId);
	}

	/**
	 * Returns a range of all the persisted bookings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @return the range of matching persisted bookings
	 */
	public static List<PersistedBooking> findByUserId(
		long userId, int start, int end) {

		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted bookings
	 */
	public static List<PersistedBooking> findByUserId(
		long userId, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted bookings
	 */
	public static List<PersistedBooking> findByUserId(
		long userId, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUserId(
			userId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted booking in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public static PersistedBooking findByUserId_First(
			long userId, OrderByComparator<PersistedBooking> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the first persisted booking in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public static PersistedBooking fetchByUserId_First(
		long userId, OrderByComparator<PersistedBooking> orderByComparator) {

		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	 * Returns the last persisted booking in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public static PersistedBooking findByUserId_Last(
			long userId, OrderByComparator<PersistedBooking> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the last persisted booking in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public static PersistedBooking fetchByUserId_Last(
		long userId, OrderByComparator<PersistedBooking> orderByComparator) {

		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	 * Returns the persisted bookings before and after the current persisted booking in the ordered set where userId = &#63;.
	 *
	 * @param bookingId the primary key of the current persisted booking
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted booking
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	public static PersistedBooking[] findByUserId_PrevAndNext(
			long bookingId, long userId,
			OrderByComparator<PersistedBooking> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().findByUserId_PrevAndNext(
			bookingId, userId, orderByComparator);
	}

	/**
	 * Removes all the persisted bookings where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public static void removeByUserId(long userId) {
		getPersistence().removeByUserId(userId);
	}

	/**
	 * Returns the number of persisted bookings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching persisted bookings
	 */
	public static int countByUserId(long userId) {
		return getPersistence().countByUserId(userId);
	}

	/**
	 * Returns the persisted booking where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedBookingException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public static PersistedBooking findByC_ERC(
			long companyId, String externalReferenceCode)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted booking where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public static PersistedBooking fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted booking where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public static PersistedBooking fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the persisted booking where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted booking that was removed
	 */
	public static PersistedBooking removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of persisted bookings where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted bookings
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the persisted booking in the entity cache if it is enabled.
	 *
	 * @param persistedBooking the persisted booking
	 */
	public static void cacheResult(PersistedBooking persistedBooking) {
		getPersistence().cacheResult(persistedBooking);
	}

	/**
	 * Caches the persisted bookings in the entity cache if it is enabled.
	 *
	 * @param persistedBookings the persisted bookings
	 */
	public static void cacheResult(List<PersistedBooking> persistedBookings) {
		getPersistence().cacheResult(persistedBookings);
	}

	/**
	 * Creates a new persisted booking with the primary key. Does not add the persisted booking to the database.
	 *
	 * @param bookingId the primary key for the new persisted booking
	 * @return the new persisted booking
	 */
	public static PersistedBooking create(long bookingId) {
		return getPersistence().create(bookingId);
	}

	/**
	 * Removes the persisted booking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingId the primary key of the persisted booking
	 * @return the persisted booking that was removed
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	public static PersistedBooking remove(long bookingId)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().remove(bookingId);
	}

	public static PersistedBooking updateImpl(
		PersistedBooking persistedBooking) {

		return getPersistence().updateImpl(persistedBooking);
	}

	/**
	 * Returns the persisted booking with the primary key or throws a <code>NoSuchPersistedBookingException</code> if it could not be found.
	 *
	 * @param bookingId the primary key of the persisted booking
	 * @return the persisted booking
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	public static PersistedBooking findByPrimaryKey(long bookingId)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedBookingException {

		return getPersistence().findByPrimaryKey(bookingId);
	}

	/**
	 * Returns the persisted booking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookingId the primary key of the persisted booking
	 * @return the persisted booking, or <code>null</code> if a persisted booking with the primary key could not be found
	 */
	public static PersistedBooking fetchByPrimaryKey(long bookingId) {
		return getPersistence().fetchByPrimaryKey(bookingId);
	}

	/**
	 * Returns all the persisted bookings.
	 *
	 * @return the persisted bookings
	 */
	public static List<PersistedBooking> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the persisted bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @return the range of persisted bookings
	 */
	public static List<PersistedBooking> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the persisted bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted bookings
	 */
	public static List<PersistedBooking> findAll(
		int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted bookings
	 */
	public static List<PersistedBooking> findAll(
		int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the persisted bookings from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of persisted bookings.
	 *
	 * @return the number of persisted bookings
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of persisted participants associated with the persisted booking.
	 *
	 * @param pk the primary key of the persisted booking
	 * @return long[] of the primaryKeys of persisted participants associated with the persisted booking
	 */
	public static long[] getPersistedParticipantPrimaryKeys(long pk) {
		return getPersistence().getPersistedParticipantPrimaryKeys(pk);
	}

	/**
	 * Returns all the persisted booking associated with the persisted participant.
	 *
	 * @param pk the primary key of the persisted participant
	 * @return the persisted bookings associated with the persisted participant
	 */
	public static List<PersistedBooking>
		getPersistedParticipantPersistedBookings(long pk) {

		return getPersistence().getPersistedParticipantPersistedBookings(pk);
	}

	/**
	 * Returns all the persisted booking associated with the persisted participant.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted participant
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @return the range of persisted bookings associated with the persisted participant
	 */
	public static List<PersistedBooking>
		getPersistedParticipantPersistedBookings(long pk, int start, int end) {

		return getPersistence().getPersistedParticipantPersistedBookings(
			pk, start, end);
	}

	/**
	 * Returns all the persisted booking associated with the persisted participant.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted participant
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted bookings associated with the persisted participant
	 */
	public static List<PersistedBooking>
		getPersistedParticipantPersistedBookings(
			long pk, int start, int end,
			OrderByComparator<PersistedBooking> orderByComparator) {

		return getPersistence().getPersistedParticipantPersistedBookings(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persisted participants associated with the persisted booking.
	 *
	 * @param pk the primary key of the persisted booking
	 * @return the number of persisted participants associated with the persisted booking
	 */
	public static int getPersistedParticipantsSize(long pk) {
		return getPersistence().getPersistedParticipantsSize(pk);
	}

	/**
	 * Returns <code>true</code> if the persisted participant is associated with the persisted booking.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPK the primary key of the persisted participant
	 * @return <code>true</code> if the persisted participant is associated with the persisted booking; <code>false</code> otherwise
	 */
	public static boolean containsPersistedParticipant(
		long pk, long persistedParticipantPK) {

		return getPersistence().containsPersistedParticipant(
			pk, persistedParticipantPK);
	}

	/**
	 * Returns <code>true</code> if the persisted booking has any persisted participants associated with it.
	 *
	 * @param pk the primary key of the persisted booking to check for associations with persisted participants
	 * @return <code>true</code> if the persisted booking has any persisted participants associated with it; <code>false</code> otherwise
	 */
	public static boolean containsPersistedParticipants(long pk) {
		return getPersistence().containsPersistedParticipants(pk);
	}

	/**
	 * Adds an association between the persisted booking and the persisted participant. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPK the primary key of the persisted participant
	 */
	public static void addPersistedParticipant(
		long pk, long persistedParticipantPK) {

		getPersistence().addPersistedParticipant(pk, persistedParticipantPK);
	}

	/**
	 * Adds an association between the persisted booking and the persisted participant. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipant the persisted participant
	 */
	public static void addPersistedParticipant(
		long pk,
		jp.co.liferay.reservation.model.PersistedParticipant
			persistedParticipant) {

		getPersistence().addPersistedParticipant(pk, persistedParticipant);
	}

	/**
	 * Adds an association between the persisted booking and the persisted participants. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPKs the primary keys of the persisted participants
	 */
	public static void addPersistedParticipants(
		long pk, long[] persistedParticipantPKs) {

		getPersistence().addPersistedParticipants(pk, persistedParticipantPKs);
	}

	/**
	 * Adds an association between the persisted booking and the persisted participants. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipants the persisted participants
	 */
	public static void addPersistedParticipants(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedParticipant>
			persistedParticipants) {

		getPersistence().addPersistedParticipants(pk, persistedParticipants);
	}

	/**
	 * Clears all associations between the persisted booking and its persisted participants. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking to clear the associated persisted participants from
	 */
	public static void clearPersistedParticipants(long pk) {
		getPersistence().clearPersistedParticipants(pk);
	}

	/**
	 * Removes the association between the persisted booking and the persisted participant. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPK the primary key of the persisted participant
	 */
	public static void removePersistedParticipant(
		long pk, long persistedParticipantPK) {

		getPersistence().removePersistedParticipant(pk, persistedParticipantPK);
	}

	/**
	 * Removes the association between the persisted booking and the persisted participant. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipant the persisted participant
	 */
	public static void removePersistedParticipant(
		long pk,
		jp.co.liferay.reservation.model.PersistedParticipant
			persistedParticipant) {

		getPersistence().removePersistedParticipant(pk, persistedParticipant);
	}

	/**
	 * Removes the association between the persisted booking and the persisted participants. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPKs the primary keys of the persisted participants
	 */
	public static void removePersistedParticipants(
		long pk, long[] persistedParticipantPKs) {

		getPersistence().removePersistedParticipants(
			pk, persistedParticipantPKs);
	}

	/**
	 * Removes the association between the persisted booking and the persisted participants. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipants the persisted participants
	 */
	public static void removePersistedParticipants(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedParticipant>
			persistedParticipants) {

		getPersistence().removePersistedParticipants(pk, persistedParticipants);
	}

	/**
	 * Sets the persisted participants associated with the persisted booking, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPKs the primary keys of the persisted participants to be associated with the persisted booking
	 */
	public static void setPersistedParticipants(
		long pk, long[] persistedParticipantPKs) {

		getPersistence().setPersistedParticipants(pk, persistedParticipantPKs);
	}

	/**
	 * Sets the persisted participants associated with the persisted booking, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipants the persisted participants to be associated with the persisted booking
	 */
	public static void setPersistedParticipants(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedParticipant>
			persistedParticipants) {

		getPersistence().setPersistedParticipants(pk, persistedParticipants);
	}

	public static PersistedBookingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedBookingPersistence, PersistedBookingPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PersistedBookingPersistence.class);

		ServiceTracker<PersistedBookingPersistence, PersistedBookingPersistence>
			serviceTracker =
				new ServiceTracker
					<PersistedBookingPersistence, PersistedBookingPersistence>(
						bundle.getBundleContext(),
						PersistedBookingPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}