package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.javaex.vo.BusinessVo;
import com.javaex.vo.ReviewListVo;
import com.javaex.vo.SearchVo;
import com.javaex.vo.StatsVo;
import com.javaex.vo.StoreVo;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Repository
public class YEDao {

	@Autowired
	private SqlSession sqlSession;

	public void msignup(BusinessVo businessVo) {
		System.out.println("YEDao.msignup()");

		sqlSession.insert("ye.bInsert", businessVo);
	}

	public int idCheck(String id) {
		System.out.println("YEDao.idCheck()");

		int count = sqlSession.selectOne("ye.bSelect", id);

		return count;
	}

	public BusinessVo mlogin(@ModelAttribute BusinessVo businessVo) {
		System.out.println("YEDao.mlogin()");

		BusinessVo auth = sqlSession.selectOne("ye.bSelectOne", businessVo);

		return auth;
	}

	public List<ReviewListVo> searchList() {
		System.out.println("YEDao.searchList()");

		List<ReviewListVo> reviewList = sqlSession.selectList("ye.searchlist");

		return reviewList;
	}

	public List<StoreVo> searchMap(StoreVo storeVo) {
		System.out.println("YEDao.searchMap()");

		List<StoreVo> storeList = sqlSession.selectList("ye.searchmap", storeVo);

		return storeList;
	}

	public List<StoreVo> mainList(StoreVo storeVo) {
		System.out.println("YEDao.mainList()");

		List<StoreVo> mainList = sqlSession.selectList("ye.mainlist", storeVo);

		return mainList;
	}

	public List<StoreVo> popList() {
		System.out.println("YEDao.popList()");

		List<StoreVo> storeList = sqlSession.selectList("ye.poplist");

		return storeList;
	}

	public List<BusinessVo> markList() {
		System.out.println("YEDao.markList()");

		List<BusinessVo> markList = sqlSession.selectList("ye.marklist");

		return markList;
	}
	
	public List<ReviewListVo> keyword(SearchVo searchVo) {
		System.out.println("YEDao.keyword()");
		
		return sqlSession.selectList("ye.keyword", searchVo);
	}

	public List<StatsVo> week(int bNo) {
		System.out.println("YEDao.week()");
		
		return sqlSession.selectList("ye.weekList", bNo);
	}

	public List<StatsVo> month(int bNo) {
		System.out.println("YEDao.month()");
		
		return sqlSession.selectList("ye.monthList", bNo);
	}

	public List<StatsVo> year(int bNo) {
		System.out.println("YEDao.year()");
		
		return sqlSession.selectList("ye.yearList", bNo);
	}

	public List<StatsVo> day(int bNo) {
		System.out.println("YEDao.day()");
		
		return sqlSession.selectList("ye.today", bNo);
	}
}
