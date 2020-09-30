package jp.co.liferay.reservation.service.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.ModelValidator;

import jp.co.liferay.reservation.exception.PersistedAmenityValidateException;
import jp.co.liferay.reservation.model.PersistedAmenity;

public class PersistedAmenityValidator implements ModelValidator<PersistedAmenity> {
    
    protected List<String> _errors = new ArrayList<>();

    public void validate(PersistedAmenity amenity) throws PortalException {
        validateName(amenity.getName());
        if (0 < _errors.size()) {
            throw new PersistedAmenityValidateException(_errors);
        }
    }

    protected void validateName(String name) {
        if (name == null || name.isEmpty()) {
            _errors.add("amenity-name-required");
        }
    }
}