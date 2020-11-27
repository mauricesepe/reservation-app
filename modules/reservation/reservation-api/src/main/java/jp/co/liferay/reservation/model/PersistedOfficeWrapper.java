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
 * This class is a wrapper for {@link PersistedOffice}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedOffice
 * @generated
 */
public class PersistedOfficeWrapper
	extends BaseModelWrapper<PersistedOffice>
	implements ModelWrapper<PersistedOffice>, PersistedOffice {

	public PersistedOfficeWrapper(PersistedOffice persistedOffice) {
		super(persistedOffice);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("officeId", getOfficeId());
		attributes.put("calendarResourceId", getCalendarResourceId());
		attributes.put("name", getName());
		attributes.put("location", getLocation());
		attributes.put("roomCount", getRoomCount());
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

		Long officeId = (Long)attributes.get("officeId");

		if (officeId != null) {
			setOfficeId(officeId);
		}

		Long calendarResourceId = (Long)attributes.get("calendarResourceId");

		if (calendarResourceId != null) {
			setCalendarResourceId(calendarResourceId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		Integer roomCount = (Integer)attributes.get("roomCount");

		if (roomCount != null) {
			setRoomCount(roomCount);
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
	 * Returns the calendar resource ID of this persisted office.
	 *
	 * @return the calendar resource ID of this persisted office
	 */
	@Override
	public long getCalendarResourceId() {
		return model.getCalendarResourceId();
	}

	/**
	 * Returns the company ID of this persisted office.
	 *
	 * @return the company ID of this persisted office
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this persisted office.
	 *
	 * @return the create date of this persisted office
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the external reference code of this persisted office.
	 *
	 * @return the external reference code of this persisted office
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the location of this persisted office.
	 *
	 * @return the location of this persisted office
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the modified date of this persisted office.
	 *
	 * @return the modified date of this persisted office
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this persisted office.
	 *
	 * @return the name of this persisted office
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the office ID of this persisted office.
	 *
	 * @return the office ID of this persisted office
	 */
	@Override
	public long getOfficeId() {
		return model.getOfficeId();
	}

	/**
	 * Returns the primary key of this persisted office.
	 *
	 * @return the primary key of this persisted office
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the room count of this persisted office.
	 *
	 * @return the room count of this persisted office
	 */
	@Override
	public int getRoomCount() {
		return model.getRoomCount();
	}

	/**
	 * Returns the user ID of this persisted office.
	 *
	 * @return the user ID of this persisted office
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this persisted office.
	 *
	 * @return the user name of this persisted office
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this persisted office.
	 *
	 * @return the user uuid of this persisted office
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this persisted office.
	 *
	 * @return the uuid of this persisted office
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
	 * Sets the calendar resource ID of this persisted office.
	 *
	 * @param calendarResourceId the calendar resource ID of this persisted office
	 */
	@Override
	public void setCalendarResourceId(long calendarResourceId) {
		model.setCalendarResourceId(calendarResourceId);
	}

	/**
	 * Sets the company ID of this persisted office.
	 *
	 * @param companyId the company ID of this persisted office
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this persisted office.
	 *
	 * @param createDate the create date of this persisted office
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the external reference code of this persisted office.
	 *
	 * @param externalReferenceCode the external reference code of this persisted office
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the location of this persisted office.
	 *
	 * @param location the location of this persisted office
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the modified date of this persisted office.
	 *
	 * @param modifiedDate the modified date of this persisted office
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this persisted office.
	 *
	 * @param name the name of this persisted office
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the office ID of this persisted office.
	 *
	 * @param officeId the office ID of this persisted office
	 */
	@Override
	public void setOfficeId(long officeId) {
		model.setOfficeId(officeId);
	}

	/**
	 * Sets the primary key of this persisted office.
	 *
	 * @param primaryKey the primary key of this persisted office
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the room count of this persisted office.
	 *
	 * @param roomCount the room count of this persisted office
	 */
	@Override
	public void setRoomCount(int roomCount) {
		model.setRoomCount(roomCount);
	}

	/**
	 * Sets the user ID of this persisted office.
	 *
	 * @param userId the user ID of this persisted office
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this persisted office.
	 *
	 * @param userName the user name of this persisted office
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this persisted office.
	 *
	 * @param userUuid the user uuid of this persisted office
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this persisted office.
	 *
	 * @param uuid the uuid of this persisted office
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected PersistedOfficeWrapper wrap(PersistedOffice persistedOffice) {
		return new PersistedOfficeWrapper(persistedOffice);
	}

}