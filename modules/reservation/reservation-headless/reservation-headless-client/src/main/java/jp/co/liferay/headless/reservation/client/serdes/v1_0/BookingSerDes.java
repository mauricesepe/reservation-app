package jp.co.liferay.headless.reservation.client.serdes.v1_0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import jp.co.liferay.headless.reservation.client.dto.v1_0.Booking;
import jp.co.liferay.headless.reservation.client.json.BaseJSONParser;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
public class BookingSerDes {

	public static Booking toDTO(String json) {
		BookingJSONParser bookingJSONParser = new BookingJSONParser();

		return bookingJSONParser.parseToDTO(json);
	}

	public static Booking[] toDTOs(String json) {
		BookingJSONParser bookingJSONParser = new BookingJSONParser();

		return bookingJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Booking booking) {
		if (booking == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (booking.getBookingId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"bookingId\": ");

			sb.append(booking.getBookingId());
		}

		if (booking.getDate() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"date\": ");

			sb.append("\"");

			sb.append(_escape(booking.getDate()));

			sb.append("\"");
		}

		if (booking.getDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"description\": ");

			sb.append("\"");

			sb.append(_escape(booking.getDescription()));

			sb.append("\"");
		}

		if (booking.getEndTime() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"endTime\": ");

			sb.append(String.valueOf(booking.getEndTime()));
		}

		if (booking.getOfficeId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"officeId\": ");

			sb.append(booking.getOfficeId());
		}

		if (booking.getOfficeName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"officeName\": ");

			sb.append("\"");

			sb.append(_escape(booking.getOfficeName()));

			sb.append("\"");
		}

		if (booking.getParticipantIds() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"participantIds\": ");

			sb.append("[");

			for (int i = 0; i < booking.getParticipantIds().length; i++) {
				sb.append(booking.getParticipantIds()[i]);

				if ((i + 1) < booking.getParticipantIds().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (booking.getRoomId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"roomId\": ");

			sb.append(booking.getRoomId());
		}

		if (booking.getRoomName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"roomName\": ");

			sb.append("\"");

			sb.append(_escape(booking.getRoomName()));

			sb.append("\"");
		}

		if (booking.getStartTime() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"startTime\": ");

			sb.append(String.valueOf(booking.getStartTime()));
		}

		if (booking.getTitle() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"title\": ");

			sb.append("\"");

			sb.append(_escape(booking.getTitle()));

			sb.append("\"");
		}

		if (booking.getUserId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userId\": ");

			sb.append(booking.getUserId());
		}

		if (booking.getUserName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userName\": ");

			sb.append("\"");

			sb.append(_escape(booking.getUserName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		BookingJSONParser bookingJSONParser = new BookingJSONParser();

		return bookingJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Booking booking) {
		if (booking == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		if (booking.getBookingId() == null) {
			map.put("bookingId", null);
		}
		else {
			map.put("bookingId", String.valueOf(booking.getBookingId()));
		}

		if (booking.getDate() == null) {
			map.put("date", null);
		}
		else {
			map.put("date", String.valueOf(booking.getDate()));
		}

		if (booking.getDescription() == null) {
			map.put("description", null);
		}
		else {
			map.put("description", String.valueOf(booking.getDescription()));
		}

		if (booking.getEndTime() == null) {
			map.put("endTime", null);
		}
		else {
			map.put("endTime", String.valueOf(booking.getEndTime()));
		}

		if (booking.getOfficeId() == null) {
			map.put("officeId", null);
		}
		else {
			map.put("officeId", String.valueOf(booking.getOfficeId()));
		}

		if (booking.getOfficeName() == null) {
			map.put("officeName", null);
		}
		else {
			map.put("officeName", String.valueOf(booking.getOfficeName()));
		}

		if (booking.getParticipantIds() == null) {
			map.put("participantIds", null);
		}
		else {
			map.put(
				"participantIds", String.valueOf(booking.getParticipantIds()));
		}

		if (booking.getRoomId() == null) {
			map.put("roomId", null);
		}
		else {
			map.put("roomId", String.valueOf(booking.getRoomId()));
		}

		if (booking.getRoomName() == null) {
			map.put("roomName", null);
		}
		else {
			map.put("roomName", String.valueOf(booking.getRoomName()));
		}

		if (booking.getStartTime() == null) {
			map.put("startTime", null);
		}
		else {
			map.put("startTime", String.valueOf(booking.getStartTime()));
		}

		if (booking.getTitle() == null) {
			map.put("title", null);
		}
		else {
			map.put("title", String.valueOf(booking.getTitle()));
		}

		if (booking.getUserId() == null) {
			map.put("userId", null);
		}
		else {
			map.put("userId", String.valueOf(booking.getUserId()));
		}

		if (booking.getUserName() == null) {
			map.put("userName", null);
		}
		else {
			map.put("userName", String.valueOf(booking.getUserName()));
		}

		return map;
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

	private static class BookingJSONParser extends BaseJSONParser<Booking> {

		@Override
		protected Booking createDTO() {
			return new Booking();
		}

		@Override
		protected Booking[] createDTOArray(int size) {
			return new Booking[size];
		}

		@Override
		protected void setField(
			Booking booking, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "bookingId")) {
				if (jsonParserFieldValue != null) {
					booking.setBookingId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "date")) {
				if (jsonParserFieldValue != null) {
					booking.setDate((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "description")) {
				if (jsonParserFieldValue != null) {
					booking.setDescription((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "endTime")) {
				if (jsonParserFieldValue != null) {
					booking.setEndTime(
						TimeSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "officeId")) {
				if (jsonParserFieldValue != null) {
					booking.setOfficeId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "officeName")) {
				if (jsonParserFieldValue != null) {
					booking.setOfficeName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "participantIds")) {
				if (jsonParserFieldValue != null) {
					booking.setParticipantIds(
						toLongs((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "roomId")) {
				if (jsonParserFieldValue != null) {
					booking.setRoomId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "roomName")) {
				if (jsonParserFieldValue != null) {
					booking.setRoomName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "startTime")) {
				if (jsonParserFieldValue != null) {
					booking.setStartTime(
						TimeSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "title")) {
				if (jsonParserFieldValue != null) {
					booking.setTitle((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userId")) {
				if (jsonParserFieldValue != null) {
					booking.setUserId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userName")) {
				if (jsonParserFieldValue != null) {
					booking.setUserName((String)jsonParserFieldValue);
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}