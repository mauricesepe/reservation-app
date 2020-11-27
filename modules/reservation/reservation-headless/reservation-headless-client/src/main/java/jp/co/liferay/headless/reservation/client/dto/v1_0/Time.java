package jp.co.liferay.headless.reservation.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import jp.co.liferay.headless.reservation.client.function.UnsafeSupplier;
import jp.co.liferay.headless.reservation.client.serdes.v1_0.TimeSerDes;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
public class Time implements Cloneable, Serializable {

	public static Time toDTO(String json) {
		return TimeSerDes.toDTO(json);
	}

	public String getAmpm() {
		return ampm;
	}

	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}

	public void setAmpm(UnsafeSupplier<String, Exception> ampmUnsafeSupplier) {
		try {
			ampm = ampmUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String ampm;

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public void setHours(
		UnsafeSupplier<String, Exception> hoursUnsafeSupplier) {

		try {
			hours = hoursUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String hours;

	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	public void setMinutes(
		UnsafeSupplier<String, Exception> minutesUnsafeSupplier) {

		try {
			minutes = minutesUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String minutes;

	@Override
	public Time clone() throws CloneNotSupportedException {
		return (Time)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Time)) {
			return false;
		}

		Time time = (Time)object;

		return Objects.equals(toString(), time.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return TimeSerDes.toJSON(this);
	}

}