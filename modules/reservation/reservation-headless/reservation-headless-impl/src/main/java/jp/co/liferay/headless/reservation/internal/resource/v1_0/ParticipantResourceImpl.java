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

import jp.co.liferay.headless.reservation.dto.v1_0.Participant;
import jp.co.liferay.headless.reservation.internal.odata.entity.v1_0.ParticipantEntityModel;
import jp.co.liferay.headless.reservation.resource.v1_0.ParticipantResource;
import jp.co.liferay.reservation.model.PersistedParticipant;
import jp.co.liferay.reservation.service.PersistedParticipantService;

/**
 * @author Maurice Sepe
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/participant.properties",
	scope = ServiceScope.PROTOTYPE, service = ParticipantResource.class
)
public class ParticipantResourceImpl extends BaseParticipantResourceImpl implements EntityModelResource {

    private ParticipantEntityModel _participantEntityModel = new ParticipantEntityModel();

    @Override
    public EntityModel getEntityModel(MultivaluedMap multivaluedMap) throws Exception {
        return _participantEntityModel;
    }

    @Override
    public Page<Participant> getParticipantsPage(String search, Filter filter, Pagination pagination, Sort[] sorts) throws Exception {
        try {
            Page<Participant> var = SearchUtil.search(
					booleanQuery -> {
					},
					filter, PersistedParticipant.class, search, pagination,
					queryConfig -> queryConfig.setSelectedFieldNames(
							Field.ENTRY_CLASS_PK),
					searchContext -> searchContext.setCompanyId(
							contextCompany.getCompanyId()),
					document -> _toParticipant(
							_persistedParticipantService.fetchPersistedParticipant(
									GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)))),
                    sorts);
                return var;
        } catch (Exception e) {
            _log.error("Error occured while retrieving participants: " + e.getMessage(), e);
            throw e;
        }
	}

    @Override
    public Participant postParticipant(@NotNull Participant participant) throws Exception {
        try {
            PersistedParticipant p = _persistedParticipantService.addPersistedParticipant(participant.getUserId(),
                participant.getFullName(), participant.getCompanyName(), participant.getEmailAddress(), _getServiceContext());
            return _toParticipant(p);
        } catch (Exception e) {
            _log.error("Error occured while creating participant: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Participant getParticipant(@NotNull String participantId) throws Exception {
        try {
            PersistedParticipant p = _persistedParticipantService.fetchPersistedParticipant(Long.parseLong(participantId));
            return (null != p) ? _toParticipant(p) : null;
        } catch (Exception e) {
            _log.error("Error occured while retrieving participant: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public Participant putParticipant(@NotNull String participantId, @NotNull Participant participant) throws Exception {
        try {
            PersistedParticipant p = _persistedParticipantService.updatePersistedParticipant(Long.parseLong(participantId), 
                participant.getUserId(), participant.getFullName(), 
                participant.getCompanyName(), participant.getEmailAddress(), _getServiceContext());
            return _toParticipant(p);
        } catch (Exception e) {
            _log.error("Error occured while updating participant: " + e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void deleteParticipant(@NotNull String participantId) throws Exception {
        try {
            _persistedParticipantService.deletePersistedParticipant(Long.parseLong(participantId));
        } catch (Exception e) {
            _log.error("Error occured while deleting participant: " + e.getMessage(), e);
            throw e;
        }
    }

    protected Participant _toParticipant(PersistedParticipant participant) {
        return new Participant() {{
            participantId = participant.getParticipantId();
            userId = participant.getUserId();
            fullName = participant.getFullName();
            companyName = participant.getCompanyName();
            emailAddress = participant.getEmailAddress();
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
    private PersistedParticipantService _persistedParticipantService;
    
    private static final Logger _log = LoggerFactory.getLogger(ParticipantResourceImpl.class);
}