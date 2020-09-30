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

import jp.co.liferay.headless.reservation.dto.v1_0.Amenity;
import jp.co.liferay.headless.reservation.internal.odata.entity.v1_0.AmenityEntityModel;
import jp.co.liferay.headless.reservation.resource.v1_0.AmenityResource;
import jp.co.liferay.reservation.model.PersistedAmenity;
import jp.co.liferay.reservation.service.PersistedAmenityService;

/**
 * @author Maurice Sepe
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/amenity.properties",
	scope = ServiceScope.PROTOTYPE, service = AmenityResource.class
)
public class AmenityResourceImpl extends BaseAmenityResourceImpl implements EntityModelResource{

    private AmenityEntityModel _amenityEntityModel = new AmenityEntityModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap) throws Exception {
        return _amenityEntityModel;
    }

    @Override
    public Page<Amenity> getAmenitiesPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
		try {  
            Page<Amenity> var = SearchUtil.search(
					booleanQuery -> {
					},
					filter, PersistedAmenity.class, search, pagination,
					queryConfig -> queryConfig.setSelectedFieldNames(
							Field.ENTRY_CLASS_PK),
					searchContext -> searchContext.setCompanyId(
							contextCompany.getCompanyId()),
					document -> _toAmenity(
							_persistedAmenityService.fetchPersistedAmenity(
									GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))),
                    sorts);
                return var;
		} catch (Exception e) {
			_log.error("Error listing amenities: " + e.getMessage(), e);
			throw e;
		}
	}

    @Override
    public Amenity postAmenity(Amenity amenity) throws Exception {
        try {
            PersistedAmenity a = _persistedAmenityService.addPersistedAmenity(amenity.getName(), _getServiceContext());
            return _toAmenity(a);
        } catch (Exception e) {
            _log.error("Error occured while creating new amenity: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Amenity getAmenity(@NotNull String amenityId) throws Exception {
        try {
            PersistedAmenity a = _persistedAmenityService.fetchPersistedAmenity(Long.parseLong(amenityId));
            return (null != a) ? _toAmenity(a) : null;
        } catch (Exception e) {
            _log.error("Error occured while retrieving amenity: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Amenity putAmenity(@NotNull String amenityId, @NotNull Amenity amenity) throws Exception {
        try {
            PersistedAmenity a = _persistedAmenityService.updatePersistedAmenity(Long.parseLong(amenityId), amenity.getName(), _getServiceContext());
            return _toAmenity(a);
        } catch (Exception e) {
            _log.error("Error occured while updating amenity: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override 
    public void deleteAmenity(@NotNull String amenityId) throws Exception {
        try {
            _persistedAmenityService.deletePersistedAmenity(Long.parseLong(amenityId));
        } catch (Exception e) {
            _log.error("Error occured while deleting amenity: " + e.getMessage(), e);
            throw e;
        }
    }

    protected Amenity _toAmenity(PersistedAmenity amenity) {
        return new Amenity() {{
            amenityId = amenity.getAmenityId();
            name = amenity.getName();
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
    private PersistedAmenityService _persistedAmenityService;
    
    private static final Logger _log = LoggerFactory.getLogger(AmenityResourceImpl.class);
}