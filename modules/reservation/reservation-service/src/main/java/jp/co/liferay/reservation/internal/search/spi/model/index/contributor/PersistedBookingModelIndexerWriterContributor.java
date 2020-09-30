package jp.co.liferay.reservation.internal.search.spi.model.index.contributor;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.IndexerWriterMode;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jp.co.liferay.reservation.model.PersistedBooking;
import jp.co.liferay.reservation.service.PersistedBookingLocalService;

@Component(
	immediate = true,
	property = "indexer.class.name=jp.co.liferay.reservation.model.PersistedBooking",
	service = ModelIndexerWriterContributor.class
)
public class PersistedBookingModelIndexerWriterContributor implements ModelIndexerWriterContributor<PersistedBooking> {
    
    @Override
    public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {
		batchIndexingActionable.setPerformActionMethod((PersistedBooking booking) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(booking);
			batchIndexingActionable.addDocuments(document);
		});
    }
    
    @Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return _dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(_persistedBookingLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(PersistedBooking booking) {
		return booking.getCompanyId();
	}

	@Override
	public IndexerWriterMode getIndexerWriterMode(PersistedBooking booking) {
		return IndexerWriterMode.UPDATE;
    }
    
    @Reference
	private PersistedBookingLocalService _persistedBookingLocalService;

	@Reference
	private DynamicQueryBatchIndexingActionableFactory _dynamicQueryBatchIndexingActionableFactory;
}