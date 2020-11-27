package jp.co.liferay.headless.reservation.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import jp.co.liferay.headless.reservation.client.function.UnsafeSupplier;
import jp.co.liferay.headless.reservation.client.serdes.v1_0.AmenitySerDes;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
public class Amenity implements Cloneable, Serializable {

	public static Amenity toDTO(String json) {
		return AmenitySerDes.toDTO(json);
	}

	public Long getAmenityId() {
		return amenityId;
	}

	public void setAmenityId(Long amenityId) {
		this.amenityId = amenityId;
	}

	public void setAmenityId(
		UnsafeSupplier<Long, Exception> amenityIdUnsafeSupplier) {

		try {
			amenityId = amenityIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long amenityId;

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

	@Override
	public Amenity clone() throws CloneNotSupportedException {
		return (Amenity)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Amenity)) {
			return false;
		}

		Amenity amenity = (Amenity)object;

		return Objects.equals(toString(), amenity.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return AmenitySerDes.toJSON(this);
	}

}