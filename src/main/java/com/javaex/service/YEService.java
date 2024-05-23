package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.javaex.dao.YEDao;
import com.javaex.vo.BusinessVo;
import com.javaex.vo.ReviewListVo;
import com.javaex.vo.StoreVo;

@Service
public class YEService {

	@Autowired
	private YEDao yeDao;

	public void exeMsignup(BusinessVo businessVo) {
		System.out.println("YEService.exeMsignup()");
		
		yeDao.msignup(businessVo);
	}

	public int exeIdCheck(String id) {
		System.out.println("YEService.exeIdCheck()");
		
		int count = yeDao.idCheck(id);
		
		return count;
	}

	public BusinessVo exeMlogin(@ModelAttribute BusinessVo businessVo) {
		System.out.println("YEService.exeMlogin()");
		
		BusinessVo auth = yeDao.mlogin(businessVo);
		
		return auth;
	}

	public List<ReviewListVo> exeSearchList() {
		System.out.println("YEService.exeSearchList()");
		
		List<ReviewListVo> reviewList = yeDao.searchList();
		
		return reviewList;
	}

	public List<StoreVo> exeSearchMap(StoreVo storeVo) {
		System.out.println("YEService.exeSearchMap()");
		
		List<StoreVo> storeList = yeDao.searchMap(storeVo);
		
		return storeList;
		
	}

	public List<StoreVo> exeList(StoreVo storeVo) {
		System.out.println("YEService.exeList()");
		
		List<StoreVo> mainList= yeDao.mainList(storeVo);
		
		return mainList;
	}
	
}
