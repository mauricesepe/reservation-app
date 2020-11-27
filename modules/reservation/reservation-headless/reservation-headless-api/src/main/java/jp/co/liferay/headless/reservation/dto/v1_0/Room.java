package jp.co.liferay.headless.reservation.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
@GraphQLName("Room")
@JsonFilter("Liferay.Vulcan")
@Schema(
	requiredProperties = {
		"name", "photoPath", "availableMonday", "availableTuesday",
		"availableWednesday", "availableThursday", "availableFriday",
		"availableSaturday", "availableSunday", "availableStartTime",
		"availableEndTime", "officeId", "capacitySquareMeters",
		"capacityPeople", "phoneExtensions", "wifiSSID", "wifiSecurityType",
		"wifiPassword"
	},
	description = "Contains all of the data for a single Room."
)
@XmlRootElement(name = "Room")
public class Room implements Serializable {

	public static Room toDTO(String json) {
		return ObjectMapperUtil.readValue(Room.class, json);
	}

	@Schema(description = "Primary keys of the amenities for this room.")
	public Long[] getAmenityIds() {
		return amenityIds;
	}

	public void setAmenityIds(Long[] amenityIds) {
		this.amenityIds = amenityIds;
	}

	@JsonIgnore
	public void setAmenityIds(
		UnsafeSupplier<Long[], Exception> amenityIdsUnsafeSupplier) {

		try {
			amenityIds = amenityIdsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Primary keys of the amenities for this room.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long[] amenityIds;

	@Schema(description = "The room's available end time.")
	@Valid
	public Time getAvailableEndTime() {
		return availableEndTime;
	}

	public void setAvailableEndTime(Time availableEndTime) {
		this.availableEndTime = availableEndTime;
	}

	@JsonIgnore
	public void setAvailableEndTime(
		UnsafeSupplier<Time, Exception> availableEndTimeUnsafeSupplier) {

		try {
			availableEndTime = availableEndTimeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The room's available end time.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Time availableEndTime;

	@Schema(description = "The room's availability on a specified day (Fri).")
	public Boolean getAvailableFriday() {
		return availableFriday;
	}

	public void setAvailableFriday(Boolean availableFriday) {
		this.availableFriday = availableFriday;
	}

	@JsonIgnore
	public void setAvailableFriday(
		UnsafeSupplier<Boolean, Exception> availableFridayUnsafeSupplier) {

		try {
			availableFriday = availableFridayUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The room's availability on a specified day (Fri)."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Boolean availableFriday;

	@Schema(description = "The room's availability on a specified day (Mon).")
	public Boolean getAvailableMonday() {
		return availableMonday;
	}

	public void setAvailableMonday(Boolean availableMonday) {
		this.availableMonday = availableMonday;
	}

	@JsonIgnore
	public void setAvailableMonday(
		UnsafeSupplier<Boolean, Exception> availableMondayUnsafeSupplier) {

		try {
			availableMonday = availableMondayUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The room's availability on a specified day (Mon)."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Boolean availableMonday;

	@Schema(description = "The room's availability on a specified day (Sat).")
	public Boolean getAvailableSaturday() {
		return availableSaturday;
	}

	public void setAvailableSaturday(Boolean availableSaturday) {
		this.availableSaturday = availableSaturday;
	}

	@JsonIgnore
	public void setAvailableSaturday(
		UnsafeSupplier<Boolean, Exception> availableSaturdayUnsafeSupplier) {

		try {
			availableSaturday = availableSaturdayUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The room's availability on a specified day (Sat)."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Boolean availableSaturday;

	@Schema(description = "The room's available start time.")
	@Valid
	public Time getAvailableStartTime() {
		return availableStartTime;
	}

	public void setAvailableStartTime(Time availableStartTime) {
		this.availableStartTime = availableStartTime;
	}

	@JsonIgnore
	public void setAvailableStartTime(
		UnsafeSupplier<Time, Exception> availableStartTimeUnsafeSupplier) {

		try {
			availableStartTime = availableStartTimeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The room's available start time.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Time availableStartTime;

	@Schema(description = "The room's availability on a specified day (Sun).")
	public Boolean getAvailableSunday() {
		return availableSunday;
	}

	public void setAvailableSunday(Boolean availableSunday) {
		this.availableSunday = availableSunday;
	}

	@JsonIgnore
	public void setAvailableSunday(
		UnsafeSupplier<Boolean, Exception> availableSundayUnsafeSupplier) {

		try {
			availableSunday = availableSundayUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The room's availability on a specified day (Sun)."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Boolean availableSunday;

	@Schema(description = "The room's availability on a specified day (Thu).")
	public Boolean getAvailableThursday() {
		return availableThursday;
	}

	public void setAvailableThursday(Boolean availableThursday) {
		this.availableThursday = availableThursday;
	}

	@JsonIgnore
	public void setAvailableThursday(
		UnsafeSupplier<Boolean, Exception> availableThursdayUnsafeSupplier) {

		try {
			availableThursday = availableThursdayUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The room's availability on a specified day (Thu)."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Boolean availableThursday;

	@Schema(description = "The room's availability on a specified day (Tue).")
	public Boolean getAvailableTuesday() {
		return availableTuesday;
	}

	public void setAvailableTuesday(Boolean availableTuesday) {
		this.availableTuesday = availableTuesday;
	}

	@JsonIgnore
	public void setAvailableTuesday(
		UnsafeSupplier<Boolean, Exception> availableTuesdayUnsafeSupplier) {

		try {
			availableTuesday = availableTuesdayUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The room's availability on a specified day (Tue)."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Boolean availableTuesday;

	@Schema(description = "The room's availability on a specified day (Wed).")
	public Boolean getAvailableWednesday() {
		return availableWednesday;
	}

	public void setAvailableWednesday(Boolean availableWednesday) {
		this.availableWednesday = availableWednesday;
	}

	@JsonIgnore
	public void setAvailableWednesday(
		UnsafeSupplier<Boolean, Exception> availableWednesdayUnsafeSupplier) {

		try {
			availableWednesday = availableWednesdayUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The room's availability on a specified day (Wed)."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Boolean availableWednesday;

	@Schema(description = "The room's maximum capacity.")
	public Integer getCapacityPeople() {
		return capacityPeople;
	}

	public void setCapacityPeople(Integer capacityPeople) {
		this.capacityPeople = capacityPeople;
	}

	@JsonIgnore
	public void setCapacityPeople(
		UnsafeSupplier<Integer, Exception> capacityPeopleUnsafeSupplier) {

		try {
			capacityPeople = capacityPeopleUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The room's maximum capacity.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Integer capacityPeople;

	@Schema(description = "The room's size in square meters.")
	public Double getCapacitySquareMeters() {
		return capacitySquareMeters;
	}

	public void setCapacitySquareMeters(Double capacitySquareMeters) {
		this.capacitySquareMeters = capacitySquareMeters;
	}

	@JsonIgnore
	public void setCapacitySquareMeters(
		UnsafeSupplier<Double, Exception> capacitySquareMetersUnsafeSupplier) {

		try {
			capacitySquareMeters = capacitySquareMetersUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The room's size in square meters.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Double capacitySquareMeters;

	@Schema(description = "The room name.")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The room name.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotEmpty
	protected String name;

	@Schema(
		description = "The id of the office that this room entity belongs to."
	)
	public Long getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Long officeId) {
		this.officeId = officeId;
	}

	@JsonIgnore
	public void setOfficeId(
		UnsafeSupplier<Long, Exception> officeIdUnsafeSupplier) {

		try {
			officeId = officeIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The id of the office that this room entity belongs to."
	)
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Long officeId;

	@Schema(
		description = "The name of the office that this room entity blongs to."
	)
	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	@JsonIgnore
	public void setOfficeName(
		UnsafeSupplier<String, Exception> officeNameUnsafeSupplier) {

		try {
			officeName = officeNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(
		description = "The name of the office that this room entity blongs to."
	)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String officeName;

	@Schema(description = "The room's extension phone number.")
	public Integer getPhoneExtension() {
		return phoneExtension;
	}

	public void setPhoneExtension(Integer phoneExtension) {
		this.phoneExtension = phoneExtension;
	}

	@JsonIgnore
	public void setPhoneExtension(
		UnsafeSupplier<Integer, Exception> phoneExtensionUnsafeSupplier) {

		try {
			phoneExtension = phoneExtensionUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The room's extension phone number.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer phoneExtension;

	@Schema(description = "The path or url of the room's photo.")
	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	@JsonIgnore
	public void setPhotoPath(
		UnsafeSupplier<String, Exception> photoPathUnsafeSupplier) {

		try {
			photoPath = photoPathUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The path or url of the room's photo.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotEmpty
	protected String photoPath;

	@Schema(description = "Primary keys of the purposes for this room.")
	public Long[] getPurposeIds() {
		return purposeIds;
	}

	public void setPurposeIds(Long[] purposeIds) {
		this.purposeIds = purposeIds;
	}

	@JsonIgnore
	public void setPurposeIds(
		UnsafeSupplier<Long[], Exception> purposeIdsUnsafeSupplier) {

		try {
			purposeIds = purposeIdsUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "Primary keys of the purposes for this room.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Long[] purposeIds;

	@Schema(description = "The primary key for the Room entity.")
	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	@JsonIgnore
	public void setRoomId(
		UnsafeSupplier<Long, Exception> roomIdUnsafeSupplier) {

		try {
			roomId = roomIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The primary key for the Room entity.")
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long roomId;

	@Schema(description = "The room's wifi password.")
	public String getWifiPassword() {
		return wifiPassword;
	}

	public void setWifiPassword(String wifiPassword) {
		this.wifiPassword = wifiPassword;
	}

	@JsonIgnore
	public void setWifiPassword(
		UnsafeSupplier<String, Exception> wifiPasswordUnsafeSupplier) {

		try {
			wifiPassword = wifiPasswordUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The room's wifi password.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotEmpty
	protected String wifiPassword;

	@Schema(description = "The room's wifi name.")
	public String getWifiSSID() {
		return wifiSSID;
	}

	public void setWifiSSID(String wifiSSID) {
		this.wifiSSID = wifiSSID;
	}

	@JsonIgnore
	public void setWifiSSID(
		UnsafeSupplier<String, Exception> wifiSSIDUnsafeSupplier) {

		try {
			wifiSSID = wifiSSIDUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The room's wifi name.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotEmpty
	protected String wifiSSID;

	@Schema(description = "The room's wifi security type.")
	public Integer getWifiSecurityType() {
		return wifiSecurityType;
	}

	public void setWifiSecurityType(Integer wifiSecurityType) {
		this.wifiSecurityType = wifiSecurityType;
	}

	@JsonIgnore
	public void setWifiSecurityType(
		UnsafeSupplier<Integer, Exception> wifiSecurityTypeUnsafeSupplier) {

		try {
			wifiSecurityType = wifiSecurityTypeUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The room's wifi security type.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Integer wifiSecurityType;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Room)) {
			return false;
		}

		Room room = (Room)object;

		return Objects.equals(toString(), room.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (amenityIds != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"amenityIds\": ");

			sb.append("[");

			for (int i = 0; i < amenityIds.length; i++) {
				sb.append(amenityIds[i]);

				if ((i + 1) < amenityIds.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (availableEndTime != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableEndTime\": ");

			sb.append(String.valueOf(availableEndTime));
		}

		if (availableFriday != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableFriday\": ");

			sb.append(availableFriday);
		}

		if (availableMonday != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableMonday\": ");

			sb.append(availableMonday);
		}

		if (availableSaturday != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableSaturday\": ");

			sb.append(availableSaturday);
		}

		if (availableStartTime != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableStartTime\": ");

			sb.append(String.valueOf(availableStartTime));
		}

		if (availableSunday != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableSunday\": ");

			sb.append(availableSunday);
		}

		if (availableThursday != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableThursday\": ");

			sb.append(availableThursday);
		}

		if (availableTuesday != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableTuesday\": ");

			sb.append(availableTuesday);
		}

		if (availableWednesday != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableWednesday\": ");

			sb.append(availableWednesday);
		}

		if (capacityPeople != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"capacityPeople\": ");

			sb.append(capacityPeople);
		}

		if (capacitySquareMeters != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"capacitySquareMeters\": ");

			sb.append(capacitySquareMeters);
		}

		if (name != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(name));

			sb.append("\"");
		}

		if (officeId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"officeId\": ");

			sb.append(officeId);
		}

		if (officeName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"officeName\": ");

			sb.append("\"");

			sb.append(_escape(officeName));

			sb.append("\"");
		}

		if (phoneExtension != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phoneExtension\": ");

			sb.append(phoneExtension);
		}

		if (photoPath != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"photoPath\": ");

			sb.append("\"");

			sb.append(_escape(photoPath));

			sb.append("\"");
		}

		if (purposeIds != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"purposeIds\": ");

			sb.append("[");

			for (int i = 0; i < purposeIds.length; i++) {
				sb.append(purposeIds[i]);

				if ((i + 1) < purposeIds.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (roomId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"roomId\": ");

			sb.append(roomId);
		}

		if (wifiPassword != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"wifiPassword\": ");

			sb.append("\"");

			sb.append(_escape(wifiPassword));

			sb.append("\"");
		}

		if (wifiSSID != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"wifiSSID\": ");

			sb.append("\"");

			sb.append(_escape(wifiSSID));

			sb.append("\"");
		}

		if (wifiSecurityType != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"wifiSecurityType\": ");

			sb.append(wifiSecurityType);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		defaultValue = "jp.co.liferay.headless.reservation.dto.v1_0.Room",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
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

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(value);
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}