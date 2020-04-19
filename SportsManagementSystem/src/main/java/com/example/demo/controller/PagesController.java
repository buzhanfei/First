package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.SportsDetailsService;
import com.example.demo.pojo.DetailsPojo;
import com.example.demo.vo.DetailsVo;

@Controller
public class PagesController {
	@Autowired
	private SportsDetailsService sportsDetailsService;
	@RequestMapping("/")
	public String getStartPage() {
		return "index"; 
	}
	@RequestMapping("/page/{which}")
	public String getAddPage(@PathVariable String which ,Model model) {
		return which;
	}
	@RequestMapping("/page/{which}/{id}")
	public String getUpdatePage(@PathVariable String which,@PathVariable Integer id,Model model) {
		//System.out.println("KKKKKKKKKKKKKKKKKKK"+id);
		//HttpSession session = quest.getSession();
		//session.setAttribute("id", id);
		DetailsPojo details = sportsDetailsService.getDetailsById(id);
		model.addAttribute("details", details);
		System.out.println(details);
		return which;
	}
	
	@RequestMapping("/updateDetails")
	public String updateObjectToDetails(DetailsVo dv) {
		//System.out.println(dv);
		sportsDetailsService.updateObjectToDetails(dv);
		return "redirect:/";		
	}
	
	@RequestMapping("/saveDetails")
	public String saveObjectToDetails(DetailsVo dv) {
		System.out.println(dv);
		sportsDetailsService.saveObjectToDetails(dv);
		return "redirect:/";
	}
	
}
