package jp.co.liferay.headless.reservation.client.serdes.v1_0;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import jp.co.liferay.headless.reservation.client.dto.v1_0.Room;
import jp.co.liferay.headless.reservation.client.json.BaseJSONParser;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
public class RoomSerDes {

	public static Room toDTO(String json) {
		RoomJSONParser roomJSONParser = new RoomJSONParser();

		return roomJSONParser.parseToDTO(json);
	}

	public static Room[] toDTOs(String json) {
		RoomJSONParser roomJSONParser = new RoomJSONParser();

		return roomJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Room room) {
		if (room == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (room.getAmenityIds() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"amenityIds\": ");

			sb.append("[");

			for (int i = 0; i < room.getAmenityIds().length; i++) {
				sb.append(room.getAmenityIds()[i]);

				if ((i + 1) < room.getAmenityIds().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (room.getAvailableEndTime() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableEndTime\": ");

			sb.append(String.valueOf(room.getAvailableEndTime()));
		}

		if (room.getAvailableFriday() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableFriday\": ");

			sb.append(room.getAvailableFriday());
		}

		if (room.getAvailableMonday() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableMonday\": ");

			sb.append(room.getAvailableMonday());
		}

		if (room.getAvailableSaturday() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableSaturday\": ");

			sb.append(room.getAvailableSaturday());
		}

		if (room.getAvailableStartTime() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableStartTime\": ");

