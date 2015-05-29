package dbLayer;

import java.sql.*;

import authLayer.DbConfig;

/**
 * DbAddress
 * 
 * @author futz
 * @version 1.0
 */

public class DbConnection {
	
	private DatabaseMetaData dma;
	private static Connection con;
	//an instance of the class is generated
	private static DbConnection instance = null;
	
    //the constructor is private to ensure that only one object of this class is created
	private DbConnection() throws Exception {
		try {
			//load SQL server driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch(Exception e) {
			throw new Exception("DbConnection.DbConnection.dbLayer", e);
		}
		try {
			//connection to the database
			con = DriverManager.getConnection(DbConfig.DBurl);
			//set autocommit
			con.setAutoCommit(true);
			//get meta data
            dma = con.getMetaData();
            //System.out.println("Connection to " + dma.getURL());
            //System.out.println("Driver " + dma.getDriverName());
            //System.out.println("Database product name " + dma.getDatabaseProductName());
            if(dma.supportsTransactionIsolationLevel(Connection.TRANSACTION_SERIALIZABLE)) {
            	con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            }
        } catch(Exception e) {
        	throw new Exception("DbConnection.DbConnection.dbLayer", e);
        }
	}
	
	public static void closeConnection() throws Exception {
		try {
			con.close();
		} catch(Exception e) {
			throw new Exception("closeConnection.DbConnection.dbLayer", e);
		}
	}
	
	//returns the connection to the database
	public Connection getDbCon() {
		return con;
	}
	
	//return the instance of the connection
	public static DbConnection getInstance() throws Exception {
		if(instance == null) {
			instance = new DbConnection();
		}
		return instance;
	}
	
	public static void startTransaction() throws Exception {
		try {
			con.setAutoCommit(false);
		} catch(Exception e) {
			throw new Exception("startTransaction.DbConnection.dbLayer", e);
		}
	}
	
	public static void comitTransaction() throws Exception {
		try {
			con.setAutoCommit(true);
		} catch(Exception e) {
			throw new Exception("commitTransaction.DbConnection.dbLayer", e);
		}
	}
	
	public static void rollbackTransaction() throws Exception {
		try {
			con.rollback();
			con.setAutoCommit(true);
		} catch(Exception e) {
			throw new Exception("rollbackTransaction.DbConnection.dbLayer", e);
		}
	}
	
}
