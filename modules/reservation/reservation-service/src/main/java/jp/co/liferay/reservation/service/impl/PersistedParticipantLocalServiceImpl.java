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
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.SystemEventConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.systemevent.SystemEvent;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jp.co.liferay.reservation.model.PersistedParticipant;
import jp.co.liferay.reservation.service.base.PersistedParticipantLocalServiceBaseImpl;
import jp.co.liferay.reservation.service.util.PersistedParticipantValidator;

/**
 * The implementation of the persisted participant local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>jp.co.liferay.reservation.service.PersistedParticipantLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedParticipantLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=jp.co.liferay.reservation.model.PersistedParticipant",
	service = AopService.class
)
public class PersistedParticipantLocalServiceImpl
	extends PersistedParticipantLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>jp.co.liferay.reservation.service.PersistedParticipantLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>jp.co.liferay.reservation.service.PersistedParticipantLocalServiceUtil</code>.
	 */

    public List<PersistedParticipant> findAll() {
		return persistedParticipantPersistence.findAll();
    }
    
    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
    @Override
	public PersistedParticipant addPersistedParticipant(long userId, String fullName, String companyName, 
            String emailAddress, ServiceContext serviceContext) throws PortalException {

        long participantId = counterLocalService.increment(PersistedParticipant.class.getName());
        PersistedParticipant entry = createPersistedParticipant(participantId);

        if (userId != 0) {
            User user = userLocalService.getUser(userId);
            Company company = _companyLocalService.getCompanyById(user.getCompanyId());
            entry.setFullName(user.getFullName());
            entry.setCompanyName(company.getName());
            entry.setEmailAddress(user.getEmailAddress());
        } else {
            entry.setFullName(fullName);
            entry.setCompanyName(companyName);
            entry.setEmailAddress(emailAddress);
        }
        entry.setUserId(userId);
		_validate(entry);

		entry = super.addPersistedParticipant(entry);
		return entry;
	}

    @Indexable(type = IndexableType.REINDEX)
    @SystemEvent(type = SystemEventConstants.TYPE_DEFAULT)
    @Override
	public PersistedParticipant updatePersistedParticipant(long participantId, long userId, String fullName, String companyName,
            String emailAddress, ServiceContext serviceContext) throws PortalException {
		
        PersistedParticipant entry = getPersistedParticipant(participantId);
        if (userId != 0) {
            User user = userLocalService.getUser(userId);
            Company company = _companyLocalService.getCompanyById(user.getCompanyId());
            entry.setFullName(user.getFullName());
            entry.setCompanyName(company.getName());
            entry.setEmailAddress(user.getEmailAddress());
        } else {
            entry.setFullName(fullName);
            entry.setCompanyName(companyName);
            entry.setEmailAddress(emailAddress);
        }
        entry.setUserId(userId);
        _validate(entry);

		entry = super.updatePersistedParticipant(entry);
		return entry;
    }

    @Indexable(type = IndexableType.DELETE)
    @Override
    public PersistedParticipant deletePersistedParticipant(long participantId) throws PortalException {
        persistedParticipantPersistence.clearPersistedBookings(participantId);
        return super.deletePersistedParticipant(participantId);
    }
    
    protected void _validate(PersistedParticipant participant) throws PortalException {

        ModelValidator<PersistedParticipant> validator = new PersistedParticipantValidator();
        validator.validate(participant);
    }

    @Reference
    protected CompanyLocalService _companyLocalService;
}