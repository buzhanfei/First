package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SportsItemDao {
	@Select("select id from item where item=#{name}")
	int findIdByName(String name);
	@Select("select item from item where id=#{itemId};")
	String getItemByid(Integer itemId);
}
