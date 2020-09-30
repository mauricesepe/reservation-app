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

import jp.co.liferay.reservation.model.PersistedOffice;
import jp.co.liferay.reservation.service.base.PersistedOfficeServiceBaseImpl;

/**
 * The implementation of the persisted office remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>jp.co.liferay.reservation.service.PersistedOfficeService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedOfficeServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=reservation",
		"json.web.service.context.path=PersistedOffice"
	},
	service = AopService.class
)
public class PersistedOfficeServiceImpl extends PersistedOfficeServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>jp.co.liferay.reservation.service.PersistedOfficeServiceUtil</code> to access the persisted office remote service.
	 */

    public PersistedOffice fetchPersistedOffice(long officeId) {
        return persistedOfficeLocalService.fetchPersistedOffice(officeId);
    }

	public List<PersistedOffice> findAll() {
		return persistedOfficeLocalService.findAll();
	}

	public PersistedOffice addPersistedOffice(String name, String location, ServiceContext serviceContext) throws PortalException {
		return persistedOfficeLocalService.addPersistedOffice(name, location, serviceContext);
	}

	public PersistedOffice updatePersistedOffice(long officeId, String name, String location, ServiceContext serviceContext) throws PortalException {
		return persistedOfficeLocalService.updatePersistedOffice(officeId, name, location, serviceContext);
	}

	public PersistedOffice deletePersistedOffice(long officeId) throws PortalException {
		return persistedOfficeLocalService.deletePersistedOffice(officeId);
	}
}