package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.DogVo;

@Repository
public class AYDao {

	@Autowired
	private SqlSession sqlSession;

	// 반려견등록
	public String addPet(DogVo dogVo) {
		System.out.println("AYDao.addPet()");
		System.out.println("*******전*********");
		System.out.println(dogVo);

		sqlSession.insert("ay.petInsert", dogVo);
		System.out.println("*******후*********");
		System.out.println(dogVo);

		return dogVo.getDogImg();
	}

}
