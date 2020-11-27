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

import jp.co.liferay.reservation.exception.NoSuchPersistedAmenityException;
import jp.co.liferay.reservation.model.PersistedAmenity;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the persisted amenity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedAmenityUtil
 * @generated
 */
@ProviderType
public interface PersistedAmenityPersistence
	extends BasePersistence<PersistedAmenity> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersistedAmenityUtil} to access the persisted amenity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the persisted amenities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted amenities
	 */
	public java.util.List<PersistedAmenity> findByUuid(String uuid);

	/**
	 * Returns a range of all the persisted amenities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @return the range of matching persisted amenities
	 */
	public java.util.List<PersistedAmenity> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the persisted amenities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted amenities
	 */
	public java.util.List<PersistedAmenity> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted amenities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted amenities
	 */
	public java.util.List<PersistedAmenity> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted amenity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted amenity
	 * @throws NoSuchPersistedAmenityException if a matching persisted amenity could not be found
	 */
	public PersistedAmenity findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
				orderByComparator)
		throws NoSuchPersistedAmenityException;

	/**
	 * Returns the first persisted amenity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	public PersistedAmenity fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
			orderByComparator);

	/**
	 * Returns the last persisted amenity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted amenity
	 * @throws NoSuchPersistedAmenityException if a matching persisted amenity could not be found
	 */
	public PersistedAmenity findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
				orderByComparator)
		throws NoSuchPersistedAmenityException;

	/**
	 * Returns the last persisted amenity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	public PersistedAmenity fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
			orderByComparator);

	/**
	 * Returns the persisted amenities before and after the current persisted amenity in the ordered set where uuid = &#63;.
	 *
	 * @param amenityId the primary key of the current persisted amenity
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted amenity
	 * @throws NoSuchPersistedAmenityException if a persisted amenity with the primary key could not be found
	 */
	public PersistedAmenity[] findByUuid_PrevAndNext(
			long amenityId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
				orderByComparator)
		throws NoSuchPersistedAmenityException;

	/**
	 * Removes all the persisted amenities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of persisted amenities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted amenities
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the persisted amenities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted amenities
	 */
	public java.util.List<PersistedAmenity> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the persisted amenities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @return the range of matching persisted amenities
	 */
	public java.util.List<PersistedAmenity> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the persisted amenities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted amenities
	 */
	public java.util.List<PersistedAmenity> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted amenities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted amenities
	 */
	public java.util.List<PersistedAmenity> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted amenity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted amenity
	 * @throws NoSuchPersistedAmenityException if a matching persisted amenity could not be found
	 */
	public PersistedAmenity findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
				orderByComparator)
		throws NoSuchPersistedAmenityException;

	/**
	 * Returns the first persisted amenity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	public PersistedAmenity fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
			orderByComparator);

	/**
	 * Returns the last persisted amenity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted amenity
	 * @throws NoSuchPersistedAmenityException if a matching persisted amenity could not be found
	 */
	public PersistedAmenity findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
				orderByComparator)
		throws NoSuchPersistedAmenityException;

	/**
	 * Returns the last persisted amenity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	public PersistedAmenity fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
			orderByComparator);

	/**
	 * Returns the persisted amenities before and after the current persisted amenity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param amenityId the primary key of the current persisted amenity
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted amenity
	 * @throws NoSuchPersistedAmenityException if a persisted amenity with the primary key could not be found
	 */
	public PersistedAmenity[] findByUuid_C_PrevAndNext(
			long amenityId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
				orderByComparator)
		throws NoSuchPersistedAmenityException;

	/**
	 * Removes all the persisted amenities where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of persisted amenities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted amenities
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the persisted amenity where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedAmenityException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted amenity
	 * @throws NoSuchPersistedAmenityException if a matching persisted amenity could not be found
	 */
	public PersistedAmenity findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedAmenityException;

	/**
	 * Returns the persisted amenity where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	public PersistedAmenity fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the persisted amenity where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	public PersistedAmenity fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the persisted amenity where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted amenity that was removed
	 */
	public PersistedAmenity removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedAmenityException;

	/**
	 * Returns the number of persisted amenities where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted amenities
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the persisted amenity in the entity cache if it is enabled.
	 *
	 * @param persistedAmenity the persisted amenity
	 */
	public void cacheResult(PersistedAmenity persistedAmenity);

	/**
	 * Caches the persisted amenities in the entity cache if it is enabled.
	 *
	 * @param persistedAmenities the persisted amenities
	 */
	public void cacheResult(
		java.util.List<PersistedAmenity> persistedAmenities);

	/**
	 * Creates a new persisted amenity with the primary key. Does not add the persisted amenity to the database.
	 *
	 * @param amenityId the primary key for the new persisted amenity
	 * @return the new persisted amenity
	 */
	public PersistedAmenity create(long amenityId);

	/**
	 * Removes the persisted amenity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amenityId the primary key of the persisted amenity
	 * @return the persisted amenity that was removed
	 * @throws NoSuchPersistedAmenityException if a persisted amenity with the primary key could not be found
	 */
	public PersistedAmenity remove(long amenityId)
		throws NoSuchPersistedAmenityException;

	public PersistedAmenity updateImpl(PersistedAmenity persistedAmenity);

	/**
	 * Returns the persisted amenity with the primary key or throws a <code>NoSuchPersistedAmenityException</code> if it could not be found.
	 *
	 * @param amenityId the primary key of the persisted amenity
	 * @return the persisted amenity
	 * @throws NoSuchPersistedAmenityException if a persisted amenity with the primary key could not be found
	 */
	public PersistedAmenity findByPrimaryKey(long amenityId)
		throws NoSuchPersistedAmenityException;

	/**
	 * Returns the persisted amenity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amenityId the primary key of the persisted amenity
	 * @return the persisted amenity, or <code>null</code> if a persisted amenity with the primary key could not be found
	 */
	public PersistedAmenity fetchByPrimaryKey(long amenityId);

	/**
	 * Returns all the persisted amenities.
	 *
	 * @return the persisted amenities
	 */
	public java.util.List<PersistedAmenity> findAll();

	/**
	 * Returns a range of all the persisted amenities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @return the range of persisted amenities
	 */
	public java.util.List<PersistedAmenity> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the persisted amenities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted amenities
	 */
	public java.util.List<PersistedAmenity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted amenities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted amenities
	 */
	public java.util.List<PersistedAmenity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the persisted amenities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of persisted amenities.
	 *
	 * @return the number of persisted amenities
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of persisted rooms associated with the persisted amenity.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @return long[] of the primaryKeys of persisted rooms associated with the persisted amenity
	 */
	public long[] getPersistedRoomPrimaryKeys(long pk);

	/**
	 * Returns all the persisted amenity associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return the persisted amenities associated with the persisted room
	 */
	public java.util.List<PersistedAmenity> getPersistedRoomPersistedAmenities(
		long pk);

	/**
	 * Returns all the persisted amenity associated with the persisted room.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted room
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of persisted amenities associated with the persisted room
	 */
	public java.util.List<PersistedAmenity> getPersistedRoomPersistedAmenities(
		long pk, int start, int end);

	/**
	 * Returns all the persisted amenity associated with the persisted room.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted room
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted amenities associated with the persisted room
	 */
	public java.util.List<PersistedAmenity> getPersistedRoomPersistedAmenities(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedAmenity>
			orderByComparator);

	/**
	 * Returns the number of persisted rooms associated with the persisted amenity.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @return the number of persisted rooms associated with the persisted amenity
	 */
	public int getPersistedRoomsSize(long pk);

	/**
	 * Returns <code>true</code> if the persisted room is associated with the persisted amenity.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPK the primary key of the persisted room
	 * @return <code>true</code> if the persisted room is associated with the persisted amenity; <code>false</code> otherwise
	 */
	public boolean containsPersistedRoom(long pk, long persistedRoomPK);

	/**
	 * Returns <code>true</code> if the persisted amenity has any persisted rooms associated with it.
	 *
	 * @param pk the primary key of the persisted amenity to check for associations with persisted rooms
	 * @return <code>true</code> if the persisted amenity has any persisted rooms associated with it; <code>false</code> otherwise
	 */
	public boolean containsPersistedRooms(long pk);

	/**
	 * Adds an association between the persisted amenity and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPK the primary key of the persisted room
	 */
	public void addPersistedRoom(long pk, long persistedRoomPK);

	/**
	 * Adds an association between the persisted amenity and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoom the persisted room
	 */
	public void addPersistedRoom(
		long pk, jp.co.liferay.reservation.model.PersistedRoom persistedRoom);

	/**
	 * Adds an association between the persisted amenity and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPKs the primary keys of the persisted rooms
	 */
	public void addPersistedRooms(long pk, long[] persistedRoomPKs);

	/**
	 * Adds an association between the persisted amenity and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRooms the persisted rooms
	 */
	public void addPersistedRooms(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
			persistedRooms);

	/**
	 * Clears all associations between the persisted amenity and its persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity to clear the associated persisted rooms from
	 */
	public void clearPersistedRooms(long pk);

	/**
	 * Removes the association between the persisted amenity and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPK the primary key of the persisted room
	 */
	public void removePersistedRoom(long pk, long persistedRoomPK);

	/**
	 * Removes the association between the persisted amenity and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoom the persisted room
	 */
	public void removePersistedRoom(
		long pk, jp.co.liferay.reservation.model.PersistedRoom persistedRoom);

	/**
	 * Removes the association between the persisted amenity and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPKs the primary keys of the persisted rooms
	 */
	public void removePersistedRooms(long pk, long[] persistedRoomPKs);

	/**
	 * Removes the association between the persisted amenity and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRooms the persisted rooms
	 */
	public void removePersistedRooms(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
			persistedRooms);

	/**
	 * Sets the persisted rooms associated with the persisted amenity, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPKs the primary keys of the persisted rooms to be associated with the persisted amenity
	 */
	public void setPersistedRooms(long pk, long[] persistedRoomPKs);

	/**
	 * Sets the persisted rooms associated with the persisted amenity, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRooms the persisted rooms to be associated with the persisted amenity
	 */
	public void setPersistedRooms(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
			persistedRooms);

}