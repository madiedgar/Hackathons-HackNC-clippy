package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBwrangler {
	
	private static DBwrangler db;
	private static Connection conn;
	
	private DBwrangler(){
		init();
	}
	
	public static DBwrangler getWrangler(){
		if (db != null){
			return db;
		} else return new DBwrangler();
	}
	
	private static void init(){
		  String url = "jdbc:mysql://127.0.0.1:3306/";
		  String dbName = "clippy";
		  String driver = "com.mysql.jdbc.Driver";
		  String userName = "clippy"; 
		  String password = "clippyuser";
		  
		  try {
			  Class.forName(driver).newInstance();
			  conn = DriverManager.getConnection(url+dbName,userName,password);
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
	
	public void dbPut(String message, String id){
		System.out.println("Let's pretend I stored " + message + " in the database");
	}

}
