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

import jp.co.liferay.headless.reservation.client.dto.v1_0.Office;
import jp.co.liferay.headless.reservation.client.http.HttpInvoker;
import jp.co.liferay.headless.reservation.client.pagination.Page;
import jp.co.liferay.headless.reservation.client.pagination.Pagination;
import jp.co.liferay.headless.reservation.client.resource.v1_0.OfficeResource;
import jp.co.liferay.headless.reservation.client.serdes.v1_0.OfficeSerDes;

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
public abstract class BaseOfficeResourceTestCase {

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

		_officeResource.setContextCompany(testCompany);

		OfficeResource.Builder builder = OfficeResource.builder();

		officeResource = builder.authentication(
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

		Office office1 = randomOffice();

		String json = objectMapper.writeValueAsString(office1);

		Office office2 = OfficeSerDes.toDTO(json);

		Assert.assertTrue(equals(office1, office2));
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

		Office office = randomOffice();

		String json1 = objectMapper.writeValueAsString(office);
		String json2 = OfficeSerDes.toJSON(office);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Office office = randomOffice();

		office.setLocation(regex);
		office.setName(regex);

		String json = OfficeSerDes.toJSON(office);

		Assert.assertFalse(json.contains(regex));

		office = OfficeSerDes.toDTO(json);

		Assert.assertEquals(regex, office.getLocation());
		Assert.assertEquals(regex, office.getName());
	}

