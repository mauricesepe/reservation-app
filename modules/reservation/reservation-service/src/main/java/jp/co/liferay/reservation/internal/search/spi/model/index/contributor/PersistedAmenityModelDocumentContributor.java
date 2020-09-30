package jp.co.liferay.reservation.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import org.osgi.service.component.annotations.Component;

import jp.co.liferay.reservation.model.PersistedAmenity;

@Component(
	immediate = true,
	property = "indexer.class.name=jp.co.liferay.reservation.model.PersistedAmenity",
	service = ModelDocumentContributor.class
)
public class PersistedAmenityModelDocumentContributor implements ModelDocumentContributor<PersistedAmenity> {

    @Override
    public void contribute(Document document, PersistedAmenity amenity) {
        document.addText("name", amenity.getName());
    }
}