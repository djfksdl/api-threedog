package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.SUDao;
import com.javaex.vo.BusinessVo;
import com.javaex.vo.PriceVo;
import com.javaex.vo.UserVo;

@Service
public class SUService {

	@Autowired
	private SUDao suDao;

	// 아이디 중복체크
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

		// 파일이 null일때 디폴트 이미지를 저장경로에 미리 저장해놓고 saveName만 db에 저장하니까 그걸 넣어줌.
		if (userVo.getFile() == null) {
			String saveName = "default_profile.jpg";
			userVo.setuProfile(saveName);

			// 파일이 null이 아닐때
		} else {
			// (1)파일관련 정보 추출///////////////////////////////////////////////////

			// 오리지널 파일명
			String orgName = userVo.getFile().getOriginalFilename();
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

//	editPage ==============================

	// 가게 등록
	public void exeShopInfoList(BusinessVo businessVo) {
		System.out.println("SUService.exeShopInfoList");

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
		String orgName = businessVo.getLogo().getOriginalFilename();
		String orgName2 = businessVo.getdProfile().getOriginalFilename();
//		System.out.println(orgName);

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		String exName2 = orgName2.substring(orgName2.lastIndexOf("."));
//		System.out.println(exName);

		// 저장파일명(겹치지 않아야 된다)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		String saveName2 = System.currentTimeMillis() + UUID.randomUUID().toString() + exName2;
//		System.out.println(saveName);

		// 파일사이즈
//		long fileSize = businessVo.getLogo().getSize() ;
//		System.out.println(fileSize);

		// 파일전체경로
		String filePath = saveDir + File.separator + saveName;
		String filePath2 = saveDir + File.separator + saveName2;
//		System.out.println(filePath);

		// vo로묶기
		businessVo.setLogoSaveName(saveName);
		businessVo.setdProfileSaveName(saveName2);

		// (2)파일저장(서버쪽 하드디스크에 저장)///////////////////////////////////////////////////
		try {
			byte[] fileData;
			fileData = businessVo.getLogo().getBytes();
			fileData = businessVo.getdProfile().getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			bos.write(fileData);
			bos.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// (3)DB저장 /////////////////////////////////////////////////////
		suDao.insertBusinessInfo(businessVo);
		suDao.insertDesignerInfo(businessVo);
		suDao.insertPriceInfo(businessVo );

	}

	// 가격 불러오기
	public List<PriceVo> exePriceBybNo(int bNo) {
		System.out.println("SUService.exePriceBybNo");

		// 가격정보 불러오기
		List<PriceVo> pList = suDao.getPrice(bNo);

//		Map<String, Object> priceInvetoryMap = new HashMap<String,Object>();
//		priceInvetoryMap.put("pList", pList);
//		priceInvetoryMap.put("inventoryList", inventoryList);

		return pList;
	}

	// 가게정보 불러오기
	public BusinessVo exeShopInfoList(int bNo) {
		System.out.println("SUService.exeShopInfoList");

		BusinessVo shopInfo = suDao.getShopInfo(bNo);

		return shopInfo;
	}

}
