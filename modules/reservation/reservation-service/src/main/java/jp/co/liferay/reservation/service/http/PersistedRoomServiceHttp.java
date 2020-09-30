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

package jp.co.liferay.reservation.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import jp.co.liferay.reservation.service.PersistedRoomServiceUtil;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the HTTP utility for the
 * <code>PersistedRoomServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedRoomServiceSoap
 * @generated
 */
@ProviderType
public class PersistedRoomServiceHttp {

	public static jp.co.liferay.reservation.model.PersistedRoom
		fetchPersistedRoom(HttpPrincipal httpPrincipal, long roomId) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedRoomServiceUtil.class, "fetchPersistedRoom",
				_fetchPersistedRoomParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, roomId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (jp.co.liferay.reservation.model.PersistedRoom)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		findAll(HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedRoomServiceUtil.class, "findAll",
				_findAllParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List
				<jp.co.liferay.reservation.model.PersistedRoom>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		findByOfficeId(HttpPrincipal httpPrincipal, long officeId) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedRoomServiceUtil.class, "findByOfficeId",
				_findByOfficeIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, officeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List
				<jp.co.liferay.reservation.model.PersistedRoom>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		findByCalendarId(HttpPrincipal httpPrincipal, long calendarId) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedRoomServiceUtil.class, "findByCalendarId",
				_findByCalendarIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, calendarId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List
				<jp.co.liferay.reservation.model.PersistedRoom>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedAmenityPersistedRooms(
			HttpPrincipal httpPrincipal, long amenityId) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedRoomServiceUtil.class,
				"getPersistedAmenityPersistedRooms",
				_getPersistedAmenityPersistedRoomsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, amenityId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List
				<jp.co.liferay.reservation.model.PersistedRoom>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
		getPersistedPurposePersistedRooms(
			HttpPrincipal httpPrincipal, long purposeId) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedRoomServiceUtil.class,
				"getPersistedPurposePersistedRooms",
				_getPersistedPurposePersistedRoomsParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, purposeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List
				<jp.co.liferay.reservation.model.PersistedRoom>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static jp.co.liferay.reservation.model.PersistedRoom
			addPersistedRoom(
				HttpPrincipal httpPrincipal, String name, String photoPath,
				boolean availableSunday, boolean availableMonday,
				boolean availableTuesday, boolean availableWednesday,
				boolean availableThursday, boolean availableFriday,
				boolean availableSaturday, int availableStartTime,
				int availableEndTime, long officeId,
				double capacitySquareMeters, int capacityPeople,
				int phoneExtension, String wifiSSID, int wifiSecurityType,
				String wifiPassword, long[] amenitiesIds, long[] purposeIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedRoomServiceUtil.class, "addPersistedRoom",
				_addPersistedRoomParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, name, photoPath, availableSunday, availableMonday,
				availableTuesday, availableWednesday, availableThursday,
				availableFriday, availableSaturday, availableStartTime,
				availableEndTime, officeId, capacitySquareMeters,
				capacityPeople, phoneExtension, wifiSSID, wifiSecurityType,
				wifiPassword, amenitiesIds, purposeIds, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (jp.co.liferay.reservation.model.PersistedRoom)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static jp.co.liferay.reservation.model.PersistedRoom updateRoom(
			HttpPrincipal httpPrincipal, long roomId, String name,
			String photoPath, boolean availableSunday, boolean availableMonday,
			boolean availableTuesday, boolean availableWednesday,
			boolean availableThursday, boolean availableFriday,
			boolean availableSaturday, int availableStartTime,
			int availableEndTime, long officeId, double capacitySquareMeters,
			int capacityPeople, int phoneExtension, String wifiSSID,
			int wifiSecurityType, String wifiPassword, long[] amenitiesIds,
			long[] purposeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedRoomServiceUtil.class, "updateRoom",
				_updateRoomParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, roomId, name, photoPath, availableSunday,
				availableMonday, availableTuesday, availableWednesday,
				availableThursday, availableFriday, availableSaturday,
				availableStartTime, availableEndTime, officeId,
				capacitySquareMeters, capacityPeople, phoneExtension, wifiSSID,
				wifiSecurityType, wifiPassword, amenitiesIds, purposeIds,
				serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (jp.co.liferay.reservation.model.PersistedRoom)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static jp.co.liferay.reservation.model.PersistedRoom deleteRoom(
			HttpPrincipal httpPrincipal, long roomId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedRoomServiceUtil.class, "deleteRoom",
				_deleteRoomParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey, roomId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (jp.co.liferay.reservation.model.PersistedRoom)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		PersistedRoomServiceHttp.class);

	private static final Class<?>[] _fetchPersistedRoomParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _findAllParameterTypes1 = new Class[] {};
	private static final Class<?>[] _findByOfficeIdParameterTypes2 =
		new Class[] {long.class};
	private static final Class<?>[] _findByCalendarIdParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[]
		_getPersistedAmenityPersistedRoomsParameterTypes4 = new Class[] {
			long.class
		};
	private static final Class<?>[]
		_getPersistedPurposePersistedRoomsParameterTypes5 = new Class[] {
			long.class
		};
	private static final Class<?>[] _addPersistedRoomParameterTypes6 =
		new Class[] {
			String.class, String.class, boolean.class, boolean.class,
			boolean.class, boolean.class, boolean.class, boolean.class,
			boolean.class, int.class, int.class, long.class, double.class,
			int.class, int.class, String.class, int.class, String.class,
			long[].class, long[].class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updateRoomParameterTypes7 = new Class[] {
		long.class, String.class, String.class, boolean.class, boolean.class,
		boolean.class, boolean.class, boolean.class, boolean.class,
		boolean.class, int.class, int.class, long.class, double.class,
		int.class, int.class, String.class, int.class, String.class,
		long[].class, long[].class,
		com.liferay.portal.kernel.service.ServiceContext.class
	};
	private static final Class<?>[] _deleteRoomParameterTypes8 = new Class[] {
		long.class
	};

}