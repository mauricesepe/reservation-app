package jp.co.liferay.reservation.service.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.ModelValidator;

import jp.co.liferay.reservation.exception.PersistedOfficeValidateException;
import jp.co.liferay.reservation.model.PersistedOffice;

public class PersistedOfficeValidator implements ModelValidator<PersistedOffice> {

    protected List<String> _errors = new ArrayList<>();

    @Override
    public void validate(PersistedOffice office) throws PortalException {
        validateName(office.getName());
        validateLocation(office.getLocation());
    	if (0 < _errors.size()) {
            throw new PersistedOfficeValidateException(_errors);
		}
    }

    protected void validateName(String name) {
		if (name == null || name.isEmpty()) {
			_errors.add("office-name-required");
		}
    }

    protected void validateLocation(String location) {
        if (location == null || location.isEmpty()) {
			_errors.add("office-location-required");
		}
    }
}