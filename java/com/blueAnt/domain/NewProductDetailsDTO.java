package com.blueAnt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "NewProductDetailsDTO")
@Table(name = "products")
public class NewProductDetailsDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;
	@Column(name = "productName")
	private String productName;
	@Column(name = "price")
	private String price;
	@Column(name = "discount")
	private String discount;
	@Column(name = "category")
	private Long category;
	@Column(name = "subcategory")
	private Long subcategory;
	@Column(name = "sellerId")
	private Long sellerId;
	@Column(name = "UploadImagePath")
	private String UploadImagePath;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public Long getCategory() {
		return category;
	}
	public void setCategory(Long category) {
		this.category = category;
	}
	public Long getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(Long subcategory) {
		this.subcategory = subcategory;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public String getUploadImagePath() {
		return UploadImagePath;
	}
	public void setUploadImagePath(String uploadImagePath) {
		UploadImagePath = uploadImagePath;
	}
	
	
}
