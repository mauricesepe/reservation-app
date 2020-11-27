package jp.co.liferay.headless.reservation.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import jp.co.liferay.headless.reservation.client.dto.v1_0.Amenity;
import jp.co.liferay.headless.reservation.client.json.BaseJSONParser;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
public class AmenitySerDes {

	public static Amenity toDTO(String json) {
		AmenityJSONParser amenityJSONParser = new AmenityJSONParser();

		return amenityJSONParser.parseToDTO(json);
	}

	public static Amenity[] toDTOs(String json) {
		AmenityJSONParser amenityJSONParser = new AmenityJSONParser();

		return amenityJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Amenity amenity) {
		if (amenity == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (amenity.getAmenityId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"amenityId\": ");

			sb.append(amenity.getAmenityId());
		}

		if (amenity.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(amenity.getName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AmenityJSONParser amenityJSONParser = new AmenityJSONParser();

		return amenityJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Amenity amenity) {
		if (amenity == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (amenity.getAmenityId() == null) {
			map.put("amenityId", null);
		}
		else {
			map.put("amenityId", String.valueOf(amenity.getAmenityId()));
		}

		if (amenity.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(amenity.getName()));
		}

		return map;
	}

	public static class AmenityJSONParser extends BaseJSONParser<Amenity> {

		@Override
		protected Amenity createDTO() {
			return new Amenity();
		}

		@Override
		protected Amenity[] createDTOArray(int size) {
			return new Amenity[size];
		}

		@Override
		protected void setField(
			Amenity amenity, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "amenityId")) {
				if (jsonParserFieldValue != null) {
					amenity.setAmenityId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					amenity.setName((String)jsonParserFieldValue);
				}
			}
			else if (jsonParserFieldName.equals("status")) {
				throw new IllegalArgumentException();
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
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

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}