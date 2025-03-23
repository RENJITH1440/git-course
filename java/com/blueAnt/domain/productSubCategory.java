package com.blueAnt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity (name = "productSubCategory")
@Table(name = "PRODUCTSUBCATEGORY")
public class productSubCategory {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "Id")
	private Long id;
	
	@Column (name="subCategoryDesc")
	private String subCategoryDesc;
	
	@Column (name="category_id")
	private Long category_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	public String getSubCategoryDesc() {
		return subCategoryDesc;
	}
	public void setSubCategoryDesc(String subCategoryDesc) {
		this.subCategoryDesc = subCategoryDesc;
	}
	
	
}
