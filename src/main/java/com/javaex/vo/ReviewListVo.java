package com.javaex.vo;

public class ReviewListVo {

	private int rNo;
	private int star;
	private String title;
	private String saveName;
	
	public ReviewListVo() {
		super();
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
		return "ReviewListVo [rNo=" + rNo + ", star=" + star + ", title=" + title + ", saveName=" + saveName + "]";
	}
}
