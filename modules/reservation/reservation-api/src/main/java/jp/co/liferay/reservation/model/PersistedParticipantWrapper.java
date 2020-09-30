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

package jp.co.liferay.reservation.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link PersistedParticipant}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedParticipant
 * @generated
 */
@ProviderType
public class PersistedParticipantWrapper
	extends BaseModelWrapper<PersistedParticipant>
	implements PersistedParticipant, ModelWrapper<PersistedParticipant> {

	public PersistedParticipantWrapper(
		PersistedParticipant persistedParticipant) {

		super(persistedParticipant);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("participantId", getParticipantId());
		attributes.put("userId", getUserId());
		attributes.put("fullName", getFullName());
		attributes.put("companyName", getCompanyName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("companyId", getCompanyId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String externalReferenceCode = (String)attributes.get(
			"externalReferenceCode");

		if (externalReferenceCode != null) {
			setExternalReferenceCode(externalReferenceCode);
		}

		Long participantId = (Long)attributes.get("participantId");

		if (participantId != null) {
			setParticipantId(participantId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String fullName = (String)attributes.get("fullName");

		if (fullName != null) {
			setFullName(fullName);
		}

		String companyName = (String)attributes.get("companyName");

		if (companyName != null) {
			setCompanyName(companyName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	/**
	 * Returns the company ID of this persisted participant.
	 *
	 * @return the company ID of this persisted participant
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the company name of this persisted participant.
	 *
	 * @return the company name of this persisted participant
	 */
	@Override
	public String getCompanyName() {
		return model.getCompanyName();
	}

	/**
	 * Returns the email address of this persisted participant.
	 *
	 * @return the email address of this persisted participant
	 */
	@Override
	public String getEmailAddress() {
		return model.getEmailAddress();
	}

	/**
	 * Returns the external reference code of this persisted participant.
	 *
	 * @return the external reference code of this persisted participant
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the full name of this persisted participant.
	 *
	 * @return the full name of this persisted participant
	 */
	@Override
	public String getFullName() {
		return model.getFullName();
	}

	/**
	 * Returns the participant ID of this persisted participant.
	 *
	 * @return the participant ID of this persisted participant
	 */
	@Override
	public long getParticipantId() {
		return model.getParticipantId();
	}

	/**
	 * Returns the primary key of this persisted participant.
	 *
	 * @return the primary key of this persisted participant
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this persisted participant.
	 *
	 * @return the user ID of this persisted participant
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this persisted participant.
	 *
	 * @return the user uuid of this persisted participant
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this persisted participant.
	 *
	 * @return the uuid of this persisted participant
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this persisted participant.
	 *
	 * @param companyId the company ID of this persisted participant
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the company name of this persisted participant.
	 *
	 * @param companyName the company name of this persisted participant
	 */
	@Override
	public void setCompanyName(String companyName) {
		model.setCompanyName(companyName);
	}

	/**
	 * Sets the email address of this persisted participant.
	 *
	 * @param emailAddress the email address of this persisted participant
	 */
	@Override
	public void setEmailAddress(String emailAddress) {
		model.setEmailAddress(emailAddress);
	}

	/**
	 * Sets the external reference code of this persisted participant.
	 *
	 * @param externalReferenceCode the external reference code of this persisted participant
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the full name of this persisted participant.
	 *
	 * @param fullName the full name of this persisted participant
	 */
	@Override
	public void setFullName(String fullName) {
		model.setFullName(fullName);
	}

	/**
	 * Sets the participant ID of this persisted participant.
	 *
	 * @param participantId the participant ID of this persisted participant
	 */
	@Override
	public void setParticipantId(long participantId) {
		model.setParticipantId(participantId);
	}

	/**
	 * Sets the primary key of this persisted participant.
	 *
	 * @param primaryKey the primary key of this persisted participant
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this persisted participant.
	 *
	 * @param userId the user ID of this persisted participant
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this persisted participant.
	 *
	 * @param userUuid the user uuid of this persisted participant
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this persisted participant.
	 *
	 * @param uuid the uuid of this persisted participant
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected PersistedParticipantWrapper wrap(
		PersistedParticipant persistedParticipant) {

		return new PersistedParticipantWrapper(persistedParticipant);
	}

}