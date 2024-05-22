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
    private Double currentWeight;
    private String dogName;
    private String kind;
    private double weight;
    private String birth;
    private String gender;
    private Boolean neutering;
    private Boolean experience;
    private Integer bite;
    private String memo;
    private String dogImg;
    private String size;
    private Boolean skin;
    private Boolean heart;
    private Boolean marking;
    private Boolean mounting;
    private int uNo;
    
    // 생성자
    public ReserveVo() {
        super();
    }

    public ReserveVo(int rsNo, int bNo, int dogNo, String rsDate, String rsTime, String signImg, int expectedPrice,
                     String attitude, String rCondition, String tangle, String disliked, String bath, Integer surcharge,
                     String message, Double currentWeight, String dogName, String kind, double weight, String birth,
                     String gender, Boolean neutering, Boolean experience, Integer bite, String memo, String dogImg, String size,
                     Boolean skin, Boolean heart, Boolean marking, Boolean mounting,int uNo) {
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
        this.currentWeight = currentWeight;
        this.dogName = dogName;
        this.kind = kind;
        this.weight = weight;
        this.birth = birth;
        this.gender = gender;
        this.neutering = neutering;
        this.experience = experience;
        this.bite = bite;
        this.memo = memo;
        this.dogImg = dogImg;
        this.size = size;
        this.skin = skin;
        this.heart = heart;
        this.marking = marking;
        this.mounting = mounting;
        this.uNo = uNo;
        
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

	public Double getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(Double currentWeight) {
		this.currentWeight = currentWeight;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Boolean getNeutering() {
		return neutering;
	}

	public void setNeutering(Boolean neutering) {
		this.neutering = neutering;
	}

	public Boolean getExperience() {
		return experience;
	}

	public void setExperience(Boolean experience) {
		this.experience = experience;
	}

	public Integer getBite() {
		return bite;
	}

	public void setBite(Integer bite) {
		this.bite = bite;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDogImg() {
		return dogImg;
	}

	public void setDogImg(String dogImg) {
		this.dogImg = dogImg;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Boolean getSkin() {
		return skin;
	}

	public void setSkin(Boolean skin) {
		this.skin = skin;
	}

	public Boolean getHeart() {
		return heart;
	}

	public void setHeart(Boolean heart) {
		this.heart = heart;
	}

	public Boolean getMarking() {
		return marking;
	}

	public void setMarking(Boolean marking) {
		this.marking = marking;
	}

	public Boolean getMounting() {
		return mounting;
	}

	public void setMounting(Boolean mounting) {
		this.mounting = mounting;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	@Override
	public String toString() {
		return "ReserveVo [rsNo=" + rsNo + ", bNo=" + bNo + ", dogNo=" + dogNo + ", rsDate=" + rsDate + ", rsTime="
				+ rsTime + ", signImg=" + signImg + ", expectedPrice=" + expectedPrice + ", attitude=" + attitude
				+ ", rCondition=" + rCondition + ", tangle=" + tangle + ", disliked=" + disliked + ", bath=" + bath
				+ ", surcharge=" + surcharge + ", message=" + message + ", currentWeight=" + currentWeight
				+ ", dogName=" + dogName + ", kind=" + kind + ", weight=" + weight + ", birth=" + birth + ", gender="
				+ gender + ", neutering=" + neutering + ", experience=" + experience + ", bite=" + bite + ", memo="
				+ memo + ", dogImg=" + dogImg + ", size=" + size + ", skin=" + skin + ", heart=" + heart + ", marking="
				+ marking + ", mounting=" + mounting + ", uNo=" + uNo + "]";
	}

    
}