package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.SUDao;
import com.javaex.vo.BusinessVo;
import com.javaex.vo.PriceVo;
import com.javaex.vo.ReserveVo;
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

		// 여기는 슬라이드 사진 추출
		List<MultipartFile> slideImgs = businessVo.getSlideImgs();
		List<String> slideImgsSaveName = new ArrayList<>();

		// 슬라이드 이미지 파일 처리 추가 부분 ///////////////////////
		for (MultipartFile slideImg : slideImgs) {
			// 오리지널 파일명
			String orgName = slideImg.getOriginalFilename();

			// 확장자
			String exName = orgName.substring(orgName.lastIndexOf("."));

			// 저장파일명(겹치지 않아야 된다)
			String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

			// 파일전체경로
			String filePath = saveDir + File.separator + saveName;

			// 파일 저장 이름 리스트에 추가
			slideImgsSaveName.add(saveName);

			// 파일 저장
			try {
				byte[] fileData = slideImg.getBytes();
				OutputStream os = new FileOutputStream(filePath);
				BufferedOutputStream bos = new BufferedOutputStream(os);
				bos.write(fileData);
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		businessVo.setSlideImgsSaveName(slideImgsSaveName);

		// 여기는 컷이미지 사진 추출
		List<MultipartFile> cutImgs = businessVo.getCutImgs();
		List<String> cutImgsSaveName = new ArrayList<>();

		// 슬라이드 이미지 파일 처리 추가 부분 ///////////////////////
		for (MultipartFile cutImg : cutImgs) {
			// 오리지널 파일명
			String orgName = cutImg.getOriginalFilename();

			// 확장자
			String exName = orgName.substring(orgName.lastIndexOf("."));

			// 저장파일명(겹치지 않아야 된다)
			String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

			// 파일전체경로
			String filePath = saveDir + File.separator + saveName;

			// 파일 저장 이름 리스트에 추가
			cutImgsSaveName.add(saveName);

			// 파일 저장
			try {
				byte[] fileData = cutImg.getBytes();
				OutputStream os = new FileOutputStream(filePath);
				BufferedOutputStream bos = new BufferedOutputStream(os);
				bos.write(fileData);
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		businessVo.setCutImgsSaveName(cutImgsSaveName);

		// 여기는 로고랑 프로필이미지 추출
		// 오리지널 파일명
		String orgName = businessVo.getLogoFile().getOriginalFilename();
		String orgName2 = businessVo.getdProfileFile().getOriginalFilename();

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));
		String exName2 = orgName2.substring(orgName2.lastIndexOf("."));

		// 저장파일명(겹치지 않아야 된다)
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		String saveName2 = System.currentTimeMillis() + UUID.randomUUID().toString() + exName2;

		// 파일사이즈
//		long fileSize = businessVo.getLogo().getSize() ;
//		System.out.println(fileSize);

		// 파일전체경로
		String filePath = saveDir + File.separator + saveName;
		String filePath2 = saveDir + File.separator + saveName2;

		// vo로묶기
		businessVo.setLogo(saveName);
		businessVo.setdProfile(saveName2);

		// (2)파일저장(서버쪽 하드디스크에 저장)///////////////////////////////////////////////////
		try {
			byte[] fileData;
			byte[] fileData2;
			
			fileData = businessVo.getLogoFile().getBytes();
			fileData2 = businessVo.getdProfileFile().getBytes();

			OutputStream os = new FileOutputStream(filePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			bos.write(fileData);
			bos.close();
			
			OutputStream os2 = new FileOutputStream(filePath2);
			BufferedOutputStream bos2 = new BufferedOutputStream(os2);

			bos2.write(fileData2);
			bos2.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// (3)DB저장 /////////////////////////////////////////////////////
		suDao.updateBusinessInfo(businessVo);
		suDao.insertDesignerInfo(businessVo);
		suDao.insertPriceInfo(businessVo);
		suDao.insertSlideImgs(businessVo);
		suDao.insertCutImgs(businessVo);

	}

	// 가게,가격 정보 불러오기
	public Map<String, Object> exeShopInfoList(int bNo) {
		System.out.println("SUService.exeShopInfoList");

		// 가게정보
		BusinessVo shopInfo = suDao.getShopInfo(bNo);

		// 가격정보
		List<PriceVo> pList = suDao.getPrice(bNo);
		
		//메인 슬라이드 이미지
		List<Map<String, Object>> slideImgsSaveNameHiNo = suDao.getSlide(bNo);
//		shopInfo.setSlideImgsSaveName(slideImgsSaveName);
		
		//컷 슬라이드 이미지
		List<Map<String, Object>> cutImgsSaveNameHiNo= suDao.getCut(bNo);
//		shopInfo.setCutImgsSaveName(cutImgsSaveName);

		// 합쳐서 가져오기
		Map<String, Object> infoPriceMap = new HashMap<String, Object>();
		infoPriceMap.put("shopInfo", shopInfo);
		infoPriceMap.put("pList", pList);
		infoPriceMap.put("sList", slideImgsSaveNameHiNo);
		infoPriceMap.put("cList", cutImgsSaveNameHiNo);

		return infoPriceMap;
	}
	
	//가게 수정
	public void exeUpdateShopInfo(BusinessVo businessVo) {
		System.out.println("SUService.exeUpdateShopInfo");
		
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

		// 여기는 슬라이드 사진 추출
		if(businessVo.getSlideImgs() != null) {
			List<MultipartFile> slideImgs = businessVo.getSlideImgs();
			List<String> slideImgsSaveName = new ArrayList<>();
	
			// 슬라이드 이미지 파일 처리 추가 부분 ///////////////////////
			for (MultipartFile slideImg : slideImgs) {
				// 오리지널 파일명
				String orgName = slideImg.getOriginalFilename();
	
				// 확장자
				String exName = orgName.substring(orgName.lastIndexOf("."));
	
				// 저장파일명(겹치지 않아야 된다)
				String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
	
				// 파일전체경로
				String filePath = saveDir + File.separator + saveName;
	
				// 파일 저장 이름 리스트에 추가
				slideImgsSaveName.add(saveName);
	
				// 파일 저장
				try {
					byte[] fileData = slideImg.getBytes();
					OutputStream os = new FileOutputStream(filePath);
					BufferedOutputStream bos = new BufferedOutputStream(os);
					bos.write(fileData);
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			businessVo.setSlideImgsSaveName(slideImgsSaveName);
			
			//추가파일o, 삭제파일o
			if(businessVo.getDelSlideHiNos() !=null) {
				System.out.println("추가파일o, 삭제파일o");
				suDao.insertSlideImgs(businessVo);
				suDao.deleteSlideImgs(businessVo);
			}else {
				//추가파일o, 삭제파일x
				System.out.println("추가파일o, 삭제파일x");
				suDao.insertSlideImgs(businessVo);
			}
			
			
		}else {
			//추가파일x, 삭제파일o
			if(businessVo.getDelSlideHiNos() !=null) {
				System.out.println("추가파일x, 삭제파일o");
				suDao.deleteSlideImgs(businessVo);
			}else {
				System.out.println("추가파일x, 삭제파일x");
				//추가파일x , 삭제파일x: 아무것도 안함
			}
		}
//		
//
//		// 여기는 컷이미지 사진 추출
		if(businessVo.getSlideImgs() != null) {
			List<MultipartFile> cutImgs = businessVo.getCutImgs();
			List<String> cutImgsSaveName = new ArrayList<>();

			// 슬라이드 이미지 파일 처리 추가 부분 ///////////////////////
			for (MultipartFile cutImg : cutImgs) {
				// 오리지널 파일명
				String orgName = cutImg.getOriginalFilename();

				// 확장자
				String exName = orgName.substring(orgName.lastIndexOf("."));

				// 저장파일명(겹치지 않아야 된다)
				String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

				// 파일전체경로
				String filePath = saveDir + File.separator + saveName;

				// 파일 저장 이름 리스트에 추가
				cutImgsSaveName.add(saveName);

				// 파일 저장
				try {
					byte[] fileData = cutImg.getBytes();
					OutputStream os = new FileOutputStream(filePath);
					BufferedOutputStream bos = new BufferedOutputStream(os);
					bos.write(fileData);
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			businessVo.setCutImgsSaveName(cutImgsSaveName);
			
			//추가파일o, 삭제파일o
			if(businessVo.getDelCutHiNos() !=null) {
				System.out.println("컷 추가파일o, 컷 삭제파일o");
				suDao.insertCutImgs(businessVo);
				suDao.deleteCutImgs(businessVo);
			}else {
				//추가파일o, 삭제파일x
				System.out.println("컷 추가파일o, 컷 삭제파일x");
				suDao.insertCutImgs(businessVo);
			}
			
			
		}else {
			//추가파일x, 삭제파일o
			if(businessVo.getDelCutHiNos() !=null) {
				System.out.println("컷 추가파일x, 컷 삭제파일o");
				suDao.deleteCutImgs(businessVo);
			}else {
				System.out.println("컷 추가파일x, 컷 삭제파일x");
				//추가파일x , 삭제파일x: 아무것도 안함
			}
			
		}
		


		// 여기는 로고이미지 추출
		if(businessVo.getLogoFile() !=null) {
			// 오리지널 파일명
			String orgName = businessVo.getLogoFile().getOriginalFilename();
			
			//확장자
			String exName = orgName.substring(orgName.lastIndexOf("."));
			
			// 저장파일명(겹치지 않아야 된다)
			String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
			
			// 파일전체경로
			String filePath = saveDir + File.separator + saveName;
			
			// vo로묶기
			businessVo.setLogo(saveName);
			
			// (2)파일저장(서버쪽 하드디스크에 저장)///////////////////////////////////////////////////
			try {
				byte[] fileData;
				
				fileData = businessVo.getLogoFile().getBytes();

				OutputStream os = new FileOutputStream(filePath);
				BufferedOutputStream bos = new BufferedOutputStream(os);
				
				bos.write(fileData);
				bos.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			// (3)DB저장 /////////////////////////////////////////////////////
			suDao.updateBusinessInfo(businessVo);
		}else {
			// (3)DB저장- 파일 안바꿨을때 /////////////////////////////////////////////////////
			suDao.updateBusinessInfoNoImg(businessVo);
		}
		
		
		
		// 여기는 프로필 이미지 추출
		if(businessVo.getdProfileFile() != null) {
			// 오리지널 파일명
			String orgName2 = businessVo.getdProfileFile().getOriginalFilename();

			// 확장자
			String exName2 = orgName2.substring(orgName2.lastIndexOf("."));

			// 저장파일명(겹치지 않아야 된다)
			String saveName2 = System.currentTimeMillis() + UUID.randomUUID().toString() + exName2;

			// 파일전체경로
			String filePath2 = saveDir + File.separator + saveName2;

			// vo로묶기
			businessVo.setdProfile(saveName2);

			// (2)파일저장(서버쪽 하드디스크에 저장)///////////////////////////////////////////////////
			try {
				byte[] fileData2;
				
				fileData2 = businessVo.getdProfileFile().getBytes();
	
				OutputStream os2 = new FileOutputStream(filePath2);
				BufferedOutputStream bos2 = new BufferedOutputStream(os2);
	
				bos2.write(fileData2);
				bos2.close();
	
			} catch (IOException e) {
				e.printStackTrace();
			}

			// (3)DB저장 /////////////////////////////////////////////////////
			suDao.updateDesignerInfo(businessVo);
		}else {
			// (3)DB저장 -파일 안바꿨을때 /////////////////////////////////////////////////////
			suDao.updateDesignerInfoNoImg(businessVo);
		}
		
//		가게 수정 - price
		for(int i= 0; i< businessVo.getPriceList().size(); i++ ) {
			int bNo = businessVo.getbNo();
			PriceVo pVo = businessVo.getPriceList().get(i);
			pVo.setbNo(bNo);
			suDao.updatePriceInfo(pVo);			
		}
		
	}

	
	//가게 운영시간 등록
	public void exeInsertRtBybNo(ReserveVo reserveVo) {
		System.out.println("SUService.exeInsertRtBybNo");
		
		//저장되어있는지 확인하기
		
		//저장이 안되어있는 날짜 가져와서 등록하기 
		//저장이 되어있는 날짜 가져와서 해당 시간은 삭제 후 등록하기
		//새로운 정보 등록
		suDao.insertRt(reserveVo);
	}
	
	//가게 운영시간 등록 여부
	public List<ReserveVo> exeGetRtBybNo(int bNo) {
		System.out.println("SUService.exeGetRtBybNo");
		
		List<ReserveVo> dList = suDao.getRt(bNo);
		
		return dList;
	}
	
	//가게 운영시간 가져오기
	public List<ReserveVo> exeGetRtimeBybNo(ReserveVo rVo) {
		System.out.println("SUService.exeGetRtimeBybNo");
		
		List<ReserveVo> timeList = suDao.getRtime(rVo);
		
		return timeList;
	}
	
	//가게 운영시간 삭제
	public void exeDeleteRt(ReserveVo reserveVo) {
		System.out.println("SUService.exeDeleteRt");
		
		suDao.deleteRt(reserveVo);
	
	}
	
	//가게 운영시간 수정
		public void exeUpdateRt(ReserveVo reserveVo) {
			System.out.println("SUService.exeUpdateRt");
			
			//날짜에 해당하는 예약시간 삭제하기
			suDao.deleteRt(reserveVo);
			
			//운영시간 등록하기
			suDao.updateRt(reserveVo);
		
		}
}