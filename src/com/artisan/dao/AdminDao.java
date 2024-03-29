package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.artisan.model.Admin;

public class AdminDao extends BaseDao {
	/**
	 * 登陆操作
	 */
	public Admin login(Admin admin) {
		String sql = "select * from s_admin where name=? and password=?";
		Admin adminRst = null;
		try {
			PreparedStatement prst = con.prepareStatement(sql);                  //传给数据库对象SQL语句
			prst.setString(1, admin.getName());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()) {
				adminRst = new Admin();
				adminRst.setId(executeQuery.getInt("id"));
				adminRst.setName(executeQuery.getString("name"));
				adminRst.setPassword(executeQuery.getString("password"));
				adminRst.setCreateDate(executeQuery.getString("createDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		try {
			//con.close();                            2019.9.15 弃用
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return adminRst;
	}
	
	
	
	
	public String editPassword(Admin admin,String newPassword)
	{
		String sql = "select * from s_admin where id=? and password=?";
		PreparedStatement prst = null;
		int id = 0;
		try {
			prst = con.prepareStatement(sql);
			prst.setInt(1, admin.getId());
			prst.setString(2, admin.getPassword());
			ResultSet executeQuery = prst.executeQuery();			
		if(!executeQuery.next()) {
			String retString = "原密码错误！";
			return retString;
		}
		id = executeQuery.getInt("id");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}                  //传给数据库对象SQL语句
		
		String retString = "密码修改失败！";
		String sqlString = "update s_admin set password = ? where id = ?";
		try {
			prst = con.prepareStatement(sqlString);
			prst.setString(1, newPassword);
			prst.setInt(2, id);
			int rst = prst.executeUpdate();
			if(rst > 0) {
				retString = "密码修改成功！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retString;
	}
	
}
