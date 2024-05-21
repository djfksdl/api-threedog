package com.javaex.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ReviewVo {

	private int rNo;
	private int bNo;
	private int uNo;
	private int star;
	private String rContent;
	private String rDate;
	private int views;
	private int riNo;
	private int imgCount;
	private String orgName;
	private String filePath;
	private int userPoint;

	private List<String> saveNameList;
	private List<MultipartFile> file;

	public ReviewVo() {
		super();
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
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

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getRiNo() {
		return riNo;
	}

	public void setRiNo(int riNo) {
		this.riNo = riNo;
	}

	public int getImgCount() {
		return imgCount;
	}

	public void setImgCount(int imgCount) {
		this.imgCount = imgCount;
	}

	public List<String> getSaveNameList() {
		return saveNameList;
	}

	public void setSaveNameList(List<String> saveNameList) {
		this.saveNameList = saveNameList;
	}

	public List<MultipartFile> getFile() {
		return file;
	}

	public void setFile(List<MultipartFile> file) {
		this.file = file;
	}

	public int getUserPoint() {
		return userPoint;
	}

	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}

	@Override
	public String toString() {
		return "ReviewVo [rNo=" + rNo + ", bNo=" + bNo + ", uNo=" + uNo + ", star=" + star + ", rContent=" + rContent
				+ ", rDate=" + rDate + ", views=" + views + ", riNo=" + riNo + ", imgCount=" + imgCount + ", orgName="
				+ orgName + ", filePath=" + filePath + ", userPoint=" + userPoint + ", saveNameList=" + saveNameList
				+ ", file=" + file + "]";
	}



}
