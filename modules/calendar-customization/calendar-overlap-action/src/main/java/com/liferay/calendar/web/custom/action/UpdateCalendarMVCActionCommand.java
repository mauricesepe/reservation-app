package com.liferay.calendar.web.custom.action;

import com.liferay.calendar.constants.CalendarPortletKeys;
import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarResourceService;
import com.liferay.calendar.service.CalendarService;
import com.liferay.calendar.web.custom.util.CalendarExpandoHelper;
import com.liferay.expando.kernel.exception.NoSuchTableException;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.service.ExpandoColumnLocalService;
import com.liferay.expando.kernel.service.ExpandoTableLocalService;
import com.liferay.expando.kernel.service.ExpandoValueLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Locale;
import java.util.Map;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + CalendarPortletKeys.CALENDAR,
		"mvc.command.name=/calendar/custom_update_calendar",
		"service.ranking:Integer=100"
	},
	service = MVCActionCommand.class
)
public class UpdateCalendarMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(
			ActionRequest actionRequest,ActionResponse actionResponse)
		throws Exception {

		// Copy from CalendarPortlet.updateCalendar(actionRequest, actionResponse)
		long calendarId = ParamUtil.getLong(actionRequest, "calendarId");

		long calendarResourceId = ParamUtil.getLong(
			actionRequest, "calendarResourceId");
		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "name");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "description");
		String timeZoneId = ParamUtil.getString(actionRequest, "timeZoneId");
		int color = ParamUtil.getInteger(actionRequest, "color");
		boolean defaultCalendar = ParamUtil.getBoolean(
			actionRequest, "defaultCalendar");
		boolean enableComments = ParamUtil.getBoolean(
			actionRequest, "enableComments");
		boolean enableRatings = ParamUtil.getBoolean(
			actionRequest, "enableRatings");

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			Calendar.class.getName(), actionRequest);

		Calendar calendar = null;

		if (calendarId <= 0) {
			CalendarResource calendarResource =
				_calendarResourceService.getCalendarResource(
					calendarResourceId);

			calendar = _calendarService.addCalendar(
				calendarResource.getGroupId(), calendarResourceId, nameMap,
				descriptionMap, timeZoneId, color, defaultCalendar,
				enableComments, enableRatings, serviceContext);
		}
		else {
			calendar = _calendarService.updateCalendar(
				calendarId, nameMap, descriptionMap, timeZoneId, color,
				defaultCalendar, enableComments, enableRatings, serviceContext);
        }

		// CUSTOM START
		// Adding Overlap expando value
		boolean disableOverlap = ParamUtil.getBoolean(
			actionRequest, "disableOverlap");

		_setOverlap(calendar, disableOverlap);
		// CUSTOM END

		sendRedirect(actionRequest, actionResponse);
	}

	private void _setOverlap(Calendar calendar, boolean disableOverlap)
		throws PortalException {

		long companyId = calendar.getCompanyId();

		try {
			ExpandoTable table = _expandoTableLocalService.getTable(
				companyId, _CALENDAR_CLASS_NAME_ID, CalendarExpandoHelper.TABLE_NAME);

			ExpandoColumn column = _expandoColumnLocalService.getColumn(
				companyId, _CALENDAR_CLASS_NAME_ID, CalendarExpandoHelper.TABLE_NAME,
				CalendarExpandoHelper.COLUMN_DISABLE_OVERLAP);

			if (column == null) {
				column = _expandoColumnLocalService.addColumn(
					table.getTableId(), CalendarExpandoHelper.COLUMN_DISABLE_OVERLAP,
					ExpandoColumnConstants.BOOLEAN);

				_log.debug("Add Expando Colunn: " + CalendarExpandoHelper.COLUMN_DISABLE_OVERLAP);
			}

			_expandoValueLocalService.addValue(
				_CALENDAR_CLASS_NAME_ID, table.getTableId(), column.getColumnId(),
				calendar.getPrimaryKey(), Boolean.toString(disableOverlap));

			_log.debug("Add Expando Value");

		} catch (NoSuchTableException nste) {
			_expandoTableLocalService.addTable(
				companyId, Calendar.class.getName(), CalendarExpandoHelper.TABLE_NAME);

			_log.debug("Add Expando Table " + CalendarExpandoHelper.TABLE_NAME);

			_setOverlap(calendar, disableOverlap);
		}
	}

	@Reference(unbind = "-")
	protected void setCalendarResourceService(
		CalendarResourceService calendarResourceService) {

		_calendarResourceService = calendarResourceService;
	}

	@Reference(unbind = "-")
	protected void setCalendarService(CalendarService calendarService) {
		_calendarService = calendarService;
	}

	@Reference(unbind = "-")
	protected void setExpandoColumnLocalService(
		ExpandoColumnLocalService expandoColumnLocalService) {
		_expandoColumnLocalService = expandoColumnLocalService;
	}

	@Reference(unbind = "-")
	protected void setExpandoTableLocalService(
		ExpandoTableLocalService expandoTableLocalService){

		_expandoTableLocalService = expandoTableLocalService;
	}

	@Reference(unbind = "-")
	protected void setExpandoValueLocalService(ExpandoValueLocalService expandoValueLocalService) {
		_expandoValueLocalService = expandoValueLocalService;
	}

	private Log _log = LogFactoryUtil.getLog(UpdateCalendarMVCActionCommand.class);

	private CalendarResourceService _calendarResourceService;
	private CalendarService _calendarService;
	private ExpandoColumnLocalService _expandoColumnLocalService;
	private ExpandoTableLocalService _expandoTableLocalService;
	private ExpandoValueLocalService _expandoValueLocalService;

	private final long _CALENDAR_CLASS_NAME_ID = ClassNameLocalServiceUtil.getClassNameId(Calendar.class);
}
