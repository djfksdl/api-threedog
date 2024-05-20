package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.SUDao;
import com.javaex.vo.UserVo;

@Service
public class SUService {

	@Autowired
	private SUDao suDao;

	//아이디 중복체크
	public int exeIdCheck(String uId) {
		System.out.println("SUService.exeIdCheck");
		
		int count = suDao.checkId(uId);
				
		return count;
	}
	
	// 회원가입
	public int exeSignUp(UserVo userVo) {
		System.out.println("SUService.exeSignUp");

		// 운영 체제 이름 확인
		String osName = System.getProperty("os.name").toLowerCase(); // 운영체제가 뭔지 알 수 있음.(if문으로 리눅스면 ~,윈도우면 ~)
		String saveDir;

		// 운영 체제에 따라 다른 경로 설정
		if (osName.contains("linux")) {
			System.out.println("리눅스");
			// 파일저장디렉토리
			saveDir = "/app/upload"; // Linux 경로. username을 실제 사용자 이름으로 변경하세요.
		} else {
			System.out.println("윈도우");
			// 파일저장디렉토리
			saveDir = "C:\\javaStudy\\upload";
		}

		// (1)파일관련 정보 추출///////////////////////////////////////////////////

		// 오리지널 파일명
		String orgName = userVo.getFile().getOriginalFilename();
//		String orgName = productVo.getFile().getOriginalFilename();
		System.out.println(orgName);

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		System.out.println(exName);

		// 저장파일명(겹치지 않아야 된다)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println(saveName);

		// 파일사이즈
		long fileSize = userVo.getFile().getSize();
		System.out.println(fileSize);

		// 파일전체경로
		String filePath = saveDir + File.separator + saveName;
		System.out.println(filePath);

		// vo로묶기
		userVo.setuProfile(saveName);

		// Dao만들기 --> DB저장 과제

		// (2)파일저장(서버쪽 하드디스크에 저장)///////////////////////////////////////////////////
		try {
			byte[] fileData;
			fileData = userVo.getFile().getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// (3)DB저장 /////////////////////////////////////////////////////
		int count = suDao.signUp(userVo);
		
		return count;

	}
//	로그인
	public UserVo exeLogIn(UserVo userVo) {
		System.out.println("SUService.exeLogIn");
		
		UserVo authUser = suDao.login(userVo);
				
		return authUser;
	}
	

}
