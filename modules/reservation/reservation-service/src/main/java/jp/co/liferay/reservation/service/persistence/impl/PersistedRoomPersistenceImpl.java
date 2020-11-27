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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
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
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import jp.co.liferay.reservation.exception.NoSuchPersistedRoomException;
import jp.co.liferay.reservation.model.PersistedAmenity;
import jp.co.liferay.reservation.model.PersistedPurpose;
import jp.co.liferay.reservation.model.PersistedRoom;
import jp.co.liferay.reservation.model.impl.PersistedRoomImpl;
import jp.co.liferay.reservation.model.impl.PersistedRoomModelImpl;
import jp.co.liferay.reservation.service.persistence.PersistedRoomPersistence;
import jp.co.liferay.reservation.service.persistence.impl.constants.ReservationPersistenceConstants;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the persisted room service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PersistedRoomPersistence.class)
public class PersistedRoomPersistenceImpl
	extends BasePersistenceImpl<PersistedRoom>
	implements PersistedRoomPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PersistedRoomUtil</code> to access the persisted room persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PersistedRoomImpl.class.getName();

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
	 * Returns all the persisted rooms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted rooms
	 */
	@Override
	public List<PersistedRoom> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted rooms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of matching persisted rooms
	 */
	@Override
	public List<PersistedRoom> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted rooms
	 */
	@Override
	public List<PersistedRoom> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted rooms
	 */
	@Override
	public List<PersistedRoom> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<PersistedRoom> list = null;

		if (useFinderCache) {
			list = (List<PersistedRoom>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedRoom persistedRoom : list) {
					if (!uuid.equals(persistedRoom.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PERSISTEDROOM_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersistedRoomModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<PersistedRoom>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first persisted room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom findByUuid_First(
			String uuid, OrderByComparator<PersistedRoom> orderByComparator)
		throws NoSuchPersistedRoomException {

		PersistedRoom persistedRoom = fetchByUuid_First(
			uuid, orderByComparator);

		if (persistedRoom != null) {
			return persistedRoom;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPersistedRoomException(sb.toString());
	}

	/**
	 * Returns the first persisted room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom fetchByUuid_First(
		String uuid, OrderByComparator<PersistedRoom> orderByComparator) {

		List<PersistedRoom> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom findByUuid_Last(
			String uuid, OrderByComparator<PersistedRoom> orderByComparator)
		throws NoSuchPersistedRoomException {

		PersistedRoom persistedRoom = fetchByUuid_Last(uuid, orderByComparator);

		if (persistedRoom != null) {
			return persistedRoom;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPersistedRoomException(sb.toString());
	}

	/**
	 * Returns the last persisted room in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom fetchByUuid_Last(
		String uuid, OrderByComparator<PersistedRoom> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PersistedRoom> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the persisted rooms before and after the current persisted room in the ordered set where uuid = &#63;.
	 *
	 * @param roomId the primary key of the current persisted room
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted room
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	@Override
	public PersistedRoom[] findByUuid_PrevAndNext(
			long roomId, String uuid,
			OrderByComparator<PersistedRoom> orderByComparator)
		throws NoSuchPersistedRoomException {

		uuid = Objects.toString(uuid, "");

		PersistedRoom persistedRoom = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			PersistedRoom[] array = new PersistedRoomImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, persistedRoom, uuid, orderByComparator, true);

			array[1] = persistedRoom;

			array[2] = getByUuid_PrevAndNext(
				session, persistedRoom, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedRoom getByUuid_PrevAndNext(
		Session session, PersistedRoom persistedRoom, String uuid,
		OrderByComparator<PersistedRoom> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PERSISTEDROOM_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PersistedRoomModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						persistedRoom)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PersistedRoom> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted rooms where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PersistedRoom persistedRoom :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(persistedRoom);
		}
	}

	/**
	 * Returns the number of persisted rooms where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted rooms
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERSISTEDROOM_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"persistedRoom.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(persistedRoom.uuid IS NULL OR persistedRoom.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the persisted rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted rooms
	 */
	@Override
	public List<PersistedRoom> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of matching persisted rooms
	 */
	@Override
	public List<PersistedRoom> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted rooms
	 */
	@Override
	public List<PersistedRoom> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
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
	@Override
	public List<PersistedRoom> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

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

		List<PersistedRoom> list = null;

		if (useFinderCache) {
			list = (List<PersistedRoom>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedRoom persistedRoom : list) {
					if (!uuid.equals(persistedRoom.getUuid()) ||
						(companyId != persistedRoom.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PERSISTEDROOM_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersistedRoomModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<PersistedRoom>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first persisted room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersistedRoom> orderByComparator)
		throws NoSuchPersistedRoomException {

		PersistedRoom persistedRoom = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (persistedRoom != null) {
			return persistedRoom;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPersistedRoomException(sb.toString());
	}

	/**
	 * Returns the first persisted room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersistedRoom> orderByComparator) {

		List<PersistedRoom> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersistedRoom> orderByComparator)
		throws NoSuchPersistedRoomException {

		PersistedRoom persistedRoom = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (persistedRoom != null) {
			return persistedRoom;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPersistedRoomException(sb.toString());
	}

	/**
	 * Returns the last persisted room in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersistedRoom> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PersistedRoom> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public PersistedRoom[] findByUuid_C_PrevAndNext(
			long roomId, String uuid, long companyId,
			OrderByComparator<PersistedRoom> orderByComparator)
		throws NoSuchPersistedRoomException {

		uuid = Objects.toString(uuid, "");

		PersistedRoom persistedRoom = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			PersistedRoom[] array = new PersistedRoomImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, persistedRoom, uuid, companyId, orderByComparator,
				true);

			array[1] = persistedRoom;

			array[2] = getByUuid_C_PrevAndNext(
				session, persistedRoom, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedRoom getByUuid_C_PrevAndNext(
		Session session, PersistedRoom persistedRoom, String uuid,
		long companyId, OrderByComparator<PersistedRoom> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PERSISTEDROOM_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PersistedRoomModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						persistedRoom)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PersistedRoom> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted rooms where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PersistedRoom persistedRoom :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(persistedRoom);
		}
	}

	/**
	 * Returns the number of persisted rooms where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted rooms
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERSISTEDROOM_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"persistedRoom.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(persistedRoom.uuid IS NULL OR persistedRoom.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"persistedRoom.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByOfficeId;
	private FinderPath _finderPathWithoutPaginationFindByOfficeId;
	private FinderPath _finderPathCountByOfficeId;

	/**
	 * Returns all the persisted rooms where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the matching persisted rooms
	 */
	@Override
	public List<PersistedRoom> findByOfficeId(long officeId) {
		return findByOfficeId(
			officeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted rooms where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of matching persisted rooms
	 */
	@Override
	public List<PersistedRoom> findByOfficeId(
		long officeId, int start, int end) {

		return findByOfficeId(officeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted rooms
	 */
	@Override
	public List<PersistedRoom> findByOfficeId(
		long officeId, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return findByOfficeId(officeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where officeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param officeId the office ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted rooms
	 */
	@Override
	public List<PersistedRoom> findByOfficeId(
		long officeId, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOfficeId;
				finderArgs = new Object[] {officeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOfficeId;
			finderArgs = new Object[] {officeId, start, end, orderByComparator};
		}

		List<PersistedRoom> list = null;

		if (useFinderCache) {
			list = (List<PersistedRoom>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedRoom persistedRoom : list) {
					if (officeId != persistedRoom.getOfficeId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PERSISTEDROOM_WHERE);

			sb.append(_FINDER_COLUMN_OFFICEID_OFFICEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersistedRoomModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(officeId);

				list = (List<PersistedRoom>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first persisted room in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom findByOfficeId_First(
			long officeId, OrderByComparator<PersistedRoom> orderByComparator)
		throws NoSuchPersistedRoomException {

		PersistedRoom persistedRoom = fetchByOfficeId_First(
			officeId, orderByComparator);

		if (persistedRoom != null) {
			return persistedRoom;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("officeId=");
		sb.append(officeId);

		sb.append("}");

		throw new NoSuchPersistedRoomException(sb.toString());
	}

	/**
	 * Returns the first persisted room in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom fetchByOfficeId_First(
		long officeId, OrderByComparator<PersistedRoom> orderByComparator) {

		List<PersistedRoom> list = findByOfficeId(
			officeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted room in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom findByOfficeId_Last(
			long officeId, OrderByComparator<PersistedRoom> orderByComparator)
		throws NoSuchPersistedRoomException {

		PersistedRoom persistedRoom = fetchByOfficeId_Last(
			officeId, orderByComparator);

		if (persistedRoom != null) {
			return persistedRoom;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("officeId=");
		sb.append(officeId);

		sb.append("}");

		throw new NoSuchPersistedRoomException(sb.toString());
	}

	/**
	 * Returns the last persisted room in the ordered set where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom fetchByOfficeId_Last(
		long officeId, OrderByComparator<PersistedRoom> orderByComparator) {

		int count = countByOfficeId(officeId);

		if (count == 0) {
			return null;
		}

		List<PersistedRoom> list = findByOfficeId(
			officeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the persisted rooms before and after the current persisted room in the ordered set where officeId = &#63;.
	 *
	 * @param roomId the primary key of the current persisted room
	 * @param officeId the office ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted room
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	@Override
	public PersistedRoom[] findByOfficeId_PrevAndNext(
			long roomId, long officeId,
			OrderByComparator<PersistedRoom> orderByComparator)
		throws NoSuchPersistedRoomException {

		PersistedRoom persistedRoom = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			PersistedRoom[] array = new PersistedRoomImpl[3];

			array[0] = getByOfficeId_PrevAndNext(
				session, persistedRoom, officeId, orderByComparator, true);

			array[1] = persistedRoom;

			array[2] = getByOfficeId_PrevAndNext(
				session, persistedRoom, officeId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedRoom getByOfficeId_PrevAndNext(
		Session session, PersistedRoom persistedRoom, long officeId,
		OrderByComparator<PersistedRoom> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PERSISTEDROOM_WHERE);

		sb.append(_FINDER_COLUMN_OFFICEID_OFFICEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PersistedRoomModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(officeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						persistedRoom)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PersistedRoom> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted rooms where officeId = &#63; from the database.
	 *
	 * @param officeId the office ID
	 */
	@Override
	public void removeByOfficeId(long officeId) {
		for (PersistedRoom persistedRoom :
				findByOfficeId(
					officeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(persistedRoom);
		}
	}

	/**
	 * Returns the number of persisted rooms where officeId = &#63;.
	 *
	 * @param officeId the office ID
	 * @return the number of matching persisted rooms
	 */
	@Override
	public int countByOfficeId(long officeId) {
		FinderPath finderPath = _finderPathCountByOfficeId;

		Object[] finderArgs = new Object[] {officeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERSISTEDROOM_WHERE);

			sb.append(_FINDER_COLUMN_OFFICEID_OFFICEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(officeId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_OFFICEID_OFFICEID_2 =
		"persistedRoom.officeId = ?";

	private FinderPath _finderPathWithPaginationFindByCalendarId;
	private FinderPath _finderPathWithoutPaginationFindByCalendarId;
	private FinderPath _finderPathCountByCalendarId;

	/**
	 * Returns all the persisted rooms where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @return the matching persisted rooms
	 */
	@Override
	public List<PersistedRoom> findByCalendarId(long calendarId) {
		return findByCalendarId(
			calendarId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted rooms where calendarId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param calendarId the calendar ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of matching persisted rooms
	 */
	@Override
	public List<PersistedRoom> findByCalendarId(
		long calendarId, int start, int end) {

		return findByCalendarId(calendarId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where calendarId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param calendarId the calendar ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted rooms
	 */
	@Override
	public List<PersistedRoom> findByCalendarId(
		long calendarId, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return findByCalendarId(
			calendarId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted rooms where calendarId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param calendarId the calendar ID
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted rooms
	 */
	@Override
	public List<PersistedRoom> findByCalendarId(
		long calendarId, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCalendarId;
				finderArgs = new Object[] {calendarId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCalendarId;
			finderArgs = new Object[] {
				calendarId, start, end, orderByComparator
			};
		}

		List<PersistedRoom> list = null;

		if (useFinderCache) {
			list = (List<PersistedRoom>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedRoom persistedRoom : list) {
					if (calendarId != persistedRoom.getCalendarId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PERSISTEDROOM_WHERE);

			sb.append(_FINDER_COLUMN_CALENDARID_CALENDARID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(PersistedRoomModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(calendarId);

				list = (List<PersistedRoom>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first persisted room in the ordered set where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom findByCalendarId_First(
			long calendarId, OrderByComparator<PersistedRoom> orderByComparator)
		throws NoSuchPersistedRoomException {

		PersistedRoom persistedRoom = fetchByCalendarId_First(
			calendarId, orderByComparator);

		if (persistedRoom != null) {
			return persistedRoom;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("calendarId=");
		sb.append(calendarId);

		sb.append("}");

		throw new NoSuchPersistedRoomException(sb.toString());
	}

	/**
	 * Returns the first persisted room in the ordered set where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom fetchByCalendarId_First(
		long calendarId, OrderByComparator<PersistedRoom> orderByComparator) {

		List<PersistedRoom> list = findByCalendarId(
			calendarId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted room in the ordered set where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom findByCalendarId_Last(
			long calendarId, OrderByComparator<PersistedRoom> orderByComparator)
		throws NoSuchPersistedRoomException {

		PersistedRoom persistedRoom = fetchByCalendarId_Last(
			calendarId, orderByComparator);

		if (persistedRoom != null) {
			return persistedRoom;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("calendarId=");
		sb.append(calendarId);

		sb.append("}");

		throw new NoSuchPersistedRoomException(sb.toString());
	}

	/**
	 * Returns the last persisted room in the ordered set where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom fetchByCalendarId_Last(
		long calendarId, OrderByComparator<PersistedRoom> orderByComparator) {

		int count = countByCalendarId(calendarId);

		if (count == 0) {
			return null;
		}

		List<PersistedRoom> list = findByCalendarId(
			calendarId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the persisted rooms before and after the current persisted room in the ordered set where calendarId = &#63;.
	 *
	 * @param roomId the primary key of the current persisted room
	 * @param calendarId the calendar ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted room
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	@Override
	public PersistedRoom[] findByCalendarId_PrevAndNext(
			long roomId, long calendarId,
			OrderByComparator<PersistedRoom> orderByComparator)
		throws NoSuchPersistedRoomException {

		PersistedRoom persistedRoom = findByPrimaryKey(roomId);

		Session session = null;

		try {
			session = openSession();

			PersistedRoom[] array = new PersistedRoomImpl[3];

			array[0] = getByCalendarId_PrevAndNext(
				session, persistedRoom, calendarId, orderByComparator, true);

			array[1] = persistedRoom;

			array[2] = getByCalendarId_PrevAndNext(
				session, persistedRoom, calendarId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedRoom getByCalendarId_PrevAndNext(
		Session session, PersistedRoom persistedRoom, long calendarId,
		OrderByComparator<PersistedRoom> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PERSISTEDROOM_WHERE);

		sb.append(_FINDER_COLUMN_CALENDARID_CALENDARID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(PersistedRoomModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(calendarId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						persistedRoom)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PersistedRoom> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted rooms where calendarId = &#63; from the database.
	 *
	 * @param calendarId the calendar ID
	 */
	@Override
	public void removeByCalendarId(long calendarId) {
		for (PersistedRoom persistedRoom :
				findByCalendarId(
					calendarId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(persistedRoom);
		}
	}

	/**
	 * Returns the number of persisted rooms where calendarId = &#63;.
	 *
	 * @param calendarId the calendar ID
	 * @return the number of matching persisted rooms
	 */
	@Override
	public int countByCalendarId(long calendarId) {
		FinderPath finderPath = _finderPathCountByCalendarId;

		Object[] finderArgs = new Object[] {calendarId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERSISTEDROOM_WHERE);

			sb.append(_FINDER_COLUMN_CALENDARID_CALENDARID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(calendarId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CALENDARID_CALENDARID_2 =
		"persistedRoom.calendarId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the persisted room where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedRoomException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted room
	 * @throws NoSuchPersistedRoomException if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedRoomException {

		PersistedRoom persistedRoom = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (persistedRoom == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("companyId=");
			sb.append(companyId);

			sb.append(", externalReferenceCode=");
			sb.append(externalReferenceCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchPersistedRoomException(sb.toString());
		}

		return persistedRoom;
	}

	/**
	 * Returns the persisted room where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the persisted room where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted room, or <code>null</code> if a matching persisted room could not be found
	 */
	@Override
	public PersistedRoom fetchByC_ERC(
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

		if (result instanceof PersistedRoom) {
			PersistedRoom persistedRoom = (PersistedRoom)result;

			if ((companyId != persistedRoom.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					persistedRoom.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PERSISTEDROOM_WHERE);

			sb.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindExternalReferenceCode) {
					queryPos.add(externalReferenceCode);
				}

				List<PersistedRoom> list = query.list();

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
								"PersistedRoomPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PersistedRoom persistedRoom = list.get(0);

					result = persistedRoom;

					cacheResult(persistedRoom);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByC_ERC, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (PersistedRoom)result;
		}
	}

	/**
	 * Removes the persisted room where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted room that was removed
	 */
	@Override
	public PersistedRoom removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedRoomException {

		PersistedRoom persistedRoom = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(persistedRoom);
	}

	/**
	 * Returns the number of persisted rooms where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted rooms
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERSISTEDROOM_WHERE);

			sb.append(_FINDER_COLUMN_C_ERC_COMPANYID_2);

			boolean bindExternalReferenceCode = false;

			if (externalReferenceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3);
			}
			else {
				bindExternalReferenceCode = true;

				sb.append(_FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(companyId);

				if (bindExternalReferenceCode) {
					queryPos.add(externalReferenceCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_ERC_COMPANYID_2 =
		"persistedRoom.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"persistedRoom.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(persistedRoom.externalReferenceCode IS NULL OR persistedRoom.externalReferenceCode = '')";

	public PersistedRoomPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PersistedRoom.class);

		setModelImplClass(PersistedRoomImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the persisted room in the entity cache if it is enabled.
	 *
	 * @param persistedRoom the persisted room
	 */
	@Override
	public void cacheResult(PersistedRoom persistedRoom) {
		entityCache.putResult(
			entityCacheEnabled, PersistedRoomImpl.class,
			persistedRoom.getPrimaryKey(), persistedRoom);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				persistedRoom.getCompanyId(),
				persistedRoom.getExternalReferenceCode()
			},
			persistedRoom);

		persistedRoom.resetOriginalValues();
	}

	/**
	 * Caches the persisted rooms in the entity cache if it is enabled.
	 *
	 * @param persistedRooms the persisted rooms
	 */
	@Override
	public void cacheResult(List<PersistedRoom> persistedRooms) {
		for (PersistedRoom persistedRoom : persistedRooms) {
			if (entityCache.getResult(
					entityCacheEnabled, PersistedRoomImpl.class,
					persistedRoom.getPrimaryKey()) == null) {

				cacheResult(persistedRoom);
			}
			else {
				persistedRoom.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all persisted rooms.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PersistedRoomImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the persisted room.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PersistedRoom persistedRoom) {
		entityCache.removeResult(
			entityCacheEnabled, PersistedRoomImpl.class,
			persistedRoom.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((PersistedRoomModelImpl)persistedRoom, true);
	}

	@Override
	public void clearCache(List<PersistedRoom> persistedRooms) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PersistedRoom persistedRoom : persistedRooms) {
			entityCache.removeResult(
				entityCacheEnabled, PersistedRoomImpl.class,
				persistedRoom.getPrimaryKey());

			clearUniqueFindersCache(
				(PersistedRoomModelImpl)persistedRoom, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, PersistedRoomImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PersistedRoomModelImpl persistedRoomModelImpl) {

		Object[] args = new Object[] {
			persistedRoomModelImpl.getCompanyId(),
			persistedRoomModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(
			_finderPathCountByC_ERC, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, persistedRoomModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		PersistedRoomModelImpl persistedRoomModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				persistedRoomModelImpl.getCompanyId(),
				persistedRoomModelImpl.getExternalReferenceCode()
			};

			finderCache.removeResult(_finderPathCountByC_ERC, args);
			finderCache.removeResult(_finderPathFetchByC_ERC, args);
		}

		if ((persistedRoomModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_ERC.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				persistedRoomModelImpl.getOriginalCompanyId(),
				persistedRoomModelImpl.getOriginalExternalReferenceCode()
			};

			finderCache.removeResult(_finderPathCountByC_ERC, args);
			finderCache.removeResult(_finderPathFetchByC_ERC, args);
		}
	}

	/**
	 * Creates a new persisted room with the primary key. Does not add the persisted room to the database.
	 *
	 * @param roomId the primary key for the new persisted room
	 * @return the new persisted room
	 */
	@Override
	public PersistedRoom create(long roomId) {
		PersistedRoom persistedRoom = new PersistedRoomImpl();

		persistedRoom.setNew(true);
		persistedRoom.setPrimaryKey(roomId);

		String uuid = PortalUUIDUtil.generate();

		persistedRoom.setUuid(uuid);

		persistedRoom.setCompanyId(CompanyThreadLocal.getCompanyId());

		return persistedRoom;
	}

	/**
	 * Removes the persisted room with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param roomId the primary key of the persisted room
	 * @return the persisted room that was removed
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	@Override
	public PersistedRoom remove(long roomId)
		throws NoSuchPersistedRoomException {

		return remove((Serializable)roomId);
	}

	/**
	 * Removes the persisted room with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the persisted room
	 * @return the persisted room that was removed
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	@Override
	public PersistedRoom remove(Serializable primaryKey)
		throws NoSuchPersistedRoomException {

		Session session = null;

		try {
			session = openSession();

			PersistedRoom persistedRoom = (PersistedRoom)session.get(
				PersistedRoomImpl.class, primaryKey);

			if (persistedRoom == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersistedRoomException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(persistedRoom);
		}
		catch (NoSuchPersistedRoomException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected PersistedRoom removeImpl(PersistedRoom persistedRoom) {
		persistedRoomToPersistedPurposeTableMapper.
			deleteLeftPrimaryKeyTableMappings(persistedRoom.getPrimaryKey());

		persistedRoomToPersistedAmenityTableMapper.
			deleteLeftPrimaryKeyTableMappings(persistedRoom.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(persistedRoom)) {
				persistedRoom = (PersistedRoom)session.get(
					PersistedRoomImpl.class, persistedRoom.getPrimaryKeyObj());
			}

			if (persistedRoom != null) {
				session.delete(persistedRoom);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (persistedRoom != null) {
			clearCache(persistedRoom);
		}

		return persistedRoom;
	}

	@Override
	public PersistedRoom updateImpl(PersistedRoom persistedRoom) {
		boolean isNew = persistedRoom.isNew();

		if (!(persistedRoom instanceof PersistedRoomModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(persistedRoom.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					persistedRoom);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in persistedRoom proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PersistedRoom implementation " +
					persistedRoom.getClass());
		}

		PersistedRoomModelImpl persistedRoomModelImpl =
			(PersistedRoomModelImpl)persistedRoom;

		if (Validator.isNull(persistedRoom.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			persistedRoom.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (persistedRoom.getCreateDate() == null)) {
			if (serviceContext == null) {
				persistedRoom.setCreateDate(now);
			}
			else {
				persistedRoom.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!persistedRoomModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				persistedRoom.setModifiedDate(now);
			}
			else {
				persistedRoom.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (persistedRoom.isNew()) {
				session.save(persistedRoom);

				persistedRoom.setNew(false);
			}
			else {
				persistedRoom = (PersistedRoom)session.merge(persistedRoom);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {persistedRoomModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				persistedRoomModelImpl.getUuid(),
				persistedRoomModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {persistedRoomModelImpl.getOfficeId()};

			finderCache.removeResult(_finderPathCountByOfficeId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByOfficeId, args);

			args = new Object[] {persistedRoomModelImpl.getCalendarId()};

			finderCache.removeResult(_finderPathCountByCalendarId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCalendarId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((persistedRoomModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					persistedRoomModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {persistedRoomModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((persistedRoomModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					persistedRoomModelImpl.getOriginalUuid(),
					persistedRoomModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					persistedRoomModelImpl.getUuid(),
					persistedRoomModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((persistedRoomModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByOfficeId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					persistedRoomModelImpl.getOriginalOfficeId()
				};

				finderCache.removeResult(_finderPathCountByOfficeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOfficeId, args);

				args = new Object[] {persistedRoomModelImpl.getOfficeId()};

				finderCache.removeResult(_finderPathCountByOfficeId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOfficeId, args);
			}

			if ((persistedRoomModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCalendarId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					persistedRoomModelImpl.getOriginalCalendarId()
				};

				finderCache.removeResult(_finderPathCountByCalendarId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCalendarId, args);

				args = new Object[] {persistedRoomModelImpl.getCalendarId()};

				finderCache.removeResult(_finderPathCountByCalendarId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCalendarId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, PersistedRoomImpl.class,
			persistedRoom.getPrimaryKey(), persistedRoom, false);

		clearUniqueFindersCache(persistedRoomModelImpl, false);
		cacheUniqueFindersCache(persistedRoomModelImpl);

		persistedRoom.resetOriginalValues();

		return persistedRoom;
	}

	/**
	 * Returns the persisted room with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the persisted room
	 * @return the persisted room
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	@Override
	public PersistedRoom findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersistedRoomException {

		PersistedRoom persistedRoom = fetchByPrimaryKey(primaryKey);

		if (persistedRoom == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersistedRoomException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return persistedRoom;
	}

	/**
	 * Returns the persisted room with the primary key or throws a <code>NoSuchPersistedRoomException</code> if it could not be found.
	 *
	 * @param roomId the primary key of the persisted room
	 * @return the persisted room
	 * @throws NoSuchPersistedRoomException if a persisted room with the primary key could not be found
	 */
	@Override
	public PersistedRoom findByPrimaryKey(long roomId)
		throws NoSuchPersistedRoomException {

		return findByPrimaryKey((Serializable)roomId);
	}

	/**
	 * Returns the persisted room with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param roomId the primary key of the persisted room
	 * @return the persisted room, or <code>null</code> if a persisted room with the primary key could not be found
	 */
	@Override
	public PersistedRoom fetchByPrimaryKey(long roomId) {
		return fetchByPrimaryKey((Serializable)roomId);
	}

	/**
	 * Returns all the persisted rooms.
	 *
	 * @return the persisted rooms
	 */
	@Override
	public List<PersistedRoom> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @return the range of persisted rooms
	 */
	@Override
	public List<PersistedRoom> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted rooms
	 */
	@Override
	public List<PersistedRoom> findAll(
		int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted rooms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted rooms
	 * @param end the upper bound of the range of persisted rooms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted rooms
	 */
	@Override
	public List<PersistedRoom> findAll(
		int start, int end, OrderByComparator<PersistedRoom> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<PersistedRoom> list = null;

		if (useFinderCache) {
			list = (List<PersistedRoom>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PERSISTEDROOM);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PERSISTEDROOM;

				sql = sql.concat(PersistedRoomModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PersistedRoom>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the persisted rooms from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PersistedRoom persistedRoom : findAll()) {
			remove(persistedRoom);
		}
	}

	/**
	 * Returns the number of persisted rooms.
	 *
	 * @return the number of persisted rooms
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PERSISTEDROOM);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the primaryKeys of persisted purposes associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return long[] of the primaryKeys of persisted purposes associated with the persisted room
	 */
	@Override
	public long[] getPersistedPurposePrimaryKeys(long pk) {
		long[] pks =
			persistedRoomToPersistedPurposeTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the persisted room associated with the persisted purpose.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @return the persisted rooms associated with the persisted purpose
	 */
	@Override
	public List<PersistedRoom> getPersistedPurposePersistedRooms(long pk) {
		return getPersistedPurposePersistedRooms(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the persisted room associated with the persisted purpose.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @return the range of persisted rooms associated with the persisted purpose
	 */
	@Override
	public List<PersistedRoom> getPersistedPurposePersistedRooms(
		long pk, int start, int end) {

		return getPersistedPurposePersistedRooms(pk, start, end, null);
	}

	/**
	 * Returns all the persisted room associated with the persisted purpose.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param start the lower bound of the range of persisted purposes
	 * @param end the upper bound of the range of persisted purposes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted rooms associated with the persisted purpose
	 */
	@Override
	public List<PersistedRoom> getPersistedPurposePersistedRooms(
		long pk, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return persistedRoomToPersistedPurposeTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persisted purposes associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return the number of persisted purposes associated with the persisted room
	 */
	@Override
	public int getPersistedPurposesSize(long pk) {
		long[] pks =
			persistedRoomToPersistedPurposeTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the persisted purpose is associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePK the primary key of the persisted purpose
	 * @return <code>true</code> if the persisted purpose is associated with the persisted room; <code>false</code> otherwise
	 */
	@Override
	public boolean containsPersistedPurpose(long pk, long persistedPurposePK) {
		return persistedRoomToPersistedPurposeTableMapper.containsTableMapping(
			pk, persistedPurposePK);
	}

	/**
	 * Returns <code>true</code> if the persisted room has any persisted purposes associated with it.
	 *
	 * @param pk the primary key of the persisted room to check for associations with persisted purposes
	 * @return <code>true</code> if the persisted room has any persisted purposes associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsPersistedPurposes(long pk) {
		if (getPersistedPurposesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the persisted room and the persisted purpose. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePK the primary key of the persisted purpose
	 */
	@Override
	public void addPersistedPurpose(long pk, long persistedPurposePK) {
		PersistedRoom persistedRoom = fetchByPrimaryKey(pk);

		if (persistedRoom == null) {
			persistedRoomToPersistedPurposeTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, persistedPurposePK);
		}
		else {
			persistedRoomToPersistedPurposeTableMapper.addTableMapping(
				persistedRoom.getCompanyId(), pk, persistedPurposePK);
		}
	}

	/**
	 * Adds an association between the persisted room and the persisted purpose. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurpose the persisted purpose
	 */
	@Override
	public void addPersistedPurpose(
		long pk, PersistedPurpose persistedPurpose) {

		PersistedRoom persistedRoom = fetchByPrimaryKey(pk);

		if (persistedRoom == null) {
			persistedRoomToPersistedPurposeTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				persistedPurpose.getPrimaryKey());
		}
		else {
			persistedRoomToPersistedPurposeTableMapper.addTableMapping(
				persistedRoom.getCompanyId(), pk,
				persistedPurpose.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the persisted room and the persisted purposes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePKs the primary keys of the persisted purposes
	 */
	@Override
	public void addPersistedPurposes(long pk, long[] persistedPurposePKs) {
		long companyId = 0;

		PersistedRoom persistedRoom = fetchByPrimaryKey(pk);

		if (persistedRoom == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = persistedRoom.getCompanyId();
		}

		persistedRoomToPersistedPurposeTableMapper.addTableMappings(
			companyId, pk, persistedPurposePKs);
	}

	/**
	 * Adds an association between the persisted room and the persisted purposes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposes the persisted purposes
	 */
	@Override
	public void addPersistedPurposes(
		long pk, List<PersistedPurpose> persistedPurposes) {

		addPersistedPurposes(
			pk,
			ListUtil.toLongArray(
				persistedPurposes, PersistedPurpose.PURPOSE_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the persisted room and its persisted purposes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room to clear the associated persisted purposes from
	 */
	@Override
	public void clearPersistedPurposes(long pk) {
		persistedRoomToPersistedPurposeTableMapper.
			deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the persisted room and the persisted purpose. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePK the primary key of the persisted purpose
	 */
	@Override
	public void removePersistedPurpose(long pk, long persistedPurposePK) {
		persistedRoomToPersistedPurposeTableMapper.deleteTableMapping(
			pk, persistedPurposePK);
	}

	/**
	 * Removes the association between the persisted room and the persisted purpose. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurpose the persisted purpose
	 */
	@Override
	public void removePersistedPurpose(
		long pk, PersistedPurpose persistedPurpose) {

		persistedRoomToPersistedPurposeTableMapper.deleteTableMapping(
			pk, persistedPurpose.getPrimaryKey());
	}

	/**
	 * Removes the association between the persisted room and the persisted purposes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePKs the primary keys of the persisted purposes
	 */
	@Override
	public void removePersistedPurposes(long pk, long[] persistedPurposePKs) {
		persistedRoomToPersistedPurposeTableMapper.deleteTableMappings(
			pk, persistedPurposePKs);
	}

	/**
	 * Removes the association between the persisted room and the persisted purposes. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposes the persisted purposes
	 */
	@Override
	public void removePersistedPurposes(
		long pk, List<PersistedPurpose> persistedPurposes) {

		removePersistedPurposes(
			pk,
			ListUtil.toLongArray(
				persistedPurposes, PersistedPurpose.PURPOSE_ID_ACCESSOR));
	}

	/**
	 * Sets the persisted purposes associated with the persisted room, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposePKs the primary keys of the persisted purposes to be associated with the persisted room
	 */
	@Override
	public void setPersistedPurposes(long pk, long[] persistedPurposePKs) {
		Set<Long> newPersistedPurposePKsSet = SetUtil.fromArray(
			persistedPurposePKs);
		Set<Long> oldPersistedPurposePKsSet = SetUtil.fromArray(
			persistedRoomToPersistedPurposeTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removePersistedPurposePKsSet = new HashSet<Long>(
			oldPersistedPurposePKsSet);

		removePersistedPurposePKsSet.removeAll(newPersistedPurposePKsSet);

		persistedRoomToPersistedPurposeTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removePersistedPurposePKsSet));

		newPersistedPurposePKsSet.removeAll(oldPersistedPurposePKsSet);

		long companyId = 0;

		PersistedRoom persistedRoom = fetchByPrimaryKey(pk);

		if (persistedRoom == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = persistedRoom.getCompanyId();
		}

		persistedRoomToPersistedPurposeTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newPersistedPurposePKsSet));
	}

	/**
	 * Sets the persisted purposes associated with the persisted room, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedPurposes the persisted purposes to be associated with the persisted room
	 */
	@Override
	public void setPersistedPurposes(
		long pk, List<PersistedPurpose> persistedPurposes) {

		try {
			long[] persistedPurposePKs = new long[persistedPurposes.size()];

			for (int i = 0; i < persistedPurposes.size(); i++) {
				PersistedPurpose persistedPurpose = persistedPurposes.get(i);

				persistedPurposePKs[i] = persistedPurpose.getPrimaryKey();
			}

			setPersistedPurposes(pk, persistedPurposePKs);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
	}

	/**
	 * Returns the primaryKeys of persisted amenities associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return long[] of the primaryKeys of persisted amenities associated with the persisted room
	 */
	@Override
	public long[] getPersistedAmenityPrimaryKeys(long pk) {
		long[] pks =
			persistedRoomToPersistedAmenityTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the persisted room associated with the persisted amenity.
	 *
	 * @param pk the primary key of the persisted amenity
	 * @return the persisted rooms associated with the persisted amenity
	 */
	@Override
	public List<PersistedRoom> getPersistedAmenityPersistedRooms(long pk) {
		return getPersistedAmenityPersistedRooms(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the persisted room associated with the persisted amenity.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @return the range of persisted rooms associated with the persisted amenity
	 */
	@Override
	public List<PersistedRoom> getPersistedAmenityPersistedRooms(
		long pk, int start, int end) {

		return getPersistedAmenityPersistedRooms(pk, start, end, null);
	}

	/**
	 * Returns all the persisted room associated with the persisted amenity.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedRoomModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted amenity
	 * @param start the lower bound of the range of persisted amenities
	 * @param end the upper bound of the range of persisted amenities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted rooms associated with the persisted amenity
	 */
	@Override
	public List<PersistedRoom> getPersistedAmenityPersistedRooms(
		long pk, int start, int end,
		OrderByComparator<PersistedRoom> orderByComparator) {

		return persistedRoomToPersistedAmenityTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persisted amenities associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return the number of persisted amenities associated with the persisted room
	 */
	@Override
	public int getPersistedAmenitiesSize(long pk) {
		long[] pks =
			persistedRoomToPersistedAmenityTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the persisted amenity is associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPK the primary key of the persisted amenity
	 * @return <code>true</code> if the persisted amenity is associated with the persisted room; <code>false</code> otherwise
	 */
	@Override
	public boolean containsPersistedAmenity(long pk, long persistedAmenityPK) {
		return persistedRoomToPersistedAmenityTableMapper.containsTableMapping(
			pk, persistedAmenityPK);
	}

	/**
	 * Returns <code>true</code> if the persisted room has any persisted amenities associated with it.
	 *
	 * @param pk the primary key of the persisted room to check for associations with persisted amenities
	 * @return <code>true</code> if the persisted room has any persisted amenities associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsPersistedAmenities(long pk) {
		if (getPersistedAmenitiesSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the persisted room and the persisted amenity. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPK the primary key of the persisted amenity
	 */
	@Override
	public void addPersistedAmenity(long pk, long persistedAmenityPK) {
		PersistedRoom persistedRoom = fetchByPrimaryKey(pk);

		if (persistedRoom == null) {
			persistedRoomToPersistedAmenityTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, persistedAmenityPK);
		}
		else {
			persistedRoomToPersistedAmenityTableMapper.addTableMapping(
				persistedRoom.getCompanyId(), pk, persistedAmenityPK);
		}
	}

	/**
	 * Adds an association between the persisted room and the persisted amenity. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenity the persisted amenity
	 */
	@Override
	public void addPersistedAmenity(
		long pk, PersistedAmenity persistedAmenity) {

		PersistedRoom persistedRoom = fetchByPrimaryKey(pk);

		if (persistedRoom == null) {
			persistedRoomToPersistedAmenityTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				persistedAmenity.getPrimaryKey());
		}
		else {
			persistedRoomToPersistedAmenityTableMapper.addTableMapping(
				persistedRoom.getCompanyId(), pk,
				persistedAmenity.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the persisted room and the persisted amenities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPKs the primary keys of the persisted amenities
	 */
	@Override
	public void addPersistedAmenities(long pk, long[] persistedAmenityPKs) {
		long companyId = 0;

		PersistedRoom persistedRoom = fetchByPrimaryKey(pk);

		if (persistedRoom == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = persistedRoom.getCompanyId();
		}

		persistedRoomToPersistedAmenityTableMapper.addTableMappings(
			companyId, pk, persistedAmenityPKs);
	}

	/**
	 * Adds an association between the persisted room and the persisted amenities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenities the persisted amenities
	 */
	@Override
	public void addPersistedAmenities(
		long pk, List<PersistedAmenity> persistedAmenities) {

		addPersistedAmenities(
			pk,
			ListUtil.toLongArray(
				persistedAmenities, PersistedAmenity.AMENITY_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the persisted room and its persisted amenities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room to clear the associated persisted amenities from
	 */
	@Override
	public void clearPersistedAmenities(long pk) {
		persistedRoomToPersistedAmenityTableMapper.
			deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the persisted room and the persisted amenity. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPK the primary key of the persisted amenity
	 */
	@Override
	public void removePersistedAmenity(long pk, long persistedAmenityPK) {
		persistedRoomToPersistedAmenityTableMapper.deleteTableMapping(
			pk, persistedAmenityPK);
	}

	/**
	 * Removes the association between the persisted room and the persisted amenity. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenity the persisted amenity
	 */
	@Override
	public void removePersistedAmenity(
		long pk, PersistedAmenity persistedAmenity) {

		persistedRoomToPersistedAmenityTableMapper.deleteTableMapping(
			pk, persistedAmenity.getPrimaryKey());
	}

	/**
	 * Removes the association between the persisted room and the persisted amenities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPKs the primary keys of the persisted amenities
	 */
	@Override
	public void removePersistedAmenities(long pk, long[] persistedAmenityPKs) {
		persistedRoomToPersistedAmenityTableMapper.deleteTableMappings(
			pk, persistedAmenityPKs);
	}

	/**
	 * Removes the association between the persisted room and the persisted amenities. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenities the persisted amenities
	 */
	@Override
	public void removePersistedAmenities(
		long pk, List<PersistedAmenity> persistedAmenities) {

		removePersistedAmenities(
			pk,
			ListUtil.toLongArray(
				persistedAmenities, PersistedAmenity.AMENITY_ID_ACCESSOR));
	}

	/**
	 * Sets the persisted amenities associated with the persisted room, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenityPKs the primary keys of the persisted amenities to be associated with the persisted room
	 */
	@Override
	public void setPersistedAmenities(long pk, long[] persistedAmenityPKs) {
		Set<Long> newPersistedAmenityPKsSet = SetUtil.fromArray(
			persistedAmenityPKs);
		Set<Long> oldPersistedAmenityPKsSet = SetUtil.fromArray(
			persistedRoomToPersistedAmenityTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removePersistedAmenityPKsSet = new HashSet<Long>(
			oldPersistedAmenityPKsSet);

		removePersistedAmenityPKsSet.removeAll(newPersistedAmenityPKsSet);

		persistedRoomToPersistedAmenityTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removePersistedAmenityPKsSet));

		newPersistedAmenityPKsSet.removeAll(oldPersistedAmenityPKsSet);

		long companyId = 0;

		PersistedRoom persistedRoom = fetchByPrimaryKey(pk);

		if (persistedRoom == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = persistedRoom.getCompanyId();
		}

		persistedRoomToPersistedAmenityTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newPersistedAmenityPKsSet));
	}

	/**
	 * Sets the persisted amenities associated with the persisted room, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted room
	 * @param persistedAmenities the persisted amenities to be associated with the persisted room
	 */
	@Override
	public void setPersistedAmenities(
		long pk, List<PersistedAmenity> persistedAmenities) {

		try {
			long[] persistedAmenityPKs = new long[persistedAmenities.size()];

			for (int i = 0; i < persistedAmenities.size(); i++) {
				PersistedAmenity persistedAmenity = persistedAmenities.get(i);

				persistedAmenityPKs[i] = persistedAmenity.getPrimaryKey();
			}

			setPersistedAmenities(pk, persistedAmenityPKs);
		}
		catch (Exception exception) {
			throw processException(exception);
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
		return "roomId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PERSISTEDROOM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PersistedRoomModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the persisted room persistence.
	 */
	@Activate
	public void activate() {
		PersistedRoomModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		PersistedRoomModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		persistedRoomToPersistedPurposeTableMapper =
			TableMapperFactory.getTableMapper(
				"Reservation_Rooms_Purposes#roomId",
				"Reservation_Rooms_Purposes", "companyId", "roomId",
				"purposeId", this, PersistedPurpose.class);

		persistedRoomToPersistedAmenityTableMapper =
			TableMapperFactory.getTableMapper(
				"Reservation_Rooms_Amenities#roomId",
				"Reservation_Rooms_Amenities", "companyId", "roomId",
				"amenityId", this, PersistedAmenity.class);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedRoomImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedRoomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedRoomImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedRoomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			PersistedRoomModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedRoomImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedRoomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			PersistedRoomModelImpl.UUID_COLUMN_BITMASK |
			PersistedRoomModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByOfficeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedRoomImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOfficeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByOfficeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedRoomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOfficeId",
			new String[] {Long.class.getName()},
			PersistedRoomModelImpl.OFFICEID_COLUMN_BITMASK);

		_finderPathCountByOfficeId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOfficeId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCalendarId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedRoomImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCalendarId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCalendarId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedRoomImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCalendarId",
			new String[] {Long.class.getName()},
			PersistedRoomModelImpl.CALENDARID_COLUMN_BITMASK);

		_finderPathCountByCalendarId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCalendarId",
			new String[] {Long.class.getName()});

		_finderPathFetchByC_ERC = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedRoomImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			PersistedRoomModelImpl.COMPANYID_COLUMN_BITMASK |
			PersistedRoomModelImpl.EXTERNALREFERENCECODE_COLUMN_BITMASK);

		_finderPathCountByC_ERC = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(PersistedRoomImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper(
			"Reservation_Rooms_Purposes#roomId");
		TableMapperFactory.removeTableMapper(
			"Reservation_Rooms_Amenities#roomId");
	}

	@Override
	@Reference(
		target = ReservationPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.jp.co.liferay.reservation.model.PersistedRoom"),
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

	protected TableMapper<PersistedRoom, PersistedPurpose>
		persistedRoomToPersistedPurposeTableMapper;
	protected TableMapper<PersistedRoom, PersistedAmenity>
		persistedRoomToPersistedAmenityTableMapper;

	private static final String _SQL_SELECT_PERSISTEDROOM =
		"SELECT persistedRoom FROM PersistedRoom persistedRoom";

	private static final String _SQL_SELECT_PERSISTEDROOM_WHERE =
		"SELECT persistedRoom FROM PersistedRoom persistedRoom WHERE ";

	private static final String _SQL_COUNT_PERSISTEDROOM =
		"SELECT COUNT(persistedRoom) FROM PersistedRoom persistedRoom";

	private static final String _SQL_COUNT_PERSISTEDROOM_WHERE =
		"SELECT COUNT(persistedRoom) FROM PersistedRoom persistedRoom WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "persistedRoom.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PersistedRoom exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PersistedRoom exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PersistedRoomPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(ReservationPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}