package com.example.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TimeStamp {
	public static long getTimeStame(String date) {
		// 格式
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 
		long time = 0;
		try {
			time = formatter.parse(date).getTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;

	}
}
