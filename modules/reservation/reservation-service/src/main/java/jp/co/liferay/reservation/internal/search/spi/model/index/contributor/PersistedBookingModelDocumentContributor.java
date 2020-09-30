package jp.co.liferay.reservation.internal.search.spi.model.index.contributor;

import java.util.List;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import jp.co.liferay.reservation.model.PersistedBooking;
import jp.co.liferay.reservation.model.PersistedOffice;
import jp.co.liferay.reservation.model.PersistedParticipant;
import jp.co.liferay.reservation.model.PersistedRoom;
import jp.co.liferay.reservation.service.PersistedOfficeService;
import jp.co.liferay.reservation.service.PersistedParticipantService;
import jp.co.liferay.reservation.service.PersistedRoomService;

@Component(
	immediate = true,
	property = "indexer.class.name=jp.co.liferay.reservation.model.PersistedBooking",
	service = ModelDocumentContributor.class
)
public class PersistedBookingModelDocumentContributor implements ModelDocumentContributor<PersistedBooking> {

    @Override
    public void contribute(Document document, PersistedBooking booking) {
        document.addText("title", booking.getTitle());
        document.addText("description", booking.getDescription());
        
        document.addNumber("userId", booking.getUserId());
        document.addNumber("roomId", booking.getRoomId());
        
        document.addDate("startDate", booking.getStartDate());
        document.addDate("endDate", booking.getEndDate());

        List<PersistedParticipant> participants = _persistedParticipantService.getPersistedBookingPersistedParticipants(booking.getBookingId());
        if (participants != null && participants.size() > 0) {
            Long[] ids = new Long[participants.size()];
            for (int i = 0; i < participants.size(); i++) {
                ids[i] = participants.get(i).getParticipantId();
            }
            document.addNumber("participantIds", ids);
        }
        PersistedRoom room = _persistedRoomService.fetchPersistedRoom(booking.getRoomId()); 
        if (room != null) {
            document.addText("roomName", room.getName());
            PersistedOffice office = _persistedOfficeService.fetchPersistedOffice(room.getOfficeId());
            if (office != null) {
                document.addText("officeName", office.getName()); 
            }
        }
    }

    @Reference
    PersistedParticipantService _persistedParticipantService;

    @Reference
    PersistedOfficeService _persistedOfficeService;

    @Reference
    PersistedRoomService _persistedRoomService;
}