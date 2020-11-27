package jp.co.liferay.headless.reservation.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLTypeExtension;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import jp.co.liferay.headless.reservation.dto.v1_0.Amenity;
import jp.co.liferay.headless.reservation.dto.v1_0.Booking;
import jp.co.liferay.headless.reservation.dto.v1_0.Office;
import jp.co.liferay.headless.reservation.dto.v1_0.Participant;
import jp.co.liferay.headless.reservation.dto.v1_0.Purpose;
import jp.co.liferay.headless.reservation.dto.v1_0.Room;
import jp.co.liferay.headless.reservation.resource.v1_0.AmenityResource;
import jp.co.liferay.headless.reservation.resource.v1_0.BookingResource;
import jp.co.liferay.headless.reservation.resource.v1_0.OfficeResource;
import jp.co.liferay.headless.reservation.resource.v1_0.ParticipantResource;
import jp.co.liferay.headless.reservation.resource.v1_0.PurposeResource;
import jp.co.liferay.headless.reservation.resource.v1_0.RoomResource;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author Maurice Sepe
 * @generated
 */
@Generated("")
public class Query {

	public static void setAmenityResourceComponentServiceObjects(
		ComponentServiceObjects<AmenityResource>
			amenityResourceComponentServiceObjects) {

		_amenityResourceComponentServiceObjects =
			amenityResourceComponentServiceObjects;
	}

	public static void setBookingResourceComponentServiceObjects(
		ComponentServiceObjects<BookingResource>
			bookingResourceComponentServiceObjects) {

		_bookingResourceComponentServiceObjects =
			bookingResourceComponentServiceObjects;
	}

	public static void setOfficeResourceComponentServiceObjects(
		ComponentServiceObjects<OfficeResource>
			officeResourceComponentServiceObjects) {

		_officeResourceComponentServiceObjects =
			officeResourceComponentServiceObjects;
	}

	public static void setParticipantResourceComponentServiceObjects(
		ComponentServiceObjects<ParticipantResource>
			participantResourceComponentServiceObjects) {

		_participantResourceComponentServiceObjects =
			participantResourceComponentServiceObjects;
	}

	public static void setPurposeResourceComponentServiceObjects(
		ComponentServiceObjects<PurposeResource>
			purposeResourceComponentServiceObjects) {

		_purposeResourceComponentServiceObjects =
			purposeResourceComponentServiceObjects;
	}

