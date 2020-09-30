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

package jp.co.liferay.reservation.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.service.persistence.impl.TableMapper;
import com.liferay.portal.kernel.service.persistence.impl.TableMapperFactory;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import jp.co.liferay.reservation.exception.NoSuchPersistedAmenityException;
import jp.co.liferay.reservation.model.PersistedAmenity;
import jp.co.liferay.reservation.model.PersistedRoom;
import jp.co.liferay.reservation.model.impl.PersistedAmenityImpl;
import jp.co.liferay.reservation.model.impl.PersistedAmenityModelImpl;
import jp.co.liferay.reservation.service.persistence.PersistedAmenityPersistence;
import jp.co.liferay.reservation.service.persistence.impl.constants.ReservationPersistenceConstants;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the persisted amenity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PersistedAmenityPersistence.class)
@ProviderType
public class PersistedAmenityPersistenceImpl
	extends BasePersistenceImpl<PersistedAmenity>
	implements PersistedAmenityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PersistedAmenityUtil</code> to access the persisted amenity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PersistedAmenityImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the persisted amenities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted amenities
	 */
	@Override
	public List<PersistedAmenity> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PersistedAmenity> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<PersistedAmenity> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<PersistedAmenity> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<PersistedAmenity> list = null;

		if (useFinderCache) {
			list = (List<PersistedAmenity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedAmenity persistedAmenity : list) {
					if (!uuid.equals(persistedAmenity.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_PERSISTEDAMENITY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(PersistedAmenityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<PersistedAmenity>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersistedAmenity>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first persisted amenity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted amenity
	 * @throws NoSuchPersistedAmenityException if a matching persisted amenity could not be found
	 */
	@Override
	public PersistedAmenity findByUuid_First(
			String uuid, OrderByComparator<PersistedAmenity> orderByComparator)
		throws NoSuchPersistedAmenityException {

		PersistedAmenity persistedAmenity = fetchByUuid_First(
			uuid, orderByComparator);

		if (persistedAmenity != null) {
			return persistedAmenity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPersistedAmenityException(msg.toString());
	}

	/**
	 * Returns the first persisted amenity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	@Override
	public PersistedAmenity fetchByUuid_First(
		String uuid, OrderByComparator<PersistedAmenity> orderByComparator) {

		List<PersistedAmenity> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted amenity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted amenity
	 * @throws NoSuchPersistedAmenityException if a matching persisted amenity could not be found
	 */
	@Override
	public PersistedAmenity findByUuid_Last(
			String uuid, OrderByComparator<PersistedAmenity> orderByComparator)
		throws NoSuchPersistedAmenityException {

		PersistedAmenity persistedAmenity = fetchByUuid_Last(
			uuid, orderByComparator);

		if (persistedAmenity != null) {
			return persistedAmenity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPersistedAmenityException(msg.toString());
	}

	/**
	 * Returns the last persisted amenity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	@Override
	public PersistedAmenity fetchByUuid_Last(
		String uuid, OrderByComparator<PersistedAmenity> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PersistedAmenity> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PersistedAmenity[] findByUuid_PrevAndNext(
			long amenityId, String uuid,
			OrderByComparator<PersistedAmenity> orderByComparator)
		throws NoSuchPersistedAmenityException {

		uuid = Objects.toString(uuid, "");

		PersistedAmenity persistedAmenity = findByPrimaryKey(amenityId);

		Session session = null;

		try {
			session = openSession();

			PersistedAmenity[] array = new PersistedAmenityImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, persistedAmenity, uuid, orderByComparator, true);

			array[1] = persistedAmenity;

			array[2] = getByUuid_PrevAndNext(
				session, persistedAmenity, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedAmenity getByUuid_PrevAndNext(
		Session session, PersistedAmenity persistedAmenity, String uuid,
		OrderByComparator<PersistedAmenity> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_PERSISTEDAMENITY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PersistedAmenityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						persistedAmenity)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<PersistedAmenity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted amenities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PersistedAmenity persistedAmenity :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(persistedAmenity);
		}
	}

	/**
	 * Returns the number of persisted amenities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted amenities
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PERSISTEDAMENITY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"persistedAmenity.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(persistedAmenity.uuid IS NULL OR persistedAmenity.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the persisted amenities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted amenities
	 */
	@Override
	public List<PersistedAmenity> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PersistedAmenity> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<PersistedAmenity> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<PersistedAmenity> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<PersistedAmenity> list = null;

		if (useFinderCache) {
			list = (List<PersistedAmenity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedAmenity persistedAmenity : list) {
					if (!uuid.equals(persistedAmenity.getUuid()) ||
						(companyId != persistedAmenity.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PERSISTEDAMENITY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(PersistedAmenityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<PersistedAmenity>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersistedAmenity>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public PersistedAmenity findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersistedAmenity> orderByComparator)
		throws NoSuchPersistedAmenityException {

		PersistedAmenity persistedAmenity = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (persistedAmenity != null) {
			return persistedAmenity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPersistedAmenityException(msg.toString());
	}

	/**
	 * Returns the first persisted amenity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	@Override
	public PersistedAmenity fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersistedAmenity> orderByComparator) {

		List<PersistedAmenity> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PersistedAmenity findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersistedAmenity> orderByComparator)
		throws NoSuchPersistedAmenityException {

		PersistedAmenity persistedAmenity = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (persistedAmenity != null) {
			return persistedAmenity;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPersistedAmenityException(msg.toString());
	}

	/**
	 * Returns the last persisted amenity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	@Override
	public PersistedAmenity fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersistedAmenity> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PersistedAmenity> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PersistedAmenity[] findByUuid_C_PrevAndNext(
			long amenityId, String uuid, long companyId,
			OrderByComparator<PersistedAmenity> orderByComparator)
		throws NoSuchPersistedAmenityException {

		uuid = Objects.toString(uuid, "");

		PersistedAmenity persistedAmenity = findByPrimaryKey(amenityId);

		Session session = null;

		try {
			session = openSession();

			PersistedAmenity[] array = new PersistedAmenityImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, persistedAmenity, uuid, companyId, orderByComparator,
				true);

			array[1] = persistedAmenity;

			array[2] = getByUuid_C_PrevAndNext(
				session, persistedAmenity, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedAmenity getByUuid_C_PrevAndNext(
		Session session, PersistedAmenity persistedAmenity, String uuid,
		long companyId, OrderByComparator<PersistedAmenity> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_PERSISTEDAMENITY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(PersistedAmenityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						persistedAmenity)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<PersistedAmenity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted amenities where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PersistedAmenity persistedAmenity :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(persistedAmenity);
		}
	}

	/**
	 * Returns the number of persisted amenities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted amenities
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PERSISTEDAMENITY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"persistedAmenity.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(persistedAmenity.uuid IS NULL OR persistedAmenity.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"persistedAmenity.companyId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the persisted amenity where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedAmenityException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted amenity
	 * @throws NoSuchPersistedAmenityException if a matching persisted amenity could not be found
	 */
	@Override
	public PersistedAmenity findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedAmenityException {

		PersistedAmenity persistedAmenity = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (persistedAmenity == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("companyId=");
			msg.append(companyId);

			msg.append(", externalReferenceCode=");
			msg.append(externalReferenceCode);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchPersistedAmenityException(msg.toString());
		}

		return persistedAmenity;
	}

	/**
	 * Returns the persisted amenity where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	@Override
	public PersistedAmenity fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the persisted amenity where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted amenity, or <code>null</code> if a matching persisted amenity could not be found
	 */
	@Override
	public PersistedAmenity fetchByC_ERC(
		long companyId, String externalReferenceCode, boolean useFinderCache) {

		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {companyId, externalReferenceCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_ERC, finderArgs, this);
		}

		if (result instanceof PersistedAmenity) {
			PersistedAmenity persistedAmenity = (PersistedAmenity)result;

			if ((companyId != persistedAmenity.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					persistedAmenity.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PERSISTEDAMENITY_WHERE);

			query.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				query.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				query.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindExternalReferenceCode) {
					qPos.add(externalReferenceCode);
				}

				List<PersistedAmenity> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByC_ERC, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									companyId, externalReferenceCode
								};
							}

							_log.warn(
								"PersistedAmenityPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PersistedAmenity persistedAmenity = list.get(0);

					result = persistedAmenity;

					cacheResult(persistedAmenity);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByC_ERC, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (PersistedAmenity)result;
		}
	}

	/**
	 * Removes the persisted amenity where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted amenity that was removed
	 */
	@Override
	public PersistedAmenity removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedAmenityException {

		PersistedAmenity persistedAmenity = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(persistedAmenity);
	}

	/**
	 * Returns the number of persisted amenities where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted amenities
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PERSISTEDAMENITY_WHERE);

			query.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				query.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				query.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (bindExternalReferenceCode) {
					qPos.add(externalReferenceCode);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_ERC_COMPANYID_2 =
		"persistedAmenity.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"persistedAmenity.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(persistedAmenity.externalReferenceCode IS NULL OR persistedAmenity.externalReferenceCode = '')";

	public PersistedAmenityPersistenceImpl() {
		setModelClass(PersistedAmenity.class);

		setModelImplClass(PersistedAmenityImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the persisted amenity in the entity cache if it is enabled.
	 *
	 * @param persistedAmenity the persisted amenity
	 */
	@Override
	public void cacheResult(PersistedAmenity persistedAmenity) {
		entityCache.putResult(
			entityCacheEnabled, PersistedAmenityImpl.class,
			persistedAmenity.getPrimaryKey(), persistedAmenity);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				persistedAmenity.getCompanyId(),
				persistedAmenity.getExternalReferenceCode()
			},
			persistedAmenity);

		persistedAmenity.resetOriginalValues();
	}

	/**
	 * Caches the persisted amenities in the entity cache if it is enabled.
	 *
	 * @param persistedAmenities the persisted amenities
	 */
	@Override
	public void cacheResult(List<PersistedAmenity> persistedAmenities) {
		for (PersistedAmenity persistedAmenity : persistedAmenities) {
			if (entityCache.getResult(
					entityCacheEnabled, PersistedAmenityImpl.class,
					persistedAmenity.getPrimaryKey()) == null) {

				cacheResult(persistedAmenity);
			}
			else {
				persistedAmenity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all persisted amenities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PersistedAmenityImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the persisted amenity.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PersistedAmenity persistedAmenity) {
		entityCache.removeResult(
			entityCacheEnabled, PersistedAmenityImpl.class,
			persistedAmenity.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(PersistedAmenityModelImpl)persistedAmenity, true);
	}

	@Override
	public void clearCache(List<PersistedAmenity> persistedAmenities) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PersistedAmenity persistedAmenity : persistedAmenities) {
			entityCache.removeResult(
				entityCacheEnabled, PersistedAmenityImpl.class,
				persistedAmenity.getPrimaryKey());

			clearUniqueFindersCache(
				(PersistedAmenityModelImpl)persistedAmenity, true);
		}
	}

	protected void cacheUniqueFindersCache(
		PersistedAmenityModelImpl persistedAmenityModelImpl) {

		Object[] args = new Object[] {
			persistedAmenityModelImpl.getCompanyId(),
			persistedAmenityModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(
			_finderPathCountByC_ERC, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, persistedAmenityModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		PersistedAmenityModelImpl persistedAmenityModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				persistedAmenityModelImpl.getCompanyId(),
				persistedAmenityModelImpl.getExternalReferenceCode()
			};

			finderCache.removeResult(_finderPathCountByC_ERC, args);
			finderCache.removeResult(_finderPathFetchByC_ERC, args);
		}

		if ((persistedAmenityModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_ERC.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				persistedAmenityModelImpl.getOriginalCompanyId(),
				persistedAmenityModelImpl.getOriginalExternalReferenceCode()
			};

			finderCache.removeResult(_finderPathCountByC_ERC, args);
			finderCache.removeResult(_finderPathFetchByC_ERC, args);
		}
	}

	/**
	 * Creates a new persisted amenity with the primary key. Does not add the persisted amenity to the database.
	 *
	 * @param amenityId the primary key for the new persisted amenity
	 * @return the new persisted amenity
	 */
	@Override
	public PersistedAmenity create(long amenityId) {
		PersistedAmenity persistedAmenity = new PersistedAmenityImpl();

		persistedAmenity.setNew(true);
		persistedAmenity.setPrimaryKey(amenityId);

		String uuid = PortalUUIDUtil.generate();

		persistedAmenity.setUuid(uuid);

		persistedAmenity.setCompanyId(CompanyThreadLocal.getCompanyId());

		return persistedAmenity;
	}

	/**
	 * Removes the persisted amenity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param amenityId the primary key of the persisted amenity
	 * @return the persisted amenity that was removed
	 * @throws NoSuchPersistedAmenityException if a persisted amenity with the primary key could not be found
	 */
	@Override
	public PersistedAmenity remove(long amenityId)
		throws NoSuchPersistedAmenityException {

		return remove((Serializable)amenityId);
	}

	/**
	 * Removes the persisted amenity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the persisted amenity
	 * @return the persisted amenity that was removed
	 * @throws NoSuchPersistedAmenityException if a persisted amenity with the primary key could not be found
	 */
	@Override
	public PersistedAmenity remove(Serializable primaryKey)
		throws NoSuchPersistedAmenityException {

		Session session = null;

		try {
			session = openSession();

			PersistedAmenity persistedAmenity = (PersistedAmenity)session.get(
				PersistedAmenityImpl.class, primaryKey);

			if (persistedAmenity == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersistedAmenityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(persistedAmenity);
		}
		catch (NoSuchPersistedAmenityException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PersistedAmenity removeImpl(PersistedAmenity persistedAmenity) {
		persistedAmenityToPersistedRoomTableMapper.
			deleteLeftPrimaryKeyTableMappings(persistedAmenity.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(persistedAmenity)) {
				persistedAmenity = (PersistedAmenity)session.get(
					PersistedAmenityImpl.class,
					persistedAmenity.getPrimaryKeyObj());
			}

			if (persistedAmenity != null) {
				session.delete(persistedAmenity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (persistedAmenity != null) {
			clearCache(persistedAmenity);
		}

		return persistedAmenity;
	}

	@Override
	public PersistedAmenity updateImpl(PersistedAmenity persistedAmenity) {
		boolean isNew = persistedAmenity.isNew();

		if (!(persistedAmenity instanceof PersistedAmenityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(persistedAmenity.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					persistedAmenity);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in persistedAmenity proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PersistedAmenity implementation " +
					persistedAmenity.getClass());
		}

		PersistedAmenityModelImpl persistedAmenityModelImpl =
			(PersistedAmenityModelImpl)persistedAmenity;

		if (Validator.isNull(persistedAmenity.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			persistedAmenity.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (persistedAmenity.isNew()) {
				session.save(persistedAmenity);

				persistedAmenity.setNew(false);
			}
			else {
				persistedAmenity = (PersistedAmenity)session.merge(
					persistedAmenity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {persistedAmenityModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				persistedAmenityModelImpl.getUuid(),
				persistedAmenityModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((persistedAmenityModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					persistedAmenityModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {persistedAmenityModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((persistedAmenityModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					persistedAmenityModelImpl.getOriginalUuid(),
					persistedAmenityModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					persistedAmenityModelImpl.getUuid(),
					persistedAmenityModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, PersistedAmenityImpl.class,
			persistedAmenity.getPrimaryKey(), persistedAmenity, false);

		clearUniqueFindersCache(persistedAmenityModelImpl, false);
		cacheUniqueFindersCache(persistedAmenityModelImpl);

		persistedAmenity.resetOriginalValues();

		return persistedAmenity;
	}

	/**
	 * Returns the persisted amenity with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the persisted amenity
	 * @return the persisted amenity
	 * @throws NoSuchPersistedAmenityException if a persisted amenity with the primary key could not be found
	 */
	@Override
	public PersistedAmenity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersistedAmenityException {

		PersistedAmenity persistedAmenity = fetchByPrimaryKey(primaryKey);

		if (persistedAmenity == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersistedAmenityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return persistedAmenity;
	}

	/**
	 * Returns the persisted amenity with the primary key or throws a <code>NoSuchPersistedAmenityException</code> if it could not be found.
	 *
	 * @param amenityId the primary key of the persisted amenity
	 * @return the persisted amenity
	 * @throws NoSuchPersistedAmenityException if a persisted amenity with the primary key could not be found
	 */
	@Override
	public PersistedAmenity findByPrimaryKey(long amenityId)
		throws NoSuchPersistedAmenityException {

		return findByPrimaryKey((Serializable)amenityId);
	}

	/**
	 * Returns the persisted amenity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param amenityId the primary key of the persisted amenity
	 * @return the persisted amenity, or <code>null</code> if a persisted amenity with the primary key could not be found
	 */
	@Override
	public PersistedAmenity fetchByPrimaryKey(long amenityId) {
		return fetchByPrimaryKey((Serializable)amenityId);
	}

	/**
	 * Returns all the persisted amenities.
	 *
	 * @return the persisted amenities
	 */
	@Override
	public List<PersistedAmenity> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PersistedAmenity> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<PersistedAmenity> findAll(
		int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<PersistedAmenity> findAll(
		int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<PersistedAmenity> list = null;

		if (useFinderCache) {
			list = (List<PersistedAmenity>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PERSISTEDAMENITY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERSISTEDAMENITY;

				if (pagination) {
					sql = sql.concat(PersistedAmenityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PersistedAmenity>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersistedAmenity>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the persisted amenities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PersistedAmenity persistedAmenity : findAll()) {
			remove(persistedAmenity);
		}
	}

	/**
	 * Returns the number of persisted amenities.
	 *
	 * @return the number of persisted amenities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PERSISTEDAMENITY);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the primaryKeys of persisted rooms associated with the persisted amenity.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @return long[] of the primaryKeys of persisted rooms associated with the persisted amenity
	 */
	@Override
	public long[] getPersistedRoomPrimaryKeys(long pk) {
		long[] pks =
			persistedAmenityToPersistedRoomTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the persisted amenity associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return the persisted amenities associated with the persisted room
	 */
	@Override
	public List<PersistedAmenity> getPersistedRoomPersistedAmenities(long pk) {
		return getPersistedRoomPersistedAmenities(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<PersistedAmenity> getPersistedRoomPersistedAmenities(
		long pk, int start, int end) {

		return getPersistedRoomPersistedAmenities(pk, start, end, null);
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
	@Override
	public List<PersistedAmenity> getPersistedRoomPersistedAmenities(
		long pk, int start, int end,
		OrderByComparator<PersistedAmenity> orderByComparator) {

		return persistedAmenityToPersistedRoomTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persisted rooms associated with the persisted amenity.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @return the number of persisted rooms associated with the persisted amenity
	 */
	@Override
	public int getPersistedRoomsSize(long pk) {
		long[] pks =
			persistedAmenityToPersistedRoomTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the persisted room is associated with the persisted amenity.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPK the primary key of the persisted room
	 * @return <code>true</code> if the persisted room is associated with the persisted amenity; <code>false</code> otherwise
	 */
	@Override
	public boolean containsPersistedRoom(long pk, long persistedRoomPK) {
		return persistedAmenityToPersistedRoomTableMapper.containsTableMapping(
			pk, persistedRoomPK);
	}

	/**
	 * Returns <code>true</code> if the persisted amenity has any persisted rooms associated with it.
	 *
	 * @param pk the primary key of the persisted amenity to check for associations with persisted rooms
	 * @return <code>true</code> if the persisted amenity has any persisted rooms associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsPersistedRooms(long pk) {
		if (getPersistedRoomsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the persisted amenity and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPK the primary key of the persisted room
	 */
	@Override
	public void addPersistedRoom(long pk, long persistedRoomPK) {
		PersistedAmenity persistedAmenity = fetchByPrimaryKey(pk);

		if (persistedAmenity == null) {
			persistedAmenityToPersistedRoomTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, persistedRoomPK);
		}
		else {
			persistedAmenityToPersistedRoomTableMapper.addTableMapping(
				persistedAmenity.getCompanyId(), pk, persistedRoomPK);
		}
	}

	/**
	 * Adds an association between the persisted amenity and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoom the persisted room
	 */
	@Override
	public void addPersistedRoom(long pk, PersistedRoom persistedRoom) {
		PersistedAmenity persistedAmenity = fetchByPrimaryKey(pk);

		if (persistedAmenity == null) {
			persistedAmenityToPersistedRoomTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				persistedRoom.getPrimaryKey());
		}
		else {
			persistedAmenityToPersistedRoomTableMapper.addTableMapping(
				persistedAmenity.getCompanyId(), pk,
				persistedRoom.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the persisted amenity and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPKs the primary keys of the persisted rooms
	 */
	@Override
	public void addPersistedRooms(long pk, long[] persistedRoomPKs) {
		long companyId = 0;

		PersistedAmenity persistedAmenity = fetchByPrimaryKey(pk);

		if (persistedAmenity == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = persistedAmenity.getCompanyId();
		}

		persistedAmenityToPersistedRoomTableMapper.addTableMappings(
			companyId, pk, persistedRoomPKs);
	}

	/**
	 * Adds an association between the persisted amenity and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRooms the persisted rooms
	 */
	@Override
	public void addPersistedRooms(long pk, List<PersistedRoom> persistedRooms) {
		addPersistedRooms(
			pk,
			ListUtil.toLongArray(
				persistedRooms, PersistedRoom.ROOM_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the persisted amenity and its persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity to clear the associated persisted rooms from
	 */
	@Override
	public void clearPersistedRooms(long pk) {
		persistedAmenityToPersistedRoomTableMapper.
			deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the persisted amenity and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPK the primary key of the persisted room
	 */
	@Override
	public void removePersistedRoom(long pk, long persistedRoomPK) {
		persistedAmenityToPersistedRoomTableMapper.deleteTableMapping(
			pk, persistedRoomPK);
	}

	/**
	 * Removes the association between the persisted amenity and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoom the persisted room
	 */
	@Override
	public void removePersistedRoom(long pk, PersistedRoom persistedRoom) {
		persistedAmenityToPersistedRoomTableMapper.deleteTableMapping(
			pk, persistedRoom.getPrimaryKey());
	}

	/**
	 * Removes the association between the persisted amenity and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPKs the primary keys of the persisted rooms
	 */
	@Override
	public void removePersistedRooms(long pk, long[] persistedRoomPKs) {
		persistedAmenityToPersistedRoomTableMapper.deleteTableMappings(
			pk, persistedRoomPKs);
	}

	/**
	 * Removes the association between the persisted amenity and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRooms the persisted rooms
	 */
	@Override
	public void removePersistedRooms(
		long pk, List<PersistedRoom> persistedRooms) {

		removePersistedRooms(
			pk,
			ListUtil.toLongArray(
				persistedRooms, PersistedRoom.ROOM_ID_ACCESSOR));
	}

	/**
	 * Sets the persisted rooms associated with the persisted amenity, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRoomPKs the primary keys of the persisted rooms to be associated with the persisted amenity
	 */
	@Override
	public void setPersistedRooms(long pk, long[] persistedRoomPKs) {
		Set<Long> newPersistedRoomPKsSet = SetUtil.fromArray(persistedRoomPKs);
		Set<Long> oldPersistedRoomPKsSet = SetUtil.fromArray(
			persistedAmenityToPersistedRoomTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removePersistedRoomPKsSet = new HashSet<Long>(
			oldPersistedRoomPKsSet);

		removePersistedRoomPKsSet.removeAll(newPersistedRoomPKsSet);

		persistedAmenityToPersistedRoomTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removePersistedRoomPKsSet));

		newPersistedRoomPKsSet.removeAll(oldPersistedRoomPKsSet);

		long companyId = 0;

		PersistedAmenity persistedAmenity = fetchByPrimaryKey(pk);

		if (persistedAmenity == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = persistedAmenity.getCompanyId();
		}

		persistedAmenityToPersistedRoomTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newPersistedRoomPKsSet));
	}

	/**
	 * Sets the persisted rooms associated with the persisted amenity, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param persistedRooms the persisted rooms to be associated with the persisted amenity
	 */
	@Override
	public void setPersistedRooms(long pk, List<PersistedRoom> persistedRooms) {
		try {
			long[] persistedRoomPKs = new long[persistedRooms.size()];

			for (int i = 0; i < persistedRooms.size(); i++) {
				PersistedRoom persistedRoom = persistedRooms.get(i);

				persistedRoomPKs[i] = persistedRoom.getPrimaryKey();
			}

			setPersistedRooms(pk, persistedRoomPKs);
		}
		catch (Exception e) {
			throw processException(e);
		}
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "amenityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PERSISTEDAMENITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PersistedAmenityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the persisted amenity persistence.
	 */
	@Activate
	public void activate() {
		PersistedAmenityModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		PersistedAmenityModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		persistedAmenityToPersistedRoomTableMapper =
			TableMapperFactory.getTableMapper(
				"Reservation_Rooms_Amenities#amenityId",
				"Reservation_Rooms_Amenities", "companyId", "amenityId",
				"roomId", this, PersistedRoom.class);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedAmenityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedAmenityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedAmenityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedAmenityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			PersistedAmenityModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedAmenityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedAmenityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			PersistedAmenityModelImpl.UUID_COLUMN_BITMASK |
			PersistedAmenityModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathFetchByC_ERC = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedAmenityImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			PersistedAmenityModelImpl.COMPANYID_COLUMN_BITMASK |
			PersistedAmenityModelImpl.EXTERNALREFERENCECODE_COLUMN_BITMASK);

		_finderPathCountByC_ERC = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(PersistedAmenityImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper(
			"Reservation_Rooms_Amenities#amenityId");
	}

	@Override
	@Reference(
		target = ReservationPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.jp.co.liferay.reservation.model.PersistedAmenity"),
			true);
	}

	@Override
	@Reference(
		target = ReservationPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ReservationPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	protected TableMapper<PersistedAmenity, PersistedRoom>
		persistedAmenityToPersistedRoomTableMapper;

	private static final String _SQL_SELECT_PERSISTEDAMENITY =
		"SELECT persistedAmenity FROM PersistedAmenity persistedAmenity";

	private static final String _SQL_SELECT_PERSISTEDAMENITY_WHERE =
		"SELECT persistedAmenity FROM PersistedAmenity persistedAmenity WHERE ";

	private static final String _SQL_COUNT_PERSISTEDAMENITY =
		"SELECT COUNT(persistedAmenity) FROM PersistedAmenity persistedAmenity";

	private static final String _SQL_COUNT_PERSISTEDAMENITY_WHERE =
		"SELECT COUNT(persistedAmenity) FROM PersistedAmenity persistedAmenity WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "persistedAmenity.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PersistedAmenity exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PersistedAmenity exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PersistedAmenityPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}