	@Test
	public void testGetOfficesPage() throws Exception {
		Page<Office> page = officeResource.getOfficesPage(
			RandomTestUtil.randomString(), null, Pagination.of(1, 2), null);

		Assert.assertEquals(0, page.getTotalCount());

		Office office1 = testGetOfficesPage_addOffice(randomOffice());

		Office office2 = testGetOfficesPage_addOffice(randomOffice());

		page = officeResource.getOfficesPage(
			null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(office1, office2), (List<Office>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetOfficesPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Office office1 = randomOffice();

		office1 = testGetOfficesPage_addOffice(office1);

		for (EntityField entityField : entityFields) {
			Page<Office> page = officeResource.getOfficesPage(
				null, getFilterString(entityField, "between", office1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(office1),
				(List<Office>)page.getItems());
		}
	}

	@Test
	public void testGetOfficesPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Office office1 = testGetOfficesPage_addOffice(randomOffice());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Office office2 = testGetOfficesPage_addOffice(randomOffice());

		for (EntityField entityField : entityFields) {
			Page<Office> page = officeResource.getOfficesPage(
				null, getFilterString(entityField, "eq", office1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(office1),
				(List<Office>)page.getItems());
		}
	}

	@Test
	public void testGetOfficesPageWithPagination() throws Exception {
		Office office1 = testGetOfficesPage_addOffice(randomOffice());

		Office office2 = testGetOfficesPage_addOffice(randomOffice());

		Office office3 = testGetOfficesPage_addOffice(randomOffice());

		Page<Office> page1 = officeResource.getOfficesPage(
			null, null, Pagination.of(1, 2), null);

		List<Office> offices1 = (List<Office>)page1.getItems();

		Assert.assertEquals(offices1.toString(), 2, offices1.size());

		Page<Office> page2 = officeResource.getOfficesPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Office> offices2 = (List<Office>)page2.getItems();

		Assert.assertEquals(offices2.toString(), 1, offices2.size());

		Page<Office> page3 = officeResource.getOfficesPage(
			null, null, Pagination.of(1, 3), null);

		assertEqualsIgnoringOrder(
			Arrays.asList(office1, office2, office3),
			(List<Office>)page3.getItems());
	}

	@Test
	public void testGetOfficesPageWithSortDateTime() throws Exception {
		testGetOfficesPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, office1, office2) -> {
				BeanUtils.setProperty(
					office1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetOfficesPageWithSortInteger() throws Exception {
		testGetOfficesPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, office1, office2) -> {
				BeanUtils.setProperty(office1, entityField.getName(), 0);
				BeanUtils.setProperty(office2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetOfficesPageWithSortString() throws Exception {
		testGetOfficesPageWithSort(
			EntityField.Type.STRING,
			(entityField, office1, office2) -> {
				Class<?> clazz = office1.getClass();

				String entityFieldName = entityField.getName();

				Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						office1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						office2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						office1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						office2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						office1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						office2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetOfficesPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Office, Office, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Office office1 = randomOffice();
		Office office2 = randomOffice();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, office1, office2);
		}

		office1 = testGetOfficesPage_addOffice(office1);

		office2 = testGetOfficesPage_addOffice(office2);

		for (EntityField entityField : entityFields) {
			Page<Office> ascPage = officeResource.getOfficesPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(office1, office2),
				(List<Office>)ascPage.getItems());

			Page<Office> descPage = officeResource.getOfficesPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(office2, office1),
				(List<Office>)descPage.getItems());
		}
	}

	protected Office testGetOfficesPage_addOffice(Office office)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetOfficesPage() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testPostOffice() throws Exception {
		Office randomOffice = randomOffice();

		Office postOffice = testPostOffice_addOffice(randomOffice);

		assertEquals(randomOffice, postOffice);
		assertValid(postOffice);
	}

	protected Office testPostOffice_addOffice(Office office) throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteOffice() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteOffice() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetOffice() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetOffice() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetOfficeNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutOffice() throws Exception {
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

	protected void assertEquals(Office office1, Office office2) {
		Assert.assertTrue(
			office1 + " does not equal " + office2, equals(office1, office2));
	}

	protected void assertEquals(List<Office> offices1, List<Office> offices2) {
		Assert.assertEquals(offices1.size(), offices2.size());

		for (int i = 0; i < offices1.size(); i++) {
			Office office1 = offices1.get(i);
			Office office2 = offices2.get(i);

			assertEquals(office1, office2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Office> offices1, List<Office> offices2) {

		Assert.assertEquals(offices1.size(), offices2.size());

		for (Office office1 : offices1) {
			boolean contains = false;

			for (Office office2 : offices2) {
				if (equals(office1, office2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				offices2 + " does not contain " + office1, contains);
		}
	}

	protected void assertValid(Office office) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("location", additionalAssertFieldName)) {
				if (office.getLocation() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (office.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("officeId", additionalAssertFieldName)) {
				if (office.getOfficeId() == null) {
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

	protected void assertValid(Page<Office> page) {
		boolean valid = false;

		java.util.Collection<Office> offices = page.getItems();

		int size = offices.size();

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
					jp.co.liferay.headless.reservation.dto.v1_0.Office.class)) {

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

	protected boolean equals(Office office1, Office office2) {
		if (office1 == office2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("location", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						office1.getLocation(), office2.getLocation())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(office1.getName(), office2.getName())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("officeId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						office1.getOfficeId(), office2.getOfficeId())) {

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

		if (!(_officeResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_officeResource;

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
		EntityField entityField, String operator, Office office) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("location")) {
			sb.append("'");
			sb.append(String.valueOf(office.getLocation()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(office.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("officeId")) {
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

	protected Office randomOffice() throws Exception {
		return new Office() {
			{
				location = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				name = StringUtil.toLowerCase(RandomTestUtil.randomString());
				officeId = RandomTestUtil.randomLong();
			}
		};
	}

	protected Office randomIrrelevantOffice() throws Exception {
		Office randomIrrelevantOffice = randomOffice();

		return randomIrrelevantOffice;
	}

	protected Office randomPatchOffice() throws Exception {
		return randomOffice();
	}

	protected OfficeResource officeResource;
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
		BaseOfficeResourceTestCase.class);

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
	private jp.co.liferay.headless.reservation.resource.v1_0.OfficeResource
		_officeResource;

}