	public static void setRoomResourceComponentServiceObjects(
		ComponentServiceObjects<RoomResource>
			roomResourceComponentServiceObjects) {

		_roomResourceComponentServiceObjects =
			roomResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {offices(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieve the list of offices. Results can be paginated, filtered, searched and sorted."
	)
	public OfficePage offices(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_officeResourceComponentServiceObjects,
			this::_populateResourceContext,
			officeResource -> new OfficePage(
				officeResource.getOfficesPage(
					search,
					_filterBiFunction.apply(officeResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(officeResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {office(officeId: ___){officeId, name, location}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the office via its ID")
	public Office office(@GraphQLName("officeId") String officeId)
		throws Exception {

		return _applyComponentServiceObjects(
			_officeResourceComponentServiceObjects,
			this::_populateResourceContext,
			officeResource -> officeResource.getOffice(officeId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {participants(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieve the list of offices. Results can be paginated, filtered, searched and sorted."
	)
	public ParticipantPage participants(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_participantResourceComponentServiceObjects,
			this::_populateResourceContext,
			participantResource -> new ParticipantPage(
				participantResource.getParticipantsPage(
					search,
					_filterBiFunction.apply(participantResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(participantResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {participant(participantId: ___){participantId, userId, fullName, companyName, emailAddress}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the participant via its ID.")
	public Participant participant(
			@GraphQLName("participantId") String participantId)
		throws Exception {

		return _applyComponentServiceObjects(
			_participantResourceComponentServiceObjects,
			this::_populateResourceContext,
			participantResource -> participantResource.getParticipant(
				participantId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {amenities(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieve the list of amenities. Results can be paginated, filtered, searched and sorted."
	)
	public AmenityPage amenities(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_amenityResourceComponentServiceObjects,
			this::_populateResourceContext,
			amenityResource -> new AmenityPage(
				amenityResource.getAmenitiesPage(
					search,
					_filterBiFunction.apply(amenityResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(amenityResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {amenity(amenityId: ___){amenityId, name}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the amenity via its ID.")
	public Amenity amenity(@GraphQLName("amenityId") String amenityId)
		throws Exception {

		return _applyComponentServiceObjects(
			_amenityResourceComponentServiceObjects,
			this::_populateResourceContext,
			amenityResource -> amenityResource.getAmenity(amenityId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {purposes(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieve the list of purposes. Results can be paginated, filtered, searched and sorted."
	)
	public PurposePage purposes(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_purposeResourceComponentServiceObjects,
			this::_populateResourceContext,
			purposeResource -> new PurposePage(
				purposeResource.getPurposesPage(
					search,
					_filterBiFunction.apply(purposeResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(purposeResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {purposPurpose(purposeId: ___){purposeId, name}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the purpose via its ID.")
	public Purpose purposPurpose(@GraphQLName("purposeId") String purposeId)
		throws Exception {

		return _applyComponentServiceObjects(
			_purposeResourceComponentServiceObjects,
			this::_populateResourceContext,
			purposeResource -> purposeResource.getPurposPurpose(purposeId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {rooms(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieve the list of rooms. Results can be paginated, filtered, searched and sorted."
	)
	public RoomPage rooms(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_roomResourceComponentServiceObjects,
			this::_populateResourceContext,
			roomResource -> new RoomPage(
				roomResource.getRoomsPage(
					search, _filterBiFunction.apply(roomResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(roomResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {room(roomId: ___){roomId, name, photoPath, availableMonday, availableTuesday, availableWednesday, availableThursday, availableFriday, availableSaturday, availableSunday, availableStartTime, availableEndTime, officeId, officeName, capacitySquareMeters, capacityPeople, phoneExtension, wifiSSID, wifiSecurityType, wifiPassword, amenityIds, purposeIds}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the room via its ID.")
	public Room room(@GraphQLName("roomId") String roomId) throws Exception {
		return _applyComponentServiceObjects(
			_roomResourceComponentServiceObjects,
			this::_populateResourceContext,
			roomResource -> roomResource.getRoom(roomId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {bookings(filter: ___, page: ___, pageSize: ___, search: ___, sorts: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(
		description = "Retrieve the list of bookings. Results can be paginated, filtered, searched and sorted."
	)
	public BookingPage bookings(
			@GraphQLName("search") String search,
			@GraphQLName("filter") String filterString,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page,
			@GraphQLName("sort") String sortsString)
		throws Exception {

		return _applyComponentServiceObjects(
			_bookingResourceComponentServiceObjects,
			this::_populateResourceContext,
			bookingResource -> new BookingPage(
				bookingResource.getBookingsPage(
					search,
					_filterBiFunction.apply(bookingResource, filterString),
					Pagination.of(page, pageSize),
					_sortsBiFunction.apply(bookingResource, sortsString))));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {booking(bookingId: ___){bookingId, title, date, startTime, endTime, roomId, roomName, officeId, officeName, description, userId, userName, participantIds}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Retrieves the booking via its ID.")
	public Booking booking(@GraphQLName("bookingId") String bookingId)
		throws Exception {

		return _applyComponentServiceObjects(
			_bookingResourceComponentServiceObjects,
			this::_populateResourceContext,
			bookingResource -> bookingResource.getBooking(bookingId));
	}

	@GraphQLTypeExtension(Booking.class)
	public class GetRoomTypeExtension {

		public GetRoomTypeExtension(Booking booking) {
			_booking = booking;
		}

		@GraphQLField(description = "Retrieves the room via its ID.")
		public Room room() throws Exception {
			return _applyComponentServiceObjects(
				_roomResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				roomResource -> roomResource.getRoom(_booking.getRoomId().toString()));
		}

		private Booking _booking;

	}

	@GraphQLTypeExtension(Booking.class)
	public class GetOfficeTypeExtension {

		public GetOfficeTypeExtension(Booking booking) {
			_booking = booking;
		}

		@GraphQLField(description = "Retrieves the office via its ID")
		public Office office() throws Exception {
			return _applyComponentServiceObjects(
				_officeResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				officeResource -> officeResource.getOffice(
					_booking.getOfficeId().toString()));
		}

		private Booking _booking;

	}

	@GraphQLName("AmenityPage")
	public class AmenityPage {

		public AmenityPage(Page amenityPage) {
			actions = amenityPage.getActions();

			items = amenityPage.getItems();
			lastPage = amenityPage.getLastPage();
			page = amenityPage.getPage();
			pageSize = amenityPage.getPageSize();
			totalCount = amenityPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Amenity> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("BookingPage")
	public class BookingPage {

		public BookingPage(Page bookingPage) {
			actions = bookingPage.getActions();

			items = bookingPage.getItems();
			lastPage = bookingPage.getLastPage();
			page = bookingPage.getPage();
			pageSize = bookingPage.getPageSize();
			totalCount = bookingPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Booking> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("OfficePage")
	public class OfficePage {

		public OfficePage(Page officePage) {
			actions = officePage.getActions();

			items = officePage.getItems();
			lastPage = officePage.getLastPage();
			page = officePage.getPage();
			pageSize = officePage.getPageSize();
			totalCount = officePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Office> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("ParticipantPage")
	public class ParticipantPage {

		public ParticipantPage(Page participantPage) {
			actions = participantPage.getActions();

			items = participantPage.getItems();
			lastPage = participantPage.getLastPage();
			page = participantPage.getPage();
			pageSize = participantPage.getPageSize();
			totalCount = participantPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Participant> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("PurposePage")
	public class PurposePage {

		public PurposePage(Page purposePage) {
			actions = purposePage.getActions();

			items = purposePage.getItems();
			lastPage = purposePage.getLastPage();
			page = purposePage.getPage();
			pageSize = purposePage.getPageSize();
			totalCount = purposePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Purpose> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("RoomPage")
	public class RoomPage {

		public RoomPage(Page roomPage) {
			actions = roomPage.getActions();

			items = roomPage.getItems();
			lastPage = roomPage.getLastPage();
			page = roomPage.getPage();
			pageSize = roomPage.getPageSize();
			totalCount = roomPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Room> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(AmenityResource amenityResource)
		throws Exception {

		amenityResource.setContextAcceptLanguage(_acceptLanguage);
		amenityResource.setContextCompany(_company);
		amenityResource.setContextHttpServletRequest(_httpServletRequest);
		amenityResource.setContextHttpServletResponse(_httpServletResponse);
		amenityResource.setContextUriInfo(_uriInfo);
		amenityResource.setContextUser(_user);
		amenityResource.setGroupLocalService(_groupLocalService);
		amenityResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(BookingResource bookingResource)
		throws Exception {

		bookingResource.setContextAcceptLanguage(_acceptLanguage);
		bookingResource.setContextCompany(_company);
		bookingResource.setContextHttpServletRequest(_httpServletRequest);
		bookingResource.setContextHttpServletResponse(_httpServletResponse);
		bookingResource.setContextUriInfo(_uriInfo);
		bookingResource.setContextUser(_user);
		bookingResource.setGroupLocalService(_groupLocalService);
		bookingResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(OfficeResource officeResource)
		throws Exception {

		officeResource.setContextAcceptLanguage(_acceptLanguage);
		officeResource.setContextCompany(_company);
		officeResource.setContextHttpServletRequest(_httpServletRequest);
		officeResource.setContextHttpServletResponse(_httpServletResponse);
		officeResource.setContextUriInfo(_uriInfo);
		officeResource.setContextUser(_user);
		officeResource.setGroupLocalService(_groupLocalService);
		officeResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			ParticipantResource participantResource)
		throws Exception {

		participantResource.setContextAcceptLanguage(_acceptLanguage);
		participantResource.setContextCompany(_company);
		participantResource.setContextHttpServletRequest(_httpServletRequest);
		participantResource.setContextHttpServletResponse(_httpServletResponse);
		participantResource.setContextUriInfo(_uriInfo);
		participantResource.setContextUser(_user);
		participantResource.setGroupLocalService(_groupLocalService);
		participantResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(PurposeResource purposeResource)
		throws Exception {

		purposeResource.setContextAcceptLanguage(_acceptLanguage);
		purposeResource.setContextCompany(_company);
		purposeResource.setContextHttpServletRequest(_httpServletRequest);
		purposeResource.setContextHttpServletResponse(_httpServletResponse);
		purposeResource.setContextUriInfo(_uriInfo);
		purposeResource.setContextUser(_user);
		purposeResource.setGroupLocalService(_groupLocalService);
		purposeResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(RoomResource roomResource)
		throws Exception {

		roomResource.setContextAcceptLanguage(_acceptLanguage);
		roomResource.setContextCompany(_company);
		roomResource.setContextHttpServletRequest(_httpServletRequest);
		roomResource.setContextHttpServletResponse(_httpServletResponse);
		roomResource.setContextUriInfo(_uriInfo);
		roomResource.setContextUser(_user);
		roomResource.setGroupLocalService(_groupLocalService);
		roomResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<AmenityResource>
		_amenityResourceComponentServiceObjects;
	private static ComponentServiceObjects<BookingResource>
		_bookingResourceComponentServiceObjects;
	private static ComponentServiceObjects<OfficeResource>
		_officeResourceComponentServiceObjects;
	private static ComponentServiceObjects<ParticipantResource>
		_participantResourceComponentServiceObjects;
	private static ComponentServiceObjects<PurposeResource>
		_purposeResourceComponentServiceObjects;
	private static ComponentServiceObjects<RoomResource>
		_roomResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}