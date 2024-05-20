package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.javaex.vo.BusinessVo;

@Repository
public class YEDao {

	@Autowired
	private SqlSession sqlSession;

	public void msignup(BusinessVo businessVo) {
		System.out.println("YEDao.msignup()");
		
		sqlSession.insert("ye.bInsert", businessVo);
	}

	public int idCheck(String id) {
		System.out.println("YEDao.idCheck()");
		
		int count = sqlSession.selectOne("ye.bSelect", id);
		
		return count;
	}

	public BusinessVo mlogin(@ModelAttribute BusinessVo businessVo) {
		System.out.println("YEDao.mlogin()");
		
		BusinessVo auth = sqlSession.selectOne("ye.bSelectOne", businessVo);
		
		return auth;
	}

}
