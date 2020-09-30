package jp.co.liferay.reservation.internal.search.spi.model.index.contributor;

import java.util.List;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jp.co.liferay.reservation.model.PersistedAmenity;
import jp.co.liferay.reservation.model.PersistedOffice;
import jp.co.liferay.reservation.model.PersistedPurpose;
import jp.co.liferay.reservation.model.PersistedRoom;
import jp.co.liferay.reservation.service.PersistedAmenityService;
import jp.co.liferay.reservation.service.PersistedOfficeService;
import jp.co.liferay.reservation.service.PersistedPurposeService;

@Component(
	immediate = true,
	property = "indexer.class.name=jp.co.liferay.reservation.model.PersistedRoom",
	service = ModelDocumentContributor.class
)
public class PersistedRoomModelDocumentContributor implements ModelDocumentContributor<PersistedRoom> {

    @Override
    public void contribute(Document document, PersistedRoom room) {

        document.addText("name", room.getName());

        document.addNumber("officeId", room.getOfficeId());
        document.addNumber("capacityPeople", room.getCapacityPeople());
        document.addNumber("capacitySquareMeters", room.getCapacitySquareMeters());
        document.addNumber("availableStartTime", room.getAvailableStartTime());
        document.addNumber("availableEndTime", room.getAvailableEndTime());

        document.addKeyword("availableMonday", room.getAvailableMonday());
        document.addKeyword("availableTuesday", room.getAvailableTuesday());
        document.addKeyword("availableWednesday", room.getAvailableWednesday());
        document.addKeyword("availableThursday", room.getAvailableThursday());
        document.addKeyword("availableFriday", room.getAvailableFriday());
        document.addKeyword("availableSaturday", room.getAvailableSaturday());
        document.addKeyword("availableSunday", room.getAvailableSunday());

        PersistedOffice office = _persistedOfficeService.fetchPersistedOffice(room.getOfficeId());
        document.addKeyword("officeName", office.getName());
        
        List<PersistedAmenity> amenities = _persistedAmenityService.getPersistedRoomPersistedAmenities(room.getRoomId());
        if (amenities != null && amenities.size() > 0) {
            Long[] ids = new Long[amenities.size()];
            for (int i = 0; i < amenities.size(); i++) {
                ids[i] = amenities.get(i).getAmenityId();
            }
            document.addNumber("amenityIds", ids);
        }
        
        List<PersistedPurpose> purposes = _persistedPurposeService.getPersistedRoomPersistedPurposes(room.getRoomId());
        if (purposes != null && purposes.size() > 0) {
            Long[] ids = new Long[purposes.size()];
            for (int i = 0; i < purposes.size(); i++) {
                ids[i] = purposes.get(i).getPurposeId();
            }
            document.addNumber("purposeIds", ids);
        }
    }

    @Reference
    PersistedPurposeService _persistedPurposeService;

    @Reference
    PersistedAmenityService _persistedAmenityService;

    @Reference
    PersistedOfficeService _persistedOfficeService;
}