package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.DogVo;

@Repository
public class AYDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int addPet(DogVo dogVo) {
		System.out.println("AYDao.addPet()");
		
		int count=sqlSession.insert("ay.petInsert");
		
		return count;
	}
	
}
