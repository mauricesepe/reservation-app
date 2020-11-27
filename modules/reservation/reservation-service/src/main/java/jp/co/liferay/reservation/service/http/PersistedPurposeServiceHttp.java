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

import jp.co.liferay.reservation.service.PersistedPurposeServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>PersistedPurposeServiceUtil</code> service
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
 * @see PersistedPurposeServiceSoap
 * @generated
 */
public class PersistedPurposeServiceHttp {

	public static jp.co.liferay.reservation.model.PersistedPurpose
		fetchPersistedPurpose(HttpPrincipal httpPrincipal, long purposeId) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedPurposeServiceUtil.class, "fetchPersistedPurpose",
				_fetchPersistedPurposeParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, purposeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (jp.co.liferay.reservation.model.PersistedPurpose)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedPurpose> findAll(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedPurposeServiceUtil.class, "findAll",
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
				<jp.co.liferay.reservation.model.PersistedPurpose>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<jp.co.liferay.reservation.model.PersistedPurpose>
			getPersistedRoomPersistedPurposes(
				HttpPrincipal httpPrincipal, long roomId) {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedPurposeServiceUtil.class,
				"getPersistedRoomPersistedPurposes",
				_getPersistedRoomPersistedPurposesParameterTypes2);

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
				<jp.co.liferay.reservation.model.PersistedPurpose>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static jp.co.liferay.reservation.model.PersistedPurpose
			addPersistedPurpose(
				HttpPrincipal httpPrincipal, String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedPurposeServiceUtil.class, "addPersistedPurpose",
				_addPersistedPurposeParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, name, serviceContext);

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

			return (jp.co.liferay.reservation.model.PersistedPurpose)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static jp.co.liferay.reservation.model.PersistedPurpose
			updatePersistedPurpose(
				HttpPrincipal httpPrincipal, long purposeId, String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedPurposeServiceUtil.class, "updatePersistedPurpose",
				_updatePersistedPurposeParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, purposeId, name, serviceContext);

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

			return (jp.co.liferay.reservation.model.PersistedPurpose)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static jp.co.liferay.reservation.model.PersistedPurpose
			deletePersistedPurpose(
				HttpPrincipal httpPrincipal, long purposeId,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				PersistedPurposeServiceUtil.class, "deletePersistedPurpose",
				_deletePersistedPurposeParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, purposeId, serviceContext);

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

			return (jp.co.liferay.reservation.model.PersistedPurpose)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		PersistedPurposeServiceHttp.class);

	private static final Class<?>[] _fetchPersistedPurposeParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _findAllParameterTypes1 = new Class[] {};
	private static final Class<?>[]
		_getPersistedRoomPersistedPurposesParameterTypes2 = new Class[] {
			long.class
		};
	private static final Class<?>[] _addPersistedPurposeParameterTypes3 =
		new Class[] {
			String.class, com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _updatePersistedPurposeParameterTypes4 =
		new Class[] {
			long.class, String.class,
			com.liferay.portal.kernel.service.ServiceContext.class
		};
	private static final Class<?>[] _deletePersistedPurposeParameterTypes5 =
		new Class[] {
			long.class, com.liferay.portal.kernel.service.ServiceContext.class
		};

}