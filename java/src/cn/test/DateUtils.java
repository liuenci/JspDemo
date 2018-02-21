package cn.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static String getSystemDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = sdf.format(date);
		return sdate;
	}
	public static String getSystemTime() {
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		Date date = new Date();
		String time = format.format(date);
		return time;
	}
}
