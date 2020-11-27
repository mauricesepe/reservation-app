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
 * This class is used by SOAP remote services, specifically {@link jp.co.liferay.reservation.service.http.PersistedBookingServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersistedBookingSoap implements Serializable {

	public static PersistedBookingSoap toSoapModel(PersistedBooking model) {
		PersistedBookingSoap soapModel = new PersistedBookingSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setExternalReferenceCode(model.getExternalReferenceCode());
		soapModel.setBookingId(model.getBookingId());
		soapModel.setCalendarBookingId(model.getCalendarBookingId());
		soapModel.setTitle(model.getTitle());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setRoomId(model.getRoomId());
		soapModel.setDescription(model.getDescription());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static PersistedBookingSoap[] toSoapModels(
		PersistedBooking[] models) {

		PersistedBookingSoap[] soapModels =
			new PersistedBookingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersistedBookingSoap[][] toSoapModels(
		PersistedBooking[][] models) {

		PersistedBookingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PersistedBookingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersistedBookingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersistedBookingSoap[] toSoapModels(
		List<PersistedBooking> models) {

		List<PersistedBookingSoap> soapModels =
			new ArrayList<PersistedBookingSoap>(models.size());

		for (PersistedBooking model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersistedBookingSoap[soapModels.size()]);
	}

	public PersistedBookingSoap() {
	}

	public long getPrimaryKey() {
		return _bookingId;
	}

	public void setPrimaryKey(long pk) {
		setBookingId(pk);
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

	public long getBookingId() {
		return _bookingId;
	}

	public void setBookingId(long bookingId) {
		_bookingId = bookingId;
	}

	public long getCalendarBookingId() {
		return _calendarBookingId;
	}

	public void setCalendarBookingId(long calendarBookingId) {
		_calendarBookingId = calendarBookingId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public long getRoomId() {
		return _roomId;
	}

	public void setRoomId(long roomId) {
		_roomId = roomId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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
	private long _bookingId;
	private long _calendarBookingId;
	private String _title;
	private Date _startDate;
	private Date _endDate;
	private long _roomId;
	private String _description;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;

}