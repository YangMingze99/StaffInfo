package com.artisan.model;
/**
 * ������Ϣ���
 */
public class StaffClass {
	private int id;           	  //����ID
	private String name;		  //��������
	private String info;          //��ע����
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
	public String toString(){                 //��дtoString����  ����AddStafFrm��setStaffClassInfoΪѡ��ֵ�ǵ�ַ������
		                                      //  2019.9.17
		return this.name;
	}
	
}
