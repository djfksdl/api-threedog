package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.NoticeService;
import com.javaex.util.JsonResult;
import com.javaex.vo.NoticeVo;
import com.javaex.vo.PagingVo;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	//리스트(검색O, 페이징O)
	@PostMapping(value="/api/notice/list")
	public Map<String, Object> noticeList(HttpServletRequest request,
										@RequestBody PagingVo pagingVo) {
		//파라미터 crtPage가 없으면 1(페이지)로 처리
		System.out.println("NoticeController.noticeList()");
		
		Map<String, Object> pMap=noticeService.exeList(pagingVo.getCrtPage(), pagingVo.getKeyword());
		
		System.out.println(pMap);
		
		return pMap;
	}
	
	//수정
	@PutMapping("/api/notice/modify")
	public JsonResult noticeModify(@RequestBody NoticeVo noticeVo) {
		System.out.println("NoticeController.noticeModify()");
		
		int count=noticeService.exeModify(noticeVo);
		
		String result=count+"건 수정 되었습니다.";
		
		return JsonResult.success(result);
	}
	
	//등록
	@PostMapping("/api/notice/write")
	public JsonResult noticeWrite(@RequestBody NoticeVo noticeVo) {
		System.out.println("NoticeController.noticeWrite()");
		
		int count=noticeService.exeWrite(noticeVo);
		
		String result=count+"건 등록 되었습니다.";
		
		return JsonResult.success(result);
	}
	
	//삭제
	@DeleteMapping("/api/notice/delete/{no}")
	public JsonResult noticeDelete(@PathVariable("no") int no) {
		System.out.println("NoticeController.noticeDelete()");
		
		int count=noticeService.exeDelete(no);
		
		String result=count+"건 삭제 되었습니다.";
		
		return JsonResult.success(result);
	}
	
	//읽기
	@GetMapping("/api/notice/read/{no}")
	public JsonResult noticeRead(@PathVariable("no") int no) {
		System.out.println("NoticeController.noticeRead()");
		
		NoticeVo nVo=noticeService.exeRead(no);
		
		return JsonResult.success(nVo);
	}

}
