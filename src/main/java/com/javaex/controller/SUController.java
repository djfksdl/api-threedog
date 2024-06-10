package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.SUService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.BusinessVo;
import com.javaex.vo.ReserveVo;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class SUController {

	@Autowired
	private SUService suService;

	// 아이디 중복체크
	@PostMapping("/api/su/idcheck")
	public JsonResult idcheck(@RequestParam(value = "uId") String uId) {
		System.out.println("SUController.list");

		System.out.println(uId);

		int count = suService.exeIdCheck(uId);

		return JsonResult.success(count);
	}

	// 회원가입
	@PostMapping("/api/su/signup")
	public JsonResult signup(@ModelAttribute UserVo userVo) {
		System.out.println("SUController.signup");

		System.out.println(userVo);

		int count = suService.exeSignUp(userVo);

		return JsonResult.success(count);
	}

	// 로그인
	@PostMapping("/api/su/login")
	public JsonResult login(@RequestBody UserVo userVo, HttpServletResponse response) {
		System.out.println("SUController.login");

//		System.out.println(userVo);

		UserVo authUser = suService.exeLogIn(userVo);
		System.out.println(authUser);

		if (authUser != null) {
			JwtUtil.createTokenAndSetHeader(response, "" + authUser.getuNo());
			return JsonResult.success(authUser);
		} else {
			return JsonResult.fail("로그인실패");
		}

	}
	
	// 카카오톡 로그인 회원가입 체크
	@PostMapping("/api/su/kakao")
	public JsonResult kakaoCheck(@RequestBody UserVo userVo , HttpServletResponse response ) {
		System.out.println("SUController.kakaoCheck");
		
		System.out.println(userVo);
		
		UserVo authKakao = suService.exeKakaoLogin(userVo);
		
		if(authKakao != null) {
			JwtUtil.createTokenAndSetHeader(response, ""+authKakao.getuNo() );
			return JsonResult.success(authKakao);
		} else {
			return null;
		}
		
	}

	// editPage================================

	// 가게 등록
	@PostMapping("/api/su/registerShop")
	public JsonResult registerPrice(@ModelAttribute BusinessVo businessVo) {
		System.out.println("SUController.registerPrice");

		System.out.println("등록전"+businessVo);
//		System.out.println("슬라이드 이미지:" + businessVo.getSlideImgs());
//		System.out.println("컷이미지:" + businessVo.getCutImgs());

		suService.exeShopInfoList(businessVo);
		System.out.println("등록후"+businessVo);

		return JsonResult.success("얏호");
	}

	// 가게,가격 정보 불러오기
	@GetMapping("/api/su/shopInfo")
	public JsonResult shopInfoList(@RequestParam(value = "bNo") int bNo) {
		System.out.println("SUController.shopInfoList");

		Map<String, Object> infoPriceMap = suService.exeShopInfoList(bNo);
		System.out.println("나와라" + infoPriceMap.get("shopInfo") );

		return JsonResult.success(infoPriceMap);
	}
	
	// 가게 수정
	@PutMapping("/api/su/updateShop")
	public JsonResult updateShop(@ModelAttribute BusinessVo businessVo) {
		System.out.println("SUController.updateShop");

//		System.out.println("수정전 슬라이드 삭제번호"+ businessVo.getDelSlideHiNos() );
//		System.out.println("수정전 슬라이드 이름"+businessVo.getSlideImgs() );
//		System.out.println("수정전 컷 삭제번호"+ businessVo.getDelCutHiNos() );
//		System.out.println("수정전 컷 이름"+businessVo.getCutImgs() );

		suService.exeUpdateShopInfo(businessVo);
		System.out.println("수정후"+businessVo);

		return JsonResult.success("얏호");
	}
	
	// manager================================
	
	//가게 운영시간 등록
	@PostMapping("/api/su/insertRT")
	public JsonResult insertRtBybNo(@RequestBody ReserveVo reserveVo) {
		System.out.println("SUController.insertRtBybNo");

//		System.out.println("잘넘어 오는가"+reserveVo);
		suService.exeInsertRtBybNo(reserveVo);

		return JsonResult.success("얏호");
	}
	
	//가게 운영시간 등록 여부
	@GetMapping("/api/su/selectRt")
	public JsonResult selectRt(@RequestParam(value="bNo")int bNo) {
		System.out.println("SUController.selectRt");

		List<ReserveVo> dList = suService.exeGetRtBybNo(bNo);

//		System.out.println("잘 가져왔는가"+dList);
		return JsonResult.success(dList);
	}
	
	//가게 운영시간 가져오기
	@GetMapping("/api/su/selectRtime")
	public JsonResult selectRtime(@RequestParam(value="bNo")int bNo, @RequestParam(value="rtDate")String rtDate) {
		System.out.println("SUController.selectRtime");
		
		ReserveVo rVo = new ReserveVo();
		rVo.setbNo(bNo);
		rVo.setRtDate(rtDate);
		System.out.println("프론트에서 여기 확인하기"+rVo.getbNo() );
		System.out.println("프론트에서 여기 확인하기"+rVo.getRtDate() );

		List<ReserveVo> timeList = suService.exeGetRtimeBybNo(rVo);

//		System.out.println("잘 가져왔는가"+timeList);
		return JsonResult.success(timeList);
	}
	
	//가게 운영시간 삭제
	@DeleteMapping("/api/su/deleteRtime")
	public JsonResult deleteRtime(@RequestBody ReserveVo reserveVo) {
		System.out.println("SUController.deleteRtime");
		
		System.out.println("받아온 bNo 확인하기" + reserveVo.getbNo() );
		System.out.println("받아온 rtDate 확인하기" + reserveVo.getRtDate() );
		System.out.println("받아온 rtTime 확인하기" + reserveVo.getRtTime() );

		suService.exeDeleteRt(reserveVo);

		return JsonResult.success("얏호");
	}
	
	//가게 운영시간 수정
		@PostMapping("/api/su/updateRtime")
		public JsonResult updateRtime(@RequestBody ReserveVo reserveVo) {
			System.out.println("SUController.updateRtime");
			
			System.out.println("받아온 bNo 확인하기" + reserveVo.getbNo() );
			System.out.println("받아온 rtDate 확인하기" + reserveVo.getRtDate() );
			System.out.println("받아온 rtTime 확인하기" + reserveVo.getRtTime() );

			suService.exeUpdateRt(reserveVo);

			return JsonResult.success("얏호");
		}
	
	

}