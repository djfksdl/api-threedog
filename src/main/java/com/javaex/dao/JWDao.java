package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ReserveVo;

@Repository
public class JWDao {

	@Autowired
	private SqlSession sqlSession;
	
	// 한 가게의 예약 리스트 정보 조회 
	public List<ReserveVo> selectReserveList() {
		System.out.println("JWDao.selectReserveList()");

		List<ReserveVo> reserveList = sqlSession.selectList("jw.selectReserveList");
		return reserveList;
	}

	// 예약 정보 업데이트
	public int diary(ReserveVo reserveVo) {
		System.out.println("JWDao.diary()");

		int count = sqlSession.update("jw.updateReserve", reserveVo);
		System.out.println(count);
		return count;

	}

}
