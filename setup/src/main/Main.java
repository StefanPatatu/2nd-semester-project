package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class Main {

	public static void main(String[] args) throws UnsupportedEncodingException {
		
		Encryptor encryptor = new Encryptor();
		
		Properties prop = new Properties();
		OutputStream output = null;
		
		try {
	 		output = new FileOutputStream("setup.properties");
	 		// set the properties value
			prop.setProperty("DBDriver", encryptor.getDBDriver());
			prop.setProperty("DBName", encryptor.getDBName());
			prop.setProperty("DBUserName", encryptor.getDBUserName());
			prop.setProperty("DBPassword", encryptor.getDBPassword());
			prop.setProperty("DBTablePrefix", encryptor.getDBTablePrefix());
	 		// save properties to project root folder
			prop.store(output, null);
	 	} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		PrintWriter out = null;
		try {
			out = new PrintWriter("query.sql");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(encryptor.getDBQuery());
		out.close();
	}

}