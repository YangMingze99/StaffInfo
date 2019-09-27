package com.artisan.model;
/**
 * Ç©µ½±í
 */
public class Signin {
	private int id;
	private int staff_id;
	private int class_id;
	String signin_date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public int getClass_id() {
		return class_id;
	}
	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}
	public String getSignin_date() {
		return signin_date;
	}
	public void setSignin_date(String signin_date) {
		this.signin_date = signin_date;
	}

}
