package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SUDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void getList() {
		System.out.println("SUDao.getList");
		
		sqlSession.selectList("su.selectList");
		
		
	}
}
