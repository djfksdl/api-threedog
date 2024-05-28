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
	public void deleteReserve(int rsNo) {
		sqlSession.delete("jw.deleteReserve", rsNo);
		System.out.println("예약 정보 삭제 완료: " + rsNo);
	}

	/****************************
	 * 알림장화면
	 ****************************/
	// 미용 기록 업데이트
		public void updateGroomingRecord(ReserveVo reserveVo) {
			sqlSession.update("com.example.mapper.JWMapper.updateGroomingRecord", reserveVo);
		}
		// 사진 업로드
		public void insertAfterImg(int rsNo, String saveName, String orgName, long fileSize, String filePath) {
		    Map<String, Object> paramMap = new HashMap<>();
		    paramMap.put("rsNo", rsNo);
		    paramMap.put("saveName", saveName);
		    paramMap.put("orgName", orgName);
		    paramMap.put("fileSize", fileSize);
		    paramMap.put("filePath", filePath);

		    sqlSession.insert("jw.insertAfterImg", paramMap);
		}


}
