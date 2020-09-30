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

import jp.co.liferay.reservation.model.PersistedPurpose;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing PersistedPurpose in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PersistedPurposeCacheModel
	implements CacheModel<PersistedPurpose>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PersistedPurposeCacheModel)) {
			return false;
		}

		PersistedPurposeCacheModel persistedPurposeCacheModel =
			(PersistedPurposeCacheModel)obj;

		if (purposeId == persistedPurposeCacheModel.purposeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, purposeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", purposeId=");
		sb.append(purposeId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PersistedPurpose toEntityModel() {
		PersistedPurposeImpl persistedPurposeImpl = new PersistedPurposeImpl();

		if (uuid == null) {
			persistedPurposeImpl.setUuid("");
		}
		else {
			persistedPurposeImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			persistedPurposeImpl.setExternalReferenceCode("");
		}
		else {
			persistedPurposeImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		persistedPurposeImpl.setPurposeId(purposeId);

		if (name == null) {
			persistedPurposeImpl.setName("");
		}
		else {
			persistedPurposeImpl.setName(name);
		}

		persistedPurposeImpl.setCompanyId(companyId);

		persistedPurposeImpl.resetOriginalValues();

		return persistedPurposeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		purposeId = objectInput.readLong();
		name = objectInput.readUTF();

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

		objectOutput.writeLong(purposeId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(companyId);
	}

	public String uuid;
	public String externalReferenceCode;
	public long purposeId;
	public String name;
	public long companyId;

}