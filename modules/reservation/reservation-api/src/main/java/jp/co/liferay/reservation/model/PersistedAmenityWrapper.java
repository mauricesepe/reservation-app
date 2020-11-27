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

/**
 * <p>
 * This class is a wrapper for {@link PersistedAmenity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PersistedAmenity
 * @generated
 */
public class PersistedAmenityWrapper
	extends BaseModelWrapper<PersistedAmenity>
	implements ModelWrapper<PersistedAmenity>, PersistedAmenity {

	public PersistedAmenityWrapper(PersistedAmenity persistedAmenity) {
		super(persistedAmenity);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("externalReferenceCode", getExternalReferenceCode());
		attributes.put("amenityId", getAmenityId());
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

		Long amenityId = (Long)attributes.get("amenityId");

		if (amenityId != null) {
			setAmenityId(amenityId);
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
	 * Returns the amenity ID of this persisted amenity.
	 *
	 * @return the amenity ID of this persisted amenity
	 */
	@Override
	public long getAmenityId() {
		return model.getAmenityId();
	}

	/**
	 * Returns the company ID of this persisted amenity.
	 *
	 * @return the company ID of this persisted amenity
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the external reference code of this persisted amenity.
	 *
	 * @return the external reference code of this persisted amenity
	 */
	@Override
	public String getExternalReferenceCode() {
		return model.getExternalReferenceCode();
	}

	/**
	 * Returns the name of this persisted amenity.
	 *
	 * @return the name of this persisted amenity
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this persisted amenity.
	 *
	 * @return the primary key of this persisted amenity
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this persisted amenity.
	 *
	 * @return the uuid of this persisted amenity
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
	 * Sets the amenity ID of this persisted amenity.
	 *
	 * @param amenityId the amenity ID of this persisted amenity
	 */
	@Override
	public void setAmenityId(long amenityId) {
		model.setAmenityId(amenityId);
	}

	/**
	 * Sets the company ID of this persisted amenity.
	 *
	 * @param companyId the company ID of this persisted amenity
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the external reference code of this persisted amenity.
	 *
	 * @param externalReferenceCode the external reference code of this persisted amenity
	 */
	@Override
	public void setExternalReferenceCode(String externalReferenceCode) {
		model.setExternalReferenceCode(externalReferenceCode);
	}

	/**
	 * Sets the name of this persisted amenity.
	 *
	 * @param name the name of this persisted amenity
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this persisted amenity.
	 *
	 * @param primaryKey the primary key of this persisted amenity
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this persisted amenity.
	 *
	 * @param uuid the uuid of this persisted amenity
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected PersistedAmenityWrapper wrap(PersistedAmenity persistedAmenity) {
		return new PersistedAmenityWrapper(persistedAmenity);
	}

}