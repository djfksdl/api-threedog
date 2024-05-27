package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.JWService;
import com.javaex.util.JsonResult;
import com.javaex.vo.ReserveVo;

@RestController
public class JWController {

	@Autowired
	private JWService jwService;

	// 한 가게의 예약 리스트 정보 조회
	@GetMapping("/api/jw/{bNo}")
	public JsonResult selectReserveList(@PathVariable("bNo") int bNo) {
		System.out.println("JWController.list");

		List<ReserveVo> reserveList = jwService.getReserveList(bNo);
		System.out.println(reserveList);

		return JsonResult.success(reserveList);
	}

	// 일정 수정
	@PutMapping("/api/jw/{rsNo}/date")
	public JsonResult updateReserveDate(@PathVariable("rsNo") int rsNo, @RequestBody ReserveVo reserveVo) {
		reserveVo.setRsNo(rsNo);
		System.out.println("일정 수정 메서드 실행");

		jwService.updateReserveDate(reserveVo);
		return JsonResult.success(reserveVo);
	}

	// 시간 수정
	@PutMapping("/api/jw/{rsNo}/time")
	public JsonResult updateReserveTime(@PathVariable("rsNo") int rsNo, @RequestBody ReserveVo reserveVo) {
		reserveVo.setRsNo(rsNo);
		System.out.println("시간 수정 메서드 실행");

		// rsDate를 함께 제공
		reserveVo.setRtDate(reserveVo.getRtDate());

		jwService.updateReserveTime(reserveVo);
		return JsonResult.success(reserveVo);
	}

	// 일정 삭제
	@DeleteMapping("/api/jw/{rsNo}/delete")
	public JsonResult deleteReserve(@PathVariable("rsNo") int rsNo) {
		
		jwService.deleteReserve(rsNo);
		return JsonResult.success(rsNo);
	}
	
	// 예약 정보 업데이트
	@PutMapping("/api/jw/diary/{rsNo}")
	public JsonResult updateReserve(@PathVariable("rsNo") int rsNo, @RequestBody ReserveVo reserveVo) {
		System.out.println("JWController.updateReserve");

		reserveVo.setRsNo(rsNo);
		System.out.println(reserveVo);

		int count = jwService.exeUpdateReserve(reserveVo);

		if (count > 0) {
			return JsonResult.success(reserveVo);
		} else {
			return JsonResult.fail("Update failed");
		}
	}
}