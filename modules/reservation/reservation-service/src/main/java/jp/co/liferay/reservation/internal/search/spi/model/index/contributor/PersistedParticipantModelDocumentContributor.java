package jp.co.liferay.reservation.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import org.osgi.service.component.annotations.Component;

import jp.co.liferay.reservation.model.PersistedParticipant;

@Component(
	immediate = true,
	property = "indexer.class.name=jp.co.liferay.reservation.model.PersistedParticipant",
	service = ModelDocumentContributor.class
)
public class PersistedParticipantModelDocumentContributor implements ModelDocumentContributor<PersistedParticipant> {

    @Override
    public void contribute(Document document, PersistedParticipant participant) {
        document.addKeyword("email", participant.getEmailAddress());
        document.addKeyword(Field.getSortableFieldName("email"), participant.getEmailAddress());
        document.addKeyword("fullName", participant.getFullName());
        document.addKeyword(Field.getSortableFieldName("fullName"), participant.getFullName(), true);
        document.addKeyword("companyName", participant.getCompanyName());
        document.addKeyword(Field.getSortableFieldName("companyName"), participant.getCompanyName(), true);
    }
}