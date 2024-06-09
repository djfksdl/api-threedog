package com.javaex.vo;

public class ReviewListVo {

	private int rNo;
	private int star;
	private String title;
	private String saveName;
	private int bNo;
	private String rContent;
	
	public ReviewListVo() {
		super();
	}

	
	
	public String getrContent() {
		return rContent;
	}



	public void setrContent(String rContent) {
		this.rContent = rContent;
	}



	public int getbNo() {
		return bNo;
	}



	public void setbNo(int bNo) {
		this.bNo = bNo;
	}



	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	@Override
	public String toString() {
		return "ReviewListVo [rNo=" + rNo + ", star=" + star + ", title=" + title + ", saveName=" + saveName + ", bNo="
				+ bNo + ", rContent=" + rContent + "]";
	}
}
