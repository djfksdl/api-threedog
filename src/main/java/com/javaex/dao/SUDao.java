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
	public List<String> getSlide(int bNo) {
		System.out.println("SUDao.getSlide");

		List<BusinessVo> sList = sqlSession.selectList("su.getSlide", bNo);

		// 결과를 단일 BusinessVo 객체의 slideImgsSaveName 리스트로 결합 why?: slideImgsSaveName는
		// List형태라서 결과가 여러 BusinessVo객체로 분리되어 반환됨.그래서 단일 객체로 결합되도록 해야함.
		List<String> slideImgsSaveName = new ArrayList<>();
		for (BusinessVo vo : sList) {
			slideImgsSaveName.addAll(vo.getSlideImgsSaveName());
		}

//		System.out.println("슬라이드 이미지덜:"+slideImgsSaveName);

		return slideImgsSaveName;

	}

	// 컷 슬라이드 이미지 불러오기
	public List<String> getCut(int bNo) {
		System.out.println("SUDao.getCut");

		List<BusinessVo> cList = sqlSession.selectList("su.getCut", bNo);

		// 결과를 단일 BusinessVo 객체의 cutImgsSaveName 리스트로 결합
		List<String> cutImgsSaveName = new ArrayList<>();
		for (BusinessVo vo : cList) {
			cutImgsSaveName.addAll(vo.getCutImgsSaveName());
		}

		System.out.println("컷 이미지덜:" + cutImgsSaveName);

		return cutImgsSaveName;

	}

	// ========================= 수정 =========================
	// 가게 수정 -designer
	public void updateDesignerInfo(BusinessVo businessVo) {
		System.out.println("SUDao.updateDesignerInfo");

		sqlSession.update("su.updateDesignerInfo", businessVo);

	}

	// 가게 수정 -price
	public void updatePriceInfo(BusinessVo businessVo) {
		System.out.println("SUDao.updatePriceInfo");

		List<PriceVo> priceList = businessVo.getPriceList();

		// BusinessVo에서 bNo를 가져와서 PriceVo의 bNo 필드에 설정
		int bNo = businessVo.getbNo();
		for (PriceVo priceVo : priceList) {
			priceVo.setbNo(bNo);
		}

		System.out.println("디비에 집어 넣기 전"+priceList);
		sqlSession.update("su.updatePriceInfo", priceList);
		

	}

	// 가게 수정 -슬라이드 이미지
	public void updateSlideImgs(BusinessVo businessVo) {
		System.out.println("SUDao.updateSlideImgs");

		List<String> sImgSaveNameList = businessVo.getSlideImgsSaveName();

		// BusinessVo에서 bNo를 가져와서 PriceVo의 bNo 필드에 설정
		int bNo = businessVo.getbNo();

		Map<String, Object> slideImgsMap = new HashMap<>();
		slideImgsMap.put("bNo", bNo);
		slideImgsMap.put("slideImgsSaveName", sImgSaveNameList);

		//기존에 있던 슬라이드(category=1)이미지 삭제하고나서 insert하기
		sqlSession.delete("su.deleteSlideImgs", bNo);
		sqlSession.insert("su.insertSlideImgs", slideImgsMap);

	}

	// 가게 수정 -컷 이미지
	public void updateCutImgs(BusinessVo businessVo) {
		System.out.println("SUDao.updateCutImgs");

		List<String> cImgSaveNameList = businessVo.getCutImgsSaveName();

		// BusinessVo에서 bNo를 가져와서 PriceVo의 bNo 필드에 설정
		int bNo = businessVo.getbNo();

		Map<String, Object> cutImgsMap = new HashMap<>();
		cutImgsMap.put("bNo", bNo);
		cutImgsMap.put("cutImgsSaveName", cImgSaveNameList);

		//기존에 있던 컷(category=2)이미지 삭제하고나서 insert하기
		sqlSession.delete("su.deleteCutImgs", bNo);
		sqlSession.insert("su.insertCutImgs", cutImgsMap);

	}

}