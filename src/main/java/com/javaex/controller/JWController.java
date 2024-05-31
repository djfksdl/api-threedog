package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.JWService;
import com.javaex.util.JsonResult;
import com.javaex.vo.ReserveVo;

@RestController
public class JWController {

	@Autowired
	private JWService jwService;

	/****************************
	 * 스케줕화면
	 ****************************/

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

	// 특정 예약의 미용 기록 조회
	@GetMapping("/api/jw/{rsNo}/groomingrecord")
	public JsonResult selectGroomingRecord(@PathVariable("rsNo") int rsNo) {
		System.out.println("특정 예약의 미용 기록 조회 메서드 실행");

		ReserveVo groomingRecord = jwService.selectGroomingRecord(rsNo);
		System.out.println(groomingRecord);

		return JsonResult.success(groomingRecord);
	}

	/****************************
	 * 알림장화면
	 ****************************/
	// 미용 기록 업데이트를 처리하는 컨트롤러 메서드
	@PutMapping("/api/jw/{rsNo}/updategroomingrecord")
	public JsonResult updateGroomingRecord(@PathVariable("rsNo") int rsNo, @RequestBody ReserveVo reserveVo) {
		reserveVo.setRsNo(rsNo); // 예약 번호를 설정
		jwService.updateGroomingRecord(reserveVo); // 서비스 호출하여 미용 기록 업데이트
		return JsonResult.success(reserveVo); // 성공 응답 반환
	}

	// 사진 업로드를 처리하는 컨트롤러 메서드
    @PostMapping("/{rsNo}/uploadimage")
    public JsonResult uploadImage(@PathVariable("rsNo") int rsNo, @RequestParam("file") MultipartFile file) {
        String fileUrl = jwService.uploadImage(rsNo, file);
        return JsonResult.success(Map.of("url", fileUrl)); // 업로드된 이미지의 URL 반환
    }

}