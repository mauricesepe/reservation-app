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

import jp.co.liferay.reservation.model.PersistedParticipant;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the persisted participant service. This utility wraps <code>jp.co.liferay.reservation.service.persistence.impl.PersistedParticipantPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedParticipantPersistence
 * @generated
 */
@ProviderType
public class PersistedParticipantUtil {

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
	public static void clearCache(PersistedParticipant persistedParticipant) {
		getPersistence().clearCache(persistedParticipant);
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
	public static Map<Serializable, PersistedParticipant> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PersistedParticipant> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PersistedParticipant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PersistedParticipant> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PersistedParticipant update(
		PersistedParticipant persistedParticipant) {

		return getPersistence().update(persistedParticipant);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PersistedParticipant update(
		PersistedParticipant persistedParticipant,
		ServiceContext serviceContext) {

		return getPersistence().update(persistedParticipant, serviceContext);
	}

	/**
	 * Returns all the persisted participants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted participants
	 */
	public static List<PersistedParticipant> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<PersistedParticipant> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<PersistedParticipant> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<PersistedParticipant> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedParticipant> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted participant
	 * @throws NoSuchPersistedParticipantException if a matching persisted participant could not be found
	 */
	public static PersistedParticipant findByUuid_First(
			String uuid,
			OrderByComparator<PersistedParticipant> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedParticipantException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first persisted participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	public static PersistedParticipant fetchByUuid_First(
		String uuid,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted participant
	 * @throws NoSuchPersistedParticipantException if a matching persisted participant could not be found
	 */
	public static PersistedParticipant findByUuid_Last(
			String uuid,
			OrderByComparator<PersistedParticipant> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedParticipantException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	public static PersistedParticipant fetchByUuid_Last(
		String uuid,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the persisted participants before and after the current persisted participant in the ordered set where uuid = &#63;.
	 *
	 * @param participantId the primary key of the current persisted participant
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted participant
	 * @throws NoSuchPersistedParticipantException if a persisted participant with the primary key could not be found
	 */
	public static PersistedParticipant[] findByUuid_PrevAndNext(
			long participantId, String uuid,
			OrderByComparator<PersistedParticipant> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedParticipantException {

		return getPersistence().findByUuid_PrevAndNext(
			participantId, uuid, orderByComparator);
	}

	/**
	 * Removes all the persisted participants where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of persisted participants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted participants
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the persisted participants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted participants
	 */
	public static List<PersistedParticipant> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<PersistedParticipant> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<PersistedParticipant> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<PersistedParticipant> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedParticipant> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted participant
	 * @throws NoSuchPersistedParticipantException if a matching persisted participant could not be found
	 */
	public static PersistedParticipant findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersistedParticipant> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedParticipantException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first persisted participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	public static PersistedParticipant fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last persisted participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted participant
	 * @throws NoSuchPersistedParticipantException if a matching persisted participant could not be found
	 */
	public static PersistedParticipant findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersistedParticipant> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedParticipantException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last persisted participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	public static PersistedParticipant fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static PersistedParticipant[] findByUuid_C_PrevAndNext(
			long participantId, String uuid, long companyId,
			OrderByComparator<PersistedParticipant> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedParticipantException {

		return getPersistence().findByUuid_C_PrevAndNext(
			participantId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the persisted participants where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of persisted participants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted participants
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the persisted participant where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedParticipantException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted participant
	 * @throws NoSuchPersistedParticipantException if a matching persisted participant could not be found
	 */
	public static PersistedParticipant findByC_ERC(
			long companyId, String externalReferenceCode)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedParticipantException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted participant where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	public static PersistedParticipant fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted participant where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	public static PersistedParticipant fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the persisted participant where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted participant that was removed
	 */
	public static PersistedParticipant removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedParticipantException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of persisted participants where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted participants
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the persisted participant in the entity cache if it is enabled.
	 *
	 * @param persistedParticipant the persisted participant
	 */
	public static void cacheResult(PersistedParticipant persistedParticipant) {
		getPersistence().cacheResult(persistedParticipant);
	}

	/**
	 * Caches the persisted participants in the entity cache if it is enabled.
	 *
	 * @param persistedParticipants the persisted participants
	 */
	public static void cacheResult(
		List<PersistedParticipant> persistedParticipants) {

		getPersistence().cacheResult(persistedParticipants);
	}

	/**
	 * Creates a new persisted participant with the primary key. Does not add the persisted participant to the database.
	 *
	 * @param participantId the primary key for the new persisted participant
	 * @return the new persisted participant
	 */
	public static PersistedParticipant create(long participantId) {
		return getPersistence().create(participantId);
	}

	/**
	 * Removes the persisted participant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param participantId the primary key of the persisted participant
	 * @return the persisted participant that was removed
	 * @throws NoSuchPersistedParticipantException if a persisted participant with the primary key could not be found
	 */
	public static PersistedParticipant remove(long participantId)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedParticipantException {

		return getPersistence().remove(participantId);
	}

	public static PersistedParticipant updateImpl(
		PersistedParticipant persistedParticipant) {

		return getPersistence().updateImpl(persistedParticipant);
	}

	/**
	 * Returns the persisted participant with the primary key or throws a <code>NoSuchPersistedParticipantException</code> if it could not be found.
	 *
	 * @param participantId the primary key of the persisted participant
	 * @return the persisted participant
	 * @throws NoSuchPersistedParticipantException if a persisted participant with the primary key could not be found
	 */
	public static PersistedParticipant findByPrimaryKey(long participantId)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedParticipantException {

		return getPersistence().findByPrimaryKey(participantId);
	}

	/**
	 * Returns the persisted participant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param participantId the primary key of the persisted participant
	 * @return the persisted participant, or <code>null</code> if a persisted participant with the primary key could not be found
	 */
	public static PersistedParticipant fetchByPrimaryKey(long participantId) {
		return getPersistence().fetchByPrimaryKey(participantId);
	}

	/**
	 * Returns all the persisted participants.
	 *
	 * @return the persisted participants
	 */
	public static List<PersistedParticipant> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<PersistedParticipant> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<PersistedParticipant> findAll(
		int start, int end,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<PersistedParticipant> findAll(
		int start, int end,
		OrderByComparator<PersistedParticipant> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the persisted participants from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of persisted participants.
	 *
	 * @return the number of persisted participants
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of persisted bookings associated with the persisted participant.
	 *
	 * @param pk the primary key of the persisted participant
	 * @return long[] of the primaryKeys of persisted bookings associated with the persisted participant
	 */
	public static long[] getPersistedBookingPrimaryKeys(long pk) {
		return getPersistence().getPersistedBookingPrimaryKeys(pk);
	}

	/**
	 * Returns all the persisted participant associated with the persisted booking.
	 *
	 * @param pk the primary key of the persisted booking
	 * @return the persisted participants associated with the persisted booking
	 */
	public static List<PersistedParticipant>
		getPersistedBookingPersistedParticipants(long pk) {

		return getPersistence().getPersistedBookingPersistedParticipants(pk);
	}

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
	public static List<PersistedParticipant>
		getPersistedBookingPersistedParticipants(long pk, int start, int end) {

		return getPersistence().getPersistedBookingPersistedParticipants(
			pk, start, end);
	}

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
	public static List<PersistedParticipant>
		getPersistedBookingPersistedParticipants(
			long pk, int start, int end,
			OrderByComparator<PersistedParticipant> orderByComparator) {

		return getPersistence().getPersistedBookingPersistedParticipants(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persisted bookings associated with the persisted participant.
	 *
	 * @param pk the primary key of the persisted participant
	 * @return the number of persisted bookings associated with the persisted participant
	 */
	public static int getPersistedBookingsSize(long pk) {
		return getPersistence().getPersistedBookingsSize(pk);
	}

	/**
	 * Returns <code>true</code> if the persisted booking is associated with the persisted participant.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPK the primary key of the persisted booking
	 * @return <code>true</code> if the persisted booking is associated with the persisted participant; <code>false</code> otherwise
	 */
	public static boolean containsPersistedBooking(
		long pk, long persistedBookingPK) {

		return getPersistence().containsPersistedBooking(
			pk, persistedBookingPK);
	}

	/**
	 * Returns <code>true</code> if the persisted participant has any persisted bookings associated with it.
	 *
	 * @param pk the primary key of the persisted participant to check for associations with persisted bookings
	 * @return <code>true</code> if the persisted participant has any persisted bookings associated with it; <code>false</code> otherwise
	 */
	public static boolean containsPersistedBookings(long pk) {
		return getPersistence().containsPersistedBookings(pk);
	}

	/**
	 * Adds an association between the persisted participant and the persisted booking. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPK the primary key of the persisted booking
	 */
	public static void addPersistedBooking(long pk, long persistedBookingPK) {
		getPersistence().addPersistedBooking(pk, persistedBookingPK);
	}

	/**
	 * Adds an association between the persisted participant and the persisted booking. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBooking the persisted booking
	 */
	public static void addPersistedBooking(
		long pk,
		jp.co.liferay.reservation.model.PersistedBooking persistedBooking) {

		getPersistence().addPersistedBooking(pk, persistedBooking);
	}

	/**
	 * Adds an association between the persisted participant and the persisted bookings. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPKs the primary keys of the persisted bookings
	 */
	public static void addPersistedBookings(
		long pk, long[] persistedBookingPKs) {

		getPersistence().addPersistedBookings(pk, persistedBookingPKs);
	}

	/**
	 * Adds an association between the persisted participant and the persisted bookings. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookings the persisted bookings
	 */
	public static void addPersistedBookings(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedBooking>
			persistedBookings) {

		getPersistence().addPersistedBookings(pk, persistedBookings);
	}

	/**
	 * Clears all associations between the persisted participant and its persisted bookings. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant to clear the associated persisted bookings from
	 */
	public static void clearPersistedBookings(long pk) {
		getPersistence().clearPersistedBookings(pk);
	}

	/**
	 * Removes the association between the persisted participant and the persisted booking. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPK the primary key of the persisted booking
	 */
	public static void removePersistedBooking(
		long pk, long persistedBookingPK) {

		getPersistence().removePersistedBooking(pk, persistedBookingPK);
	}

	/**
	 * Removes the association between the persisted participant and the persisted booking. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBooking the persisted booking
	 */
	public static void removePersistedBooking(
		long pk,
		jp.co.liferay.reservation.model.PersistedBooking persistedBooking) {

		getPersistence().removePersistedBooking(pk, persistedBooking);
	}

	/**
	 * Removes the association between the persisted participant and the persisted bookings. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPKs the primary keys of the persisted bookings
	 */
	public static void removePersistedBookings(
		long pk, long[] persistedBookingPKs) {

		getPersistence().removePersistedBookings(pk, persistedBookingPKs);
	}

	/**
	 * Removes the association between the persisted participant and the persisted bookings. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookings the persisted bookings
	 */
	public static void removePersistedBookings(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedBooking>
			persistedBookings) {

		getPersistence().removePersistedBookings(pk, persistedBookings);
	}

	/**
	 * Sets the persisted bookings associated with the persisted participant, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPKs the primary keys of the persisted bookings to be associated with the persisted participant
	 */
	public static void setPersistedBookings(
		long pk, long[] persistedBookingPKs) {

		getPersistence().setPersistedBookings(pk, persistedBookingPKs);
	}

	/**
	 * Sets the persisted bookings associated with the persisted participant, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookings the persisted bookings to be associated with the persisted participant
	 */
	public static void setPersistedBookings(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedBooking>
			persistedBookings) {

		getPersistence().setPersistedBookings(pk, persistedBookings);
	}

	public static PersistedParticipantPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedParticipantPersistence, PersistedParticipantPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PersistedParticipantPersistence.class);

		ServiceTracker
			<PersistedParticipantPersistence, PersistedParticipantPersistence>
				serviceTracker =
					new ServiceTracker
						<PersistedParticipantPersistence,
						 PersistedParticipantPersistence>(
							 bundle.getBundleContext(),
							 PersistedParticipantPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}