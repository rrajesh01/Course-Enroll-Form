package com.rajesh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	static String driverClassName = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/myStudent";
	static String userName = "root";
	static String userPassword = "rajesh";

	static {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException, SQLException {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, userPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
