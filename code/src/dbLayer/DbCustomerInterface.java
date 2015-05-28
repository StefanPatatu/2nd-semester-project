package dbLayer;

import java.util.ArrayList;

import modelLayer.Customer;

/**
 * DbCustomerInterface
 * 
 * @author Kool-kat
 * @version 1.2
 */

public interface DbCustomerInterface {
	
	public ArrayList<Customer> getAllCustomers() throws Exception;
	public Customer findCustomer(int id_customer, boolean retrieveAssoc) throws Exception;
	public ArrayList<Customer> searchCustomerByName(String name) throws Exception;
	public int insertCustomer(Customer c) throws Exception;
	public int updateCustomer(Customer c) throws Exception;
	
}
