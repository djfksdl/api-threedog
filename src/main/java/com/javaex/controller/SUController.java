package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.SUService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.BusinessVo;
import com.javaex.vo.PriceVo;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class SUController {
	
	@Autowired
	private SUService suService;
	
	//아이디 중복체크
	@PostMapping("/api/su/idcheck")
	public JsonResult idcheck(@RequestParam String uId) {
		System.out.println("SUController.list");
		
		System.out.println(uId);
		
		int count = suService.exeIdCheck(uId);
		
		return JsonResult.success(count);
	}
	
	//회원가입
	@PostMapping("/api/su/signup")
	public JsonResult signup(@ModelAttribute UserVo userVo) {
		System.out.println("SUController.signup");
		
		System.out.println(userVo);
		
		int count = suService.exeSignUp(userVo);
		
		return JsonResult.success(count);
	}
	
	//로그인
	@PostMapping("/api/su/login")
	public JsonResult login(@RequestBody UserVo userVo, HttpServletResponse response) {
		System.out.println("SUController.login");
		
//		System.out.println(userVo);
		
		UserVo authUser = suService.exeLogIn(userVo);
		System.out.println(authUser);
		
		if(authUser != null) {
			JwtUtil.createTokenAndSetHeader(response, "" + authUser.getuNo() );
			return JsonResult.success(authUser);
		}else {
			return JsonResult.fail("로그인실패");
		}
		
	}
	
	//editPage================================
	
	//초기가격 불러오기
	@GetMapping("/api/su/firstprice")
	public JsonResult firstPrice() {
		System.out.println("SUController.firstPrice");
		
		List<PriceVo> pList = suService.exeFirstPrice();
		
		
		return JsonResult.success(pList);
	}
	
	//가게정보 불러오기
	@GetMapping("/api/su/shopInfo")
	public JsonResult shopInfo() {
		System.out.println("SUController.shopInfo");
		
		BusinessVo shopInfo = suService.exeShopInfo();
		
		
		return JsonResult.success(shopInfo);
	}
	
	
}
