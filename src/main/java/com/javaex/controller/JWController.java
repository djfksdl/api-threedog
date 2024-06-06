package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

	// 일정 삭제 및 예약 시간 업데이트
	@DeleteMapping("/api/jw/{rsNo}/delete")
    public ResponseEntity<?> deleteAndUpdateReserve(@PathVariable int rsNo) {
        jwService.deleteAndFinishReserve(rsNo);
        return ResponseEntity.ok().build();
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

	// 이미지 업로드를 처리하는 컨트롤러 메서드
	@PostMapping("/api/jw/{rsNo}/uploadimage")
	public JsonResult uploadImage(@PathVariable("rsNo") int rsNo, @RequestParam("file") MultipartFile file) {
		String fileUrl = jwService.uploadImage(rsNo, file);
		System.out.println("업로드된 파일 URL: " + fileUrl); // 콘솔 출력 추가
		return JsonResult.success(Map.of("url", fileUrl)); // 업로드된 이미지의 URL 반환
	}
	
	
	
	// 미용 기록 업데이트를 처리하는 컨트롤러 메서드
	@PutMapping("/api/jw/{rsNo}/updategroomingrecord")
	public JsonResult updateGroomingRecord(@PathVariable("rsNo") int rsNo, @RequestBody Map<String, Object> params) {
	    // ReserveVo 객체 생성 및 설정
	    ReserveVo reserveVo = new ReserveVo();
	    reserveVo.setRsNo(rsNo); // 예약 번호를 설정

	    // 필요한 필드들 설정
	    reserveVo.setAttitude((String) params.get("groomingEtiquette"));
	    reserveVo.setrCondition((String) params.get("condition"));
	    reserveVo.setTangle((String) params.get("mattedArea"));
	    reserveVo.setDisliked((String) params.get("dislikedArea"));
	    reserveVo.setBath((String) params.get("bathDry"));

	    // curruntWeight를 double로 설정
	    if (params.get("curruntWeight") instanceof Number) {
	        reserveVo.setcurruntWeight(((Number) params.get("curruntWeight")).doubleValue());
	    } else if (params.get("curruntWeight") instanceof String) {
	        try {
	            reserveVo.setcurruntWeight(Double.parseDouble((String) params.get("curruntWeight")));
	        } catch (NumberFormatException e) {
	            reserveVo.setcurruntWeight(0.0); // 기본값으로 설정하거나 예외 처리
	        }
	    } else {
	        reserveVo.setcurruntWeight(0.0); // 기본값으로 설정하거나 예외 처리
	    }

	    reserveVo.setMessage((String) params.get("note"));

	    // additionalFee를 Integer로 설정
	    if (params.get("additionalFee") instanceof Number) {
	        reserveVo.setSurcharge(((Number) params.get("additionalFee")).intValue());
	    } else if (params.get("additionalFee") instanceof String) {
	        try {
	            reserveVo.setSurcharge(Integer.parseInt((String) params.get("additionalFee")));
	        } catch (NumberFormatException e) {
	            reserveVo.setSurcharge(0); // 기본값으로 설정하거나 예외 처리
	        }
	    } else {
	        reserveVo.setSurcharge(0); // 기본값으로 설정하거나 예외 처리
	    }

	    System.out.println(reserveVo);

	    System.out.println("업데이트할 예약 번호: " + rsNo); // 예약 번호 확인
	    jwService.updateGroomingRecord(reserveVo); // 서비스 호출하여 미용 기록 업데이트
	    System.out.println("미용 기록 업데이트 완료: " + reserveVo); // 업데이트 완료 확인
	    return JsonResult.success(reserveVo); // 성공 응답 반환
	}


	// 푸시 알림 저장
    @PostMapping("/api/jw/{rsNo}/insertPushNotification")
    public ResponseEntity<?> insertPushNotification(@PathVariable("rsNo") int rsNo) {
        jwService.insertPushNotification(rsNo);
        System.out.println("푸쉬푸쉬베이베: " + rsNo); // 업데이트 완료 확인
        return ResponseEntity.ok().build();
    }
    
    
    /****************************
     * 회원 강아지의 마이다이어리
     ****************************/
    @GetMapping("/api/jw/userDogList/{uNo}")
    public JsonResult getUserDogList(@PathVariable("uNo") int uNo) {
        System.out.println("어떤회원의 강아지별 알림장리스트 요청: uNo = " + uNo);
        List<ReserveVo> userDogList = jwService.getUserDogList(uNo);
        System.out.println("회원 강아지별 알림장리스트: " + userDogList);
        return JsonResult.success(userDogList);
    }

    
}