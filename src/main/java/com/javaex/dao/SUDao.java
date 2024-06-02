package com.javaex.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BusinessVo;
import com.javaex.vo.PriceVo;
import com.javaex.vo.ReserveVo;
import com.javaex.vo.UserVo;

@Repository
public class SUDao {

	@Autowired
	private SqlSession sqlSession;

//	************************** user **************************
//	아이디 중복체크
	public int checkId(String uId) {
		System.out.println("SUDao.checkId");
		int count = sqlSession.selectOne("su.checkId", uId);

		return count;
	}

//	회원가입
	public int signUp(UserVo userVo) {
		System.out.println("SUDao.signUp");

		int count = sqlSession.insert("su.insertUser", userVo);

		return count;
	}

//	로그인
	public UserVo login(UserVo userVo) {
		System.out.println("SUDao.login");

		UserVo authUser = sqlSession.selectOne("su.login", userVo);

		return authUser;
	}

//	************************** editPage **************************

	// ========================= 등록 =========================
	// 가게 등록,수정 -business
	public void updateBusinessInfo(BusinessVo businessVo) {
		System.out.println("SUDao.updateBusinessInfo");

		sqlSession.update("su.updateBusinessInfo", businessVo);

	}

	// 가게 등록 -designer
	public void insertDesignerInfo(BusinessVo businessVo) {
		System.out.println("SUDao.insertDesignerInfo");

		sqlSession.insert("su.insertDesignerInfo", businessVo);

	}

	// 가게 등록 -price
	public void insertPriceInfo(BusinessVo businessVo) {
		System.out.println("SUDao.insertPriceInfo");

		List<PriceVo> priceList = businessVo.getPriceList();

		// BusinessVo에서 bNo를 가져와서 PriceVo의 bNo 필드에 설정
		int bNo = businessVo.getbNo();
		for (PriceVo priceVo : priceList) {
			priceVo.setbNo(bNo);
		}

		sqlSession.insert("su.insertPriceInfo", priceList);

	}

	// 가게 등록 -슬라이드 이미지
	public void insertSlideImgs(BusinessVo businessVo) {
		System.out.println("SUDao.insertSlideImgs");

		List<String> sImgSaveNameList = businessVo.getSlideImgsSaveName();

		// BusinessVo에서 bNo를 가져와서 PriceVo의 bNo 필드에 설정
		int bNo = businessVo.getbNo();

		Map<String, Object> slideImgsMap = new HashMap<>();
		slideImgsMap.put("bNo", bNo);
		slideImgsMap.put("slideImgsSaveName", sImgSaveNameList);

		sqlSession.insert("su.insertSlideImgs", slideImgsMap);

	}

	// 가게 등록 -컷 이미지
	public void insertCutImgs(BusinessVo businessVo) {
		System.out.println("SUDao.insertCutImgs");

		List<String> cImgSaveNameList = businessVo.getCutImgsSaveName();

		// BusinessVo에서 bNo를 가져와서 PriceVo의 bNo 필드에 설정
		int bNo = businessVo.getbNo();

		Map<String, Object> cutImgsMap = new HashMap<>();
		cutImgsMap.put("bNo", bNo);
		cutImgsMap.put("cutImgsSaveName", cImgSaveNameList);

		sqlSession.insert("su.insertCutImgs", cutImgsMap);

	}

	// ========================= 불러오기 =========================
	// 가게정보 불러오기
	public BusinessVo getShopInfo(int bNo) {
		System.out.println("SUDao.getShopInfo");

		BusinessVo shopInfo = sqlSession.selectOne("su.getShopInfo", bNo);

		System.out.println(shopInfo);

		return shopInfo;
	}

	// 가격정보 불러오기
	public List<PriceVo> getPrice(int bNo) {
		System.out.println("SUDao.getPrice");

		List<PriceVo> pList = sqlSession.selectList("su.getPrice", bNo);

		return pList;
	}

	// 메인 슬라이드 이미지 불러오기
	public List<Map<String, Object>> getSlide(int bNo) {
		System.out.println("SUDao.getSlide");

		List<BusinessVo> sList = sqlSession.selectList("su.getSlide", bNo);

		// 결과를 단일 BusinessVo 객체의 slideImgsSaveName 리스트로 결합 why?: slideImgsSaveName는
		// List형태라서 결과가 여러 BusinessVo객체로 분리되어 반환됨.그래서 단일 객체로 결합되도록 해야함.
		List<Map<String, Object>> result = new ArrayList<>();
		for (BusinessVo vo : sList) {
			List<String> slideImgsSaveName = vo.getSlideImgsSaveName();
			List<Integer> hiNos = vo.getHiNos();

			for (int i = 0; i < slideImgsSaveName.size(); i++) {
				Map<String, Object> map = new HashMap<>();
				map.put("hiNo", hiNos.get(i));
				map.put("saveName", slideImgsSaveName.get(i));
				result.add(map);
			}
		}

		System.out.println("슬라이드 이미지덜:"+result);

		return result;

	}

