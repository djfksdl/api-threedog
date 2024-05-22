package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.AYDao;
import com.javaex.vo.BusinessVo;
import com.javaex.vo.DogVo;
import com.javaex.vo.ReviewVo;

@Service
public class AYService {

	@Autowired
	private AYDao ayDao;

	// 반려견등록
	public String exePetInsert(DogVo dogVo) {
		System.out.println("AYService.exeInsert()");

		// 운영체제 확인
		String osName = System.getProperty("os.name").toLowerCase(); // 운영체제가 뭔지 알 수 있음.(if문으로 리눅스면 ~,윈도우면 ~)
		String saveDir;

		// 운영 체제에 따라 다른 경로 설정
		if (osName.contains("linux")) {
			System.out.println("리눅스");
			// 파일저장디렉토리
			saveDir = "/app/upload/"; // Linux 경로. username을 실제 사용자 이름으로 변경하세요.
		} else {
			System.out.println("윈도우");
			// 파일저장디렉토리
			saveDir = "C:\\javaStudy\\upload\\";
		}

		System.out.println(dogVo.getFile().getOriginalFilename());
		System.out.println(dogVo.getFile().getSize());

		// 확장자
		String exName = dogVo.getFile().getOriginalFilename()
				.substring(dogVo.getFile().getOriginalFilename().lastIndexOf("."));
		System.out.println(exName);

		// 저장파일명바꾸기
		dogVo.setDogImg(System.currentTimeMillis() + UUID.randomUUID().toString() + exName);
		System.out.println(dogVo.getDogImg());

		// 파일전체경로
		String filePath = saveDir + File.separator + dogVo.getDogImg();
		System.out.println(filePath);

		try {
			byte[] fileData;
			fileData = dogVo.getFile().getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ayDao.addPet(dogVo);

		return dogVo.getDogImg();
	}

	// 리뷰등록
	public void exeReviewInsert(ReviewVo reviewVo) {
		System.out.println("AYService.reviewInsert()");

		List<MultipartFile> files = reviewVo.getFile();
		List<String> saveNameList = new ArrayList<>();

		for (MultipartFile file : files) {

			// 오리지널 파일명
			String orgName = file.getOriginalFilename();
			System.out.println(orgName);

			// 확장자
			String exName = orgName.substring(orgName.lastIndexOf("."));
			System.out.println(exName);

			// 저장파일명(겹치지 않아야 된다)
			String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
			System.out.println(saveName);

			String saveDir;

			String osName = System.getProperty("os.name").toLowerCase();

			// 운영 체제에 따라 다른 경로 설정
			if (osName.contains("linux")) {
				System.out.println("리눅스");
				// 파일저장디렉토리
				saveDir = "/app/upload/"; // Linux 경로. username을 실제 사용자 이름으로 변경하세요.
			} else {
				System.out.println("윈도우");
				// 파일저장디렉토리
				saveDir = "C:\\javaStudy\\upload\\";
			}

			// 파일전체경로
			String filePath = saveDir + File.separator + saveNameList;
			System.out.println(filePath);

			saveNameList.add(saveName);

			// 파일저장
			try {
				byte[] fileData = file.getBytes();

				OutputStream os = new FileOutputStream(filePath);

				BufferedOutputStream bos = new BufferedOutputStream(os);
				bos.write(fileData);
				bos.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
			reviewVo.setSaveNameList(saveNameList);
			System.out.println("*****************saveNameList*****************");
			System.out.println(saveNameList);

		}
//		reviewVo.setpDate(reviewVo.getrDate());	//날짜
//		reviewVo.setRvNum(reviewVo.getrNo());//리뷰번호
		ayDao.addReview(reviewVo);
	}
	
	// 가게정보 가져오기
	public BusinessVo exeGetBList(int bNo) {
		System.out.println("AYService.exeGetBList");
		
		BusinessVo businessVo = ayDao.getBList(bNo);
		
		return businessVo;
	}

}
