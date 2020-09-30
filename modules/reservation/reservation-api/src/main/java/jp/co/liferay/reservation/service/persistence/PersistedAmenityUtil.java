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

import jp.co.liferay.reservation.model.PersistedAmenity;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the persisted amenity service. This utility wraps <code>jp.co.liferay.reservation.service.persistence.impl.PersistedAmenityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedAmenityPersistence
 * @generated
 */
@ProviderType
public class PersistedAmenityUtil {

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
	public static void clearCache(PersistedAmenity persistedAmenity) {
		getPersistence().clearCache(persistedAmenity);
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
	public static Map<Serializable, PersistedAmenity> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PersistedAmenity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PersistedAmenity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PersistedAmenity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PersistedAmenity update(PersistedAmenity persistedAmenity) {
		return getPersistence().update(persistedAmenity);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PersistedAmenity update(
		PersistedAmenity persistedAmenity, ServiceContext serviceContext) {

		return getPersistence().update(persistedAmenity, serviceContext);
	}

	/**
	 * Returns all the persisted amenities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted amenities
	 */
	public static List<PersistedAmenity> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the persisted amenities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @return the range of matching persisted amenities
	 */
	public static List<PersistedAmenity> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted amenities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted amenities
	 */
	public static List<PersistedAmenity> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted amenities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted amenities
	 */
	public static List<PersistedAmenity> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted amenity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted amenity
	 * @throws NoSuchPersistedAmenityException if a matching persisted amenity could not be found
	 */
	public static PersistedAmenity findByUuid_First(
			String uuid, OrderByComparator<PersistedAmenity> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedAmenityException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first persisted amenity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	public static PersistedAmenity fetchByUuid_First(
		String uuid, OrderByComparator<PersistedAmenity> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted amenity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted amenity
	 * @throws NoSuchPersistedAmenityException if a matching persisted amenity could not be found
	 */
	public static PersistedAmenity findByUuid_Last(
			String uuid, OrderByComparator<PersistedAmenity> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedAmenityException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted amenity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	public static PersistedAmenity fetchByUuid_Last(
		String uuid, OrderByComparator<PersistedAmenity> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the persisted amenities before and after the current persisted amenity in the ordered set where uuid = &#63;.
	 *
	 * @param amenityId the primary key of the current persisted amenity
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted amenity
	 * @throws NoSuchPersistedAmenityException if a persisted amenity with the primary key could not be found
	 */
	public static PersistedAmenity[] findByUuid_PrevAndNext(
			long amenityId, String uuid,
			OrderByComparator<PersistedAmenity> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedAmenityException {

		return getPersistence().findByUuid_PrevAndNext(
			amenityId, uuid, orderByComparator);
	}

	/**
	 * Removes all the persisted amenities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of persisted amenities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted amenities
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the persisted amenities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted amenities
	 */
	public static List<PersistedAmenity> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the persisted amenities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @return the range of matching persisted amenities
	 */
	public static List<PersistedAmenity> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted amenities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted amenities
	 */
	public static List<PersistedAmenity> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted amenities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public static List<PersistedAmenity> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted amenity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted amenity
	 * @throws NoSuchPersistedAmenityException if a matching persisted amenity could not be found
	 */
	public static PersistedAmenity findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersistedAmenity> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedAmenityException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first persisted amenity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	public static PersistedAmenity fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersistedAmenity> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last persisted amenity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted amenity
	 * @throws NoSuchPersistedAmenityException if a matching persisted amenity could not be found
	 */
	public static PersistedAmenity findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersistedAmenity> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedAmenityException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last persisted amenity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	public static PersistedAmenity fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersistedAmenity> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static PersistedAmenity[] findByUuid_C_PrevAndNext(
			long amenityId, String uuid, long companyId,
			OrderByComparator<PersistedAmenity> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedAmenityException {

		return getPersistence().findByUuid_C_PrevAndNext(
			amenityId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the persisted amenities where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of persisted amenities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted amenities
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the persisted amenity where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedAmenityException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted amenity
	 * @throws NoSuchPersistedAmenityException if a matching persisted amenity could not be found
	 */
	public static PersistedAmenity findByC_ERC(
			long companyId, String externalReferenceCode)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedAmenityException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted amenity where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	public static PersistedAmenity fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted amenity where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	public static PersistedAmenity fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the persisted amenity where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted amenity that was removed
	 */
	public static PersistedAmenity removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedAmenityException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of persisted amenities where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted amenities
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the persisted amenity in the entity cache if it is enabled.
	 *
	 * @param persistedAmenity the persisted amenity
	 */
	public static void cacheResult(PersistedAmenity persistedAmenity) {
		getPersistence().cacheResult(persistedAmenity);
	}

	/**
	 * Caches the persisted amenities in the entity cache if it is enabled.
	 *
	 * @param persistedAmenities the persisted amenities
	 */
	public static void cacheResult(List<PersistedAmenity> persistedAmenities) {
		getPersistence().cacheResult(persistedAmenities);
	}

	/**
	 * Creates a new persisted amenity with the primary key. Does not add the persisted amenity to the database.
	 *
	 * @param amenityId the primary key for the new persisted amenity
	 * @return the new persisted amenity
	 */
	public static PersistedAmenity create(long amenityId) {
		return getPersistence().create(amenityId);
	}

	/**
	 * Removes the persisted amenity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amenityId the primary key of the persisted amenity
	 * @return the persisted amenity that was removed
	 * @throws NoSuchPersistedAmenityException if a persisted amenity with the primary key could not be found
	 */
	public static PersistedAmenity remove(long amenityId)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedAmenityException {

		return getPersistence().remove(amenityId);
	}

	public static PersistedAmenity updateImpl(
		PersistedAmenity persistedAmenity) {

		return getPersistence().updateImpl(persistedAmenity);
	}

	/**
	 * Returns the persisted amenity with the primary key or throws a <code>NoSuchPersistedAmenityException</code> if it could not be found.
	 *
	 * @param amenityId the primary key of the persisted amenity
	 * @return the persisted amenity
	 * @throws NoSuchPersistedAmenityException if a persisted amenity with the primary key could not be found
	 */
	public static PersistedAmenity findByPrimaryKey(long amenityId)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedAmenityException {

		return getPersistence().findByPrimaryKey(amenityId);
	}

	/**
	 * Returns the persisted amenity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amenityId the primary key of the persisted amenity
	 * @return the persisted amenity, or <code>null</code> if a persisted amenity with the primary key could not be found
	 */
	public static PersistedAmenity fetchByPrimaryKey(long amenityId) {
		return getPersistence().fetchByPrimaryKey(amenityId);
	}

	/**
	 * Returns all the persisted amenities.
	 *
	 * @return the persisted amenities
	 */
	public static List<PersistedAmenity> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the persisted amenities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @return the range of persisted amenities
	 */
	public static List<PersistedAmenity> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the persisted amenities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted amenities
	 */
	public static List<PersistedAmenity> findAll(
		int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted amenities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted amenities
	 */
	public static List<PersistedAmenity> findAll(
		int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the persisted amenities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of persisted amenities.
	 *
	 * @return the number of persisted amenities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	/**
	 * Returns the primaryKeys of persisted rooms associated with the persisted amenity.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @return long[] of the primaryKeys of persisted rooms associated with the persisted amenity
	 */
	public static long[] getPersistedRoomPrimaryKeys(long pk) {
		return getPersistence().getPersistedRoomPrimaryKeys(pk);
	}

	/**
	 * Returns all the persisted amenity associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return the persisted amenities associated with the persisted room
	 */
	public static List<PersistedAmenity> getPersistedRoomPersistedAmenities(
		long pk) {

		return getPersistence().getPersistedRoomPersistedAmenities(pk);
	}

	/**
	 * Returns all the persisted amenity associated with the persisted room.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the persisted room
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of persisted amenities associated with the persisted room
	 */
	public static List<PersistedAmenity> getPersistedRoomPersistedAmenities(
		long pk, int start, int end) {

		return getPersistence().getPersistedRoomPersistedAmenities(
			pk, start, end);
	}

	/**
	 * Returns all the persisted amenity associated with the persisted room.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedAmenityModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the persisted room
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted amenities associated with the persisted room
	 */
	public static List<PersistedAmenity> getPersistedRoomPersistedAmenities(
		long pk, int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator) {

		return getPersistence().getPersistedRoomPersistedAmenities(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persisted rooms associated with the persisted amenity.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @return the number of persisted rooms associated with the persisted amenity
	 */
	public static int getPersistedRoomsSize(long pk) {
		return getPersistence().getPersistedRoomsSize(pk);
	}

	/**
	 * Returns <code>true</code> if the persisted room is associated with the persisted amenity.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPK the primary key of the persisted room
	 * @return <code>true</code> if the persisted room is associated with the persisted amenity; <code>false</code> otherwise
	 */
	public static boolean containsPersistedRoom(long pk, long persistedRoomPK) {
		return getPersistence().containsPersistedRoom(pk, persistedRoomPK);
	}

	/**
	 * Returns <code>true</code> if the persisted amenity has any persisted rooms associated with it.
	 *
	 * @param pk the primary key of the persisted amenity to check for associations with persisted rooms
	 * @return <code>true</code> if the persisted amenity has any persisted rooms associated with it; <code>false</code> otherwise
	 */
	public static boolean containsPersistedRooms(long pk) {
		return getPersistence().containsPersistedRooms(pk);
	}

	/**
	 * Adds an association between the persisted amenity and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPK the primary key of the persisted room
	 */
	public static void addPersistedRoom(long pk, long persistedRoomPK) {
		getPersistence().addPersistedRoom(pk, persistedRoomPK);
	}

	/**
	 * Adds an association between the persisted amenity and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoom the persisted room
	 */
	public static void addPersistedRoom(
		long pk, jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		getPersistence().addPersistedRoom(pk, persistedRoom);
	}

	/**
	 * Adds an association between the persisted amenity and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPKs the primary keys of the persisted rooms
	 */
	public static void addPersistedRooms(long pk, long[] persistedRoomPKs) {
		getPersistence().addPersistedRooms(pk, persistedRoomPKs);
	}

	/**
	 * Adds an association between the persisted amenity and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRooms the persisted rooms
	 */
	public static void addPersistedRooms(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedRoom> persistedRooms) {

		getPersistence().addPersistedRooms(pk, persistedRooms);
	}

	/**
	 * Clears all associations between the persisted amenity and its persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity to clear the associated persisted rooms from
	 */
	public static void clearPersistedRooms(long pk) {
		getPersistence().clearPersistedRooms(pk);
	}

	/**
	 * Removes the association between the persisted amenity and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPK the primary key of the persisted room
	 */
	public static void removePersistedRoom(long pk, long persistedRoomPK) {
		getPersistence().removePersistedRoom(pk, persistedRoomPK);
	}

	/**
	 * Removes the association between the persisted amenity and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoom the persisted room
	 */
	public static void removePersistedRoom(
		long pk, jp.co.liferay.reservation.model.PersistedRoom persistedRoom) {

		getPersistence().removePersistedRoom(pk, persistedRoom);
	}

	/**
	 * Removes the association between the persisted amenity and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPKs the primary keys of the persisted rooms
	 */
	public static void removePersistedRooms(long pk, long[] persistedRoomPKs) {
		getPersistence().removePersistedRooms(pk, persistedRoomPKs);
	}

	/**
	 * Removes the association between the persisted amenity and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRooms the persisted rooms
	 */
	public static void removePersistedRooms(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedRoom> persistedRooms) {

		getPersistence().removePersistedRooms(pk, persistedRooms);
	}

	/**
	 * Sets the persisted rooms associated with the persisted amenity, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPKs the primary keys of the persisted rooms to be associated with the persisted amenity
	 */
	public static void setPersistedRooms(long pk, long[] persistedRoomPKs) {
		getPersistence().setPersistedRooms(pk, persistedRoomPKs);
	}

	/**
	 * Sets the persisted rooms associated with the persisted amenity, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRooms the persisted rooms to be associated with the persisted amenity
	 */
	public static void setPersistedRooms(
		long pk,
		List<jp.co.liferay.reservation.model.PersistedRoom> persistedRooms) {

		getPersistence().setPersistedRooms(pk, persistedRooms);
	}

	public static PersistedAmenityPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedAmenityPersistence, PersistedAmenityPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PersistedAmenityPersistence.class);

		ServiceTracker<PersistedAmenityPersistence, PersistedAmenityPersistence>
			serviceTracker =
				new ServiceTracker
					<PersistedAmenityPersistence, PersistedAmenityPersistence>(
						bundle.getBundleContext(),
						PersistedAmenityPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}