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

import jp.co.liferay.reservation.exception.NoSuchPersistedRoomException;
import jp.co.liferay.reservation.model.PersistedRoom;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the persisted room service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedRoomUtil
 * @generated
 */
@ProviderType
public interface PersistedRoomPersistence
	extends BasePersistence<PersistedRoom> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersistedRoomUtil} to access the persisted room persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the persisted rooms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted rooms
	 */
	public java.util.List<PersistedRoom> findByUuid(String uuid);

	/**
	 * Returns a range of all the persisted rooms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of matching persisted rooms
	 */
	public java.util.List<PersistedRoom> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the persisted rooms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted rooms
	 */
	public java.util.List<PersistedRoom> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted rooms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted rooms
	 */
	public java.util.List<PersistedRoom> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public PersistedRoom findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
				orderByComparator)
		throws NoSuchPersistedRoomException;

	/**
	 * Returns the first persisted room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public PersistedRoom fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator);

	/**
	 * Returns the last persisted room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public PersistedRoom findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
				orderByComparator)
		throws NoSuchPersistedRoomException;

	/**
	 * Returns the last persisted room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public PersistedRoom fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator);

	/**
	 * Returns the persisted rooms before and after the current persisted room in the ordered set where uuid = &#63;.
	 *
	 * @param roomId the primary key of the current persisted room
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted room
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	public PersistedRoom[] findByUuid_PrevAndNext(
			long roomId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
				orderByComparator)
		throws NoSuchPersistedRoomException;

	/**
	 * Removes all the persisted rooms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of persisted rooms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted rooms
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the persisted rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted rooms
	 */
	public java.util.List<PersistedRoom> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the persisted rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of matching persisted rooms
	 */
	public java.util.List<PersistedRoom> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the persisted rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted rooms
	 */
	public java.util.List<PersistedRoom> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public java.util.List<PersistedRoom> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public PersistedRoom findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
				orderByComparator)
		throws NoSuchPersistedRoomException;

	/**
	 * Returns the first persisted room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public PersistedRoom fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator);

	/**
	 * Returns the last persisted room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public PersistedRoom findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
				orderByComparator)
		throws NoSuchPersistedRoomException;

	/**
	 * Returns the last persisted room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public PersistedRoom fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator);

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
	public PersistedRoom[] findByUuid_C_PrevAndNext(
			long roomId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
				orderByComparator)
		throws NoSuchPersistedRoomException;

	/**
	 * Removes all the persisted rooms where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of persisted rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted rooms
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the persisted rooms where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the matching persisted rooms
	 */
	public java.util.List<PersistedRoom> findByOfficeId(long officeId);

	/**
	 * Returns a range of all the persisted rooms where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of matching persisted rooms
	 */
	public java.util.List<PersistedRoom> findByOfficeId(
		long officeId, int start, int end);

	/**
	 * Returns an ordered range of all the persisted rooms where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted rooms
	 */
	public java.util.List<PersistedRoom> findByOfficeId(
		long officeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted rooms where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted rooms
	 */
	public java.util.List<PersistedRoom> findByOfficeId(
		long officeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted room in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public PersistedRoom findByOfficeId_First(
			long officeId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
				orderByComparator)
		throws NoSuchPersistedRoomException;

	/**
	 * Returns the first persisted room in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public PersistedRoom fetchByOfficeId_First(
		long officeId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator);

	/**
	 * Returns the last persisted room in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public PersistedRoom findByOfficeId_Last(
			long officeId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
				orderByComparator)
		throws NoSuchPersistedRoomException;

	/**
	 * Returns the last persisted room in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public PersistedRoom fetchByOfficeId_Last(
		long officeId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator);

	/**
	 * Returns the persisted rooms before and after the current persisted room in the ordered set where officeId = &#63;.
	 *
	 * @param roomId the primary key of the current persisted room
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted room
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	public PersistedRoom[] findByOfficeId_PrevAndNext(
			long roomId, long officeId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
				orderByComparator)
		throws NoSuchPersistedRoomException;

	/**
	 * Removes all the persisted rooms where officeId = &#63; from the database.
	 *
	 * @param officeId the office ID
	 */
	public void removeByOfficeId(long officeId);

	/**
	 * Returns the number of persisted rooms where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the number of matching persisted rooms
	 */
	public int countByOfficeId(long officeId);

	/**
	 * Returns all the persisted rooms where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @return the matching persisted rooms
	 */
	public java.util.List<PersistedRoom> findByCalendarId(long calendarId);

	/**
	 * Returns a range of all the persisted rooms where calendarId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param calendarId the calendar ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of matching persisted rooms
	 */
	public java.util.List<PersistedRoom> findByCalendarId(
		long calendarId, int start, int end);

	/**
	 * Returns an ordered range of all the persisted rooms where calendarId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param calendarId the calendar ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted rooms
	 */
	public java.util.List<PersistedRoom> findByCalendarId(
		long calendarId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted rooms where calendarId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param calendarId the calendar ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted rooms
	 */
	public java.util.List<PersistedRoom> findByCalendarId(
		long calendarId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted room in the ordered set where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public PersistedRoom findByCalendarId_First(
			long calendarId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
				orderByComparator)
		throws NoSuchPersistedRoomException;

	/**
	 * Returns the first persisted room in the ordered set where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public PersistedRoom fetchByCalendarId_First(
		long calendarId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator);

	/**
	 * Returns the last persisted room in the ordered set where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public PersistedRoom findByCalendarId_Last(
			long calendarId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
				orderByComparator)
		throws NoSuchPersistedRoomException;

	/**
	 * Returns the last persisted room in the ordered set where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public PersistedRoom fetchByCalendarId_Last(
		long calendarId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator);

	/**
	 * Returns the persisted rooms before and after the current persisted room in the ordered set where calendarId = &#63;.
	 *
	 * @param roomId the primary key of the current persisted room
	 * @param calendarId the calendar ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted room
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	public PersistedRoom[] findByCalendarId_PrevAndNext(
			long roomId, long calendarId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
				orderByComparator)
		throws NoSuchPersistedRoomException;

	/**
	 * Removes all the persisted rooms where calendarId = &#63; from the database.
	 *
	 * @param calendarId the calendar ID
	 */
	public void removeByCalendarId(long calendarId);

	/**
	 * Returns the number of persisted rooms where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @return the number of matching persisted rooms
	 */
	public int countByCalendarId(long calendarId);

	/**
	 * Returns the persisted room where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedRoomException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	public PersistedRoom findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedRoomException;

	/**
	 * Returns the persisted room where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public PersistedRoom fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the persisted room where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	public PersistedRoom fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the persisted room where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted room that was removed
	 */
	public PersistedRoom removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedRoomException;

	/**
	 * Returns the number of persisted rooms where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted rooms
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the persisted room in the entity cache if it is enabled.
	 *
	 * @param persistedRoom the persisted room
	 */
	public void cacheResult(PersistedRoom persistedRoom);

	/**
	 * Caches the persisted rooms in the entity cache if it is enabled.
	 *
	 * @param persistedRooms the persisted rooms
	 */
	public void cacheResult(java.util.List<PersistedRoom> persistedRooms);

	/**
	 * Creates a new persisted room with the primary key. Does not add the persisted room to the database.
	 *
	 * @param roomId the primary key for the new persisted room
	 * @return the new persisted room
	 */
	public PersistedRoom create(long roomId);

	/**
	 * Removes the persisted room with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roomId the primary key of the persisted room
	 * @return the persisted room that was removed
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	public PersistedRoom remove(long roomId)
		throws NoSuchPersistedRoomException;

	public PersistedRoom updateImpl(PersistedRoom persistedRoom);

	/**
	 * Returns the persisted room with the primary key or throws a <code>NoSuchPersistedRoomException</code> if it could not be found.
	 *
	 * @param roomId the primary key of the persisted room
	 * @return the persisted room
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	public PersistedRoom findByPrimaryKey(long roomId)
		throws NoSuchPersistedRoomException;

	/**
	 * Returns the persisted room with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roomId the primary key of the persisted room
	 * @return the persisted room, or <code>null</code> if a persisted room with the primary key could not be found
	 */
	public PersistedRoom fetchByPrimaryKey(long roomId);

	/**
	 * Returns all the persisted rooms.
	 *
	 * @return the persisted rooms
	 */
	public java.util.List<PersistedRoom> findAll();

	/**
	 * Returns a range of all the persisted rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of persisted rooms
	 */
	public java.util.List<PersistedRoom> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the persisted rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted rooms
	 */
	public java.util.List<PersistedRoom> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted rooms
	 */
	public java.util.List<PersistedRoom> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the persisted rooms from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of persisted rooms.
	 *
	 * @return the number of persisted rooms
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of persisted purposes associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return long[] of the primaryKeys of persisted purposes associated with the persisted room
	 */
	public long[] getPersistedPurposePrimaryKeys(long pk);

	/**
	 * Returns all the persisted room associated with the persisted purpose.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @return the persisted rooms associated with the persisted purpose
	 */
	public java.util.List<PersistedRoom> getPersistedPurposePersistedRooms(
		long pk);

	/**
	 * Returns all the persisted room associated with the persisted purpose.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @return the range of persisted rooms associated with the persisted purpose
	 */
	public java.util.List<PersistedRoom> getPersistedPurposePersistedRooms(
		long pk, int start, int end);

	/**
	 * Returns all the persisted room associated with the persisted purpose.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted rooms associated with the persisted purpose
	 */
	public java.util.List<PersistedRoom> getPersistedPurposePersistedRooms(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator);

	/**
	 * Returns the number of persisted purposes associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return the number of persisted purposes associated with the persisted room
	 */
	public int getPersistedPurposesSize(long pk);

	/**
	 * Returns <code>true</code> if the persisted purpose is associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePK the primary key of the persisted purpose
	 * @return <code>true</code> if the persisted purpose is associated with the persisted room; <code>false</code> otherwise
	 */
	public boolean containsPersistedPurpose(long pk, long persistedPurposePK);

	/**
	 * Returns <code>true</code> if the persisted room has any persisted purposes associated with it.
	 *
	 * @param pk the primary key of the persisted room to check for associations with persisted purposes
	 * @return <code>true</code> if the persisted room has any persisted purposes associated with it; <code>false</code> otherwise
	 */
	public boolean containsPersistedPurposes(long pk);

	/**
	 * Adds an association between the persisted room and the persisted purpose. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePK the primary key of the persisted purpose
	 */
	public void addPersistedPurpose(long pk, long persistedPurposePK);

	/**
	 * Adds an association between the persisted room and the persisted purpose. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurpose the persisted purpose
	 */
	public void addPersistedPurpose(
		long pk,
		jp.co.liferay.reservation.model.PersistedPurpose persistedPurpose);

	/**
	 * Adds an association between the persisted room and the persisted purposes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePKs the primary keys of the persisted purposes
	 */
	public void addPersistedPurposes(long pk, long[] persistedPurposePKs);

	/**
	 * Adds an association between the persisted room and the persisted purposes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposes the persisted purposes
	 */
	public void addPersistedPurposes(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedPurpose>
			persistedPurposes);

	/**
	 * Clears all associations between the persisted room and its persisted purposes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room to clear the associated persisted purposes from
	 */
	public void clearPersistedPurposes(long pk);

	/**
	 * Removes the association between the persisted room and the persisted purpose. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePK the primary key of the persisted purpose
	 */
	public void removePersistedPurpose(long pk, long persistedPurposePK);

	/**
	 * Removes the association between the persisted room and the persisted purpose. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurpose the persisted purpose
	 */
	public void removePersistedPurpose(
		long pk,
		jp.co.liferay.reservation.model.PersistedPurpose persistedPurpose);

	/**
	 * Removes the association between the persisted room and the persisted purposes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePKs the primary keys of the persisted purposes
	 */
	public void removePersistedPurposes(long pk, long[] persistedPurposePKs);

	/**
	 * Removes the association between the persisted room and the persisted purposes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposes the persisted purposes
	 */
	public void removePersistedPurposes(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedPurpose>
			persistedPurposes);

	/**
	 * Sets the persisted purposes associated with the persisted room, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePKs the primary keys of the persisted purposes to be associated with the persisted room
	 */
	public void setPersistedPurposes(long pk, long[] persistedPurposePKs);

	/**
	 * Sets the persisted purposes associated with the persisted room, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposes the persisted purposes to be associated with the persisted room
	 */
	public void setPersistedPurposes(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedPurpose>
			persistedPurposes);

	/**
	 * Returns the primaryKeys of persisted amenities associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return long[] of the primaryKeys of persisted amenities associated with the persisted room
	 */
	public long[] getPersistedAmenityPrimaryKeys(long pk);

	/**
	 * Returns all the persisted room associated with the persisted amenity.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @return the persisted rooms associated with the persisted amenity
	 */
	public java.util.List<PersistedRoom> getPersistedAmenityPersistedRooms(
		long pk);

	/**
	 * Returns all the persisted room associated with the persisted amenity.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @return the range of persisted rooms associated with the persisted amenity
	 */
	public java.util.List<PersistedRoom> getPersistedAmenityPersistedRooms(
		long pk, int start, int end);

	/**
	 * Returns all the persisted room associated with the persisted amenity.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted rooms associated with the persisted amenity
	 */
	public java.util.List<PersistedRoom> getPersistedAmenityPersistedRooms(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedRoom>
			orderByComparator);

	/**
	 * Returns the number of persisted amenities associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return the number of persisted amenities associated with the persisted room
	 */
	public int getPersistedAmenitiesSize(long pk);

	/**
	 * Returns <code>true</code> if the persisted amenity is associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPK the primary key of the persisted amenity
	 * @return <code>true</code> if the persisted amenity is associated with the persisted room; <code>false</code> otherwise
	 */
	public boolean containsPersistedAmenity(long pk, long persistedAmenityPK);

	/**
	 * Returns <code>true</code> if the persisted room has any persisted amenities associated with it.
	 *
	 * @param pk the primary key of the persisted room to check for associations with persisted amenities
	 * @return <code>true</code> if the persisted room has any persisted amenities associated with it; <code>false</code> otherwise
	 */
	public boolean containsPersistedAmenities(long pk);

	/**
	 * Adds an association between the persisted room and the persisted amenity. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPK the primary key of the persisted amenity
	 */
	public void addPersistedAmenity(long pk, long persistedAmenityPK);

	/**
	 * Adds an association between the persisted room and the persisted amenity. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenity the persisted amenity
	 */
	public void addPersistedAmenity(
		long pk,
		jp.co.liferay.reservation.model.PersistedAmenity persistedAmenity);

	/**
	 * Adds an association between the persisted room and the persisted amenities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPKs the primary keys of the persisted amenities
	 */
	public void addPersistedAmenities(long pk, long[] persistedAmenityPKs);

	/**
	 * Adds an association between the persisted room and the persisted amenities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenities the persisted amenities
	 */
	public void addPersistedAmenities(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
			persistedAmenities);

	/**
	 * Clears all associations between the persisted room and its persisted amenities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room to clear the associated persisted amenities from
	 */
	public void clearPersistedAmenities(long pk);

	/**
	 * Removes the association between the persisted room and the persisted amenity. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPK the primary key of the persisted amenity
	 */
	public void removePersistedAmenity(long pk, long persistedAmenityPK);

	/**
	 * Removes the association between the persisted room and the persisted amenity. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenity the persisted amenity
	 */
	public void removePersistedAmenity(
		long pk,
		jp.co.liferay.reservation.model.PersistedAmenity persistedAmenity);

	/**
	 * Removes the association between the persisted room and the persisted amenities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPKs the primary keys of the persisted amenities
	 */
	public void removePersistedAmenities(long pk, long[] persistedAmenityPKs);

	/**
	 * Removes the association between the persisted room and the persisted amenities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenities the persisted amenities
	 */
	public void removePersistedAmenities(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
			persistedAmenities);

	/**
	 * Sets the persisted amenities associated with the persisted room, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPKs the primary keys of the persisted amenities to be associated with the persisted room
	 */
	public void setPersistedAmenities(long pk, long[] persistedAmenityPKs);

	/**
	 * Sets the persisted amenities associated with the persisted room, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenities the persisted amenities to be associated with the persisted room
	 */
	public void setPersistedAmenities(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
			persistedAmenities);

}