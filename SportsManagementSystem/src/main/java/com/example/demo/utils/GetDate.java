package com.example.demo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class GetDate {
	public static String getDate(String date) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
		DateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//df2.setTimeZone(TimeZone.getTimeZone("GMT"));
		Date d = null;
		String d1="0000-00-00T00:00:00";
		if(d1.length()==date.length()) {
			
			try {
			    d = df.parse(date);
			    //System.out.println(d);
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			String value = df2.format(d);
			return value;
		}else {
			date=date+":00";
			try {
			    d = df.parse(date);
			    //System.out.println(d);
			} catch (ParseException e) {
			    e.printStackTrace();
			}
			String value = df2.format(d);
			return value;
		}		
		
	}
}
