package jp.co.liferay.headless.reservation.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.function.UnsafeTriConsumer;
import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.search.test.util.SearchTestRule;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_roomResource.setContextCompany(testCompany);

		RoomResource.Builder builder = RoomResource.builder();

		roomResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
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
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
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
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Room room = randomRoom();

		String json1 = objectMapper.writeValueAsString(room);
		String json2 = RoomSerDes.toJSON(room);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Room room = randomRoom();

		room.setName(regex);
		room.setOfficeName(regex);
		room.setPhotoPath(regex);
		room.setWifiPassword(regex);
		room.setWifiSSID(regex);

		String json = RoomSerDes.toJSON(room);

		Assert.assertFalse(json.contains(regex));

		room = RoomSerDes.toDTO(json);

		Assert.assertEquals(regex, room.getName());
		Assert.assertEquals(regex, room.getOfficeName());
		Assert.assertEquals(regex, room.getPhotoPath());
		Assert.assertEquals(regex, room.getWifiPassword());
		Assert.assertEquals(regex, room.getWifiSSID());
	}

	@Test
	public void testGetRoomsPage() throws Exception {
		Page<Room> page = roomResource.getRoomsPage(
			RandomTestUtil.randomString(), null, Pagination.of(1, 2), null);

		Assert.assertEquals(0, page.getTotalCount());

		Room room1 = testGetRoomsPage_addRoom(randomRoom());

		Room room2 = testGetRoomsPage_addRoom(randomRoom());

		page = roomResource.getRoomsPage(null, null, Pagination.of(1, 2), null);

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
			Page<Room> page = roomResource.getRoomsPage(
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
			Page<Room> page = roomResource.getRoomsPage(
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

		Page<Room> page1 = roomResource.getRoomsPage(
			null, null, Pagination.of(1, 2), null);

		List<Room> rooms1 = (List<Room>)page1.getItems();

		Assert.assertEquals(rooms1.toString(), 2, rooms1.size());

		Page<Room> page2 = roomResource.getRoomsPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Room> rooms2 = (List<Room>)page2.getItems();

		Assert.assertEquals(rooms2.toString(), 1, rooms2.size());

		Page<Room> page3 = roomResource.getRoomsPage(
			null, null, Pagination.of(1, 3), null);

		assertEqualsIgnoringOrder(
			Arrays.asList(room1, room2, room3), (List<Room>)page3.getItems());
	}

	@Test
	public void testGetRoomsPageWithSortDateTime() throws Exception {
		testGetRoomsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, room1, room2) -> {
				BeanUtils.setProperty(
					room1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetRoomsPageWithSortInteger() throws Exception {
		testGetRoomsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, room1, room2) -> {
				BeanUtils.setProperty(room1, entityField.getName(), 0);
				BeanUtils.setProperty(room2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetRoomsPageWithSortString() throws Exception {
		testGetRoomsPageWithSort(
			EntityField.Type.STRING,
			(entityField, room1, room2) -> {
				Class<?> clazz = room1.getClass();

				String entityFieldName = entityField.getName();

				Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						room1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						room2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						room1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						room2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						room1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						room2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetRoomsPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Room, Room, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Room room1 = randomRoom();
		Room room2 = randomRoom();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, room1, room2);
		}

		room1 = testGetRoomsPage_addRoom(room1);

		room2 = testGetRoomsPage_addRoom(room2);

		for (EntityField entityField : entityFields) {
			Page<Room> ascPage = roomResource.getRoomsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(room1, room2), (List<Room>)ascPage.getItems());

			Page<Room> descPage = roomResource.getRoomsPage(
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
	public void testGraphQLGetRoomsPage() throws Exception {
		Assert.assertTrue(false);
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
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteRoom() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetRoom() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetRoom() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetRoomNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutRoom() throws Exception {
		Assert.assertTrue(false);
	}

	@Rule
	public SearchTestRule searchTestRule = new SearchTestRule();

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

	protected void assertValid(Room room) throws Exception {
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

		java.util.Collection<Room> rooms = page.getItems();

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

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field :
				ReflectionUtil.getDeclaredFields(
					jp.co.liferay.headless.reservation.dto.v1_0.Room.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					ReflectionUtil.getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
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

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

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

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
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

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
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
				capacityPeople = RandomTestUtil.randomInt();
				capacitySquareMeters = RandomTestUtil.randomDouble();
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				officeId = RandomTestUtil.randomLong();
				officeName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				phoneExtension = RandomTestUtil.randomInt();
				photoPath = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				roomId = RandomTestUtil.randomLong();
				wifiPassword = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				wifiSSID = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				wifiSecurityType = RandomTestUtil.randomInt();
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

	protected RoomResource roomResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(":");
					sb.append(entry.getValue());
					sb.append(",");
				}

				sb.setLength(sb.length() - 1);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(",");
				}

				sb.setLength(sb.length() - 1);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

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