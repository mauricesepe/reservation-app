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
 * This class is used by SOAP remote services, specifically {@link jp.co.liferay.reservation.service.http.PersistedRoomServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersistedRoomSoap implements Serializable {

	public static PersistedRoomSoap toSoapModel(PersistedRoom model) {
		PersistedRoomSoap soapModel = new PersistedRoomSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setRoomId(model.getRoomId());
		soapModel.setCalendarId(model.getCalendarId());
		soapModel.setName(model.getName());
		soapModel.setPhotoPath(model.getPhotoPath());
		soapModel.setAvailableMonday(model.isAvailableMonday());
		soapModel.setAvailableTuesday(model.isAvailableTuesday());
		soapModel.setAvailableWednesday(model.isAvailableWednesday());
		soapModel.setAvailableThursday(model.isAvailableThursday());
		soapModel.setAvailableFriday(model.isAvailableFriday());
		soapModel.setAvailableSaturday(model.isAvailableSaturday());
		soapModel.setAvailableSunday(model.isAvailableSunday());
		soapModel.setAvailableStartTime(model.getAvailableStartTime());
		soapModel.setAvailableEndTime(model.getAvailableEndTime());
		soapModel.setOfficeId(model.getOfficeId());
		soapModel.setCapacitySquareMeters(model.getCapacitySquareMeters());
		soapModel.setCapacityPeople(model.getCapacityPeople());
		soapModel.setPhoneExtension(model.getPhoneExtension());
		soapModel.setWifiSSID(model.getWifiSSID());
		soapModel.setWifiSecurityType(model.getWifiSecurityType());
		soapModel.setWifiPassword(model.getWifiPassword());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static PersistedRoomSoap[] toSoapModels(PersistedRoom[] models) {
		PersistedRoomSoap[] soapModels = new PersistedRoomSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersistedRoomSoap[][] toSoapModels(PersistedRoom[][] models) {
		PersistedRoomSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PersistedRoomSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersistedRoomSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersistedRoomSoap[] toSoapModels(List<PersistedRoom> models) {
		List<PersistedRoomSoap> soapModels = new ArrayList<PersistedRoomSoap>(
			models.size());

		for (PersistedRoom model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersistedRoomSoap[soapModels.size()]);
	}

	public PersistedRoomSoap() {
	}

	public long getPrimaryKey() {
		return _roomId;
	}

	public void setPrimaryKey(long pk) {
		setRoomId(pk);
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

	public long getRoomId() {
		return _roomId;
	}

	public void setRoomId(long roomId) {
		_roomId = roomId;
	}

	public long getCalendarId() {
		return _calendarId;
	}

	public void setCalendarId(long calendarId) {
		_calendarId = calendarId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getPhotoPath() {
		return _photoPath;
	}

	public void setPhotoPath(String photoPath) {
		_photoPath = photoPath;
	}

	public boolean getAvailableMonday() {
		return _availableMonday;
	}

	public boolean isAvailableMonday() {
		return _availableMonday;
	}

	public void setAvailableMonday(boolean availableMonday) {
		_availableMonday = availableMonday;
	}

	public boolean getAvailableTuesday() {
		return _availableTuesday;
	}

	public boolean isAvailableTuesday() {
		return _availableTuesday;
	}

	public void setAvailableTuesday(boolean availableTuesday) {
		_availableTuesday = availableTuesday;
	}

	public boolean getAvailableWednesday() {
		return _availableWednesday;
	}

	public boolean isAvailableWednesday() {
		return _availableWednesday;
	}

	public void setAvailableWednesday(boolean availableWednesday) {
		_availableWednesday = availableWednesday;
	}

	public boolean getAvailableThursday() {
		return _availableThursday;
	}

	public boolean isAvailableThursday() {
		return _availableThursday;
	}

	public void setAvailableThursday(boolean availableThursday) {
		_availableThursday = availableThursday;
	}

	public boolean getAvailableFriday() {
		return _availableFriday;
	}

	public boolean isAvailableFriday() {
		return _availableFriday;
	}

	public void setAvailableFriday(boolean availableFriday) {
		_availableFriday = availableFriday;
	}

	public boolean getAvailableSaturday() {
		return _availableSaturday;
	}

	public boolean isAvailableSaturday() {
		return _availableSaturday;
	}

	public void setAvailableSaturday(boolean availableSaturday) {
		_availableSaturday = availableSaturday;
	}

	public boolean getAvailableSunday() {
		return _availableSunday;
	}

	public boolean isAvailableSunday() {
		return _availableSunday;
	}

	public void setAvailableSunday(boolean availableSunday) {
		_availableSunday = availableSunday;
	}

	public int getAvailableStartTime() {
		return _availableStartTime;
	}

	public void setAvailableStartTime(int availableStartTime) {
		_availableStartTime = availableStartTime;
	}

	public int getAvailableEndTime() {
		return _availableEndTime;
	}

	public void setAvailableEndTime(int availableEndTime) {
		_availableEndTime = availableEndTime;
	}

	public long getOfficeId() {
		return _officeId;
	}

	public void setOfficeId(long officeId) {
		_officeId = officeId;
	}

	public double getCapacitySquareMeters() {
		return _capacitySquareMeters;
	}

	public void setCapacitySquareMeters(double capacitySquareMeters) {
		_capacitySquareMeters = capacitySquareMeters;
	}

	public int getCapacityPeople() {
		return _capacityPeople;
	}

	public void setCapacityPeople(int capacityPeople) {
		_capacityPeople = capacityPeople;
	}

	public int getPhoneExtension() {
		return _phoneExtension;
	}

	public void setPhoneExtension(int phoneExtension) {
		_phoneExtension = phoneExtension;
	}

	public String getWifiSSID() {
		return _wifiSSID;
	}

	public void setWifiSSID(String wifiSSID) {
		_wifiSSID = wifiSSID;
	}

	public int getWifiSecurityType() {
		return _wifiSecurityType;
	}

	public void setWifiSecurityType(int wifiSecurityType) {
		_wifiSecurityType = wifiSecurityType;
	}

	public String getWifiPassword() {
		return _wifiPassword;
	}

	public void setWifiPassword(String wifiPassword) {
		_wifiPassword = wifiPassword;
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
	private long _roomId;
	private long _calendarId;
	private String _name;
	private String _photoPath;
	private boolean _availableMonday;
	private boolean _availableTuesday;
	private boolean _availableWednesday;
	private boolean _availableThursday;
	private boolean _availableFriday;
	private boolean _availableSaturday;
	private boolean _availableSunday;
	private int _availableStartTime;
	private int _availableEndTime;
	private long _officeId;
	private double _capacitySquareMeters;
	private int _capacityPeople;
	private int _phoneExtension;
	private String _wifiSSID;
	private int _wifiSecurityType;
	private String _wifiPassword;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}