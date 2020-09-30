package jp.co.liferay.headless.reservation.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLName;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.constraints.NotEmpty;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
@GraphQLName("Time")
@JsonFilter("Liferay.Vulcan")
@Schema(requiredProperties = {"hours", "minutes", "ampm"})
@XmlRootElement(name = "Time")
public class Time {

	@Schema
	public String getAmpm() {
		return ampm;
	}

	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}

	@JsonIgnore
	public void setAmpm(UnsafeSupplier<String, Exception> ampmUnsafeSupplier) {
		try {
			ampm = ampmUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotEmpty
	protected String ampm;

	@Schema
	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	@JsonIgnore
	public void setHours(
		UnsafeSupplier<String, Exception> hoursUnsafeSupplier) {

		try {
			hours = hoursUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotEmpty
	protected String hours;

	@Schema
	public String getMinutes() {
		return minutes;
	}

	public void setMinutes(String minutes) {
		this.minutes = minutes;
	}

	@JsonIgnore
	public void setMinutes(
		UnsafeSupplier<String, Exception> minutesUnsafeSupplier) {

		try {
			minutes = minutesUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotEmpty
	protected String minutes;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (ampm != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ampm\": ");

			sb.append("\"");

			sb.append(_escape(ampm));

			sb.append("\"");
		}

		if (hours != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"hours\": ");

			sb.append("\"");

			sb.append(_escape(hours));

			sb.append("\"");
		}

		if (minutes != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"minutes\": ");

			sb.append("\"");

			sb.append(_escape(minutes));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":");
			sb.append("\"");
			sb.append(entry.getValue());
			sb.append("\"");

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}