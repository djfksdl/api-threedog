package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ReserveVo;

@Repository
public class JWDao {

	@Autowired
	private SqlSession sqlSession;

	/****************************
	 * 스케줕화면
	 ****************************/

	// 한 가게의 예약 리스트 정보 조회
	public List<ReserveVo> selectReserveList(int bNo) {
		System.out.println("JWDao.selectReserveList()");

		List<ReserveVo> reserveList = sqlSession.selectList("jw.selectReserveList", bNo);
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
	// 예약 삭제
	public void deleteReserve(int rsNo) {
	    sqlSession.delete("jw.deleteReserve", rsNo);
	    System.out.println("예약 정보 삭제 완료: " + rsNo);
	}
	
	// 예약 테이블에서 예약 삭제
	public void deleteReserve2(int rsNo) {
	    sqlSession.delete("jw.deleteReserve2", rsNo);
	    System.out.println("예약 정보 삭제 완료2: " + rsNo);
	}

	// 예약 시간 완료 상태 업데이트
	public void updateReserveTimeFinishByRsNo(int rsNo) {
	    sqlSession.update("jw.updateReserveTimeFinishByRsNo", rsNo);
	    System.out.println("예약 정보 삭제 완료up: " + rsNo);
	}


	// 특정 예약의 미용 기록 조회
	public ReserveVo selectGroomingRecord(int rsNo) {
		System.out.println("DAO에서 특정 예약의 미용 기록 조회 메서드 실행");

		ReserveVo groomingRecord = sqlSession.selectOne("jw.selectGroomingRecord", rsNo);

		System.out.println("미용 기록 조회 결과: " + groomingRecord);

		return groomingRecord;
	}

	/****************************
	 * 알림장화면
	 ****************************/
	// 미용 기록 업데이트 쿼리 실행
	public void updateGroomingRecord(ReserveVo reserveVo) {
		  System.out.println("DAO: 미용 기록 업데이트 쿼리 실행");
		sqlSession.update("jw.updateGroomingRecord", reserveVo);
	}

	// 이미지 정보를 DB에 삽입하는 메서드
	public void insertAfterImg(int rsNo, String saveName) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("rsNo", rsNo); // 예약 번호
		paramMap.put("saveName", saveName); // 저장된 파일명
		sqlSession.insert("jw.insertAfterImg", paramMap); // 쿼리 실행하여 DB에 삽입
	}
	//알림발송
	public void insertPushNotification(int rsNo) {
		 sqlSession.insert("jw.insertPushNotification", rsNo);
		 System.out.println("푸싱싱싱: " + rsNo);
		
	}

}