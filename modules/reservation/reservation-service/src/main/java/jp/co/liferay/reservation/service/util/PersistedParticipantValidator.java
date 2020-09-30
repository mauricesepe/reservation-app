package jp.co.liferay.reservation.service.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.util.Validator;

import jp.co.liferay.reservation.exception.PersistedParticipantValidateException;
import jp.co.liferay.reservation.model.PersistedParticipant;

public class PersistedParticipantValidator implements ModelValidator<PersistedParticipant> {
    
    protected List<String> _errors = new ArrayList<>();

    @Override
    public void validate(PersistedParticipant participant) throws PortalException {
        validateName(participant.getFullName());
        validateEmailAddress(participant.getEmailAddress());
        validateCompany(participant.getCompanyName());
        if (0 < _errors.size()) {
			throw new PersistedParticipantValidateException(_errors);
		}
    }

    protected void validateName(String name) {
        if (name == null || name.isEmpty()) {
			_errors.add("participant-name-required");
		}
    }

    protected void validateEmailAddress(String email) {
        if (email == null || email.isEmpty()) {
			_errors.add("participant-email-required");
        }

        if (!Validator.isEmailAddress(email)){
            _errors.add("participant-email-invalid");
        }
    }

    protected void validateCompany(String company) {
        if (company == null || company.isEmpty()) {
			_errors.add("participant-company-required");
		}
    }
}