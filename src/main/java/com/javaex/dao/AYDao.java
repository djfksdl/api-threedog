package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BusinessVo;
import com.javaex.vo.DogVo;
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

	// 리뷰등록
	public void addReview(ReviewVo reviewVo) {
		System.out.println("AYDao.addReview()");

		// 리뷰 정보를 먼저 등록
		sqlSession.insert("ay.addReview01", reviewVo);
		sqlSession.update("ay.insertPoint", reviewVo);
		// 등록된 리뷰의 rNo를 가져옴
		int rNo = reviewVo.getrNo();

		// 리뷰 이미지 정보를 등록
		for (String saveName : reviewVo.getSaveNameList()) {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("rNo", rNo);
			paramMap.put("saveName", saveName);
			System.out.println(saveName);
//			paramMap.put("orgName", reviewVo.getOrgName());
//			paramMap.put("filePath", reviewVo.getFilePath());

			sqlSession.insert("ay.addReview02", paramMap);
		}

		System.out.println("성공");
	}

	// 가게리스트
	public List<ReviewVo> getRList(int bNo) {
		System.out.println("AYDao.getRList");
		List<ReviewVo> reviewVo = sqlSession.selectList("ay.reviewSelect", bNo);

		return reviewVo;
	}

	// 가게정보 가져오기
	public BusinessVo getBList(int bNo) {
		System.out.println("AYDao.getBList()");
		BusinessVo businessVo = sqlSession.selectOne("ay.selectOne", bNo);

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

	// 예약하기
	public String reserveInsert(ReserveVo reserveVo) {
		System.out.println("AYDao.reserveInsert()");
		System.out.println(reserveVo);

		// 예약테이블 등록
//		sqlSession.insert("ay.reserveInsert", reserveVo);
//
//		// 예약시간테이블 수정
//		sqlSession.update("ay.reserveTime", reserveVo);
//
//		// 포인터테이블 등록
//		sqlSession.insert("ay.reservePoint", reserveVo);
//
//		// 반려견테이블 수정
//		sqlSession.update("ay.reserveDog", reserveVo);
//
//		// 예약가격테이블 등록
//		sqlSession.insert("ay.reservePrice)", reserveVo);

		return reserveVo.getSignImg();
	}
}