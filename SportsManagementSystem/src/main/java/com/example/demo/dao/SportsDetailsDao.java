package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.DetailsPojo;

@Mapper
public interface SportsDetailsDao extends BaseMapper<DetailsPojo>{
	@Select("select * from details")
	List<DetailsPojo> getObjectFromDetails();
	@Insert("insert into details values(null,#{itemId},#{startTime},#{endTime},#{site},#{peopleNumber},#{remark})")
	int saveDetais(DetailsPojo pojo);
	@Select("select * from details where id=#{id}")
	DetailsPojo getObjectFromDetailsById(Integer id);
	@Delete("delete from details where id=#{id}")
	void deleteDetailsBuId(Integer id);
	//void updateDetailsById(DetailsPojo detailsPojo);
}
