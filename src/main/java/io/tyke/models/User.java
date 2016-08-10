package io.tyke.models;

import org.springframework.data.annotation.Id;

public class User extends TykeModel {
	@Id
	String Id;
	String username;
	String password;
	String email;
	String phoneNumber;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}