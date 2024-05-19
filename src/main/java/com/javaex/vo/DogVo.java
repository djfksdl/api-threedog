package com.javaex.vo;

public class DogVo {

	private int dogNo;
	private String dogName;
	private String kind;
	private double weight;
	private String birth;
	private String gender;
	private boolean neutering;
	private boolean experience;
	private int bite;
	private String memo;
	private String dogImg;
	private String size;
	private boolean skin;
	private boolean heart;
	private boolean marking;
	private boolean mounting;

	public DogVo() {
		super();
	}

	public DogVo(int dogNo, String dogName, String kind, double weight, String birth, String gender, boolean neutering,
			boolean experience, int bite, String memo, String dogImg, String size, boolean skin, boolean heart,
			boolean marking, boolean mounting) {
		super();
		this.dogNo = dogNo;
		this.dogName = dogName;
		this.kind = kind;
		this.weight = weight;
		this.birth = birth;
		this.gender = gender;
		this.neutering = neutering;
		this.experience = experience;
		this.bite = bite;
		this.memo = memo;
		this.dogImg = dogImg;
		this.size = size;
		this.skin = skin;
		this.heart = heart;
		this.marking = marking;
		this.mounting = mounting;
	}

	public int getDogNo() {
		return dogNo;
	}

	public void setDogNo(int dogNo) {
		this.dogNo = dogNo;
	}

	public String getDogName() {
		return dogName;
	}

	public void setDogName(String dogName) {
		this.dogName = dogName;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isNeutering() {
		return neutering;
	}

	public void setNeutering(boolean neutering) {
		this.neutering = neutering;
	}

	public boolean isExperience() {
		return experience;
	}

	public void setExperience(boolean experience) {
		this.experience = experience;
	}

	public int getBite() {
		return bite;
	}

	public void setBite(int bite) {
		this.bite = bite;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getDogImg() {
		return dogImg;
	}

	public void setDogImg(String dogImg) {
		this.dogImg = dogImg;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public boolean isSkin() {
		return skin;
	}

	public void setSkin(boolean skin) {
		this.skin = skin;
	}

	public boolean isHeart() {
		return heart;
	}

	public void setHeart(boolean heart) {
		this.heart = heart;
	}

	public boolean isMarking() {
		return marking;
	}

	public void setMarking(boolean marking) {
		this.marking = marking;
	}

	public boolean isMounting() {
		return mounting;
	}

	public void setMounting(boolean mounting) {
		this.mounting = mounting;
	}

	@Override
	public String toString() {
		return "DogVo [dogNo=" + dogNo + ", dogName=" + dogName + ", kind=" + kind + ", weight=" + weight + ", birth="
				+ birth + ", gender=" + gender + ", neutering=" + neutering + ", experience=" + experience + ", bite="
				+ bite + ", memo=" + memo + ", dogImg=" + dogImg + ", size=" + size + ", skin=" + skin + ", heart="
				+ heart + ", marking=" + marking + ", mounting=" + mounting + "]";
	}

}
