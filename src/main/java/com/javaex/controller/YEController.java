package com.javaex.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.YEService;
import com.javaex.util.JsonResult;
import com.javaex.util.JwtUtil;
import com.javaex.vo.BusinessVo;
import com.javaex.vo.ReviewListVo;
import com.javaex.vo.SearchVo;
import com.javaex.vo.StatsVo;
import com.javaex.vo.StoreVo;

import jakarta.servlet.http.HttpServletResponse;

@RestController
public class YEController {

	@Autowired
	private YEService yeService;

	// 회원가입
	@PostMapping("/api/msignup")
	public JsonResult mSignup(@ModelAttribute BusinessVo businessVo) {
		System.out.println("YEController.mSignup()");

		System.out.println(businessVo);

		yeService.exeMsignup(businessVo);

		System.out.println(businessVo);
		return JsonResult.success(businessVo);
	}

	// 아이디 중복 체크
	@GetMapping("/api/msignup/id")
	public JsonResult idCheck(@RequestParam String id) {
		System.out.println("YEController.idCheck()");
//		System.out.println(id);

		int count = yeService.exeIdCheck(id);
//		System.out.println(count);

		return JsonResult.success(count);
	}

	// 로그인
	@PostMapping("/api/mlogin")
	public JsonResult mLogin(@ModelAttribute BusinessVo businessVo, HttpServletResponse response) {
		System.out.println("YEController.mLogin()");

//		System.out.println(businessVo);
		BusinessVo auth = yeService.exeMlogin(businessVo);

		if (auth != null) {
			JwtUtil.createTokenAndSetHeader(response, "" + auth.getbNo());
			return JsonResult.success(auth);
		} else {
			return JsonResult.fail("로그인실패");
		}
	}

	// 검색 화면 기본 후기 리스트(조회순, 검색기본화면, 인기짱강아지리스트)
	@GetMapping("/api/searchlist")
	public JsonResult searchList() {
		System.out.println("YEController.searchList()");

		List<ReviewListVo> reviewList = yeService.exeSearchList();
//		System.out.println(reviewList);

		return JsonResult.success(reviewList);
	}

	
	// 메인 가게 리스트(거리순)
	@GetMapping("/api/mainlist")
	public JsonResult mainList(@RequestParam(value = "lat") Double lat, @RequestParam(value = "lng") Double lng) {
		System.out.println("YEController.mainList()");

		if (lat == null)
			lat = 37.5665;
		if (lng == null)
			lng = 126.9780;

		StoreVo storeVo = new StoreVo(lat, lng);

		List<StoreVo> mainList = yeService.exeList(storeVo);

//		System.out.println("-----------");
//	    System.out.println(mainList);

		return JsonResult.success(mainList);
	}

	// 지도, 캘린더로 검색 리스트
	@GetMapping("/api/searchmap")
	public JsonResult searchMap(@RequestParam(value = "lat") Double lat, @RequestParam(value = "lng") Double lng,
			@RequestParam(value = "rsDate") String rsDate) {
		System.out.println("YEController.searchmap()");

		if (lat == null)
			lat = 37.5665;
		if (lng == null)
			lng = 126.9780;
		if (rsDate =="")
			rsDate = null;
		
		StoreVo storeVo = new StoreVo(lat, lng, rsDate);

		System.out.println("Received lat: " + storeVo.getLat());
		System.out.println("Received lng: " + storeVo.getLan());
		System.out.println("Received rsDate: " + storeVo.getRsDate());

		List<StoreVo> storeList = yeService.exeSearchMap(storeVo);

		System.out.println("dd"+storeList);

		return JsonResult.success(storeList);
	}

	// 인기검색어
	@GetMapping("/api/poprank")
	public JsonResult popRank() {
		System.out.println("YEController.popRank()");

		List<StoreVo> storeList = yeService.exePopList();
//		System.out.println("------------------");
//		System.out.println(storeList);
//		System.out.println("------------------");
		return JsonResult.success(storeList);
	}

