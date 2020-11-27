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

import jp.co.liferay.reservation.exception.NoSuchPersistedPurposeException;
import jp.co.liferay.reservation.model.PersistedPurpose;
import jp.co.liferay.reservation.model.PersistedRoom;
import jp.co.liferay.reservation.model.impl.PersistedPurposeImpl;
import jp.co.liferay.reservation.model.impl.PersistedPurposeModelImpl;
import jp.co.liferay.reservation.service.persistence.PersistedPurposePersistence;
import jp.co.liferay.reservation.service.persistence.impl.constants.ReservationPersistenceConstants;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the persisted purpose service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PersistedPurposePersistence.class)
public class PersistedPurposePersistenceImpl
	extends BasePersistenceImpl<PersistedPurpose>
	implements PersistedPurposePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PersistedPurposeUtil</code> to access the persisted purpose persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PersistedPurposeImpl.class.getName();

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
	 * Returns all the persisted purposes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted purposes
	 */
	@Override
	public List<PersistedPurpose> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PersistedPurpose> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<PersistedPurpose> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<PersistedPurpose> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator,
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

		List<PersistedPurpose> list = null;

		if (useFinderCache) {
			list = (List<PersistedPurpose>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedPurpose persistedPurpose : list) {
					if (!uuid.equals(persistedPurpose.getUuid())) {
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

			sb.append(_SQL_SELECT_PERSISTEDPURPOSE_WHERE);

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
				sb.append(PersistedPurposeModelImpl.ORDER_BY_JPQL);
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

				list = (List<PersistedPurpose>)QueryUtil.list(
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
	 * Returns the first persisted purpose in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted purpose
	 * @throws NoSuchPersistedPurposeException if a matching persisted purpose could not be found
	 */
	@Override
	public PersistedPurpose findByUuid_First(
			String uuid, OrderByComparator<PersistedPurpose> orderByComparator)
		throws NoSuchPersistedPurposeException {

		PersistedPurpose persistedPurpose = fetchByUuid_First(
			uuid, orderByComparator);

		if (persistedPurpose != null) {
			return persistedPurpose;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPersistedPurposeException(sb.toString());
	}

	/**
	 * Returns the first persisted purpose in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	@Override
	public PersistedPurpose fetchByUuid_First(
		String uuid, OrderByComparator<PersistedPurpose> orderByComparator) {

		List<PersistedPurpose> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted purpose in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted purpose
	 * @throws NoSuchPersistedPurposeException if a matching persisted purpose could not be found
	 */
	@Override
	public PersistedPurpose findByUuid_Last(
			String uuid, OrderByComparator<PersistedPurpose> orderByComparator)
		throws NoSuchPersistedPurposeException {

		PersistedPurpose persistedPurpose = fetchByUuid_Last(
			uuid, orderByComparator);

		if (persistedPurpose != null) {
			return persistedPurpose;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPersistedPurposeException(sb.toString());
	}

	/**
	 * Returns the last persisted purpose in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	@Override
	public PersistedPurpose fetchByUuid_Last(
		String uuid, OrderByComparator<PersistedPurpose> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PersistedPurpose> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PersistedPurpose[] findByUuid_PrevAndNext(
			long purposeId, String uuid,
			OrderByComparator<PersistedPurpose> orderByComparator)
		throws NoSuchPersistedPurposeException {

		uuid = Objects.toString(uuid, "");

		PersistedPurpose persistedPurpose = findByPrimaryKey(purposeId);

		Session session = null;

		try {
			session = openSession();

			PersistedPurpose[] array = new PersistedPurposeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, persistedPurpose, uuid, orderByComparator, true);

			array[1] = persistedPurpose;

			array[2] = getByUuid_PrevAndNext(
				session, persistedPurpose, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedPurpose getByUuid_PrevAndNext(
		Session session, PersistedPurpose persistedPurpose, String uuid,
		OrderByComparator<PersistedPurpose> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PERSISTEDPURPOSE_WHERE);

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
			sb.append(PersistedPurposeModelImpl.ORDER_BY_JPQL);
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
						persistedPurpose)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PersistedPurpose> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted purposes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PersistedPurpose persistedPurpose :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(persistedPurpose);
		}
	}

	/**
	 * Returns the number of persisted purposes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted purposes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERSISTEDPURPOSE_WHERE);

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
		"persistedPurpose.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(persistedPurpose.uuid IS NULL OR persistedPurpose.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the persisted purposes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted purposes
	 */
	@Override
	public List<PersistedPurpose> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PersistedPurpose> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<PersistedPurpose> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<PersistedPurpose> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator,
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

		List<PersistedPurpose> list = null;

		if (useFinderCache) {
			list = (List<PersistedPurpose>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedPurpose persistedPurpose : list) {
					if (!uuid.equals(persistedPurpose.getUuid()) ||
						(companyId != persistedPurpose.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PERSISTEDPURPOSE_WHERE);

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
				sb.append(PersistedPurposeModelImpl.ORDER_BY_JPQL);
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

				list = (List<PersistedPurpose>)QueryUtil.list(
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
	 * Returns the first persisted purpose in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted purpose
	 * @throws NoSuchPersistedPurposeException if a matching persisted purpose could not be found
	 */
	@Override
	public PersistedPurpose findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersistedPurpose> orderByComparator)
		throws NoSuchPersistedPurposeException {

		PersistedPurpose persistedPurpose = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (persistedPurpose != null) {
			return persistedPurpose;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPersistedPurposeException(sb.toString());
	}

	/**
	 * Returns the first persisted purpose in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	@Override
	public PersistedPurpose fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersistedPurpose> orderByComparator) {

		List<PersistedPurpose> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PersistedPurpose findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersistedPurpose> orderByComparator)
		throws NoSuchPersistedPurposeException {

		PersistedPurpose persistedPurpose = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (persistedPurpose != null) {
			return persistedPurpose;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPersistedPurposeException(sb.toString());
	}

	/**
	 * Returns the last persisted purpose in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	@Override
	public PersistedPurpose fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersistedPurpose> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PersistedPurpose> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PersistedPurpose[] findByUuid_C_PrevAndNext(
			long purposeId, String uuid, long companyId,
			OrderByComparator<PersistedPurpose> orderByComparator)
		throws NoSuchPersistedPurposeException {

		uuid = Objects.toString(uuid, "");

		PersistedPurpose persistedPurpose = findByPrimaryKey(purposeId);

		Session session = null;

		try {
			session = openSession();

			PersistedPurpose[] array = new PersistedPurposeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, persistedPurpose, uuid, companyId, orderByComparator,
				true);

			array[1] = persistedPurpose;

			array[2] = getByUuid_C_PrevAndNext(
				session, persistedPurpose, uuid, companyId, orderByComparator,
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

	protected PersistedPurpose getByUuid_C_PrevAndNext(
		Session session, PersistedPurpose persistedPurpose, String uuid,
		long companyId, OrderByComparator<PersistedPurpose> orderByComparator,
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

		sb.append(_SQL_SELECT_PERSISTEDPURPOSE_WHERE);

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
			sb.append(PersistedPurposeModelImpl.ORDER_BY_JPQL);
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
						persistedPurpose)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PersistedPurpose> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted purposes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PersistedPurpose persistedPurpose :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(persistedPurpose);
		}
	}

	/**
	 * Returns the number of persisted purposes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted purposes
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERSISTEDPURPOSE_WHERE);

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
		"persistedPurpose.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(persistedPurpose.uuid IS NULL OR persistedPurpose.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"persistedPurpose.companyId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the persisted purpose where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedPurposeException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted purpose
	 * @throws NoSuchPersistedPurposeException if a matching persisted purpose could not be found
	 */
	@Override
	public PersistedPurpose findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedPurposeException {

		PersistedPurpose persistedPurpose = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (persistedPurpose == null) {
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

			throw new NoSuchPersistedPurposeException(sb.toString());
		}

		return persistedPurpose;
	}

	/**
	 * Returns the persisted purpose where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	@Override
	public PersistedPurpose fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the persisted purpose where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted purpose, or <code>null</code> if a matching persisted purpose could not be found
	 */
	@Override
	public PersistedPurpose fetchByC_ERC(
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

		if (result instanceof PersistedPurpose) {
			PersistedPurpose persistedPurpose = (PersistedPurpose)result;

			if ((companyId != persistedPurpose.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					persistedPurpose.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PERSISTEDPURPOSE_WHERE);

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

				List<PersistedPurpose> list = query.list();

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
								"PersistedPurposePersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PersistedPurpose persistedPurpose = list.get(0);

					result = persistedPurpose;

					cacheResult(persistedPurpose);
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
			return (PersistedPurpose)result;
		}
	}

	/**
	 * Removes the persisted purpose where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted purpose that was removed
	 */
	@Override
	public PersistedPurpose removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedPurposeException {

		PersistedPurpose persistedPurpose = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(persistedPurpose);
	}

	/**
	 * Returns the number of persisted purposes where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted purposes
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERSISTEDPURPOSE_WHERE);

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
		"persistedPurpose.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"persistedPurpose.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(persistedPurpose.externalReferenceCode IS NULL OR persistedPurpose.externalReferenceCode = '')";

	public PersistedPurposePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PersistedPurpose.class);

		setModelImplClass(PersistedPurposeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the persisted purpose in the entity cache if it is enabled.
	 *
	 * @param persistedPurpose the persisted purpose
	 */
	@Override
	public void cacheResult(PersistedPurpose persistedPurpose) {
		entityCache.putResult(
			entityCacheEnabled, PersistedPurposeImpl.class,
			persistedPurpose.getPrimaryKey(), persistedPurpose);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				persistedPurpose.getCompanyId(),
				persistedPurpose.getExternalReferenceCode()
			},
			persistedPurpose);

		persistedPurpose.resetOriginalValues();
	}

	/**
	 * Caches the persisted purposes in the entity cache if it is enabled.
	 *
	 * @param persistedPurposes the persisted purposes
	 */
	@Override
	public void cacheResult(List<PersistedPurpose> persistedPurposes) {
		for (PersistedPurpose persistedPurpose : persistedPurposes) {
			if (entityCache.getResult(
					entityCacheEnabled, PersistedPurposeImpl.class,
					persistedPurpose.getPrimaryKey()) == null) {

				cacheResult(persistedPurpose);
			}
			else {
				persistedPurpose.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all persisted purposes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PersistedPurposeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the persisted purpose.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PersistedPurpose persistedPurpose) {
		entityCache.removeResult(
			entityCacheEnabled, PersistedPurposeImpl.class,
			persistedPurpose.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(PersistedPurposeModelImpl)persistedPurpose, true);
	}

	@Override
	public void clearCache(List<PersistedPurpose> persistedPurposes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PersistedPurpose persistedPurpose : persistedPurposes) {
			entityCache.removeResult(
				entityCacheEnabled, PersistedPurposeImpl.class,
				persistedPurpose.getPrimaryKey());

			clearUniqueFindersCache(
				(PersistedPurposeModelImpl)persistedPurpose, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, PersistedPurposeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PersistedPurposeModelImpl persistedPurposeModelImpl) {

		Object[] args = new Object[] {
			persistedPurposeModelImpl.getCompanyId(),
			persistedPurposeModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(
			_finderPathCountByC_ERC, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, persistedPurposeModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		PersistedPurposeModelImpl persistedPurposeModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				persistedPurposeModelImpl.getCompanyId(),
				persistedPurposeModelImpl.getExternalReferenceCode()
			};

			finderCache.removeResult(_finderPathCountByC_ERC, args);
			finderCache.removeResult(_finderPathFetchByC_ERC, args);
		}

		if ((persistedPurposeModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_ERC.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				persistedPurposeModelImpl.getOriginalCompanyId(),
				persistedPurposeModelImpl.getOriginalExternalReferenceCode()
			};

			finderCache.removeResult(_finderPathCountByC_ERC, args);
			finderCache.removeResult(_finderPathFetchByC_ERC, args);
		}
	}

	/**
	 * Creates a new persisted purpose with the primary key. Does not add the persisted purpose to the database.
	 *
	 * @param purposeId the primary key for the new persisted purpose
	 * @return the new persisted purpose
	 */
	@Override
	public PersistedPurpose create(long purposeId) {
		PersistedPurpose persistedPurpose = new PersistedPurposeImpl();

		persistedPurpose.setNew(true);
		persistedPurpose.setPrimaryKey(purposeId);

		String uuid = PortalUUIDUtil.generate();

		persistedPurpose.setUuid(uuid);

		persistedPurpose.setCompanyId(CompanyThreadLocal.getCompanyId());

		return persistedPurpose;
	}

	/**
	 * Removes the persisted purpose with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param purposeId the primary key of the persisted purpose
	 * @return the persisted purpose that was removed
	 * @throws NoSuchPersistedPurposeException if a persisted purpose with the primary key could not be found
	 */
	@Override
	public PersistedPurpose remove(long purposeId)
		throws NoSuchPersistedPurposeException {

		return remove((Serializable)purposeId);
	}

	/**
	 * Removes the persisted purpose with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the persisted purpose
	 * @return the persisted purpose that was removed
	 * @throws NoSuchPersistedPurposeException if a persisted purpose with the primary key could not be found
	 */
	@Override
	public PersistedPurpose remove(Serializable primaryKey)
		throws NoSuchPersistedPurposeException {

		Session session = null;

		try {
			session = openSession();

			PersistedPurpose persistedPurpose = (PersistedPurpose)session.get(
				PersistedPurposeImpl.class, primaryKey);

			if (persistedPurpose == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersistedPurposeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(persistedPurpose);
		}
		catch (NoSuchPersistedPurposeException noSuchEntityException) {
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
	protected PersistedPurpose removeImpl(PersistedPurpose persistedPurpose) {
		persistedPurposeToPersistedRoomTableMapper.
			deleteLeftPrimaryKeyTableMappings(persistedPurpose.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(persistedPurpose)) {
				persistedPurpose = (PersistedPurpose)session.get(
					PersistedPurposeImpl.class,
					persistedPurpose.getPrimaryKeyObj());
			}

			if (persistedPurpose != null) {
				session.delete(persistedPurpose);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (persistedPurpose != null) {
			clearCache(persistedPurpose);
		}

		return persistedPurpose;
	}

	@Override
	public PersistedPurpose updateImpl(PersistedPurpose persistedPurpose) {
		boolean isNew = persistedPurpose.isNew();

		if (!(persistedPurpose instanceof PersistedPurposeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(persistedPurpose.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					persistedPurpose);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in persistedPurpose proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PersistedPurpose implementation " +
					persistedPurpose.getClass());
		}

		PersistedPurposeModelImpl persistedPurposeModelImpl =
			(PersistedPurposeModelImpl)persistedPurpose;

		if (Validator.isNull(persistedPurpose.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			persistedPurpose.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (persistedPurpose.isNew()) {
				session.save(persistedPurpose);

				persistedPurpose.setNew(false);
			}
			else {
				persistedPurpose = (PersistedPurpose)session.merge(
					persistedPurpose);
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
			Object[] args = new Object[] {persistedPurposeModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				persistedPurposeModelImpl.getUuid(),
				persistedPurposeModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((persistedPurposeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					persistedPurposeModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {persistedPurposeModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((persistedPurposeModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					persistedPurposeModelImpl.getOriginalUuid(),
					persistedPurposeModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					persistedPurposeModelImpl.getUuid(),
					persistedPurposeModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, PersistedPurposeImpl.class,
			persistedPurpose.getPrimaryKey(), persistedPurpose, false);

		clearUniqueFindersCache(persistedPurposeModelImpl, false);
		cacheUniqueFindersCache(persistedPurposeModelImpl);

		persistedPurpose.resetOriginalValues();

		return persistedPurpose;
	}

	/**
	 * Returns the persisted purpose with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the persisted purpose
	 * @return the persisted purpose
	 * @throws NoSuchPersistedPurposeException if a persisted purpose with the primary key could not be found
	 */
	@Override
	public PersistedPurpose findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersistedPurposeException {

		PersistedPurpose persistedPurpose = fetchByPrimaryKey(primaryKey);

		if (persistedPurpose == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersistedPurposeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return persistedPurpose;
	}

	/**
	 * Returns the persisted purpose with the primary key or throws a <code>NoSuchPersistedPurposeException</code> if it could not be found.
	 *
	 * @param purposeId the primary key of the persisted purpose
	 * @return the persisted purpose
	 * @throws NoSuchPersistedPurposeException if a persisted purpose with the primary key could not be found
	 */
	@Override
	public PersistedPurpose findByPrimaryKey(long purposeId)
		throws NoSuchPersistedPurposeException {

		return findByPrimaryKey((Serializable)purposeId);
	}

	/**
	 * Returns the persisted purpose with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param purposeId the primary key of the persisted purpose
	 * @return the persisted purpose, or <code>null</code> if a persisted purpose with the primary key could not be found
	 */
	@Override
	public PersistedPurpose fetchByPrimaryKey(long purposeId) {
		return fetchByPrimaryKey((Serializable)purposeId);
	}

	/**
	 * Returns all the persisted purposes.
	 *
	 * @return the persisted purposes
	 */
	@Override
	public List<PersistedPurpose> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<PersistedPurpose> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<PersistedPurpose> findAll(
		int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<PersistedPurpose> findAll(
		int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator,
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

		List<PersistedPurpose> list = null;

		if (useFinderCache) {
			list = (List<PersistedPurpose>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PERSISTEDPURPOSE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PERSISTEDPURPOSE;

				sql = sql.concat(PersistedPurposeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PersistedPurpose>)QueryUtil.list(
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
	 * Removes all the persisted purposes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PersistedPurpose persistedPurpose : findAll()) {
			remove(persistedPurpose);
		}
	}

	/**
	 * Returns the number of persisted purposes.
	 *
	 * @return the number of persisted purposes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PERSISTEDPURPOSE);

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
	 * Returns the primaryKeys of persisted rooms associated with the persisted purpose.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @return long[] of the primaryKeys of persisted rooms associated with the persisted purpose
	 */
	@Override
	public long[] getPersistedRoomPrimaryKeys(long pk) {
		long[] pks =
			persistedPurposeToPersistedRoomTableMapper.getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the persisted purpose associated with the persisted room.
	 *
	 * @param pk the primary key of the persisted room
	 * @return the persisted purposes associated with the persisted room
	 */
	@Override
	public List<PersistedPurpose> getPersistedRoomPersistedPurposes(long pk) {
		return getPersistedRoomPersistedPurposes(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
	@Override
	public List<PersistedPurpose> getPersistedRoomPersistedPurposes(
		long pk, int start, int end) {

		return getPersistedRoomPersistedPurposes(pk, start, end, null);
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
	@Override
	public List<PersistedPurpose> getPersistedRoomPersistedPurposes(
		long pk, int start, int end,
		OrderByComparator<PersistedPurpose> orderByComparator) {

		return persistedPurposeToPersistedRoomTableMapper.getLeftBaseModels(
			pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persisted rooms associated with the persisted purpose.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @return the number of persisted rooms associated with the persisted purpose
	 */
	@Override
	public int getPersistedRoomsSize(long pk) {
		long[] pks =
			persistedPurposeToPersistedRoomTableMapper.getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the persisted room is associated with the persisted purpose.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPK the primary key of the persisted room
	 * @return <code>true</code> if the persisted room is associated with the persisted purpose; <code>false</code> otherwise
	 */
	@Override
	public boolean containsPersistedRoom(long pk, long persistedRoomPK) {
		return persistedPurposeToPersistedRoomTableMapper.containsTableMapping(
			pk, persistedRoomPK);
	}

	/**
	 * Returns <code>true</code> if the persisted purpose has any persisted rooms associated with it.
	 *
	 * @param pk the primary key of the persisted purpose to check for associations with persisted rooms
	 * @return <code>true</code> if the persisted purpose has any persisted rooms associated with it; <code>false</code> otherwise
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
	 * Adds an association between the persisted purpose and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPK the primary key of the persisted room
	 */
	@Override
	public void addPersistedRoom(long pk, long persistedRoomPK) {
		PersistedPurpose persistedPurpose = fetchByPrimaryKey(pk);

		if (persistedPurpose == null) {
			persistedPurposeToPersistedRoomTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, persistedRoomPK);
		}
		else {
			persistedPurposeToPersistedRoomTableMapper.addTableMapping(
				persistedPurpose.getCompanyId(), pk, persistedRoomPK);
		}
	}

	/**
	 * Adds an association between the persisted purpose and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoom the persisted room
	 */
	@Override
	public void addPersistedRoom(long pk, PersistedRoom persistedRoom) {
		PersistedPurpose persistedPurpose = fetchByPrimaryKey(pk);

		if (persistedPurpose == null) {
			persistedPurposeToPersistedRoomTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				persistedRoom.getPrimaryKey());
		}
		else {
			persistedPurposeToPersistedRoomTableMapper.addTableMapping(
				persistedPurpose.getCompanyId(), pk,
				persistedRoom.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the persisted purpose and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPKs the primary keys of the persisted rooms
	 */
	@Override
	public void addPersistedRooms(long pk, long[] persistedRoomPKs) {
		long companyId = 0;

		PersistedPurpose persistedPurpose = fetchByPrimaryKey(pk);

		if (persistedPurpose == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = persistedPurpose.getCompanyId();
		}

		persistedPurposeToPersistedRoomTableMapper.addTableMappings(
			companyId, pk, persistedRoomPKs);
	}

	/**
	 * Adds an association between the persisted purpose and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
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
	 * Clears all associations between the persisted purpose and its persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose to clear the associated persisted rooms from
	 */
	@Override
	public void clearPersistedRooms(long pk) {
		persistedPurposeToPersistedRoomTableMapper.
			deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the persisted purpose and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPK the primary key of the persisted room
	 */
	@Override
	public void removePersistedRoom(long pk, long persistedRoomPK) {
		persistedPurposeToPersistedRoomTableMapper.deleteTableMapping(
			pk, persistedRoomPK);
	}

	/**
	 * Removes the association between the persisted purpose and the persisted room. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoom the persisted room
	 */
	@Override
	public void removePersistedRoom(long pk, PersistedRoom persistedRoom) {
		persistedPurposeToPersistedRoomTableMapper.deleteTableMapping(
			pk, persistedRoom.getPrimaryKey());
	}

	/**
	 * Removes the association between the persisted purpose and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPKs the primary keys of the persisted rooms
	 */
	@Override
	public void removePersistedRooms(long pk, long[] persistedRoomPKs) {
		persistedPurposeToPersistedRoomTableMapper.deleteTableMappings(
			pk, persistedRoomPKs);
	}

	/**
	 * Removes the association between the persisted purpose and the persisted rooms. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
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
	 * Sets the persisted rooms associated with the persisted purpose, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRoomPKs the primary keys of the persisted rooms to be associated with the persisted purpose
	 */
	@Override
	public void setPersistedRooms(long pk, long[] persistedRoomPKs) {
		Set<Long> newPersistedRoomPKsSet = SetUtil.fromArray(persistedRoomPKs);
		Set<Long> oldPersistedRoomPKsSet = SetUtil.fromArray(
			persistedPurposeToPersistedRoomTableMapper.getRightPrimaryKeys(pk));

		Set<Long> removePersistedRoomPKsSet = new HashSet<Long>(
			oldPersistedRoomPKsSet);

		removePersistedRoomPKsSet.removeAll(newPersistedRoomPKsSet);

		persistedPurposeToPersistedRoomTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removePersistedRoomPKsSet));

		newPersistedRoomPKsSet.removeAll(oldPersistedRoomPKsSet);

		long companyId = 0;

		PersistedPurpose persistedPurpose = fetchByPrimaryKey(pk);

		if (persistedPurpose == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = persistedPurpose.getCompanyId();
		}

		persistedPurposeToPersistedRoomTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newPersistedRoomPKsSet));
	}

	/**
	 * Sets the persisted rooms associated with the persisted purpose, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted purpose
	 * @param persistedRooms the persisted rooms to be associated with the persisted purpose
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
		return "purposeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PERSISTEDPURPOSE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PersistedPurposeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the persisted purpose persistence.
	 */
	@Activate
	public void activate() {
		PersistedPurposeModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		PersistedPurposeModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		persistedPurposeToPersistedRoomTableMapper =
			TableMapperFactory.getTableMapper(
				"Reservation_Rooms_Purposes#purposeId",
				"Reservation_Rooms_Purposes", "companyId", "purposeId",
				"roomId", this, PersistedRoom.class);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedPurposeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedPurposeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedPurposeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedPurposeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			PersistedPurposeModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedPurposeImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedPurposeImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			PersistedPurposeModelImpl.UUID_COLUMN_BITMASK |
			PersistedPurposeModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathFetchByC_ERC = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PersistedPurposeImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			PersistedPurposeModelImpl.COMPANYID_COLUMN_BITMASK |
			PersistedPurposeModelImpl.EXTERNALREFERENCECODE_COLUMN_BITMASK);

		_finderPathCountByC_ERC = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(PersistedPurposeImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper(
			"Reservation_Rooms_Purposes#purposeId");
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
				"value.object.column.bitmask.enabled.jp.co.liferay.reservation.model.PersistedPurpose"),
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

	protected TableMapper<PersistedPurpose, PersistedRoom>
		persistedPurposeToPersistedRoomTableMapper;

	private static final String _SQL_SELECT_PERSISTEDPURPOSE =
		"SELECT persistedPurpose FROM PersistedPurpose persistedPurpose";

	private static final String _SQL_SELECT_PERSISTEDPURPOSE_WHERE =
		"SELECT persistedPurpose FROM PersistedPurpose persistedPurpose WHERE ";

	private static final String _SQL_COUNT_PERSISTEDPURPOSE =
		"SELECT COUNT(persistedPurpose) FROM PersistedPurpose persistedPurpose";

	private static final String _SQL_COUNT_PERSISTEDPURPOSE_WHERE =
		"SELECT COUNT(persistedPurpose) FROM PersistedPurpose persistedPurpose WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "persistedPurpose.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PersistedPurpose exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PersistedPurpose exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PersistedPurposePersistenceImpl.class);

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