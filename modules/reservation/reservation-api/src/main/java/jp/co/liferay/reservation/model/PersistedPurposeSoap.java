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

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link jp.co.liferay.reservation.service.http.PersistedPurposeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PersistedPurposeSoap implements Serializable {

	public static PersistedPurposeSoap toSoapModel(PersistedPurpose model) {
		PersistedPurposeSoap soapModel = new PersistedPurposeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setPurposeId(model.getPurposeId());
		soapModel.setName(model.getName());
		soapModel.setCompanyId(model.getCompanyId());

		return soapModel;
	}

	public static PersistedPurposeSoap[] toSoapModels(
		PersistedPurpose[] models) {

		PersistedPurposeSoap[] soapModels =
			new PersistedPurposeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersistedPurposeSoap[][] toSoapModels(
		PersistedPurpose[][] models) {

		PersistedPurposeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PersistedPurposeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersistedPurposeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersistedPurposeSoap[] toSoapModels(
		List<PersistedPurpose> models) {

		List<PersistedPurposeSoap> soapModels =
			new ArrayList<PersistedPurposeSoap>(models.size());

		for (PersistedPurpose model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersistedPurposeSoap[soapModels.size()]);
	}

	public PersistedPurposeSoap() {
	}

	public long getPrimaryKey() {
		return _purposeId;
	}

	public void setPrimaryKey(long pk) {
		setPurposeId(pk);
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

	public long getPurposeId() {
		return _purposeId;
	}

	public void setPurposeId(long purposeId) {
		_purposeId = purposeId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _purposeId;
	private String _name;
	private long _companyId;

}