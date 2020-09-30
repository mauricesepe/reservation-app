package jp.co.liferay.reservation.react.admin.application.list;

import jp.co.liferay.reservation.react.admin.constants.ReservationReactAdminPanelCategoryKeys;
import jp.co.liferay.reservation.react.admin.constants.ReservationReactAdminPortletKeys;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.model.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author mauricesepe
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=100",
		"panel.category.key=" + ReservationReactAdminPanelCategoryKeys.CONTROL_PANEL_CATEGORY
	},
	service = PanelApp.class
)
public class ReservationReactAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return ReservationReactAdminPortletKeys.RESERVATIONREACTADMIN;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + ReservationReactAdminPortletKeys.RESERVATIONREACTADMIN + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}