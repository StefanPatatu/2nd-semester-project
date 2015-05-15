package db;

import java.sql.*;

import test.Variables;

/**
 * DbConnection
 * 
 * @author Alex
 * @version 1.0
 */

public class DbConnection {
	
	private static final boolean testMode = Variables.getTestmode();
	private static final String DBurl = Variables.getDBurl();
	
	private DatabaseMetaData dma;
	private static Connection con; //an instance of the class is generated
	private static DbConnection instance = null;
	
	private DbConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			if (testMode) {
				System.out.println("Load of class is ok");
			}
		} catch(Exception e) {
			if (testMode) {
				System.out.println("Can not find the driver");
				System.out.println(e.getMessage());
			}
		}
		
		//connect to the database
		try{
			con = DriverManager.getConnection(DBurl);
			con.setAutoCommit(true);
			dma = con.getMetaData();
			if (testMode) {
				System.out.println("Connection to " + dma.getURL());
				System.out.println("Driver " + dma.getDriverName());
				System.out.println("Database product name " + dma.getDatabaseProductName());
			}
		} catch(Exception e) {
			if (testMode) {
				System.out.println("There is a problem with the connection to the database");
				System.out.println(e.getMessage());
				System.out.println(DBurl);
			}
		}
	}
	public static void closeConnection() {
		try {
			con.close();
			if (testMode) {
				System.out.println("The connection has been closed");
			}
		} catch(Exception e) {
			if (testMode) {
				System.out.println("An error occurred while trying to close the database " + e.getMessage());
			}
		}
	}
	public Connection getDBcon() {
		return con;
	}
	
	//method used to get the instance of the connection
	public static DbConnection getInstance() {
		if (instance == null) {
			instance = new DbConnection();
		}
		return instance;
	}
	
	public static void startTransaction() {
		try {
			con.setAutoCommit(false);
		} catch(Exception e) {
			if (testMode) {
				System.out.println("Failure to commit transaction");
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void  rollbackTransaction() {
		try {
			con.rollback();
			con.setAutoCommit(true);
		} catch(Exception e) {
			if (testMode) {
				System.out.println("Failure to rollback transaction");
				System.out.println(e.getMessage());
			}
		}
	}
}
	
	
	
	