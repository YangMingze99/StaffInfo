package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artisan.model.Admin;
import com.artisan.model.Staff;
import com.artisan.model.StaffClass;
import com.artisan.util.StringUtil;

public class StaffDao extends BaseDao {
	public boolean addStaff (Staff staff) {
		String sql = "insert into s_staff values(null,?,?,?,?,?)" ;
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, staff.getName());
			preparedStatement.setString(2, staff.getSex());
			preparedStatement.setString(3, staff.getAge());
			preparedStatement.setInt(4, staff.getClassId());
			preparedStatement.setString(5, staff.getPassword());
			if(preparedStatement.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}
	
	public List<Staff> getStaffList(Staff staff){
		List<Staff> retList = new ArrayList<Staff>();              //����
		StringBuffer sqlString = new StringBuffer("select * from s_staff");
		if(!StringUtil.isEmpty(staff.getName())) {
			sqlString.append(" and name like '%"+staff.getName()+"%'");                    //�ж���Ϲ�ϵ
		}
		if(staff.getClassId() != 0) {
			sqlString.append(" and classId = "+staff.getClassId());
		}
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()) {
				Staff s = new Staff();
				s.setId(executeQuery.getInt("id"));                   //ע������ID  ����Column 'id' not found.����Ϊnavicat��Ʊ� IDǰ�пո���ɵģ�������
				s.setName(executeQuery.getString("name"));
				s.setSex(executeQuery.getString("sex"));
				s.setAge(executeQuery.getString("age"));
				s.setClassId(executeQuery.getInt("classId"));
				s.setPassword(executeQuery.getString("password"));
				retList.add(s);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	
	public boolean delete(int id) {
		String sql = "delete from s_staff where id = ?";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean update(Staff staff) {
		String sql = "update  s_staff set name = ? , sex = ? ,age = ? ,classId = ?,password = ? where id = ?";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, staff.getName());
			preparedStatement.setString(2, staff.getSex());
			preparedStatement.setString(3, staff.getAge());
			preparedStatement.setInt(4, staff.getClassId());
			preparedStatement.setString(5, staff.getPassword());
			preparedStatement.setInt(6, staff.getId());
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public String editPassword(Staff staff,String newPassword)
	{
		String sql = "select * from s_staff where id=? and password=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, staff.getId());
			prst.setString(2, staff.getPassword());
			ResultSet executeQuery = prst.executeQuery();			
		if(!executeQuery.next()) {
			String retString = "ԭ�������";
			return retString;
		}
		id = executeQuery.getInt("id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}                  //�������ݿ����SQL���
		
		String retString = "�����޸�ʧ�ܣ�";
		String sqlString = "update s_staff set password = ? where id = ?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int rst = prst.executeUpdate();
			if(rst > 0) {
				retString = "�����޸ĳɹ���";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retString;
	}
	
	public Staff login(Staff staff) {
		String sql = "select * from s_staff where name=? and password=?";
		Staff staffRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);                  //�������ݿ����SQL���
			prst.setString(1, staff.getName());
			prst.setString(2, staff.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()) {
				staffRst = new Staff();
				staffRst.setId(executeQuery.getInt("id"));
				staffRst.setClassId(executeQuery.getInt("classId"));
				staffRst.setName(executeQuery.getString("name"));
				staffRst.setPassword(executeQuery.getString("password"));
				staffRst.setSex(executeQuery.getString("sex"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		try {
			//con.close();                            2019.9.15 ����
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return staffRst;
	}
}
