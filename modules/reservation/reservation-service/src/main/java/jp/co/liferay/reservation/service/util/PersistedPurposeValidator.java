package jp.co.liferay.reservation.service.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.ModelValidator;

import jp.co.liferay.reservation.exception.PersistedPurposeValidateException;
import jp.co.liferay.reservation.model.PersistedPurpose;

public class PersistedPurposeValidator implements ModelValidator<PersistedPurpose> {

    protected List<String> _errors = new ArrayList<>();
    
    public void validate(PersistedPurpose purpose) throws PortalException {
        validateName(purpose.getName());
        if (0 < _errors.size()) {
			throw new PersistedPurposeValidateException(_errors);
		}
    }

    protected void validateName(String name) {
        if (name == null || name.isEmpty()) {
			_errors.add("purpose-name-required");
		}
    }
}