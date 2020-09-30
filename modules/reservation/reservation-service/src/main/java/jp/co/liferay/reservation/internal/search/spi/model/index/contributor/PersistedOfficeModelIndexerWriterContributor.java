package jp.co.liferay.reservation.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jp.co.liferay.reservation.model.PersistedOffice;
import jp.co.liferay.reservation.service.PersistedOfficeLocalService;

@Component(
	immediate = true,
	property = "indexer.class.name=jp.co.liferay.reservation.model.PersistedOffice",
	service = ModelIndexerWriterContributor.class
)
public class PersistedOfficeModelIndexerWriterContributor implements ModelIndexerWriterContributor<PersistedOffice> {
    
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		batchIndexingActionable.setPerformActionMethod((PersistedOffice office) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(office);
			batchIndexingActionable.addDocuments(document);
		});
    }
    
    @Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(_persistedOfficeLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(PersistedOffice office) {
		return office.getCompanyId();
	}

	@Override
	public IndexerWriterMode getIndexerWriterMode(PersistedOffice office) {
		return IndexerWriterMode.UPDATE;
    }
    
    @Reference
    private PersistedOfficeLocalService _persistedOfficeLocalService;

	@Reference
	private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;
}