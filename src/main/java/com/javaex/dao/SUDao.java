package com.javaex.dao;

import java.util.List;

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
	
	// 가게 등록
	public void insertShopInfo(BusinessVo businessVo) {
		System.out.println("SUDao.insertShopInfo");
		
//		여기서부터 하기
//		sqlSession.insert("su.insertShopInfo",businessVo);

		
//		return pList;
	}
	
	//가격정보 불러오기
	public List<PriceVo> getPrice(int bNo) {
		System.out.println("SUDao.getPrice");
		
		List<PriceVo> pList = sqlSession.selectList("su.getPrice",bNo);

		
		return pList;
	}

	//가게정보 불러오기
	public BusinessVo getShopInfo(int bNo){
		System.out.println("SUDao.getShopInfo");
		
		BusinessVo shopInfo = sqlSession.selectOne("su.getShopInfo",bNo);
		
		System.out.println(shopInfo);
		
		return shopInfo;
	}
	

	
}
