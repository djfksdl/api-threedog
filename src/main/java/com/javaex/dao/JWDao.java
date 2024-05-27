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
	public List<ReserveVo> selectReserveList(int bNo) {
		System.out.println("JWDao.selectReserveList()");

		List<ReserveVo> reserveList = sqlSession.selectList("jw.selectReserveList", bNo);
		// System.out.println("밍밍밍"+reserveList);

		return reserveList;
	}

	// 일정 수정
	public void updateReserveDate(ReserveVo reserveVo) {
		sqlSession.update("jw.updateReserveDate", reserveVo);
		System.out.println("예약 일정이 수정되었습니다.");
	}

	// 시간 수정
	public void updateReserveTime(ReserveVo reserveVo) {
		sqlSession.update("jw.updateReserveTime", reserveVo);
		System.out.println("예약 시간이 수정되었습니다.");
	}

	// 예약 삭제
	public void deleteReserve(int rsNo) {
		sqlSession.delete("jw.deleteReserve", rsNo);
		System.out.println("예약 정보 삭제 완료: " + rsNo);
	}

	// 예약 정보 업데이트
	public int updateReserve(ReserveVo reserveVo) {
		System.out.println("JWDao.updateReserve()");

		int count = sqlSession.update("jw.updateReserve", reserveVo);
		System.out.println(count);
		return count;
	}

}
