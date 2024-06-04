package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.JWDao;
import com.javaex.vo.DogVo;
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

	// 첫 번째 메서드: rsPrice와 reserve 테이블에서 예약 정보 삭제
	public void deleteReserve(int rsNo) {
	    jwDao.deleteReserve(rsNo);
	    jwDao.deleteReserve2(rsNo);
	    System.out.println("예약 정보 삭제 완료: " + rsNo);
	}

	// 두 번째 메서드: 예약 시간의 rtFinish 값을 0으로 업데이트
	public void updateReserveTimeFinish(int rtNo) {
	    jwDao.updateReserveTimeFinish(rtNo);
	    System.out.println("예약 시간 정보 업데이트 완료: " + rtNo);
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

	// 이미지 업로드 메서드
	public String uploadImage(int rsNo, MultipartFile file) {
		String saveDir = getSaveDirectory(); // 파일 저장 디렉토리 경로 설정
		try {
			byte[] bytes = file.getBytes(); // 파일 바이트 데이터 가져오기
			String uniqueFileName = System.currentTimeMillis() + "_" + file.getOriginalFilename(); // 유니크 파일명 생성
			String fileUrl = saveDir + File.separator + uniqueFileName; // 파일 URL 생성
			saveFile(saveDir, uniqueFileName, bytes); // 파일 저장
			jwDao.insertAfterImg(rsNo, uniqueFileName); // 파일 정보 DB에 저장
			System.out.println("파일이 업로드되었습니다. URL: " + fileUrl); // 콘솔 출력 추가
			return fileUrl; // 저장된 파일 경로 반환
		} catch (IOException e) {
			throw new RuntimeException("File upload failed", e); // 파일 업로드 실패시 예외 발생
		}
	}

	// 파일을 저장하는 메서드
	private void saveFile(String saveDir, String fileName, byte[] bytes) throws IOException {
		File directory = new File(saveDir); // 디렉토리 생성
		if (!directory.exists()) {
			directory.mkdirs(); // 디렉토리가 존재하지 않으면 생성
		}
		try (OutputStream os = new FileOutputStream(new File(directory, fileName))) {
			os.write(bytes); // 파일 저장
		}
	}

	// 파일 저장 디렉토리 경로를 반환하는 메서드
	private String getSaveDirectory() {
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.contains("linux")) {
			return "/app/upload/"; // 리눅스 경로 설정
		} else {
			return "C:\\javaStudy\\upload\\"; // 윈도우즈 경로 설정
		}
	}
}