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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PersistedRoom}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedRoom
 * @generated
 */
public class PersistedRoomWrapper
	extends BaseModelWrapper<PersistedRoom>
	implements ModelWrapper<PersistedRoom>, PersistedRoom {

	public PersistedRoomWrapper(PersistedRoom persistedRoom) {
		super(persistedRoom);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("roomId", getRoomId());
		attributes.put("calendarId", getCalendarId());
		attributes.put("name", getName());
		attributes.put("photoPath", getPhotoPath());
		attributes.put("availableMonday", isAvailableMonday());
		attributes.put("availableTuesday", isAvailableTuesday());
		attributes.put("availableWednesday", isAvailableWednesday());
		attributes.put("availableThursday", isAvailableThursday());
		attributes.put("availableFriday", isAvailableFriday());
		attributes.put("availableSaturday", isAvailableSaturday());
		attributes.put("availableSunday", isAvailableSunday());
		attributes.put("availableStartTime", getAvailableStartTime());
		attributes.put("availableEndTime", getAvailableEndTime());
		attributes.put("officeId", getOfficeId());
		attributes.put("capacitySquareMeters", getCapacitySquareMeters());
		attributes.put("capacityPeople", getCapacityPeople());
		attributes.put("phoneExtension", getPhoneExtension());
		attributes.put("wifiSSID", getWifiSSID());
		attributes.put("wifiSecurityType", getWifiSecurityType());
		attributes.put("wifiPassword", getWifiPassword());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

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

		Long roomId = (Long)attributes.get("roomId");

		if (roomId != null) {
			setRoomId(roomId);
		}

		Long calendarId = (Long)attributes.get("calendarId");

		if (calendarId != null) {
			setCalendarId(calendarId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String photoPath = (String)attributes.get("photoPath");

		if (photoPath != null) {
			setPhotoPath(photoPath);
		}

		Boolean availableMonday = (Boolean)attributes.get("availableMonday");

		if (availableMonday != null) {
			setAvailableMonday(availableMonday);
		}

		Boolean availableTuesday = (Boolean)attributes.get("availableTuesday");

		if (availableTuesday != null) {
			setAvailableTuesday(availableTuesday);
		}

		Boolean availableWednesday = (Boolean)attributes.get(
			"availableWednesday");

		if (availableWednesday != null) {
			setAvailableWednesday(availableWednesday);
		}

		Boolean availableThursday = (Boolean)attributes.get(
			"availableThursday");

		if (availableThursday != null) {
			setAvailableThursday(availableThursday);
		}

		Boolean availableFriday = (Boolean)attributes.get("availableFriday");

		if (availableFriday != null) {
			setAvailableFriday(availableFriday);
		}

		Boolean availableSaturday = (Boolean)attributes.get(
			"availableSaturday");

		if (availableSaturday != null) {
			setAvailableSaturday(availableSaturday);
		}

		Boolean availableSunday = (Boolean)attributes.get("availableSunday");

		if (availableSunday != null) {
			setAvailableSunday(availableSunday);
		}

		Integer availableStartTime = (Integer)attributes.get(
			"availableStartTime");

		if (availableStartTime != null) {
			setAvailableStartTime(availableStartTime);
		}

		Integer availableEndTime = (Integer)attributes.get("availableEndTime");

		if (availableEndTime != null) {
			setAvailableEndTime(availableEndTime);
		}

		Long officeId = (Long)attributes.get("officeId");

		if (officeId != null) {
			setOfficeId(officeId);
		}

		Double capacitySquareMeters = (Double)attributes.get(
			"capacitySquareMeters");

		if (capacitySquareMeters != null) {
			setCapacitySquareMeters(capacitySquareMeters);
		}

		Integer capacityPeople = (Integer)attributes.get("capacityPeople");

		if (capacityPeople != null) {
			setCapacityPeople(capacityPeople);
		}

		Integer phoneExtension = (Integer)attributes.get("phoneExtension");

		if (phoneExtension != null) {
			setPhoneExtension(phoneExtension);
		}

		String wifiSSID = (String)attributes.get("wifiSSID");

		if (wifiSSID != null) {
			setWifiSSID(wifiSSID);
		}

		Integer wifiSecurityType = (Integer)attributes.get("wifiSecurityType");

		if (wifiSecurityType != null) {
			setWifiSecurityType(wifiSecurityType);
		}

		String wifiPassword = (String)attributes.get("wifiPassword");

		if (wifiPassword != null) {
			setWifiPassword(wifiPassword);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	 * Returns the available end time of this persisted room.
	 *
	 * @return the available end time of this persisted room
	 */
	@Override
	public int getAvailableEndTime() {
		return model.getAvailableEndTime();
	}

	/**
	 * Returns the available friday of this persisted room.
	 *
	 * @return the available friday of this persisted room
	 */
	@Override
	public boolean getAvailableFriday() {
		return model.getAvailableFriday();
	}

	/**
	 * Returns the available monday of this persisted room.
	 *
	 * @return the available monday of this persisted room
	 */
	@Override
	public boolean getAvailableMonday() {
		return model.getAvailableMonday();
	}

	/**
	 * Returns the available saturday of this persisted room.
	 *
	 * @return the available saturday of this persisted room
	 */
	@Override
	public boolean getAvailableSaturday() {
		return model.getAvailableSaturday();
	}

	/**
	 * Returns the available start time of this persisted room.
	 *
	 * @return the available start time of this persisted room
	 */
	@Override
	public int getAvailableStartTime() {
		return model.getAvailableStartTime();
	}

	/**
	 * Returns the available sunday of this persisted room.
	 *
	 * @return the available sunday of this persisted room
	 */
	@Override
	public boolean getAvailableSunday() {
		return model.getAvailableSunday();
	}

	/**
	 * Returns the available thursday of this persisted room.
	 *
	 * @return the available thursday of this persisted room
	 */
	@Override
	public boolean getAvailableThursday() {
		return model.getAvailableThursday();
	}

	/**
	 * Returns the available tuesday of this persisted room.
	 *
	 * @return the available tuesday of this persisted room
	 */
	@Override
	public boolean getAvailableTuesday() {
		return model.getAvailableTuesday();
	}

	/**
	 * Returns the available wednesday of this persisted room.
	 *
	 * @return the available wednesday of this persisted room
	 */
	@Override
	public boolean getAvailableWednesday() {
		return model.getAvailableWednesday();
	}

	/**
	 * Returns the calendar ID of this persisted room.
	 *
	 * @return the calendar ID of this persisted room
	 */
	@Override
	public long getCalendarId() {
		return model.getCalendarId();
	}

	/**
	 * Returns the capacity people of this persisted room.
	 *
	 * @return the capacity people of this persisted room
	 */
	@Override
	public int getCapacityPeople() {
		return model.getCapacityPeople();
	}

	/**
	 * Returns the capacity square meters of this persisted room.
	 *
	 * @return the capacity square meters of this persisted room
	 */
	@Override
	public double getCapacitySquareMeters() {
		return model.getCapacitySquareMeters();
	}

	/**
	 * Returns the company ID of this persisted room.
	 *
	 * @return the company ID of this persisted room
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this persisted room.
	 *
	 * @return the create date of this persisted room
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external reference code of this persisted room.
	 *
	 * @return the external reference code of this persisted room
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the modified date of this persisted room.
	 *
	 * @return the modified date of this persisted room
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this persisted room.
	 *
	 * @return the name of this persisted room
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the office ID of this persisted room.
	 *
	 * @return the office ID of this persisted room
	 */
	@Override
	public long getOfficeId() {
		return model.getOfficeId();
	}

	/**
	 * Returns the phone extension of this persisted room.
	 *
	 * @return the phone extension of this persisted room
	 */
	@Override
	public int getPhoneExtension() {
		return model.getPhoneExtension();
	}

	/**
	 * Returns the photo path of this persisted room.
	 *
	 * @return the photo path of this persisted room
	 */
	@Override
	public String getPhotoPath() {
		return model.getPhotoPath();
	}

	/**
	 * Returns the primary key of this persisted room.
	 *
	 * @return the primary key of this persisted room
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the room ID of this persisted room.
	 *
	 * @return the room ID of this persisted room
	 */
	@Override
	public long getRoomId() {
		return model.getRoomId();
	}

	/**
	 * Returns the user ID of this persisted room.
	 *
	 * @return the user ID of this persisted room
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this persisted room.
	 *
	 * @return the user name of this persisted room
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this persisted room.
	 *
	 * @return the user uuid of this persisted room
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this persisted room.
	 *
	 * @return the uuid of this persisted room
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the wifi password of this persisted room.
	 *
	 * @return the wifi password of this persisted room
	 */
	@Override
	public String getWifiPassword() {
		return model.getWifiPassword();
	}

	/**
	 * Returns the wifi security type of this persisted room.
	 *
	 * @return the wifi security type of this persisted room
	 */
	@Override
	public int getWifiSecurityType() {
		return model.getWifiSecurityType();
	}

	/**
	 * Returns the wifi ssid of this persisted room.
	 *
	 * @return the wifi ssid of this persisted room
	 */
	@Override
	public String getWifiSSID() {
		return model.getWifiSSID();
	}

	/**
	 * Returns <code>true</code> if this persisted room is available friday.
	 *
	 * @return <code>true</code> if this persisted room is available friday; <code>false</code> otherwise
	 */
	@Override
	public boolean isAvailableFriday() {
		return model.isAvailableFriday();
	}

	/**
	 * Returns <code>true</code> if this persisted room is available monday.
	 *
	 * @return <code>true</code> if this persisted room is available monday; <code>false</code> otherwise
	 */
	@Override
	public boolean isAvailableMonday() {
		return model.isAvailableMonday();
	}

	/**
	 * Returns <code>true</code> if this persisted room is available saturday.
	 *
	 * @return <code>true</code> if this persisted room is available saturday; <code>false</code> otherwise
	 */
	@Override
	public boolean isAvailableSaturday() {
		return model.isAvailableSaturday();
	}

	/**
	 * Returns <code>true</code> if this persisted room is available sunday.
	 *
	 * @return <code>true</code> if this persisted room is available sunday; <code>false</code> otherwise
	 */
	@Override
	public boolean isAvailableSunday() {
		return model.isAvailableSunday();
	}

	/**
	 * Returns <code>true</code> if this persisted room is available thursday.
	 *
	 * @return <code>true</code> if this persisted room is available thursday; <code>false</code> otherwise
	 */
	@Override
	public boolean isAvailableThursday() {
		return model.isAvailableThursday();
	}

	/**
	 * Returns <code>true</code> if this persisted room is available tuesday.
	 *
	 * @return <code>true</code> if this persisted room is available tuesday; <code>false</code> otherwise
	 */
	@Override
	public boolean isAvailableTuesday() {
		return model.isAvailableTuesday();
	}

	/**
	 * Returns <code>true</code> if this persisted room is available wednesday.
	 *
	 * @return <code>true</code> if this persisted room is available wednesday; <code>false</code> otherwise
	 */
	@Override
	public boolean isAvailableWednesday() {
		return model.isAvailableWednesday();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the available end time of this persisted room.
	 *
	 * @param availableEndTime the available end time of this persisted room
	 */
	@Override
	public void setAvailableEndTime(int availableEndTime) {
		model.setAvailableEndTime(availableEndTime);
	}

	/**
	 * Sets whether this persisted room is available friday.
	 *
	 * @param availableFriday the available friday of this persisted room
	 */
	@Override
	public void setAvailableFriday(boolean availableFriday) {
		model.setAvailableFriday(availableFriday);
	}

	/**
	 * Sets whether this persisted room is available monday.
	 *
	 * @param availableMonday the available monday of this persisted room
	 */
	@Override
	public void setAvailableMonday(boolean availableMonday) {
		model.setAvailableMonday(availableMonday);
	}

	/**
	 * Sets whether this persisted room is available saturday.
	 *
	 * @param availableSaturday the available saturday of this persisted room
	 */
	@Override
	public void setAvailableSaturday(boolean availableSaturday) {
		model.setAvailableSaturday(availableSaturday);
	}

	/**
	 * Sets the available start time of this persisted room.
	 *
	 * @param availableStartTime the available start time of this persisted room
	 */
	@Override
	public void setAvailableStartTime(int availableStartTime) {
		model.setAvailableStartTime(availableStartTime);
	}

	/**
	 * Sets whether this persisted room is available sunday.
	 *
	 * @param availableSunday the available sunday of this persisted room
	 */
	@Override
	public void setAvailableSunday(boolean availableSunday) {
		model.setAvailableSunday(availableSunday);
	}

	/**
	 * Sets whether this persisted room is available thursday.
	 *
	 * @param availableThursday the available thursday of this persisted room
	 */
	@Override
	public void setAvailableThursday(boolean availableThursday) {
		model.setAvailableThursday(availableThursday);
	}

	/**
	 * Sets whether this persisted room is available tuesday.
	 *
	 * @param availableTuesday the available tuesday of this persisted room
	 */
	@Override
	public void setAvailableTuesday(boolean availableTuesday) {
		model.setAvailableTuesday(availableTuesday);
	}

	/**
	 * Sets whether this persisted room is available wednesday.
	 *
	 * @param availableWednesday the available wednesday of this persisted room
	 */
	@Override
	public void setAvailableWednesday(boolean availableWednesday) {
		model.setAvailableWednesday(availableWednesday);
	}

	/**
	 * Sets the calendar ID of this persisted room.
	 *
	 * @param calendarId the calendar ID of this persisted room
	 */
	@Override
	public void setCalendarId(long calendarId) {
		model.setCalendarId(calendarId);
	}

	/**
	 * Sets the capacity people of this persisted room.
	 *
	 * @param capacityPeople the capacity people of this persisted room
	 */
	@Override
	public void setCapacityPeople(int capacityPeople) {
		model.setCapacityPeople(capacityPeople);
	}

	/**
	 * Sets the capacity square meters of this persisted room.
	 *
	 * @param capacitySquareMeters the capacity square meters of this persisted room
	 */
	@Override
	public void setCapacitySquareMeters(double capacitySquareMeters) {
		model.setCapacitySquareMeters(capacitySquareMeters);
	}

	/**
	 * Sets the company ID of this persisted room.
	 *
	 * @param companyId the company ID of this persisted room
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this persisted room.
	 *
	 * @param createDate the create date of this persisted room
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external reference code of this persisted room.
	 *
	 * @param externalReferenceCode the external reference code of this persisted room
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the modified date of this persisted room.
	 *
	 * @param modifiedDate the modified date of this persisted room
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this persisted room.
	 *
	 * @param name the name of this persisted room
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the office ID of this persisted room.
	 *
	 * @param officeId the office ID of this persisted room
	 */
	@Override
	public void setOfficeId(long officeId) {
		model.setOfficeId(officeId);
	}

	/**
	 * Sets the phone extension of this persisted room.
	 *
	 * @param phoneExtension the phone extension of this persisted room
	 */
	@Override
	public void setPhoneExtension(int phoneExtension) {
		model.setPhoneExtension(phoneExtension);
	}

	/**
	 * Sets the photo path of this persisted room.
	 *
	 * @param photoPath the photo path of this persisted room
	 */
	@Override
	public void setPhotoPath(String photoPath) {
		model.setPhotoPath(photoPath);
	}

	/**
	 * Sets the primary key of this persisted room.
	 *
	 * @param primaryKey the primary key of this persisted room
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the room ID of this persisted room.
	 *
	 * @param roomId the room ID of this persisted room
	 */
	@Override
	public void setRoomId(long roomId) {
		model.setRoomId(roomId);
	}

	/**
	 * Sets the user ID of this persisted room.
	 *
	 * @param userId the user ID of this persisted room
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this persisted room.
	 *
	 * @param userName the user name of this persisted room
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this persisted room.
	 *
	 * @param userUuid the user uuid of this persisted room
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this persisted room.
	 *
	 * @param uuid the uuid of this persisted room
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the wifi password of this persisted room.
	 *
	 * @param wifiPassword the wifi password of this persisted room
	 */
	@Override
	public void setWifiPassword(String wifiPassword) {
		model.setWifiPassword(wifiPassword);
	}

	/**
	 * Sets the wifi security type of this persisted room.
	 *
	 * @param wifiSecurityType the wifi security type of this persisted room
	 */
	@Override
	public void setWifiSecurityType(int wifiSecurityType) {
		model.setWifiSecurityType(wifiSecurityType);
	}

	/**
	 * Sets the wifi ssid of this persisted room.
	 *
	 * @param wifiSSID the wifi ssid of this persisted room
	 */
	@Override
	public void setWifiSSID(String wifiSSID) {
		model.setWifiSSID(wifiSSID);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected PersistedRoomWrapper wrap(PersistedRoom persistedRoom) {
		return new PersistedRoomWrapper(persistedRoom);
	}

}