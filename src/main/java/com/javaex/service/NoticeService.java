package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.NoticeDao;
import com.javaex.vo.NoticeVo;

@Service
public class NoticeService {
	
	@Autowired
	private NoticeDao noticeDao;
	
	//리스트(검색O, 페이징O)
	public Map<String, Object> exeList(int crtPage, String keyword){
		System.out.println("NoticeService.exeList()");
		
		//한 페이지당 출력 글 개수
		int listCnt=10;
		
		crtPage=(crtPage>0)? crtPage:(crtPage=1);
		
		//startRowNo 구하기
		int startRowNo=(crtPage-1)*listCnt;
		
		//startRowNo, listCnt Map으로 묶는다
		Map<String, Object> limitMap=new HashMap<String, Object>();
		limitMap.put("startRowNo", startRowNo);
		limitMap.put("listCnt", listCnt);
		limitMap.put("keyword", keyword);
		
		//dao에 전달해서 현재 페이지의 리스트 10개를 받는다
		List<NoticeVo> nList = noticeDao.selectList(limitMap);
		
		/**********************
		 * 페이징 계산
		 *********************/
		//페이지당 버튼 개수
		int pageBtnCount=5;
			
		//전체 글 개수
		int totalCnt=noticeDao.selectTotalCnt(keyword);
		
		//마지막 버튼 번호
		int endPageBtnNo=(int)Math.ceil(crtPage/(double)pageBtnCount)*pageBtnCount;
		
		//시작 버튼 번호
		int startPageBtnNo=(endPageBtnNo-pageBtnCount)+1;
		
		//다음 화살표 유무
		boolean next=false;
		
		if(listCnt*endPageBtnNo<totalCnt) {
			//한 페이지당 글 개수(10)*마지막 버튼 번호(5)<전체 글 개수 102개
			next=true;
		} else {	//다음 화살표가 false일 때 마지막 버튼 번호 정확히 계산
			//187개 -> 19페이지 => 187/10=18.7 올림 -> 19
			endPageBtnNo=(int)Math.ceil(totalCnt/(double)listCnt);
			
		}
		
		//이전 화살표 유무
		boolean prev=false;
		
		if(startPageBtnNo!=1) {
			prev=true;
		}
		
		//5개 map으로 묶어서 controller한테 보낸다/리턴
		Map<String, Object> pMap=new HashMap<String, Object>();
		pMap.put("nList", nList);
		pMap.put("startPageBtnNo", startPageBtnNo);
		pMap.put("endPageBtnNo", endPageBtnNo);
		pMap.put("prev", prev);
		pMap.put("next", next);
		pMap.put("totalCnt", totalCnt);
		
		return pMap;
		
	}
	
	//수정
	public int exeModify(NoticeVo noticeVo) {
		System.out.println("NoticeService.exeModify()");
		
		return noticeDao.updateNotice(noticeVo);
	}
	
	//등록
	public int exeWrite(NoticeVo noticeVo) {
		System.out.println("NoticeService.exeWrite()");
		
		return noticeDao.insertNotice(noticeVo);
	}
	
	//삭제
	public int exeDelete(int no) {
		System.out.println("NoticeService.exeDelete()");
		
		return noticeDao.deleteNotice(no);
	}
	
	//읽기
	public NoticeVo exeRead(int no) {
		System.out.println("NoticeService.exeRead()");
		
		NoticeVo nVo=noticeDao.selectOneNotice(no);
		
		return nVo;
	}

}
