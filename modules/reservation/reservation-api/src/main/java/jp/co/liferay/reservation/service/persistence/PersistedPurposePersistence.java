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

import jp.co.liferay.reservation.exception.NoSuchPersistedPurposeException;
import jp.co.liferay.reservation.model.PersistedPurpose;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the persisted purpose service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedPurposeUtil
 * @generated
 */
@ProviderType
public interface PersistedPurposePersistence
	extends BasePersistence<PersistedPurpose> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersistedPurposeUtil} to access the persisted purpose persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the persisted purposes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted purposes
	 */
	public java.util.List<PersistedPurpose> findByUuid(String uuid);

	/**
	 * Returns a range of all the persisted purposes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedPurposeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @return the range of matching persisted purposes
	 */
	public java.util.List<PersistedPurpose> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the persisted purposes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedPurposeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted purposes
	 */
	public java.util.List<PersistedPurpose> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted purposes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedPurposeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted purposes
	 */
	public java.util.List<PersistedPurpose> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted purpose in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted purpose
	 * @throws NoSuchPersistedPurposeException if a matching persisted purpose could not be found
	 */
	public PersistedPurpose findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
				orderByComparator)
		throws NoSuchPersistedPurposeException;

	/**
	 * Returns the first persisted purpose in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	public PersistedPurpose fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
			orderByComparator);

	/**
	 * Returns the last persisted purpose in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted purpose
	 * @throws NoSuchPersistedPurposeException if a matching persisted purpose could not be found
	 */
	public PersistedPurpose findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
				orderByComparator)
		throws NoSuchPersistedPurposeException;

	/**
	 * Returns the last persisted purpose in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	public PersistedPurpose fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
			orderByComparator);

	/**
	 * Returns the persisted purposes before and after the current persisted purpose in the ordered set where uuid = &#63;.
	 *
	 * @param purposeId the primary key of the current persisted purpose
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted purpose
	 * @throws NoSuchPersistedPurposeException if a persisted purpose with the primary key could not be found
	 */
	public PersistedPurpose[] findByUuid_PrevAndNext(
			long purposeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
				orderByComparator)
		throws NoSuchPersistedPurposeException;

	/**
	 * Removes all the persisted purposes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of persisted purposes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted purposes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the persisted purposes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted purposes
	 */
	public java.util.List<PersistedPurpose> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the persisted purposes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedPurposeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @return the range of matching persisted purposes
	 */
	public java.util.List<PersistedPurpose> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the persisted purposes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedPurposeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted purposes
	 */
	public java.util.List<PersistedPurpose> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted purposes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedPurposeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted purposes
	 */
	public java.util.List<PersistedPurpose> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted purpose in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted purpose
	 * @throws NoSuchPersistedPurposeException if a matching persisted purpose could not be found
	 */
	public PersistedPurpose findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
				orderByComparator)
		throws NoSuchPersistedPurposeException;

	/**
	 * Returns the first persisted purpose in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	public PersistedPurpose fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
			orderByComparator);

	/**
	 * Returns the last persisted purpose in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted purpose
	 * @throws NoSuchPersistedPurposeException if a matching persisted purpose could not be found
	 */
	public PersistedPurpose findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
				orderByComparator)
		throws NoSuchPersistedPurposeException;

	/**
	 * Returns the last persisted purpose in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	public PersistedPurpose fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
			orderByComparator);

	/**
	 * Returns the persisted purposes before and after the current persisted purpose in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param purposeId the primary key of the current persisted purpose
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted purpose
	 * @throws NoSuchPersistedPurposeException if a persisted purpose with the primary key could not be found
	 */
	public PersistedPurpose[] findByUuid_C_PrevAndNext(
			long purposeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
				orderByComparator)
		throws NoSuchPersistedPurposeException;

	/**
	 * Removes all the persisted purposes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of persisted purposes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted purposes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the persisted purpose where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedPurposeException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted purpose
	 * @throws NoSuchPersistedPurposeException if a matching persisted purpose could not be found
	 */
	public PersistedPurpose findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedPurposeException;

	/**
	 * Returns the persisted purpose where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	public PersistedPurpose fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the persisted purpose where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	public PersistedPurpose fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the persisted purpose where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted purpose that was removed
	 */
	public PersistedPurpose removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedPurposeException;

	/**
	 * Returns the number of persisted purposes where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted purposes
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the persisted purpose in the entity cache if it is enabled.
	 *
	 * @param persistedPurpose the persisted purpose
	 */
	public void cacheResult(PersistedPurpose persistedPurpose);

	/**
	 * Caches the persisted purposes in the entity cache if it is enabled.
	 *
	 * @param persistedPurposes the persisted purposes
	 */
	public void cacheResult(java.util.List<PersistedPurpose> persistedPurposes);

	/**
	 * Creates a new persisted purpose with the primary key. Does not add the persisted purpose to the database.
	 *
	 * @param purposeId the primary key for the new persisted purpose
	 * @return the new persisted purpose
	 */
	public PersistedPurpose create(long purposeId);

	/**
	 * Removes the persisted purpose with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param purposeId the primary key of the persisted purpose
	 * @return the persisted purpose that was removed
	 * @throws NoSuchPersistedPurposeException if a persisted purpose with the primary key could not be found
	 */
	public PersistedPurpose remove(long purposeId)
		throws NoSuchPersistedPurposeException;

	public PersistedPurpose updateImpl(PersistedPurpose persistedPurpose);

	/**
	 * Returns the persisted purpose with the primary key or throws a <code>NoSuchPersistedPurposeException</code> if it could not be found.
	 *
	 * @param purposeId the primary key of the persisted purpose
	 * @return the persisted purpose
	 * @throws NoSuchPersistedPurposeException if a persisted purpose with the primary key could not be found
	 */
	public PersistedPurpose findByPrimaryKey(long purposeId)
		throws NoSuchPersistedPurposeException;

	/**
	 * Returns the persisted purpose with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param purposeId the primary key of the persisted purpose
	 * @return the persisted purpose, or <code>null</code> if a persisted purpose with the primary key could not be found
	 */
	public PersistedPurpose fetchByPrimaryKey(long purposeId);

	/**
	 * Returns all the persisted purposes.
	 *
	 * @return the persisted purposes
	 */
	public java.util.List<PersistedPurpose> findAll();

	/**
	 * Returns a range of all the persisted purposes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedPurposeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @return the range of persisted purposes
	 */
	public java.util.List<PersistedPurpose> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the persisted purposes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedPurposeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted purposes
	 */
	public java.util.List<PersistedPurpose> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted purposes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedPurposeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted purposes
	 */
	public java.util.List<PersistedPurpose> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the persisted purposes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of persisted purposes.
	 *
	 * @return the number of persisted purposes
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of persisted rooms associated with the persisted purpose.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @return long[] of the primaryKeys of persisted rooms associated with the persisted purpose
	 */
	public long[] getPersistedRoomPrimaryKeys(long pk);

	/**
	 * Returns all the persisted purpose associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return the persisted purposes associated with the persisted room
	 */
	public java.util.List<PersistedPurpose> getPersistedRoomPersistedPurposes(
		long pk);

	/**
	 * Returns all the persisted purpose associated with the persisted room.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedPurposeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted room
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of persisted purposes associated with the persisted room
	 */
	public java.util.List<PersistedPurpose> getPersistedRoomPersistedPurposes(
		long pk, int start, int end);

	/**
	 * Returns all the persisted purpose associated with the persisted room.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedPurposeModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted room
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted purposes associated with the persisted room
	 */
	public java.util.List<PersistedPurpose> getPersistedRoomPersistedPurposes(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedPurpose>
			orderByComparator);

	/**
	 * Returns the number of persisted rooms associated with the persisted purpose.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @return the number of persisted rooms associated with the persisted purpose
	 */
	public int getPersistedRoomsSize(long pk);

	/**
	 * Returns <code>true</code> if the persisted room is associated with the persisted purpose.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPK the primary key of the persisted room
	 * @return <code>true</code> if the persisted room is associated with the persisted purpose; <code>false</code> otherwise
	 */
	public boolean containsPersistedRoom(long pk, long persistedRoomPK);

	/**
	 * Returns <code>true</code> if the persisted purpose has any persisted rooms associated with it.
	 *
	 * @param pk the primary key of the persisted purpose to check for associations with persisted rooms
	 * @return <code>true</code> if the persisted purpose has any persisted rooms associated with it; <code>false</code> otherwise
	 */
	public boolean containsPersistedRooms(long pk);

	/**
	 * Adds an association between the persisted purpose and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPK the primary key of the persisted room
	 */
	public void addPersistedRoom(long pk, long persistedRoomPK);

	/**
	 * Adds an association between the persisted purpose and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoom the persisted room
	 */
	public void addPersistedRoom(
		long pk, jp.co.liferay.reservation.model.PersistedRoom persistedRoom);

	/**
	 * Adds an association between the persisted purpose and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPKs the primary keys of the persisted rooms
	 */
	public void addPersistedRooms(long pk, long[] persistedRoomPKs);

	/**
	 * Adds an association between the persisted purpose and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRooms the persisted rooms
	 */
	public void addPersistedRooms(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
			persistedRooms);

	/**
	 * Clears all associations between the persisted purpose and its persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose to clear the associated persisted rooms from
	 */
	public void clearPersistedRooms(long pk);

	/**
	 * Removes the association between the persisted purpose and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPK the primary key of the persisted room
	 */
	public void removePersistedRoom(long pk, long persistedRoomPK);

	/**
	 * Removes the association between the persisted purpose and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoom the persisted room
	 */
	public void removePersistedRoom(
		long pk, jp.co.liferay.reservation.model.PersistedRoom persistedRoom);

	/**
	 * Removes the association between the persisted purpose and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPKs the primary keys of the persisted rooms
	 */
	public void removePersistedRooms(long pk, long[] persistedRoomPKs);

	/**
	 * Removes the association between the persisted purpose and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRooms the persisted rooms
	 */
	public void removePersistedRooms(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
			persistedRooms);

	/**
	 * Sets the persisted rooms associated with the persisted purpose, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPKs the primary keys of the persisted rooms to be associated with the persisted purpose
	 */
	public void setPersistedRooms(long pk, long[] persistedRoomPKs);

	/**
	 * Sets the persisted rooms associated with the persisted purpose, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRooms the persisted rooms to be associated with the persisted purpose
	 */
	public void setPersistedRooms(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
			persistedRooms);

}