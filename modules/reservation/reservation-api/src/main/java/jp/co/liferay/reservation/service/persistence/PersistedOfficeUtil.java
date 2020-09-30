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

import jp.co.liferay.reservation.model.PersistedOffice;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the persisted office service. This utility wraps <code>jp.co.liferay.reservation.service.persistence.impl.PersistedOfficePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedOfficePersistence
 * @generated
 */
@ProviderType
public class PersistedOfficeUtil {

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
	public static void clearCache(PersistedOffice persistedOffice) {
		getPersistence().clearCache(persistedOffice);
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
	public static Map<Serializable, PersistedOffice> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PersistedOffice> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PersistedOffice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PersistedOffice> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PersistedOffice> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PersistedOffice update(PersistedOffice persistedOffice) {
		return getPersistence().update(persistedOffice);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PersistedOffice update(
		PersistedOffice persistedOffice, ServiceContext serviceContext) {

		return getPersistence().update(persistedOffice, serviceContext);
	}

	/**
	 * Returns all the persisted offices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted offices
	 */
	public static List<PersistedOffice> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the persisted offices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @return the range of matching persisted offices
	 */
	public static List<PersistedOffice> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted offices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted offices
	 */
	public static List<PersistedOffice> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedOffice> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted offices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted offices
	 */
	public static List<PersistedOffice> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedOffice> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted office in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted office
	 * @throws NoSuchPersistedOfficeException if a matching persisted office could not be found
	 */
	public static PersistedOffice findByUuid_First(
			String uuid, OrderByComparator<PersistedOffice> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedOfficeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first persisted office in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	public static PersistedOffice fetchByUuid_First(
		String uuid, OrderByComparator<PersistedOffice> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted office in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted office
	 * @throws NoSuchPersistedOfficeException if a matching persisted office could not be found
	 */
	public static PersistedOffice findByUuid_Last(
			String uuid, OrderByComparator<PersistedOffice> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedOfficeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last persisted office in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	public static PersistedOffice fetchByUuid_Last(
		String uuid, OrderByComparator<PersistedOffice> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the persisted offices before and after the current persisted office in the ordered set where uuid = &#63;.
	 *
	 * @param officeId the primary key of the current persisted office
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted office
	 * @throws NoSuchPersistedOfficeException if a persisted office with the primary key could not be found
	 */
	public static PersistedOffice[] findByUuid_PrevAndNext(
			long officeId, String uuid,
			OrderByComparator<PersistedOffice> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedOfficeException {

		return getPersistence().findByUuid_PrevAndNext(
			officeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the persisted offices where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of persisted offices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted offices
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the persisted offices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted offices
	 */
	public static List<PersistedOffice> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the persisted offices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @return the range of matching persisted offices
	 */
	public static List<PersistedOffice> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the persisted offices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted offices
	 */
	public static List<PersistedOffice> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedOffice> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted offices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted offices
	 */
	public static List<PersistedOffice> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedOffice> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first persisted office in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted office
	 * @throws NoSuchPersistedOfficeException if a matching persisted office could not be found
	 */
	public static PersistedOffice findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersistedOffice> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedOfficeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first persisted office in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	public static PersistedOffice fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersistedOffice> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last persisted office in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted office
	 * @throws NoSuchPersistedOfficeException if a matching persisted office could not be found
	 */
	public static PersistedOffice findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersistedOffice> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedOfficeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last persisted office in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	public static PersistedOffice fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersistedOffice> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the persisted offices before and after the current persisted office in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param officeId the primary key of the current persisted office
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted office
	 * @throws NoSuchPersistedOfficeException if a persisted office with the primary key could not be found
	 */
	public static PersistedOffice[] findByUuid_C_PrevAndNext(
			long officeId, String uuid, long companyId,
			OrderByComparator<PersistedOffice> orderByComparator)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedOfficeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			officeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the persisted offices where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of persisted offices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted offices
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the persisted office where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedOfficeException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted office
	 * @throws NoSuchPersistedOfficeException if a matching persisted office could not be found
	 */
	public static PersistedOffice findByC_ERC(
			long companyId, String externalReferenceCode)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedOfficeException {

		return getPersistence().findByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted office where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	public static PersistedOffice fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().fetchByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the persisted office where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	public static PersistedOffice fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		return getPersistence().fetchByC_ERC(
			companyId, externalReferenceCode, useFinderCache);
	}

	/**
	 * Removes the persisted office where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted office that was removed
	 */
	public static PersistedOffice removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedOfficeException {

		return getPersistence().removeByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Returns the number of persisted offices where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted offices
	 */
	public static int countByC_ERC(
		long companyId, String externalReferenceCode) {

		return getPersistence().countByC_ERC(companyId, externalReferenceCode);
	}

	/**
	 * Caches the persisted office in the entity cache if it is enabled.
	 *
	 * @param persistedOffice the persisted office
	 */
	public static void cacheResult(PersistedOffice persistedOffice) {
		getPersistence().cacheResult(persistedOffice);
	}

	/**
	 * Caches the persisted offices in the entity cache if it is enabled.
	 *
	 * @param persistedOffices the persisted offices
	 */
	public static void cacheResult(List<PersistedOffice> persistedOffices) {
		getPersistence().cacheResult(persistedOffices);
	}

	/**
	 * Creates a new persisted office with the primary key. Does not add the persisted office to the database.
	 *
	 * @param officeId the primary key for the new persisted office
	 * @return the new persisted office
	 */
	public static PersistedOffice create(long officeId) {
		return getPersistence().create(officeId);
	}

	/**
	 * Removes the persisted office with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officeId the primary key of the persisted office
	 * @return the persisted office that was removed
	 * @throws NoSuchPersistedOfficeException if a persisted office with the primary key could not be found
	 */
	public static PersistedOffice remove(long officeId)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedOfficeException {

		return getPersistence().remove(officeId);
	}

	public static PersistedOffice updateImpl(PersistedOffice persistedOffice) {
		return getPersistence().updateImpl(persistedOffice);
	}

	/**
	 * Returns the persisted office with the primary key or throws a <code>NoSuchPersistedOfficeException</code> if it could not be found.
	 *
	 * @param officeId the primary key of the persisted office
	 * @return the persisted office
	 * @throws NoSuchPersistedOfficeException if a persisted office with the primary key could not be found
	 */
	public static PersistedOffice findByPrimaryKey(long officeId)
		throws jp.co.liferay.reservation.exception.
			NoSuchPersistedOfficeException {

		return getPersistence().findByPrimaryKey(officeId);
	}

	/**
	 * Returns the persisted office with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param officeId the primary key of the persisted office
	 * @return the persisted office, or <code>null</code> if a persisted office with the primary key could not be found
	 */
	public static PersistedOffice fetchByPrimaryKey(long officeId) {
		return getPersistence().fetchByPrimaryKey(officeId);
	}

	/**
	 * Returns all the persisted offices.
	 *
	 * @return the persisted offices
	 */
	public static List<PersistedOffice> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the persisted offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @return the range of persisted offices
	 */
	public static List<PersistedOffice> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the persisted offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted offices
	 */
	public static List<PersistedOffice> findAll(
		int start, int end,
		OrderByComparator<PersistedOffice> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the persisted offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted offices
	 */
	public static List<PersistedOffice> findAll(
		int start, int end,
		OrderByComparator<PersistedOffice> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the persisted offices from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of persisted offices.
	 *
	 * @return the number of persisted offices
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PersistedOfficePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PersistedOfficePersistence, PersistedOfficePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PersistedOfficePersistence.class);

		ServiceTracker<PersistedOfficePersistence, PersistedOfficePersistence>
			serviceTracker =
				new ServiceTracker
					<PersistedOfficePersistence, PersistedOfficePersistence>(
						bundle.getBundleContext(),
						PersistedOfficePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}