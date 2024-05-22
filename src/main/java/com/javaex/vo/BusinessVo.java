package com.javaex.vo;

import java.io.IOException;

import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;
import com.google.code.geocoder.model.LatLng;

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
	
	public BusinessVo() {
		super();
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

	public void setLatitudeAndLongitude(String location) {
        Float[] coords = geoCoding(location);
        if (coords != null && coords.length == 2) {
            this.latitude = coords[0];
            this.longitude = coords[1];
        }
    }

    // 위도와 경도를 얻는 메서드
    private static Float[] geoCoding(String location) {
        if (location == null)
            return null;

        Geocoder geocoder = new Geocoder();
        GeocoderRequest geocoderRequest = new GeocoderRequestBuilder()
            .setAddress(location)
            .setLanguage("ko")
            .getGeocoderRequest();

        try {
            GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
            if (geocoderResponse.getStatus() == GeocoderStatus.OK && !geocoderResponse.getResults().isEmpty()) {
                GeocoderResult geocoderResult = geocoderResponse.getResults().iterator().next();
                LatLng latitudeLongitude = geocoderResult.getGeometry().getLocation();
                Float[] coords = new Float[2];
                coords[0] = latitudeLongitude.getLat().floatValue();
                coords[1] = latitudeLongitude.getLng().floatValue();
                return coords;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

	@Override
	public String toString() {
		return "BusinessVo [bNo=" + bNo + ", bId=" + bId + ", bPw=" + bPw + ", bNum=" + bNum + ", bZipCode=" + bZipCode
				+ ", bAddress=" + bAddress + ", bdAddress=" + bdAddress + ", bPhone=" + bPhone + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}
	
	
}
