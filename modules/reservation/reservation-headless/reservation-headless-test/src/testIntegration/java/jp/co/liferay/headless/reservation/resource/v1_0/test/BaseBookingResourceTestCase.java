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

import jp.co.liferay.headless.reservation.client.dto.v1_0.Booking;
import jp.co.liferay.headless.reservation.client.http.HttpInvoker;
import jp.co.liferay.headless.reservation.client.pagination.Page;
import jp.co.liferay.headless.reservation.client.pagination.Pagination;
import jp.co.liferay.headless.reservation.client.resource.v1_0.BookingResource;
import jp.co.liferay.headless.reservation.client.serdes.v1_0.BookingSerDes;

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
public abstract class BaseBookingResourceTestCase {

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

		Booking booking1 = randomBooking();

		String json = objectMapper.writeValueAsString(booking1);

		Booking booking2 = BookingSerDes.toDTO(json);

		Assert.assertTrue(equals(booking1, booking2));
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

		Booking booking = randomBooking();

		String json1 = objectMapper.writeValueAsString(booking);
		String json2 = BookingSerDes.toJSON(booking);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testGetBookingsPage() throws Exception {
		Booking booking1 = testGetBookingsPage_addBooking(randomBooking());

		Booking booking2 = testGetBookingsPage_addBooking(randomBooking());

		Page<Booking> page = BookingResource.getBookingsPage(
			null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(booking1, booking2), (List<Booking>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetBookingsPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Booking booking1 = randomBooking();

		booking1 = testGetBookingsPage_addBooking(booking1);

		for (EntityField entityField : entityFields) {
			Page<Booking> page = BookingResource.getBookingsPage(
				null, getFilterString(entityField, "between", booking1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(booking1),
				(List<Booking>)page.getItems());
		}
	}

	@Test
	public void testGetBookingsPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Booking booking1 = testGetBookingsPage_addBooking(randomBooking());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Booking booking2 = testGetBookingsPage_addBooking(randomBooking());

		for (EntityField entityField : entityFields) {
			Page<Booking> page = BookingResource.getBookingsPage(
				null, getFilterString(entityField, "eq", booking1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(booking1),
				(List<Booking>)page.getItems());
		}
	}

	@Test
	public void testGetBookingsPageWithPagination() throws Exception {
		Booking booking1 = testGetBookingsPage_addBooking(randomBooking());

		Booking booking2 = testGetBookingsPage_addBooking(randomBooking());

		Booking booking3 = testGetBookingsPage_addBooking(randomBooking());

		Page<Booking> page1 = BookingResource.getBookingsPage(
			null, null, Pagination.of(1, 2), null);

		List<Booking> bookings1 = (List<Booking>)page1.getItems();

		Assert.assertEquals(bookings1.toString(), 2, bookings1.size());

		Page<Booking> page2 = BookingResource.getBookingsPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Booking> bookings2 = (List<Booking>)page2.getItems();

		Assert.assertEquals(bookings2.toString(), 1, bookings2.size());

		assertEqualsIgnoringOrder(
			Arrays.asList(booking1, booking2, booking3),
			new ArrayList<Booking>() {
				{
					addAll(bookings1);
					addAll(bookings2);
				}
			});
	}

	@Test
	public void testGetBookingsPageWithSortDateTime() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Booking booking1 = randomBooking();
		Booking booking2 = randomBooking();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(
				booking1, entityField.getName(),
				DateUtils.addMinutes(new Date(), -2));
		}

		booking1 = testGetBookingsPage_addBooking(booking1);

		booking2 = testGetBookingsPage_addBooking(booking2);

		for (EntityField entityField : entityFields) {
			Page<Booking> ascPage = BookingResource.getBookingsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(booking1, booking2),
				(List<Booking>)ascPage.getItems());

			Page<Booking> descPage = BookingResource.getBookingsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(booking2, booking1),
				(List<Booking>)descPage.getItems());
		}
	}

	@Test
	public void testGetBookingsPageWithSortString() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Booking booking1 = randomBooking();
		Booking booking2 = randomBooking();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(booking1, entityField.getName(), "Aaa");
			BeanUtils.setProperty(booking2, entityField.getName(), "Bbb");
		}

		booking1 = testGetBookingsPage_addBooking(booking1);

		booking2 = testGetBookingsPage_addBooking(booking2);

		for (EntityField entityField : entityFields) {
			Page<Booking> ascPage = BookingResource.getBookingsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(booking1, booking2),
				(List<Booking>)ascPage.getItems());

			Page<Booking> descPage = BookingResource.getBookingsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(booking2, booking1),
				(List<Booking>)descPage.getItems());
		}
	}

	protected Booking testGetBookingsPage_addBooking(Booking booking)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostBooking() throws Exception {
		Booking randomBooking = randomBooking();

		Booking postBooking = testPostBooking_addBooking(randomBooking);

		assertEquals(randomBooking, postBooking);
		assertValid(postBooking);
	}

	protected Booking testPostBooking_addBooking(Booking booking)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteBooking() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGetBooking() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutBooking() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Booking booking1, Booking booking2) {
		Assert.assertTrue(
			booking1 + " does not equal " + booking2,
			equals(booking1, booking2));
	}

	protected void assertEquals(
		List<Booking> bookings1, List<Booking> bookings2) {

		Assert.assertEquals(bookings1.size(), bookings2.size());

		for (int i = 0; i < bookings1.size(); i++) {
			Booking booking1 = bookings1.get(i);
			Booking booking2 = bookings2.get(i);

			assertEquals(booking1, booking2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Booking> bookings1, List<Booking> bookings2) {

		Assert.assertEquals(bookings1.size(), bookings2.size());

		for (Booking booking1 : bookings1) {
			boolean contains = false;

			for (Booking booking2 : bookings2) {
				if (equals(booking1, booking2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				bookings2 + " does not contain " + booking1, contains);
		}
	}

	protected void assertValid(Booking booking) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("bookingId", additionalAssertFieldName)) {
				if (booking.getBookingId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("date", additionalAssertFieldName)) {
				if (booking.getDate() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (booking.getDescription() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("endTime", additionalAssertFieldName)) {
				if (booking.getEndTime() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("officeId", additionalAssertFieldName)) {
				if (booking.getOfficeId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("officeName", additionalAssertFieldName)) {
				if (booking.getOfficeName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("participantIds", additionalAssertFieldName)) {
				if (booking.getParticipantIds() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("roomId", additionalAssertFieldName)) {
				if (booking.getRoomId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("roomName", additionalAssertFieldName)) {
				if (booking.getRoomName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("startTime", additionalAssertFieldName)) {
				if (booking.getStartTime() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (booking.getTitle() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (booking.getUserId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userName", additionalAssertFieldName)) {
				if (booking.getUserName() == null) {
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

	protected void assertValid(Page<Booking> page) {
		boolean valid = false;

		Collection<Booking> bookings = page.getItems();

		int size = bookings.size();

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

	protected boolean equals(Booking booking1, Booking booking2) {
		if (booking1 == booking2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("bookingId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						booking1.getBookingId(), booking2.getBookingId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("date", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						booking1.getDate(), booking2.getDate())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("description", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						booking1.getDescription(), booking2.getDescription())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("endTime", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						booking1.getEndTime(), booking2.getEndTime())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("officeId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						booking1.getOfficeId(), booking2.getOfficeId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("officeName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						booking1.getOfficeName(), booking2.getOfficeName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("participantIds", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						booking1.getParticipantIds(),
						booking2.getParticipantIds())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("roomId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						booking1.getRoomId(), booking2.getRoomId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("roomName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						booking1.getRoomName(), booking2.getRoomName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("startTime", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						booking1.getStartTime(), booking2.getStartTime())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("title", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						booking1.getTitle(), booking2.getTitle())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						booking1.getUserId(), booking2.getUserId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						booking1.getUserName(), booking2.getUserName())) {

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
		if (!(_bookingResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_bookingResource;

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
		EntityField entityField, String operator, Booking booking) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("bookingId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("date")) {
			sb.append("'");
			sb.append(String.valueOf(booking.getDate()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("description")) {
			sb.append("'");
			sb.append(String.valueOf(booking.getDescription()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("endTime")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("officeId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("officeName")) {
			sb.append("'");
			sb.append(String.valueOf(booking.getOfficeName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("participantIds")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("roomId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("roomName")) {
			sb.append("'");
			sb.append(String.valueOf(booking.getRoomName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("startTime")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("title")) {
			sb.append("'");
			sb.append(String.valueOf(booking.getTitle()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("userId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("userName")) {
			sb.append("'");
			sb.append(String.valueOf(booking.getUserName()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected Booking randomBooking() throws Exception {
		return new Booking() {
			{
				bookingId = RandomTestUtil.randomLong();
				date = RandomTestUtil.randomString();
				description = RandomTestUtil.randomString();
				officeId = RandomTestUtil.randomLong();
				officeName = RandomTestUtil.randomString();
				roomId = RandomTestUtil.randomLong();
				roomName = RandomTestUtil.randomString();
				title = RandomTestUtil.randomString();
				userId = RandomTestUtil.randomLong();
				userName = RandomTestUtil.randomString();
			}
		};
	}

	protected Booking randomIrrelevantBooking() throws Exception {
		Booking randomIrrelevantBooking = randomBooking();

		return randomIrrelevantBooking;
	}

	protected Booking randomPatchBooking() throws Exception {
		return randomBooking();
	}

	protected Group irrelevantGroup;
	protected Group testGroup;
	protected Locale testLocale;
	protected String testUserNameAndPassword = "test@liferay.com:test";

	private static final Log _log = LogFactoryUtil.getLog(
		BaseBookingResourceTestCase.class);

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
	private jp.co.liferay.headless.reservation.resource.v1_0.BookingResource
		_bookingResource;

}