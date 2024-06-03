package com.javaex.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ReserveVo {

	// 필드
	private int rsNo;
	private int bNo;
	private int dogNo;
	private int rtNo;
	private String rtDate;
	private String rtTime;
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
	private int rspNo;
	private int priceNo;
	private int beautyNo;
	private Integer onePrice;
	private String sizeDiv;
	private String weightDiv;
	private String beauty;
	private int aiNo;
	private String saveName;
	private int pushNo;
	private String pushTime;
	private List<MultipartFile> files;
	private MultipartFile signFile;
	private List<String> beautyPlus;
	private Boolean rtFinish;
	private int rNo;

	private int rsNum;
	private int usePoint;
	private List<Integer> priceNoPlus;
	private List<String> rtDates;
	private List<String> rtTimes;
	private String title;

	private String bPhone;
	private String bAddress;
	private String bdAddress;

	// 생성자
	public ReserveVo() {
		super();
	}

	public ReserveVo(int bNo, String rtDate) {
		super();
		this.bNo = bNo;
		this.rtDate = rtDate;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public String getbPhone() {
		return bPhone;
	}

	public void setbPhone(String bPhone) {
		this.bPhone = bPhone;
	}

	public String getbAddress() {
		return bAddress;
	}

	public void setbAddress(String bAddress) {
		this.bAddress = bAddress;
	}

	public String getBdAddress() {
		return bdAddress;
	}

	public void setBdAddress(String bdAddress) {
		this.bdAddress = bdAddress;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getRsNum() {
		return rsNum;
	}

	public void setRsNum(int rsNum) {
		this.rsNum = rsNum;
	}

	public Boolean getRtFinish() {
		return rtFinish;
	}

	public void setRtFinish(Boolean rtFinish) {
		this.rtFinish = rtFinish;
	}

	public MultipartFile getSignFile() {
		return signFile;
	}

	public void setSignFile(MultipartFile signFile) {
		this.signFile = signFile;
	}

	public List<String> getBeautyPlus() {
		return beautyPlus;
	}

	public void setBeautyPlus(List<String> beautyPlus) {
		this.beautyPlus = beautyPlus;
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

	public int getRtNo() {
		return rtNo;
	}

	public void setRtNo(int rtNo) {
		this.rtNo = rtNo;
	}

	public String getRtDate() {
		return rtDate;
	}

	public void setRtDate(String rtDate) {
		this.rtDate = rtDate;
	}

	public String getRtTime() {
		return rtTime;
	}

	public void setRtTime(String rtTime) {
		this.rtTime = rtTime;
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

	public int getRspNo() {
		return rspNo;
	}

	public void setRspNo(int rspNo) {
		this.rspNo = rspNo;
	}

	public int getPriceNo() {
		return priceNo;
	}

	public void setPriceNo(int priceNo) {
		this.priceNo = priceNo;
	}

	public int getBeautyNo() {
		return beautyNo;
	}

	public void setBeautyNo(int beautyNo) {
		this.beautyNo = beautyNo;
	}

	public Integer getOnePrice() {
		return onePrice;
	}

	public void setOnePrice(Integer onePrice) {
		this.onePrice = onePrice;
	}

	public int getUsePoint() {
		return usePoint;
	}

	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}

	public String getSizeDiv() {
		return sizeDiv;
	}

	public void setSizeDiv(String sizeDiv) {
		this.sizeDiv = sizeDiv;
	}

	public String getWeightDiv() {
		return weightDiv;
	}

	public void setWeightDiv(String weightDiv) {
		this.weightDiv = weightDiv;
	}

	public String getBeauty() {
		return beauty;
	}

	public void setBeauty(String beauty) {
		this.beauty = beauty;
	}

	public int getAiNo() {
		return aiNo;
	}

	public void setAiNo(int aiNo) {
		this.aiNo = aiNo;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public int getPushNo() {
		return pushNo;
	}

	public void setPushNo(int pushNo) {
		this.pushNo = pushNo;
	}

	public String getPushTime() {
		return pushTime;
	}

	public void setPushTime(String pushTime) {
		this.pushTime = pushTime;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public List<Integer> getPriceNoPlus() {
		return priceNoPlus;
	}

	public void setPriceNoPlus(List<Integer> priceNoPlus) {
		this.priceNoPlus = priceNoPlus;
	}

	public List<String> getRtDates() {
		return rtDates;
	}

	public void setRtDates(List<String> rtDates) {
		this.rtDates = rtDates;
	}

	public List<String> getRtTimes() {
		return rtTimes;
	}

	public void setRtTimes(List<String> rtTimes) {
		this.rtTimes = rtTimes;
	}

	@Override
	public String toString() {
		return "ReserveVo [rsNo=" + rsNo + ", bNo=" + bNo + ", dogNo=" + dogNo + ", rtNo=" + rtNo + ", rtDate=" + rtDate
				+ ", rtTime=" + rtTime + ", signImg=" + signImg + ", expectedPrice=" + expectedPrice + ", attitude="
				+ attitude + ", rCondition=" + rCondition + ", tangle=" + tangle + ", disliked=" + disliked + ", bath="
				+ bath + ", surcharge=" + surcharge + ", message=" + message + ", currentWeight=" + currentWeight
				+ ", dogName=" + dogName + ", kind=" + kind + ", weight=" + weight + ", birth=" + birth + ", gender="
				+ gender + ", neutering=" + neutering + ", experience=" + experience + ", bite=" + bite + ", memo="
				+ memo + ", dogImg=" + dogImg + ", size=" + size + ", skin=" + skin + ", heart=" + heart + ", marking="
				+ marking + ", mounting=" + mounting + ", uNo=" + uNo + ", rspNo=" + rspNo + ", priceNo=" + priceNo
				+ ", beautyNo=" + beautyNo + ", onePrice=" + onePrice + ", sizeDiv=" + sizeDiv + ", weightDiv="
				+ weightDiv + ", beauty=" + beauty + ", aiNo=" + aiNo + ", saveName=" + saveName + ", pushNo=" + pushNo
				+ ", pushTime=" + pushTime + ", files=" + files + ", signFile=" + signFile + ", beautyPlus="
				+ beautyPlus + ", rtFinish=" + rtFinish + ", rNo=" + rNo + ", rsNum=" + rsNum + ", usePoint=" + usePoint
				+ ", priceNoPlus=" + priceNoPlus + ", rtDates=" + rtDates + ", rtTimes=" + rtTimes + ", title=" + title
				+ ", bPhone=" + bPhone + ", bAddress=" + bAddress + ", bdAddress=" + bdAddress + "]";
	}

}