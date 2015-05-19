package dbLayer;

import java.util.ArrayList;
import modelLayer.Customer;

/**
 * DbCustomerInterface
 * 
 * @author Koolkat
 * @version 1.0
 *
 */

public interface DbCustomerInterface {
	
	public ArrayList<Customer> getAllCustomers();
	public Customer findCustomer(int id_customer);
	public ArrayList<Customer> searchCustomerByName(String name);
	public int insertCustomer(Customer c);
	public int updateCustomer(Customer c);
	public int removeCustomer(Customer c);
	
}
