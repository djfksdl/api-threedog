package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BusinessVo;
import com.javaex.vo.DogVo;
import com.javaex.vo.PointVo;
import com.javaex.vo.PriceVo;
import com.javaex.vo.ReserveVo;
import com.javaex.vo.ReviewVo;
import com.javaex.vo.UserVo;

@Repository
public class AYDao {

	@Autowired
	private SqlSession sqlSession;

	// 반려견등록
	public String addPet(DogVo dogVo) {
		System.out.println("AYDao.addPet()");
		System.out.println("*******전*********");
		System.out.println(dogVo);

		sqlSession.insert("ay.petInsert", dogVo);

		System.out.println("*******후*********");
		System.out.println(dogVo);

		return dogVo.getDogImg();
	}

	// 반려견수정
	public String petUpdate(DogVo dogVo) {
		System.out.println("AYDao.petUpdate()");
		System.out.println(dogVo);

		sqlSession.update("ay.petUpdate", dogVo);

		return dogVo.getDogImg();
	}

	// 반려견수정
	public DogVo petUpdateWithoutImage(DogVo dogVo) {
		System.out.println("AYDao.petUpdateWithoutImage()");
		System.out.println(dogVo);

		sqlSession.update("ay.petUpdateWithoutImage", dogVo);

		return dogVo;
	}

	// 반려견정보1개 가져오기
	public DogVo getPetGetInfor(int dogNo) {
		System.out.println("AYDao.getPetGetInfor()");

		DogVo dogVo = sqlSession.selectOne("ay.petSelectOne", dogNo);

		return dogVo;
	}

	// 리뷰등록
	public void addReview(ReviewVo reviewVo) {
		System.out.println("AYDao.addReview()");

		// 리뷰 정보를 먼저 등록
		sqlSession.insert("ay.addReview01", reviewVo);
		sqlSession.update("ay.insertPoint", reviewVo);
		sqlSession.update("ay.addUserPoint", reviewVo);

	}

	// 리뷰등록
	public void addReview2(ReviewVo reviewVo) {
		System.out.println("AYDao.addReview2()");
		System.out.println("제발 사진추가좀하자아아아");
		System.out.println(reviewVo.getrNo());

		System.out.println(reviewVo);

		sqlSession.insert("ay.addReview02", reviewVo);

		System.out.println(reviewVo.getSaveName());
	}

	// 조회수 증가
	public void updateView(int rNo) {
		System.out.println("AYDao.updateView");

		sqlSession.update("ay.reviewUpdateView", rNo);

	}

	// 리뷰리스트
	public List<ReviewVo> getRList(int bNo) {
		System.out.println("AYDao.getRList");
		List<ReviewVo> reviewVo = sqlSession.selectList("ay.reviewSelect", bNo);

		System.out.println(reviewVo);

		return reviewVo;
	}

	// 리뷰1개 가져오기
	public ReviewVo getOnerList(int rNo) {
		System.out.println("AYDao.getOnerList()");
		ReviewVo reviewVo = sqlSession.selectOne("ay.selectOneRList", rNo);

		System.out.println(reviewVo);

		return reviewVo;

	}

