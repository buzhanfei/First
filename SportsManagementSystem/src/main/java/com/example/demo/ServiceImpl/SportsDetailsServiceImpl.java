package com.example.demo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Service.SportsDetailsService;
import com.example.demo.dao.SportsDetailsDao;
import com.example.demo.dao.SportsItemDao;
import com.example.demo.pojo.DetailsPojo;
import com.example.demo.utils.GetDate;
import com.example.demo.utils.GetEndTime;
import com.example.demo.utils.GetOperationResult;
import com.example.demo.utils.TimeStamp;
import com.example.demo.vo.DetailsVo;
@Service
public class SportsDetailsServiceImpl implements SportsDetailsService {
	@Autowired
	private SportsDetailsDao sportsDetailsDao;
	@Autowired
	private SportsItemDao sportsItemDao;
	@Override
	public List<DetailsPojo> getObjectFromDetails() {
		List<DetailsPojo> list = sportsDetailsDao.getObjectFromDetails();
		//System.out.println("------------------------------");
		//System.out.println(list);
		for (DetailsPojo detailsPojo : list) {
			String item = sportsItemDao.getItemByid(detailsPojo.getItemId());
			detailsPojo.setItem(item);
			boolean result = GetOperationResult.getResult(detailsPojo.getEndTime(),detailsPojo.getStartTime());
			if(result) {
				detailsPojo.setOperate("删除");
			}else {
				detailsPojo.setOperate("修改");
			}
		}
		//System.out.println("========================================");
		//System.out.println(list);
		return list;
	}
	@Override
	@Transactional
	public void saveObjectToDetails(DetailsVo dv) {
		// TODO Auto-generated method stub
		if(dv==null) {
			throw new RuntimeException("新增数据为空");
		}
		DetailsPojo detailsPojo = new DetailsPojo();
		//String[] arr= {"badminton","basketball","pingPong","rockClimbing","swim"};		
		String item = dv.getItem();
		if("badminton".equals(item)) {
			int itemId = sportsItemDao.findIdByName("羽毛球活动");
			detailsPojo.setItemId(itemId);
		}else if("basketball".equals(item)) {
			int itemId = sportsItemDao.findIdByName("篮球活动");
			detailsPojo.setItemId(itemId);
		}else if("pingPong".equals(item)) {
			int itemId = sportsItemDao.findIdByName("乒乓球活动");
			detailsPojo.setItemId(itemId);
		}else if("rockClimbing".equals(item)) {
			int itemId = sportsItemDao.findIdByName("攀岩活动");
			detailsPojo.setItemId(itemId);
		}else {
			int itemId = sportsItemDao.findIdByName("游泳活动");
			detailsPojo.setItemId(itemId);
		}
		//System.out.println(dv.getUser_date());
		String date = GetDate.getDate(dv.getUser_date());
		//System.out.println(date);
		detailsPojo.setStartTime(date);
		String endTime = GetEndTime.getEndTime(date, dv.getDuration());
		detailsPojo.setEndTime(endTime);
		detailsPojo.setSite(dv.getSite());
		detailsPojo.setPeopleNumber(dv.getPeopleNumber());
		detailsPojo.setRemark(dv.getDescription());
		//System.out.println("=====================================================");
		//System.out.println(detailsPojo);
		sportsDetailsDao.saveDetais(detailsPojo);
	}
	@Override
	public boolean judgeDeleteDetails(Integer id) {
		// TODO Auto-generated method stub
		//System.out.println(id);
		DetailsPojo objectFromDetailsById = sportsDetailsDao.getObjectFromDetailsById(id);
		
		System.out.println(objectFromDetailsById);
		String endTime = objectFromDetailsById.getEndTime();
		boolean result = GetOperationResult.getResult(endTime, null);
		if(result) {
			return true;
		}
		return false;
	}
	@Override
	public void confirmDeleteDetails(Integer id) {
		// TODO Auto-generated method stub
		sportsDetailsDao.deleteDetailsBuId(id);
	}
	@Override
	public DetailsPojo getDetailsById(Integer id) {
		// TODO Auto-generated method stub
		DetailsPojo details = sportsDetailsDao.getObjectFromDetailsById(id);
		int hours = GetOperationResult.getHours(details.getEndTime(), details.getStartTime());
		details.setHour(hours);
		String item = sportsItemDao.getItemByid(details.getItemId());
		details.setItem(item);
		return details;
	}
	@Override
	public void updateObjectToDetails(DetailsVo dv) {
		// TODO Auto-generated method stub
		//System.out.println(dv);
		DetailsPojo detailsPojo = new DetailsPojo();
		String endTime = GetEndTime.getEndTime(dv.getUser_date(),dv.getDuration());
		detailsPojo.setEndTime(endTime);
		detailsPojo.setPeopleNumber(dv.getPeopleNumber());
		detailsPojo.setId(dv.getId());
		//MybatisPlus
		sportsDetailsDao.updateById(detailsPojo);
		//sportsDetailsDao.updateDetailsById(detailsPojo);
	}
	
}
