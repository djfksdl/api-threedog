package com.javaex.vo;

public class StatsVo {

	private int bNo;
	private int week;
	private int month;
	private int year;
	private int totalPrice;
	
	public StatsVo() {
		super();
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}
	
	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "StatsVo [bNo=" + bNo + ", week=" + week + ", month=" + month + ", year=" + year + ", totalPrice="
				+ totalPrice + "]";
	}
	
}
