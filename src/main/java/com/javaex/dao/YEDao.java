package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.javaex.vo.BusinessVo;
import com.javaex.vo.ReviewListVo;

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

	public List<ReviewListVo> searchList() {
		System.out.println("YEDao.searchList()");
		
		List<ReviewListVo> reviewList = sqlSession.selectList("ye.searchlist");
		
		return reviewList;
	}

}
