package br.com.ademme.util;

import java.sql.*;
public class ConectionFactory {

	
	static String status = "";
	
	public static Connection getConnection(){
		Connection conn = null;
	try {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		
		String url = "jdbc:mysql://localhost/Ademme?user=root&password=root";
		conn = DriverManager.getConnection(url);
		
		status = "conectado com sucesso";
		
	} catch (SQLException e) {
		status = e.getMessage();
		
	}catch (ClassNotFoundException e) {
		status = e.getMessage();
	
	}catch (Exception e){
		status = e.getMessage();
		
	}
	return conn;
	
	}
	
}
