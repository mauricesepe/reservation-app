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

import jp.co.liferay.reservation.model.PersistedAmenity;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing PersistedAmenity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class PersistedAmenityCacheModel
	implements CacheModel<PersistedAmenity>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PersistedAmenityCacheModel)) {
			return false;
		}

		PersistedAmenityCacheModel persistedAmenityCacheModel =
			(PersistedAmenityCacheModel)obj;

		if (amenityId == persistedAmenityCacheModel.amenityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, amenityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", externalReferenceCode=");
		sb.append(externalReferenceCode);
		sb.append(", amenityId=");
		sb.append(amenityId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PersistedAmenity toEntityModel() {
		PersistedAmenityImpl persistedAmenityImpl = new PersistedAmenityImpl();

		if (uuid == null) {
			persistedAmenityImpl.setUuid("");
		}
		else {
			persistedAmenityImpl.setUuid(uuid);
		}

		if (externalReferenceCode == null) {
			persistedAmenityImpl.setExternalReferenceCode("");
		}
		else {
			persistedAmenityImpl.setExternalReferenceCode(
				externalReferenceCode);
		}

		persistedAmenityImpl.setAmenityId(amenityId);

		if (name == null) {
			persistedAmenityImpl.setName("");
		}
		else {
			persistedAmenityImpl.setName(name);
		}

		persistedAmenityImpl.setCompanyId(companyId);

		persistedAmenityImpl.resetOriginalValues();

		return persistedAmenityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		externalReferenceCode = objectInput.readUTF();

		amenityId = objectInput.readLong();
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

		objectOutput.writeLong(amenityId);

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
	public long amenityId;
	public String name;
	public long companyId;

}