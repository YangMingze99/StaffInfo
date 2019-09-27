package com.artisan.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.artisan.util.DbUtil;
/*
 * 创建连接对象
 */

public class BaseDao {
	public Connection con = new DbUtil().getCon();						/*   数据库链接对象  */
	public void closeDao() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
