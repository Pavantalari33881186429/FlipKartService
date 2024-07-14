package com.fproduct.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;


@Entity
@Component
public class FProduct {

	@Id()
	private long fproductID;
	@Column(name = "fproductname")
	private String productName;
	@Column(name = "fproductprice")
	private long productPrice;
	//Default Constructor
	public FProduct() {
		
	}
	//Parameterized Constructor
	public FProduct(long productID, String productName, long productPrice) {
		super();
		this.fproductID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
	}
	public long getProductID() {
		return fproductID;
	}
	public void setProductID(long productID) {
		this.fproductID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	
	@Override
	public String toString() {
		return "Product [productID=" + fproductID + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}
	
}
