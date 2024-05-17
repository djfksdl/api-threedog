package com.javaex.vo;

public class UserVo {
	
	//필드
	
	private int uNo;
	private String uId;
	
	//생성자
	public UserVo() {
		super();
	}

	public UserVo(int uNo, String uId) {
		super();
		this.uNo = uNo;
		this.uId = uId;
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

	
	//메소드-일반
	@Override
	public String toString() {
		return "UserVo [uNo=" + uNo + ", uId=" + uId + "]";
	}
	

}
