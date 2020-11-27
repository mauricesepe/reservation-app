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

import jp.co.liferay.reservation.model.PersistedOffice;

/**
 * The cache model class for representing PersistedOffice in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersistedOfficeCacheModel
	implements CacheModel<PersistedOffice>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PersistedOfficeCacheModel)) {
			return false;
		}

		PersistedOfficeCacheModel persistedOfficeCacheModel =
			(PersistedOfficeCacheModel)object;

		if (officeId == persistedOfficeCacheModel.officeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, officeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", officeId=");
		sb.append(officeId);
		sb.append(", calendarResourceId=");
		sb.append(calendarResourceId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", location=");
		sb.append(location);
		sb.append(", roomCount=");
		sb.append(roomCount);
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
	public PersistedOffice toEntityModel() {
		PersistedOfficeImpl persistedOfficeImpl = new PersistedOfficeImpl();

		if (uuid == null) {
			persistedOfficeImpl.setUuid("");
		}
		else {
			persistedOfficeImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			persistedOfficeImpl.setExternalReferenceCode("");
		}
		else {
			persistedOfficeImpl.setExternalReferenceCode(externalReferenceCode);
		}

		persistedOfficeImpl.setOfficeId(officeId);
		persistedOfficeImpl.setCalendarResourceId(calendarResourceId);

		if (name == null) {
			persistedOfficeImpl.setName("");
		}
		else {
			persistedOfficeImpl.setName(name);
		}

		if (location == null) {
			persistedOfficeImpl.setLocation("");
		}
		else {
			persistedOfficeImpl.setLocation(location);
		}

		persistedOfficeImpl.setRoomCount(roomCount);
		persistedOfficeImpl.setCompanyId(companyId);
		persistedOfficeImpl.setUserId(userId);

		if (userName == null) {
			persistedOfficeImpl.setUserName("");
		}
		else {
			persistedOfficeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			persistedOfficeImpl.setCreateDate(null);
		}
		else {
			persistedOfficeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			persistedOfficeImpl.setModifiedDate(null);
		}
		else {
			persistedOfficeImpl.setModifiedDate(new Date(modifiedDate));
		}

		persistedOfficeImpl.resetOriginalValues();

		return persistedOfficeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		officeId = objectInput.readLong();

		calendarResourceId = objectInput.readLong();
		name = objectInput.readUTF();
		location = objectInput.readUTF();

		roomCount = objectInput.readInt();

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

		objectOutput.writeLong(officeId);

		objectOutput.writeLong(calendarResourceId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}

		objectOutput.writeInt(roomCount);

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
	public long officeId;
	public long calendarResourceId;
	public String name;
	public String location;
	public int roomCount;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}