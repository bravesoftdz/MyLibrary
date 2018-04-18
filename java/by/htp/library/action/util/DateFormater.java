package by.htp.library.action.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import by.htp.library.constants.TimeZones;

public class DateFormater {

	public String formDate(long dateOn) {
		long unixSeconds = dateOn; 
		Date date = new Date(unixSeconds * 1000L); 
		SimpleDateFormat sdf = new SimpleDateFormat(TimeZones.DATE_FORMAT); 
		sdf.setTimeZone(TimeZone.getTimeZone(TimeZones.TIME_ZONE_MINSK)); 
		String formattedDate = sdf.format(date);
		return formattedDate;
	}
	
}
