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

import jp.co.liferay.reservation.exception.NoSuchPersistedOfficeException;
import jp.co.liferay.reservation.model.PersistedOffice;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the persisted office service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedOfficeUtil
 * @generated
 */
@ProviderType
public interface PersistedOfficePersistence
	extends BasePersistence<PersistedOffice> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PersistedOfficeUtil} to access the persisted office persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the persisted offices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted offices
	 */
	public java.util.List<PersistedOffice> findByUuid(String uuid);

	/**
	 * Returns a range of all the persisted offices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @return the range of matching persisted offices
	 */
	public java.util.List<PersistedOffice> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the persisted offices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted offices
	 */
	public java.util.List<PersistedOffice> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted offices where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted offices
	 */
	public java.util.List<PersistedOffice> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted office in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted office
	 * @throws NoSuchPersistedOfficeException if a matching persisted office could not be found
	 */
	public PersistedOffice findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
				orderByComparator)
		throws NoSuchPersistedOfficeException;

	/**
	 * Returns the first persisted office in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	public PersistedOffice fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
			orderByComparator);

	/**
	 * Returns the last persisted office in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted office
	 * @throws NoSuchPersistedOfficeException if a matching persisted office could not be found
	 */
	public PersistedOffice findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
				orderByComparator)
		throws NoSuchPersistedOfficeException;

	/**
	 * Returns the last persisted office in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	public PersistedOffice fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
			orderByComparator);

	/**
	 * Returns the persisted offices before and after the current persisted office in the ordered set where uuid = &#63;.
	 *
	 * @param officeId the primary key of the current persisted office
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted office
	 * @throws NoSuchPersistedOfficeException if a persisted office with the primary key could not be found
	 */
	public PersistedOffice[] findByUuid_PrevAndNext(
			long officeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
				orderByComparator)
		throws NoSuchPersistedOfficeException;

	/**
	 * Removes all the persisted offices where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of persisted offices where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted offices
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the persisted offices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted offices
	 */
	public java.util.List<PersistedOffice> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the persisted offices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @return the range of matching persisted offices
	 */
	public java.util.List<PersistedOffice> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the persisted offices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted offices
	 */
	public java.util.List<PersistedOffice> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted offices where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>.
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
	public java.util.List<PersistedOffice> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first persisted office in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted office
	 * @throws NoSuchPersistedOfficeException if a matching persisted office could not be found
	 */
	public PersistedOffice findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
				orderByComparator)
		throws NoSuchPersistedOfficeException;

	/**
	 * Returns the first persisted office in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	public PersistedOffice fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
			orderByComparator);

	/**
	 * Returns the last persisted office in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted office
	 * @throws NoSuchPersistedOfficeException if a matching persisted office could not be found
	 */
	public PersistedOffice findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
				orderByComparator)
		throws NoSuchPersistedOfficeException;

	/**
	 * Returns the last persisted office in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	public PersistedOffice fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
			orderByComparator);

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
	public PersistedOffice[] findByUuid_C_PrevAndNext(
			long officeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
				orderByComparator)
		throws NoSuchPersistedOfficeException;

	/**
	 * Removes all the persisted offices where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of persisted offices where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted offices
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns the persisted office where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedOfficeException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted office
	 * @throws NoSuchPersistedOfficeException if a matching persisted office could not be found
	 */
	public PersistedOffice findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedOfficeException;

	/**
	 * Returns the persisted office where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	public PersistedOffice fetchByC_ERC(
		long companyId, String externalReferenceCode);

	/**
	 * Returns the persisted office where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted office, or <code>null</code> if a matching persisted office could not be found
	 */
	public PersistedOffice fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache);

	/**
	 * Removes the persisted office where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted office that was removed
	 */
	public PersistedOffice removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedOfficeException;

	/**
	 * Returns the number of persisted offices where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted offices
	 */
	public int countByC_ERC(long companyId, String externalReferenceCode);

	/**
	 * Caches the persisted office in the entity cache if it is enabled.
	 *
	 * @param persistedOffice the persisted office
	 */
	public void cacheResult(PersistedOffice persistedOffice);

	/**
	 * Caches the persisted offices in the entity cache if it is enabled.
	 *
	 * @param persistedOffices the persisted offices
	 */
	public void cacheResult(java.util.List<PersistedOffice> persistedOffices);

	/**
	 * Creates a new persisted office with the primary key. Does not add the persisted office to the database.
	 *
	 * @param officeId the primary key for the new persisted office
	 * @return the new persisted office
	 */
	public PersistedOffice create(long officeId);

	/**
	 * Removes the persisted office with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param officeId the primary key of the persisted office
	 * @return the persisted office that was removed
	 * @throws NoSuchPersistedOfficeException if a persisted office with the primary key could not be found
	 */
	public PersistedOffice remove(long officeId)
		throws NoSuchPersistedOfficeException;

	public PersistedOffice updateImpl(PersistedOffice persistedOffice);

	/**
	 * Returns the persisted office with the primary key or throws a <code>NoSuchPersistedOfficeException</code> if it could not be found.
	 *
	 * @param officeId the primary key of the persisted office
	 * @return the persisted office
	 * @throws NoSuchPersistedOfficeException if a persisted office with the primary key could not be found
	 */
	public PersistedOffice findByPrimaryKey(long officeId)
		throws NoSuchPersistedOfficeException;

	/**
	 * Returns the persisted office with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param officeId the primary key of the persisted office
	 * @return the persisted office, or <code>null</code> if a persisted office with the primary key could not be found
	 */
	public PersistedOffice fetchByPrimaryKey(long officeId);

	/**
	 * Returns all the persisted offices.
	 *
	 * @return the persisted offices
	 */
	public java.util.List<PersistedOffice> findAll();

	/**
	 * Returns a range of all the persisted offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @return the range of persisted offices
	 */
	public java.util.List<PersistedOffice> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the persisted offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted offices
	 */
	public java.util.List<PersistedOffice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
			orderByComparator);

	/**
	 * Returns an ordered range of all the persisted offices.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedOfficeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted offices
	 * @param end the upper bound of the range of persisted offices (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted offices
	 */
	public java.util.List<PersistedOffice> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PersistedOffice>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the persisted offices from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of persisted offices.
	 *
	 * @return the number of persisted offices
	 */
	public int countAll();

}