package com.example.demo.Service;

import java.util.List;

import com.example.demo.pojo.DetailsPojo;
import com.example.demo.vo.DetailsVo;

public interface SportsDetailsService {

	List<DetailsPojo> getObjectFromDetails();

	void saveObjectToDetails(DetailsVo dv);

	boolean judgeDeleteDetails(Integer id);

	void confirmDeleteDetails(Integer id);
	
	DetailsPojo getDetailsById(Integer id);

	void updateObjectToDetails(DetailsVo dv);

}
