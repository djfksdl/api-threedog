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
	//초기가격 불러오기
	public List<PriceVo> getPrice(int bNo) {
		System.out.println("SUDao.getPrice");
		
		List<PriceVo> pList = sqlSession.selectList("su.getPrice",bNo);
//		System.out.println("가기전에 확인하기");
//		System.out.println(pList);
		
		return pList;
	}
	
	//가게정보 불러오기
	public BusinessVo getShopInfo(int bNo){
		System.out.println("SUDao.getShopInfo");
		
		BusinessVo shopInfo = sqlSession.selectOne("su.getShopInfo",bNo);
		
		return shopInfo;
	}
	
}
