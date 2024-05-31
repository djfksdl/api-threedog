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

	// 특정 예약의 미용 기록 조회
	public ReserveVo selectGroomingRecord(int rsNo) {
		System.out.println("JWService.selectGroomingRecord() 메서드 실행");

		ReserveVo groomingRecord = jwDao.selectGroomingRecord(rsNo);

		return groomingRecord;
	}

	/****************************
	 * 알림장화면
	 ****************************/
	// 미용 기록 업데이트
	public void updateGroomingRecord(ReserveVo reserveVo) {
		jwDao.updateGroomingRecord(reserveVo); // DAO 호출하여 미용 기록 업데이트
		List<MultipartFile> files = reserveVo.getFiles(); // 첨부된 파일들 가져오기
		for (MultipartFile file : files) {
			uploadImage(reserveVo.getRsNo(), file); // 각 파일을 업로드
		}
	}

	// 이미지 업로드
	public String uploadImage(int rsNo, MultipartFile file) {
		String uploadDir = "/path/to/upload/directory/"; // 파일 업로드 디렉토리 경로 설정
		try {
			byte[] bytes = file.getBytes(); // 파일 바이트 데이터 가져오기
			String uniqueFileName = System.currentTimeMillis() + "_" + file.getOriginalFilename(); // 유니크 파일명 생성
			Path path = Paths.get(uploadDir + uniqueFileName); // 파일 경로 설정
			Files.write(path, bytes); // 파일 저장
			jwDao.insertAfterImg(rsNo, uniqueFileName, file.getOriginalFilename(), file.getSize(), uploadDir); // 파일 정보
																												// DB에
																												// 저장
			return uploadDir + uniqueFileName; // 저장된 파일 경로 반환
		} catch (IOException e) {
			throw new RuntimeException("File upload failed", e); // 파일 업로드 실패시 예외 발생
		}
	}
}
