package jp.co.liferay.headless.reservation.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import jp.co.liferay.headless.reservation.client.dto.v1_0.Time;
import jp.co.liferay.headless.reservation.client.function.UnsafeSupplier;
import jp.co.liferay.headless.reservation.client.serdes.v1_0.RoomSerDes;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
public class Room implements Cloneable, Serializable {

	public static Room toDTO(String json) {
		return RoomSerDes.toDTO(json);
	}

	public Long[] getAmenityIds() {
		return amenityIds;
	}

	public void setAmenityIds(Long[] amenityIds) {
		this.amenityIds = amenityIds;
	}

	public void setAmenityIds(
		UnsafeSupplier<Long[], Exception> amenityIdsUnsafeSupplier) {

		try {
			amenityIds = amenityIdsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long[] amenityIds;

	public Time getAvailableEndTime() {
		return availableEndTime;
	}

	public void setAvailableEndTime(Time availableEndTime) {
		this.availableEndTime = availableEndTime;
	}

	public void setAvailableEndTime(
		UnsafeSupplier<Time, Exception> availableEndTimeUnsafeSupplier) {

		try {
			availableEndTime = availableEndTimeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Time availableEndTime;

	public Boolean getAvailableFriday() {
		return availableFriday;
	}

	public void setAvailableFriday(Boolean availableFriday) {
		this.availableFriday = availableFriday;
	}

	public void setAvailableFriday(
		UnsafeSupplier<Boolean, Exception> availableFridayUnsafeSupplier) {

		try {
			availableFriday = availableFridayUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean availableFriday;

	public Boolean getAvailableMonday() {
		return availableMonday;
	}

	public void setAvailableMonday(Boolean availableMonday) {
		this.availableMonday = availableMonday;
	}

	public void setAvailableMonday(
		UnsafeSupplier<Boolean, Exception> availableMondayUnsafeSupplier) {

		try {
			availableMonday = availableMondayUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean availableMonday;

	public Boolean getAvailableSaturday() {
		return availableSaturday;
	}

	public void setAvailableSaturday(Boolean availableSaturday) {
		this.availableSaturday = availableSaturday;
	}

	public void setAvailableSaturday(
		UnsafeSupplier<Boolean, Exception> availableSaturdayUnsafeSupplier) {

		try {
			availableSaturday = availableSaturdayUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean availableSaturday;

	public Time getAvailableStartTime() {
		return availableStartTime;
	}

	public void setAvailableStartTime(Time availableStartTime) {
		this.availableStartTime = availableStartTime;
	}

	public void setAvailableStartTime(
		UnsafeSupplier<Time, Exception> availableStartTimeUnsafeSupplier) {

		try {
			availableStartTime = availableStartTimeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Time availableStartTime;

	public Boolean getAvailableSunday() {
		return availableSunday;
	}

	public void setAvailableSunday(Boolean availableSunday) {
		this.availableSunday = availableSunday;
	}

	public void setAvailableSunday(
		UnsafeSupplier<Boolean, Exception> availableSundayUnsafeSupplier) {

		try {
			availableSunday = availableSundayUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean availableSunday;

	public Boolean getAvailableThursday() {
		return availableThursday;
	}

	public void setAvailableThursday(Boolean availableThursday) {
		this.availableThursday = availableThursday;
	}

	public void setAvailableThursday(
		UnsafeSupplier<Boolean, Exception> availableThursdayUnsafeSupplier) {

		try {
			availableThursday = availableThursdayUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean availableThursday;

	public Boolean getAvailableTuesday() {
		return availableTuesday;
	}

	public void setAvailableTuesday(Boolean availableTuesday) {
		this.availableTuesday = availableTuesday;
	}

	public void setAvailableTuesday(
		UnsafeSupplier<Boolean, Exception> availableTuesdayUnsafeSupplier) {

		try {
			availableTuesday = availableTuesdayUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean availableTuesday;

	public Boolean getAvailableWednesday() {
		return availableWednesday;
	}

	public void setAvailableWednesday(Boolean availableWednesday) {
		this.availableWednesday = availableWednesday;
	}

	public void setAvailableWednesday(
		UnsafeSupplier<Boolean, Exception> availableWednesdayUnsafeSupplier) {

		try {
			availableWednesday = availableWednesdayUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean availableWednesday;

	public Integer getCapacityPeople() {
		return capacityPeople;
	}

	public void setCapacityPeople(Integer capacityPeople) {
		this.capacityPeople = capacityPeople;
	}

	public void setCapacityPeople(
		UnsafeSupplier<Integer, Exception> capacityPeopleUnsafeSupplier) {

		try {
			capacityPeople = capacityPeopleUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer capacityPeople;

	public Double getCapacitySquareMeters() {
		return capacitySquareMeters;
	}

	public void setCapacitySquareMeters(Double capacitySquareMeters) {
		this.capacitySquareMeters = capacitySquareMeters;
	}

	public void setCapacitySquareMeters(
		UnsafeSupplier<Double, Exception> capacitySquareMetersUnsafeSupplier) {

		try {
			capacitySquareMeters = capacitySquareMetersUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double capacitySquareMeters;

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

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public void setOfficeName(
		UnsafeSupplier<String, Exception> officeNameUnsafeSupplier) {

		try {
			officeName = officeNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String officeName;

	public Integer getPhoneExtension() {
		return phoneExtension;
	}

	public void setPhoneExtension(Integer phoneExtension) {
		this.phoneExtension = phoneExtension;
	}

	public void setPhoneExtension(
		UnsafeSupplier<Integer, Exception> phoneExtensionUnsafeSupplier) {

		try {
			phoneExtension = phoneExtensionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer phoneExtension;

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public void setPhotoPath(
		UnsafeSupplier<String, Exception> photoPathUnsafeSupplier) {

		try {
			photoPath = photoPathUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String photoPath;

	public Long[] getPurposeIds() {
		return purposeIds;
	}

	public void setPurposeIds(Long[] purposeIds) {
		this.purposeIds = purposeIds;
	}

	public void setPurposeIds(
		UnsafeSupplier<Long[], Exception> purposeIdsUnsafeSupplier) {

		try {
			purposeIds = purposeIdsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long[] purposeIds;

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public void setRoomId(
		UnsafeSupplier<Long, Exception> roomIdUnsafeSupplier) {

		try {
			roomId = roomIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long roomId;

	public String getWifiPassword() {
		return wifiPassword;
	}

	public void setWifiPassword(String wifiPassword) {
		this.wifiPassword = wifiPassword;
	}

	public void setWifiPassword(
		UnsafeSupplier<String, Exception> wifiPasswordUnsafeSupplier) {

		try {
			wifiPassword = wifiPasswordUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String wifiPassword;

	public String getWifiSSID() {
		return wifiSSID;
	}

	public void setWifiSSID(String wifiSSID) {
		this.wifiSSID = wifiSSID;
	}

	public void setWifiSSID(
		UnsafeSupplier<String, Exception> wifiSSIDUnsafeSupplier) {

		try {
			wifiSSID = wifiSSIDUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String wifiSSID;

	public Integer getWifiSecurityType() {
		return wifiSecurityType;
	}

	public void setWifiSecurityType(Integer wifiSecurityType) {
		this.wifiSecurityType = wifiSecurityType;
	}

	public void setWifiSecurityType(
		UnsafeSupplier<Integer, Exception> wifiSecurityTypeUnsafeSupplier) {

		try {
			wifiSecurityType = wifiSecurityTypeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer wifiSecurityType;

	@Override
	public Room clone() throws CloneNotSupportedException {
		return (Room)super.clone();
	}

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
		return RoomSerDes.toJSON(this);
	}

}