package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
}
