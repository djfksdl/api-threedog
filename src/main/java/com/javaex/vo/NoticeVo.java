package com.javaex.vo;

public class NoticeVo {
	
	private int no;
	private String title;
	private String content;
	private String regDate;
	private int uNo;
	private String uName;
	
	public NoticeVo() {
	}
	public NoticeVo(int no, String title, String content, String regDate, int uNo, String uName) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.uNo=uNo;
		this.uName=uName;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getUNo() {
		return uNo;
	}
	public void setUNo(int uNo) {
		this.uNo = uNo;
	}
	public String getUName() {
		return uName;
	}
	public void setUName(String uName) {
		this.uName = uName;
	}
	
	@Override
	public String toString() {
		return "NoticeVo [no=" + no + ", title=" + title + ", content=" + content + ", regDate=" + regDate + ", uNo=" + uNo + ", uName=" + uName + "]";
	}

}
