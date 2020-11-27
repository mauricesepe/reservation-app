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

import jp.co.liferay.headless.reservation.client.dto.v1_0.Participant;
import jp.co.liferay.headless.reservation.client.http.HttpInvoker;
import jp.co.liferay.headless.reservation.client.pagination.Page;
import jp.co.liferay.headless.reservation.client.pagination.Pagination;
import jp.co.liferay.headless.reservation.client.resource.v1_0.ParticipantResource;
import jp.co.liferay.headless.reservation.client.serdes.v1_0.ParticipantSerDes;

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
public abstract class BaseParticipantResourceTestCase {

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

		_participantResource.setContextCompany(testCompany);

		ParticipantResource.Builder builder = ParticipantResource.builder();

		participantResource = builder.authentication(
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

		Participant participant1 = randomParticipant();

		String json = objectMapper.writeValueAsString(participant1);

		Participant participant2 = ParticipantSerDes.toDTO(json);

		Assert.assertTrue(equals(participant1, participant2));
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

		Participant participant = randomParticipant();

		String json1 = objectMapper.writeValueAsString(participant);
		String json2 = ParticipantSerDes.toJSON(participant);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Participant participant = randomParticipant();

		participant.setCompanyName(regex);
		participant.setEmailAddress(regex);
		participant.setFullName(regex);

		String json = ParticipantSerDes.toJSON(participant);

		Assert.assertFalse(json.contains(regex));

		participant = ParticipantSerDes.toDTO(json);

		Assert.assertEquals(regex, participant.getCompanyName());
		Assert.assertEquals(regex, participant.getEmailAddress());
		Assert.assertEquals(regex, participant.getFullName());
	}

