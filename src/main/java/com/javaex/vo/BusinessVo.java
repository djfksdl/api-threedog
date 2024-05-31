package com.javaex.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BusinessVo {

	private int bNo;
	private String bId;
	private String bPw;
	private String bNum;
	private String bZipCode;
	private String bAddress;
	private String bdAddress;
	private String bPhone;
	private double latitude;
	private double longitude;
	private double averageStar;
	private String title;
	private String subTitle;
	private String dName;
	private String introduce;
	private String job;
	private MultipartFile logoFile;
	private String logo; // 파일받는건 logoFile로 하고, 넣는건 새로 만들어서 넣어주면 됨. 동시에 받고 넣는건 안된다.자료형도 달라서 안되긴함.
	private MultipartFile dProfileFile;
	private String dProfile;
	private List<MultipartFile> slideImgs;
	private List<String> slideImgsSaveName;
	private List<MultipartFile> cutImgs;
	private List<String> cutImgsSaveName;

	private List<PriceVo> priceList;

	private List<Integer> hiNos;
	private List<Integer> delSlideHiNos;
	private List<Integer> delCutHiNos;

//	생성자
	public BusinessVo() {
		super();
	}

	public BusinessVo(int bNo, String bId, String bPw, String bNum, String bZipCode, String bAddress, String bdAddress,
			String bPhone, double latitude, double longitude, double averageStar, String title, String subTitle,
			String dName, String introduce, String job, MultipartFile logoFile, String logo, MultipartFile dProfileFile,
			String dProfile, List<MultipartFile> slideImgs, List<String> slideImgsSaveName, List<MultipartFile> cutImgs,
			List<String> cutImgsSaveName, List<PriceVo> priceList, List<Integer> hiNos, List<Integer> delSlideHiNos,
			List<Integer> delCutHiNos) {
		super();
		this.bNo = bNo;
		this.bId = bId;
		this.bPw = bPw;
		this.bNum = bNum;
		this.bZipCode = bZipCode;
		this.bAddress = bAddress;
		this.bdAddress = bdAddress;
		this.bPhone = bPhone;
		this.latitude = latitude;
		this.longitude = longitude;
		this.averageStar = averageStar;
		this.title = title;
		this.subTitle = subTitle;
		this.dName = dName;
		this.introduce = introduce;
		this.job = job;
		this.logoFile = logoFile;
		this.logo = logo;
		this.dProfileFile = dProfileFile;
		this.dProfile = dProfile;
		this.slideImgs = slideImgs;
		this.slideImgsSaveName = slideImgsSaveName;
		this.cutImgs = cutImgs;
		this.cutImgsSaveName = cutImgsSaveName;
		this.priceList = priceList;
		this.hiNos = hiNos;
		this.delSlideHiNos = delSlideHiNos;
		this.delCutHiNos = delCutHiNos;
	}

	// 메소드-gs
	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbId() {
		return bId;
	}

	public void setbId(String bId) {
		this.bId = bId;
	}

	public String getbPw() {
		return bPw;
	}

	public void setbPw(String bPw) {
		this.bPw = bPw;
	}

	public String getbNum() {
		return bNum;
	}

	public void setbNum(String bNum) {
		this.bNum = bNum;
	}

	public String getbZipCode() {
		return bZipCode;
	}

	public void setbZipCode(String bZipCode) {
		this.bZipCode = bZipCode;
	}

	public String getbAddress() {
		return bAddress;
	}

	public void setbAddress(String bAddress) {
		this.bAddress = bAddress;
	}

	public String getBdAddress() {
		return bdAddress;
	}

	public void setBdAddress(String bdAddress) {
		this.bdAddress = bdAddress;
	}

	public String getbPhone() {
		return bPhone;
	}

	public void setbPhone(String bPhone) {
		this.bPhone = bPhone;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getAverageStar() {
		return averageStar;
	}

	public void setAverageStar(double averageStar) {
		this.averageStar = averageStar;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public MultipartFile getLogoFile() {
		return logoFile;
	}

	public void setLogoFile(MultipartFile logoFile) {
		this.logoFile = logoFile;
	}

	public List<MultipartFile> getSlideImgs() {
		return slideImgs;
	}

	public void setSlideImgs(List<MultipartFile> slideImgs) {
		this.slideImgs = slideImgs;
	}

	public List<MultipartFile> getCutImgs() {
		return cutImgs;
	}

	public void setCutImgs(List<MultipartFile> cutImgs) {
		this.cutImgs = cutImgs;
	}

	public MultipartFile getdProfileFile() {
		return dProfileFile;
	}

	public void setdProfileFile(MultipartFile dProfileFile) {
		this.dProfileFile = dProfileFile;
	}

	public List<PriceVo> getPriceList() {
		return priceList;
	}

	public void setPriceList(List<PriceVo> priceList) {
		this.priceList = priceList;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getdProfile() {
		return dProfile;
	}

	public void setdProfile(String dProfile) {
		this.dProfile = dProfile;
	}

	public List<String> getSlideImgsSaveName() {
		return slideImgsSaveName;
	}

	public void setSlideImgsSaveName(List<String> slideImgsSaveName) {
		this.slideImgsSaveName = slideImgsSaveName;
	}

	public List<String> getCutImgsSaveName() {
		return cutImgsSaveName;
	}

	public void setCutImgsSaveName(List<String> cutImgsSaveName) {
		this.cutImgsSaveName = cutImgsSaveName;
	}

	public List<Integer> getHiNos() {
		return hiNos;
	}

	public void setHiNos(List<Integer> hiNos) {
		this.hiNos = hiNos;
	}

	public List<Integer> getDelSlideHiNos() {
		return delSlideHiNos;
	}

	public void setDelSlideHiNos(List<Integer> delSlideHiNos) {
		this.delSlideHiNos = delSlideHiNos;
	}

	public List<Integer> getDelCutHiNos() {
		return delCutHiNos;
	}

	public void setDelCutHiNos(List<Integer> delCutHiNos) {
		this.delCutHiNos = delCutHiNos;
	}

	// 메소드-일반
	@Override
	public String toString() {
		return "BusinessVo [bNo=" + bNo + ", bId=" + bId + ", bPw=" + bPw + ", bNum=" + bNum + ", bZipCode=" + bZipCode
				+ ", bAddress=" + bAddress + ", bdAddress=" + bdAddress + ", bPhone=" + bPhone + ", latitude="
				+ latitude + ", longitude=" + longitude + ", averageStar=" + averageStar + ", title=" + title
				+ ", subTitle=" + subTitle + ", dName=" + dName + ", introduce=" + introduce + ", job=" + job
				+ ", logoFile=" + logoFile + ", logo=" + logo + ", dProfileFile=" + dProfileFile + ", dProfile="
				+ dProfile + ", slideImgs=" + slideImgs + ", slideImgsSaveName=" + slideImgsSaveName + ", cutImgs="
				+ cutImgs + ", cutImgsSaveName=" + cutImgsSaveName + ", priceList=" + priceList + ", hiNos=" + hiNos
				+ ", delSlideHiNos=" + delSlideHiNos + ", delCutHiNos=" + delCutHiNos + "]";
	}


}