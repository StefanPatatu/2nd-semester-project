package controlLayer;

import java.util.ArrayList;

import modelLayer.Customer;
import dbLayer.DbCustomerInterface;
import dbLayer.DbCustomer;
import dbLayer.DbConnection;

/**
 * CtrCustomer
 * 
 * @author futz
 * @version 1.0
 */

public class CtrCustomer {
	
	private DbCustomerInterface dbCustomer;
	
	//constructor
	public CtrCustomer() {
		dbCustomer = new DbCustomer();
	}
	
	public ArrayList<Customer> getAllCustomers() throws Exception {
		ArrayList<Customer> customers = new ArrayList<>();
		customers = dbCustomer.getAllCustomers();
		return customers;
	}
	
	public Customer findCustomer(int id_customer) throws Exception {
		return dbCustomer.findCustomer(id_customer, true);
	}
	
	public ArrayList<Customer> searchCustomerByName(String name) throws Exception {
		return dbCustomer.searchCustomerByName(name);
	}
	
	public int insertCustomer(String name, String country, String city, String street, String phoneNr, String email) throws Exception {
		?is it ok? create address here
	}

}
