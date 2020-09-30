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

import jp.co.liferay.reservation.service.PersistedRoomServiceUtil;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the SOAP utility for the
 * <code>PersistedRoomServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>jp.co.liferay.reservation.model.PersistedRoomSoap</code>. If the method in the
 * service utility returns a
 * <code>jp.co.liferay.reservation.model.PersistedRoom</code>, that is translated to a
 * <code>jp.co.liferay.reservation.model.PersistedRoomSoap</code>. Methods that SOAP
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
 * @see PersistedRoomServiceHttp
 * @generated
 */
@ProviderType
public class PersistedRoomServiceSoap {

	public static jp.co.liferay.reservation.model.PersistedRoomSoap
			fetchPersistedRoom(long roomId)
		throws RemoteException {

		try {
			jp.co.liferay.reservation.model.PersistedRoom returnValue =
				PersistedRoomServiceUtil.fetchPersistedRoom(roomId);

			return jp.co.liferay.reservation.model.PersistedRoomSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedRoomSoap[] findAll()
		throws RemoteException {

		try {
			java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
				returnValue = PersistedRoomServiceUtil.findAll();

			return jp.co.liferay.reservation.model.PersistedRoomSoap.
				toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedRoomSoap[]
			findByOfficeId(long officeId)
		throws RemoteException {

		try {
			java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
				returnValue = PersistedRoomServiceUtil.findByOfficeId(officeId);

			return jp.co.liferay.reservation.model.PersistedRoomSoap.
				toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedRoomSoap[]
			findByCalendarId(long calendarId)
		throws RemoteException {

		try {
			java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
				returnValue = PersistedRoomServiceUtil.findByCalendarId(
					calendarId);

			return jp.co.liferay.reservation.model.PersistedRoomSoap.
				toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedRoomSoap[]
			getPersistedAmenityPersistedRooms(long amenityId)
		throws RemoteException {

		try {
			java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
				returnValue =
					PersistedRoomServiceUtil.getPersistedAmenityPersistedRooms(
						amenityId);

			return jp.co.liferay.reservation.model.PersistedRoomSoap.
				toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedRoomSoap[]
			getPersistedPurposePersistedRooms(long purposeId)
		throws RemoteException {

		try {
			java.util.List<jp.co.liferay.reservation.model.PersistedRoom>
				returnValue =
					PersistedRoomServiceUtil.getPersistedPurposePersistedRooms(
						purposeId);

			return jp.co.liferay.reservation.model.PersistedRoomSoap.
				toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedRoomSoap
			addPersistedRoom(
				String name, String photoPath, boolean availableSunday,
				boolean availableMonday, boolean availableTuesday,
				boolean availableWednesday, boolean availableThursday,
				boolean availableFriday, boolean availableSaturday,
				int availableStartTime, int availableEndTime, long officeId,
				double capacitySquareMeters, int capacityPeople,
				int phoneExtension, String wifiSSID, int wifiSecurityType,
				String wifiPassword, long[] amenitiesIds, long[] purposeIds,
				com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			jp.co.liferay.reservation.model.PersistedRoom returnValue =
				PersistedRoomServiceUtil.addPersistedRoom(
					name, photoPath, availableSunday, availableMonday,
					availableTuesday, availableWednesday, availableThursday,
					availableFriday, availableSaturday, availableStartTime,
					availableEndTime, officeId, capacitySquareMeters,
					capacityPeople, phoneExtension, wifiSSID, wifiSecurityType,
					wifiPassword, amenitiesIds, purposeIds, serviceContext);

			return jp.co.liferay.reservation.model.PersistedRoomSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedRoomSoap updateRoom(
			long roomId, String name, String photoPath, boolean availableSunday,
			boolean availableMonday, boolean availableTuesday,
			boolean availableWednesday, boolean availableThursday,
			boolean availableFriday, boolean availableSaturday,
			int availableStartTime, int availableEndTime, long officeId,
			double capacitySquareMeters, int capacityPeople, int phoneExtension,
			String wifiSSID, int wifiSecurityType, String wifiPassword,
			long[] amenitiesIds, long[] purposeIds,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			jp.co.liferay.reservation.model.PersistedRoom returnValue =
				PersistedRoomServiceUtil.updateRoom(
					roomId, name, photoPath, availableSunday, availableMonday,
					availableTuesday, availableWednesday, availableThursday,
					availableFriday, availableSaturday, availableStartTime,
					availableEndTime, officeId, capacitySquareMeters,
					capacityPeople, phoneExtension, wifiSSID, wifiSecurityType,
					wifiPassword, amenitiesIds, purposeIds, serviceContext);

			return jp.co.liferay.reservation.model.PersistedRoomSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static jp.co.liferay.reservation.model.PersistedRoomSoap deleteRoom(
			long roomId)
		throws RemoteException {

		try {
			jp.co.liferay.reservation.model.PersistedRoom returnValue =
				PersistedRoomServiceUtil.deleteRoom(roomId);

			return jp.co.liferay.reservation.model.PersistedRoomSoap.
				toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		PersistedRoomServiceSoap.class);

}