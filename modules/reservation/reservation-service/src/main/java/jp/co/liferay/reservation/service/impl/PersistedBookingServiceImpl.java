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

package jp.co.liferay.reservation.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

import jp.co.liferay.reservation.model.PersistedBooking;
import jp.co.liferay.reservation.service.base.PersistedBookingServiceBaseImpl;

/**
 * The implementation of the persisted booking remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>jp.co.liferay.reservation.service.PersistedBookingService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedBookingServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=reservation",
		"json.web.service.context.path=PersistedBooking"
	},
	service = AopService.class
)
public class PersistedBookingServiceImpl
	extends PersistedBookingServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>jp.co.liferay.reservation.service.PersistedBookingServiceUtil</code> to access the persisted booking remote service.
	 */

    public PersistedBooking fetchPersistedBooking(long bookingId) {
        return persistedBookingLocalService.fetchPersistedBooking(bookingId);
    }

	public List<PersistedBooking> findAll() {
		return persistedBookingLocalService.findAll();
    }

    public List<PersistedBooking> findByUserId(long userId) {
        return persistedBookingLocalService.findByUserId(userId);
    }

    public List<PersistedBooking> findByRoomId(long roomId) {
        return persistedBookingLocalService.findByRoomId(roomId);
    }

    public List<PersistedBooking> getPersistedParticipantPersistedBookings(long participantId) {
        return persistedBookingLocalService.getPersistedParticipantPersistedBookings(participantId);
    }

    public PersistedBooking addPersistedBooking(String title, Date startDt, Date endDt, long roomId, String description,
            long[] participantIds, ServiceContext serviceContext) throws PortalException {
		return persistedBookingLocalService.addPersistedBooking(title, startDt, endDt, roomId, description, participantIds, serviceContext);
	}

    public PersistedBooking updatePersistedBooking(long bookingId, String title, Date startDt, Date endDt, long roomId, String description,
            long[] participantIds, ServiceContext serviceContext) throws PortalException {
		return persistedBookingLocalService.updatePersistedBooking(bookingId, title, startDt, endDt, roomId, description, participantIds, serviceContext);
	}

	public PersistedBooking deletePersistedBooking(long bookingId) throws PortalException {
		return persistedBookingLocalService.deletePersistedBooking(bookingId);
	}
}