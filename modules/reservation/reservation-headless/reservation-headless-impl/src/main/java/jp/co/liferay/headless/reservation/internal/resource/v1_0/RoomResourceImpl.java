package jp.co.liferay.headless.reservation.internal.resource.v1_0;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MultivaluedMap;

import com.liferay.headless.common.spi.service.context.ServiceContextUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
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

import jp.co.liferay.headless.reservation.dto.v1_0.Room;
import jp.co.liferay.headless.reservation.internal.odata.entity.v1_0.RoomEntityModel;
import jp.co.liferay.headless.reservation.internal.util.TimeUtil;
import jp.co.liferay.headless.reservation.resource.v1_0.RoomResource;
import jp.co.liferay.reservation.model.PersistedAmenity;
import jp.co.liferay.reservation.model.PersistedOffice;
import jp.co.liferay.reservation.model.PersistedPurpose;
import jp.co.liferay.reservation.model.PersistedRoom;
import jp.co.liferay.reservation.service.PersistedAmenityService;
import jp.co.liferay.reservation.service.PersistedOfficeService;
import jp.co.liferay.reservation.service.PersistedPurposeService;
import jp.co.liferay.reservation.service.PersistedRoomService;

/**
 * @author Maurice Sepe
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/room.properties",
	scope = ServiceScope.PROTOTYPE, service = RoomResource.class
)
public class RoomResourceImpl extends BaseRoomResourceImpl implements EntityModelResource {

    private RoomEntityModel _roomEntityModel = new RoomEntityModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap) throws Exception {
      return _roomEntityModel;
    }

    @Override
    public Page<Room> getRoomsPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
        try {
            Page<Room> var = SearchUtil.search(
					booleanQuery -> {
					},
					filter, PersistedRoom.class, search, pagination,
					queryConfig -> queryConfig.setSelectedFieldNames(
							Field.ENTRY_CLASS_PK),
					searchContext -> searchContext.setCompanyId(
							contextCompany.getCompanyId()),
					document -> _toRoom(
							_persistedRoomService.fetchPersistedRoom(
									GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))),
                    sorts);
                return var;
        } catch (Exception e) {
            _log.error("Error occured while retrieving rooms: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Room postRoom(@NotNull Room room) throws Exception {
        try {

            long[] amenitiesList = (null != room.getAmenityIds()) ? ArrayUtil.toArray(room.getAmenityIds()) : null;
            long[] purposesList = (null != room.getPurposeIds()) ? ArrayUtil.toArray(room.getPurposeIds()) : null;

            PersistedRoom p = _persistedRoomService.addPersistedRoom(room.getName(), 
                    room.getPhotoPath(), 
                    room.getAvailableSunday(), 
                    room.getAvailableMonday(), 
                    room.getAvailableTuesday(), 
                    room.getAvailableWednesday(), 
                    room.getAvailableThursday(), 
                    room.getAvailableFriday(), 
                    room.getAvailableSaturday(), 
                    TimeUtil.convertToMinutes(room.getAvailableStartTime()),
                    TimeUtil.convertToMinutes(room.getAvailableEndTime()), 
                    room.getOfficeId().longValue(), 
                    room.getCapacitySquareMeters(), 
                    room.getCapacityPeople(), 
                    room.getPhoneExtension(), 
                    room.getWifiSSID(), 
                    room.getWifiSecurityType(), 
                    room.getWifiPassword(), 
                    amenitiesList,
                    purposesList, 
                    _getServiceContext());
            return _toRoom(p);
        } catch (Exception e) {
            _log.error("Error occured while creating room: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Room getRoom(@NotNull String roomId) throws Exception {
        try {
            PersistedRoom r = _persistedRoomService.fetchPersistedRoom(Long.parseLong(roomId));
            return (r != null) ?  _toRoom(r) : null;
        } catch (Exception e) {
            _log.error("Error occured while retrieving room: " + e.getMessage(), e);
            throw e;
        } 
    }

    @Override
    public Room putRoom(@NotNull String roomId, @NotNull Room room) throws Exception {
        try {

            long[] amenitiesList = (null != room.getAmenityIds()) ? ArrayUtil.toArray(room.getAmenityIds()) : null;
            long[] purposesList = (null != room.getPurposeIds()) ? ArrayUtil.toArray(room.getPurposeIds()) : null;

            PersistedRoom p = _persistedRoomService.updateRoom(Long.parseLong(roomId),
                    room.getName(),
                    room.getPhotoPath(), 
                    room.getAvailableSunday(), 
                    room.getAvailableMonday(), 
                    room.getAvailableTuesday(), 
                    room.getAvailableWednesday(), 
                    room.getAvailableThursday(), 
                    room.getAvailableFriday(), 
                    room.getAvailableSaturday(), 
                    TimeUtil.convertToMinutes(room.getAvailableStartTime()),
                    TimeUtil.convertToMinutes(room.getAvailableEndTime()),
                    room.getOfficeId().longValue(), 
                    room.getCapacitySquareMeters(), 
                    room.getCapacityPeople(), 
                    room.getPhoneExtension(), 
                    room.getWifiSSID(), 
                    room.getWifiSecurityType(), 
                    room.getWifiPassword(), 
                    amenitiesList,
                    purposesList, 
                    _getServiceContext());
            return _toRoom(p);
        } catch (Exception e) {
            _log.error("Error occured while updating room: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteRoom(@NotNull String roomId) throws Exception {
        try {
            _persistedRoomService.deleteRoom(Long.parseLong(roomId));
        } catch (Exception e) {
            _log.error("Error occured while deleting room: " + e.getMessage(), e);
            throw e;
        }
    }

    protected Room _toRoom(PersistedRoom room) {
        return new Room() {{
            roomId = room.getRoomId();
            name = room.getName();
            photoPath = room.getPhotoPath();
            availableSunday = room.getAvailableSunday();
            availableMonday = room.getAvailableMonday();
            availableTuesday = room.getAvailableTuesday();
            availableWednesday = room.getAvailableWednesday();
            availableThursday = room.getAvailableThursday();
            availableFriday = room.getAvailableFriday();
            availableSaturday = room.getAvailableSaturday();
            availableStartTime = TimeUtil.convertToTime(room.getAvailableStartTime());
            availableEndTime = TimeUtil.convertToTime(room.getAvailableEndTime());
            officeId = room.getOfficeId();
            capacitySquareMeters = room.getCapacitySquareMeters(); 
            capacityPeople = room.getCapacityPeople();
            phoneExtension = room.getPhoneExtension();
            wifiSSID = room.getWifiSSID(); 
            wifiSecurityType = room.getWifiSecurityType();
            wifiPassword = room.getWifiPassword();

            PersistedOffice office = _persistedOfficeService.fetchPersistedOffice(room.getOfficeId());
            if (office != null) {
                officeName = office.getName();
            }
            
            List<PersistedPurpose> purposes = _persistedPurposeService.getPersistedRoomPersistedPurposes(room.getRoomId());
            if (purposes != null && purposes.size() > 0) {
                Long[] ids = new Long[purposes.size()];
                for (int i = 0; i < purposes.size(); i++) {
                    ids[i] = purposes.get(i).getPurposeId();
                }
                purposeIds = ids;
            }
            List<PersistedAmenity> amenities = _persistedAmenityService.getPersistedRoomPersistedAmenities(room.getRoomId());
            if (amenities != null && amenities.size() > 0) {
                Long[] ids = new Long[amenities.size()];
                for (int i = 0; i < amenities.size(); i++) {
                    ids[i] = amenities.get(i).getAmenityId();
                }
                amenityIds = ids;
            }
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
    private PersistedRoomService _persistedRoomService;

    @Reference
    private PersistedPurposeService _persistedPurposeService;

    @Reference
    private PersistedAmenityService _persistedAmenityService;

    @Reference
    private PersistedOfficeService _persistedOfficeService;
    
    private static final Logger _log = LoggerFactory.getLogger(RoomResourceImpl.class);
}