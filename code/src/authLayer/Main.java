package authLayer;

public class Main {

	public static void main(String[] args) throws Exception {
		
		
		DbConfig dbconfig = new DbConfig();
		
		System.out.println(dbconfig.getDBDriver());
		System.out.println(dbconfig.getDBName());
		System.out.println(dbconfig.getDBUserName());
		System.out.println(dbconfig.getDBPassword());
		System.out.println(dbconfig.getDBTablePrefix());	
		
	}

}
