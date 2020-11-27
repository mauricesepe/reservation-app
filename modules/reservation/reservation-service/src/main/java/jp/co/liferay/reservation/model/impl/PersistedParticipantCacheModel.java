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

import jp.co.liferay.reservation.model.PersistedParticipant;

/**
 * The cache model class for representing PersistedParticipant in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PersistedParticipantCacheModel
	implements CacheModel<PersistedParticipant>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PersistedParticipantCacheModel)) {
			return false;
		}

		PersistedParticipantCacheModel persistedParticipantCacheModel =
			(PersistedParticipantCacheModel)object;

		if (participantId == persistedParticipantCacheModel.participantId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, participantId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", participantId=");
		sb.append(participantId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", fullName=");
		sb.append(fullName);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PersistedParticipant toEntityModel() {
		PersistedParticipantImpl persistedParticipantImpl =
			new PersistedParticipantImpl();

		if (uuid == null) {
			persistedParticipantImpl.setUuid("");
		}
		else {
			persistedParticipantImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			persistedParticipantImpl.setExternalReferenceCode("");
		}
		else {
			persistedParticipantImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		persistedParticipantImpl.setParticipantId(participantId);
		persistedParticipantImpl.setUserId(userId);

		if (fullName == null) {
			persistedParticipantImpl.setFullName("");
		}
		else {
			persistedParticipantImpl.setFullName(fullName);
		}

		if (companyName == null) {
			persistedParticipantImpl.setCompanyName("");
		}
		else {
			persistedParticipantImpl.setCompanyName(companyName);
		}

		if (emailAddress == null) {
			persistedParticipantImpl.setEmailAddress("");
		}
		else {
			persistedParticipantImpl.setEmailAddress(emailAddress);
		}

		persistedParticipantImpl.setCompanyId(companyId);

		persistedParticipantImpl.resetOriginalValues();

		return persistedParticipantImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		participantId = objectInput.readLong();

		userId = objectInput.readLong();
		fullName = objectInput.readUTF();
		companyName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();

		companyId = objectInput.readLong();
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

		objectOutput.writeLong(participantId);

		objectOutput.writeLong(userId);

		if (fullName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fullName);
		}

		if (companyName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(companyName);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeLong(companyId);
	}

	public String uuid;
	public String externalReferenceCode;
	public long participantId;
	public long userId;
	public String fullName;
	public String companyName;
	public String emailAddress;
	public long companyId;

}