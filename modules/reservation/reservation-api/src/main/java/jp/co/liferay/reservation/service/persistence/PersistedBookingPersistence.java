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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import jp.co.liferay.reservation.exception.NoSuchPersistedBookingException;
import jp.co.liferay.reservation.model.PersistedBooking;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the persisted booking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedBookingUtil
 * @generated
 */
@ProviderType
public interface PersistedBookingPersistence
	extends BasePersistence<PersistedBooking> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersistedBookingUtil} to access the persisted booking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the persisted bookings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted bookings
	 */
	public java.util.List<PersistedBooking> findByUuid(String uuid);

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
	public java.util.List<PersistedBooking> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<PersistedBooking> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator);

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
	public java.util.List<PersistedBooking> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted booking in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public PersistedBooking findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
				orderByComparator)
		throws NoSuchPersistedBookingException;

	/**
	 * Returns the first persisted booking in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public PersistedBooking fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator);

	/**
	 * Returns the last persisted booking in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public PersistedBooking findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
				orderByComparator)
		throws NoSuchPersistedBookingException;

	/**
	 * Returns the last persisted booking in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public PersistedBooking fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator);

	/**
	 * Returns the persisted bookings before and after the current persisted booking in the ordered set where uuid = &#63;.
	 *
	 * @param bookingId the primary key of the current persisted booking
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted booking
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	public PersistedBooking[] findByUuid_PrevAndNext(
			long bookingId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
				orderByComparator)
		throws NoSuchPersistedBookingException;

	/**
	 * Removes all the persisted bookings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of persisted bookings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted bookings
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the persisted bookings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted bookings
	 */
	public java.util.List<PersistedBooking> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<PersistedBooking> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<PersistedBooking> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator);

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
	public java.util.List<PersistedBooking> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted booking in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public PersistedBooking findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
				orderByComparator)
		throws NoSuchPersistedBookingException;

	/**
	 * Returns the first persisted booking in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public PersistedBooking fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator);

	/**
	 * Returns the last persisted booking in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public PersistedBooking findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
				orderByComparator)
		throws NoSuchPersistedBookingException;

	/**
	 * Returns the last persisted booking in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public PersistedBooking fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator);

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
	public PersistedBooking[] findByUuid_C_PrevAndNext(
			long bookingId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
				orderByComparator)
		throws NoSuchPersistedBookingException;

	/**
	 * Removes all the persisted bookings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of persisted bookings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted bookings
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the persisted bookings where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @return the matching persisted bookings
	 */
	public java.util.List<PersistedBooking> findByRoomId(long roomId);

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
	public java.util.List<PersistedBooking> findByRoomId(
		long roomId, int start, int end);

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
	public java.util.List<PersistedBooking> findByRoomId(
		long roomId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator);

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
	public java.util.List<PersistedBooking> findByRoomId(
		long roomId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted booking in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public PersistedBooking findByRoomId_First(
			long roomId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
				orderByComparator)
		throws NoSuchPersistedBookingException;

	/**
	 * Returns the first persisted booking in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public PersistedBooking fetchByRoomId_First(
		long roomId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator);

	/**
	 * Returns the last persisted booking in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public PersistedBooking findByRoomId_Last(
			long roomId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
				orderByComparator)
		throws NoSuchPersistedBookingException;

	/**
	 * Returns the last persisted booking in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public PersistedBooking fetchByRoomId_Last(
		long roomId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator);

	/**
	 * Returns the persisted bookings before and after the current persisted booking in the ordered set where roomId = &#63;.
	 *
	 * @param bookingId the primary key of the current persisted booking
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted booking
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	public PersistedBooking[] findByRoomId_PrevAndNext(
			long bookingId, long roomId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
				orderByComparator)
		throws NoSuchPersistedBookingException;

	/**
	 * Removes all the persisted bookings where roomId = &#63; from the database.
	 *
	 * @param roomId the room ID
	 */
	public void removeByRoomId(long roomId);

	/**
	 * Returns the number of persisted bookings where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @return the number of matching persisted bookings
	 */
	public int countByRoomId(long roomId);

	/**
	 * Returns all the persisted bookings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching persisted bookings
	 */
	public java.util.List<PersistedBooking> findByUserId(long userId);

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
	public java.util.List<PersistedBooking> findByUserId(
		long userId, int start, int end);

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
	public java.util.List<PersistedBooking> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator);

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
	public java.util.List<PersistedBooking> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted booking in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public PersistedBooking findByUserId_First(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
				orderByComparator)
		throws NoSuchPersistedBookingException;

	/**
	 * Returns the first persisted booking in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public PersistedBooking fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator);

	/**
	 * Returns the last persisted booking in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public PersistedBooking findByUserId_Last(
			long userId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
				orderByComparator)
		throws NoSuchPersistedBookingException;

	/**
	 * Returns the last persisted booking in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public PersistedBooking fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator);

	/**
	 * Returns the persisted bookings before and after the current persisted booking in the ordered set where userId = &#63;.
	 *
	 * @param bookingId the primary key of the current persisted booking
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted booking
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	public PersistedBooking[] findByUserId_PrevAndNext(
			long bookingId, long userId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
				orderByComparator)
		throws NoSuchPersistedBookingException;

	/**
	 * Removes all the persisted bookings where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	public void removeByUserId(long userId);

	/**
	 * Returns the number of persisted bookings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching persisted bookings
	 */
	public int countByUserId(long userId);

	/**
	 * Returns the persisted booking where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedBookingException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	public PersistedBooking findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedBookingException;

	/**
	 * Returns the persisted booking where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public PersistedBooking fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the persisted booking where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	public PersistedBooking fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the persisted booking where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted booking that was removed
	 */
	public PersistedBooking removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedBookingException;

	/**
	 * Returns the number of persisted bookings where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted bookings
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the persisted booking in the entity cache if it is enabled.
	 *
	 * @param persistedBooking the persisted booking
	 */
	public void cacheResult(PersistedBooking persistedBooking);

	/**
	 * Caches the persisted bookings in the entity cache if it is enabled.
	 *
	 * @param persistedBookings the persisted bookings
	 */
	public void cacheResult(java.util.List<PersistedBooking> persistedBookings);

	/**
	 * Creates a new persisted booking with the primary key. Does not add the persisted booking to the database.
	 *
	 * @param bookingId the primary key for the new persisted booking
	 * @return the new persisted booking
	 */
	public PersistedBooking create(long bookingId);

	/**
	 * Removes the persisted booking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingId the primary key of the persisted booking
	 * @return the persisted booking that was removed
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	public PersistedBooking remove(long bookingId)
		throws NoSuchPersistedBookingException;

	public PersistedBooking updateImpl(PersistedBooking persistedBooking);

	/**
	 * Returns the persisted booking with the primary key or throws a <code>NoSuchPersistedBookingException</code> if it could not be found.
	 *
	 * @param bookingId the primary key of the persisted booking
	 * @return the persisted booking
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	public PersistedBooking findByPrimaryKey(long bookingId)
		throws NoSuchPersistedBookingException;

	/**
	 * Returns the persisted booking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookingId the primary key of the persisted booking
	 * @return the persisted booking, or <code>null</code> if a persisted booking with the primary key could not be found
	 */
	public PersistedBooking fetchByPrimaryKey(long bookingId);

	/**
	 * Returns all the persisted bookings.
	 *
	 * @return the persisted bookings
	 */
	public java.util.List<PersistedBooking> findAll();

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
	public java.util.List<PersistedBooking> findAll(int start, int end);

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
	public java.util.List<PersistedBooking> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator);

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
	public java.util.List<PersistedBooking> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the persisted bookings from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of persisted bookings.
	 *
	 * @return the number of persisted bookings
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of persisted participants associated with the persisted booking.
	 *
	 * @param pk the primary key of the persisted booking
	 * @return long[] of the primaryKeys of persisted participants associated with the persisted booking
	 */
	public long[] getPersistedParticipantPrimaryKeys(long pk);

	/**
	 * Returns all the persisted booking associated with the persisted participant.
	 *
	 * @param pk the primary key of the persisted participant
	 * @return the persisted bookings associated with the persisted participant
	 */
	public java.util.List<PersistedBooking>
		getPersistedParticipantPersistedBookings(long pk);

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
	public java.util.List<PersistedBooking>
		getPersistedParticipantPersistedBookings(long pk, int start, int end);

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
	public java.util.List<PersistedBooking>
		getPersistedParticipantPersistedBookings(
			long pk, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedBooking>
				orderByComparator);

	/**
	 * Returns the number of persisted participants associated with the persisted booking.
	 *
	 * @param pk the primary key of the persisted booking
	 * @return the number of persisted participants associated with the persisted booking
	 */
	public int getPersistedParticipantsSize(long pk);

	/**
	 * Returns <code>true</code> if the persisted participant is associated with the persisted booking.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPK the primary key of the persisted participant
	 * @return <code>true</code> if the persisted participant is associated with the persisted booking; <code>false</code> otherwise
	 */
	public boolean containsPersistedParticipant(
		long pk, long persistedParticipantPK);

	/**
	 * Returns <code>true</code> if the persisted booking has any persisted participants associated with it.
	 *
	 * @param pk the primary key of the persisted booking to check for associations with persisted participants
	 * @return <code>true</code> if the persisted booking has any persisted participants associated with it; <code>false</code> otherwise
	 */
	public boolean containsPersistedParticipants(long pk);

	/**
	 * Adds an association between the persisted booking and the persisted participant. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPK the primary key of the persisted participant
	 */
	public void addPersistedParticipant(long pk, long persistedParticipantPK);

	/**
	 * Adds an association between the persisted booking and the persisted participant. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipant the persisted participant
	 */
	public void addPersistedParticipant(
		long pk,
		jp.co.liferay.reservation.model.PersistedParticipant
			persistedParticipant);

	/**
	 * Adds an association between the persisted booking and the persisted participants. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPKs the primary keys of the persisted participants
	 */
	public void addPersistedParticipants(
		long pk, long[] persistedParticipantPKs);

	/**
	 * Adds an association between the persisted booking and the persisted participants. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipants the persisted participants
	 */
	public void addPersistedParticipants(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedParticipant>
			persistedParticipants);

	/**
	 * Clears all associations between the persisted booking and its persisted participants. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking to clear the associated persisted participants from
	 */
	public void clearPersistedParticipants(long pk);

	/**
	 * Removes the association between the persisted booking and the persisted participant. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPK the primary key of the persisted participant
	 */
	public void removePersistedParticipant(
		long pk, long persistedParticipantPK);

	/**
	 * Removes the association between the persisted booking and the persisted participant. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipant the persisted participant
	 */
	public void removePersistedParticipant(
		long pk,
		jp.co.liferay.reservation.model.PersistedParticipant
			persistedParticipant);

	/**
	 * Removes the association between the persisted booking and the persisted participants. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPKs the primary keys of the persisted participants
	 */
	public void removePersistedParticipants(
		long pk, long[] persistedParticipantPKs);

	/**
	 * Removes the association between the persisted booking and the persisted participants. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipants the persisted participants
	 */
	public void removePersistedParticipants(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedParticipant>
			persistedParticipants);

	/**
	 * Sets the persisted participants associated with the persisted booking, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPKs the primary keys of the persisted participants to be associated with the persisted booking
	 */
	public void setPersistedParticipants(
		long pk, long[] persistedParticipantPKs);

	/**
	 * Sets the persisted participants associated with the persisted booking, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipants the persisted participants to be associated with the persisted booking
	 */
	public void setPersistedParticipants(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedParticipant>
			persistedParticipants);

}