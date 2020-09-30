package jp.co.liferay.reservation.internal.search.spi.model.result.contributor;

import java.util.Locale;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = "indexer.class.name=jp.co.liferay.reservation.model.PersistedParticipant",
	service = ModelSummaryContributor.class
)
public class PersistedParticipantModelSummaryContributor implements ModelSummaryContributor {
    @Override
	public Summary getSummary(
			Document document, Locale locale, String snippet) {

		Summary summary = new Summary(
				document.get(Field.getSortableFieldName("fullName")),
				document.get(Field.getSortableFieldName("companyName")));

		summary.setMaxContentLength(200);
		return summary;
	}
}