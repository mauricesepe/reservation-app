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

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link PersistedBooking}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedBooking
 * @generated
 */
@ProviderType
public class PersistedBookingWrapper
	extends BaseModelWrapper<PersistedBooking>
	implements PersistedBooking, ModelWrapper<PersistedBooking> {

	public PersistedBookingWrapper(PersistedBooking persistedBooking) {
		super(persistedBooking);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("bookingId", getBookingId());
		attributes.put("calendarBookingId", getCalendarBookingId());
		attributes.put("title", getTitle());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("roomId", getRoomId());
		attributes.put("description", getDescription());
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

		Long bookingId = (Long)attributes.get("bookingId");

		if (bookingId != null) {
			setBookingId(bookingId);
		}

		Long calendarBookingId = (Long)attributes.get("calendarBookingId");

		if (calendarBookingId != null) {
			setCalendarBookingId(calendarBookingId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long roomId = (Long)attributes.get("roomId");

		if (roomId != null) {
			setRoomId(roomId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	 * Returns the booking ID of this persisted booking.
	 *
	 * @return the booking ID of this persisted booking
	 */
	@Override
	public long getBookingId() {
		return model.getBookingId();
	}

	/**
	 * Returns the calendar booking ID of this persisted booking.
	 *
	 * @return the calendar booking ID of this persisted booking
	 */
	@Override
	public long getCalendarBookingId() {
		return model.getCalendarBookingId();
	}

	/**
	 * Returns the company ID of this persisted booking.
	 *
	 * @return the company ID of this persisted booking
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this persisted booking.
	 *
	 * @return the create date of this persisted booking
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this persisted booking.
	 *
	 * @return the description of this persisted booking
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the end date of this persisted booking.
	 *
	 * @return the end date of this persisted booking
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the external reference code of this persisted booking.
	 *
	 * @return the external reference code of this persisted booking
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the modified date of this persisted booking.
	 *
	 * @return the modified date of this persisted booking
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this persisted booking.
	 *
	 * @return the primary key of this persisted booking
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the room ID of this persisted booking.
	 *
	 * @return the room ID of this persisted booking
	 */
	@Override
	public long getRoomId() {
		return model.getRoomId();
	}

	/**
	 * Returns the start date of this persisted booking.
	 *
	 * @return the start date of this persisted booking
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the title of this persisted booking.
	 *
	 * @return the title of this persisted booking
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this persisted booking.
	 *
	 * @return the user ID of this persisted booking
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this persisted booking.
	 *
	 * @return the user name of this persisted booking
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this persisted booking.
	 *
	 * @return the user uuid of this persisted booking
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this persisted booking.
	 *
	 * @return the uuid of this persisted booking
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
	 * Sets the booking ID of this persisted booking.
	 *
	 * @param bookingId the booking ID of this persisted booking
	 */
	@Override
	public void setBookingId(long bookingId) {
		model.setBookingId(bookingId);
	}

	/**
	 * Sets the calendar booking ID of this persisted booking.
	 *
	 * @param calendarBookingId the calendar booking ID of this persisted booking
	 */
	@Override
	public void setCalendarBookingId(long calendarBookingId) {
		model.setCalendarBookingId(calendarBookingId);
	}

	/**
	 * Sets the company ID of this persisted booking.
	 *
	 * @param companyId the company ID of this persisted booking
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this persisted booking.
	 *
	 * @param createDate the create date of this persisted booking
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this persisted booking.
	 *
	 * @param description the description of this persisted booking
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the end date of this persisted booking.
	 *
	 * @param endDate the end date of this persisted booking
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the external reference code of this persisted booking.
	 *
	 * @param externalReferenceCode the external reference code of this persisted booking
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the modified date of this persisted booking.
	 *
	 * @param modifiedDate the modified date of this persisted booking
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this persisted booking.
	 *
	 * @param primaryKey the primary key of this persisted booking
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the room ID of this persisted booking.
	 *
	 * @param roomId the room ID of this persisted booking
	 */
	@Override
	public void setRoomId(long roomId) {
		model.setRoomId(roomId);
	}

	/**
	 * Sets the start date of this persisted booking.
	 *
	 * @param startDate the start date of this persisted booking
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the title of this persisted booking.
	 *
	 * @param title the title of this persisted booking
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this persisted booking.
	 *
	 * @param userId the user ID of this persisted booking
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this persisted booking.
	 *
	 * @param userName the user name of this persisted booking
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this persisted booking.
	 *
	 * @param userUuid the user uuid of this persisted booking
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this persisted booking.
	 *
	 * @param uuid the uuid of this persisted booking
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
	protected PersistedBookingWrapper wrap(PersistedBooking persistedBooking) {
		return new PersistedBookingWrapper(persistedBooking);
	}

}