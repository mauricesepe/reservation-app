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

import jp.co.liferay.reservation.service.PersistedParticipantServiceUtil;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the HTTP utility for the
 * <code>PersistedParticipantServiceUtil</code> service
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
 * @see PersistedParticipantServiceSoap
 * @generated
 */
@ProviderType
public class PersistedParticipantServiceHttp {

	public static jp.co.liferay.reservation.model.PersistedParticipant
		fetchPersistedParticipant(
			HttpPrincipal httpPrincipal, long participantId) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedParticipantServiceUtil.class,
				"fetchPersistedParticipant",
				_fetchPersistedParticipantParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, participantId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (jp.co.liferay.reservation.model.PersistedParticipant)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedParticipant> findAll(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedParticipantServiceUtil.class, "findAll",
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
				<jp.co.liferay.reservation.model.PersistedParticipant>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedParticipant>
			getPersistedBookingPersistedParticipants(
				HttpPrincipal httpPrincipal, long bookingId) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedParticipantServiceUtil.class,
				"getPersistedBookingPersistedParticipants",
				_getPersistedBookingPersistedParticipantsParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, bookingId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (java.util.List
				<jp.co.liferay.reservation.model.PersistedParticipant>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static jp.co.liferay.reservation.model.PersistedParticipant
			addPersistedParticipant(
				HttpPrincipal httpPrincipal, long userId, String fullName,
				String companyName, String emailAddress,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedParticipantServiceUtil.class,
				"addPersistedParticipant",
				_addPersistedParticipantParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, userId, fullName, companyName, emailAddress,
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

			return (jp.co.liferay.reservation.model.PersistedParticipant)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static jp.co.liferay.reservation.model.PersistedParticipant
			updatePersistedParticipant(
				HttpPrincipal httpPrincipal, long participantId, long userId,
				String fullName, String companyName, String emailAddress,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedParticipantServiceUtil.class,
				"updatePersistedParticipant",
				_updatePersistedParticipantParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, participantId, userId, fullName, companyName,
				emailAddress, serviceContext);

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

			return (jp.co.liferay.reservation.model.PersistedParticipant)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static jp.co.liferay.reservation.model.PersistedParticipant
			deletePersistedParticipant(
				HttpPrincipal httpPrincipal, long participantId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedParticipantServiceUtil.class,
				"deletePersistedParticipant",
				_deletePersistedParticipantParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, participantId);

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

			return (jp.co.liferay.reservation.model.PersistedParticipant)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		PersistedParticipantServiceHttp.class);

	private static final Class<?>[] _fetchPersistedParticipantParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _findAllParameterTypes1 = new Class[] {};
	private static final Class<?>[]
		_getPersistedBookingPersistedParticipantsParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _addPersistedParticipantParameterTypes3 =
		new Class[] {
			long.class, String.class, String.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updatePersistedParticipantParameterTypes4 =
		new Class[] {
			long.class, long.class, String.class, String.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deletePersistedParticipantParameterTypes5 =
		new Class[] {long.class};

}