package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.SportsDetailsService;
import com.example.demo.pojo.DetailsPojo;
import com.example.demo.utils.ResultJson;
import com.example.demo.vo.DetailsVo;

@RestController
public class SportsDetailsController {
	@Autowired
	private SportsDetailsService sportsDetailsService;
	@RequestMapping("/getAllDetails")
	public ResultJson getObjectFromDetails() {
		//System.out.println("123");
		List<DetailsPojo> list = sportsDetailsService.getObjectFromDetails();
		return new ResultJson(list);		
	}

	/*
	 * @RequestMapping("/saveDetails") public ResultJson
	 * saveObjectToDetails(DetailsVo dv) { System.out.println(dv);
	 * sportsDetailsService.saveObjectToDetails(dv); return null;
	 */		
	//}
	//判断是否可删
	@RequestMapping("/judgeDeleteDetails")
	public ResultJson judgeDeleteDetails(Integer id) {
		//System.out.println("============================="+id);
		boolean judgeDeleteDetails = sportsDetailsService.judgeDeleteDetails(id);
		
		if(judgeDeleteDetails) {
			return new ResultJson(200,"是否删除",1);
		}else {
			return new ResultJson(200,"活动未结束,不可删除",2);
		}

	}
	
	/*
	 * @RequestMapping("/updateDetails") public ResultJson
	 * updateObjectToDetails(DetailsVo dv) { System.out.println(dv);
	 * sportsDetailsService.updateObjectToDetails(dv); return null; }
	 */
	@RequestMapping("/confirmDeleteDetails")
	public ResultJson confirmDeleteDetails(Integer id) {
		//System.out.println("============================="+id);
		sportsDetailsService.confirmDeleteDetails(id);
		return new ResultJson(200,"ok",null);		
		}
}
