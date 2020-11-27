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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link jp.co.liferay.reservation.service.http.PersistedParticipantServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersistedParticipantSoap implements Serializable {

	public static PersistedParticipantSoap toSoapModel(
		PersistedParticipant model) {

		PersistedParticipantSoap soapModel = new PersistedParticipantSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setParticipantId(model.getParticipantId());
		soapModel.setUserId(model.getUserId());
		soapModel.setFullName(model.getFullName());
		soapModel.setCompanyName(model.getCompanyName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setCompanyId(model.getCompanyId());

		return soapModel;
	}

	public static PersistedParticipantSoap[] toSoapModels(
		PersistedParticipant[] models) {

		PersistedParticipantSoap[] soapModels =
			new PersistedParticipantSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersistedParticipantSoap[][] toSoapModels(
		PersistedParticipant[][] models) {

		PersistedParticipantSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PersistedParticipantSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersistedParticipantSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersistedParticipantSoap[] toSoapModels(
		List<PersistedParticipant> models) {

		List<PersistedParticipantSoap> soapModels =
			new ArrayList<PersistedParticipantSoap>(models.size());

		for (PersistedParticipant model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new PersistedParticipantSoap[soapModels.size()]);
	}

	public PersistedParticipantSoap() {
	}

	public long getPrimaryKey() {
		return _participantId;
	}

	public void setPrimaryKey(long pk) {
		setParticipantId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public String getExternalReferenceCode() {
		return _externalReferenceCode;
	}

	public void setExternalReferenceCode(String externalReferenceCode) {
		_externalReferenceCode = externalReferenceCode;
	}

	public long getParticipantId() {
		return _participantId;
	}

	public void setParticipantId(long participantId) {
		_participantId = participantId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getFullName() {
		return _fullName;
	}

	public void setFullName(String fullName) {
		_fullName = fullName;
	}

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _participantId;
	private long _userId;
	private String _fullName;
	private String _companyName;
	private String _emailAddress;
	private long _companyId;

}