package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.AYService;
import com.javaex.util.JsonResult;
import com.javaex.vo.BusinessVo;
import com.javaex.vo.DogVo;
import com.javaex.vo.PriceVo;
import com.javaex.vo.ReserveVo;
import com.javaex.vo.ReviewVo;
import com.javaex.vo.UserVo;

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

	// 반려견정보1개 가져오기
	@GetMapping("/api/mypage/petgetinfor")
	public JsonResult petGetInfor(@RequestParam(value = "dogNo") int dogNo) {
		System.out.println("AYController.getRList");
		System.out.println(dogNo);

		DogVo dogVo = ayService.exePetGetInfor(dogNo);

		return JsonResult.success(dogVo);
	}

	@PutMapping("/api/mypage/petupdate")
	public JsonResult petUpdate(@ModelAttribute DogVo dogVo) {
		System.out.println("AYController.petUpdate");

		ayService.exePetUpdate(dogVo);

		return JsonResult.success(dogVo);
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

	// 리뷰리스트
	@GetMapping("/api/mypage/getRList")
	public JsonResult reviewList(@RequestParam(value = "bNo") int bNo) {
		System.out.println("AYController.getRList");

		List<ReviewVo> reviewVo = ayService.exeGetRList(bNo);

		return JsonResult.success(reviewVo);
	}

	// 조회수 증가
	@PostMapping("/api/mypage/updateview")
	public JsonResult updateView(@RequestParam(value = "rNo") int rNo) {
		System.out.println("AYController.updateView");
		System.out.println(rNo);

		ayService.exeUpdateView(rNo);

		return JsonResult.success("서엉ㅇ공~");
	}

	// 리뷰1개 가져오기
	@GetMapping("/api/mypage/getonerlist")
	public JsonResult getOnerList(@RequestParam(value = "rNo") int rNo) {
		System.out.println("AYController.getOnerList");

		System.out.println(rNo);
		ReviewVo reviewVo = ayService.exeGetOnerList(rNo);

		return JsonResult.success(reviewVo);
	}

	// 리뷰사진들
	@GetMapping("/api/mypage/getsavename")
	public JsonResult getrSaveNameList(@RequestParam(value = "rNo") int rNo) {
		System.out.println("AYController.getrSaveNameList");

		System.out.println(rNo);
		List<ReviewVo> reviewVo = ayService.exegetrSaveNameList(rNo);

		return JsonResult.success(reviewVo);
	}

	// 예약페이지 가게정보
	@GetMapping("/api/mypage/getbList")
	public JsonResult getBList(@RequestParam(value = "bNo") int bNo) {
		System.out.println("AYController.getBList");

		System.out.println(bNo);
		BusinessVo businessVo = ayService.exeGetBList(bNo);

		return JsonResult.success(businessVo);
	}

	// 반려견 불러오기
	@GetMapping("/api/mypage/getpetlist")
	public JsonResult getPetList(@RequestParam(value = "uNo") int uNo) {
		System.out.println("AYController.getPetList");

		List<ReserveVo> reserveVo = ayService.exeGetPetList(uNo);
		System.out.println(reserveVo);

		return JsonResult.success(reserveVo);
	}

	// 반려견 정보1개 가져오기
	@GetMapping("/api/mypage/getpetinfor")
	public JsonResult getPetInfor(@RequestParam(value = "dogNo") int dogNo) {
		System.out.println("AYController.getPetInfor");

		DogVo dogVo = ayService.exeGetPetInfor(dogNo);

		System.out.println(dogVo);

		return JsonResult.success(dogVo);
	}

	// 가격표 가져오기
	@GetMapping("/api/mypage/getprice")
	public JsonResult getPrice(@RequestParam(value = "bNo") int bNo, @RequestParam(value = "sizeDiv") String sizeDiv) {
		System.out.println("AYController.getPrice");

		PriceVo priceVo = new PriceVo(bNo, sizeDiv);

		List<PriceVo> priceList = ayService.exeGetPrice(priceVo);

		return JsonResult.success(priceList);
	}

	// 추가요금 가져오기
	@GetMapping("/api/mypage/getplusprice")
	public JsonResult getPlusPrice(@RequestParam(value = "bNo") int bNo) {
		System.out.println("AYController.getPlusPrice");

		List<PriceVo> priceList = ayService.exeGetPlusPrice(bNo);

		return JsonResult.success(priceList);
	}

	// 유저포인트 가져오기
	@GetMapping("/api/mypage/getpoint")
	public JsonResult getPoint(@RequestParam(value = "uNo") int uNo) {
		System.out.println("AYController.getPoint");
		System.out.println("유저포인트 가져오기");
		System.out.println(uNo);
		UserVo userVo = ayService.exeGetPoint(uNo);

		return JsonResult.success(userVo);
	}

	// 시간가져오기
	@GetMapping("/api/mypage/gettimelist")
	public JsonResult getTimeList(@RequestParam(value = "bNo") int bNo, @RequestParam(value = "rtDate") String rtDate) {
		System.out.println("AYController.getTimeList");
		System.out.println("시간ㄴㄴ을가가져오아아아");
		System.out.println(bNo);
		System.out.println(rtDate);

		ReserveVo reserveVo = new ReserveVo(bNo, rtDate);
		System.out.println(reserveVo);

		List<ReserveVo> reserveList = ayService.exeGetTimeList(reserveVo);

		return JsonResult.success(reserveList);

	}

	// 예약하기
	@PostMapping("/api/mypage/reservation")
	public JsonResult reserveInsert(@ModelAttribute ReserveVo reserveVo) {
		System.out.println("AYController.reserveInsert");
		System.out.println("예약하기 ~~~~~ ");
		System.out.println(reserveVo);

		ayService.exeReserveInsert(reserveVo);

		return JsonResult.success("성공 ~~~~~");
	}

	// 사이드바
	@GetMapping("/api/mypage/sidebar")
	public JsonResult getSidebar(@RequestParam(value = "uNo") int uNo) {
		System.out.println("AYController.getSidebar");

		UserVo userVo = ayService.exeGetSidebar(uNo);

		return JsonResult.success(userVo);
	}

	// 사이드바
	@GetMapping("/api/mypage/sidebar2")
	public JsonResult getSidebar2(@RequestParam(value = "uNo") int uNo) {
		System.out.println("AYController.getSidebar2");

		List<DogVo> dogVo = ayService.exeGetSidebar2(uNo);

		return JsonResult.success(dogVo);
	}

	// 마이페이지 예약
	@GetMapping("/api/mypage/reserve")
	public JsonResult getReserve(@RequestParam(value = "uNo") int uNo) {
		System.out.println("AYController.getReserve");

		ReserveVo reserveVo = ayService.exeGetReserve(uNo);

		return JsonResult.success(reserveVo);
	}

	// 마이페이지 후기
	@GetMapping("/api/mypage/review")
	public JsonResult getReview(@RequestParam(value = "uNo") int uNo) {
		System.out.println("AYController.getReview");

		ReviewVo reviewVo = ayService.exeGetReview(uNo);

		return JsonResult.success(reviewVo);
	}

	// 마이페이지 알림장
	@GetMapping("/api/mypage/mydiary")
	public JsonResult getMydiary(@RequestParam(value = "uNo") int uNo) {
		System.out.println("AYController.getMydiary");

		ReserveVo reserveVo = ayService.exeGetMydiary(uNo);

		return JsonResult.success(reserveVo);
	}
	
	//마이페이지 예약더보기
	@GetMapping("/api/mypage/reservationlist")
	public JsonResult getReservationList(@RequestParam(value = "uNo") int uNo) {
		System.out.println("AYController.reservationlist");

		List<ReserveVo> reserveVo = ayService.exeGetReservationList(uNo);

		return JsonResult.success(reserveVo);
	}

}