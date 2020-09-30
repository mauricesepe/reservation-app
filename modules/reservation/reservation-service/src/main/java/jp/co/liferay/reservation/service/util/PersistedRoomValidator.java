package jp.co.liferay.reservation.service.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.ModelValidator;

import jp.co.liferay.reservation.exception.PersistedRoomValidateException;
import jp.co.liferay.reservation.model.PersistedRoom;

public class PersistedRoomValidator implements ModelValidator<PersistedRoom> {
   
    protected List<String> _errors = new ArrayList<>();

    public void validate(PersistedRoom room) throws PortalException {
        validateName(room.getName());
        validatePhotoPath(room.getPhotoPath());
        validateAvailability(room);
        validateOfficeId(room.getOfficeId());
        validateCapacitySize(room.getCapacitySquareMeters());
        validateCapacityPeople(room.getCapacityPeople());
        validateWifi(room);
        if (0 < _errors.size()) {
			throw new PersistedRoomValidateException(_errors);
		}
    }

    protected void validateName(String name) {
        if (name == null || name.isEmpty()) {
			_errors.add("room-name-required");
		}
    }

    protected void validatePhotoPath(String path) {
        if (path == null || path.isEmpty()) {
			_errors.add("room-photo-path-required");
		}
    }

    protected void validateAvailability(PersistedRoom room) {
        if (!room.getAvailableMonday() 
                && !room.getAvailableTuesday()
                && !room.getAvailableWednesday() 
                && !room.getAvailableThursday()
                && !room.getAvailableFriday()
                && !room.getAvailableSaturday()
                && !room.getAvailableSunday()) {
            _errors.add("room-availability-day-required");
        }

        int sTime = room.getAvailableStartTime();
        int eTime = room.getAvailableEndTime();

        /* 24hrs * 60mins = 1440 mins */
        if ((sTime < 0  || sTime > 1440) 
                || (eTime < 0 || eTime > 1440)
                || sTime >= eTime) {
            _errors.add("room-availability-time-invalid");
        }
    }

    protected void validateOfficeId(long officeId) {
        if (officeId <= 0) {
            _errors.add("room-office-id-required");
        }
    }

    protected void validateCapacitySize(double sqm) {
        if (sqm <= 0) {
            _errors.add("room-size-required");
        }
    }

    protected void validateCapacityPeople(int people) {
        if (people <= 0) {
            _errors.add("room-people-capacity-required");
        }
    }

    protected void validateWifi(PersistedRoom room) {
        if (room.getWifiSSID() != null && !room.getWifiSSID().isEmpty()) {
            if (room.getWifiPassword() == null || room.getWifiPassword().isEmpty()) {
                _errors.add("room-wifi-password-required");
            }
        }
    }
}