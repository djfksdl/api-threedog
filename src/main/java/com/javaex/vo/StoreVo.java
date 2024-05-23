package com.javaex.vo;

public class StoreVo {

	private int bNo;
	private String title;
	private String logo;
	private double lat;
	private double lan;
	private String rsDate;
	private double distance;
	
	public StoreVo() {
		super();
	}
	
	
	public StoreVo(double lat, double lan) {
		super();
		this.lat = lat;
		this.lan = lan;
	}


	public StoreVo(double lat, double lan, String rsDate) {
		super();
		this.lat = lat;
		this.lan = lan;
		this.rsDate = rsDate;
	}

	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLan() {
		return lan;
	}
	public void setLan(double lan) {
		this.lan = lan;
	}
	public String getRsDate() {
		return rsDate;
	}
	public void setRsDate(String rsDate) {
		this.rsDate = rsDate;
	}
	
	@Override
	public String toString() {
		return "StoreVo [bNo=" + bNo + ", title=" + title + ", logo=" + logo + ", lat=" + lat + ", lan=" + lan
				+ ", rsDate=" + rsDate + ", distance=" + distance + "]";
	}
	
	
	
}
