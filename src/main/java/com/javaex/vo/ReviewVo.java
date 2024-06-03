package com.javaex.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ReviewVo {

	// 리뷰
	private int rNo;
	private int bNo;
	private int uNo;
	private int star;
	private String rContent;
	private String rDate;
	private int views;
	private int riNo;
	private int imgCount;
	private String orgName;
	private String filePath;
	private int userPoint;
	private int rsNo;
	private String saveName;
	private int uPoint;
	private List<String> saveNameList;
	private List<MultipartFile> file;

	// 반려견정보
	private int dogNo;
	private String dogName;
	private double weight;

	// 예약
	private int expectedPrice;
	private int surcharge;
	private String beauty;
	private String uId;
	private String title;

	public int getSurcharge() {
		return surcharge;
	}

	public void setSurcharge(int surcharge) {
		this.surcharge = surcharge;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getuPoint() {
		return uPoint;
	}

	public void setuPoint(int uPoint) {
		this.uPoint = uPoint;
	}

	public ReviewVo() {
		super();
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getBeauty() {
		return beauty;
	}

	public void setBeauty(String beauty) {
		this.beauty = beauty;
	}

	public int getDogNo() {
		return dogNo;
	}

	public void setDogNo(int dogNo) {
		this.dogNo = dogNo;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getExpectedPrice() {
		return expectedPrice;
	}

	public void setExpectedPrice(int expectedPrice) {
		this.expectedPrice = expectedPrice;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getrDate() {
		return rDate;
	}

	public void setrDate(String rDate) {
		this.rDate = rDate;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getRiNo() {
		return riNo;
	}

	public void setRiNo(int riNo) {
		this.riNo = riNo;
	}

	public int getImgCount() {
		return imgCount;
	}

	public void setImgCount(int imgCount) {
		this.imgCount = imgCount;
	}

	public List<String> getSaveNameList() {
		return saveNameList;
	}

	public void setSaveNameList(List<String> saveNameList) {
		this.saveNameList = saveNameList;
	}

	public List<MultipartFile> getFile() {
		return file;
	}

	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	public int getRsNo() {
		return rsNo;
	}

	public void setRsNo(int rsNo) {
		this.rsNo = rsNo;
	}

	@Override
	public String toString() {
		return "ReviewVo [rNo=" + rNo + ", bNo=" + bNo + ", uNo=" + uNo + ", star=" + star + ", rContent=" + rContent
				+ ", rDate=" + rDate + ", views=" + views + ", riNo=" + riNo + ", imgCount=" + imgCount + ", orgName="
				+ orgName + ", filePath=" + filePath + ", userPoint=" + userPoint + ", rsNo=" + rsNo + ", saveName="
				+ saveName + ", uPoint=" + uPoint + ", saveNameList=" + saveNameList + ", file=" + file + ", dogNo="
				+ dogNo + ", dogName=" + dogName + ", weight=" + weight + ", expectedPrice=" + expectedPrice
				+ ", surcharge=" + surcharge + ", beauty=" + beauty + ", uId=" + uId + ", title=" + title + "]";
	}

}
