package com.javaex.dao;

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
	
	
//	아이디 중복체크
	public int checkId(String uId) {
		System.out.println("SUDao.checkId");
		int count = sqlSession.selectOne("su.checkId",uId);
		
//		System.out.println("요기봐야함:"+count);
		return count;
	}
//	회원가입
	public int signUp(UserVo userVo) {
		System.out.println("SUDao.signUp");
		
		int count = sqlSession.insert("su.insertUser",userVo);
		
		return count;
	}
//	로그인
	public UserVo login(UserVo userVo) {
		System.out.println("SUDao.login");
		
		UserVo authUser = sqlSession.selectOne("su.login",userVo);
		
		return authUser;
	}
//	editPage==================
	
	// 가게 등록 -business
	public void insertBusinessInfo(BusinessVo businessVo) {
		System.out.println("SUDao.insertBusinessInfo");
		
		sqlSession.update("su.updateBusinessInfo",businessVo);
	
	}
	// 가게 등록 -designer
	public void insertDesignerInfo(BusinessVo businessVo) {
		System.out.println("SUDao.insertDesignerInfo");
		
		sqlSession.insert("su.insertDesignerInfo",businessVo);
		
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
		
		sqlSession.insert("su.insertPriceInfo",priceList);
		
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
		
		sqlSession.insert("su.insertSlideImgs",slideImgsMap);
		
	}
	// 가게 등록 -컷 이미지
		public void insertCutImgs(BusinessVo businessVo) {
			System.out.println("SUDao.insertCutImgs");
		
			List<String> cImgSaveNameList = businessVo.getCutImgsSaveName() ;

			// BusinessVo에서 bNo를 가져와서 PriceVo의 bNo 필드에 설정
		    int bNo = businessVo.getbNo();
		    
		    Map<String, Object> cutImgsMap = new HashMap<>();
		    cutImgsMap.put("bNo", bNo);
		    cutImgsMap.put("cutImgsSaveName", cImgSaveNameList);
			
			sqlSession.insert("su.insertCutImgs",cutImgsMap);
			
		}
	
	//가게정보 불러오기
	public BusinessVo getShopInfo(int bNo){
		System.out.println("SUDao.getShopInfo");
		
		BusinessVo shopInfo = sqlSession.selectOne("su.getShopInfo",bNo);
		
		System.out.println(shopInfo);
		
		return shopInfo;
	}
	
	//가격정보 불러오기
	public List<PriceVo> getPrice(int bNo) {
		System.out.println("SUDao.getPrice");
		
		List<PriceVo> pList = sqlSession.selectList("su.getPrice",bNo);

		
		return pList;
	}


	

	
}
