package com.javaex.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.DogVo;
import com.javaex.vo.ReviewVo;

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

	// 리뷰등록
	public void addReview(ReviewVo reviewVo) {
		System.out.println("AYDao.addReview()");

		// 리뷰 정보를 먼저 등록
		sqlSession.insert("ay.addReview01", reviewVo);
		sqlSession.update("ay.updatePoint", reviewVo);
		// 등록된 리뷰의 rNo를 가져옴
		int rNo = reviewVo.getrNo();

		// 리뷰 이미지 정보를 등록
		for (String saveName : reviewVo.getSaveNameList()) {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("rNo", rNo);
			paramMap.put("saveName", saveName);
			System.out.println(saveName);
//			paramMap.put("orgName", reviewVo.getOrgName());
//			paramMap.put("filePath", reviewVo.getFilePath());

			sqlSession.insert("ay.addReview02", paramMap);
		}

		System.out.println("성공");
	}

}
