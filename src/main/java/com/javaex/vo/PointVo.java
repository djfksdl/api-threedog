package com.javaex.vo;

public class PointVo {

	private int pNo;
	private int uNo;
	private String pDate;
	private boolean pDiv;
	private int rsNum;
	private int rvNum;
	private int usePoint;

	public PointVo() {
		super();
	}

	public PointVo(int pNo, int uNo, String pDate, boolean pDiv, int rsNum, int rvNum, int usePoint) {
		super();
		this.pNo = pNo;
		this.uNo = uNo;
		this.pDate = pDate;
		this.pDiv = pDiv;
		this.rsNum = rsNum;
		this.rvNum = rvNum;
		this.usePoint = usePoint;
	}

	public int getpNo() {
		return pNo;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public int getuNo() {
		return uNo;
	}

	public void setuNo(int uNo) {
		this.uNo = uNo;
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

	@Override
	public String toString() {
		return "PointVo [pNo=" + pNo + ", uNo=" + uNo + ", pDate=" + pDate + ", pDiv=" + pDiv + ", rsNum=" + rsNum
				+ ", rvNum=" + rvNum + ", usePoint=" + usePoint + "]";
	}

}
