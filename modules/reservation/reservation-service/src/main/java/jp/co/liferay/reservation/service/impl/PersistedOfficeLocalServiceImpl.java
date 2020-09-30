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
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarResourceLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jp.co.liferay.reservation.model.PersistedOffice;
import jp.co.liferay.reservation.service.base.PersistedOfficeLocalServiceBaseImpl;
import jp.co.liferay.reservation.service.util.PersistedOfficeValidator;

/**
 * The implementation of the persisted office local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>jp.co.liferay.reservation.service.PersistedOfficeLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedOfficeLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=jp.co.liferay.reservation.model.PersistedOffice",
	service = AopService.class
)
public class PersistedOfficeLocalServiceImpl
	extends PersistedOfficeLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>jp.co.liferay.reservation.service.PersistedOfficeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>jp.co.liferay.reservation.service.PersistedOfficeLocalServiceUtil</code>.
	 */

    public List<PersistedOffice> findAll() {
		return persistedOfficePersistence.findAll();
	}
    
    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedOffice addPersistedOffice(String name, String location, ServiceContext serviceContext) throws PortalException {

        long officeId = counterLocalService.increment(PersistedOffice.class.getName());

        PersistedOffice entry = createPersistedOffice(officeId);
        entry.setName(name);
        entry.setLocation(location);

		_validate(entry);

		entry = _addPersistedOffice(entry, serviceContext);
		return entry;
	}

    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
	public PersistedOffice updatePersistedOffice(long officeId, String name, String location, ServiceContext serviceContext) throws PortalException {
        
        PersistedOffice entry = getPersistedOffice(officeId);
        entry.setName(name);
        entry.setLocation(location);
        
        _validate(entry);

		entry = _updatePersistedOffice(entry, serviceContext);
		return entry;
    }

    @Indexable(type = IndexableType.DELETE)
    @Override
    public PersistedOffice deletePersistedOffice(long officeId) throws PortalException{
        
        PersistedOffice entry = getPersistedOffice(officeId);
        long calendarResourceId = entry.getCalendarResourceId();
        _calendarResourceLocalService.deleteCalendarResource(calendarResourceId);
        
        return super.deletePersistedOffice(officeId);
    }

    protected PersistedOffice _addPersistedOffice(PersistedOffice office, ServiceContext serviceContext) throws PortalException {
        long companyId = serviceContext.getCompanyId();
        long userId = serviceContext.getUserId();
        User user = userLocalService.getUser(userId);
        office.setCompanyId(companyId);
        office.setUserId(userId);
        office.setUserName(user.getFullName());

        Date now = new Date();
        office.setCreateDate(now);
        office.setModifiedDate(now);

        CalendarResource calendarResource = _setCalendarResource(office, serviceContext);
        office.setCalendarResourceId(calendarResource.getCalendarResourceId());

        return super.addPersistedOffice(office);
    }

    protected PersistedOffice _updatePersistedOffice(PersistedOffice office, ServiceContext serviceContext) throws PortalException {
        long companyId = serviceContext.getCompanyId();
        long userId = serviceContext.getUserId();
        User user = userLocalService.getUser(userId);
        office.setCompanyId(companyId);
        office.setUserId(userId);
        office.setUserName(user.getFullName());

        Date now = new Date();
        office.setModifiedDate(now);

        CalendarResource calendarResource = _setCalendarResource(office, serviceContext);
        office.setCalendarResourceId(calendarResource.getCalendarResourceId());

        return super.updatePersistedOffice(office);
    }

    protected CalendarResource _setCalendarResource(PersistedOffice office, ServiceContext serviceContext) throws PortalException {
        long calendarResourceId = office.getCalendarResourceId();

		long userId = office.getUserId();
		long groupId = userLocalService.getUserById(userId).getGroupId();
		long classNameId = classNameLocalService.getClassNameId(PersistedOffice.class);
		long classPk = office.getOfficeId();
		String classUuid = office.getUuid();

		Map<Locale, String> nameMap = new HashMap<>();
        nameMap.put(serviceContext.getLocale(), office.getName());
        
        CalendarResource calendarResource;
        if (calendarResourceId == 0) {
            calendarResource = _calendarResourceLocalService.addCalendarResource(
                    userId, groupId, classNameId, classPk, classUuid, null,
                    nameMap, null, true, serviceContext);
        } else {
            calendarResource =_calendarResourceLocalService.updateCalendarResource(
					calendarResourceId, nameMap, null, true,
					serviceContext);
        }
        return calendarResource;
    }
    
    protected void _validate(PersistedOffice office) throws PortalException {

        ModelValidator<PersistedOffice> validator = new PersistedOfficeValidator();
        validator.validate(office);
    }

    @Reference
    CalendarResourceLocalService _calendarResourceLocalService;
}