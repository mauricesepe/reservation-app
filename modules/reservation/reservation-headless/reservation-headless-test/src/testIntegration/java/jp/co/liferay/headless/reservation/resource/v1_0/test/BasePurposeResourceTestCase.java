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

import jp.co.liferay.headless.reservation.client.dto.v1_0.Purpose;
import jp.co.liferay.headless.reservation.client.http.HttpInvoker;
import jp.co.liferay.headless.reservation.client.pagination.Page;
import jp.co.liferay.headless.reservation.client.pagination.Pagination;
import jp.co.liferay.headless.reservation.client.resource.v1_0.PurposeResource;
import jp.co.liferay.headless.reservation.client.serdes.v1_0.PurposeSerDes;

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
public abstract class BasePurposeResourceTestCase {

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

		Purpose purpose1 = randomPurpose();

		String json = objectMapper.writeValueAsString(purpose1);

		Purpose purpose2 = PurposeSerDes.toDTO(json);

		Assert.assertTrue(equals(purpose1, purpose2));
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

		Purpose purpose = randomPurpose();

		String json1 = objectMapper.writeValueAsString(purpose);
		String json2 = PurposeSerDes.toJSON(purpose);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testGetPurposesPage() throws Exception {
		Purpose purpose1 = testGetPurposesPage_addPurpose(randomPurpose());

		Purpose purpose2 = testGetPurposesPage_addPurpose(randomPurpose());

		Page<Purpose> page = PurposeResource.getPurposesPage(
			null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(purpose1, purpose2), (List<Purpose>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetPurposesPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Purpose purpose1 = randomPurpose();

		purpose1 = testGetPurposesPage_addPurpose(purpose1);

		for (EntityField entityField : entityFields) {
			Page<Purpose> page = PurposeResource.getPurposesPage(
				null, getFilterString(entityField, "between", purpose1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(purpose1),
				(List<Purpose>)page.getItems());
		}
	}

	@Test
	public void testGetPurposesPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Purpose purpose1 = testGetPurposesPage_addPurpose(randomPurpose());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Purpose purpose2 = testGetPurposesPage_addPurpose(randomPurpose());

		for (EntityField entityField : entityFields) {
			Page<Purpose> page = PurposeResource.getPurposesPage(
				null, getFilterString(entityField, "eq", purpose1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(purpose1),
				(List<Purpose>)page.getItems());
		}
	}

	@Test
	public void testGetPurposesPageWithPagination() throws Exception {
		Purpose purpose1 = testGetPurposesPage_addPurpose(randomPurpose());

		Purpose purpose2 = testGetPurposesPage_addPurpose(randomPurpose());

		Purpose purpose3 = testGetPurposesPage_addPurpose(randomPurpose());

		Page<Purpose> page1 = PurposeResource.getPurposesPage(
			null, null, Pagination.of(1, 2), null);

		List<Purpose> purposes1 = (List<Purpose>)page1.getItems();

		Assert.assertEquals(purposes1.toString(), 2, purposes1.size());

		Page<Purpose> page2 = PurposeResource.getPurposesPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Purpose> purposes2 = (List<Purpose>)page2.getItems();

		Assert.assertEquals(purposes2.toString(), 1, purposes2.size());

		assertEqualsIgnoringOrder(
			Arrays.asList(purpose1, purpose2, purpose3),
			new ArrayList<Purpose>() {
				{
					addAll(purposes1);
					addAll(purposes2);
				}
			});
	}

	@Test
	public void testGetPurposesPageWithSortDateTime() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Purpose purpose1 = randomPurpose();
		Purpose purpose2 = randomPurpose();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(
				purpose1, entityField.getName(),
				DateUtils.addMinutes(new Date(), -2));
		}

		purpose1 = testGetPurposesPage_addPurpose(purpose1);

		purpose2 = testGetPurposesPage_addPurpose(purpose2);

		for (EntityField entityField : entityFields) {
			Page<Purpose> ascPage = PurposeResource.getPurposesPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(purpose1, purpose2),
				(List<Purpose>)ascPage.getItems());

			Page<Purpose> descPage = PurposeResource.getPurposesPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(purpose2, purpose1),
				(List<Purpose>)descPage.getItems());
		}
	}

	@Test
	public void testGetPurposesPageWithSortString() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Purpose purpose1 = randomPurpose();
		Purpose purpose2 = randomPurpose();

		for (EntityField entityField : entityFields) {
			BeanUtils.setProperty(purpose1, entityField.getName(), "Aaa");
			BeanUtils.setProperty(purpose2, entityField.getName(), "Bbb");
		}

		purpose1 = testGetPurposesPage_addPurpose(purpose1);

		purpose2 = testGetPurposesPage_addPurpose(purpose2);

		for (EntityField entityField : entityFields) {
			Page<Purpose> ascPage = PurposeResource.getPurposesPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(purpose1, purpose2),
				(List<Purpose>)ascPage.getItems());

			Page<Purpose> descPage = PurposeResource.getPurposesPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(purpose2, purpose1),
				(List<Purpose>)descPage.getItems());
		}
	}

	protected Purpose testGetPurposesPage_addPurpose(Purpose purpose)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testPostPurpos() throws Exception {
		Purpose randomPurpose = randomPurpose();

		Purpose postPurpose = testPostPurpos_addPurpose(randomPurpose);

		assertEquals(randomPurpose, postPurpose);
		assertValid(postPurpose);
	}

	protected Purpose testPostPurpos_addPurpose(Purpose purpose)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeletePurposPurpose() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGetPurposPurpose() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutPurposPurpose() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Purpose purpose1, Purpose purpose2) {
		Assert.assertTrue(
			purpose1 + " does not equal " + purpose2,
			equals(purpose1, purpose2));
	}

	protected void assertEquals(
		List<Purpose> purposes1, List<Purpose> purposes2) {

		Assert.assertEquals(purposes1.size(), purposes2.size());

		for (int i = 0; i < purposes1.size(); i++) {
			Purpose purpose1 = purposes1.get(i);
			Purpose purpose2 = purposes2.get(i);

			assertEquals(purpose1, purpose2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Purpose> purposes1, List<Purpose> purposes2) {

		Assert.assertEquals(purposes1.size(), purposes2.size());

		for (Purpose purpose1 : purposes1) {
			boolean contains = false;

			for (Purpose purpose2 : purposes2) {
				if (equals(purpose1, purpose2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				purposes2 + " does not contain " + purpose1, contains);
		}
	}

	protected void assertValid(Purpose purpose) {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (purpose.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("purposeId", additionalAssertFieldName)) {
				if (purpose.getPurposeId() == null) {
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

	protected void assertValid(Page<Purpose> page) {
		boolean valid = false;

		Collection<Purpose> purposes = page.getItems();

		int size = purposes.size();

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

	protected boolean equals(Purpose purpose1, Purpose purpose2) {
		if (purpose1 == purpose2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						purpose1.getName(), purpose2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("purposeId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						purpose1.getPurposeId(), purpose2.getPurposeId())) {

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
		if (!(_purposeResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_purposeResource;

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
		EntityField entityField, String operator, Purpose purpose) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(purpose.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("purposeId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected Purpose randomPurpose() throws Exception {
		return new Purpose() {
			{
				name = RandomTestUtil.randomString();
				purposeId = RandomTestUtil.randomLong();
			}
		};
	}

	protected Purpose randomIrrelevantPurpose() throws Exception {
		Purpose randomIrrelevantPurpose = randomPurpose();

		return randomIrrelevantPurpose;
	}

	protected Purpose randomPatchPurpose() throws Exception {
		return randomPurpose();
	}

	protected Group irrelevantGroup;
	protected Group testGroup;
	protected Locale testLocale;
	protected String testUserNameAndPassword = "test@liferay.com:test";

	private static final Log _log = LogFactoryUtil.getLog(
		BasePurposeResourceTestCase.class);

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
	private jp.co.liferay.headless.reservation.resource.v1_0.PurposeResource
		_purposeResource;

}