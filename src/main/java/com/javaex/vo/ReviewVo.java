package com.javaex.vo;

public class ReviewVo {

	private int rNo;
	private int bNo;
	private int uNo;
	private int star;
	private String rContent;
	private String rDate;
	private int views;
	private int riNo;
	private String saveName;
	private String orgName;
	private int fileSize;
	private String filePath;

	public ReviewVo() {
		super();
	}

	public ReviewVo(int rNo, int bNo, int uNo, int star, String rContent, String rDate, int views, int riNo,
			String saveName, String orgName, int fileSize, String filePath) {
		super();
		this.rNo = rNo;
		this.bNo = bNo;
		this.uNo = uNo;
		this.star = star;
		this.rContent = rContent;
		this.rDate = rDate;
		this.views = views;
		this.riNo = riNo;
		this.saveName = saveName;
		this.orgName = orgName;
		this.fileSize = fileSize;
		this.filePath = filePath;
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

	public int getRiNo() {
		return riNo;
	}

	public void setRiNo(int riNo) {
		this.riNo = riNo;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "ReviewVo [rNo=" + rNo + ", bNo=" + bNo + ", uNo=" + uNo + ", star=" + star + ", rContent=" + rContent
				+ ", rDate=" + rDate + ", views=" + views + ", riNo=" + riNo + ", saveName=" + saveName + ", orgName="
				+ orgName + ", fileSize=" + fileSize + ", filePath=" + filePath + "]";
	}

}
