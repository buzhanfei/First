package com.example.demo.pojo;






import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
@TableName(value = "details")
@Data
public class DetailsPojo {
	@TableId(type = IdType.AUTO)
	private Integer id;
	private Integer itemId;
	private String startTime;
	private String endTime;
	private String site;
	private Integer peopleNumber;	
	private String remark;
	@TableField(exist = false) //映射时忽略本字段
	private String operate;
	@TableField(exist = false)
	private String item;
	@TableField(exist = false)
	private Integer hour;
}