	// 가게정보 가져오기
	public BusinessVo getBList(int bNo) {
		System.out.println("AYDao.getBList()");
		BusinessVo businessVo = sqlSession.selectOne("ay.selectOne", bNo);
		System.out.println("가게정보!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(businessVo);

		return businessVo;

	}

	// 반려견 불러오기
	public List<ReserveVo> getPetList(int uNo) {
		System.out.println("AYDao.getPetList");
		System.out.println(uNo);
		List<ReserveVo> reserveVo = sqlSession.selectList("ay.selectPetList", uNo);

		return reserveVo;
	}

	// 반려견 정보1개 가져오기
	public DogVo getPetInfor(int dogNo) {
		System.out.println("AYDao.getPetInfor");
		DogVo dogVo = sqlSession.selectOne("ay.selectPetInforOne", dogNo);

		return dogVo;
	}

	// 미용목록 불러오기
	public List<PriceVo> getPriceList(PriceVo priceVo) {
		System.out.println("AYDao.getPriceList");
		System.out.println(priceVo);

		List<PriceVo> priceList = sqlSession.selectList("ay.selectPrice", priceVo);

		return priceList;
	}

	// 추가요금 불러오기
	public List<PriceVo> getPlusPrice(int bNo) {
		System.out.println("AYDao.getPlusPrice");
		System.out.println(bNo);

		List<PriceVo> priceList = sqlSession.selectList("ay.selectPlusPrice", bNo);
		System.out.println("-----------------------추가요금----------------");
		System.out.println(priceList);
		return priceList;
	}

	// 유저포인트 가져오기
	public UserVo getPoint(int uNo) {
		System.out.println("AYDao.getPoint");

		UserVo userVo = sqlSession.selectOne("ay.selectUserPoint", uNo);
		System.out.println("********************유저포인트가져오기**************************");
		System.out.println(userVo);
		return userVo;
	}

	// 시간 가져오기
	public List<ReserveVo> getTimeList(ReserveVo reserveVo) {
		System.out.println("AYDao.getTimeList");

		List<ReserveVo> reserveList = sqlSession.selectList("ay.selecTimeList", reserveVo);
		System.out.println(reserveList);

		return reserveList;
	}

	// 예약테이블 등록
	public String reserveInsert(ReserveVo reserveVo) {
		System.out.println("AYDao.reserveInsert()");
		System.out.println(reserveVo);

		reserveVo.setRsNum(reserveVo.getRsNo());
		sqlSession.insert("ay.reserveInsert", reserveVo);

		return reserveVo.getSignImg();
	}

	// 예약시간테이블 수정
	public String reserveTime(ReserveVo reserveVo) {
		System.out.println("AYDao.reserveTime()");
		System.out.println(reserveVo);

		sqlSession.update("ay.reserveTime", reserveVo);

		return reserveVo.getSignImg();
	}

	// 포인트테이블 등록
	public String reservePoint(ReserveVo reserveVo) {
		System.out.println("AYDao.reservePoint()");
		System.out.println(reserveVo);
		System.out.println("예약번호???????????");
		System.out.println(reserveVo.getRsNum());
		sqlSession.insert("ay.reservePoint", reserveVo);

		return reserveVo.getSignImg();
	}

	// 유저포인트 수정
	public String userPoint(ReserveVo reserveVo) {
		System.out.println("AYDao.userPoint()");
		System.out.println(reserveVo);

		sqlSession.update("ay.userPoint", reserveVo);

		return reserveVo.getSignImg();
	}

	// 반려견테이블 수정
	public String reserveDog(ReserveVo reserveVo) {
		System.out.println("AYDao.reserveDog()");
		System.out.println(reserveVo);

		sqlSession.update("ay.reserveDog", reserveVo);

		return reserveVo.getSignImg();
	}

	// 예약가격테이블 등록
	public String reservePrice(ReserveVo reserveVo) {
		System.out.println("AYDao.reservePrice()");
		System.out.println(reserveVo);

		sqlSession.insert("ay.reservePrice", reserveVo);

		for (int priceNo : reserveVo.getPriceNoPlus()) {
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("rsNo", reserveVo.getRsNo());
			paramMap.put("priceNo", priceNo);
			paramMap.put("rtNo", reserveVo.getRtNo());
			sqlSession.insert("ay.reservePrice2", paramMap);
		}

		return reserveVo.getSignImg();
	}

	// 사이드바
	public UserVo getSidebar(int uNo) {
		System.out.println("AYDao.getSidebar");

		UserVo userVo = sqlSession.selectOne("ay.selectSidebar1", uNo);
		System.out.println(userVo);

		return userVo;
	}

	// 사이드바
	public List<DogVo> getSidebar2(int uNo) {
		System.out.println("AYDao.getSidebar");

		List<DogVo> dogVo = sqlSession.selectList("ay.selectSidebar2", uNo);
		System.out.println(dogVo);

		return dogVo;
	}

	// 마이페이지 예약
	public ReserveVo getReserve(int uNo) {
		System.out.println("AYDao.ReserveVo");

		ReserveVo reserveVo = sqlSession.selectOne("ay.selectGetReserve", uNo);
		System.out.println(reserveVo);
		return reserveVo;
	}

	// 마이페이지 리뷰
	public ReviewVo getReview(int uNo) {
		System.out.println("AYDao.getReview");

		ReviewVo reviewVo = sqlSession.selectOne("ay.selectGetReview", uNo);
		System.out.println(reviewVo);

		return reviewVo;
	}

	// 마이페이지 알림장
	public ReserveVo getMydiary(int uNo) {
		System.out.println("AYDao.getMydiary");

		ReserveVo reserveVo = sqlSession.selectOne("ay.selectGetMydiary", uNo);
		System.out.println(reserveVo);

		return reserveVo;
	}

	// 마이페이지 예약더보기
	public List<ReserveVo> getReservationList(int uNo) {
		System.out.println("AYDao.getReservationList");

		List<ReserveVo> reserveList = sqlSession.selectList("ay.selectListReservation", uNo);
		System.out.println(reserveList);

		return reserveList;
	}

	// 마이페이지 리뷰더보기
	public List<ReserveVo> getReservationList2(int uNo) {
		System.out.println("AYDao.getReservationList2");

		List<ReserveVo> reserveList = sqlSession.selectList("ay.selectListReservation2", uNo);
		System.out.println(reserveList);

		return reserveList;
	}

	// 리뷰1개 가져오기
	public ReviewVo getOnerList2(int rsNo) {
		System.out.println("AYDao.getOnerList2()");
		ReviewVo reviewVo = sqlSession.selectOne("ay.selectOneRList2", rsNo);

		System.out.println(reviewVo);

		return reviewVo;

	}

	// 리뷰1개 가져오기
	public List<ReviewVo> getSaveName(int rsNo) {
		System.out.println("AYDao.getOnerList2()");
		List<ReviewVo> reviewList = sqlSession.selectList("ay.reviewSaveNameList", rsNo);

		System.out.println(reviewList);

		return reviewList;

	}

	public List<ReviewVo> getSaveName2(int rNo) {
		System.out.println("AYDao.getSaveName2()");
		List<ReviewVo> reviewList = sqlSession.selectList("ay.reviewSaveNameList2", rNo);

		System.out.println(reviewList);

		return reviewList;

	}

	public List<ReviewVo> recentOrder(int bNo) {
		System.out.println("AYDao.recentOrder()");
		List<ReviewVo> reviewList = sqlSession.selectList("ay.recentOrder", bNo);

		System.out.println(reviewList);

		return reviewList;

	}

	public List<ReviewVo> Vieworder(int bNo) {
		System.out.println("AYDao.Vieworder()");
		List<ReviewVo> reviewList = sqlSession.selectList("ay.Vieworder", bNo);

		System.out.println(reviewList);

		return reviewList;

	}

	public List<ReviewVo> Stargradeorder(int bNo) {
		System.out.println("AYDao.Stargradeorder()");
		List<ReviewVo> reviewList = sqlSession.selectList("ay.Stargradeorder", bNo);

		System.out.println(reviewList);

		return reviewList;

	}

	public List<PointVo> getPointList(int uNo) {
		System.out.println("AYDao.getPointList()");
		List<PointVo> pointList = sqlSession.selectList("ay.getPointList", uNo);

		System.out.println(pointList);

		return pointList;

	}

	public List<PointVo> getDataByDateRange(PointVo pointVo) {
		System.out.println("AYDao.getDataByDateRange()");
		
		List<PointVo> pointList = sqlSession.selectList("ay.getDataByDateRange", pointVo);

		System.out.println(pointList);

		return pointList;

	}

}