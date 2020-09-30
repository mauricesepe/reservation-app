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

import jp.co.liferay.reservation.model.PersistedPurpose;
import jp.co.liferay.reservation.service.base.PersistedPurposeServiceBaseImpl;

/**
 * The implementation of the persisted purpose remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>jp.co.liferay.reservation.service.PersistedPurposeService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedPurposeServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=reservation",
		"json.web.service.context.path=PersistedPurpose"
	},
	service = AopService.class
)
public class PersistedPurposeServiceImpl
	extends PersistedPurposeServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>jp.co.liferay.reservation.service.PersistedPurposeServiceUtil</code> to access the persisted purpose remote service.
	 */

    public PersistedPurpose fetchPersistedPurpose(long purposeId) {
        return persistedPurposeLocalService.fetchPersistedPurpose(purposeId);
    }

	public List<PersistedPurpose> findAll() {
		return persistedPurposeLocalService.findAll();
    }
    
    public List<PersistedPurpose> getPersistedRoomPersistedPurposes(long roomId) {
        return persistedPurposeLocalService.getPersistedRoomPersistedPurposes(roomId);
    }

	public PersistedPurpose addPersistedPurpose(String name, ServiceContext serviceContext) throws PortalException {
		return persistedPurposeLocalService.addPersistedPurpose(name, serviceContext);
	}

	public PersistedPurpose updatePersistedPurpose(long purposeId, String name, ServiceContext serviceContext) throws PortalException {
		return persistedPurposeLocalService.updatePersistedPurpose(purposeId, name, serviceContext);
	}

	public PersistedPurpose deletePersistedPurpose(long purposeId, ServiceContext serviceContext) throws PortalException {
		return persistedPurposeLocalService.deletePersistedPurpose(purposeId, serviceContext);
	}
}