	// 컷 슬라이드 이미지 불러오기
	public List<Map<String, Object>> getCut(int bNo) {
		System.out.println("SUDao.getCut");
		
		List<BusinessVo> cList = sqlSession.selectList("su.getCut", bNo);

		List<Map<String, Object>> result = new ArrayList<>();
		for (BusinessVo vo : cList) {
			List<String> cutImgsSaveName = vo.getCutImgsSaveName();
			List<Integer> hiNos = vo.getHiNos();

			for (int i = 0; i < cutImgsSaveName.size(); i++) {
				Map<String, Object> map = new HashMap<>();
				map.put("hiNo", hiNos.get(i));
				map.put("saveName", cutImgsSaveName.get(i));
				result.add(map);
			}
		}

		System.out.println("컷 이미지덜:" + result);

		return result;

	}

	// ========================= 수정 =========================
	// 가게 수정(파일 안바꿨을때) -business
	public void updateBusinessInfoNoImg(BusinessVo businessVo) {
		System.out.println("SUDao.updateBusinessInfoNoImg");

//			System.out.println(businessVo);
		sqlSession.update("su.updateBusinessInfoNoImg", businessVo);

	}

	// 가게 수정 -designer
	public void updateDesignerInfo(BusinessVo businessVo) {
		System.out.println("SUDao.updateDesignerInfo");

		sqlSession.update("su.updateDesignerInfo", businessVo);

	}

	// 가게 수정(파일 안바꿨을때) -designer
	public void updateDesignerInfoNoImg(BusinessVo businessVo) {
		System.out.println("SUDao.updateDesignerInfoNoImg");

		sqlSession.update("su.updateDesignerInfoNoImg", businessVo);

	}

	// 가게 수정 -price
	public void updatePriceInfo(PriceVo priceVo) {
		System.out.println("SUDao.updatePriceInfo");

		
		
		System.out.println("디비에 집어 넣기 전" + priceVo.getBeautyNo() );
		sqlSession.update("su.updatePriceInfo", priceVo);

	}

	// 가게 수정(삭제파일) -슬라이드 이미지
	public void deleteSlideImgs(BusinessVo businessVo) {
		System.out.println("SUDao.deleteSlideImgs");

		List<Integer> delSlideHiNosList = businessVo.getDelSlideHiNos() ;


		System.out.println("슬라이드 삭제:" + delSlideHiNosList);
		// 기존에 있던 슬라이드(category=1)이미지 삭제
		sqlSession.delete("su.deleteSlideImgs", delSlideHiNosList);
		System.out.println("슬라이드 삭제:" + businessVo.getSlideImgsSaveName() );

	}

	// 가게 수정(삭제파일) -컷 이미지
	public void deleteCutImgs(BusinessVo businessVo) {
		System.out.println("SUDao.deleteCutImgs");

		List<Integer> delDelCutHiNosList = businessVo.getDelCutHiNos();

		// 기존에 있던 컷(category=2)이미지 삭제하고나서 insert하기
		sqlSession.delete("su.deleteCutImgs", delDelCutHiNosList);

	}
	
	
//	************************** insertTime **************************
	//가게 운영시간 등록
	public void insertRt(ReserveVo reserveVo) {
		System.out.println("SUDao.insertRt");

		int bNo = reserveVo.getbNo();
		
		List<String> rtDates = reserveVo.getRtDates();
	    List<String> rtTimes = reserveVo.getRtTimes();
	    
	 // rtDates와 rtTimes의 각 값을 매칭하여 데이터베이스에 삽입합니다.
	    for (int i = 0; i < rtDates.size(); i++) {
	        String rtDate = rtDates.get(i);
	        String startTime = rtTimes.get(i);

	        Map<String, Object> paramMap = new HashMap<>();
	        paramMap.put("bNo", bNo);
	        paramMap.put("rtDate", rtDate);
	        paramMap.put("rtTime", startTime);

	        sqlSession.insert("su.insertRtBybNo", paramMap);
	    }

	}
	
	//가게 운영시간 등록 여부
	public List<ReserveVo> getRt(int bNo) {
		System.out.println("SUDao.getRt");

		List<ReserveVo> dList = sqlSession.selectList("su.selectRtBybNo", bNo);
		
		return dList;

	}
	
	//가게 운영시간 가져오기
	public List<ReserveVo> getRtime(ReserveVo rVo) {
		System.out.println("SUDao.getRtime");

		List<ReserveVo> timeList = sqlSession.selectList("su.selectRtimeBybNo", rVo);
		
		return timeList;

	}
	
	//가게 운영시간 삭제
	public void deleteRt(ReserveVo reserveVo) {
		System.out.println("SUDao.deleteRt");

		sqlSession.delete("su.deleteRt", reserveVo);

	}
	
	//가게 운영시간 수정(1개 등록)
	public void updateRt(ReserveVo reserveVo) {
		System.out.println("SUDao.updateRt");

		int bNo = reserveVo.getbNo();
		String rtDate = reserveVo.getRtDate();
		
	    List<String> rtTimes = reserveVo.getRtTimes();
	    
	 // rtTimes의 각 값을 반복하여 데이터베이스에 삽입합니다.
	    for (String startTime : rtTimes) {
	        Map<String, Object> paramMap = new HashMap<>();
	        paramMap.put("bNo", bNo);
	        paramMap.put("rtDate", rtDate);
	        paramMap.put("rtTime", startTime);

	        sqlSession.insert("su.insertRtBybNo", paramMap);
	    }

	}


}