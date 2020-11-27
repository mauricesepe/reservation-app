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

import jp.co.liferay.reservation.service.PersistedBookingServiceUtil;

/**
 * Provides the SOAP utility for the
 * <code>PersistedBookingServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>jp.co.liferay.reservation.model.PersistedBookingSoap</code>. If the method in the
 * service utility returns a
 * <code>jp.co.liferay.reservation.model.PersistedBooking</code>, that is translated to a
 * <code>jp.co.liferay.reservation.model.PersistedBookingSoap</code>. Methods that SOAP
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
 * @see PersistedBookingServiceHttp
 * @generated
 */
public class PersistedBookingServiceSoap {

	public static jp.co.liferay.reservation.model.PersistedBookingSoap
			fetchPersistedBooking(long bookingId)
		throws RemoteException {

		try {
			jp.co.liferay.reservation.model.PersistedBooking returnValue =
				PersistedBookingServiceUtil.fetchPersistedBooking(bookingId);

			return jp.co.liferay.reservation.model.PersistedBookingSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedBookingSoap[]
			findAll()
		throws RemoteException {

		try {
			java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
				returnValue = PersistedBookingServiceUtil.findAll();

			return jp.co.liferay.reservation.model.PersistedBookingSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedBookingSoap[]
			findByUserId(long userId)
		throws RemoteException {

		try {
			java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
				returnValue = PersistedBookingServiceUtil.findByUserId(userId);

			return jp.co.liferay.reservation.model.PersistedBookingSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedBookingSoap[]
			findByRoomId(long roomId)
		throws RemoteException {

		try {
			java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
				returnValue = PersistedBookingServiceUtil.findByRoomId(roomId);

			return jp.co.liferay.reservation.model.PersistedBookingSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedBookingSoap[]
			getPersistedParticipantPersistedBookings(long participantId)
		throws RemoteException {

		try {
			java.util.List<jp.co.liferay.reservation.model.PersistedBooking>
				returnValue =
					PersistedBookingServiceUtil.
						getPersistedParticipantPersistedBookings(participantId);

			return jp.co.liferay.reservation.model.PersistedBookingSoap.
				toSoapModels(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedBookingSoap
			addPersistedBooking(
				String title, java.util.Date startDt, java.util.Date endDt,
				long roomId, String description, long[] participantIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			jp.co.liferay.reservation.model.PersistedBooking returnValue =
				PersistedBookingServiceUtil.addPersistedBooking(
					title, startDt, endDt, roomId, description, participantIds,
					serviceContext);

			return jp.co.liferay.reservation.model.PersistedBookingSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedBookingSoap
			updatePersistedBooking(
				long bookingId, String title, java.util.Date startDt,
				java.util.Date endDt, long roomId, String description,
				long[] participantIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			jp.co.liferay.reservation.model.PersistedBooking returnValue =
				PersistedBookingServiceUtil.updatePersistedBooking(
					bookingId, title, startDt, endDt, roomId, description,
					participantIds, serviceContext);

			return jp.co.liferay.reservation.model.PersistedBookingSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedBookingSoap
			deletePersistedBooking(long bookingId)
		throws RemoteException {

		try {
			jp.co.liferay.reservation.model.PersistedBooking returnValue =
				PersistedBookingServiceUtil.deletePersistedBooking(bookingId);

			return jp.co.liferay.reservation.model.PersistedBookingSoap.
				toSoapModel(returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		PersistedBookingServiceSoap.class);

}