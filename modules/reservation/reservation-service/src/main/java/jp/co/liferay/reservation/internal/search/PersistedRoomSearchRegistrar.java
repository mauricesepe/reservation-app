package jp.co.liferay.reservation.internal.search;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;
import com.liferay.portal.search.spi.model.result.contributor.ModelSummaryContributor;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import jp.co.liferay.reservation.model.PersistedRoom;

@Component(
    immediate = true,
    service = {PersistedRoomSearchRegistrar.class}
)
public class PersistedRoomSearchRegistrar {

    @Activate
	protected void activate(BundleContext bundleContext) {
		_serviceRegistration = modelSearchRegistrarHelper.register(
				PersistedRoom.class, bundleContext,
				modelSearchDefinition -> {
					modelSearchDefinition.setDefaultSelectedFieldNames(
                            Field.ASSET_TAG_NAMES,
							Field.COMPANY_ID,
                            Field.ENTRY_CLASS_NAME,
                            Field.ENTRY_CLASS_PK,
                            Field.GROUP_ID,
                            Field.SCOPE_GROUP_ID,
                            Field.NAME);
					modelSearchDefinition.setModelIndexWriteContributor(
							modelIndexWriterContributor);
					modelSearchDefinition.setModelSummaryContributor(
							modelSummaryContributor);
				});
	}
    
    @Deactivate
    protected void deactivate() {
        _serviceRegistration.unregister();
    }

    @Reference
    protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

    @Reference(target = "(indexer.class.name=jp.co.liferay.reservation.model.PersistedRoom)")
    protected ModelIndexerWriterContributor<PersistedRoom> modelIndexWriterContributor;

    @Reference(target = "(indexer.class.name=jp.co.liferay.reservation.model.PersistedRoom)")
    protected ModelSummaryContributor modelSummaryContributor;

    private ServiceRegistration<?> _serviceRegistration;
}