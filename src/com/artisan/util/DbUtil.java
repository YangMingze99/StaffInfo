package com.artisan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private String dbUrl = "jdbc:mysql://localhost:3306/db_staff";           
	private String dbUsername = "root";
	private String dbPassword = "123456";
	private String jdbcName = "com.mysql.jdbc.Driver";
	
	public Connection getCon() {
		 try {
	           Class.forName(jdbcName);
	     } catch (ClassNotFoundException e) {
	    	// TODO Auto-generated catch block
	         e.printStackTrace();
	     }
		 Connection con = null;
		 
		 try {
             con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		 return con;
	}
	
	/**
	  * �ر����ݿ�����
	 * @throws Exception 
	 */
	public void closeCon(Connection con) throws Exception {
		if(con != null) {
			con.close();
		}
	}
	
	public static void main(String[] args) {
		DbUtil dbUtil = new DbUtil();
		try {
			dbUtil.getCon();
			System.out.println("���ݿ����ӳɹ���");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("���ݿ�����ʧ�ܣ�");
			e.printStackTrace();
		}	
	}
}
