package com.javaex.vo;

public class UserVo {
	
	//필드
	
	private int uNo;
	private String uId;
	private String uPw;
	private String uName;
	private String uPhone;
	private String uZipCode;
	private String uAddress;
	private String uDetailAddress;
	private int uPoint;
	private String uProfile;
	
	//생성자
	public UserVo() {
		super();
	}

	public UserVo(int uNo, String uId, String uPw, String uName, String uPhone, String uZipCode, String uAddress,
			String uDetailAddress, int uPoint, String uProfile) {
		super();
		this.uNo = uNo;
		this.uId = uId;
		this.uPw = uPw;
		this.uName = uName;
		this.uPhone = uPhone;
		this.uZipCode = uZipCode;
		this.uAddress = uAddress;
		this.uDetailAddress = uDetailAddress;
		this.uPoint = uPoint;
		this.uProfile = uProfile;
	}

		
	//메소드-gs

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPw() {
		return uPw;
	}

	public void setuPw(String uPw) {
		this.uPw = uPw;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	public String getuZipCode() {
		return uZipCode;
	}

	public void setuZipCode(String uZipCode) {
		this.uZipCode = uZipCode;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public String getuDetailAddress() {
		return uDetailAddress;
	}

	public void setuDetailAddress(String uDetailAddress) {
		this.uDetailAddress = uDetailAddress;
	}

	public int getuPoint() {
		return uPoint;
	}

	public void setuPoint(int uPoint) {
		this.uPoint = uPoint;
	}

	public String getuProfile() {
		return uProfile;
	}

	public void setuProfile(String uProfile) {
		this.uProfile = uProfile;
	}

	
	//메소드-일반
	@Override
	public String toString() {
		return "UserVo [uNo=" + uNo + ", uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + ", uPhone=" + uPhone
				+ ", uZipCode=" + uZipCode + ", uAddress=" + uAddress + ", uDetailAddress=" + uDetailAddress
				+ ", uPoint=" + uPoint + ", uProfile=" + uProfile + "]";
	}

}
