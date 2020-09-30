package jp.co.liferay.reservation.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import org.osgi.service.component.annotations.Component;

import jp.co.liferay.reservation.model.PersistedOffice;

@Component(
	immediate = true,
	property = "indexer.class.name=jp.co.liferay.reservation.model.PersistedOffice",
	service = ModelDocumentContributor.class
)
public class PersistedOfficeModelDocumentContributor implements ModelDocumentContributor<PersistedOffice> {

    @Override
    public void contribute(Document document, PersistedOffice office) {
        document.addText("name", office.getName());
        document.addKeyword("location", office.getLocation());
        document.addKeyword(Field.getSortableFieldName("location"), office.getLocation(), true);
    }
}