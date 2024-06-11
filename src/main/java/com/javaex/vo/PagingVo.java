package com.javaex.vo;

public class PagingVo {
	
	private int crtPage;
	private String keyword;
	private String title;
	
	public PagingVo() {
	}
	public PagingVo(int crtPage, String keyword, String title) {
		this.crtPage = crtPage;
		this.keyword = keyword;
		this.title = title;
	}

	public int getCrtPage() {
		return crtPage;
	}
	public void setCrtPage(int crtPage) {
		this.crtPage = crtPage;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "PagingVo [crtPage=" + crtPage + ", keyword=" + keyword + ", title=" + title + "]";
	}

}
