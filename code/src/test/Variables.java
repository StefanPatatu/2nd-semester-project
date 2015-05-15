package test;

/*
 * 
 * Variables
 * 
 * @author Alex
 * @version 1.0
 */

public class Variables {
	
	private static final boolean testMode = true;
	private static final String database = "kraka";
	
	private static String DBurl;
	
	//test DB variables
	private static final String testDBDriver = "jdbc:sqlserver://localhost:1433";
	private static final String testDBName = ";databaseName=entafarma";
	private static final String testDBUserName = ";user=sa";
	private static final String testDBPassword = ";password=secret";
	
	//kraka DB variables
	private static final String krakaDBDriver = "jdbc:sqlserver://kraka.ucn.dk:1433";
	private static final String krakaDBName = ";databaseName=dmaio914_2Sem_5";
	private static final String krakaDBUserName = ";user=dmaio914_2Sem_";
	private static final String krakaDBPassword = ";password=IsAllowed";
	
	//constructor
	
	private Variables() {
		
	}

	/**
	 * @return the testMode
	 */
	public static boolean getTestmode() {
		return testMode;
	}
	
	public static String getDBurl() {
		if (database.equals("local")) {
			DBurl = testDBDriver + testDBName + testDBUserName + testDBPassword;
		} else if (database.equals("kraka")) {
			DBurl = krakaDBDriver + krakaDBName + krakaDBUserName + krakaDBPassword;
			} else {
				throw new NullPointerException("Incorrect database name in file Variables.java");
			}
		return DBurl;
		
		}
	}
	


