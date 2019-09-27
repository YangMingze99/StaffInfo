package com.artisan.model;
/**
 * 部门信息添加
 */
public class StaffClass {
	private int id;           	  //部门ID
	private String name;		  //部门名称
	private String info;          //备注部门
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString(){                 //重写toString方法  避免AddStafFrm中setStaffClassInfo为选框传值是地址的问题
		                                      //  2019.9.17
		return this.name;
	}
	
}
