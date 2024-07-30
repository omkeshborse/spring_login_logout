package com.model;

public class userModel {
	private int id;
	private String first_name;
	private String last_name;
	private String password;
	private String confirm_password;
	private String gender;
	private String email;
	private String phone_number;
	private String postal_code;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	@Override
	public String toString() {
		return "userModel [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", password="
				+ password + ", confirm_password=" + confirm_password + ", gender=" + gender + ", email=" + email
				+ ", phone_number=" + phone_number + ", postal_code=" + postal_code + "]";
	}
	
	
	
}
