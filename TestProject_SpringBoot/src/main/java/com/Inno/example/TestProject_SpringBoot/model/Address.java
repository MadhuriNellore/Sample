package com.Inno.example.TestProject_SpringBoot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	private String id;
	private String address;
	private String landmark;
	private String pincode;
	public Address(String id, String address, String landmark, String pincode) {
		super();
		this.id = id;
		this.address = address;
		this.landmark = landmark;
		this.pincode = pincode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
}
