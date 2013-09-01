package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static Date parse(String dateStr) throws ParseException {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    	return sdf.parse(dateStr);
	}
}
