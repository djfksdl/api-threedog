package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.JWDao;
import com.javaex.vo.ReserveVo;

@Service
public class JWService {

	@Autowired
	private JWDao jwDao;
	
	// 한 가게의 예약 리스트 정보 조회 
	public List<ReserveVo> getReserveList() {
		System.out.println("JWService.getReserveList()");
		
		List<ReserveVo> reserveList = jwDao.selectReserveList();
		
		return reserveList;
	}

	// 예약 정보 업데이트
	public int exeUpdateReserve(ReserveVo reserveVo) {
		System.out.println("JWService.exeUpdateReserve()");
		int count = jwDao.diary(reserveVo);
		return count;
	}

}
