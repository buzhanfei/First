package com.example.demo.vo;


import lombok.Data;
@Data
public class DetailsVo {
	private Integer id;
	//活动类型
	private String item;
	//活动开始时间
	private String   user_date;
	//活动时长(小时)
	private Integer duration;
	//活动地点
	private String  site;
	//活动人数
	private Integer peopleNumber;
	//备注
	private String  description;
}
