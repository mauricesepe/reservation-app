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

import jp.co.liferay.reservation.exception.NoSuchPersistedParticipantException;
import jp.co.liferay.reservation.model.PersistedParticipant;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the persisted participant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedParticipantUtil
 * @generated
 */
@ProviderType
public interface PersistedParticipantPersistence
	extends BasePersistence<PersistedParticipant> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersistedParticipantUtil} to access the persisted participant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the persisted participants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted participants
	 */
	public java.util.List<PersistedParticipant> findByUuid(String uuid);

	/**
	 * Returns a range of all the persisted participants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @return the range of matching persisted participants
	 */
	public java.util.List<PersistedParticipant> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the persisted participants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted participants
	 */
	public java.util.List<PersistedParticipant> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedParticipant>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted participants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted participants
	 */
	public java.util.List<PersistedParticipant> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedParticipant>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted participant
	 * @throws NoSuchPersistedParticipantException if a matching persisted participant could not be found
	 */
	public PersistedParticipant findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<PersistedParticipant> orderByComparator)
		throws NoSuchPersistedParticipantException;

	/**
	 * Returns the first persisted participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	public PersistedParticipant fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedParticipant>
			orderByComparator);

	/**
	 * Returns the last persisted participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted participant
	 * @throws NoSuchPersistedParticipantException if a matching persisted participant could not be found
	 */
	public PersistedParticipant findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<PersistedParticipant> orderByComparator)
		throws NoSuchPersistedParticipantException;

	/**
	 * Returns the last persisted participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	public PersistedParticipant fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedParticipant>
			orderByComparator);

	/**
	 * Returns the persisted participants before and after the current persisted participant in the ordered set where uuid = &#63;.
	 *
	 * @param participantId the primary key of the current persisted participant
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted participant
	 * @throws NoSuchPersistedParticipantException if a persisted participant with the primary key could not be found
	 */
	public PersistedParticipant[] findByUuid_PrevAndNext(
			long participantId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator
				<PersistedParticipant> orderByComparator)
		throws NoSuchPersistedParticipantException;

	/**
	 * Removes all the persisted participants where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of persisted participants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted participants
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the persisted participants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted participants
	 */
	public java.util.List<PersistedParticipant> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the persisted participants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @return the range of matching persisted participants
	 */
	public java.util.List<PersistedParticipant> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the persisted participants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted participants
	 */
	public java.util.List<PersistedParticipant> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedParticipant>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted participants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted participants
	 */
	public java.util.List<PersistedParticipant> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedParticipant>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted participant
	 * @throws NoSuchPersistedParticipantException if a matching persisted participant could not be found
	 */
	public PersistedParticipant findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PersistedParticipant> orderByComparator)
		throws NoSuchPersistedParticipantException;

	/**
	 * Returns the first persisted participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	public PersistedParticipant fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedParticipant>
			orderByComparator);

	/**
	 * Returns the last persisted participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted participant
	 * @throws NoSuchPersistedParticipantException if a matching persisted participant could not be found
	 */
	public PersistedParticipant findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PersistedParticipant> orderByComparator)
		throws NoSuchPersistedParticipantException;

	/**
	 * Returns the last persisted participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	public PersistedParticipant fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedParticipant>
			orderByComparator);

	/**
	 * Returns the persisted participants before and after the current persisted participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param participantId the primary key of the current persisted participant
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted participant
	 * @throws NoSuchPersistedParticipantException if a persisted participant with the primary key could not be found
	 */
	public PersistedParticipant[] findByUuid_C_PrevAndNext(
			long participantId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator
				<PersistedParticipant> orderByComparator)
		throws NoSuchPersistedParticipantException;

	/**
	 * Removes all the persisted participants where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of persisted participants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted participants
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the persisted participant where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedParticipantException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted participant
	 * @throws NoSuchPersistedParticipantException if a matching persisted participant could not be found
	 */
	public PersistedParticipant findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedParticipantException;

	/**
	 * Returns the persisted participant where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	public PersistedParticipant fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the persisted participant where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	public PersistedParticipant fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the persisted participant where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted participant that was removed
	 */
	public PersistedParticipant removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedParticipantException;

	/**
	 * Returns the number of persisted participants where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted participants
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the persisted participant in the entity cache if it is enabled.
	 *
	 * @param persistedParticipant the persisted participant
	 */
	public void cacheResult(PersistedParticipant persistedParticipant);

	/**
	 * Caches the persisted participants in the entity cache if it is enabled.
	 *
	 * @param persistedParticipants the persisted participants
	 */
	public void cacheResult(
		java.util.List<PersistedParticipant> persistedParticipants);

	/**
	 * Creates a new persisted participant with the primary key. Does not add the persisted participant to the database.
	 *
	 * @param participantId the primary key for the new persisted participant
	 * @return the new persisted participant
	 */
	public PersistedParticipant create(long participantId);

	/**
	 * Removes the persisted participant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param participantId the primary key of the persisted participant
	 * @return the persisted participant that was removed
	 * @throws NoSuchPersistedParticipantException if a persisted participant with the primary key could not be found
	 */
	public PersistedParticipant remove(long participantId)
		throws NoSuchPersistedParticipantException;

	public PersistedParticipant updateImpl(
		PersistedParticipant persistedParticipant);

	/**
	 * Returns the persisted participant with the primary key or throws a <code>NoSuchPersistedParticipantException</code> if it could not be found.
	 *
	 * @param participantId the primary key of the persisted participant
	 * @return the persisted participant
	 * @throws NoSuchPersistedParticipantException if a persisted participant with the primary key could not be found
	 */
	public PersistedParticipant findByPrimaryKey(long participantId)
		throws NoSuchPersistedParticipantException;

	/**
	 * Returns the persisted participant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param participantId the primary key of the persisted participant
	 * @return the persisted participant, or <code>null</code> if a persisted participant with the primary key could not be found
	 */
	public PersistedParticipant fetchByPrimaryKey(long participantId);

	/**
	 * Returns all the persisted participants.
	 *
	 * @return the persisted participants
	 */
	public java.util.List<PersistedParticipant> findAll();

	/**
	 * Returns a range of all the persisted participants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @return the range of persisted participants
	 */
	public java.util.List<PersistedParticipant> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the persisted participants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted participants
	 */
	public java.util.List<PersistedParticipant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedParticipant>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted participants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted participants
	 */
	public java.util.List<PersistedParticipant> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedParticipant>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the persisted participants from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of persisted participants.
	 *
	 * @return the number of persisted participants
	 */
	public int countAll();

	/**
	 * Returns the primaryKeys of persisted bookings associated with the persisted participant.
	 *
	 * @param pk the primary key of the persisted participant
	 * @return long[] of the primaryKeys of persisted bookings associated with the persisted participant
	 */
	public long[] getPersistedBookingPrimaryKeys(long pk);

	/**
	 * Returns all the persisted participant associated with the persisted booking.
	 *
	 * @param pk the primary key of the persisted booking
	 * @return the persisted participants associated with the persisted booking
	 */
	public java.util.List<PersistedParticipant>
		getPersistedBookingPersistedParticipants(long pk);

	/**
	 * Returns all the persisted participant associated with the persisted booking.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the persisted booking
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @return the range of persisted participants associated with the persisted booking
	 */
	public java.util.List<PersistedParticipant>
		getPersistedBookingPersistedParticipants(long pk, int start, int end);

	/**
	 * Returns all the persisted participant associated with the persisted booking.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the persisted booking
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted participants associated with the persisted booking
	 */
	public java.util.List<PersistedParticipant>
		getPersistedBookingPersistedParticipants(
			long pk, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<PersistedParticipant> orderByComparator);

	/**
	 * Returns the number of persisted bookings associated with the persisted participant.
	 *
	 * @param pk the primary key of the persisted participant
	 * @return the number of persisted bookings associated with the persisted participant
	 */
	public int getPersistedBookingsSize(long pk);

	/**
	 * Returns <code>true</code> if the persisted booking is associated with the persisted participant.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPK the primary key of the persisted booking
	 * @return <code>true</code> if the persisted booking is associated with the persisted participant; <code>false</code> otherwise
	 */
	public boolean containsPersistedBooking(long pk, long persistedBookingPK);

	/**
	 * Returns <code>true</code> if the persisted participant has any persisted bookings associated with it.
	 *
	 * @param pk the primary key of the persisted participant to check for associations with persisted bookings
	 * @return <code>true</code> if the persisted participant has any persisted bookings associated with it; <code>false</code> otherwise
	 */
	public boolean containsPersistedBookings(long pk);

	/**
	 * Adds an association between the persisted participant and the persisted booking. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPK the primary key of the persisted booking
	 */
	public void addPersistedBooking(long pk, long persistedBookingPK);

	/**
	 * Adds an association between the persisted participant and the persisted booking. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBooking the persisted booking
	 */
	public void addPersistedBooking(
		long pk,
		jp.co.liferay.reservation.model.PersistedBooking persistedBooking);

	/**
	 * Adds an association between the persisted participant and the persisted bookings. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPKs the primary keys of the persisted bookings
	 */
	public void addPersistedBookings(long pk, long[] persistedBookingPKs);

	/**
	 * Adds an association between the persisted participant and the persisted bookings. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookings the persisted bookings
	 */
	public void addPersistedBookings(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
			persistedBookings);

	/**
	 * Clears all associations between the persisted participant and its persisted bookings. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant to clear the associated persisted bookings from
	 */
	public void clearPersistedBookings(long pk);

	/**
	 * Removes the association between the persisted participant and the persisted booking. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPK the primary key of the persisted booking
	 */
	public void removePersistedBooking(long pk, long persistedBookingPK);

	/**
	 * Removes the association between the persisted participant and the persisted booking. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBooking the persisted booking
	 */
	public void removePersistedBooking(
		long pk,
		jp.co.liferay.reservation.model.PersistedBooking persistedBooking);

	/**
	 * Removes the association between the persisted participant and the persisted bookings. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPKs the primary keys of the persisted bookings
	 */
	public void removePersistedBookings(long pk, long[] persistedBookingPKs);

	/**
	 * Removes the association between the persisted participant and the persisted bookings. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookings the persisted bookings
	 */
	public void removePersistedBookings(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
			persistedBookings);

	/**
	 * Sets the persisted bookings associated with the persisted participant, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPKs the primary keys of the persisted bookings to be associated with the persisted participant
	 */
	public void setPersistedBookings(long pk, long[] persistedBookingPKs);

	/**
	 * Sets the persisted bookings associated with the persisted participant, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookings the persisted bookings to be associated with the persisted participant
	 */
	public void setPersistedBookings(
		long pk,
		java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
			persistedBookings);

}