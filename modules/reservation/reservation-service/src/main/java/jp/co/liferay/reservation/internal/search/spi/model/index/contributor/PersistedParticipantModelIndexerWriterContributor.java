package jp.co.liferay.reservation.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jp.co.liferay.reservation.model.PersistedParticipant;
import jp.co.liferay.reservation.service.PersistedParticipantLocalService;

@Component(
	immediate = true,
	property = "indexer.class.name=jp.co.liferay.reservation.model.PersistedParticipant",
	service = ModelIndexerWriterContributor.class
)
public class PersistedParticipantModelIndexerWriterContributor implements ModelIndexerWriterContributor<PersistedParticipant> {
    
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		batchIndexingActionable.setPerformActionMethod((PersistedParticipant participant) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(participant);
			batchIndexingActionable.addDocuments(document);
		});
    }
    
    @Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(_persistedParticipantLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(PersistedParticipant participant) {
		return participant.getCompanyId();
	}

	@Override
	public IndexerWriterMode getIndexerWriterMode(PersistedParticipant participant) {
		return IndexerWriterMode.UPDATE;
    }

    @Reference
    private PersistedParticipantLocalService _persistedParticipantLocalService;

	@Reference
	private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;
}