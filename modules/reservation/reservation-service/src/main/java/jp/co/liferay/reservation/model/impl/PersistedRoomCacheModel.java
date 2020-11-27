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

import jp.co.liferay.reservation.model.PersistedRoom;

/**
 * The cache model class for representing PersistedRoom in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersistedRoomCacheModel
	implements CacheModel<PersistedRoom>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PersistedRoomCacheModel)) {
			return false;
		}

		PersistedRoomCacheModel persistedRoomCacheModel =
			(PersistedRoomCacheModel)object;

		if (roomId == persistedRoomCacheModel.roomId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, roomId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", roomId=");
		sb.append(roomId);
		sb.append(", calendarId=");
		sb.append(calendarId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", photoPath=");
		sb.append(photoPath);
		sb.append(", availableMonday=");
		sb.append(availableMonday);
		sb.append(", availableTuesday=");
		sb.append(availableTuesday);
		sb.append(", availableWednesday=");
		sb.append(availableWednesday);
		sb.append(", availableThursday=");
		sb.append(availableThursday);
		sb.append(", availableFriday=");
		sb.append(availableFriday);
		sb.append(", availableSaturday=");
		sb.append(availableSaturday);
		sb.append(", availableSunday=");
		sb.append(availableSunday);
		sb.append(", availableStartTime=");
		sb.append(availableStartTime);
		sb.append(", availableEndTime=");
		sb.append(availableEndTime);
		sb.append(", officeId=");
		sb.append(officeId);
		sb.append(", capacitySquareMeters=");
		sb.append(capacitySquareMeters);
		sb.append(", capacityPeople=");
		sb.append(capacityPeople);
		sb.append(", phoneExtension=");
		sb.append(phoneExtension);
		sb.append(", wifiSSID=");
		sb.append(wifiSSID);
		sb.append(", wifiSecurityType=");
		sb.append(wifiSecurityType);
		sb.append(", wifiPassword=");
		sb.append(wifiPassword);
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
	public PersistedRoom toEntityModel() {
		PersistedRoomImpl persistedRoomImpl = new PersistedRoomImpl();

		if (uuid == null) {
			persistedRoomImpl.setUuid("");
		}
		else {
			persistedRoomImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			persistedRoomImpl.setExternalReferenceCode("");
		}
		else {
			persistedRoomImpl.setExternalReferenceCode(externalReferenceCode);
		}

		persistedRoomImpl.setRoomId(roomId);
		persistedRoomImpl.setCalendarId(calendarId);

		if (name == null) {
			persistedRoomImpl.setName("");
		}
		else {
			persistedRoomImpl.setName(name);
		}

		if (photoPath == null) {
			persistedRoomImpl.setPhotoPath("");
		}
		else {
			persistedRoomImpl.setPhotoPath(photoPath);
		}

		persistedRoomImpl.setAvailableMonday(availableMonday);
		persistedRoomImpl.setAvailableTuesday(availableTuesday);
		persistedRoomImpl.setAvailableWednesday(availableWednesday);
		persistedRoomImpl.setAvailableThursday(availableThursday);
		persistedRoomImpl.setAvailableFriday(availableFriday);
		persistedRoomImpl.setAvailableSaturday(availableSaturday);
		persistedRoomImpl.setAvailableSunday(availableSunday);
		persistedRoomImpl.setAvailableStartTime(availableStartTime);
		persistedRoomImpl.setAvailableEndTime(availableEndTime);
		persistedRoomImpl.setOfficeId(officeId);
		persistedRoomImpl.setCapacitySquareMeters(capacitySquareMeters);
		persistedRoomImpl.setCapacityPeople(capacityPeople);
		persistedRoomImpl.setPhoneExtension(phoneExtension);

		if (wifiSSID == null) {
			persistedRoomImpl.setWifiSSID("");
		}
		else {
			persistedRoomImpl.setWifiSSID(wifiSSID);
		}

		persistedRoomImpl.setWifiSecurityType(wifiSecurityType);

		if (wifiPassword == null) {
			persistedRoomImpl.setWifiPassword("");
		}
		else {
			persistedRoomImpl.setWifiPassword(wifiPassword);
		}

		persistedRoomImpl.setCompanyId(companyId);
		persistedRoomImpl.setUserId(userId);

		if (userName == null) {
			persistedRoomImpl.setUserName("");
		}
		else {
			persistedRoomImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			persistedRoomImpl.setCreateDate(null);
		}
		else {
			persistedRoomImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			persistedRoomImpl.setModifiedDate(null);
		}
		else {
			persistedRoomImpl.setModifiedDate(new Date(modifiedDate));
		}

		persistedRoomImpl.resetOriginalValues();

		return persistedRoomImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		roomId = objectInput.readLong();

		calendarId = objectInput.readLong();
		name = objectInput.readUTF();
		photoPath = objectInput.readUTF();

		availableMonday = objectInput.readBoolean();

		availableTuesday = objectInput.readBoolean();

		availableWednesday = objectInput.readBoolean();

		availableThursday = objectInput.readBoolean();

		availableFriday = objectInput.readBoolean();

		availableSaturday = objectInput.readBoolean();

		availableSunday = objectInput.readBoolean();

		availableStartTime = objectInput.readInt();

		availableEndTime = objectInput.readInt();

		officeId = objectInput.readLong();

		capacitySquareMeters = objectInput.readDouble();

		capacityPeople = objectInput.readInt();

		phoneExtension = objectInput.readInt();
		wifiSSID = objectInput.readUTF();

		wifiSecurityType = objectInput.readInt();
		wifiPassword = objectInput.readUTF();

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

		objectOutput.writeLong(roomId);

		objectOutput.writeLong(calendarId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (photoPath == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(photoPath);
		}

		objectOutput.writeBoolean(availableMonday);

		objectOutput.writeBoolean(availableTuesday);

		objectOutput.writeBoolean(availableWednesday);

		objectOutput.writeBoolean(availableThursday);

		objectOutput.writeBoolean(availableFriday);

		objectOutput.writeBoolean(availableSaturday);

		objectOutput.writeBoolean(availableSunday);

		objectOutput.writeInt(availableStartTime);

		objectOutput.writeInt(availableEndTime);

		objectOutput.writeLong(officeId);

		objectOutput.writeDouble(capacitySquareMeters);

		objectOutput.writeInt(capacityPeople);

		objectOutput.writeInt(phoneExtension);

		if (wifiSSID == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(wifiSSID);
		}

		objectOutput.writeInt(wifiSecurityType);

		if (wifiPassword == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(wifiPassword);
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
	public long roomId;
	public long calendarId;
	public String name;
	public String photoPath;
	public boolean availableMonday;
	public boolean availableTuesday;
	public boolean availableWednesday;
	public boolean availableThursday;
	public boolean availableFriday;
	public boolean availableSaturday;
	public boolean availableSunday;
	public int availableStartTime;
	public int availableEndTime;
	public long officeId;
	public double capacitySquareMeters;
	public int capacityPeople;
	public int phoneExtension;
	public String wifiSSID;
	public int wifiSecurityType;
	public String wifiPassword;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;

}