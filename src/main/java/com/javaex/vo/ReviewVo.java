package com.javaex.vo;

public class ReviewVo {

	private int rNo;
	private int bNo;
	private int uNo;
	private int star;
	private String rContent;
	private String rDate;

	public ReviewVo() {
		super();
	}

	public ReviewVo(int rNo, int bNo, int uNo, int star, String rContent, String rDate) {
		super();
		this.rNo = rNo;
		this.bNo = bNo;
		this.uNo = uNo;
		this.star = star;
		this.rContent = rContent;
		this.rDate = rDate;
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

	@Override
	public String toString() {
		return "ReviewVo [rNo=" + rNo + ", bNo=" + bNo + ", uNo=" + uNo + ", star=" + star + ", rContent=" + rContent
				+ ", rDate=" + rDate + "]";
	}

}
