package com.artisan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artisan.model.Signin;
import com.artisan.model.StaffClass;
import com.artisan.util.StringUtil;

public class SigninDao extends BaseDao {
	public boolean addSignin(Signin sn) {
		String sql = "insert into s_signin values(null,?,?,?)" ;
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, sn.getStaff_id());
			preparedStatement.setInt(2, sn.getClass_id());
			preparedStatement.setString(3, sn.getSignin_date());
			if(preparedStatement.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}
	
	public boolean isSignined(Signin sn){
		String sql = "select * from s_signin where staff_id=? and class_id = ? and signin_date = ?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);//把sql语句传给数据库操作对象
			prst.setInt(1, sn.getStaff_id());
			prst.setInt(2, sn.getClass_id());
			prst.setString(3, sn.getSignin_date());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Signin> getSigninList(Signin signin){
		List<Signin> retList = new ArrayList<Signin>();
		StringBuffer sqlString = new StringBuffer("select * from s_signin");
		if(signin.getStaff_id() != 0){
			sqlString.append(" and staff_id = "+signin.getStaff_id());
		}
		if(signin.getClass_id() != 0){
			sqlString.append(" and class_id ="+signin.getClass_id());
		}
		if(!StringUtil.isEmpty(signin.getSignin_date())){
			sqlString.append(" and signin_date like'%"+signin.getSignin_date()+"%'");
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Signin s = new Signin();
				s.setId(executeQuery.getInt("id"));
				s.setStaff_id(executeQuery.getInt("staff_id"));
				s.setClass_id(executeQuery.getInt("class_id"));
				s.setSignin_date(executeQuery.getString("signin_date"));
				retList.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	
	public boolean delete(int id){
		String sql = "delete from s_signin where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
