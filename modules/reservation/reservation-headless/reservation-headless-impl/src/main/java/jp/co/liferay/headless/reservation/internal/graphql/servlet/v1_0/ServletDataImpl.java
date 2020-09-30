package jp.co.liferay.headless.reservation.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import jp.co.liferay.headless.reservation.internal.graphql.mutation.v1_0.Mutation;
import jp.co.liferay.headless.reservation.internal.graphql.query.v1_0.Query;
import jp.co.liferay.headless.reservation.resource.v1_0.AmenityResource;
import jp.co.liferay.headless.reservation.resource.v1_0.BookingResource;
import jp.co.liferay.headless.reservation.resource.v1_0.OfficeResource;
import jp.co.liferay.headless.reservation.resource.v1_0.ParticipantResource;
import jp.co.liferay.headless.reservation.resource.v1_0.PurposeResource;
import jp.co.liferay.headless.reservation.resource.v1_0.RoomResource;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author Maurice Sepe
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setAmenityResourceComponentServiceObjects(
			_amenityResourceComponentServiceObjects);
		Mutation.setBookingResourceComponentServiceObjects(
			_bookingResourceComponentServiceObjects);
		Mutation.setOfficeResourceComponentServiceObjects(
			_officeResourceComponentServiceObjects);
		Mutation.setParticipantResourceComponentServiceObjects(
			_participantResourceComponentServiceObjects);
		Mutation.setPurposeResourceComponentServiceObjects(
			_purposeResourceComponentServiceObjects);
		Mutation.setRoomResourceComponentServiceObjects(
			_roomResourceComponentServiceObjects);

		Query.setAmenityResourceComponentServiceObjects(
			_amenityResourceComponentServiceObjects);
		Query.setBookingResourceComponentServiceObjects(
			_bookingResourceComponentServiceObjects);
		Query.setOfficeResourceComponentServiceObjects(
			_officeResourceComponentServiceObjects);
		Query.setParticipantResourceComponentServiceObjects(
			_participantResourceComponentServiceObjects);
		Query.setPurposeResourceComponentServiceObjects(
			_purposeResourceComponentServiceObjects);
		Query.setRoomResourceComponentServiceObjects(
			_roomResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/reservation-headless-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<AmenityResource>
		_amenityResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<BookingResource>
		_bookingResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<OfficeResource>
		_officeResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<ParticipantResource>
		_participantResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<PurposeResource>
		_purposeResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<RoomResource>
		_roomResourceComponentServiceObjects;

}