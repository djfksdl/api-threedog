package com.javaex.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.JWDao;
import com.javaex.vo.ReserveVo;

@Service
public class JWService {

	@Autowired
	private JWDao jwDao;

	/****************************
	 * 스케줕화면
	 ****************************/

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
		System.out.println("JWService.deleteReserve() 메서드 실행");
	}

	/****************************
	 * 알림장화면
	 ****************************/
	
	// 미용 기록 업데이트
		public void updateGroomingRecord(ReserveVo reserveVo) {
		    System.out.println("JWService.updateGroomingRecord() 메서드 실행");

		    // 파일 업로드 로직
		    List<MultipartFile> files = reserveVo.getFiles();
		    
		    for (MultipartFile file : files) {
		        // 파일 저장 경로 정의 (예시)
		        String uploadDir = "/path/to/upload/directory/";

		        // 파일 저장 로직
		        try {
		            byte[] bytes = file.getBytes();
		            // 파일명 중복을 방지하기 위해 유니크한 파일명 생성
		            String uniqueFileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
		            Path path = Paths.get(uploadDir + uniqueFileName);
		            Files.write(path, bytes);

		            // 파일 정보를 데이터베이스에 저장
		            jwDao.insertAfterImg(reserveVo.getRsNo(), uniqueFileName, file.getOriginalFilename(), file.getSize(), uploadDir);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		    // 미용 기록 업데이트
		    jwDao.updateGroomingRecord(reserveVo);
		    System.out.println("미용 기록이 업데이트되었습니다.");
		}
}
