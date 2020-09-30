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

import java.util.List;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

import jp.co.liferay.reservation.model.PersistedParticipant;
import jp.co.liferay.reservation.service.base.PersistedParticipantServiceBaseImpl;

/**
 * The implementation of the persisted participant remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>jp.co.liferay.reservation.service.PersistedParticipantService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedParticipantServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=reservation",
		"json.web.service.context.path=PersistedParticipant"
	},
	service = AopService.class
)
public class PersistedParticipantServiceImpl
	extends PersistedParticipantServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>jp.co.liferay.reservation.service.PersistedParticipantServiceUtil</code> to access the persisted participant remote service.
	 */

    public PersistedParticipant fetchPersistedParticipant(long participantId) {
        return persistedParticipantLocalService.fetchPersistedParticipant(participantId);
    }

	public List<PersistedParticipant> findAll() {
		return persistedParticipantLocalService.findAll();
    }
    
    public List<PersistedParticipant> getPersistedBookingPersistedParticipants(long bookingId) {
        return persistedParticipantLocalService.getPersistedBookingPersistedParticipants(bookingId);
    }

	public PersistedParticipant addPersistedParticipant(long userId, String fullName, String companyName, 
            String emailAddress, ServiceContext serviceContext) throws PortalException {
		return persistedParticipantLocalService.addPersistedParticipant(userId, fullName, companyName, emailAddress, serviceContext);
	}

	public PersistedParticipant updatePersistedParticipant(long participantId, long userId, String fullName, String companyName, 
            String emailAddress, ServiceContext serviceContext) throws PortalException {
        return persistedParticipantLocalService.updatePersistedParticipant(participantId, userId, fullName, companyName,emailAddress, serviceContext);
	}

	public PersistedParticipant deletePersistedParticipant(long participantId) throws PortalException {
		return persistedParticipantLocalService.deletePersistedParticipant(participantId);
	}
}