package vaibhav.framework.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
	
	public static String getTimeStamp() {
		SimpleDateFormat Dateformat = new SimpleDateFormat("MM-dd-YYYY HH:mm::ss");
		Date date = new Date();
		String timeStamp = Dateformat.format(date);	
		System.out.println(timeStamp);
		return timeStamp;		
	}

}
