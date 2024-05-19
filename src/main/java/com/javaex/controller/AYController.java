package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.AYService;
import com.javaex.util.JsonResult;
import com.javaex.vo.DogVo;

@RestController
public class AYController {

	@Autowired
	private AYService ayService;

	// 반려견등록
	@PostMapping("/api/mypage/doginsert")
	public JsonResult petInsert(@RequestBody  DogVo dogVo) {
		System.out.println("AYController.petInsert");
		System.out.println(dogVo);

		ayService.exeInsert(dogVo);

		return JsonResult.success(dogVo);
	}
}
