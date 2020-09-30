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

import jp.co.liferay.headless.reservation.dto.v1_0.Office;
import jp.co.liferay.headless.reservation.internal.odata.entity.v1_0.OfficeEntityModel;
import jp.co.liferay.headless.reservation.resource.v1_0.OfficeResource;
import jp.co.liferay.reservation.model.PersistedOffice;
import jp.co.liferay.reservation.service.PersistedOfficeService;

/**
 * @author Maurice Sepe
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/office.properties",
	scope = ServiceScope.PROTOTYPE, service = OfficeResource.class
)
public class OfficeResourceImpl extends BaseOfficeResourceImpl implements EntityModelResource{

    private OfficeEntityModel _officeEntityModel = new OfficeEntityModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap) throws Exception {
        return _officeEntityModel;
    }

    @Override
    public Page<Office> getOfficesPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		try {
            Page<Office> var = SearchUtil.search(
					booleanQuery -> {
					},
					filter, PersistedOffice.class, search, pagination,
					queryConfig -> queryConfig.setSelectedFieldNames(
							Field.ENTRY_CLASS_PK),
					searchContext -> searchContext.setCompanyId(
							contextCompany.getCompanyId()),
					document -> _toOffice(
							_persistedOfficeService.fetchPersistedOffice(
									GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))),
                    sorts);
                return var;
		} catch (Exception e) {
			_log.error("Error occured while retrieving office: " + e.getMessage(), e);
			throw e;
		}
	}

    @Override
    public Office postOffice(@NotNull Office office) throws Exception {
        try {
            PersistedOffice o = _persistedOfficeService.addPersistedOffice(office.getName(), 
                    office.getLocation(), _getServiceContext());
            return _toOffice(o);
        } catch (Exception e) {
            _log.error("Error occured while creating office: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Office getOffice(@NotNull String officeId) throws Exception {
        try {
            PersistedOffice o = _persistedOfficeService.fetchPersistedOffice(Long.parseLong(officeId));
            return (null != o) ? _toOffice(o) : null;
        } catch (Exception e) {
            _log.error("Error occured while retrieving office: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Office putOffice(@NotNull String officeId, @NotNull Office office) throws Exception {
        try {
            PersistedOffice o = _persistedOfficeService.updatePersistedOffice(Long.parseLong(officeId), 
                    office.getName(), office.getLocation(), _getServiceContext());
            return _toOffice(o);
        } catch (Exception e) {
            _log.error("Error occured while updating office: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteOffice(@NotNull String officeId) throws Exception {
        try {
            _persistedOfficeService.deletePersistedOffice(Long.parseLong(officeId));
        } catch (Exception e) {
            _log.error("Error occured while deleting office: " + e.getMessage(), e);
            throw e;
        }
    }

    protected Office _toOffice(PersistedOffice office) {
        return new Office() {{
            officeId = office.getOfficeId();
            name = office.getName();
            location = office.getLocation();
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
    private PersistedOfficeService _persistedOfficeService;
    
    private static final Logger _log = LoggerFactory.getLogger(OfficeResourceImpl.class);
}