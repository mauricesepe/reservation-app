package jp.co.liferay.headless.reservation.internal.resource.v1_0;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MultivaluedMap;

import com.liferay.headless.common.spi.service.context.ServiceContextUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.portal.vulcan.util.SearchUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.liferay.headless.reservation.dto.v1_0.Booking;
import jp.co.liferay.headless.reservation.internal.odata.entity.v1_0.BookingEntityModel;
import jp.co.liferay.headless.reservation.internal.util.TimeUtil;
import jp.co.liferay.headless.reservation.resource.v1_0.BookingResource;
import jp.co.liferay.reservation.model.PersistedBooking;
import jp.co.liferay.reservation.model.PersistedOffice;
import jp.co.liferay.reservation.model.PersistedParticipant;
import jp.co.liferay.reservation.model.PersistedRoom;
import jp.co.liferay.reservation.service.PersistedBookingService;
import jp.co.liferay.reservation.service.PersistedOfficeService;
import jp.co.liferay.reservation.service.PersistedParticipantService;
import jp.co.liferay.reservation.service.PersistedRoomService;

/**
 * @author Maurice Sepe
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/booking.properties",
	scope = ServiceScope.PROTOTYPE, service = BookingResource.class
)
public class BookingResourceImpl extends BaseBookingResourceImpl implements EntityModelResource{

    private BookingEntityModel _bookingEntityModel = new BookingEntityModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap) throws Exception {
        return _bookingEntityModel;
    }

    @Override
    public Page<Booking> getBookingsPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
        try {
            Page<Booking> var = SearchUtil.search(
					booleanQuery -> {
					},
					filter, PersistedBooking.class, search, pagination,
					queryConfig -> queryConfig.setSelectedFieldNames(
							Field.ENTRY_CLASS_PK),
					searchContext -> searchContext.setCompanyId(
							contextCompany.getCompanyId()),
					document -> _toBooking(
							_persistedBookingService.fetchPersistedBooking(
									GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))),
                    sorts);
                return var;
        } catch (Exception e) {
            _log.error("Error occured while retrieving booking: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Booking postBooking(@NotNull Booking booking) throws Exception {
        try {

            long[] participantsList = (null != booking.getParticipantIds()) ? ArrayUtil.toArray(booking.getParticipantIds()) : null;

            PersistedBooking p = _persistedBookingService.addPersistedBooking(
                    booking.getTitle(), 
                    TimeUtil.convertToDate(booking.getDate(), booking.getStartTime()),
                    TimeUtil.convertToDate(booking.getDate(), booking.getEndTime()),
                    booking.getRoomId().longValue(), 
                    booking.getDescription(), 
                    participantsList,
                    _getServiceContext());
                return _toBooking(p);
        } catch (Exception e) {
            _log.error("Error occured while creating booking: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Booking getBooking(@NotNull String bookingId) throws Exception {
        try {
            PersistedBooking p = _persistedBookingService.fetchPersistedBooking(Long.parseLong(bookingId));
            return (null != p) ? _toBooking(p) : null;
        } catch (Exception e) {
            _log.error("Error occured while retrieving booking: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Booking putBooking(@NotNull String bookingId, @NotNull Booking booking) throws Exception {
        try {
            
            long[] participantsList = (null != booking.getParticipantIds()) ? ArrayUtil.toArray(booking.getParticipantIds()) : null;

            PersistedBooking p = _persistedBookingService.updatePersistedBooking(
                    Long.parseLong(bookingId), 
                    booking.getTitle(), 
                    TimeUtil.convertToDate(booking.getDate(), booking.getStartTime()),
                    TimeUtil.convertToDate(booking.getDate(), booking.getEndTime()),
                    booking.getRoomId().longValue(), 
                    booking.getDescription(), 
                    participantsList, 
                    _getServiceContext());
            return _toBooking(p);
        } catch (Exception e) {
            _log.error("Error occured while updating booking: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteBooking(@NotNull String bookingId) throws Exception {
        try {
            _persistedBookingService.deletePersistedBooking(Long.parseLong(bookingId));
        } catch (Exception e) {
            _log.error("Error occured while deleting booking: " + e.getMessage(), e);
            throw e;
        }
    }

    protected Booking _toBooking(PersistedBooking booking) {
        return new Booking() {{
            bookingId = booking.getBookingId();
            title = booking.getTitle();
            roomId = booking.getRoomId();
            description = booking.getDescription();
            userId = booking.getUserId();
            startTime = TimeUtil.getTimeOnly(booking.getStartDate());
            endTime = TimeUtil.getTimeOnly(booking.getEndDate());

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            date = sdf.format(booking.getStartDate());

            List<PersistedParticipant> participants = _persistedParticipantService.getPersistedBookingPersistedParticipants(booking.getBookingId());
            if (null != participants && participants.size() > 0) {
                Long[] ids = new Long[participants.size()];
                for (int idx = 0; idx < participants.size(); idx++) {
                    ids[idx] = participants.get(idx).getParticipantId();
                }
                participantIds = ids;
            }

            PersistedRoom room = _persistedRoomService.fetchPersistedRoom(booking.getRoomId());
            if (room != null) {
                roomName = room.getName();
                PersistedOffice office = _persistedOfficeService.fetchPersistedOffice(room.getOfficeId());
                if (office != null) {
                    officeId = office.getOfficeId();
                    officeName = office.getName();
                }
            }
            
            try {
                User user = _userLocalService.getUser(booking.getUserId());
                userName = user.getFullName();
            } catch (Exception e ) {
                _log.error("No user exists with id: " + booking.getUserId(), e);
            };
        }};
    }

    protected ServiceContext _getServiceContext() {
		ServiceContext serviceContext = ServiceContextUtil.createServiceContext(0, "anyone");
		serviceContext.setCompanyId(contextCompany.getCompanyId());

		long userId = PrincipalThreadLocal.getUserId();
		serviceContext.setUserId(userId);

		return serviceContext;
    }

    @Reference
    protected UserLocalService _userLocalService;

    @Reference
    protected PersistedRoomService _persistedRoomService;

    @Reference
    protected PersistedOfficeService _persistedOfficeService;

    @Reference
    protected PersistedParticipantService _persistedParticipantService;

    @Reference
    protected PersistedBookingService _persistedBookingService;
    
    private static final Logger _log = LoggerFactory.getLogger(BookingResourceImpl.class);
}