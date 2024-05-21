package com.javaex.vo;

public class ReserveVo {
	// 필드
	private int rsNo;
	private int bNo;
	private int dogNo;
	private String rsDate;
	private String rsTime;
	private String signImg;
	private int expectedPrice;
	private String attitude;
	private String rCondition;
	private String tangle;
	private String disliked;
	private String bath;
	private Integer surcharge;
	private String message;
	private Double curruntWeight;

	// 생성자
	public ReserveVo() {
		super();
	}

	public ReserveVo(int rsNo, int bNo, int dogNo, String rsDate, String rsTime, String signImg, int expectedPrice,
			String attitude, String rCondition, String tangle, String disliked, String bath, Integer surcharge,
			String message, Double curruntWeight) {
		super();
		this.rsNo = rsNo;
		this.bNo = bNo;
		this.dogNo = dogNo;
		this.rsDate = rsDate;
		this.rsTime = rsTime;
		this.signImg = signImg;
		this.expectedPrice = expectedPrice;
		this.attitude = attitude;
		this.rCondition = rCondition;
		this.tangle = tangle;
		this.disliked = disliked;
		this.bath = bath;
		this.surcharge = surcharge;
		this.message = message;
		this.curruntWeight = curruntWeight;
	}

	public int getRsNo() {
		return rsNo;
	}

	public void setRsNo(int rsNo) {
		this.rsNo = rsNo;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public int getDogNo() {
		return dogNo;
	}

	public void setDogNo(int dogNo) {
		this.dogNo = dogNo;
	}

	public String getRsDate() {
		return rsDate;
	}

	public void setRsDate(String rsDate) {
		this.rsDate = rsDate;
	}

	public String getRsTime() {
		return rsTime;
	}

	public void setRsTime(String rsTime) {
		this.rsTime = rsTime;
	}

	public String getSignImg() {
		return signImg;
	}

	public void setSignImg(String signImg) {
		this.signImg = signImg;
	}

	public int getExpectedPrice() {
		return expectedPrice;
	}

	public void setExpectedPrice(int expectedPrice) {
		this.expectedPrice = expectedPrice;
	}

	public String getAttitude() {
		return attitude;
	}

	public void setAttitude(String attitude) {
		this.attitude = attitude;
	}

	public String getrCondition() {
		return rCondition;
	}

	public void setrCondition(String rCondition) {
		this.rCondition = rCondition;
	}

	public String getTangle() {
		return tangle;
	}

	public void setTangle(String tangle) {
		this.tangle = tangle;
	}

	public String getDisliked() {
		return disliked;
	}

	public void setDisliked(String disliked) {
		this.disliked = disliked;
	}

	public String getBath() {
		return bath;
	}

	public void setBath(String bath) {
		this.bath = bath;
	}

	public Integer getSurcharge() {
		return surcharge;
	}

	public void setSurcharge(Integer surcharge) {
		this.surcharge = surcharge;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getCurruntWeight() {
		return curruntWeight;
	}

	public void setCurruntWeight(Double curruntWeight) {
		this.curruntWeight = curruntWeight;
	}

	@Override
	public String toString() {
		return "ReserveVo [rsNo=" + rsNo + ", bNo=" + bNo + ", dogNo=" + dogNo + ", rsDate=" + rsDate + ", rsTime="
				+ rsTime + ", signImg=" + signImg + ", expectedPrice=" + expectedPrice + ", attitude=" + attitude
				+ ", rCondition=" + rCondition + ", tangle=" + tangle + ", disliked=" + disliked + ", bath=" + bath
				+ ", surcharge=" + surcharge + ", message=" + message + ", curruntWeight=" + curruntWeight + "]";
	}

	

}
