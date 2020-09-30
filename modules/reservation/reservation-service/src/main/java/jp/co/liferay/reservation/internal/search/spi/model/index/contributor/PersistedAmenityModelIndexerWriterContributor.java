package jp.co.liferay.reservation.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jp.co.liferay.reservation.model.PersistedAmenity;
import jp.co.liferay.reservation.service.PersistedAmenityLocalService;

@Component(
	immediate = true,
	property = "indexer.class.name=jp.co.liferay.reservation.model.PersistedAmenity",
	service = ModelIndexerWriterContributor.class
)
public class PersistedAmenityModelIndexerWriterContributor implements ModelIndexerWriterContributor<PersistedAmenity> {
    
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		batchIndexingActionable.setPerformActionMethod((PersistedAmenity amenity) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(amenity);
			batchIndexingActionable.addDocuments(document);
		});
    }
    
    @Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(_persistedAmenityLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(PersistedAmenity amenity) {
		return amenity.getCompanyId();
	}

	@Override
	public IndexerWriterMode getIndexerWriterMode(PersistedAmenity amenity) {
		return IndexerWriterMode.UPDATE;
    }
    
    @Reference
    private PersistedAmenityLocalService _persistedAmenityLocalService;

	@Reference
	private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;
}