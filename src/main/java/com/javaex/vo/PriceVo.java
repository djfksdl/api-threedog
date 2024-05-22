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
	 private Integer 목욕;
     private Integer 부분;
     private Integer 목욕_부분;
     private Integer 얼굴_부분_목욕;
     private Integer 기본전체미용;
     private Integer 스포팅;
     private Integer 가위컷;
     private Integer 컷;
     private Integer 엉킴;
     private Integer 기장;
     private Integer 특수얼굴컷;
     private Integer 투톤염색;
     private Integer 염색;

	//생성자
	public PriceVo() {
		super();
	}
	
	public PriceVo(int priceNo, int beautyNo, int bNo, int onePrice, String sizeDiv, String weightDiv, String beauty,
			Integer 목욕, Integer 부분, Integer 목욕_부분, Integer 얼굴_부분_목욕, Integer 기본전체미용, Integer 스포팅, Integer 가위컷,
			Integer 컷, Integer 엉킴, Integer 기장, Integer 특수얼굴컷, Integer 투톤염색, Integer 염색) {
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
	
	public Integer get목욕() {
		return 목욕;
	}

	public void set목욕(Integer 목욕) {
		this.목욕 = 목욕;
	}

	public Integer get부분() {
		return 부분;
	}

	public void set부분(Integer 부분) {
		this.부분 = 부분;
	}

	public Integer get목욕_부분() {
		return 목욕_부분;
	}

	public void set목욕_부분(Integer 목욕_부분) {
		this.목욕_부분 = 목욕_부분;
	}

	public Integer get얼굴_부분_목욕() {
		return 얼굴_부분_목욕;
	}

	public void set얼굴_부분_목욕(Integer 얼굴_부분_목욕) {
		this.얼굴_부분_목욕 = 얼굴_부분_목욕;
	}

	public Integer get기본전체미용() {
		return 기본전체미용;
	}

	public void set기본전체미용(Integer 기본전체미용) {
		this.기본전체미용 = 기본전체미용;
	}
	
	public Integer get스포팅() {
		return 스포팅;
	}

	public void set스포팅(Integer 스포팅) {
		this.스포팅 = 스포팅;
	}

	public Integer get가위컷() {
		return 가위컷;
	}

	public void set가위컷(Integer 가위컷) {
		this.가위컷 = 가위컷;
	}
	
	public Integer get컷() {
		return 컷;
	}

	public void set컷(Integer 컷) {
		this.컷 = 컷;
	}

	public Integer get엉킴() {
		return 엉킴;
	}

	public void set엉킴(Integer 엉킴) {
		this.엉킴 = 엉킴;
	}

	public Integer get기장() {
		return 기장;
	}

	public void set기장(Integer 기장) {
		this.기장 = 기장;
	}

	public Integer get특수얼굴컷() {
		return 특수얼굴컷;
	}

	public void set특수얼굴컷(Integer 특수얼굴컷) {
		this.특수얼굴컷 = 특수얼굴컷;
	}

	public Integer get투톤염색() {
		return 투톤염색;
	}

	public void set투톤염색(Integer 투톤염색) {
		this.투톤염색 = 투톤염색;
	}

	public Integer get염색() {
		return 염색;
	}

	public void set염색(Integer 염색) {
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
