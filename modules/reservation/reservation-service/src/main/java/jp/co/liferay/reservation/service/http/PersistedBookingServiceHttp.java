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

import jp.co.liferay.reservation.service.PersistedBookingServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>PersistedBookingServiceUtil</code> service
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
 * @see PersistedBookingServiceSoap
 * @generated
 */
public class PersistedBookingServiceHttp {

	public static jp.co.liferay.reservation.model.PersistedBooking
		fetchPersistedBooking(HttpPrincipal httpPrincipal, long bookingId) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedBookingServiceUtil.class, "fetchPersistedBooking",
				_fetchPersistedBookingParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, bookingId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (jp.co.liferay.reservation.model.PersistedBooking)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedBooking> findAll(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedBookingServiceUtil.class, "findAll",
				_findAllParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<jp.co.liferay.reservation.model.PersistedBooking>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedBooking> findByUserId(
			HttpPrincipal httpPrincipal, long userId) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedBookingServiceUtil.class, "findByUserId",
				_findByUserIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, userId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<jp.co.liferay.reservation.model.PersistedBooking>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedBooking> findByRoomId(
			HttpPrincipal httpPrincipal, long roomId) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedBookingServiceUtil.class, "findByRoomId",
				_findByRoomIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, roomId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<jp.co.liferay.reservation.model.PersistedBooking>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedBooking>
			getPersistedParticipantPersistedBookings(
				HttpPrincipal httpPrincipal, long participantId) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedBookingServiceUtil.class,
				"getPersistedParticipantPersistedBookings",
				_getPersistedParticipantPersistedBookingsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, participantId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<jp.co.liferay.reservation.model.PersistedBooking>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static jp.co.liferay.reservation.model.PersistedBooking
			addPersistedBooking(
				HttpPrincipal httpPrincipal, String title,
				java.util.Date startDt, java.util.Date endDt, long roomId,
				String description, long[] participantIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedBookingServiceUtil.class, "addPersistedBooking",
				_addPersistedBookingParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, title, startDt, endDt, roomId, description,
				participantIds, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (jp.co.liferay.reservation.model.PersistedBooking)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static jp.co.liferay.reservation.model.PersistedBooking
			updatePersistedBooking(
				HttpPrincipal httpPrincipal, long bookingId, String title,
				java.util.Date startDt, java.util.Date endDt, long roomId,
				String description, long[] participantIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedBookingServiceUtil.class, "updatePersistedBooking",
				_updatePersistedBookingParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, bookingId, title, startDt, endDt, roomId,
				description, participantIds, serviceContext);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (jp.co.liferay.reservation.model.PersistedBooking)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static jp.co.liferay.reservation.model.PersistedBooking
			deletePersistedBooking(HttpPrincipal httpPrincipal, long bookingId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedBookingServiceUtil.class, "deletePersistedBooking",
				_deletePersistedBookingParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, bookingId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (jp.co.liferay.reservation.model.PersistedBooking)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		PersistedBookingServiceHttp.class);

	private static final Class<?>[] _fetchPersistedBookingParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _findAllParameterTypes1 = new Class[] {};
	private static final Class<?>[] _findByUserIdParameterTypes2 = new Class[] {
		long.class
	};
	private static final Class<?>[] _findByRoomIdParameterTypes3 = new Class[] {
		long.class
	};
	private static final Class<?>[]
		_getPersistedParticipantPersistedBookingsParameterTypes4 = new Class[] {
			long.class
		};
	private static final Class<?>[] _addPersistedBookingParameterTypes5 =
		new Class[] {
			String.class, java.util.Date.class, java.util.Date.class,
			long.class, String.class, long[].class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updatePersistedBookingParameterTypes6 =
		new Class[] {
			long.class, String.class, java.util.Date.class,
			java.util.Date.class, long.class, String.class, long[].class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deletePersistedBookingParameterTypes7 =
		new Class[] {long.class};

}