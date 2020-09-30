package com.liferay.calendar.web.custom.util;

import com.liferay.calendar.model.Calendar;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

public class CalendarExpandoHelper {

	public static String TABLE_NAME = "CalendarCustomFields";
	public static String COLUMN_DISABLE_OVERLAP = "disableOverlap";

	public static boolean isOverlapDisabled(long companyId, long calendarId)
		throws PortalException {

		ExpandoValue value = ExpandoValueLocalServiceUtil.getValue(
			companyId, Calendar.class.getName(), TABLE_NAME, COLUMN_DISABLE_OVERLAP, calendarId);

		if (value == null) {
			return false;
		}

		return value.getBoolean();
	}
}
