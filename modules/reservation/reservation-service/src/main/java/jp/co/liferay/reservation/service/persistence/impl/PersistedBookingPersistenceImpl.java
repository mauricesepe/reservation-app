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

import jp.co.liferay.reservation.exception.NoSuchPersistedBookingException;
import jp.co.liferay.reservation.model.PersistedBooking;
import jp.co.liferay.reservation.model.PersistedParticipant;
import jp.co.liferay.reservation.model.impl.PersistedBookingImpl;
import jp.co.liferay.reservation.model.impl.PersistedBookingModelImpl;
import jp.co.liferay.reservation.service.persistence.PersistedBookingPersistence;
import jp.co.liferay.reservation.service.persistence.impl.constants.ReservationPersistenceConstants;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the persisted booking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PersistedBookingPersistence.class)
@ProviderType
public class PersistedBookingPersistenceImpl
	extends BasePersistenceImpl<PersistedBooking>
	implements PersistedBookingPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PersistedBookingUtil</code> to access the persisted booking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PersistedBookingImpl.class.getName();

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
	 * Returns all the persisted bookings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted bookings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @return the range of matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator,
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

		List<PersistedBooking> list = null;

		if (useFinderCache) {
			list = (List<PersistedBooking>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedBooking persistedBooking : list) {
					if (!uuid.equals(persistedBooking.getUuid())) {
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

			query.append(_SQL_SELECT_PERSISTEDBOOKING_WHERE);

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
				query.append(PersistedBookingModelImpl.ORDER_BY_JPQL);
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
					list = (List<PersistedBooking>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersistedBooking>)QueryUtil.list(
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
	 * Returns the first persisted booking in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking findByUuid_First(
			String uuid, OrderByComparator<PersistedBooking> orderByComparator)
		throws NoSuchPersistedBookingException {

		PersistedBooking persistedBooking = fetchByUuid_First(
			uuid, orderByComparator);

		if (persistedBooking != null) {
			return persistedBooking;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPersistedBookingException(msg.toString());
	}

	/**
	 * Returns the first persisted booking in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking fetchByUuid_First(
		String uuid, OrderByComparator<PersistedBooking> orderByComparator) {

		List<PersistedBooking> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted booking in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking findByUuid_Last(
			String uuid, OrderByComparator<PersistedBooking> orderByComparator)
		throws NoSuchPersistedBookingException {

		PersistedBooking persistedBooking = fetchByUuid_Last(
			uuid, orderByComparator);

		if (persistedBooking != null) {
			return persistedBooking;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchPersistedBookingException(msg.toString());
	}

	/**
	 * Returns the last persisted booking in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking fetchByUuid_Last(
		String uuid, OrderByComparator<PersistedBooking> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PersistedBooking> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the persisted bookings before and after the current persisted booking in the ordered set where uuid = &#63;.
	 *
	 * @param bookingId the primary key of the current persisted booking
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted booking
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	@Override
	public PersistedBooking[] findByUuid_PrevAndNext(
			long bookingId, String uuid,
			OrderByComparator<PersistedBooking> orderByComparator)
		throws NoSuchPersistedBookingException {

		uuid = Objects.toString(uuid, "");

		PersistedBooking persistedBooking = findByPrimaryKey(bookingId);

		Session session = null;

		try {
			session = openSession();

			PersistedBooking[] array = new PersistedBookingImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, persistedBooking, uuid, orderByComparator, true);

			array[1] = persistedBooking;

			array[2] = getByUuid_PrevAndNext(
				session, persistedBooking, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedBooking getByUuid_PrevAndNext(
		Session session, PersistedBooking persistedBooking, String uuid,
		OrderByComparator<PersistedBooking> orderByComparator,
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

		query.append(_SQL_SELECT_PERSISTEDBOOKING_WHERE);

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
			query.append(PersistedBookingModelImpl.ORDER_BY_JPQL);
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
						persistedBooking)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<PersistedBooking> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted bookings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PersistedBooking persistedBooking :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(persistedBooking);
		}
	}

	/**
	 * Returns the number of persisted bookings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted bookings
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PERSISTEDBOOKING_WHERE);

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
		"persistedBooking.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(persistedBooking.uuid IS NULL OR persistedBooking.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the persisted bookings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted bookings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @return the range of matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator,
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

		List<PersistedBooking> list = null;

		if (useFinderCache) {
			list = (List<PersistedBooking>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedBooking persistedBooking : list) {
					if (!uuid.equals(persistedBooking.getUuid()) ||
						(companyId != persistedBooking.getCompanyId())) {

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

			query.append(_SQL_SELECT_PERSISTEDBOOKING_WHERE);

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
				query.append(PersistedBookingModelImpl.ORDER_BY_JPQL);
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
					list = (List<PersistedBooking>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersistedBooking>)QueryUtil.list(
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
	 * Returns the first persisted booking in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersistedBooking> orderByComparator)
		throws NoSuchPersistedBookingException {

		PersistedBooking persistedBooking = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (persistedBooking != null) {
			return persistedBooking;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPersistedBookingException(msg.toString());
	}

	/**
	 * Returns the first persisted booking in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersistedBooking> orderByComparator) {

		List<PersistedBooking> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted booking in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersistedBooking> orderByComparator)
		throws NoSuchPersistedBookingException {

		PersistedBooking persistedBooking = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (persistedBooking != null) {
			return persistedBooking;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchPersistedBookingException(msg.toString());
	}

	/**
	 * Returns the last persisted booking in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersistedBooking> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PersistedBooking> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the persisted bookings before and after the current persisted booking in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param bookingId the primary key of the current persisted booking
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted booking
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	@Override
	public PersistedBooking[] findByUuid_C_PrevAndNext(
			long bookingId, String uuid, long companyId,
			OrderByComparator<PersistedBooking> orderByComparator)
		throws NoSuchPersistedBookingException {

		uuid = Objects.toString(uuid, "");

		PersistedBooking persistedBooking = findByPrimaryKey(bookingId);

		Session session = null;

		try {
			session = openSession();

			PersistedBooking[] array = new PersistedBookingImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, persistedBooking, uuid, companyId, orderByComparator,
				true);

			array[1] = persistedBooking;

			array[2] = getByUuid_C_PrevAndNext(
				session, persistedBooking, uuid, companyId, orderByComparator,
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

	protected PersistedBooking getByUuid_C_PrevAndNext(
		Session session, PersistedBooking persistedBooking, String uuid,
		long companyId, OrderByComparator<PersistedBooking> orderByComparator,
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

		query.append(_SQL_SELECT_PERSISTEDBOOKING_WHERE);

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
			query.append(PersistedBookingModelImpl.ORDER_BY_JPQL);
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
						persistedBooking)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<PersistedBooking> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted bookings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PersistedBooking persistedBooking :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(persistedBooking);
		}
	}

	/**
	 * Returns the number of persisted bookings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted bookings
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PERSISTEDBOOKING_WHERE);

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
		"persistedBooking.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(persistedBooking.uuid IS NULL OR persistedBooking.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"persistedBooking.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByRoomId;
	private FinderPath _finderPathWithoutPaginationFindByRoomId;
	private FinderPath _finderPathCountByRoomId;

	/**
	 * Returns all the persisted bookings where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @return the matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByRoomId(long roomId) {
		return findByRoomId(roomId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted bookings where roomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roomId the room ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @return the range of matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByRoomId(
		long roomId, int start, int end) {

		return findByRoomId(roomId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where roomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roomId the room ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByRoomId(
		long roomId, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator) {

		return findByRoomId(roomId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where roomId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param roomId the room ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByRoomId(
		long roomId, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRoomId;
				finderArgs = new Object[] {roomId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRoomId;
			finderArgs = new Object[] {roomId, start, end, orderByComparator};
		}

		List<PersistedBooking> list = null;

		if (useFinderCache) {
			list = (List<PersistedBooking>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedBooking persistedBooking : list) {
					if ((roomId != persistedBooking.getRoomId())) {
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

			query.append(_SQL_SELECT_PERSISTEDBOOKING_WHERE);

			query.append(_FINDER_COLUMN_ROOMID_ROOMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(PersistedBookingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roomId);

				if (!pagination) {
					list = (List<PersistedBooking>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersistedBooking>)QueryUtil.list(
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
	 * Returns the first persisted booking in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking findByRoomId_First(
			long roomId, OrderByComparator<PersistedBooking> orderByComparator)
		throws NoSuchPersistedBookingException {

		PersistedBooking persistedBooking = fetchByRoomId_First(
			roomId, orderByComparator);

		if (persistedBooking != null) {
			return persistedBooking;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roomId=");
		msg.append(roomId);

		msg.append("}");

		throw new NoSuchPersistedBookingException(msg.toString());
	}

	/**
	 * Returns the first persisted booking in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking fetchByRoomId_First(
		long roomId, OrderByComparator<PersistedBooking> orderByComparator) {

		List<PersistedBooking> list = findByRoomId(
			roomId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted booking in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking findByRoomId_Last(
			long roomId, OrderByComparator<PersistedBooking> orderByComparator)
		throws NoSuchPersistedBookingException {

		PersistedBooking persistedBooking = fetchByRoomId_Last(
			roomId, orderByComparator);

		if (persistedBooking != null) {
			return persistedBooking;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("roomId=");
		msg.append(roomId);

		msg.append("}");

		throw new NoSuchPersistedBookingException(msg.toString());
	}

	/**
	 * Returns the last persisted booking in the ordered set where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking fetchByRoomId_Last(
		long roomId, OrderByComparator<PersistedBooking> orderByComparator) {

		int count = countByRoomId(roomId);

		if (count == 0) {
			return null;
		}

		List<PersistedBooking> list = findByRoomId(
			roomId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the persisted bookings before and after the current persisted booking in the ordered set where roomId = &#63;.
	 *
	 * @param bookingId the primary key of the current persisted booking
	 * @param roomId the room ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted booking
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	@Override
	public PersistedBooking[] findByRoomId_PrevAndNext(
			long bookingId, long roomId,
			OrderByComparator<PersistedBooking> orderByComparator)
		throws NoSuchPersistedBookingException {

		PersistedBooking persistedBooking = findByPrimaryKey(bookingId);

		Session session = null;

		try {
			session = openSession();

			PersistedBooking[] array = new PersistedBookingImpl[3];

			array[0] = getByRoomId_PrevAndNext(
				session, persistedBooking, roomId, orderByComparator, true);

			array[1] = persistedBooking;

			array[2] = getByRoomId_PrevAndNext(
				session, persistedBooking, roomId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedBooking getByRoomId_PrevAndNext(
		Session session, PersistedBooking persistedBooking, long roomId,
		OrderByComparator<PersistedBooking> orderByComparator,
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

		query.append(_SQL_SELECT_PERSISTEDBOOKING_WHERE);

		query.append(_FINDER_COLUMN_ROOMID_ROOMID_2);

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
			query.append(PersistedBookingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(roomId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						persistedBooking)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<PersistedBooking> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted bookings where roomId = &#63; from the database.
	 *
	 * @param roomId the room ID
	 */
	@Override
	public void removeByRoomId(long roomId) {
		for (PersistedBooking persistedBooking :
				findByRoomId(
					roomId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(persistedBooking);
		}
	}

	/**
	 * Returns the number of persisted bookings where roomId = &#63;.
	 *
	 * @param roomId the room ID
	 * @return the number of matching persisted bookings
	 */
	@Override
	public int countByRoomId(long roomId) {
		FinderPath finderPath = _finderPathCountByRoomId;

		Object[] finderArgs = new Object[] {roomId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PERSISTEDBOOKING_WHERE);

			query.append(_FINDER_COLUMN_ROOMID_ROOMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(roomId);

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

	private static final String _FINDER_COLUMN_ROOMID_ROOMID_2 =
		"persistedBooking.roomId = ?";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the persisted bookings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted bookings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @return the range of matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByUserId(
		long userId, int start, int end) {

		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByUserId(
		long userId, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted bookings where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted bookings
	 */
	@Override
	public List<PersistedBooking> findByUserId(
		long userId, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<PersistedBooking> list = null;

		if (useFinderCache) {
			list = (List<PersistedBooking>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedBooking persistedBooking : list) {
					if ((userId != persistedBooking.getUserId())) {
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

			query.append(_SQL_SELECT_PERSISTEDBOOKING_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(PersistedBookingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<PersistedBooking>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersistedBooking>)QueryUtil.list(
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
	 * Returns the first persisted booking in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking findByUserId_First(
			long userId, OrderByComparator<PersistedBooking> orderByComparator)
		throws NoSuchPersistedBookingException {

		PersistedBooking persistedBooking = fetchByUserId_First(
			userId, orderByComparator);

		if (persistedBooking != null) {
			return persistedBooking;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchPersistedBookingException(msg.toString());
	}

	/**
	 * Returns the first persisted booking in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking fetchByUserId_First(
		long userId, OrderByComparator<PersistedBooking> orderByComparator) {

		List<PersistedBooking> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted booking in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking findByUserId_Last(
			long userId, OrderByComparator<PersistedBooking> orderByComparator)
		throws NoSuchPersistedBookingException {

		PersistedBooking persistedBooking = fetchByUserId_Last(
			userId, orderByComparator);

		if (persistedBooking != null) {
			return persistedBooking;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchPersistedBookingException(msg.toString());
	}

	/**
	 * Returns the last persisted booking in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking fetchByUserId_Last(
		long userId, OrderByComparator<PersistedBooking> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<PersistedBooking> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the persisted bookings before and after the current persisted booking in the ordered set where userId = &#63;.
	 *
	 * @param bookingId the primary key of the current persisted booking
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next persisted booking
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	@Override
	public PersistedBooking[] findByUserId_PrevAndNext(
			long bookingId, long userId,
			OrderByComparator<PersistedBooking> orderByComparator)
		throws NoSuchPersistedBookingException {

		PersistedBooking persistedBooking = findByPrimaryKey(bookingId);

		Session session = null;

		try {
			session = openSession();

			PersistedBooking[] array = new PersistedBookingImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, persistedBooking, userId, orderByComparator, true);

			array[1] = persistedBooking;

			array[2] = getByUserId_PrevAndNext(
				session, persistedBooking, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedBooking getByUserId_PrevAndNext(
		Session session, PersistedBooking persistedBooking, long userId,
		OrderByComparator<PersistedBooking> orderByComparator,
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

		query.append(_SQL_SELECT_PERSISTEDBOOKING_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(PersistedBookingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						persistedBooking)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<PersistedBooking> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted bookings where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (PersistedBooking persistedBooking :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(persistedBooking);
		}
	}

	/**
	 * Returns the number of persisted bookings where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching persisted bookings
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PERSISTEDBOOKING_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"persistedBooking.userId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the persisted booking where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedBookingException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted booking
	 * @throws NoSuchPersistedBookingException if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedBookingException {

		PersistedBooking persistedBooking = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (persistedBooking == null) {
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

			throw new NoSuchPersistedBookingException(msg.toString());
		}

		return persistedBooking;
	}

	/**
	 * Returns the persisted booking where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the persisted booking where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted booking, or <code>null</code> if a matching persisted booking could not be found
	 */
	@Override
	public PersistedBooking fetchByC_ERC(
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

		if (result instanceof PersistedBooking) {
			PersistedBooking persistedBooking = (PersistedBooking)result;

			if ((companyId != persistedBooking.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					persistedBooking.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_PERSISTEDBOOKING_WHERE);

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

				List<PersistedBooking> list = q.list();

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
								"PersistedBookingPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PersistedBooking persistedBooking = list.get(0);

					result = persistedBooking;

					cacheResult(persistedBooking);
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
			return (PersistedBooking)result;
		}
	}

	/**
	 * Removes the persisted booking where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted booking that was removed
	 */
	@Override
	public PersistedBooking removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedBookingException {

		PersistedBooking persistedBooking = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(persistedBooking);
	}

	/**
	 * Returns the number of persisted bookings where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted bookings
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PERSISTEDBOOKING_WHERE);

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
		"persistedBooking.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"persistedBooking.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(persistedBooking.externalReferenceCode IS NULL OR persistedBooking.externalReferenceCode = '')";

	public PersistedBookingPersistenceImpl() {
		setModelClass(PersistedBooking.class);

		setModelImplClass(PersistedBookingImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the persisted booking in the entity cache if it is enabled.
	 *
	 * @param persistedBooking the persisted booking
	 */
	@Override
	public void cacheResult(PersistedBooking persistedBooking) {
		entityCache.putResult(
			entityCacheEnabled, PersistedBookingImpl.class,
			persistedBooking.getPrimaryKey(), persistedBooking);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				persistedBooking.getCompanyId(),
				persistedBooking.getExternalReferenceCode()
			},
			persistedBooking);

		persistedBooking.resetOriginalValues();
	}

	/**
	 * Caches the persisted bookings in the entity cache if it is enabled.
	 *
	 * @param persistedBookings the persisted bookings
	 */
	@Override
	public void cacheResult(List<PersistedBooking> persistedBookings) {
		for (PersistedBooking persistedBooking : persistedBookings) {
			if (entityCache.getResult(
					entityCacheEnabled, PersistedBookingImpl.class,
					persistedBooking.getPrimaryKey()) == null) {

				cacheResult(persistedBooking);
			}
			else {
				persistedBooking.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all persisted bookings.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PersistedBookingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the persisted booking.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PersistedBooking persistedBooking) {
		entityCache.removeResult(
			entityCacheEnabled, PersistedBookingImpl.class,
			persistedBooking.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(PersistedBookingModelImpl)persistedBooking, true);
	}

	@Override
	public void clearCache(List<PersistedBooking> persistedBookings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PersistedBooking persistedBooking : persistedBookings) {
			entityCache.removeResult(
				entityCacheEnabled, PersistedBookingImpl.class,
				persistedBooking.getPrimaryKey());

			clearUniqueFindersCache(
				(PersistedBookingModelImpl)persistedBooking, true);
		}
	}

	protected void cacheUniqueFindersCache(
		PersistedBookingModelImpl persistedBookingModelImpl) {

		Object[] args = new Object[] {
			persistedBookingModelImpl.getCompanyId(),
			persistedBookingModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(
			_finderPathCountByC_ERC, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, persistedBookingModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		PersistedBookingModelImpl persistedBookingModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				persistedBookingModelImpl.getCompanyId(),
				persistedBookingModelImpl.getExternalReferenceCode()
			};

			finderCache.removeResult(_finderPathCountByC_ERC, args);
			finderCache.removeResult(_finderPathFetchByC_ERC, args);
		}

		if ((persistedBookingModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_ERC.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				persistedBookingModelImpl.getOriginalCompanyId(),
				persistedBookingModelImpl.getOriginalExternalReferenceCode()
			};

			finderCache.removeResult(_finderPathCountByC_ERC, args);
			finderCache.removeResult(_finderPathFetchByC_ERC, args);
		}
	}

	/**
	 * Creates a new persisted booking with the primary key. Does not add the persisted booking to the database.
	 *
	 * @param bookingId the primary key for the new persisted booking
	 * @return the new persisted booking
	 */
	@Override
	public PersistedBooking create(long bookingId) {
		PersistedBooking persistedBooking = new PersistedBookingImpl();

		persistedBooking.setNew(true);
		persistedBooking.setPrimaryKey(bookingId);

		String uuid = PortalUUIDUtil.generate();

		persistedBooking.setUuid(uuid);

		persistedBooking.setCompanyId(CompanyThreadLocal.getCompanyId());

		return persistedBooking;
	}

	/**
	 * Removes the persisted booking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bookingId the primary key of the persisted booking
	 * @return the persisted booking that was removed
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	@Override
	public PersistedBooking remove(long bookingId)
		throws NoSuchPersistedBookingException {

		return remove((Serializable)bookingId);
	}

	/**
	 * Removes the persisted booking with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the persisted booking
	 * @return the persisted booking that was removed
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	@Override
	public PersistedBooking remove(Serializable primaryKey)
		throws NoSuchPersistedBookingException {

		Session session = null;

		try {
			session = openSession();

			PersistedBooking persistedBooking = (PersistedBooking)session.get(
				PersistedBookingImpl.class, primaryKey);

			if (persistedBooking == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersistedBookingException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(persistedBooking);
		}
		catch (NoSuchPersistedBookingException nsee) {
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
	protected PersistedBooking removeImpl(PersistedBooking persistedBooking) {
		persistedBookingToPersistedParticipantTableMapper.
			deleteLeftPrimaryKeyTableMappings(persistedBooking.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(persistedBooking)) {
				persistedBooking = (PersistedBooking)session.get(
					PersistedBookingImpl.class,
					persistedBooking.getPrimaryKeyObj());
			}

			if (persistedBooking != null) {
				session.delete(persistedBooking);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (persistedBooking != null) {
			clearCache(persistedBooking);
		}

		return persistedBooking;
	}

	@Override
	public PersistedBooking updateImpl(PersistedBooking persistedBooking) {
		boolean isNew = persistedBooking.isNew();

		if (!(persistedBooking instanceof PersistedBookingModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(persistedBooking.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					persistedBooking);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in persistedBooking proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PersistedBooking implementation " +
					persistedBooking.getClass());
		}

		PersistedBookingModelImpl persistedBookingModelImpl =
			(PersistedBookingModelImpl)persistedBooking;

		if (Validator.isNull(persistedBooking.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			persistedBooking.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (persistedBooking.getCreateDate() == null)) {
			if (serviceContext == null) {
				persistedBooking.setCreateDate(now);
			}
			else {
				persistedBooking.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!persistedBookingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				persistedBooking.setModifiedDate(now);
			}
			else {
				persistedBooking.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (persistedBooking.isNew()) {
				session.save(persistedBooking);

				persistedBooking.setNew(false);
			}
			else {
				persistedBooking = (PersistedBooking)session.merge(
					persistedBooking);
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
			Object[] args = new Object[] {persistedBookingModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				persistedBookingModelImpl.getUuid(),
				persistedBookingModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {persistedBookingModelImpl.getRoomId()};

			finderCache.removeResult(_finderPathCountByRoomId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRoomId, args);

			args = new Object[] {persistedBookingModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((persistedBookingModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					persistedBookingModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {persistedBookingModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((persistedBookingModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					persistedBookingModelImpl.getOriginalUuid(),
					persistedBookingModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					persistedBookingModelImpl.getUuid(),
					persistedBookingModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((persistedBookingModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRoomId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					persistedBookingModelImpl.getOriginalRoomId()
				};

				finderCache.removeResult(_finderPathCountByRoomId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRoomId, args);

				args = new Object[] {persistedBookingModelImpl.getRoomId()};

				finderCache.removeResult(_finderPathCountByRoomId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRoomId, args);
			}

			if ((persistedBookingModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					persistedBookingModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);

				args = new Object[] {persistedBookingModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, PersistedBookingImpl.class,
			persistedBooking.getPrimaryKey(), persistedBooking, false);

		clearUniqueFindersCache(persistedBookingModelImpl, false);
		cacheUniqueFindersCache(persistedBookingModelImpl);

		persistedBooking.resetOriginalValues();

		return persistedBooking;
	}

	/**
	 * Returns the persisted booking with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the persisted booking
	 * @return the persisted booking
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	@Override
	public PersistedBooking findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersistedBookingException {

		PersistedBooking persistedBooking = fetchByPrimaryKey(primaryKey);

		if (persistedBooking == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersistedBookingException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return persistedBooking;
	}

	/**
	 * Returns the persisted booking with the primary key or throws a <code>NoSuchPersistedBookingException</code> if it could not be found.
	 *
	 * @param bookingId the primary key of the persisted booking
	 * @return the persisted booking
	 * @throws NoSuchPersistedBookingException if a persisted booking with the primary key could not be found
	 */
	@Override
	public PersistedBooking findByPrimaryKey(long bookingId)
		throws NoSuchPersistedBookingException {

		return findByPrimaryKey((Serializable)bookingId);
	}

	/**
	 * Returns the persisted booking with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bookingId the primary key of the persisted booking
	 * @return the persisted booking, or <code>null</code> if a persisted booking with the primary key could not be found
	 */
	@Override
	public PersistedBooking fetchByPrimaryKey(long bookingId) {
		return fetchByPrimaryKey((Serializable)bookingId);
	}

	/**
	 * Returns all the persisted bookings.
	 *
	 * @return the persisted bookings
	 */
	@Override
	public List<PersistedBooking> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @return the range of persisted bookings
	 */
	@Override
	public List<PersistedBooking> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted bookings
	 */
	@Override
	public List<PersistedBooking> findAll(
		int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted bookings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted bookings
	 */
	@Override
	public List<PersistedBooking> findAll(
		int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator,
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

		List<PersistedBooking> list = null;

		if (useFinderCache) {
			list = (List<PersistedBooking>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PERSISTEDBOOKING);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERSISTEDBOOKING;

				if (pagination) {
					sql = sql.concat(PersistedBookingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<PersistedBooking>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<PersistedBooking>)QueryUtil.list(
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
	 * Removes all the persisted bookings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PersistedBooking persistedBooking : findAll()) {
			remove(persistedBooking);
		}
	}

	/**
	 * Returns the number of persisted bookings.
	 *
	 * @return the number of persisted bookings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PERSISTEDBOOKING);

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
	 * Returns the primaryKeys of persisted participants associated with the persisted booking.
	 *
	 * @param pk the primary key of the persisted booking
	 * @return long[] of the primaryKeys of persisted participants associated with the persisted booking
	 */
	@Override
	public long[] getPersistedParticipantPrimaryKeys(long pk) {
		long[] pks =
			persistedBookingToPersistedParticipantTableMapper.
				getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the persisted booking associated with the persisted participant.
	 *
	 * @param pk the primary key of the persisted participant
	 * @return the persisted bookings associated with the persisted participant
	 */
	@Override
	public List<PersistedBooking> getPersistedParticipantPersistedBookings(
		long pk) {

		return getPersistedParticipantPersistedBookings(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the persisted booking associated with the persisted participant.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the persisted participant
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @return the range of persisted bookings associated with the persisted participant
	 */
	@Override
	public List<PersistedBooking> getPersistedParticipantPersistedBookings(
		long pk, int start, int end) {

		return getPersistedParticipantPersistedBookings(pk, start, end, null);
	}

	/**
	 * Returns all the persisted booking associated with the persisted participant.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>PersistedBookingModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param pk the primary key of the persisted participant
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted bookings associated with the persisted participant
	 */
	@Override
	public List<PersistedBooking> getPersistedParticipantPersistedBookings(
		long pk, int start, int end,
		OrderByComparator<PersistedBooking> orderByComparator) {

		return persistedBookingToPersistedParticipantTableMapper.
			getLeftBaseModels(pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persisted participants associated with the persisted booking.
	 *
	 * @param pk the primary key of the persisted booking
	 * @return the number of persisted participants associated with the persisted booking
	 */
	@Override
	public int getPersistedParticipantsSize(long pk) {
		long[] pks =
			persistedBookingToPersistedParticipantTableMapper.
				getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the persisted participant is associated with the persisted booking.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPK the primary key of the persisted participant
	 * @return <code>true</code> if the persisted participant is associated with the persisted booking; <code>false</code> otherwise
	 */
	@Override
	public boolean containsPersistedParticipant(
		long pk, long persistedParticipantPK) {

		return persistedBookingToPersistedParticipantTableMapper.
			containsTableMapping(pk, persistedParticipantPK);
	}

	/**
	 * Returns <code>true</code> if the persisted booking has any persisted participants associated with it.
	 *
	 * @param pk the primary key of the persisted booking to check for associations with persisted participants
	 * @return <code>true</code> if the persisted booking has any persisted participants associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsPersistedParticipants(long pk) {
		if (getPersistedParticipantsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the persisted booking and the persisted participant. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPK the primary key of the persisted participant
	 */
	@Override
	public void addPersistedParticipant(long pk, long persistedParticipantPK) {
		PersistedBooking persistedBooking = fetchByPrimaryKey(pk);

		if (persistedBooking == null) {
			persistedBookingToPersistedParticipantTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, persistedParticipantPK);
		}
		else {
			persistedBookingToPersistedParticipantTableMapper.addTableMapping(
				persistedBooking.getCompanyId(), pk, persistedParticipantPK);
		}
	}

	/**
	 * Adds an association between the persisted booking and the persisted participant. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipant the persisted participant
	 */
	@Override
	public void addPersistedParticipant(
		long pk, PersistedParticipant persistedParticipant) {

		PersistedBooking persistedBooking = fetchByPrimaryKey(pk);

		if (persistedBooking == null) {
			persistedBookingToPersistedParticipantTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				persistedParticipant.getPrimaryKey());
		}
		else {
			persistedBookingToPersistedParticipantTableMapper.addTableMapping(
				persistedBooking.getCompanyId(), pk,
				persistedParticipant.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the persisted booking and the persisted participants. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPKs the primary keys of the persisted participants
	 */
	@Override
	public void addPersistedParticipants(
		long pk, long[] persistedParticipantPKs) {

		long companyId = 0;

		PersistedBooking persistedBooking = fetchByPrimaryKey(pk);

		if (persistedBooking == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = persistedBooking.getCompanyId();
		}

		persistedBookingToPersistedParticipantTableMapper.addTableMappings(
			companyId, pk, persistedParticipantPKs);
	}

	/**
	 * Adds an association between the persisted booking and the persisted participants. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipants the persisted participants
	 */
	@Override
	public void addPersistedParticipants(
		long pk, List<PersistedParticipant> persistedParticipants) {

		addPersistedParticipants(
			pk,
			ListUtil.toLongArray(
				persistedParticipants,
				PersistedParticipant.PARTICIPANT_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the persisted booking and its persisted participants. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking to clear the associated persisted participants from
	 */
	@Override
	public void clearPersistedParticipants(long pk) {
		persistedBookingToPersistedParticipantTableMapper.
			deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the persisted booking and the persisted participant. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPK the primary key of the persisted participant
	 */
	@Override
	public void removePersistedParticipant(
		long pk, long persistedParticipantPK) {

		persistedBookingToPersistedParticipantTableMapper.deleteTableMapping(
			pk, persistedParticipantPK);
	}

	/**
	 * Removes the association between the persisted booking and the persisted participant. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipant the persisted participant
	 */
	@Override
	public void removePersistedParticipant(
		long pk, PersistedParticipant persistedParticipant) {

		persistedBookingToPersistedParticipantTableMapper.deleteTableMapping(
			pk, persistedParticipant.getPrimaryKey());
	}

	/**
	 * Removes the association between the persisted booking and the persisted participants. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPKs the primary keys of the persisted participants
	 */
	@Override
	public void removePersistedParticipants(
		long pk, long[] persistedParticipantPKs) {

		persistedBookingToPersistedParticipantTableMapper.deleteTableMappings(
			pk, persistedParticipantPKs);
	}

	/**
	 * Removes the association between the persisted booking and the persisted participants. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipants the persisted participants
	 */
	@Override
	public void removePersistedParticipants(
		long pk, List<PersistedParticipant> persistedParticipants) {

		removePersistedParticipants(
			pk,
			ListUtil.toLongArray(
				persistedParticipants,
				PersistedParticipant.PARTICIPANT_ID_ACCESSOR));
	}

	/**
	 * Sets the persisted participants associated with the persisted booking, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipantPKs the primary keys of the persisted participants to be associated with the persisted booking
	 */
	@Override
	public void setPersistedParticipants(
		long pk, long[] persistedParticipantPKs) {

		Set<Long> newPersistedParticipantPKsSet = SetUtil.fromArray(
			persistedParticipantPKs);
		Set<Long> oldPersistedParticipantPKsSet = SetUtil.fromArray(
			persistedBookingToPersistedParticipantTableMapper.
				getRightPrimaryKeys(pk));

		Set<Long> removePersistedParticipantPKsSet = new HashSet<Long>(
			oldPersistedParticipantPKsSet);

		removePersistedParticipantPKsSet.removeAll(
			newPersistedParticipantPKsSet);

		persistedBookingToPersistedParticipantTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removePersistedParticipantPKsSet));

		newPersistedParticipantPKsSet.removeAll(oldPersistedParticipantPKsSet);

		long companyId = 0;

		PersistedBooking persistedBooking = fetchByPrimaryKey(pk);

		if (persistedBooking == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = persistedBooking.getCompanyId();
		}

		persistedBookingToPersistedParticipantTableMapper.addTableMappings(
			companyId, pk,
			ArrayUtil.toLongArray(newPersistedParticipantPKsSet));
	}

	/**
	 * Sets the persisted participants associated with the persisted booking, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted booking
	 * @param persistedParticipants the persisted participants to be associated with the persisted booking
	 */
	@Override
	public void setPersistedParticipants(
		long pk, List<PersistedParticipant> persistedParticipants) {

		try {
			long[] persistedParticipantPKs =
				new long[persistedParticipants.size()];

			for (int i = 0; i < persistedParticipants.size(); i++) {
				PersistedParticipant persistedParticipant =
					persistedParticipants.get(i);

				persistedParticipantPKs[i] =
					persistedParticipant.getPrimaryKey();
			}

			setPersistedParticipants(pk, persistedParticipantPKs);
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
		return "bookingId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PERSISTEDBOOKING;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PersistedBookingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the persisted booking persistence.
	 */
	@Activate
	public void activate() {
		PersistedBookingModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		PersistedBookingModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		persistedBookingToPersistedParticipantTableMapper =
			TableMapperFactory.getTableMapper(
				"Reservation_Participants_Bookings#bookingId",
				"Reservation_Participants_Bookings", "companyId", "bookingId",
				"participantId", this, PersistedParticipant.class);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedBookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedBookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedBookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedBookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			PersistedBookingModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedBookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedBookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			PersistedBookingModelImpl.UUID_COLUMN_BITMASK |
			PersistedBookingModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByRoomId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedBookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoomId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRoomId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedBookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRoomId",
			new String[] {Long.class.getName()},
			PersistedBookingModelImpl.ROOMID_COLUMN_BITMASK);

		_finderPathCountByRoomId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoomId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedBookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedBookingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()},
			PersistedBookingModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_finderPathFetchByC_ERC = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedBookingImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			PersistedBookingModelImpl.COMPANYID_COLUMN_BITMASK |
			PersistedBookingModelImpl.EXTERNALREFERENCECODE_COLUMN_BITMASK);

		_finderPathCountByC_ERC = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(PersistedBookingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper(
			"Reservation_Participants_Bookings#bookingId");
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
				"value.object.column.bitmask.enabled.jp.co.liferay.reservation.model.PersistedBooking"),
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

	protected TableMapper<PersistedBooking, PersistedParticipant>
		persistedBookingToPersistedParticipantTableMapper;

	private static final String _SQL_SELECT_PERSISTEDBOOKING =
		"SELECT persistedBooking FROM PersistedBooking persistedBooking";

	private static final String _SQL_SELECT_PERSISTEDBOOKING_WHERE =
		"SELECT persistedBooking FROM PersistedBooking persistedBooking WHERE ";

	private static final String _SQL_COUNT_PERSISTEDBOOKING =
		"SELECT COUNT(persistedBooking) FROM PersistedBooking persistedBooking";

	private static final String _SQL_COUNT_PERSISTEDBOOKING_WHERE =
		"SELECT COUNT(persistedBooking) FROM PersistedBooking persistedBooking WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "persistedBooking.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PersistedBooking exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PersistedBooking exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PersistedBookingPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

}