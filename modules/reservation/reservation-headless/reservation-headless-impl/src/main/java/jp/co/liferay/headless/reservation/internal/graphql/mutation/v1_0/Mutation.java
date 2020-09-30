package jp.co.liferay.headless.reservation.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import javax.annotation.Generated;

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

	@GraphQLField
	@GraphQLInvokeDetached
	public Office postOffice(@GraphQLName("office") Office office)
		throws Exception {

		return _applyComponentServiceObjects(
			_officeResourceComponentServiceObjects,
			this::_populateResourceContext,
			officeResource -> officeResource.postOffice(office));
	}

	@GraphQLInvokeDetached
	public void deleteOffice(@GraphQLName("officeId") String officeId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_officeResourceComponentServiceObjects,
			this::_populateResourceContext,
			officeResource -> officeResource.deleteOffice(officeId));
	}

	@GraphQLInvokeDetached
	public Office putOffice(
			@GraphQLName("officeId") String officeId,
			@GraphQLName("office") Office office)
		throws Exception {

		return _applyComponentServiceObjects(
			_officeResourceComponentServiceObjects,
			this::_populateResourceContext,
			officeResource -> officeResource.putOffice(officeId, office));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Participant postParticipant(
			@GraphQLName("participant") Participant participant)
		throws Exception {

		return _applyComponentServiceObjects(
			_participantResourceComponentServiceObjects,
			this::_populateResourceContext,
			participantResource -> participantResource.postParticipant(
				participant));
	}

	@GraphQLInvokeDetached
	public void deleteParticipant(
			@GraphQLName("participantId") String participantId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_participantResourceComponentServiceObjects,
			this::_populateResourceContext,
			participantResource -> participantResource.deleteParticipant(
				participantId));
	}

	@GraphQLInvokeDetached
	public Participant putParticipant(
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
	@GraphQLInvokeDetached
	public Amenity postAmenity(@GraphQLName("amenity") Amenity amenity)
		throws Exception {

		return _applyComponentServiceObjects(
			_amenityResourceComponentServiceObjects,
			this::_populateResourceContext,
			amenityResource -> amenityResource.postAmenity(amenity));
	}

	@GraphQLInvokeDetached
	public void deleteAmenity(@GraphQLName("amenityId") String amenityId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_amenityResourceComponentServiceObjects,
			this::_populateResourceContext,
			amenityResource -> amenityResource.deleteAmenity(amenityId));
	}

	@GraphQLInvokeDetached
	public Amenity putAmenity(
			@GraphQLName("amenityId") String amenityId,
			@GraphQLName("amenity") Amenity amenity)
		throws Exception {

		return _applyComponentServiceObjects(
			_amenityResourceComponentServiceObjects,
			this::_populateResourceContext,
			amenityResource -> amenityResource.putAmenity(amenityId, amenity));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Purpose postPurpos(@GraphQLName("purpose") Purpose purpose)
		throws Exception {

		return _applyComponentServiceObjects(
			_purposeResourceComponentServiceObjects,
			this::_populateResourceContext,
			purposeResource -> purposeResource.postPurpos(purpose));
	}

	@GraphQLInvokeDetached
	public void deletePurposPurpose(@GraphQLName("purposeId") String purposeId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_purposeResourceComponentServiceObjects,
			this::_populateResourceContext,
			purposeResource -> purposeResource.deletePurposPurpose(purposeId));
	}

	@GraphQLInvokeDetached
	public Purpose putPurposPurpose(
			@GraphQLName("purposeId") String purposeId,
			@GraphQLName("purpose") Purpose purpose)
		throws Exception {

		return _applyComponentServiceObjects(
			_purposeResourceComponentServiceObjects,
			this::_populateResourceContext,
			purposeResource -> purposeResource.putPurposPurpose(
				purposeId, purpose));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Room postRoom(@GraphQLName("room") Room room) throws Exception {
		return _applyComponentServiceObjects(
			_roomResourceComponentServiceObjects,
			this::_populateResourceContext,
			roomResource -> roomResource.postRoom(room));
	}

	@GraphQLInvokeDetached
	public void deleteRoom(@GraphQLName("roomId") String roomId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_roomResourceComponentServiceObjects,
			this::_populateResourceContext,
			roomResource -> roomResource.deleteRoom(roomId));
	}

	@GraphQLInvokeDetached
	public Room putRoom(
			@GraphQLName("roomId") String roomId,
			@GraphQLName("room") Room room)
		throws Exception {

		return _applyComponentServiceObjects(
			_roomResourceComponentServiceObjects,
			this::_populateResourceContext,
			roomResource -> roomResource.putRoom(roomId, room));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Booking postBooking(@GraphQLName("booking") Booking booking)
		throws Exception {

		return _applyComponentServiceObjects(
			_bookingResourceComponentServiceObjects,
			this::_populateResourceContext,
			bookingResource -> bookingResource.postBooking(booking));
	}

	@GraphQLInvokeDetached
	public void deleteBooking(@GraphQLName("bookingId") String bookingId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_bookingResourceComponentServiceObjects,
			this::_populateResourceContext,
			bookingResource -> bookingResource.deleteBooking(bookingId));
	}

	@GraphQLInvokeDetached
	public Booking putBooking(
			@GraphQLName("bookingId") String bookingId,
			@GraphQLName("booking") Booking booking)
		throws Exception {

		return _applyComponentServiceObjects(
			_bookingResourceComponentServiceObjects,
			this::_populateResourceContext,
			bookingResource -> bookingResource.putBooking(bookingId, booking));
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

		amenityResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private void _populateResourceContext(BookingResource bookingResource)
		throws Exception {

		bookingResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private void _populateResourceContext(OfficeResource officeResource)
		throws Exception {

		officeResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private void _populateResourceContext(
			ParticipantResource participantResource)
		throws Exception {

		participantResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private void _populateResourceContext(PurposeResource purposeResource)
		throws Exception {

		purposeResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
	}

	private void _populateResourceContext(RoomResource roomResource)
		throws Exception {

		roomResource.setContextCompany(
			CompanyLocalServiceUtil.getCompany(
				CompanyThreadLocal.getCompanyId()));
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

}