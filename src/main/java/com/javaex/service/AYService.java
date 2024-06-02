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
import com.javaex.vo.PriceVo;
import com.javaex.vo.ReserveVo;
import com.javaex.vo.ReviewVo;
import com.javaex.vo.UserVo;

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
		ayDao.addReview(reviewVo);

	}

	// 리뷰리스트 가져오기
	public List<ReviewVo> exeGetRList(int bNo) {
		System.out.println("AYService.exeGetRList");

		List<ReviewVo> reviewVo = ayDao.getRList(bNo);

		return reviewVo;
	}

	// 조회수 증가
	public void exeUpdateView(int rNo) {
		System.out.println("AYService.exeUpdateView");

		ayDao.updateView(rNo);

	}

	// 리뷰1개 가져오기
	public ReviewVo exeGetOnerList(int rNo) {
		System.out.println("AYService.exeGetOnerList");

		ReviewVo reviewVo = ayDao.getOnerList(rNo);

		return reviewVo;
	}

	public List<ReviewVo> exegetrSaveNameList(int rNo) {
		System.out.println("AYService.exegetrSaveNameList");

		List<ReviewVo> reviewVo = ayDao.getrSaveNameList(rNo);

		return reviewVo;
	}

	// 가게정보 가져오기
	public BusinessVo exeGetBList(int bNo) {
		System.out.println("AYService.exeGetBList");

		BusinessVo businessVo = ayDao.getBList(bNo);

		return businessVo;
	}

	// 반려견 불러오기
	public List<ReserveVo> exeGetPetList(int uNo) {
		System.out.println("AYService.exeGetPetList");

		List<ReserveVo> reserveVo = ayDao.getPetList(uNo);

		return reserveVo;
	}

	// 반려견 정보1개 가져오기
	public DogVo exeGetPetInfor(int dogNo) {
		System.out.println("AYService.exeGetPetInfor");

		DogVo dogVo = ayDao.getPetInfor(dogNo);

		return dogVo;
	}

	// 미용목록 가져오기
	public List<PriceVo> exeGetPrice(PriceVo priceVo) {
		System.out.println("AYService.exeGetPrice");

		List<PriceVo> priceList = ayDao.getPriceList(priceVo);

		return priceList;
	}

	// 추가요금 가져오기
	public List<PriceVo> exeGetPlusPrice(int bNo) {
		System.out.println("AYService.getPlusPrice");

		List<PriceVo> priceList = ayDao.getPlusPrice(bNo);

		return priceList;
	}

	// 유저포인트 가져오기
	public UserVo exeGetPoint(int uNo) {
		System.out.println("AYService.exeGetPoint");

		UserVo userVo = ayDao.getPoint(uNo);

		return userVo;
	}

	// 시간 가져오기
	public List<ReserveVo> exeGetTimeList(ReserveVo reserveVo) {
		System.out.println("AYService.exeGetPoint");

		List<ReserveVo> reserveList = ayDao.getTimeList(reserveVo);

		return reserveList;
	}

	// 예약하기
	public String exeReserveInsert(ReserveVo reserveVo) {
		System.out.println("AYService.exeReserveInsert");

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

		// 확장자
		String exName = reserveVo.getSignFile().getOriginalFilename()
				.substring(reserveVo.getSignFile().getOriginalFilename().lastIndexOf("."));
		System.out.println(exName);

		// 저장파일명바꾸기
		reserveVo.setSignImg(System.currentTimeMillis() + UUID.randomUUID().toString() + exName);
		System.out.println(reserveVo.getSignImg());

		// 파일전체경로
		String filePath = saveDir + File.separator + reserveVo.getSignImg();
		System.out.println(filePath);

		try {
			byte[] fileData;
			fileData = reserveVo.getSignFile().getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("전자서명 저장이름!!!!!!!!!!!!!!");
		System.out.println(reserveVo.getSignImg());

		ayDao.reserveInsert(reserveVo); // 예약테이블
		ayDao.reserveTime(reserveVo); // 예약시간테이블
		ayDao.reserveDog(reserveVo); // 반려견테이블
		ayDao.reservePoint(reserveVo); // 포인트테이블
		ayDao.reservePrice(reserveVo);
		ayDao.userPoint(reserveVo);

		return reserveVo.getSignImg();
	}

	// 사이드바
	public UserVo exeGetSidebar(int uNo) {
		System.out.println("AYService.exeGetSidebar");

		UserVo userVo = ayDao.getSidebar(uNo);

		return userVo;
	}

	// 사이드바
	public List<DogVo> exeGetSidebar2(int uNo) {
		System.out.println("AYService.exeGetSidebar");

		List<DogVo> dogVo = ayDao.getSidebar2(uNo);

		return dogVo;
	}

}