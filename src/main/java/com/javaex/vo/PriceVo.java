package com.javaex.vo;

public class PriceVo {

	//필드
	private int priceNo;
	private int beautyNo;
	private int bNo;
	private int onePrice;
	private String sizeDiv;
	private String weightDiv;
	private String beauty;
	
	//beauty필드
	 private String 목욕;
     private String 부분;
     private String 목욕_부분;
     private String 얼굴_부분_목욕;
     private String 기본전체미용;
     private String 스포팅;
     private String 가위컷;
     private String 컷;
     private String 엉킴;
     private String 기장;
     private String 특수얼굴컷;
     private String 투톤염색;
     private String 염색;

	//생성자
	public PriceVo() {
		super();
	}
	
	
	
	public PriceVo(int bNo, String sizeDiv) {
		super();
		this.bNo = bNo;
		this.sizeDiv = sizeDiv;
	}



	public PriceVo(int priceNo, int beautyNo, int bNo, int onePrice, String sizeDiv, String weightDiv, String beauty,
			String 목욕, String 부분, String 목욕_부분, String 얼굴_부분_목욕, String 기본전체미용, String 스포팅, String 가위컷,
			String 컷, String 엉킴, String 기장, String 특수얼굴컷, String 투톤염색, String 염색) {
		super();
		this.priceNo = priceNo;
		this.beautyNo = beautyNo;
		this.bNo = bNo;
		this.onePrice = onePrice;
		this.sizeDiv = sizeDiv;
		this.weightDiv = weightDiv;
		this.beauty = beauty;
		this.목욕 = 목욕;
		this.부분 = 부분;
		this.목욕_부분 = 목욕_부분;
		this.얼굴_부분_목욕 = 얼굴_부분_목욕;
		this.기본전체미용 = 기본전체미용;
		this.스포팅 = 스포팅;
		this.가위컷 = 가위컷;
		this.컷 = 컷;
		this.엉킴 = 엉킴;
		this.기장 = 기장;
		this.특수얼굴컷 = 특수얼굴컷;
		this.투톤염색 = 투톤염색;
		this.염색 = 염색;
	}

	//메소드 -gs
	public int getPriceNo() {
		return priceNo;
	}

	public void setPriceNo(int priceNo) {
		this.priceNo = priceNo;
	}

	public int getBeautyNo() {
		return beautyNo;
	}

	public void setBeautyNo(int beautyNo) {
		this.beautyNo = beautyNo;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public int getOnePrice() {
		return onePrice;
	}

	public void setOnePrice(int onePrice) {
		this.onePrice = onePrice;
	}

	public String getSizeDiv() {
		return sizeDiv;
	}

	public void setSizeDiv(String sizeDiv) {
		this.sizeDiv = sizeDiv;
	}

	public String getWeightDiv() {
		return weightDiv;
	}

	public void setWeightDiv(String weightDiv) {
		this.weightDiv = weightDiv;
	}

	public String getBeauty() {
		return beauty;
	}

	public void setBeauty(String beauty) {
		this.beauty = beauty;
	}
	
	public String get목욕() {
		return 목욕;
	}

	public void set목욕(String 목욕) {
		this.목욕 = 목욕;
	}

	public String get부분() {
		return 부분;
	}

	public void set부분(String 부분) {
		this.부분 = 부분;
	}

	public String get목욕_부분() {
		return 목욕_부분;
	}

	public void set목욕_부분(String 목욕_부분) {
		this.목욕_부분 = 목욕_부분;
	}

	public String get얼굴_부분_목욕() {
		return 얼굴_부분_목욕;
	}

	public void set얼굴_부분_목욕(String 얼굴_부분_목욕) {
		this.얼굴_부분_목욕 = 얼굴_부분_목욕;
	}

	public String get기본전체미용() {
		return 기본전체미용;
	}

	public void set기본전체미용(String 기본전체미용) {
		this.기본전체미용 = 기본전체미용;
	}
	
	public String get스포팅() {
		return 스포팅;
	}

	public void set스포팅(String 스포팅) {
		this.스포팅 = 스포팅;
	}

	public String get가위컷() {
		return 가위컷;
	}

	public void set가위컷(String 가위컷) {
		this.가위컷 = 가위컷;
	}
	
	public String get컷() {
		return 컷;
	}

	public void set컷(String 컷) {
		this.컷 = 컷;
	}

	public String get엉킴() {
		return 엉킴;
	}

	public void set엉킴(String 엉킴) {
		this.엉킴 = 엉킴;
	}

	public String get기장() {
		return 기장;
	}

	public void set기장(String 기장) {
		this.기장 = 기장;
	}

	public String get특수얼굴컷() {
		return 특수얼굴컷;
	}

	public void set특수얼굴컷(String 특수얼굴컷) {
		this.특수얼굴컷 = 특수얼굴컷;
	}

	public String get투톤염색() {
		return 투톤염색;
	}

	public void set투톤염색(String 투톤염색) {
		this.투톤염색 = 투톤염색;
	}

	public String get염색() {
		return 염색;
	}

	public void set염색(String 염색) {
		this.염색 = 염색;
	}
	
	//메소드 -일반
	@Override
	public String toString() {
		return "PriceVo [priceNo=" + priceNo + ", beautyNo=" + beautyNo + ", bNo=" + bNo + ", onePrice=" + onePrice
				+ ", sizeDiv=" + sizeDiv + ", weightDiv=" + weightDiv + ", beauty=" + beauty + ", 목욕=" + 목욕 + ", 부분="
				+ 부분 + ", 목욕_부분=" + 목욕_부분 + ", 얼굴_부분_목욕=" + 얼굴_부분_목욕 + ", 기본전체미용=" + 기본전체미용 + ", 스포팅=" + 스포팅 + ", 가위컷="
				+ 가위컷 + ", 컷=" + 컷 + ", 엉킴=" + 엉킴 + ", 기장=" + 기장 + ", 특수얼굴컷=" + 특수얼굴컷 + ", 투톤염색=" + 투톤염색 + ", 염색=" + 염색
				+ "]";
	}
	
	
}