	// 가게 마커 표시하고 싶어용 ㅜㅜ
	@GetMapping("/api/marker")
	public JsonResult marker() {
		System.out.println("YEController.marker()");

		List<BusinessVo> markList = yeService.exeMarker();
//		System.out.println(markList);

		return JsonResult.success(markList);
	}

	// 키워드 검색
	@GetMapping("/api/keyword")
	public JsonResult keyword(
	    @RequestParam(value = "searchKeyword") String keyword,
	    @RequestParam(value = "selectedCities", required = false) String selectedCities,
	    @RequestParam(value = "selectedWeights", required = false) String selectedWeights,
	    @RequestParam(value = "selectedTypes", required = false) String selectedTypes,
	    @RequestParam(value = "selectedPrices", required = false) String selectedPrices) {

	    System.out.println("YEController.keyword()");

	    // 도시 리스트
	    List<String> citiesList = selectedCities != null && !selectedCities.isEmpty() ? Arrays.asList(selectedCities.split(";")) : null;

	    // 무게 리스트 분할 및 숫자 변환
	    List<Integer> weightsList = new ArrayList<>();
	    if (selectedWeights != null && !selectedWeights.isEmpty()) {
	        String[] weightIndices = selectedWeights.split(";");
	        for (String index : weightIndices) {
	            weightsList.add(Integer.parseInt(index));
	        }
	    }

	    // 타입 리스트
	    List<String> typesList = selectedTypes != null && !selectedTypes.isEmpty() ? Arrays.asList(selectedTypes.split(";")) : null;

	    // 가격 리스트 및 숫자 변환
	    List<Integer> pricesList = new ArrayList<>();
	    if (selectedPrices != null && !selectedPrices.isEmpty()) {
	        String[] prices = selectedPrices.split(";");
	        for (String price : prices) {
	            pricesList.add(Integer.parseInt(price.replaceAll("[^0-9]", "")));
	        }
	    }
	    
	    // SearchVo 생성
	    SearchVo searchVo = new SearchVo(keyword, citiesList, weightsList, typesList, pricesList);

//	    System.out.println(searchVo);
	    List<ReviewListVo> reviewList = yeService.exeKeyword(searchVo);
	    
	    System.out.println("=============");
	    System.out.println(reviewList);

	    return JsonResult.success(reviewList);
	}
	
	// 주별 통계
	@GetMapping("/api/weekstats")
	public JsonResult weekStats(@RequestParam(value = "bNo") int bNo) {
		System.out.println("YEController.weekStats()");
//		System.out.println(bNo);
		List<StatsVo> weekList = yeService.exeWeekList(bNo);

//		System.out.println("주"+weekList);
		
		return JsonResult.success(weekList);
	}
	
	// 월별 통계
	@GetMapping("/api/monthstats")
	public JsonResult monthStats(@RequestParam(value = "bNo") int bNo) {
		System.out.println("YEController.monthStats()");

		List<StatsVo> monthList = yeService.exeMonthList(bNo);
		
//		System.out.println("월"+monthList);
		
		return JsonResult.success(monthList);
	}
	
	// 년별 통계
	@GetMapping("/api/yearstats")
	public JsonResult yearStats(@RequestParam(value = "bNo") int bNo) {
		System.out.println("YEController.yearStats()");

		List<StatsVo> yearList = yeService.exeYearList(bNo);
		
//		System.out.println("년"+yearList);

		return JsonResult.success(yearList);
	}
	
	// 일일 종류 별 금액
	@GetMapping("/api/daystats")
	public JsonResult dayStats(@RequestParam(value = "bNo") int bNo) {
		System.out.println("YEController.dayStats()");

		List<StatsVo> dayList = yeService.exeDayList(bNo);
		
//		System.out.println("날짜"+dayList);

		return JsonResult.success(dayList);
	}
	
}