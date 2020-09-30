package jp.co.liferay.headless.reservation.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import jp.co.liferay.headless.reservation.client.dto.v1_0.Room;
import jp.co.liferay.headless.reservation.client.http.HttpInvoker;
import jp.co.liferay.headless.reservation.client.pagination.Page;
import jp.co.liferay.headless.reservation.client.pagination.Pagination;
import jp.co.liferay.headless.reservation.client.resource.v1_0.RoomResource;
import jp.co.liferay.headless.reservation.client.serdes.v1_0.RoomSerDes;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
public abstract class BaseRoomResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();
		testLocale = LocaleUtil.getDefault();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
			}
		};

		Room room1 = randomRoom();

		String json = objectMapper.writeValueAsString(room1);

		Room room2 = RoomSerDes.toDTO(json);

		Assert.assertTrue(equals(room1, room2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
			}
		};

		Room room = randomRoom();

		String json1 = objectMapper.writeValueAsString(room);
		String json2 = RoomSerDes.toJSON(room);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testGetRoomsPage() throws Exception {
		Room room1 = testGetRoomsPage_addRoom(randomRoom());

		Room room2 = testGetRoomsPage_addRoom(randomRoom());

		Page<Room> page = RoomResource.getRoomsPage(
			null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(room1, room2), (List<Room>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetRoomsPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Room room1 = randomRoom();

		room1 = testGetRoomsPage_addRoom(room1);

		for (EntityField entityField : entityFields) {
			Page<Room> page = RoomResource.getRoomsPage(
				null, getFilterString(entityField, "between", room1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(room1), (List<Room>)page.getItems());
		}
	}

	@Test
	public void testGetRoomsPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Room room1 = testGetRoomsPage_addRoom(randomRoom());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Room room2 = testGetRoomsPage_addRoom(randomRoom());

		for (EntityField entityField : entityFields) {
			Page<Room> page = RoomResource.getRoomsPage(
				null, getFilterString(entityField, "eq", room1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(room1), (List<Room>)page.getItems());
		}
	}

	@Test
	public void testGetRoomsPageWithPagination() throws Exception {
		Room room1 = testGetRoomsPage_addRoom(randomRoom());

		Room room2 = testGetRoomsPage_addRoom(randomRoom());

		Room room3 = testGetRoomsPage_addRoom(randomRoom());

		Page<Room> page1 = RoomResource.getRoomsPage(
			null, null, Pagination.of(1, 2), null);

		List<Room> rooms1 = (List<Room>)page1.getItems();

		Assert.assertEquals(rooms1.toString(), 2, rooms1.size());

		Page<Room> page2 = RoomResource.getRoomsPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Room> rooms2 = (List<Room>)page2.getItems();

		Assert.assertEquals(rooms2.toString(), 1, rooms2.size());

		assertEqualsIgnoringOrder(
			Arrays.asList(room1, room2, room3),
			new ArrayList<Room>() {
				{
					addAll(rooms1);
					addAll(rooms2);
				}
			});
	}

	@Test
	public void testGetRoomsPageWithSortDateTime() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Room room1 = randomRoom();
		Room room2 = randomRoom();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(
				room1, entityField.getName(),
				DateUtils.addMinutes(new Date(), -2));
		}

		room1 = testGetRoomsPage_addRoom(room1);

		room2 = testGetRoomsPage_addRoom(room2);

		for (EntityField entityField : entityFields) {
			Page<Room> ascPage = RoomResource.getRoomsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(room1, room2), (List<Room>)ascPage.getItems());

			Page<Room> descPage = RoomResource.getRoomsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(room2, room1), (List<Room>)descPage.getItems());
		}
	}

	@Test
	public void testGetRoomsPageWithSortString() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Room room1 = randomRoom();
		Room room2 = randomRoom();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(room1, entityField.getName(), "Aaa");
			BeanUtils.setProperty(room2, entityField.getName(), "Bbb");
		}

		room1 = testGetRoomsPage_addRoom(room1);

		room2 = testGetRoomsPage_addRoom(room2);

		for (EntityField entityField : entityFields) {
			Page<Room> ascPage = RoomResource.getRoomsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(room1, room2), (List<Room>)ascPage.getItems());

			Page<Room> descPage = RoomResource.getRoomsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(room2, room1), (List<Room>)descPage.getItems());
		}
	}

	protected Room testGetRoomsPage_addRoom(Room room) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostRoom() throws Exception {
		Room randomRoom = randomRoom();

		Room postRoom = testPostRoom_addRoom(randomRoom);

		assertEquals(randomRoom, postRoom);
		assertValid(postRoom);
	}

	protected Room testPostRoom_addRoom(Room room) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteRoom() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGetRoom() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutRoom() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Room room1, Room room2) {
		Assert.assertTrue(
			room1 + " does not equal " + room2, equals(room1, room2));
	}

	protected void assertEquals(List<Room> rooms1, List<Room> rooms2) {
		Assert.assertEquals(rooms1.size(), rooms2.size());

		for (int i = 0; i < rooms1.size(); i++) {
			Room room1 = rooms1.get(i);
			Room room2 = rooms2.get(i);

			assertEquals(room1, room2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Room> rooms1, List<Room> rooms2) {

		Assert.assertEquals(rooms1.size(), rooms2.size());

		for (Room room1 : rooms1) {
			boolean contains = false;

			for (Room room2 : rooms2) {
				if (equals(room1, room2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(rooms2 + " does not contain " + room1, contains);
		}
	}

	protected void assertValid(Room room) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("amenityIds", additionalAssertFieldName)) {
				if (room.getAmenityIds() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("availableEndTime", additionalAssertFieldName)) {
				if (room.getAvailableEndTime() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("availableFriday", additionalAssertFieldName)) {
				if (room.getAvailableFriday() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("availableMonday", additionalAssertFieldName)) {
				if (room.getAvailableMonday() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"availableSaturday", additionalAssertFieldName)) {

				if (room.getAvailableSaturday() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"availableStartTime", additionalAssertFieldName)) {

				if (room.getAvailableStartTime() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("availableSunday", additionalAssertFieldName)) {
				if (room.getAvailableSunday() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"availableThursday", additionalAssertFieldName)) {

				if (room.getAvailableThursday() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("availableTuesday", additionalAssertFieldName)) {
				if (room.getAvailableTuesday() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"availableWednesday", additionalAssertFieldName)) {

				if (room.getAvailableWednesday() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("capacityPeople", additionalAssertFieldName)) {
				if (room.getCapacityPeople() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals(
					"capacitySquareMeters", additionalAssertFieldName)) {

				if (room.getCapacitySquareMeters() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (room.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("officeId", additionalAssertFieldName)) {
				if (room.getOfficeId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("officeName", additionalAssertFieldName)) {
				if (room.getOfficeName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("phoneExtension", additionalAssertFieldName)) {
				if (room.getPhoneExtension() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("photoPath", additionalAssertFieldName)) {
				if (room.getPhotoPath() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("purposeIds", additionalAssertFieldName)) {
				if (room.getPurposeIds() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("roomId", additionalAssertFieldName)) {
				if (room.getRoomId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("wifiPassword", additionalAssertFieldName)) {
				if (room.getWifiPassword() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("wifiSSID", additionalAssertFieldName)) {
				if (room.getWifiSSID() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("wifiSecurityType", additionalAssertFieldName)) {
				if (room.getWifiSecurityType() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Room> page) {
		boolean valid = false;

		Collection<Room> rooms = page.getItems();

		int size = rooms.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected boolean equals(Room room1, Room room2) {
		if (room1 == room2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("amenityIds", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						room1.getAmenityIds(), room2.getAmenityIds())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("availableEndTime", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						room1.getAvailableEndTime(),
						room2.getAvailableEndTime())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("availableFriday", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						room1.getAvailableFriday(),
						room2.getAvailableFriday())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("availableMonday", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						room1.getAvailableMonday(),
						room2.getAvailableMonday())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"availableSaturday", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						room1.getAvailableSaturday(),
						room2.getAvailableSaturday())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"availableStartTime", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						room1.getAvailableStartTime(),
						room2.getAvailableStartTime())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("availableSunday", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						room1.getAvailableSunday(),
						room2.getAvailableSunday())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"availableThursday", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						room1.getAvailableThursday(),
						room2.getAvailableThursday())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("availableTuesday", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						room1.getAvailableTuesday(),
						room2.getAvailableTuesday())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"availableWednesday", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						room1.getAvailableWednesday(),
						room2.getAvailableWednesday())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("capacityPeople", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						room1.getCapacityPeople(), room2.getCapacityPeople())) {

					return false;
				}

				continue;
			}

			if (Objects.equals(
					"capacitySquareMeters", additionalAssertFieldName)) {

				if (!Objects.deepEquals(
						room1.getCapacitySquareMeters(),
						room2.getCapacitySquareMeters())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(room1.getName(), room2.getName())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("officeId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						room1.getOfficeId(), room2.getOfficeId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("officeName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						room1.getOfficeName(), room2.getOfficeName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("phoneExtension", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						room1.getPhoneExtension(), room2.getPhoneExtension())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("photoPath", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						room1.getPhotoPath(), room2.getPhotoPath())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("purposeIds", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						room1.getPurposeIds(), room2.getPurposeIds())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("roomId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(room1.getRoomId(), room2.getRoomId())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("wifiPassword", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						room1.getWifiPassword(), room2.getWifiPassword())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("wifiSSID", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						room1.getWifiSSID(), room2.getWifiSSID())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("wifiSecurityType", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						room1.getWifiSecurityType(),
						room2.getWifiSecurityType())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected Collection<EntityField> getEntityFields() throws Exception {
		if (!(_roomResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_roomResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField -> Objects.equals(entityField.getType(), type)
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Room room) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("amenityIds")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("availableEndTime")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("availableFriday")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("availableMonday")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("availableSaturday")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("availableStartTime")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("availableSunday")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("availableThursday")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("availableTuesday")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("availableWednesday")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("capacityPeople")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("capacitySquareMeters")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(room.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("officeId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("officeName")) {
			sb.append("'");
			sb.append(String.valueOf(room.getOfficeName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("phoneExtension")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("photoPath")) {
			sb.append("'");
			sb.append(String.valueOf(room.getPhotoPath()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("purposeIds")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("roomId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("wifiPassword")) {
			sb.append("'");
			sb.append(String.valueOf(room.getWifiPassword()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("wifiSSID")) {
			sb.append("'");
			sb.append(String.valueOf(room.getWifiSSID()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("wifiSecurityType")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected Room randomRoom() throws Exception {
		return new Room() {
			{
				availableFriday = RandomTestUtil.randomBoolean();
				availableMonday = RandomTestUtil.randomBoolean();
				availableSaturday = RandomTestUtil.randomBoolean();
				availableSunday = RandomTestUtil.randomBoolean();
				availableThursday = RandomTestUtil.randomBoolean();
				availableTuesday = RandomTestUtil.randomBoolean();
				availableWednesday = RandomTestUtil.randomBoolean();
				capacitySquareMeters = RandomTestUtil.randomDouble();
				name = RandomTestUtil.randomString();
				officeId = RandomTestUtil.randomLong();
				officeName = RandomTestUtil.randomString();
				photoPath = RandomTestUtil.randomString();
				roomId = RandomTestUtil.randomLong();
				wifiPassword = RandomTestUtil.randomString();
				wifiSSID = RandomTestUtil.randomString();
			}
		};
	}

	protected Room randomIrrelevantRoom() throws Exception {
		Room randomIrrelevantRoom = randomRoom();

		return randomIrrelevantRoom;
	}

	protected Room randomPatchRoom() throws Exception {
		return randomRoom();
	}

	protected Group irrelevantGroup;
	protected Group testGroup;
	protected Locale testLocale;
	protected String testUserNameAndPassword = "test@liferay.com:test";

	private static final Log _log = LogFactoryUtil.getLog(
		BaseRoomResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private jp.co.liferay.headless.reservation.resource.v1_0.RoomResource
		_roomResource;

}