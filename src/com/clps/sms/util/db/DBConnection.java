/**
 * 
 */
package com.clps.sms.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * @author erwin.wang
 *
 *         2017年8月15日下午2:12:32
 * 
 *         since v1.0
 */
public class DBConnection {

	private static Logger logger =Logger.getLogger(DBConnection.class);
	
	private static Connection conn=null;
	private boolean flag = false;
	
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/meeting";
	private static String username = "root";
	private static String password = "root";
	
	static{
		try {
			Class.forName(driver).newInstance();
			conn =DriverManager.getConnection(url, username, password);
			logger.info("mysql db connection successfully!");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
			logger.error("mysql db connection failure!");
		}
	}
	
	public boolean execUpdate(){
		return flag;
	}
	
	public boolean execQuery(){
		return flag;
	}
	
	
	public static Connection getConnection() {
		return conn;
	}
	
	public static void getClose() throws SQLException{
		conn.close();
	}


}
