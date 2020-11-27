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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link jp.co.liferay.reservation.service.http.PersistedOfficeServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersistedOfficeSoap implements Serializable {

	public static PersistedOfficeSoap toSoapModel(PersistedOffice model) {
		PersistedOfficeSoap soapModel = new PersistedOfficeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setOfficeId(model.getOfficeId());
		soapModel.setCalendarResourceId(model.getCalendarResourceId());
		soapModel.setName(model.getName());
		soapModel.setLocation(model.getLocation());
		soapModel.setRoomCount(model.getRoomCount());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static PersistedOfficeSoap[] toSoapModels(PersistedOffice[] models) {
		PersistedOfficeSoap[] soapModels =
			new PersistedOfficeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersistedOfficeSoap[][] toSoapModels(
		PersistedOffice[][] models) {

		PersistedOfficeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PersistedOfficeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersistedOfficeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersistedOfficeSoap[] toSoapModels(
		List<PersistedOffice> models) {

		List<PersistedOfficeSoap> soapModels =
			new ArrayList<PersistedOfficeSoap>(models.size());

		for (PersistedOffice model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersistedOfficeSoap[soapModels.size()]);
	}

	public PersistedOfficeSoap() {
	}

	public long getPrimaryKey() {
		return _officeId;
	}

	public void setPrimaryKey(long pk) {
		setOfficeId(pk);
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

	public long getOfficeId() {
		return _officeId;
	}

	public void setOfficeId(long officeId) {
		_officeId = officeId;
	}

	public long getCalendarResourceId() {
		return _calendarResourceId;
	}

	public void setCalendarResourceId(long calendarResourceId) {
		_calendarResourceId = calendarResourceId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public int getRoomCount() {
		return _roomCount;
	}

	public void setRoomCount(int roomCount) {
		_roomCount = roomCount;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	private String _uuid;
	private String _externalReferenceCode;
	private long _officeId;
	private long _calendarResourceId;
	private String _name;
	private String _location;
	private int _roomCount;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}