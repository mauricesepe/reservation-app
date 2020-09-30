package jp.co.liferay.headless.reservation.client.resource.v1_0;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

import jp.co.liferay.headless.reservation.client.dto.v1_0.Purpose;
import jp.co.liferay.headless.reservation.client.http.HttpInvoker;
import jp.co.liferay.headless.reservation.client.pagination.Page;
import jp.co.liferay.headless.reservation.client.pagination.Pagination;
import jp.co.liferay.headless.reservation.client.serdes.v1_0.PurposeSerDes;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
public class PurposeResource {

	public static Page<Purpose> getPurposesPage(
			String search, String filterString, Pagination pagination,
			String sortString)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = getPurposesPageHttpResponse(
			search, filterString, pagination, sortString);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		return Page.of(content, PurposeSerDes::toDTO);
	}

	public static HttpInvoker.HttpResponse getPurposesPageHttpResponse(
			String search, String filterString, Pagination pagination,
			String sortString)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		if (search != null) {
			httpInvoker.parameter("search", String.valueOf(search));
		}

		if (filterString != null) {
			httpInvoker.parameter("filter", filterString);
		}

		if (pagination != null) {
			httpInvoker.parameter("page", String.valueOf(pagination.getPage()));
			httpInvoker.parameter(
				"pageSize", String.valueOf(pagination.getPageSize()));
		}

		if (sortString != null) {
			httpInvoker.parameter("sort", sortString);
		}

		httpInvoker.path(
			"http://localhost:8080/o/reservation-headless/v1.0/purposes");

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Purpose postPurpos(Purpose purpose) throws Exception {
		HttpInvoker.HttpResponse httpResponse = postPurposHttpResponse(purpose);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return PurposeSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse postPurposHttpResponse(
			Purpose purpose)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(purpose.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		httpInvoker.path(
			"http://localhost:8080/o/reservation-headless/v1.0/purposes");

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static void deletePurposPurpose(String purposeId) throws Exception {
		HttpInvoker.HttpResponse httpResponse = deletePurposPurposeHttpResponse(
			purposeId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());
	}

	public static HttpInvoker.HttpResponse deletePurposPurposeHttpResponse(
			String purposeId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		httpInvoker.path(
			"http://localhost:8080/o/reservation-headless/v1.0/purposes/{purposeId}",
			purposeId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Purpose getPurposPurpose(String purposeId) throws Exception {
		HttpInvoker.HttpResponse httpResponse = getPurposPurposeHttpResponse(
			purposeId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return PurposeSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse getPurposPurposeHttpResponse(
			String purposeId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		httpInvoker.path(
			"http://localhost:8080/o/reservation-headless/v1.0/purposes/{purposeId}",
			purposeId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Purpose putPurposPurpose(String purposeId, Purpose purpose)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = putPurposPurposeHttpResponse(
			purposeId, purpose);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return PurposeSerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse putPurposPurposeHttpResponse(
			String purposeId, Purpose purpose)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(purpose.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

		httpInvoker.path(
			"http://localhost:8080/o/reservation-headless/v1.0/purposes/{purposeId}",
			purposeId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	private static final Logger _logger = Logger.getLogger(
		PurposeResource.class.getName());

}