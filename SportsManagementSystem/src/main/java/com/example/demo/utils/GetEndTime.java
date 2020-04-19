package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetEndTime {
	public static String getEndTime(String start,Integer hour) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long nowValue=TimeStamp.getTimeStame(start);
		Long afterHour=nowValue+hour*60*60*1000;//date加小时后的zd毫秒数
		Date afterHourDate=new Date(afterHour);
		String format = formatter.format(afterHourDate);
		return format;
	}
	}

