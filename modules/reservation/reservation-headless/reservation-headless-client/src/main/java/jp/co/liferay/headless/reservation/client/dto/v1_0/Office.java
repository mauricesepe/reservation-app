package jp.co.liferay.headless.reservation.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import jp.co.liferay.headless.reservation.client.function.UnsafeSupplier;
import jp.co.liferay.headless.reservation.client.serdes.v1_0.OfficeSerDes;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
public class Office implements Cloneable, Serializable {

	public static Office toDTO(String json) {
		return OfficeSerDes.toDTO(json);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setLocation(
		UnsafeSupplier<String, Exception> locationUnsafeSupplier) {

		try {
			location = locationUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String location;

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

	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	public void setOfficeId(
		UnsafeSupplier<Long, Exception> officeIdUnsafeSupplier) {

		try {
			officeId = officeIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long officeId;

	@Override
	public Office clone() throws CloneNotSupportedException {
		return (Office)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Office)) {
			return false;
		}

		Office office = (Office)object;

		return Objects.equals(toString(), office.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return OfficeSerDes.toJSON(this);
	}

}