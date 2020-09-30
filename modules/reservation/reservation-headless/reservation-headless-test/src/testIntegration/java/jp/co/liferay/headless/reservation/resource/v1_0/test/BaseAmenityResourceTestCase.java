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

import jp.co.liferay.headless.reservation.client.dto.v1_0.Amenity;
import jp.co.liferay.headless.reservation.client.http.HttpInvoker;
import jp.co.liferay.headless.reservation.client.pagination.Page;
import jp.co.liferay.headless.reservation.client.pagination.Pagination;
import jp.co.liferay.headless.reservation.client.resource.v1_0.AmenityResource;
import jp.co.liferay.headless.reservation.client.serdes.v1_0.AmenitySerDes;

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
public abstract class BaseAmenityResourceTestCase {

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

		Amenity amenity1 = randomAmenity();

		String json = objectMapper.writeValueAsString(amenity1);

		Amenity amenity2 = AmenitySerDes.toDTO(json);

		Assert.assertTrue(equals(amenity1, amenity2));
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

		Amenity amenity = randomAmenity();

		String json1 = objectMapper.writeValueAsString(amenity);
		String json2 = AmenitySerDes.toJSON(amenity);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testGetAmenitiesPage() throws Exception {
		Amenity amenity1 = testGetAmenitiesPage_addAmenity(randomAmenity());

		Amenity amenity2 = testGetAmenitiesPage_addAmenity(randomAmenity());

		Page<Amenity> page = AmenityResource.getAmenitiesPage(
			null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(amenity1, amenity2), (List<Amenity>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetAmenitiesPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Amenity amenity1 = randomAmenity();

		amenity1 = testGetAmenitiesPage_addAmenity(amenity1);

		for (EntityField entityField : entityFields) {
			Page<Amenity> page = AmenityResource.getAmenitiesPage(
				null, getFilterString(entityField, "between", amenity1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(amenity1),
				(List<Amenity>)page.getItems());
		}
	}

	@Test
	public void testGetAmenitiesPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Amenity amenity1 = testGetAmenitiesPage_addAmenity(randomAmenity());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Amenity amenity2 = testGetAmenitiesPage_addAmenity(randomAmenity());

		for (EntityField entityField : entityFields) {
			Page<Amenity> page = AmenityResource.getAmenitiesPage(
				null, getFilterString(entityField, "eq", amenity1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(amenity1),
				(List<Amenity>)page.getItems());
		}
	}

	@Test
	public void testGetAmenitiesPageWithPagination() throws Exception {
		Amenity amenity1 = testGetAmenitiesPage_addAmenity(randomAmenity());

		Amenity amenity2 = testGetAmenitiesPage_addAmenity(randomAmenity());

		Amenity amenity3 = testGetAmenitiesPage_addAmenity(randomAmenity());

		Page<Amenity> page1 = AmenityResource.getAmenitiesPage(
			null, null, Pagination.of(1, 2), null);

		List<Amenity> amenities1 = (List<Amenity>)page1.getItems();

		Assert.assertEquals(amenities1.toString(), 2, amenities1.size());

		Page<Amenity> page2 = AmenityResource.getAmenitiesPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Amenity> amenities2 = (List<Amenity>)page2.getItems();

		Assert.assertEquals(amenities2.toString(), 1, amenities2.size());

		assertEqualsIgnoringOrder(
			Arrays.asList(amenity1, amenity2, amenity3),
			new ArrayList<Amenity>() {
				{
					addAll(amenities1);
					addAll(amenities2);
				}
			});
	}

	@Test
	public void testGetAmenitiesPageWithSortDateTime() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Amenity amenity1 = randomAmenity();
		Amenity amenity2 = randomAmenity();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(
				amenity1, entityField.getName(),
				DateUtils.addMinutes(new Date(), -2));
		}

		amenity1 = testGetAmenitiesPage_addAmenity(amenity1);

		amenity2 = testGetAmenitiesPage_addAmenity(amenity2);

		for (EntityField entityField : entityFields) {
			Page<Amenity> ascPage = AmenityResource.getAmenitiesPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(amenity1, amenity2),
				(List<Amenity>)ascPage.getItems());

			Page<Amenity> descPage = AmenityResource.getAmenitiesPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(amenity2, amenity1),
				(List<Amenity>)descPage.getItems());
		}
	}

	@Test
	public void testGetAmenitiesPageWithSortString() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Amenity amenity1 = randomAmenity();
		Amenity amenity2 = randomAmenity();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(amenity1, entityField.getName(), "Aaa");
			BeanUtils.setProperty(amenity2, entityField.getName(), "Bbb");
		}

		amenity1 = testGetAmenitiesPage_addAmenity(amenity1);

		amenity2 = testGetAmenitiesPage_addAmenity(amenity2);

		for (EntityField entityField : entityFields) {
			Page<Amenity> ascPage = AmenityResource.getAmenitiesPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(amenity1, amenity2),
				(List<Amenity>)ascPage.getItems());

			Page<Amenity> descPage = AmenityResource.getAmenitiesPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(amenity2, amenity1),
				(List<Amenity>)descPage.getItems());
		}
	}

	protected Amenity testGetAmenitiesPage_addAmenity(Amenity amenity)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostAmenity() throws Exception {
		Amenity randomAmenity = randomAmenity();

		Amenity postAmenity = testPostAmenity_addAmenity(randomAmenity);

		assertEquals(randomAmenity, postAmenity);
		assertValid(postAmenity);
	}

	protected Amenity testPostAmenity_addAmenity(Amenity amenity)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteAmenity() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGetAmenity() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutAmenity() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Amenity amenity1, Amenity amenity2) {
		Assert.assertTrue(
			amenity1 + " does not equal " + amenity2,
			equals(amenity1, amenity2));
	}

	protected void assertEquals(
		List<Amenity> amenities1, List<Amenity> amenities2) {

		Assert.assertEquals(amenities1.size(), amenities2.size());

		for (int i = 0; i < amenities1.size(); i++) {
			Amenity amenity1 = amenities1.get(i);
			Amenity amenity2 = amenities2.get(i);

			assertEquals(amenity1, amenity2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Amenity> amenities1, List<Amenity> amenities2) {

		Assert.assertEquals(amenities1.size(), amenities2.size());

		for (Amenity amenity1 : amenities1) {
			boolean contains = false;

			for (Amenity amenity2 : amenities2) {
				if (equals(amenity1, amenity2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				amenities2 + " does not contain " + amenity1, contains);
		}
	}

	protected void assertValid(Amenity amenity) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("amenityId", additionalAssertFieldName)) {
				if (amenity.getAmenityId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (amenity.getName() == null) {
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

	protected void assertValid(Page<Amenity> page) {
		boolean valid = false;

		Collection<Amenity> amenities = page.getItems();

		int size = amenities.size();

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

	protected boolean equals(Amenity amenity1, Amenity amenity2) {
		if (amenity1 == amenity2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("amenityId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						amenity1.getAmenityId(), amenity2.getAmenityId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						amenity1.getName(), amenity2.getName())) {

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
		if (!(_amenityResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_amenityResource;

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
		EntityField entityField, String operator, Amenity amenity) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("amenityId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(amenity.getName()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected Amenity randomAmenity() throws Exception {
		return new Amenity() {
			{
				amenityId = RandomTestUtil.randomLong();
				name = RandomTestUtil.randomString();
			}
		};
	}

	protected Amenity randomIrrelevantAmenity() throws Exception {
		Amenity randomIrrelevantAmenity = randomAmenity();

		return randomIrrelevantAmenity;
	}

	protected Amenity randomPatchAmenity() throws Exception {
		return randomAmenity();
	}

	protected Group irrelevantGroup;
	protected Group testGroup;
	protected Locale testLocale;
	protected String testUserNameAndPassword = "test@liferay.com:test";

	private static final Log _log = LogFactoryUtil.getLog(
		BaseAmenityResourceTestCase.class);

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
	private jp.co.liferay.headless.reservation.resource.v1_0.AmenityResource
		_amenityResource;

}