			sb.append(String.valueOf(room.getAvailableStartTime()));
		}

		if (room.getAvailableSunday() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableSunday\": ");

			sb.append(room.getAvailableSunday());
		}

		if (room.getAvailableThursday() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableThursday\": ");

			sb.append(room.getAvailableThursday());
		}

		if (room.getAvailableTuesday() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableTuesday\": ");

			sb.append(room.getAvailableTuesday());
		}

		if (room.getAvailableWednesday() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"availableWednesday\": ");

			sb.append(room.getAvailableWednesday());
		}

		if (room.getCapacityPeople() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"capacityPeople\": ");

			sb.append(room.getCapacityPeople());
		}

		if (room.getCapacitySquareMeters() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"capacitySquareMeters\": ");

			sb.append(room.getCapacitySquareMeters());
		}

		if (room.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(room.getName()));

			sb.append("\"");
		}

		if (room.getOfficeId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"officeId\": ");

			sb.append(room.getOfficeId());
		}

		if (room.getOfficeName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"officeName\": ");

			sb.append("\"");

			sb.append(_escape(room.getOfficeName()));

			sb.append("\"");
		}

		if (room.getPhoneExtension() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phoneExtension\": ");

			sb.append(room.getPhoneExtension());
		}

		if (room.getPhotoPath() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"photoPath\": ");

			sb.append("\"");

			sb.append(_escape(room.getPhotoPath()));

			sb.append("\"");
		}

		if (room.getPurposeIds() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"purposeIds\": ");

			sb.append("[");

			for (int i = 0; i < room.getPurposeIds().length; i++) {
				sb.append(room.getPurposeIds()[i]);

				if ((i + 1) < room.getPurposeIds().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (room.getRoomId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"roomId\": ");

			sb.append(room.getRoomId());
		}

		if (room.getWifiPassword() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"wifiPassword\": ");

			sb.append("\"");

			sb.append(_escape(room.getWifiPassword()));

			sb.append("\"");
		}

		if (room.getWifiSSID() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"wifiSSID\": ");

			sb.append("\"");

			sb.append(_escape(room.getWifiSSID()));

			sb.append("\"");
		}

		if (room.getWifiSecurityType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"wifiSecurityType\": ");

			sb.append(room.getWifiSecurityType());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		RoomJSONParser roomJSONParser = new RoomJSONParser();

		return roomJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Room room) {
		if (room == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		if (room.getAmenityIds() == null) {
			map.put("amenityIds", null);
		}
		else {
			map.put("amenityIds", String.valueOf(room.getAmenityIds()));
		}

		if (room.getAvailableEndTime() == null) {
			map.put("availableEndTime", null);
		}
		else {
			map.put(
				"availableEndTime", String.valueOf(room.getAvailableEndTime()));
		}

		if (room.getAvailableFriday() == null) {
			map.put("availableFriday", null);
		}
		else {
			map.put(
				"availableFriday", String.valueOf(room.getAvailableFriday()));
		}

		if (room.getAvailableMonday() == null) {
			map.put("availableMonday", null);
		}
		else {
			map.put(
				"availableMonday", String.valueOf(room.getAvailableMonday()));
		}

		if (room.getAvailableSaturday() == null) {
			map.put("availableSaturday", null);
		}
		else {
			map.put(
				"availableSaturday",
				String.valueOf(room.getAvailableSaturday()));
		}

		if (room.getAvailableStartTime() == null) {
			map.put("availableStartTime", null);
		}
		else {
			map.put(
				"availableStartTime",
				String.valueOf(room.getAvailableStartTime()));
		}

		if (room.getAvailableSunday() == null) {
			map.put("availableSunday", null);
		}
		else {
			map.put(
				"availableSunday", String.valueOf(room.getAvailableSunday()));
		}

		if (room.getAvailableThursday() == null) {
			map.put("availableThursday", null);
		}
		else {
			map.put(
				"availableThursday",
				String.valueOf(room.getAvailableThursday()));
		}

		if (room.getAvailableTuesday() == null) {
			map.put("availableTuesday", null);
		}
		else {
			map.put(
				"availableTuesday", String.valueOf(room.getAvailableTuesday()));
		}

		if (room.getAvailableWednesday() == null) {
			map.put("availableWednesday", null);
		}
		else {
			map.put(
				"availableWednesday",
				String.valueOf(room.getAvailableWednesday()));
		}

		if (room.getCapacityPeople() == null) {
			map.put("capacityPeople", null);
		}
		else {
			map.put("capacityPeople", String.valueOf(room.getCapacityPeople()));
		}

		if (room.getCapacitySquareMeters() == null) {
			map.put("capacitySquareMeters", null);
		}
		else {
			map.put(
				"capacitySquareMeters",
				String.valueOf(room.getCapacitySquareMeters()));
		}

		if (room.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(room.getName()));
		}

		if (room.getOfficeId() == null) {
			map.put("officeId", null);
		}
		else {
			map.put("officeId", String.valueOf(room.getOfficeId()));
		}

		if (room.getOfficeName() == null) {
			map.put("officeName", null);
		}
		else {
			map.put("officeName", String.valueOf(room.getOfficeName()));
		}

		if (room.getPhoneExtension() == null) {
			map.put("phoneExtension", null);
		}
		else {
			map.put("phoneExtension", String.valueOf(room.getPhoneExtension()));
		}

		if (room.getPhotoPath() == null) {
			map.put("photoPath", null);
		}
		else {
			map.put("photoPath", String.valueOf(room.getPhotoPath()));
		}

		if (room.getPurposeIds() == null) {
			map.put("purposeIds", null);
		}
		else {
			map.put("purposeIds", String.valueOf(room.getPurposeIds()));
		}

		if (room.getRoomId() == null) {
			map.put("roomId", null);
		}
		else {
			map.put("roomId", String.valueOf(room.getRoomId()));
		}

		if (room.getWifiPassword() == null) {
			map.put("wifiPassword", null);
		}
		else {
			map.put("wifiPassword", String.valueOf(room.getWifiPassword()));
		}

		if (room.getWifiSSID() == null) {
			map.put("wifiSSID", null);
		}
		else {
			map.put("wifiSSID", String.valueOf(room.getWifiSSID()));
		}

		if (room.getWifiSecurityType() == null) {
			map.put("wifiSecurityType", null);
		}
		else {
			map.put(
				"wifiSecurityType", String.valueOf(room.getWifiSecurityType()));
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

	private static class RoomJSONParser extends BaseJSONParser<Room> {

		@Override
		protected Room createDTO() {
			return new Room();
		}

		@Override
		protected Room[] createDTOArray(int size) {
			return new Room[size];
		}

		@Override
		protected void setField(
			Room room, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "amenityIds")) {
				if (jsonParserFieldValue != null) {
					room.setAmenityIds(toLongs((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "availableEndTime")) {
				if (jsonParserFieldValue != null) {
					room.setAvailableEndTime(
						TimeSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "availableFriday")) {
				if (jsonParserFieldValue != null) {
					room.setAvailableFriday((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "availableMonday")) {
				if (jsonParserFieldValue != null) {
					room.setAvailableMonday((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "availableSaturday")) {
				if (jsonParserFieldValue != null) {
					room.setAvailableSaturday((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "availableStartTime")) {

				if (jsonParserFieldValue != null) {
					room.setAvailableStartTime(
						TimeSerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "availableSunday")) {
				if (jsonParserFieldValue != null) {
					room.setAvailableSunday((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "availableThursday")) {
				if (jsonParserFieldValue != null) {
					room.setAvailableThursday((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "availableTuesday")) {
				if (jsonParserFieldValue != null) {
					room.setAvailableTuesday((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "availableWednesday")) {

				if (jsonParserFieldValue != null) {
					room.setAvailableWednesday((Boolean)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "capacityPeople")) {
				if (jsonParserFieldValue != null) {
					room.setCapacityPeople(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(
						jsonParserFieldName, "capacitySquareMeters")) {

				if (jsonParserFieldValue != null) {
					room.setCapacitySquareMeters((Double)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					room.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "officeId")) {
				if (jsonParserFieldValue != null) {
					room.setOfficeId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "officeName")) {
				if (jsonParserFieldValue != null) {
					room.setOfficeName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phoneExtension")) {
				if (jsonParserFieldValue != null) {
					room.setPhoneExtension(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "photoPath")) {
				if (jsonParserFieldValue != null) {
					room.setPhotoPath((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "purposeIds")) {
				if (jsonParserFieldValue != null) {
					room.setPurposeIds(toLongs((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "roomId")) {
				if (jsonParserFieldValue != null) {
					room.setRoomId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "wifiPassword")) {
				if (jsonParserFieldValue != null) {
					room.setWifiPassword((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "wifiSSID")) {
				if (jsonParserFieldValue != null) {
					room.setWifiSSID((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "wifiSecurityType")) {
				if (jsonParserFieldValue != null) {
					room.setWifiSecurityType(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}