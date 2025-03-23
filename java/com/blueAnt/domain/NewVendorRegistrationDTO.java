package com.blueAnt.domain;

public class NewVendorRegistrationDTO {

	
	private int id;
	private String vendorName;
	private String gstRegNo;
	private String contactNo;
	private String address;
	private String country;
	private String state;
	private String district;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getGstRegNo() {
		return gstRegNo;
	}
	public void setGstRegNo(String gstRegNo) {
		this.gstRegNo = gstRegNo;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	
}
