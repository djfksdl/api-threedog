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
	
	public BusinessVo() {
		super();
	}


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

	@Override
	public String toString() {
		return "BusinessVo [bNo=" + bNo + ", bId=" + bId + ", bPw=" + bPw + ", bNum=" + bNum + ", bZipCode=" + bZipCode
				+ ", bAddress=" + bAddress + ", bdAddress=" + bdAddress + ", bPhone=" + bPhone + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}
	
	
}
