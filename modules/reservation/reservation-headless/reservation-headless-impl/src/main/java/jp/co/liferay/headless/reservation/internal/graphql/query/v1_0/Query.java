package jp.co.liferay.headless.reservation.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;

import graphql.annotations.annotationTypes.GraphQLField;
import graphql.annotations.annotationTypes.GraphQLInvokeDetached;
import graphql.annotations.annotationTypes.GraphQLName;

import java.util.Collection;

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

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Office> getOfficesPage(
			@GraphQLName("search") String search,
			@GraphQLName("filter") Filter filter,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page, @GraphQLName("sorts") Sort[] sorts)
		throws Exception {

		return _applyComponentServiceObjects(
			_officeResourceComponentServiceObjects,
			this::_populateResourceContext,
			officeResource -> {
				Page paginationPage = officeResource.getOfficesPage(
					search, filter, Pagination.of(pageSize, page), sorts);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Office getOffice(@GraphQLName("officeId") String officeId)
		throws Exception {

		return _applyComponentServiceObjects(
			_officeResourceComponentServiceObjects,
			this::_populateResourceContext,
			officeResource -> officeResource.getOffice(officeId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Participant> getParticipantsPage(
			@GraphQLName("search") String search,
			@GraphQLName("filter") Filter filter,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page, @GraphQLName("sorts") Sort[] sorts)
		throws Exception {

		return _applyComponentServiceObjects(
			_participantResourceComponentServiceObjects,
			this::_populateResourceContext,
			participantResource -> {
				Page paginationPage = participantResource.getParticipantsPage(
					search, filter, Pagination.of(pageSize, page), sorts);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Participant getParticipant(
			@GraphQLName("participantId") String participantId)
		throws Exception {

		return _applyComponentServiceObjects(
			_participantResourceComponentServiceObjects,
			this::_populateResourceContext,
			participantResource -> participantResource.getParticipant(
				participantId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Amenity> getAmenitiesPage(
			@GraphQLName("search") String search,
			@GraphQLName("filter") Filter filter,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page, @GraphQLName("sorts") Sort[] sorts)
		throws Exception {

		return _applyComponentServiceObjects(
			_amenityResourceComponentServiceObjects,
			this::_populateResourceContext,
			amenityResource -> {
				Page paginationPage = amenityResource.getAmenitiesPage(
					search, filter, Pagination.of(pageSize, page), sorts);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Amenity getAmenity(@GraphQLName("amenityId") String amenityId)
		throws Exception {

		return _applyComponentServiceObjects(
			_amenityResourceComponentServiceObjects,
			this::_populateResourceContext,
			amenityResource -> amenityResource.getAmenity(amenityId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Purpose> getPurposesPage(
			@GraphQLName("search") String search,
			@GraphQLName("filter") Filter filter,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page, @GraphQLName("sorts") Sort[] sorts)
		throws Exception {

		return _applyComponentServiceObjects(
			_purposeResourceComponentServiceObjects,
			this::_populateResourceContext,
			purposeResource -> {
				Page paginationPage = purposeResource.getPurposesPage(
					search, filter, Pagination.of(pageSize, page), sorts);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Purpose getPurposPurpose(@GraphQLName("purposeId") String purposeId)
		throws Exception {

		return _applyComponentServiceObjects(
			_purposeResourceComponentServiceObjects,
			this::_populateResourceContext,
			purposeResource -> purposeResource.getPurposPurpose(purposeId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Room> getRoomsPage(
			@GraphQLName("search") String search,
			@GraphQLName("filter") Filter filter,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page, @GraphQLName("sorts") Sort[] sorts)
		throws Exception {

		return _applyComponentServiceObjects(
			_roomResourceComponentServiceObjects,
			this::_populateResourceContext,
			roomResource -> {
				Page paginationPage = roomResource.getRoomsPage(
					search, filter, Pagination.of(pageSize, page), sorts);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Room getRoom(@GraphQLName("roomId") String roomId) throws Exception {
		return _applyComponentServiceObjects(
			_roomResourceComponentServiceObjects,
			this::_populateResourceContext,
			roomResource -> roomResource.getRoom(roomId));
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Collection<Booking> getBookingsPage(
			@GraphQLName("search") String search,
			@GraphQLName("filter") Filter filter,
			@GraphQLName("pageSize") int pageSize,
			@GraphQLName("page") int page, @GraphQLName("sorts") Sort[] sorts)
		throws Exception {

		return _applyComponentServiceObjects(
			_bookingResourceComponentServiceObjects,
			this::_populateResourceContext,
			bookingResource -> {
				Page paginationPage = bookingResource.getBookingsPage(
					search, filter, Pagination.of(pageSize, page), sorts);

				return paginationPage.getItems();
			});
	}

	@GraphQLField
	@GraphQLInvokeDetached
	public Booking getBooking(@GraphQLName("bookingId") String bookingId)
		throws Exception {

		return _applyComponentServiceObjects(
			_bookingResourceComponentServiceObjects,
			this::_populateResourceContext,
			bookingResource -> bookingResource.getBooking(bookingId));
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