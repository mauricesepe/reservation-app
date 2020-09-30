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

package jp.co.liferay.reservation.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import jp.co.liferay.reservation.model.PersistedBooking;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing PersistedBooking in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PersistedBookingCacheModel
	implements CacheModel<PersistedBooking>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PersistedBookingCacheModel)) {
			return false;
		}

		PersistedBookingCacheModel persistedBookingCacheModel =
			(PersistedBookingCacheModel)obj;

		if (bookingId == persistedBookingCacheModel.bookingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bookingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", bookingId=");
		sb.append(bookingId);
		sb.append(", calendarBookingId=");
		sb.append(calendarBookingId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", roomId=");
		sb.append(roomId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PersistedBooking toEntityModel() {
		PersistedBookingImpl persistedBookingImpl = new PersistedBookingImpl();

		if (uuid == null) {
			persistedBookingImpl.setUuid("");
		}
		else {
			persistedBookingImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			persistedBookingImpl.setExternalReferenceCode("");
		}
		else {
			persistedBookingImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		persistedBookingImpl.setBookingId(bookingId);
		persistedBookingImpl.setCalendarBookingId(calendarBookingId);

		if (title == null) {
			persistedBookingImpl.setTitle("");
		}
		else {
			persistedBookingImpl.setTitle(title);
		}

		if (startDate == Long.MIN_VALUE) {
			persistedBookingImpl.setStartDate(null);
		}
		else {
			persistedBookingImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			persistedBookingImpl.setEndDate(null);
		}
		else {
			persistedBookingImpl.setEndDate(new Date(endDate));
		}

		persistedBookingImpl.setRoomId(roomId);

		if (description == null) {
			persistedBookingImpl.setDescription("");
		}
		else {
			persistedBookingImpl.setDescription(description);
		}

		persistedBookingImpl.setCompanyId(companyId);
		persistedBookingImpl.setUserId(userId);

		if (userName == null) {
			persistedBookingImpl.setUserName("");
		}
		else {
			persistedBookingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			persistedBookingImpl.setCreateDate(null);
		}
		else {
			persistedBookingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			persistedBookingImpl.setModifiedDate(null);
		}
		else {
			persistedBookingImpl.setModifiedDate(new Date(modifiedDate));
		}

		persistedBookingImpl.resetOriginalValues();

		return persistedBookingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		bookingId = objectInput.readLong();

		calendarBookingId = objectInput.readLong();
		title = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();

		roomId = objectInput.readLong();
		description = objectInput.readUTF();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (externalReferenceCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalReferenceCode);
		}

		objectOutput.writeLong(bookingId);

		objectOutput.writeLong(calendarBookingId);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		objectOutput.writeLong(roomId);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public String externalReferenceCode;
	public long bookingId;
	public long calendarBookingId;
	public String title;
	public long startDate;
	public long endDate;
	public long roomId;
	public String description;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}