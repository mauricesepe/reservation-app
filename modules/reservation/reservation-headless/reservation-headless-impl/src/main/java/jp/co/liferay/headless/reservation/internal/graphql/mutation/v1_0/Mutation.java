package jp.co.liferay.headless.reservation.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.Response;
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
public class Mutation {

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

	@GraphQLField(description = "Create a new office entity.")
	public Office createOffice(@GraphQLName("office") Office office)
		throws Exception {

		return _applyComponentServiceObjects(
			_officeResourceComponentServiceObjects,
			this::_populateResourceContext,
			officeResource -> officeResource.postOffice(office));
	}

	@GraphQLField
	public Response createOfficeBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_officeResourceComponentServiceObjects,
			this::_populateResourceContext,
			officeResource -> officeResource.postOfficeBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Deletes the target office entity.")
	public boolean deleteOffice(@GraphQLName("officeId") String officeId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_officeResourceComponentServiceObjects,
			this::_populateResourceContext,
			officeResource -> officeResource.deleteOffice(officeId));

		return true;
	}

	@GraphQLField
	public Response deleteOfficeBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_officeResourceComponentServiceObjects,
			this::_populateResourceContext,
			officeResource -> officeResource.deleteOfficeBatch(
				callbackURL, object));
	}

	@GraphQLField(
		description = "Updates and overwrites existing office entity."
	)
	public Office updateOffice(
			@GraphQLName("officeId") String officeId,
			@GraphQLName("office") Office office)
		throws Exception {

		return _applyComponentServiceObjects(
			_officeResourceComponentServiceObjects,
			this::_populateResourceContext,
			officeResource -> officeResource.putOffice(officeId, office));
	}

	@GraphQLField
	public Response updateOfficeBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_officeResourceComponentServiceObjects,
			this::_populateResourceContext,
			officeResource -> officeResource.putOfficeBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Create a new participant entity.")
	public Participant createParticipant(
			@GraphQLName("participant") Participant participant)
		throws Exception {

		return _applyComponentServiceObjects(
			_participantResourceComponentServiceObjects,
			this::_populateResourceContext,
			participantResource -> participantResource.postParticipant(
				participant));
	}

	@GraphQLField
	public Response createParticipantBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_participantResourceComponentServiceObjects,
			this::_populateResourceContext,
			participantResource -> participantResource.postParticipantBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Deletes the target participant")
	public boolean deleteParticipant(
			@GraphQLName("participantId") String participantId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_participantResourceComponentServiceObjects,
			this::_populateResourceContext,
			participantResource -> participantResource.deleteParticipant(
				participantId));

		return true;
	}

	@GraphQLField
	public Response deleteParticipantBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_participantResourceComponentServiceObjects,
			this::_populateResourceContext,
			participantResource -> participantResource.deleteParticipantBatch(
				callbackURL, object));
	}

	@GraphQLField(
		description = "Updates and overwrites the target participant."
	)
	public Participant updateParticipant(
			@GraphQLName("participantId") String participantId,
			@GraphQLName("participant") Participant participant)
		throws Exception {

		return _applyComponentServiceObjects(
			_participantResourceComponentServiceObjects,
			this::_populateResourceContext,
			participantResource -> participantResource.putParticipant(
				participantId, participant));
	}

	@GraphQLField
	public Response updateParticipantBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_participantResourceComponentServiceObjects,
			this::_populateResourceContext,
			participantResource -> participantResource.putParticipantBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Create a new amenity.")
	public Amenity createAmenity(@GraphQLName("amenity") Amenity amenity)
		throws Exception {

		return _applyComponentServiceObjects(
			_amenityResourceComponentServiceObjects,
			this::_populateResourceContext,
			amenityResource -> amenityResource.postAmenity(amenity));
	}

	@GraphQLField
	public Response createAmenityBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_amenityResourceComponentServiceObjects,
			this::_populateResourceContext,
			amenityResource -> amenityResource.postAmenityBatch(
				callbackURL, object));
	}

	@GraphQLField(
		description = "Deletes the amenity and returns a 204 if the operation succeeds."
	)
	public boolean deleteAmenity(@GraphQLName("amenityId") String amenityId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_amenityResourceComponentServiceObjects,
			this::_populateResourceContext,
			amenityResource -> amenityResource.deleteAmenity(amenityId));

		return true;
	}

	@GraphQLField
	public Response deleteAmenityBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_amenityResourceComponentServiceObjects,
			this::_populateResourceContext,
			amenityResource -> amenityResource.deleteAmenityBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Updates and overwrites the amenity.")
	public Amenity updateAmenity(
			@GraphQLName("amenityId") String amenityId,
			@GraphQLName("amenity") Amenity amenity)
		throws Exception {

		return _applyComponentServiceObjects(
			_amenityResourceComponentServiceObjects,
			this::_populateResourceContext,
			amenityResource -> amenityResource.putAmenity(amenityId, amenity));
	}

	@GraphQLField
	public Response updateAmenityBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_amenityResourceComponentServiceObjects,
			this::_populateResourceContext,
			amenityResource -> amenityResource.putAmenityBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Create a new purpose tag.")
	public Purpose createPurpos(@GraphQLName("purpose") Purpose purpose)
		throws Exception {

		return _applyComponentServiceObjects(
			_purposeResourceComponentServiceObjects,
			this::_populateResourceContext,
			purposeResource -> purposeResource.postPurpos(purpose));
	}

	@GraphQLField(
		description = "Deletes the purpose and returns a 204 if the operation succeeds."
	)
	public boolean deletePurposPurpose(
			@GraphQLName("purposeId") String purposeId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_purposeResourceComponentServiceObjects,
			this::_populateResourceContext,
			purposeResource -> purposeResource.deletePurposPurpose(purposeId));

		return true;
	}

	@GraphQLField(description = "Updates and overwrites the target purpose.")
	public Purpose updatePurposPurpose(
			@GraphQLName("purposeId") String purposeId,
			@GraphQLName("purpose") Purpose purpose)
		throws Exception {

		return _applyComponentServiceObjects(
			_purposeResourceComponentServiceObjects,
			this::_populateResourceContext,
			purposeResource -> purposeResource.putPurposPurpose(
				purposeId, purpose));
	}

	@GraphQLField(description = "Create a new room.")
	public Room createRoom(@GraphQLName("room") Room room) throws Exception {
		return _applyComponentServiceObjects(
			_roomResourceComponentServiceObjects,
			this::_populateResourceContext,
			roomResource -> roomResource.postRoom(room));
	}

	@GraphQLField
	public Response createRoomBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_roomResourceComponentServiceObjects,
			this::_populateResourceContext,
			roomResource -> roomResource.postRoomBatch(callbackURL, object));
	}

	@GraphQLField(
		description = "Deletes the room and returns a 204 if the operation succeeds."
	)
	public boolean deleteRoom(@GraphQLName("roomId") String roomId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_roomResourceComponentServiceObjects,
			this::_populateResourceContext,
			roomResource -> roomResource.deleteRoom(roomId));

		return true;
	}

	@GraphQLField
	public Response deleteRoomBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_roomResourceComponentServiceObjects,
			this::_populateResourceContext,
			roomResource -> roomResource.deleteRoomBatch(callbackURL, object));
	}

	@GraphQLField(description = "Updates and overwrites target room details.")
	public Room updateRoom(
			@GraphQLName("roomId") String roomId,
			@GraphQLName("room") Room room)
		throws Exception {

		return _applyComponentServiceObjects(
			_roomResourceComponentServiceObjects,
			this::_populateResourceContext,
			roomResource -> roomResource.putRoom(roomId, room));
	}

	@GraphQLField
	public Response updateRoomBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_roomResourceComponentServiceObjects,
			this::_populateResourceContext,
			roomResource -> roomResource.putRoomBatch(callbackURL, object));
	}

	@GraphQLField(description = "Create a new booking.")
	public Booking createBooking(@GraphQLName("booking") Booking booking)
		throws Exception {

		return _applyComponentServiceObjects(
			_bookingResourceComponentServiceObjects,
			this::_populateResourceContext,
			bookingResource -> bookingResource.postBooking(booking));
	}

	@GraphQLField
	public Response createBookingBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_bookingResourceComponentServiceObjects,
			this::_populateResourceContext,
			bookingResource -> bookingResource.postBookingBatch(
				callbackURL, object));
	}

	@GraphQLField(
		description = "Deletes the booking and returns a 204 if the operation succeeds."
	)
	public boolean deleteBooking(@GraphQLName("bookingId") String bookingId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_bookingResourceComponentServiceObjects,
			this::_populateResourceContext,
			bookingResource -> bookingResource.deleteBooking(bookingId));

		return true;
	}

	@GraphQLField
	public Response deleteBookingBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_bookingResourceComponentServiceObjects,
			this::_populateResourceContext,
			bookingResource -> bookingResource.deleteBookingBatch(
				callbackURL, object));
	}

	@GraphQLField(description = "Updates and overwrites the booking.")
	public Booking updateBooking(
			@GraphQLName("bookingId") String bookingId,
			@GraphQLName("booking") Booking booking)
		throws Exception {

		return _applyComponentServiceObjects(
			_bookingResourceComponentServiceObjects,
			this::_populateResourceContext,
			bookingResource -> bookingResource.putBooking(bookingId, booking));
	}

	@GraphQLField
	public Response updateBookingBatch(
			@GraphQLName("callbackURL") String callbackURL,
			@GraphQLName("object") Object object)
		throws Exception {

		return _applyComponentServiceObjects(
			_bookingResourceComponentServiceObjects,
			this::_populateResourceContext,
			bookingResource -> bookingResource.putBookingBatch(
				callbackURL, object));
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

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
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
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}