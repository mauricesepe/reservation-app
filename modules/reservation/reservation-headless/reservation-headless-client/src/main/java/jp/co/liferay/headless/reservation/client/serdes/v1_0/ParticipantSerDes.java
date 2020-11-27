package jp.co.liferay.headless.reservation.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import jp.co.liferay.headless.reservation.client.dto.v1_0.Participant;
import jp.co.liferay.headless.reservation.client.json.BaseJSONParser;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
public class ParticipantSerDes {

	public static Participant toDTO(String json) {
		ParticipantJSONParser participantJSONParser =
			new ParticipantJSONParser();

		return participantJSONParser.parseToDTO(json);
	}

	public static Participant[] toDTOs(String json) {
		ParticipantJSONParser participantJSONParser =
			new ParticipantJSONParser();

		return participantJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Participant participant) {
		if (participant == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (participant.getCompanyName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"companyName\": ");

			sb.append("\"");

			sb.append(_escape(participant.getCompanyName()));

			sb.append("\"");
		}

		if (participant.getEmailAddress() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"emailAddress\": ");

			sb.append("\"");

			sb.append(_escape(participant.getEmailAddress()));

			sb.append("\"");
		}

		if (participant.getFullName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"fullName\": ");

			sb.append("\"");

			sb.append(_escape(participant.getFullName()));

			sb.append("\"");
		}

		if (participant.getParticipantId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"participantId\": ");

			sb.append(participant.getParticipantId());
		}

		if (participant.getUserId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userId\": ");

			sb.append(participant.getUserId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ParticipantJSONParser participantJSONParser =
			new ParticipantJSONParser();

		return participantJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Participant participant) {
		if (participant == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (participant.getCompanyName() == null) {
			map.put("companyName", null);
		}
		else {
			map.put(
				"companyName", String.valueOf(participant.getCompanyName()));
		}

		if (participant.getEmailAddress() == null) {
			map.put("emailAddress", null);
		}
		else {
			map.put(
				"emailAddress", String.valueOf(participant.getEmailAddress()));
		}

		if (participant.getFullName() == null) {
			map.put("fullName", null);
		}
		else {
			map.put("fullName", String.valueOf(participant.getFullName()));
		}

		if (participant.getParticipantId() == null) {
			map.put("participantId", null);
		}
		else {
			map.put(
				"participantId",
				String.valueOf(participant.getParticipantId()));
		}

		if (participant.getUserId() == null) {
			map.put("userId", null);
		}
		else {
			map.put("userId", String.valueOf(participant.getUserId()));
		}

		return map;
	}

	public static class ParticipantJSONParser
		extends BaseJSONParser<Participant> {

		@Override
		protected Participant createDTO() {
			return new Participant();
		}

		@Override
		protected Participant[] createDTOArray(int size) {
			return new Participant[size];
		}

		@Override
		protected void setField(
			Participant participant, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "companyName")) {
				if (jsonParserFieldValue != null) {
					participant.setCompanyName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "emailAddress")) {
				if (jsonParserFieldValue != null) {
					participant.setEmailAddress((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "fullName")) {
				if (jsonParserFieldValue != null) {
					participant.setFullName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "participantId")) {
				if (jsonParserFieldValue != null) {
					participant.setParticipantId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userId")) {
				if (jsonParserFieldValue != null) {
					participant.setUserId(
						Long.valueOf((String)jsonParserFieldValue));
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