package com.javaex.vo;

public class PointVo {

	private int uNo;
	private int pNo;
	private String pDate;
	private String rDate;
	private String startDate;
	private String endDate;
	private boolean pDiv;
	private int rsNum;
	private int rvNum;
	private int usePoint;
	private int bNo;
	private String title;

	public PointVo() {
		super();
	}
	
	

	public PointVo(int uNo, String startDate, String endDate) {
		super();
		this.uNo = uNo;
		this.startDate = startDate;
		this.endDate = endDate;
	}



	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	public boolean ispDiv() {
		return pDiv;
	}

	public void setpDiv(boolean pDiv) {
		this.pDiv = pDiv;
	}

	public int getRsNum() {
		return rsNum;
	}

	public void setRsNum(int rsNum) {
		this.rsNum = rsNum;
	}

	public int getRvNum() {
		return rvNum;
	}

	public void setRvNum(int rvNum) {
		this.rvNum = rvNum;
	}

	public int getUsePoint() {
		return usePoint;
	}

	public void setUsePoint(int usePoint) {
		this.usePoint = usePoint;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getrDate() {
		return rDate;
	}

	public void setrDate(String rDate) {
		this.rDate = rDate;
	}

	@Override
	public String toString() {
		return "PointVo [uNo=" + uNo + ", pNo=" + pNo + ", pDate=" + pDate + ", rDate=" + rDate + ", startDate="
				+ startDate + ", endDate=" + endDate + ", pDiv=" + pDiv + ", rsNum=" + rsNum + ", rvNum=" + rvNum
				+ ", usePoint=" + usePoint + ", bNo=" + bNo + ", title=" + title + "]";
	}

}
