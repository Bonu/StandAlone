package edu.mum.cs.oms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT")
public class Product {

	@Id
	@Column(name="ProductID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId=0;
	private String name;
	private String unitType;
	private String code;
	private String category;
	private double sellinPrice;
	
	public Product(){
		
	}
	
	public Product(String name, String unitType, String code, String category,
			double sellinPrice) {
		super();
		this.name = name;
		this.unitType = unitType;
		this.code = code;
		this.category = category;
		this.sellinPrice = sellinPrice;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getSellinPrice() {
		return sellinPrice;
	}
	public void setSellinPrice(double sellinPrice) {
		this.sellinPrice = sellinPrice;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name
				+ ", unitType=" + unitType + ", code=" + code + ", category="
				+ category + ", sellinPrice=" + sellinPrice + "]";
	}
	
	
}