	@Test
	public void testGetParticipantsPage() throws Exception {
		Page<Participant> page = participantResource.getParticipantsPage(
			RandomTestUtil.randomString(), null, Pagination.of(1, 2), null);

		Assert.assertEquals(0, page.getTotalCount());

		Participant participant1 = testGetParticipantsPage_addParticipant(
			randomParticipant());

		Participant participant2 = testGetParticipantsPage_addParticipant(
			randomParticipant());

		page = participantResource.getParticipantsPage(
			null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(participant1, participant2),
			(List<Participant>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetParticipantsPageWithFilterDateTimeEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Participant participant1 = randomParticipant();

		participant1 = testGetParticipantsPage_addParticipant(participant1);

		for (EntityField entityField : entityFields) {
			Page<Participant> page = participantResource.getParticipantsPage(
				null, getFilterString(entityField, "between", participant1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(participant1),
				(List<Participant>)page.getItems());
		}
	}

	@Test
	public void testGetParticipantsPageWithFilterStringEquals()
		throws Exception {

		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Participant participant1 = testGetParticipantsPage_addParticipant(
			randomParticipant());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Participant participant2 = testGetParticipantsPage_addParticipant(
			randomParticipant());

		for (EntityField entityField : entityFields) {
			Page<Participant> page = participantResource.getParticipantsPage(
				null, getFilterString(entityField, "eq", participant1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(participant1),
				(List<Participant>)page.getItems());
		}
	}

	@Test
	public void testGetParticipantsPageWithPagination() throws Exception {
		Participant participant1 = testGetParticipantsPage_addParticipant(
			randomParticipant());

		Participant participant2 = testGetParticipantsPage_addParticipant(
			randomParticipant());

		Participant participant3 = testGetParticipantsPage_addParticipant(
			randomParticipant());

		Page<Participant> page1 = participantResource.getParticipantsPage(
			null, null, Pagination.of(1, 2), null);

		List<Participant> participants1 = (List<Participant>)page1.getItems();

		Assert.assertEquals(participants1.toString(), 2, participants1.size());

		Page<Participant> page2 = participantResource.getParticipantsPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Participant> participants2 = (List<Participant>)page2.getItems();

		Assert.assertEquals(participants2.toString(), 1, participants2.size());

		Page<Participant> page3 = participantResource.getParticipantsPage(
			null, null, Pagination.of(1, 3), null);

		assertEqualsIgnoringOrder(
			Arrays.asList(participant1, participant2, participant3),
			(List<Participant>)page3.getItems());
	}

	@Test
	public void testGetParticipantsPageWithSortDateTime() throws Exception {
		testGetParticipantsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, participant1, participant2) -> {
				BeanUtils.setProperty(
					participant1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetParticipantsPageWithSortInteger() throws Exception {
		testGetParticipantsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, participant1, participant2) -> {
				BeanUtils.setProperty(participant1, entityField.getName(), 0);
				BeanUtils.setProperty(participant2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetParticipantsPageWithSortString() throws Exception {
		testGetParticipantsPageWithSort(
			EntityField.Type.STRING,
			(entityField, participant1, participant2) -> {
				Class<?> clazz = participant1.getClass();

				String entityFieldName = entityField.getName();

				Method method = clazz.getMethod(
					"get" + StringUtil.upperCaseFirstLetter(entityFieldName));

				Class<?> returnType = method.getReturnType();

				if (returnType.isAssignableFrom(Map.class)) {
					BeanUtils.setProperty(
						participant1, entityFieldName,
						Collections.singletonMap("Aaa", "Aaa"));
					BeanUtils.setProperty(
						participant2, entityFieldName,
						Collections.singletonMap("Bbb", "Bbb"));
				}
				else if (entityFieldName.contains("email")) {
					BeanUtils.setProperty(
						participant1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
					BeanUtils.setProperty(
						participant2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()) +
									"@liferay.com");
				}
				else {
					BeanUtils.setProperty(
						participant1, entityFieldName,
						"aaa" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
					BeanUtils.setProperty(
						participant2, entityFieldName,
						"bbb" +
							StringUtil.toLowerCase(
								RandomTestUtil.randomString()));
				}
			});
	}

	protected void testGetParticipantsPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Participant, Participant, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Participant participant1 = randomParticipant();
		Participant participant2 = randomParticipant();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, participant1, participant2);
		}

		participant1 = testGetParticipantsPage_addParticipant(participant1);

		participant2 = testGetParticipantsPage_addParticipant(participant2);

		for (EntityField entityField : entityFields) {
			Page<Participant> ascPage = participantResource.getParticipantsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(participant1, participant2),
				(List<Participant>)ascPage.getItems());

			Page<Participant> descPage =
				participantResource.getParticipantsPage(
					null, null, Pagination.of(1, 2),
					entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(participant2, participant1),
				(List<Participant>)descPage.getItems());
		}
	}

	protected Participant testGetParticipantsPage_addParticipant(
			Participant participant)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetParticipantsPage() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testPostParticipant() throws Exception {
		Participant randomParticipant = randomParticipant();

		Participant postParticipant = testPostParticipant_addParticipant(
			randomParticipant);

		assertEquals(randomParticipant, postParticipant);
		assertValid(postParticipant);
	}

	protected Participant testPostParticipant_addParticipant(
			Participant participant)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteParticipant() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLDeleteParticipant() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetParticipant() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGraphQLGetParticipant() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGraphQLGetParticipantNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutParticipant() throws Exception {
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

	protected void assertEquals(
		Participant participant1, Participant participant2) {

		Assert.assertTrue(
			participant1 + " does not equal " + participant2,
			equals(participant1, participant2));
	}

	protected void assertEquals(
		List<Participant> participants1, List<Participant> participants2) {

		Assert.assertEquals(participants1.size(), participants2.size());

		for (int i = 0; i < participants1.size(); i++) {
			Participant participant1 = participants1.get(i);
			Participant participant2 = participants2.get(i);

			assertEquals(participant1, participant2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Participant> participants1, List<Participant> participants2) {

		Assert.assertEquals(participants1.size(), participants2.size());

		for (Participant participant1 : participants1) {
			boolean contains = false;

			for (Participant participant2 : participants2) {
				if (equals(participant1, participant2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				participants2 + " does not contain " + participant1, contains);
		}
	}

	protected void assertValid(Participant participant) throws Exception {
		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("companyName", additionalAssertFieldName)) {
				if (participant.getCompanyName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("emailAddress", additionalAssertFieldName)) {
				if (participant.getEmailAddress() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("fullName", additionalAssertFieldName)) {
				if (participant.getFullName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("participantId", additionalAssertFieldName)) {
				if (participant.getParticipantId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (participant.getUserId() == null) {
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

	protected void assertValid(Page<Participant> page) {
		boolean valid = false;

		java.util.Collection<Participant> participants = page.getItems();

		int size = participants.size();

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
					jp.co.liferay.headless.reservation.dto.v1_0.Participant.
						class)) {

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

	protected boolean equals(
		Participant participant1, Participant participant2) {

		if (participant1 == participant2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("companyName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						participant1.getCompanyName(),
						participant2.getCompanyName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("emailAddress", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						participant1.getEmailAddress(),
						participant2.getEmailAddress())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("fullName", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						participant1.getFullName(),
						participant2.getFullName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("participantId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						participant1.getParticipantId(),
						participant2.getParticipantId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("userId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						participant1.getUserId(), participant2.getUserId())) {

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

		if (!(_participantResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_participantResource;

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
		EntityField entityField, String operator, Participant participant) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("companyName")) {
			sb.append("'");
			sb.append(String.valueOf(participant.getCompanyName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("emailAddress")) {
			sb.append("'");
			sb.append(String.valueOf(participant.getEmailAddress()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("fullName")) {
			sb.append("'");
			sb.append(String.valueOf(participant.getFullName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("participantId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("userId")) {
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

	protected Participant randomParticipant() throws Exception {
		return new Participant() {
			{
				companyName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				emailAddress =
					StringUtil.toLowerCase(RandomTestUtil.randomString()) +
						"@liferay.com";
				fullName = StringUtil.toLowerCase(
					RandomTestUtil.randomString());
				participantId = RandomTestUtil.randomLong();
				userId = RandomTestUtil.randomLong();
			}
		};
	}

	protected Participant randomIrrelevantParticipant() throws Exception {
		Participant randomIrrelevantParticipant = randomParticipant();

		return randomIrrelevantParticipant;
	}

	protected Participant randomPatchParticipant() throws Exception {
		return randomParticipant();
	}

	protected ParticipantResource participantResource;
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
		BaseParticipantResourceTestCase.class);

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
	private jp.co.liferay.headless.reservation.resource.v1_0.ParticipantResource
		_participantResource;

}