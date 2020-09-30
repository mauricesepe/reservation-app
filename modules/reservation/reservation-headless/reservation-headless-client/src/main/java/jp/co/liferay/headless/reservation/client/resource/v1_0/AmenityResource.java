package jp.co.liferay.headless.reservation.client.resource.v1_0;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

import jp.co.liferay.headless.reservation.client.dto.v1_0.Amenity;
import jp.co.liferay.headless.reservation.client.http.HttpInvoker;
import jp.co.liferay.headless.reservation.client.pagination.Page;
import jp.co.liferay.headless.reservation.client.pagination.Pagination;
import jp.co.liferay.headless.reservation.client.serdes.v1_0.AmenitySerDes;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
public class AmenityResource {

	public static Page<Amenity> getAmenitiesPage(
			String search, String filterString, Pagination pagination,
			String sortString)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = getAmenitiesPageHttpResponse(
			search, filterString, pagination, sortString);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		return Page.of(content, AmenitySerDes::toDTO);
	}

	public static HttpInvoker.HttpResponse getAmenitiesPageHttpResponse(
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
			"http://localhost:8080/o/reservation-headless/v1.0/amenities");

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Amenity postAmenity(Amenity amenity) throws Exception {
		HttpInvoker.HttpResponse httpResponse = postAmenityHttpResponse(
			amenity);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return AmenitySerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse postAmenityHttpResponse(
			Amenity amenity)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(amenity.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

		httpInvoker.path(
			"http://localhost:8080/o/reservation-headless/v1.0/amenities");

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static void deleteAmenity(String amenityId) throws Exception {
		HttpInvoker.HttpResponse httpResponse = deleteAmenityHttpResponse(
			amenityId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());
	}

	public static HttpInvoker.HttpResponse deleteAmenityHttpResponse(
			String amenityId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.DELETE);

		httpInvoker.path(
			"http://localhost:8080/o/reservation-headless/v1.0/amenities/{amenityId}",
			amenityId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Amenity getAmenity(String amenityId) throws Exception {
		HttpInvoker.HttpResponse httpResponse = getAmenityHttpResponse(
			amenityId);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return AmenitySerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse getAmenityHttpResponse(
			String amenityId)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.GET);

		httpInvoker.path(
			"http://localhost:8080/o/reservation-headless/v1.0/amenities/{amenityId}",
			amenityId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	public static Amenity putAmenity(String amenityId, Amenity amenity)
		throws Exception {

		HttpInvoker.HttpResponse httpResponse = putAmenityHttpResponse(
			amenityId, amenity);

		String content = httpResponse.getContent();

		_logger.fine("HTTP response content: " + content);

		_logger.fine("HTTP response message: " + httpResponse.getMessage());
		_logger.fine(
			"HTTP response status code: " + httpResponse.getStatusCode());

		try {
			return AmenitySerDes.toDTO(content);
		}
		catch (Exception e) {
			_logger.log(
				Level.WARNING, "Unable to process HTTP response: " + content,
				e);

			throw e;
		}
	}

	public static HttpInvoker.HttpResponse putAmenityHttpResponse(
			String amenityId, Amenity amenity)
		throws Exception {

		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(amenity.toString(), "application/json");

		httpInvoker.httpMethod(HttpInvoker.HttpMethod.PUT);

		httpInvoker.path(
			"http://localhost:8080/o/reservation-headless/v1.0/amenities/{amenityId}",
			amenityId);

		httpInvoker.userNameAndPassword("test@liferay.com:test");

		return httpInvoker.invoke();
	}

	private static final Logger _logger = Logger.getLogger(
		AmenityResource.class.getName());

}