package jp.co.liferay.headless.reservation.internal.resource.v1_0;

import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MultivaluedMap;

import com.liferay.headless.common.spi.service.context.ServiceContextUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.security.auth.PrincipalThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.portal.vulcan.pagination.Pagination;
import com.liferay.portal.vulcan.resource.EntityModelResource;
import com.liferay.portal.vulcan.util.SearchUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jp.co.liferay.headless.reservation.dto.v1_0.Purpose;
import jp.co.liferay.headless.reservation.internal.odata.entity.v1_0.PurposeEntityModel;
import jp.co.liferay.headless.reservation.resource.v1_0.PurposeResource;
import jp.co.liferay.reservation.model.PersistedPurpose;
import jp.co.liferay.reservation.service.PersistedPurposeService;

/**
 * @author Maurice Sepe
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/purpose.properties",
	scope = ServiceScope.PROTOTYPE, service = PurposeResource.class
)
public class PurposeResourceImpl extends BasePurposeResourceImpl implements EntityModelResource{

    private PurposeEntityModel _purposeEntityModel = new PurposeEntityModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap) throws Exception {
        return _purposeEntityModel;
    }

    @Override
    public Page<Purpose> getPurposesPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		try {
            Page<Purpose> var = SearchUtil.search(
					booleanQuery -> {
					},
					filter, PersistedPurpose.class, search, pagination,
					queryConfig -> queryConfig.setSelectedFieldNames(
							Field.ENTRY_CLASS_PK),
					searchContext -> searchContext.setCompanyId(
							contextCompany.getCompanyId()),
					document -> _toPurpose(
							_persistedPurposeService.fetchPersistedPurpose(
									GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))),
                    sorts);
                return var;
		} catch (Exception e) {
			_log.error("Error listing purposes: " + e.getMessage(), e);
			throw e;
		}
	}

    @Override
    public Purpose postPurpos(Purpose purpose) throws Exception {
        try {
            PersistedPurpose p = _persistedPurposeService.addPersistedPurpose(purpose.getName(), _getServiceContext());
            return _toPurpose(p);
        } catch (Exception e) {
            _log.error("Error occured while creating new purpose: " + e.getMessage(), e);
            throw e;
        }
    }
    
    @Override
    public Purpose getPurposPurpose(@NotNull String purposeId) throws Exception {
        try {
            PersistedPurpose p = _persistedPurposeService.fetchPersistedPurpose(Long.parseLong(purposeId));
            return (p != null) ?  _toPurpose(p) : null;
        } catch (Exception e) {
            _log.error("Error occured while retrieving purpose: " + e.getMessage(), e);
            throw e;
        } 
    }
    
    @Override
    public Purpose putPurposPurpose(@NotNull String purposeId, @NotNull Purpose purpose) throws Exception {
        try {
            PersistedPurpose p = _persistedPurposeService.updatePersistedPurpose(Long.parseLong(purposeId), purpose.getName(), _getServiceContext());
            return _toPurpose(p);
        } catch (Exception e) {
            _log.error("Error occured while updating purpose: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deletePurposPurpose(@NotNull String purposeId) throws Exception {
        try {
            _persistedPurposeService.deletePersistedPurpose(Long.parseLong(purposeId), _getServiceContext());
        } catch (Exception e) {
            _log.error("Error occured while deleting purpose: " + e.getMessage(), e);
            throw e;
        }
    }

    protected Purpose _toPurpose(PersistedPurpose purpose) {
        return new Purpose() {{
            purposeId = purpose.getPurposeId();
            name = purpose.getName();
        }};
    }

    protected ServiceContext _getServiceContext() {
		ServiceContext serviceContext = ServiceContextUtil.createServiceContext(0, "anyone");
		serviceContext.setCompanyId(contextCompany.getCompanyId());
        
        long userId = PrincipalThreadLocal.getUserId();
		serviceContext.setUserId(userId);

		return serviceContext;
    }

    @Reference
    private PersistedPurposeService _persistedPurposeService;
    
    private static final Logger _log = LoggerFactory.getLogger(PurposeResourceImpl.class);
}