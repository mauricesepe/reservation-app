package jp.co.liferay.headless.reservation.client.dto.v1_0;

import java.util.Objects;

import javax.annotation.Generated;

import jp.co.liferay.headless.reservation.client.function.UnsafeSupplier;
import jp.co.liferay.headless.reservation.client.serdes.v1_0.PurposeSerDes;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
public class Purpose {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	public Long getPurposeId() {
		return purposeId;
	}

	public void setPurposeId(Long purposeId) {
		this.purposeId = purposeId;
	}

	public void setPurposeId(
		UnsafeSupplier<Long, Exception> purposeIdUnsafeSupplier) {

		try {
			purposeId = purposeIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long purposeId;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Purpose)) {
			return false;
		}

		Purpose purpose = (Purpose)object;

		return Objects.equals(toString(), purpose.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return PurposeSerDes.toJSON(this);
	}

}