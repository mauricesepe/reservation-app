package jp.co.liferay.reservation.service.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.ModelValidator;

import jp.co.liferay.reservation.exception.PersistedBookingValidateException;
import jp.co.liferay.reservation.model.PersistedBooking;

public class PersistedBookingValidator implements ModelValidator<PersistedBooking> {
    
    protected List<String> _errors = new ArrayList<>();

    public void validate(PersistedBooking booking) throws PortalException {
        validateTitle(booking.getTitle());
        validateDuration(booking.getStartDate(), booking.getEndDate());
        validateRoomId(booking.getRoomId());
        validateDescription(booking.getDescription());
        if (0 < _errors.size()) {
			throw new PersistedBookingValidateException(_errors);
        }
    }

    protected void validateTitle(String title) {
        if (title == null || title.isEmpty()) {
			_errors.add("booking-title-required");
		}
    }

    protected void validateDuration(Date startDt, Date endDt) {
        if (startDt == null || endDt == null) {
            _errors.add("booking-duration-required");
        }

        if (startDt.compareTo(endDt) >= 0) {
            _errors.add("booking-duration-invalid");
        }
    }

    protected void validateRoomId(long roomId) {
        if (roomId <= 0) {
            _errors.add("booking-room-id-required");
        }
    }

    protected void validateDescription(String description) {
        if (description == null || description.isEmpty()) {
			_errors.add("booking-desc-required");
		}
    }
}