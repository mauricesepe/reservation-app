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
import javax.validation.constraints.NotNull;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
@GraphQLName("Booking")
@JsonFilter("Liferay.Vulcan")
@Schema(
	requiredProperties = {
		"title", "date", "startTime", "endTime", "roomId", "description"
	}
)
@XmlRootElement(name = "Booking")
public class Booking {

	@Schema(description = "The primary key for the Booking entity.")
	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	@JsonIgnore
	public void setBookingId(
		UnsafeSupplier<Long, Exception> bookingIdUnsafeSupplier) {

		try {
			bookingId = bookingIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long bookingId;

	@Schema(description = "Date of the booking event.")
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@JsonIgnore
	public void setDate(UnsafeSupplier<String, Exception> dateUnsafeSupplier) {
		try {
			date = dateUnsafeSupplier.get();
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
	protected String date;

	@Schema(description = "A description of the booking event.")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonIgnore
	public void setDescription(
		UnsafeSupplier<String, Exception> descriptionUnsafeSupplier) {

		try {
			description = descriptionUnsafeSupplier.get();
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
	protected String description;

	@Schema(description = "End time of the booking event.")
	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@JsonIgnore
	public void setEndTime(
		UnsafeSupplier<Time, Exception> endTimeUnsafeSupplier) {

		try {
			endTime = endTimeUnsafeSupplier.get();
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
	@NotNull
	protected Time endTime;

	@Schema(description = "Id associated with the office.")
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

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long officeId;

	@Schema(description = "Name associated with the room.")
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

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String officeName;

	@Schema(description = "Primary keys of the participants for this booking.")
	public Long[] getParticipantIds() {
		return participantIds;
	}

	public void setParticipantIds(Long[] participantIds) {
		this.participantIds = participantIds;
	}

	@JsonIgnore
	public void setParticipantIds(
		UnsafeSupplier<Long[], Exception> participantIdsUnsafeSupplier) {

		try {
			participantIds = participantIdsUnsafeSupplier.get();
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
	protected Long[] participantIds;

	@Schema(description = "Id associated with the room.")
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

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	@NotNull
	protected Long roomId;

	@Schema(description = "Name associated with the room.")
	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	@JsonIgnore
	public void setRoomName(
		UnsafeSupplier<String, Exception> roomNameUnsafeSupplier) {

		try {
			roomName = roomNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String roomName;

	@Schema(description = "Start time of the booking event.")
	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	@JsonIgnore
	public void setStartTime(
		UnsafeSupplier<Time, Exception> startTimeUnsafeSupplier) {

		try {
			startTime = startTimeUnsafeSupplier.get();
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
	@NotNull
	protected Time startTime;

	@Schema(description = "Title of the booking event.")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonIgnore
	public void setTitle(
		UnsafeSupplier<String, Exception> titleUnsafeSupplier) {

		try {
			title = titleUnsafeSupplier.get();
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
	protected String title;

	@Schema(description = "The user who created the booking.")
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@JsonIgnore
	public void setUserId(
		UnsafeSupplier<Long, Exception> userIdUnsafeSupplier) {

		try {
			userId = userIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected Long userId;

	@Schema(description = "Name of associated user.")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@JsonIgnore
	public void setUserName(
		UnsafeSupplier<String, Exception> userNameUnsafeSupplier) {

		try {
			userName = userNameUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	protected String userName;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Booking)) {
			return false;
		}

		Booking booking = (Booking)object;

		return Objects.equals(toString(), booking.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (bookingId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"bookingId\": ");

			sb.append(bookingId);
		}

		if (date != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"date\": ");

			sb.append("\"");

			sb.append(_escape(date));

			sb.append("\"");
		}

		if (description != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(description));

			sb.append("\"");
		}

		if (endTime != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"endTime\": ");

			sb.append(String.valueOf(endTime));
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

		if (participantIds != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"participantIds\": ");

			sb.append("[");

			for (int i = 0; i < participantIds.length; i++) {
				sb.append(participantIds[i]);

				if ((i + 1) < participantIds.length) {
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

		if (roomName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"roomName\": ");

			sb.append("\"");

			sb.append(_escape(roomName));

			sb.append("\"");
		}

		if (startTime != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"startTime\": ");

			sb.append(String.valueOf(startTime));
		}

		if (title != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(title));

			sb.append("\"");
		}

		if (userId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userId\": ");

			sb.append(userId);
		}

		if (userName != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userName\": ");

			sb.append("\"");

			sb.append(_escape(userName));

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