package jp.co.liferay.reservation.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import org.osgi.service.component.annotations.Component;

import jp.co.liferay.reservation.model.PersistedPurpose;

@Component(
	immediate = true,
	property = "indexer.class.name=jp.co.liferay.reservation.model.PersistedPurpose",
	service = ModelDocumentContributor.class
)
public class PersistedPurposeModelDocumentContributor implements ModelDocumentContributor<PersistedPurpose> {

    @Override
    public void contribute(Document document, PersistedPurpose purpose) {
        document.addText("name", purpose.getName());
    }
}