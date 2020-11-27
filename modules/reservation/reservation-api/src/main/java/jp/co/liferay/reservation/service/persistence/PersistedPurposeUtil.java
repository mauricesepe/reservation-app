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

import jp.co.liferay.reservation.model.PersistedPurpose;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the persisted purpose service. This utility wraps <code>jp.co.liferay.reservation.service.persistence.impl.PersistedPurposePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedPurposePersistence
 * @generated
 */
public class PersistedPurposeUtil {

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
	public static void clearCache(PersistedPurpose persistedPurpose) {
		getPersistence().clearCache(persistedPurpose);
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
	public static Map<Serializable, PersistedPurpose> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PersistedPurpose> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PersistedPurpose> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PersistedPurpose> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PersistedPurpose update(PersistedPurpose persistedPurpose) {
		return getPersistence().update(persistedPurpose);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PersistedPurpose update(
		PersistedPurpose persistedPurpose, ServiceContext serviceContext) {

		return getPersistence().update(persistedPurpose, serviceContext);
	}

	/**
	 * Returns all the persisted purposes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted purposes
	 */
	public static List<PersistedPurpose> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<PersistedPurpose> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<PersistedPurpose> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<PersistedPurpose> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted purpose in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted purpose
	 * @throws NoSuchPersistedPurposeException if a matching persisted purpose could not be found
	 */
	public static PersistedPurpose findByUuid_First(
			String uuid, OrderByComparator<PersistedPurpose> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedPurposeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first persisted purpose in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	public static PersistedPurpose fetchByUuid_First(
		String uuid, OrderByComparator<PersistedPurpose> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted purpose in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted purpose
	 * @throws NoSuchPersistedPurposeException if a matching persisted purpose could not be found
	 */
	public static PersistedPurpose findByUuid_Last(
			String uuid, OrderByComparator<PersistedPurpose> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedPurposeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted purpose in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	public static PersistedPurpose fetchByUuid_Last(
		String uuid, OrderByComparator<PersistedPurpose> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the persisted purposes before and after the current persisted purpose in the ordered set where uuid = &#63;.
	 *
	 * @param purposeId the primary key of the current persisted purpose
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted purpose
	 * @throws NoSuchPersistedPurposeException if a persisted purpose with the primary key could not be found
	 */
	public static PersistedPurpose[] findByUuid_PrevAndNext(
			long purposeId, String uuid,
			OrderByComparator<PersistedPurpose> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedPurposeException {

		return getPersistence().findByUuid_PrevAndNext(
			purposeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the persisted purposes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of persisted purposes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted purposes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the persisted purposes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted purposes
	 */
	public static List<PersistedPurpose> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<PersistedPurpose> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<PersistedPurpose> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<PersistedPurpose> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted purpose in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted purpose
	 * @throws NoSuchPersistedPurposeException if a matching persisted purpose could not be found
	 */
	public static PersistedPurpose findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersistedPurpose> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedPurposeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first persisted purpose in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	public static PersistedPurpose fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersistedPurpose> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last persisted purpose in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted purpose
	 * @throws NoSuchPersistedPurposeException if a matching persisted purpose could not be found
	 */
	public static PersistedPurpose findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersistedPurpose> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedPurposeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last persisted purpose in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	public static PersistedPurpose fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersistedPurpose> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static PersistedPurpose[] findByUuid_C_PrevAndNext(
			long purposeId, String uuid, long companyId,
			OrderByComparator<PersistedPurpose> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedPurposeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			purposeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the persisted purposes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of persisted purposes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted purposes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the persisted purpose where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedPurposeException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted purpose
	 * @throws NoSuchPersistedPurposeException if a matching persisted purpose could not be found
	 */
	public static PersistedPurpose findByC_ERC(
			long companyId, String externalReferenceCode)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedPurposeException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted purpose where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	public static PersistedPurpose fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted purpose where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	public static PersistedPurpose fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the persisted purpose where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted purpose that was removed
	 */
	public static PersistedPurpose removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedPurposeException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of persisted purposes where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted purposes
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the persisted purpose in the entity cache if it is enabled.
	 *
	 * @param persistedPurpose the persisted purpose
	 */
	public static void cacheResult(PersistedPurpose persistedPurpose) {
		getPersistence().cacheResult(persistedPurpose);
	}

	/**
	 * Caches the persisted purposes in the entity cache if it is enabled.
	 *
	 * @param persistedPurposes the persisted purposes
	 */
	public static void cacheResult(List<PersistedPurpose> persistedPurposes) {
		getPersistence().cacheResult(persistedPurposes);
	}

	/**
	 * Creates a new persisted purpose with the primary key. Does not add the persisted purpose to the database.
	 *
	 * @param purposeId the primary key for the new persisted purpose
	 * @return the new persisted purpose
	 */
	public static PersistedPurpose create(long purposeId) {
		return getPersistence().create(purposeId);
	}

	/**
	 * Removes the persisted purpose with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param purposeId the primary key of the persisted purpose
	 * @return the persisted purpose that was removed
	 * @throws NoSuchPersistedPurposeException if a persisted purpose with the primary key could not be found
	 */
	public static PersistedPurpose remove(long purposeId)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedPurposeException {

		return getPersistence().remove(purposeId);
	}

	public static PersistedPurpose updateImpl(
		PersistedPurpose persistedPurpose) {

		return getPersistence().updateImpl(persistedPurpose);
	}

	/**
	 * Returns the persisted purpose with the primary key or throws a <code>NoSuchPersistedPurposeException</code> if it could not be found.
	 *
	 * @param purposeId the primary key of the persisted purpose
	 * @return the persisted purpose
	 * @throws NoSuchPersistedPurposeException if a persisted purpose with the primary key could not be found
	 */
	public static PersistedPurpose findByPrimaryKey(long purposeId)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedPurposeException {

		return getPersistence().findByPrimaryKey(purposeId);
	}

	/**
	 * Returns the persisted purpose with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param purposeId the primary key of the persisted purpose
	 * @return the persisted purpose, or <code>null</code> if a persisted purpose with the primary key could not be found
	 */
	public static PersistedPurpose fetchByPrimaryKey(long purposeId) {
		return getPersistence().fetchByPrimaryKey(purposeId);
	}

	/**
	 * Returns all the persisted purposes.
	 *
	 * @return the persisted purposes
	 */
	public static List<PersistedPurpose> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<PersistedPurpose> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<PersistedPurpose> findAll(
		int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<PersistedPurpose> findAll(
		int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the persisted purposes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of persisted purposes.
	 *
	 * @return the number of persisted purposes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of persisted rooms associated with the persisted purpose.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @return long[] of the primaryKeys of persisted rooms associated with the persisted purpose
	 */
	public static long[] getPersistedRoomPrimaryKeys(long pk) {
		return getPersistence().getPersistedRoomPrimaryKeys(pk);
	}

	/**
	 * Returns all the persisted purpose associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return the persisted purposes associated with the persisted room
	 */
	public static List<PersistedPurpose> getPersistedRoomPersistedPurposes(
		long pk) {

		return getPersistence().getPersistedRoomPersistedPurposes(pk);
	}

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
	public static List<PersistedPurpose> getPersistedRoomPersistedPurposes(
		long pk, int start, int end) {

		return getPersistence().getPersistedRoomPersistedPurposes(
			pk, start, end);
	}

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
	public static List<PersistedPurpose> getPersistedRoomPersistedPurposes(
		long pk, int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator) {

		return getPersistence().getPersistedRoomPersistedPurposes(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persisted rooms associated with the persisted purpose.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @return the number of persisted rooms associated with the persisted purpose
	 */
	public static int getPersistedRoomsSize(long pk) {
		return getPersistence().getPersistedRoomsSize(pk);
	}

	/**
	 * Returns <code>true</code> if the persisted room is associated with the persisted purpose.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPK the primary key of the persisted room
	 * @return <code>true</code> if the persisted room is associated with the persisted purpose; <code>false</code> otherwise
	 */
	public static boolean containsPersistedRoom(long pk, long persistedRoomPK) {
		return getPersistence().containsPersistedRoom(pk, persistedRoomPK);
	}

	/**
	 * Returns <code>true</code> if the persisted purpose has any persisted rooms associated with it.
	 *
	 * @param pk the primary key of the persisted purpose to check for associations with persisted rooms
	 * @return <code>true</code> if the persisted purpose has any persisted rooms associated with it; <code>false</code> otherwise
	 */
	public static boolean containsPersistedRooms(long pk) {
		return getPersistence().containsPersistedRooms(pk);
	}

	/**
	 * Adds an association between the persisted purpose and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPK the primary key of the persisted room
	 */
	public static void addPersistedRoom(long pk, long persistedRoomPK) {
		getPersistence().addPersistedRoom(pk, persistedRoomPK);
	}

	/**
	 * Adds an association between the persisted purpose and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoom the persisted room
	 */
	public static void addPersistedRoom(
		long pk, jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		getPersistence().addPersistedRoom(pk, persistedRoom);
	}

	/**
	 * Adds an association between the persisted purpose and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPKs the primary keys of the persisted rooms
	 */
	public static void addPersistedRooms(long pk, long[] persistedRoomPKs) {
		getPersistence().addPersistedRooms(pk, persistedRoomPKs);
	}

	/**
	 * Adds an association between the persisted purpose and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRooms the persisted rooms
	 */
	public static void addPersistedRooms(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedRoom> persistedRooms) {

		getPersistence().addPersistedRooms(pk, persistedRooms);
	}

	/**
	 * Clears all associations between the persisted purpose and its persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose to clear the associated persisted rooms from
	 */
	public static void clearPersistedRooms(long pk) {
		getPersistence().clearPersistedRooms(pk);
	}

	/**
	 * Removes the association between the persisted purpose and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPK the primary key of the persisted room
	 */
	public static void removePersistedRoom(long pk, long persistedRoomPK) {
		getPersistence().removePersistedRoom(pk, persistedRoomPK);
	}

	/**
	 * Removes the association between the persisted purpose and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoom the persisted room
	 */
	public static void removePersistedRoom(
		long pk, jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		getPersistence().removePersistedRoom(pk, persistedRoom);
	}

	/**
	 * Removes the association between the persisted purpose and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPKs the primary keys of the persisted rooms
	 */
	public static void removePersistedRooms(long pk, long[] persistedRoomPKs) {
		getPersistence().removePersistedRooms(pk, persistedRoomPKs);
	}

	/**
	 * Removes the association between the persisted purpose and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRooms the persisted rooms
	 */
	public static void removePersistedRooms(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedRoom> persistedRooms) {

		getPersistence().removePersistedRooms(pk, persistedRooms);
	}

	/**
	 * Sets the persisted rooms associated with the persisted purpose, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPKs the primary keys of the persisted rooms to be associated with the persisted purpose
	 */
	public static void setPersistedRooms(long pk, long[] persistedRoomPKs) {
		getPersistence().setPersistedRooms(pk, persistedRoomPKs);
	}

	/**
	 * Sets the persisted rooms associated with the persisted purpose, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRooms the persisted rooms to be associated with the persisted purpose
	 */
	public static void setPersistedRooms(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedRoom> persistedRooms) {

		getPersistence().setPersistedRooms(pk, persistedRooms);
	}

	public static PersistedPurposePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedPurposePersistence, PersistedPurposePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PersistedPurposePersistence.class);

		ServiceTracker<PersistedPurposePersistence, PersistedPurposePersistence>
			serviceTracker =
				new ServiceTracker
					<PersistedPurposePersistence, PersistedPurposePersistence>(
						bundle.getBundleContext(),
						PersistedPurposePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}