package com.blueAnt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Vendors")
@Table(name = "VENDORS")
public class Vendors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;
    @Column(name="vendorName")
	private String vendorName;
    @Column(name="gstRegNo")
	private String gstRegNo;
    @Column(name="contactNo")
	private String contactNo;
    @Column(name="address")
	private String address;
    @Column(name="country")
	private String country;
    @Column(name="state")
	private String state;
    @Column(name="district")
	private String district;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
