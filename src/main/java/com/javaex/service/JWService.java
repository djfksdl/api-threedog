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
	public List<ReserveVo> getReserveList(int bNo) {
		System.out.println("JWService.getReserveList()");

		List<ReserveVo> reserveList = jwDao.selectReserveList(bNo);

		return reserveList;
	}

	// 일정 수정
	public void updateReserveDate(ReserveVo reserveVo) {
		jwDao.updateReserveDate(reserveVo);
		System.out.println("JWService.updateReserveDate() 메서드 실행");
	}

	// 시간 수정
	public void updateReserveTime(ReserveVo reserveVo) {
		jwDao.updateReserveTime(reserveVo);
		System.out.println("JWService.updateReserveTime() 메서드 실행");
	}

	// 예약 삭제
	public void deleteReserve(int rsNo) {
		jwDao.deleteReserve(rsNo);
	}

	// 예약 정보 업데이트
	public int exeUpdateReserve(ReserveVo reserveVo) {
		System.out.println("JWService.exeUpdateReserve()");
		int count = jwDao.updateReserve(reserveVo);
		return count;
	}
}
