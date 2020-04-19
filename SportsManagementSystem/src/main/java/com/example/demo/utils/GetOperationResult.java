package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetOperationResult {
	
	public static boolean getResult(String endTime,String startTime) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = formatter.format(new Date());
		long current = TimeStamp.getTimeStame(currentTime);
		long end = TimeStamp.getTimeStame(endTime);
		if(startTime!=null) {
		long start = TimeStamp.getTimeStame(startTime);
		return current>=start?true:false;
		}else {			
			return current>=end?true:false;
		}
	}
	
	public static int getHours(String endTime,String startTime) {
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long end = TimeStamp.getTimeStame(endTime);
		long start = TimeStamp.getTimeStame(startTime);	
		int hours=(int)(end-start)/1000/60/60;	
		return hours;
	}
}
