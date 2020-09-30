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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link PersistedPurpose}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedPurpose
 * @generated
 */
@ProviderType
public class PersistedPurposeWrapper
	extends BaseModelWrapper<PersistedPurpose>
	implements PersistedPurpose, ModelWrapper<PersistedPurpose> {

	public PersistedPurposeWrapper(PersistedPurpose persistedPurpose) {
		super(persistedPurpose);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("purposeId", getPurposeId());
		attributes.put("name", getName());
		attributes.put("companyId", getCompanyId());

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

		Long purposeId = (Long)attributes.get("purposeId");

		if (purposeId != null) {
			setPurposeId(purposeId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}
	}

	/**
	 * Returns the company ID of this persisted purpose.
	 *
	 * @return the company ID of this persisted purpose
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the external reference code of this persisted purpose.
	 *
	 * @return the external reference code of this persisted purpose
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the name of this persisted purpose.
	 *
	 * @return the name of this persisted purpose
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this persisted purpose.
	 *
	 * @return the primary key of this persisted purpose
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the purpose ID of this persisted purpose.
	 *
	 * @return the purpose ID of this persisted purpose
	 */
	@Override
	public long getPurposeId() {
		return model.getPurposeId();
	}

	/**
	 * Returns the uuid of this persisted purpose.
	 *
	 * @return the uuid of this persisted purpose
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
	 * Sets the company ID of this persisted purpose.
	 *
	 * @param companyId the company ID of this persisted purpose
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the external reference code of this persisted purpose.
	 *
	 * @param externalReferenceCode the external reference code of this persisted purpose
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the name of this persisted purpose.
	 *
	 * @param name the name of this persisted purpose
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this persisted purpose.
	 *
	 * @param primaryKey the primary key of this persisted purpose
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the purpose ID of this persisted purpose.
	 *
	 * @param purposeId the purpose ID of this persisted purpose
	 */
	@Override
	public void setPurposeId(long purposeId) {
		model.setPurposeId(purposeId);
	}

	/**
	 * Sets the uuid of this persisted purpose.
	 *
	 * @param uuid the uuid of this persisted purpose
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected PersistedPurposeWrapper wrap(PersistedPurpose persistedPurpose) {
		return new PersistedPurposeWrapper(persistedPurpose);
	}

}