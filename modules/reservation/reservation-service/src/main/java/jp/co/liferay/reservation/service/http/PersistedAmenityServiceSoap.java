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

import java.rmi.RemoteException;

import jp.co.liferay.reservation.service.PersistedAmenityServiceUtil;

/**
 * Provides the SOAP utility for the
 * <code>PersistedAmenityServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>jp.co.liferay.reservation.model.PersistedAmenitySoap</code>. If the method in the
 * service utility returns a
 * <code>jp.co.liferay.reservation.model.PersistedAmenity</code>, that is translated to a
 * <code>jp.co.liferay.reservation.model.PersistedAmenitySoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedAmenityServiceHttp
 * @generated
 */
public class PersistedAmenityServiceSoap {

	public static jp.co.liferay.reservation.model.PersistedAmenitySoap
			fetchPersistedAmenity(long amenityId)
		throws RemoteException {

		try {
			jp.co.liferay.reservation.model.PersistedAmenity returnValue =
				PersistedAmenityServiceUtil.fetchPersistedAmenity(amenityId);

			return jp.co.liferay.reservation.model.PersistedAmenitySoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedAmenitySoap[]
			findAll()
		throws RemoteException {

		try {
			java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
				returnValue = PersistedAmenityServiceUtil.findAll();

			return jp.co.liferay.reservation.model.PersistedAmenitySoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedAmenitySoap[]
			getPersistedRoomPersistedAmenities(long roomId)
		throws RemoteException {

		try {
			java.util.List<jp.co.liferay.reservation.model.PersistedAmenity>
				returnValue =
					PersistedAmenityServiceUtil.
						getPersistedRoomPersistedAmenities(roomId);

			return jp.co.liferay.reservation.model.PersistedAmenitySoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedAmenitySoap
			addPersistedAmenity(
				String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			jp.co.liferay.reservation.model.PersistedAmenity returnValue =
				PersistedAmenityServiceUtil.addPersistedAmenity(
					name, serviceContext);

			return jp.co.liferay.reservation.model.PersistedAmenitySoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedAmenitySoap
			updatePersistedAmenity(
				long amenityId, String name,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			jp.co.liferay.reservation.model.PersistedAmenity returnValue =
				PersistedAmenityServiceUtil.updatePersistedAmenity(
					amenityId, name, serviceContext);

			return jp.co.liferay.reservation.model.PersistedAmenitySoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedAmenitySoap
			deletePersistedAmenity(long amenityId)
		throws RemoteException {

		try {
			jp.co.liferay.reservation.model.PersistedAmenity returnValue =
				PersistedAmenityServiceUtil.deletePersistedAmenity(amenityId);

			return jp.co.liferay.reservation.model.PersistedAmenitySoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		PersistedAmenityServiceSoap.class);

}