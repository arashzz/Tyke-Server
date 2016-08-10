package io.tyke.models;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Spending extends TykeModel {
	@Id
	String Id;
	Date recieptDate;
	Date expireyDate;
	double recieptAmount;
	SpendingUserForeignDocument user;
	SpendingBrandForeignDocument brand;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public Date getRecieptDate() {
		return recieptDate;
	}
	public void setRecieptDate(Date recieptDate) {
		this.recieptDate = recieptDate;
	}
	public Date getExpireyDate() {
		return expireyDate;
	}
	public void setExpireyDate(Date expireyDate) {
		this.expireyDate = expireyDate;
	}
	public double getRecieptAmount() {
		return recieptAmount;
	}
	public void setRecieptAmount(double recieptAmount) {
		this.recieptAmount = recieptAmount;
	}
	public SpendingUserForeignDocument getUser() {
		return user;
	}
	public void setUser(SpendingUserForeignDocument user) {
		this.user = user;
	}
	public SpendingBrandForeignDocument getBrand() {
		return brand;
	}
	public void setBrand(SpendingBrandForeignDocument brand) {
		this.brand = brand;
	}
	

}
