package com.javaex.vo;

public class BusinessVo {

	private int bNo;
	private String bId;
	private String bPw;
	private String bNum;
	private String bZipCode;
	private String bAddress;
	private String bdAddress;
	private String bPhone;
	private double latitude;
	private double longitude;
	private double averageStar;
	private String logo;
	private String title;
	private String subTitle;
	private String dName;
	private String introduce;
	private String dProfile;
	private String  job;
	private String utilTime;

//	생성자
	public BusinessVo() {
		super();
	}

public BusinessVo(int bNo, String bId, String bPw, String bNum, String bZipCode, String bAddress, String bdAddress,
			String bPhone, double latitude, double longitude, double averageStar, String logo, String title,
			String subTitle, String dName, String introduce, String dProfile, String job,  String utilTime) {
		super();
		this.bNo = bNo;
		this.bId = bId;
		this.bPw = bPw;
		this.bNum = bNum;
		this.bZipCode = bZipCode;
		this.bAddress = bAddress;
		this.bdAddress = bdAddress;
		this.bPhone = bPhone;
		this.latitude = latitude;
		this.longitude = longitude;
		this.averageStar = averageStar;
		this.logo = logo;
		this.title = title;
		this.subTitle = subTitle;
		this.dName = dName;
		this.introduce = introduce;
		this.dProfile = dProfile;
		this.job = job;
		this.utilTime= utilTime;
	}



	//	메소드-gs
	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getbPw() {
		return bPw;
	}

	public void setbPw(String bPw) {
		this.bPw = bPw;
	}

	public String getbNum() {
		return bNum;
	}

	public void setbNum(String bNum) {
		this.bNum = bNum;
	}

	public String getbZipCode() {
		return bZipCode;
	}

	public void setbZipCode(String bZipCode) {
		this.bZipCode = bZipCode;
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

	public String getbPhone() {
		return bPhone;
	}

	public void setbPhone(String bPhone) {
		this.bPhone = bPhone;
	}

	public double getAverageStar() {
		return averageStar;
	}

	public void setAverageStar(double averageStar) {
		this.averageStar = averageStar;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getdProfile() {
		return dProfile;
	}

	public void setdProfile(String dProfile) {
		this.dProfile = dProfile;
	}
	
	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	
	public String getUtilTime() {
		return utilTime;
	}

	public void setUtilTime(String utilTime) {
		this.utilTime = utilTime;
	}

	
	// 메소드-일반
	@Override
	public String toString() {
		return "BusinessVo [bNo=" + bNo + ", bId=" + bId + ", bPw=" + bPw + ", bNum=" + bNum + ", bZipCode=" + bZipCode
				+ ", bAddress=" + bAddress + ", bdAddress=" + bdAddress + ", bPhone=" + bPhone + ", latitude="
				+ latitude + ", longitude=" + longitude + ", averageStar=" + averageStar + ", logo=" + logo + ", title="
				+ title + ", subTitle=" + subTitle + ", dName=" + dName + ", introduce=" + introduce + ", dProfile="
				+ dProfile + ", job=" + job + ", utilTime=" + utilTime + "]";
	}








	

	

}
