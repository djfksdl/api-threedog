package com.javaex.vo;

public class PointVo {

	private int uNo;
	private int pNo;
	private String pDate;
	private boolean pDiv;
	private int rsNum;
	private int rvNum;
	private int usePoint;
	private int bNo;
	private String title;

	public PointVo() {
		super();
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

	@Override
	public String toString() {
		return "PointVo [uNo=" + uNo + ", pNo=" + pNo + ", pDate=" + pDate + ", pDiv=" + pDiv + ", rsNum=" + rsNum
				+ ", rvNum=" + rvNum + ", usePoint=" + usePoint + ", bNo=" + bNo + ", title=" + title + "]";
	}

}
