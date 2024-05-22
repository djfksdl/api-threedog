package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.AYService;
import com.javaex.util.JsonResult;
import com.javaex.vo.BusinessVo;
import com.javaex.vo.DogVo;
import com.javaex.vo.ReviewVo;

@RestController
public class AYController {

	@Autowired
	private AYService ayService;

	// 반려견등록
	@PostMapping("/api/mypage/doginsert")
	public JsonResult petInsert(@ModelAttribute DogVo dogVo) {
		System.out.println("AYController.petInsert");
		System.out.println(dogVo.getuNo());
		System.out.println(dogVo);

		ayService.exePetInsert(dogVo);

		return JsonResult.success(dogVo.getDogImg());
	}

	// 리뷰등록
	@PostMapping("/api/mypage/reviewinsert")
	public JsonResult reviewInsert(@ModelAttribute ReviewVo reviewVo) {
		System.out.println("AYController.reviewInsert");
		System.out.println(reviewVo);
//		System.out.println(reviewVo.getImgCount());
		
		ayService.exeReviewInsert(reviewVo);
		
		return JsonResult.success("성공");
	}
	
	@GetMapping("/api/mypage/getbList")
	public JsonResult getBList(@RequestParam (value="bNo") int bNo) {
		System.out.println("AYController.getBList");
		
		System.out.println(bNo);
		BusinessVo businessVo = ayService.exeGetBList(bNo);
		
		return JsonResult.success(businessVo);
	}
	
	
}
