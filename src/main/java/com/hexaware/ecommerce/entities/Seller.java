package com.hexaware.ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Seller_Info")
public class Seller {

	@Id
	private int sellerId;
	private String sellerName;
	private String sellerPassword;
	private String sellerAddress;
	private String sellerContact;


	public Seller() {
		super();
	}


	public Seller(int sellerId, String sellerName, String sellerPassword, String sellerAddress, String sellerContact) {
		super();
		this.sellerId = sellerId;
		this.sellerName = sellerName;
		this.sellerPassword = sellerPassword;
		this.sellerAddress = sellerAddress;
		this.sellerContact = sellerContact;
	}


	public int getSellerId() {
		return sellerId;
	}


	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}


	public String getSellerName() {
		return sellerName;
	}


	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}


	public String getSellerPassword() {
		return sellerPassword;
	}


	public void setSellerPassword(String sellerPassword) {
		this.sellerPassword = sellerPassword;
	}


	public String getSellerAddress() {
		return sellerAddress;
	}


	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}


	public String getSellerContact() {
		return sellerContact;
	}


	public void setSellerContact(String sellerContact) {
		this.sellerContact = sellerContact;
	}


	@Override
	public String toString() {
		return "Seller [sellerId=" + sellerId + ", sellerName=" + sellerName + ", sellerPassword=" + sellerPassword
				+ ", sellerAddress=" + sellerAddress + ", sellerContact=" + sellerContact + "]";
	}




}
