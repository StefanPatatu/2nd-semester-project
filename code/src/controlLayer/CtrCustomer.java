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
	private CtrAddress ctrAddress;
	
	//constructor
	public CtrCustomer() {
		dbCustomer = new DbCustomer();
		ctrAddress = new CtrAddress();
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
	
	//returns 1 if successful
	//returns negative value if unsuccessful
	//throws Exception if rollbackTransaction() fails -> means something terribly wrong happened
	public int insertCustomer(String name, String country, String city, String street, String phoneNr, String email) throws Exception {
		int success = 1;
		Customer customer = new Customer(name, ctrAddress.createNewAddress(country, city), street, phoneNr, email);
		try {
			DbConnection.startTransaction();
			dbCustomer.insertCustomer(customer);
			DbConnection.comitTransaction();
		} catch (Exception e) {
			try {
				DbConnection.rollbackTransaction();
			} catch (Exception r) {
				throw new Exception("insertCustomer.CtrCustomer.controlLayer", r);
			}
			success = Errors.INSERT_CUSTOMER.getCode();
		}
		return success;	
	}
	
	//returns 1 if successful
	//returns negative value if unsuccessful
	//throws Exception if rollbackTransaction() fails -> means something terribly wrong happened
	public int updateCustomer(int id_address, String name, String country, String city, String street, String phoneNr, String email) throws Exception {
		int success = 1;
		Customer customer = new Customer(id_address, name, ctrAddress.createNewAddress(country, city), street, phoneNr, email);
		try {
			DbConnection.startTransaction();
			dbCustomer.updateCustomer(customer);
			DbConnection.comitTransaction();
		} catch (Exception e) {
			try {
				DbConnection.rollbackTransaction();
			} catch (Exception r) {
				throw new Exception("updateCustoemr.CtrCustomer.controlLayer", r);
			}
			success = Errors.UPDATE_CUSTOMER.getCode();
		}
		return success;	
	}

}
