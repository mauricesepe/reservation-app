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
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;

import org.osgi.service.component.annotations.Component;

import jp.co.liferay.reservation.model.PersistedAmenity;
import jp.co.liferay.reservation.service.base.PersistedAmenityLocalServiceBaseImpl;
import jp.co.liferay.reservation.service.util.PersistedAmenityValidator;

/**
 * The implementation of the persisted amenity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>jp.co.liferay.reservation.service.PersistedAmenityLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedAmenityLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=jp.co.liferay.reservation.model.PersistedAmenity",
	service = AopService.class
)
public class PersistedAmenityLocalServiceImpl
	extends PersistedAmenityLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>jp.co.liferay.reservation.service.PersistedAmenityLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>jp.co.liferay.reservation.service.PersistedAmenityLocalServiceUtil</code>.
	 */

    public List<PersistedAmenity> findAll() {
        return persistedAmenityPersistence.findAll();
    }

    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
    @Override
    public PersistedAmenity addPersistedAmenity(String name, ServiceContext serviceContext) throws PortalException {

        long amenityId = counterLocalService.increment(PersistedAmenity.class.getName());

        PersistedAmenity entry = createPersistedAmenity(amenityId);
        entry.setName(name);

        _validate(entry);

        entry = super.addPersistedAmenity(entry);
        return entry;
    }

    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
    @Override
    public PersistedAmenity updatePersistedAmenity(long amenityId, String name, ServiceContext serviceContext) throws PortalException {

        PersistedAmenity entry = getPersistedAmenity(amenityId);
        entry.setName(name);

        _validate(entry);

        entry = super.updatePersistedAmenity(entry);
        return entry;
    }

    @Indexable(type = IndexableType.DELETE)
    @Override
    public PersistedAmenity deletePersistedAmenity(long amenityId) throws PortalException {
        persistedAmenityPersistence.clearPersistedRooms(amenityId);
        return super.deletePersistedAmenity(amenityId);
    }

    protected void _validate(PersistedAmenity amenity) throws PortalException {
        ModelValidator<PersistedAmenity> validator = new PersistedAmenityValidator();
        validator.validate(amenity);
    }
}