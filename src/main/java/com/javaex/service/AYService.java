package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.AYDao;
import com.javaex.vo.DogVo;

@Service
public class AYService {

	@Autowired
	private AYDao ayDao;

	// 반려견등록
	public int exeInsert(DogVo dogVo) {
		System.out.println("AYService.exeInsert()");
		int count = ayDao.addPet(dogVo);

		return count;
	}

}
