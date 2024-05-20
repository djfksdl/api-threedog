package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.YEService;
import com.javaex.util.JsonResult;
import com.javaex.vo.BusinessVo;

@RestController
public class YEController {
	
	@Autowired
	private YEService yeService;
	
	//회원가입
	@PostMapping("/api/msignup")
	public JsonResult mSignup(@ModelAttribute BusinessVo businessVo) {
		System.out.println("YEController.mSignup()");
//		System.out.println(businessVo);
		
		yeService.exeMsignup(businessVo);

		return JsonResult.success(businessVo);
	}
	
	//아이디 중복 체크
	@GetMapping("/api/msignup/id")
	public JsonResult  idCheck(@RequestParam String id) {
		System.out.println("YEController.idCheck()");
		System.out.println(id);
		
		int count = yeService.exeIdCheck(id);
//		System.out.println(count);

		return JsonResult.success(count);
	}
	
	//로그인
	@PostMapping("/api/mlogin")
	public JsonResult mLogin(@ModelAttribute BusinessVo businessVo) {
		System.out.println("YEController.mLogin()");
		
//		System.out.println(businessVo);
		BusinessVo auth = yeService.exeMlogin(businessVo);
		
		return JsonResult.success(auth);
	}
}
