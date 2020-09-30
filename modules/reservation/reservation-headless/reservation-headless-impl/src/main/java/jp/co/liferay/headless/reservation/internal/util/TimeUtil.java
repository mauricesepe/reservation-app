package jp.co.liferay.headless.reservation.internal.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.TimeZoneUtil;

import jp.co.liferay.headless.reservation.dto.v1_0.Time;

public class TimeUtil {

    public static Date getDateOnly(Date date) {
        TimeZone tz = TimeZoneUtil.getDefault();
        Calendar cal = CalendarFactoryUtil.getCalendar(tz);
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Time getTimeOnly(Date date) {
        TimeZone tz = TimeZoneUtil.getDefault();
        Calendar cal = CalendarFactoryUtil.getCalendar(tz);
        cal.setTime(date);

        return new Time() {{
            int hr = cal.get(Calendar.HOUR_OF_DAY) % 12;
            hr = (hr == 0) ? 12 : hr;
            hours = Integer.toString(hr);
            minutes = Integer.toString(cal.get(Calendar.MINUTE));
            ampm = (Calendar.AM == cal.get(Calendar.AM_PM)) ? "am" : "pm";
        }};
    }

    public static Date convertToDate(String dt, Time time) throws Exception {
        _validate(time);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dt);

        int hours = Integer.parseInt(time.getHours());
        int minutes = Integer.parseInt(time.getMinutes());
        int ampm = ("am".equalsIgnoreCase(time.getAmpm())) ? Calendar.AM : Calendar.PM;
        /* special case for 12 hour */
        if (hours == 12) {
            hours = 0;
        }
        TimeZone tz = TimeZoneUtil.getDefault();
        Calendar cal = CalendarFactoryUtil.getCalendar(tz);
        cal.setTime(date);
        cal.set(Calendar.HOUR, hours);
        cal.set(Calendar.MINUTE, minutes);
        cal.set(Calendar.AM_PM, ampm);
        return cal.getTime();
    }

    public static Time convertToTime(int i) {
        boolean isPm = (i/60) > 12;
        int hr = (i / 60) % 12;
        int min = i % 60;
        return new Time(){{
            hours = Integer.toString((hr == 0) ? 12 : hr);
            minutes =  Integer.toString(min);
            ampm = isPm ? "pm" : "am";
        }};
    }

    public static int convertToMinutes(Time time) throws Exception{
        _validate(time);
        int hours = Integer.parseInt(time.getHours());
        int minutes = Integer.parseInt(time.getMinutes());
        boolean isPm = "pm".equalsIgnoreCase(time.getAmpm());
        int v = (hours % 12 + (isPm ? 12 : 0)) * 60 + minutes;
        return v;
    }

    private static void _validate(Time time) throws Exception {
        int hours = Integer.parseInt(time.getHours());
        if (hours < 1 || hours > 12) {
            throw new Exception("invalid-hour-format");
        }
        int minutes = Integer.parseInt(time.getMinutes());
        if (minutes < 0 || minutes > 59) {
            throw new Exception("invalid-minute-format");
        }
        if (!"am".equalsIgnoreCase(time.getAmpm()) 
                && !"pm".equalsIgnoreCase(time.getAmpm())) {
            throw new Exception("invalid-ampm-format");
        }
    }
}