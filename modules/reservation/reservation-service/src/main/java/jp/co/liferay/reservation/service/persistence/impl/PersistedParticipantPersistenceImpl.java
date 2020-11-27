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

import jp.co.liferay.reservation.exception.NoSuchPersistedParticipantException;
import jp.co.liferay.reservation.model.PersistedBooking;
import jp.co.liferay.reservation.model.PersistedParticipant;
import jp.co.liferay.reservation.model.impl.PersistedParticipantImpl;
import jp.co.liferay.reservation.model.impl.PersistedParticipantModelImpl;
import jp.co.liferay.reservation.service.persistence.PersistedParticipantPersistence;
import jp.co.liferay.reservation.service.persistence.impl.constants.ReservationPersistenceConstants;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the persisted participant service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PersistedParticipantPersistence.class)
public class PersistedParticipantPersistenceImpl
	extends BasePersistenceImpl<PersistedParticipant>
	implements PersistedParticipantPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PersistedParticipantUtil</code> to access the persisted participant persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PersistedParticipantImpl.class.getName();

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
	 * Returns all the persisted participants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching persisted participants
	 */
	@Override
	public List<PersistedParticipant> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted participants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @return the range of matching persisted participants
	 */
	@Override
	public List<PersistedParticipant> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted participants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted participants
	 */
	@Override
	public List<PersistedParticipant> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted participants where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching persisted participants
	 */
	@Override
	public List<PersistedParticipant> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PersistedParticipant> orderByComparator,
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

		List<PersistedParticipant> list = null;

		if (useFinderCache) {
			list = (List<PersistedParticipant>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedParticipant persistedParticipant : list) {
					if (!uuid.equals(persistedParticipant.getUuid())) {
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

			sb.append(_SQL_SELECT_PERSISTEDPARTICIPANT_WHERE);

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
				sb.append(PersistedParticipantModelImpl.ORDER_BY_JPQL);
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

				list = (List<PersistedParticipant>)QueryUtil.list(
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
	 * Returns the first persisted participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted participant
	 * @throws NoSuchPersistedParticipantException if a matching persisted participant could not be found
	 */
	@Override
	public PersistedParticipant findByUuid_First(
			String uuid,
			OrderByComparator<PersistedParticipant> orderByComparator)
		throws NoSuchPersistedParticipantException {

		PersistedParticipant persistedParticipant = fetchByUuid_First(
			uuid, orderByComparator);

		if (persistedParticipant != null) {
			return persistedParticipant;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPersistedParticipantException(sb.toString());
	}

	/**
	 * Returns the first persisted participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	@Override
	public PersistedParticipant fetchByUuid_First(
		String uuid,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		List<PersistedParticipant> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last persisted participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted participant
	 * @throws NoSuchPersistedParticipantException if a matching persisted participant could not be found
	 */
	@Override
	public PersistedParticipant findByUuid_Last(
			String uuid,
			OrderByComparator<PersistedParticipant> orderByComparator)
		throws NoSuchPersistedParticipantException {

		PersistedParticipant persistedParticipant = fetchByUuid_Last(
			uuid, orderByComparator);

		if (persistedParticipant != null) {
			return persistedParticipant;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchPersistedParticipantException(sb.toString());
	}

	/**
	 * Returns the last persisted participant in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	@Override
	public PersistedParticipant fetchByUuid_Last(
		String uuid,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<PersistedParticipant> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PersistedParticipant[] findByUuid_PrevAndNext(
			long participantId, String uuid,
			OrderByComparator<PersistedParticipant> orderByComparator)
		throws NoSuchPersistedParticipantException {

		uuid = Objects.toString(uuid, "");

		PersistedParticipant persistedParticipant = findByPrimaryKey(
			participantId);

		Session session = null;

		try {
			session = openSession();

			PersistedParticipant[] array = new PersistedParticipantImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, persistedParticipant, uuid, orderByComparator, true);

			array[1] = persistedParticipant;

			array[2] = getByUuid_PrevAndNext(
				session, persistedParticipant, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedParticipant getByUuid_PrevAndNext(
		Session session, PersistedParticipant persistedParticipant, String uuid,
		OrderByComparator<PersistedParticipant> orderByComparator,
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

		sb.append(_SQL_SELECT_PERSISTEDPARTICIPANT_WHERE);

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
			sb.append(PersistedParticipantModelImpl.ORDER_BY_JPQL);
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
						persistedParticipant)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PersistedParticipant> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted participants where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (PersistedParticipant persistedParticipant :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(persistedParticipant);
		}
	}

	/**
	 * Returns the number of persisted participants where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching persisted participants
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PERSISTEDPARTICIPANT_WHERE);

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
		"persistedParticipant.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(persistedParticipant.uuid IS NULL OR persistedParticipant.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the persisted participants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching persisted participants
	 */
	@Override
	public List<PersistedParticipant> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted participants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @return the range of matching persisted participants
	 */
	@Override
	public List<PersistedParticipant> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted participants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching persisted participants
	 */
	@Override
	public List<PersistedParticipant> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted participants where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>.
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
	@Override
	public List<PersistedParticipant> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersistedParticipant> orderByComparator,
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

		List<PersistedParticipant> list = null;

		if (useFinderCache) {
			list = (List<PersistedParticipant>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PersistedParticipant persistedParticipant : list) {
					if (!uuid.equals(persistedParticipant.getUuid()) ||
						(companyId != persistedParticipant.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PERSISTEDPARTICIPANT_WHERE);

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
				sb.append(PersistedParticipantModelImpl.ORDER_BY_JPQL);
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

				list = (List<PersistedParticipant>)QueryUtil.list(
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
	 * Returns the first persisted participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted participant
	 * @throws NoSuchPersistedParticipantException if a matching persisted participant could not be found
	 */
	@Override
	public PersistedParticipant findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<PersistedParticipant> orderByComparator)
		throws NoSuchPersistedParticipantException {

		PersistedParticipant persistedParticipant = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (persistedParticipant != null) {
			return persistedParticipant;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPersistedParticipantException(sb.toString());
	}

	/**
	 * Returns the first persisted participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	@Override
	public PersistedParticipant fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		List<PersistedParticipant> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PersistedParticipant findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<PersistedParticipant> orderByComparator)
		throws NoSuchPersistedParticipantException {

		PersistedParticipant persistedParticipant = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (persistedParticipant != null) {
			return persistedParticipant;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchPersistedParticipantException(sb.toString());
	}

	/**
	 * Returns the last persisted participant in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	@Override
	public PersistedParticipant fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<PersistedParticipant> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public PersistedParticipant[] findByUuid_C_PrevAndNext(
			long participantId, String uuid, long companyId,
			OrderByComparator<PersistedParticipant> orderByComparator)
		throws NoSuchPersistedParticipantException {

		uuid = Objects.toString(uuid, "");

		PersistedParticipant persistedParticipant = findByPrimaryKey(
			participantId);

		Session session = null;

		try {
			session = openSession();

			PersistedParticipant[] array = new PersistedParticipantImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, persistedParticipant, uuid, companyId,
				orderByComparator, true);

			array[1] = persistedParticipant;

			array[2] = getByUuid_C_PrevAndNext(
				session, persistedParticipant, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected PersistedParticipant getByUuid_C_PrevAndNext(
		Session session, PersistedParticipant persistedParticipant, String uuid,
		long companyId,
		OrderByComparator<PersistedParticipant> orderByComparator,
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

		sb.append(_SQL_SELECT_PERSISTEDPARTICIPANT_WHERE);

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
			sb.append(PersistedParticipantModelImpl.ORDER_BY_JPQL);
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
						persistedParticipant)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<PersistedParticipant> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the persisted participants where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (PersistedParticipant persistedParticipant :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(persistedParticipant);
		}
	}

	/**
	 * Returns the number of persisted participants where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching persisted participants
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERSISTEDPARTICIPANT_WHERE);

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
		"persistedParticipant.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(persistedParticipant.uuid IS NULL OR persistedParticipant.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"persistedParticipant.companyId = ?";

	private FinderPath _finderPathFetchByC_ERC;
	private FinderPath _finderPathCountByC_ERC;

	/**
	 * Returns the persisted participant where companyId = &#63; and externalReferenceCode = &#63; or throws a <code>NoSuchPersistedParticipantException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted participant
	 * @throws NoSuchPersistedParticipantException if a matching persisted participant could not be found
	 */
	@Override
	public PersistedParticipant findByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedParticipantException {

		PersistedParticipant persistedParticipant = fetchByC_ERC(
			companyId, externalReferenceCode);

		if (persistedParticipant == null) {
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

			throw new NoSuchPersistedParticipantException(sb.toString());
		}

		return persistedParticipant;
	}

	/**
	 * Returns the persisted participant where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	@Override
	public PersistedParticipant fetchByC_ERC(
		long companyId, String externalReferenceCode) {

		return fetchByC_ERC(companyId, externalReferenceCode, true);
	}

	/**
	 * Returns the persisted participant where companyId = &#63; and externalReferenceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching persisted participant, or <code>null</code> if a matching persisted participant could not be found
	 */
	@Override
	public PersistedParticipant fetchByC_ERC(
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

		if (result instanceof PersistedParticipant) {
			PersistedParticipant persistedParticipant =
				(PersistedParticipant)result;

			if ((companyId != persistedParticipant.getCompanyId()) ||
				!Objects.equals(
					externalReferenceCode,
					persistedParticipant.getExternalReferenceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PERSISTEDPARTICIPANT_WHERE);

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

				List<PersistedParticipant> list = query.list();

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
								"PersistedParticipantPersistenceImpl.fetchByC_ERC(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					PersistedParticipant persistedParticipant = list.get(0);

					result = persistedParticipant;

					cacheResult(persistedParticipant);
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
			return (PersistedParticipant)result;
		}
	}

	/**
	 * Removes the persisted participant where companyId = &#63; and externalReferenceCode = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the persisted participant that was removed
	 */
	@Override
	public PersistedParticipant removeByC_ERC(
			long companyId, String externalReferenceCode)
		throws NoSuchPersistedParticipantException {

		PersistedParticipant persistedParticipant = findByC_ERC(
			companyId, externalReferenceCode);

		return remove(persistedParticipant);
	}

	/**
	 * Returns the number of persisted participants where companyId = &#63; and externalReferenceCode = &#63;.
	 *
	 * @param companyId the company ID
	 * @param externalReferenceCode the external reference code
	 * @return the number of matching persisted participants
	 */
	@Override
	public int countByC_ERC(long companyId, String externalReferenceCode) {
		externalReferenceCode = Objects.toString(externalReferenceCode, "");

		FinderPath finderPath = _finderPathCountByC_ERC;

		Object[] finderArgs = new Object[] {companyId, externalReferenceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PERSISTEDPARTICIPANT_WHERE);

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
		"persistedParticipant.companyId = ? AND ";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_2 =
		"persistedParticipant.externalReferenceCode = ?";

	private static final String _FINDER_COLUMN_C_ERC_EXTERNALREFERENCECODE_3 =
		"(persistedParticipant.externalReferenceCode IS NULL OR persistedParticipant.externalReferenceCode = '')";

	public PersistedParticipantPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(PersistedParticipant.class);

		setModelImplClass(PersistedParticipantImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the persisted participant in the entity cache if it is enabled.
	 *
	 * @param persistedParticipant the persisted participant
	 */
	@Override
	public void cacheResult(PersistedParticipant persistedParticipant) {
		entityCache.putResult(
			entityCacheEnabled, PersistedParticipantImpl.class,
			persistedParticipant.getPrimaryKey(), persistedParticipant);

		finderCache.putResult(
			_finderPathFetchByC_ERC,
			new Object[] {
				persistedParticipant.getCompanyId(),
				persistedParticipant.getExternalReferenceCode()
			},
			persistedParticipant);

		persistedParticipant.resetOriginalValues();
	}

	/**
	 * Caches the persisted participants in the entity cache if it is enabled.
	 *
	 * @param persistedParticipants the persisted participants
	 */
	@Override
	public void cacheResult(List<PersistedParticipant> persistedParticipants) {
		for (PersistedParticipant persistedParticipant :
				persistedParticipants) {

			if (entityCache.getResult(
					entityCacheEnabled, PersistedParticipantImpl.class,
					persistedParticipant.getPrimaryKey()) == null) {

				cacheResult(persistedParticipant);
			}
			else {
				persistedParticipant.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all persisted participants.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PersistedParticipantImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the persisted participant.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PersistedParticipant persistedParticipant) {
		entityCache.removeResult(
			entityCacheEnabled, PersistedParticipantImpl.class,
			persistedParticipant.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(PersistedParticipantModelImpl)persistedParticipant, true);
	}

	@Override
	public void clearCache(List<PersistedParticipant> persistedParticipants) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PersistedParticipant persistedParticipant :
				persistedParticipants) {

			entityCache.removeResult(
				entityCacheEnabled, PersistedParticipantImpl.class,
				persistedParticipant.getPrimaryKey());

			clearUniqueFindersCache(
				(PersistedParticipantModelImpl)persistedParticipant, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, PersistedParticipantImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		PersistedParticipantModelImpl persistedParticipantModelImpl) {

		Object[] args = new Object[] {
			persistedParticipantModelImpl.getCompanyId(),
			persistedParticipantModelImpl.getExternalReferenceCode()
		};

		finderCache.putResult(
			_finderPathCountByC_ERC, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_ERC, args, persistedParticipantModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		PersistedParticipantModelImpl persistedParticipantModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				persistedParticipantModelImpl.getCompanyId(),
				persistedParticipantModelImpl.getExternalReferenceCode()
			};

			finderCache.removeResult(_finderPathCountByC_ERC, args);
			finderCache.removeResult(_finderPathFetchByC_ERC, args);
		}

		if ((persistedParticipantModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_ERC.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				persistedParticipantModelImpl.getOriginalCompanyId(),
				persistedParticipantModelImpl.getOriginalExternalReferenceCode()
			};

			finderCache.removeResult(_finderPathCountByC_ERC, args);
			finderCache.removeResult(_finderPathFetchByC_ERC, args);
		}
	}

	/**
	 * Creates a new persisted participant with the primary key. Does not add the persisted participant to the database.
	 *
	 * @param participantId the primary key for the new persisted participant
	 * @return the new persisted participant
	 */
	@Override
	public PersistedParticipant create(long participantId) {
		PersistedParticipant persistedParticipant =
			new PersistedParticipantImpl();

		persistedParticipant.setNew(true);
		persistedParticipant.setPrimaryKey(participantId);

		String uuid = PortalUUIDUtil.generate();

		persistedParticipant.setUuid(uuid);

		persistedParticipant.setCompanyId(CompanyThreadLocal.getCompanyId());

		return persistedParticipant;
	}

	/**
	 * Removes the persisted participant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param participantId the primary key of the persisted participant
	 * @return the persisted participant that was removed
	 * @throws NoSuchPersistedParticipantException if a persisted participant with the primary key could not be found
	 */
	@Override
	public PersistedParticipant remove(long participantId)
		throws NoSuchPersistedParticipantException {

		return remove((Serializable)participantId);
	}

	/**
	 * Removes the persisted participant with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the persisted participant
	 * @return the persisted participant that was removed
	 * @throws NoSuchPersistedParticipantException if a persisted participant with the primary key could not be found
	 */
	@Override
	public PersistedParticipant remove(Serializable primaryKey)
		throws NoSuchPersistedParticipantException {

		Session session = null;

		try {
			session = openSession();

			PersistedParticipant persistedParticipant =
				(PersistedParticipant)session.get(
					PersistedParticipantImpl.class, primaryKey);

			if (persistedParticipant == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPersistedParticipantException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(persistedParticipant);
		}
		catch (NoSuchPersistedParticipantException noSuchEntityException) {
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
	protected PersistedParticipant removeImpl(
		PersistedParticipant persistedParticipant) {

		persistedParticipantToPersistedBookingTableMapper.
			deleteLeftPrimaryKeyTableMappings(
				persistedParticipant.getPrimaryKey());

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(persistedParticipant)) {
				persistedParticipant = (PersistedParticipant)session.get(
					PersistedParticipantImpl.class,
					persistedParticipant.getPrimaryKeyObj());
			}

			if (persistedParticipant != null) {
				session.delete(persistedParticipant);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (persistedParticipant != null) {
			clearCache(persistedParticipant);
		}

		return persistedParticipant;
	}

	@Override
	public PersistedParticipant updateImpl(
		PersistedParticipant persistedParticipant) {

		boolean isNew = persistedParticipant.isNew();

		if (!(persistedParticipant instanceof PersistedParticipantModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(persistedParticipant.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					persistedParticipant);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in persistedParticipant proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PersistedParticipant implementation " +
					persistedParticipant.getClass());
		}

		PersistedParticipantModelImpl persistedParticipantModelImpl =
			(PersistedParticipantModelImpl)persistedParticipant;

		if (Validator.isNull(persistedParticipant.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			persistedParticipant.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (persistedParticipant.isNew()) {
				session.save(persistedParticipant);

				persistedParticipant.setNew(false);
			}
			else {
				persistedParticipant = (PersistedParticipant)session.merge(
					persistedParticipant);
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
			Object[] args = new Object[] {
				persistedParticipantModelImpl.getUuid()
			};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				persistedParticipantModelImpl.getUuid(),
				persistedParticipantModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((persistedParticipantModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					persistedParticipantModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {persistedParticipantModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((persistedParticipantModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					persistedParticipantModelImpl.getOriginalUuid(),
					persistedParticipantModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					persistedParticipantModelImpl.getUuid(),
					persistedParticipantModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, PersistedParticipantImpl.class,
			persistedParticipant.getPrimaryKey(), persistedParticipant, false);

		clearUniqueFindersCache(persistedParticipantModelImpl, false);
		cacheUniqueFindersCache(persistedParticipantModelImpl);

		persistedParticipant.resetOriginalValues();

		return persistedParticipant;
	}

	/**
	 * Returns the persisted participant with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the persisted participant
	 * @return the persisted participant
	 * @throws NoSuchPersistedParticipantException if a persisted participant with the primary key could not be found
	 */
	@Override
	public PersistedParticipant findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPersistedParticipantException {

		PersistedParticipant persistedParticipant = fetchByPrimaryKey(
			primaryKey);

		if (persistedParticipant == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPersistedParticipantException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return persistedParticipant;
	}

	/**
	 * Returns the persisted participant with the primary key or throws a <code>NoSuchPersistedParticipantException</code> if it could not be found.
	 *
	 * @param participantId the primary key of the persisted participant
	 * @return the persisted participant
	 * @throws NoSuchPersistedParticipantException if a persisted participant with the primary key could not be found
	 */
	@Override
	public PersistedParticipant findByPrimaryKey(long participantId)
		throws NoSuchPersistedParticipantException {

		return findByPrimaryKey((Serializable)participantId);
	}

	/**
	 * Returns the persisted participant with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param participantId the primary key of the persisted participant
	 * @return the persisted participant, or <code>null</code> if a persisted participant with the primary key could not be found
	 */
	@Override
	public PersistedParticipant fetchByPrimaryKey(long participantId) {
		return fetchByPrimaryKey((Serializable)participantId);
	}

	/**
	 * Returns all the persisted participants.
	 *
	 * @return the persisted participants
	 */
	@Override
	public List<PersistedParticipant> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the persisted participants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @return the range of persisted participants
	 */
	@Override
	public List<PersistedParticipant> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the persisted participants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted participants
	 */
	@Override
	public List<PersistedParticipant> findAll(
		int start, int end,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the persisted participants.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of persisted participants
	 * @param end the upper bound of the range of persisted participants (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of persisted participants
	 */
	@Override
	public List<PersistedParticipant> findAll(
		int start, int end,
		OrderByComparator<PersistedParticipant> orderByComparator,
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

		List<PersistedParticipant> list = null;

		if (useFinderCache) {
			list = (List<PersistedParticipant>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PERSISTEDPARTICIPANT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PERSISTEDPARTICIPANT;

				sql = sql.concat(PersistedParticipantModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PersistedParticipant>)QueryUtil.list(
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
	 * Removes all the persisted participants from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PersistedParticipant persistedParticipant : findAll()) {
			remove(persistedParticipant);
		}
	}

	/**
	 * Returns the number of persisted participants.
	 *
	 * @return the number of persisted participants
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_PERSISTEDPARTICIPANT);

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
	 * Returns the primaryKeys of persisted bookings associated with the persisted participant.
	 *
	 * @param pk the primary key of the persisted participant
	 * @return long[] of the primaryKeys of persisted bookings associated with the persisted participant
	 */
	@Override
	public long[] getPersistedBookingPrimaryKeys(long pk) {
		long[] pks =
			persistedParticipantToPersistedBookingTableMapper.
				getRightPrimaryKeys(pk);

		return pks.clone();
	}

	/**
	 * Returns all the persisted participant associated with the persisted booking.
	 *
	 * @param pk the primary key of the persisted booking
	 * @return the persisted participants associated with the persisted booking
	 */
	@Override
	public List<PersistedParticipant> getPersistedBookingPersistedParticipants(
		long pk) {

		return getPersistedBookingPersistedParticipants(
			pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	/**
	 * Returns all the persisted participant associated with the persisted booking.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted booking
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @return the range of persisted participants associated with the persisted booking
	 */
	@Override
	public List<PersistedParticipant> getPersistedBookingPersistedParticipants(
		long pk, int start, int end) {

		return getPersistedBookingPersistedParticipants(pk, start, end, null);
	}

	/**
	 * Returns all the persisted participant associated with the persisted booking.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PersistedParticipantModelImpl</code>.
	 * </p>
	 *
	 * @param pk the primary key of the persisted booking
	 * @param start the lower bound of the range of persisted bookings
	 * @param end the upper bound of the range of persisted bookings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of persisted participants associated with the persisted booking
	 */
	@Override
	public List<PersistedParticipant> getPersistedBookingPersistedParticipants(
		long pk, int start, int end,
		OrderByComparator<PersistedParticipant> orderByComparator) {

		return persistedParticipantToPersistedBookingTableMapper.
			getLeftBaseModels(pk, start, end, orderByComparator);
	}

	/**
	 * Returns the number of persisted bookings associated with the persisted participant.
	 *
	 * @param pk the primary key of the persisted participant
	 * @return the number of persisted bookings associated with the persisted participant
	 */
	@Override
	public int getPersistedBookingsSize(long pk) {
		long[] pks =
			persistedParticipantToPersistedBookingTableMapper.
				getRightPrimaryKeys(pk);

		return pks.length;
	}

	/**
	 * Returns <code>true</code> if the persisted booking is associated with the persisted participant.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPK the primary key of the persisted booking
	 * @return <code>true</code> if the persisted booking is associated with the persisted participant; <code>false</code> otherwise
	 */
	@Override
	public boolean containsPersistedBooking(long pk, long persistedBookingPK) {
		return persistedParticipantToPersistedBookingTableMapper.
			containsTableMapping(pk, persistedBookingPK);
	}

	/**
	 * Returns <code>true</code> if the persisted participant has any persisted bookings associated with it.
	 *
	 * @param pk the primary key of the persisted participant to check for associations with persisted bookings
	 * @return <code>true</code> if the persisted participant has any persisted bookings associated with it; <code>false</code> otherwise
	 */
	@Override
	public boolean containsPersistedBookings(long pk) {
		if (getPersistedBookingsSize(pk) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * Adds an association between the persisted participant and the persisted booking. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPK the primary key of the persisted booking
	 */
	@Override
	public void addPersistedBooking(long pk, long persistedBookingPK) {
		PersistedParticipant persistedParticipant = fetchByPrimaryKey(pk);

		if (persistedParticipant == null) {
			persistedParticipantToPersistedBookingTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk, persistedBookingPK);
		}
		else {
			persistedParticipantToPersistedBookingTableMapper.addTableMapping(
				persistedParticipant.getCompanyId(), pk, persistedBookingPK);
		}
	}

	/**
	 * Adds an association between the persisted participant and the persisted booking. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBooking the persisted booking
	 */
	@Override
	public void addPersistedBooking(
		long pk, PersistedBooking persistedBooking) {

		PersistedParticipant persistedParticipant = fetchByPrimaryKey(pk);

		if (persistedParticipant == null) {
			persistedParticipantToPersistedBookingTableMapper.addTableMapping(
				CompanyThreadLocal.getCompanyId(), pk,
				persistedBooking.getPrimaryKey());
		}
		else {
			persistedParticipantToPersistedBookingTableMapper.addTableMapping(
				persistedParticipant.getCompanyId(), pk,
				persistedBooking.getPrimaryKey());
		}
	}

	/**
	 * Adds an association between the persisted participant and the persisted bookings. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPKs the primary keys of the persisted bookings
	 */
	@Override
	public void addPersistedBookings(long pk, long[] persistedBookingPKs) {
		long companyId = 0;

		PersistedParticipant persistedParticipant = fetchByPrimaryKey(pk);

		if (persistedParticipant == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = persistedParticipant.getCompanyId();
		}

		persistedParticipantToPersistedBookingTableMapper.addTableMappings(
			companyId, pk, persistedBookingPKs);
	}

	/**
	 * Adds an association between the persisted participant and the persisted bookings. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookings the persisted bookings
	 */
	@Override
	public void addPersistedBookings(
		long pk, List<PersistedBooking> persistedBookings) {

		addPersistedBookings(
			pk,
			ListUtil.toLongArray(
				persistedBookings, PersistedBooking.BOOKING_ID_ACCESSOR));
	}

	/**
	 * Clears all associations between the persisted participant and its persisted bookings. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant to clear the associated persisted bookings from
	 */
	@Override
	public void clearPersistedBookings(long pk) {
		persistedParticipantToPersistedBookingTableMapper.
			deleteLeftPrimaryKeyTableMappings(pk);
	}

	/**
	 * Removes the association between the persisted participant and the persisted booking. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPK the primary key of the persisted booking
	 */
	@Override
	public void removePersistedBooking(long pk, long persistedBookingPK) {
		persistedParticipantToPersistedBookingTableMapper.deleteTableMapping(
			pk, persistedBookingPK);
	}

	/**
	 * Removes the association between the persisted participant and the persisted booking. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBooking the persisted booking
	 */
	@Override
	public void removePersistedBooking(
		long pk, PersistedBooking persistedBooking) {

		persistedParticipantToPersistedBookingTableMapper.deleteTableMapping(
			pk, persistedBooking.getPrimaryKey());
	}

	/**
	 * Removes the association between the persisted participant and the persisted bookings. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPKs the primary keys of the persisted bookings
	 */
	@Override
	public void removePersistedBookings(long pk, long[] persistedBookingPKs) {
		persistedParticipantToPersistedBookingTableMapper.deleteTableMappings(
			pk, persistedBookingPKs);
	}

	/**
	 * Removes the association between the persisted participant and the persisted bookings. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookings the persisted bookings
	 */
	@Override
	public void removePersistedBookings(
		long pk, List<PersistedBooking> persistedBookings) {

		removePersistedBookings(
			pk,
			ListUtil.toLongArray(
				persistedBookings, PersistedBooking.BOOKING_ID_ACCESSOR));
	}

	/**
	 * Sets the persisted bookings associated with the persisted participant, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookingPKs the primary keys of the persisted bookings to be associated with the persisted participant
	 */
	@Override
	public void setPersistedBookings(long pk, long[] persistedBookingPKs) {
		Set<Long> newPersistedBookingPKsSet = SetUtil.fromArray(
			persistedBookingPKs);
		Set<Long> oldPersistedBookingPKsSet = SetUtil.fromArray(
			persistedParticipantToPersistedBookingTableMapper.
				getRightPrimaryKeys(pk));

		Set<Long> removePersistedBookingPKsSet = new HashSet<Long>(
			oldPersistedBookingPKsSet);

		removePersistedBookingPKsSet.removeAll(newPersistedBookingPKsSet);

		persistedParticipantToPersistedBookingTableMapper.deleteTableMappings(
			pk, ArrayUtil.toLongArray(removePersistedBookingPKsSet));

		newPersistedBookingPKsSet.removeAll(oldPersistedBookingPKsSet);

		long companyId = 0;

		PersistedParticipant persistedParticipant = fetchByPrimaryKey(pk);

		if (persistedParticipant == null) {
			companyId = CompanyThreadLocal.getCompanyId();
		}
		else {
			companyId = persistedParticipant.getCompanyId();
		}

		persistedParticipantToPersistedBookingTableMapper.addTableMappings(
			companyId, pk, ArrayUtil.toLongArray(newPersistedBookingPKsSet));
	}

	/**
	 * Sets the persisted bookings associated with the persisted participant, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
	 *
	 * @param pk the primary key of the persisted participant
	 * @param persistedBookings the persisted bookings to be associated with the persisted participant
	 */
	@Override
	public void setPersistedBookings(
		long pk, List<PersistedBooking> persistedBookings) {

		try {
			long[] persistedBookingPKs = new long[persistedBookings.size()];

			for (int i = 0; i < persistedBookings.size(); i++) {
				PersistedBooking persistedBooking = persistedBookings.get(i);

				persistedBookingPKs[i] = persistedBooking.getPrimaryKey();
			}

			setPersistedBookings(pk, persistedBookingPKs);
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
		return "participantId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PERSISTEDPARTICIPANT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PersistedParticipantModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the persisted participant persistence.
	 */
	@Activate
	public void activate() {
		PersistedParticipantModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		PersistedParticipantModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		persistedParticipantToPersistedBookingTableMapper =
			TableMapperFactory.getTableMapper(
				"Reservation_Participants_Bookings#participantId",
				"Reservation_Participants_Bookings", "companyId",
				"participantId", "bookingId", this, PersistedBooking.class);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			PersistedParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			PersistedParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			PersistedParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			PersistedParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			PersistedParticipantModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			PersistedParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			PersistedParticipantImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			PersistedParticipantModelImpl.UUID_COLUMN_BITMASK |
			PersistedParticipantModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathFetchByC_ERC = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			PersistedParticipantImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()},
			PersistedParticipantModelImpl.COMPANYID_COLUMN_BITMASK |
			PersistedParticipantModelImpl.EXTERNALREFERENCECODE_COLUMN_BITMASK);

		_finderPathCountByC_ERC = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_ERC",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(PersistedParticipantImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		TableMapperFactory.removeTableMapper(
			"Reservation_Participants_Bookings#participantId");
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
				"value.object.column.bitmask.enabled.jp.co.liferay.reservation.model.PersistedParticipant"),
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

	protected TableMapper<PersistedParticipant, PersistedBooking>
		persistedParticipantToPersistedBookingTableMapper;

	private static final String _SQL_SELECT_PERSISTEDPARTICIPANT =
		"SELECT persistedParticipant FROM PersistedParticipant persistedParticipant";

	private static final String _SQL_SELECT_PERSISTEDPARTICIPANT_WHERE =
		"SELECT persistedParticipant FROM PersistedParticipant persistedParticipant WHERE ";

	private static final String _SQL_COUNT_PERSISTEDPARTICIPANT =
		"SELECT COUNT(persistedParticipant) FROM PersistedParticipant persistedParticipant";

	private static final String _SQL_COUNT_PERSISTEDPARTICIPANT_WHERE =
		"SELECT COUNT(persistedParticipant) FROM PersistedParticipant persistedParticipant WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"persistedParticipant.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PersistedParticipant exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PersistedParticipant exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PersistedParticipantPersistenceImpl.class);

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