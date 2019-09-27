package com.artisan.dao;
/**
 * 数据库操作
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.artisan.model.StaffClass;
import com.artisan.util.StringUtil;

public class ClassDao extends BaseDao {
	public boolean addClass(StaffClass sc1) {
		String sql = "insert into s_class values(null,?,?)" ;
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, sc1.getName());
			preparedStatement.setString(2, sc1.getInfo());
			if(preparedStatement.executeUpdate() > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<StaffClass> getClassList(StaffClass staffClass){
		List<StaffClass> retList = new ArrayList<StaffClass>();              //泛型
		String sqlString = "select * from s_class";
		if(!StringUtil.isEmpty(staffClass.getName())) {
			sqlString +=" where cname like '%"+staffClass.getName()+"%'";
		}
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()) {
				StaffClass sc = new StaffClass();
				sc.setId(executeQuery.getInt("id"));                   //注意这里ID  报错Column 'id' not found.是因为navicat设计表 ID前有空格造成的！！！！
				sc.setName(executeQuery.getString("cname"));
				sc.setInfo(executeQuery.getString("info"));
				retList.add(sc);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retList;
	}
	
	public boolean delete(int id) {
		String sql = "delete from s_class where id = ?";
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
	
	public boolean update(StaffClass sc) {
		String sql = "update  s_class set cname = ? , info = ? where id = ?";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, sc.getName());
			preparedStatement.setString(2, sc.getInfo());
			preparedStatement.setInt(3, sc.getId());
			if(preparedStatement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
