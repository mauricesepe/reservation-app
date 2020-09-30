package jp.co.liferay.reservation.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jp.co.liferay.reservation.model.PersistedPurpose;
import jp.co.liferay.reservation.service.PersistedPurposeLocalService;

@Component(
	immediate = true,
	property = "indexer.class.name=jp.co.liferay.reservation.model.PersistedPurpose",
	service = ModelIndexerWriterContributor.class
)
public class PersistedPurposeModelIndexerWriterContributor implements ModelIndexerWriterContributor<PersistedPurpose> {
    
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		batchIndexingActionable.setPerformActionMethod((PersistedPurpose purpose) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(purpose);
			batchIndexingActionable.addDocuments(document);
		});
    }
    
    @Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(_persistedPurposeLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(PersistedPurpose purpose) {
		return purpose.getCompanyId();
	}

	@Override
	public IndexerWriterMode getIndexerWriterMode(PersistedPurpose purpose) {
		return IndexerWriterMode.UPDATE;
    }
    
    @Reference
    private PersistedPurposeLocalService _persistedPurposeLocalService;

	@Reference
	private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;
}