package controlLayer;

import java.util.ArrayList;

import modelLayer.Customer;
import modelLayer.Sale;
import dbLayer.DbCustomerInterface;
import dbLayer.DbCustomer;
import dbLayer.DbConnection;

/**
 * CtrCustomer
 * 
 * @author futz
 * @version 1.3
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
	public int updateCustomer(int id_customer, String name, String country, String city, String street, String phoneNr, String email) throws Exception {
		int success = 1;
		Customer customer = new Customer(id_customer, name, ctrAddress.createNewAddress(country, city), street, phoneNr, email);
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
	
	//returns the discount if successful
	//returns -24 if error trying to calculate the total
	//returns -23 if error trying to get the sale lines from the database
	//returns -21 or -25 if error trying to calculate the discount
	//returns -22 if error trying to retrieve the sales from the database
	public int getDiscount(int id_customer) {
		int success = Errors.GET_DISCOUNT.getCode();
		double totalMoneySpent = 0;
		ArrayList<Sale> sales = new ArrayList<>();
		CtrSale ctrSale = new CtrSale();
		//retrieve all sales ever made by the customer
		try {
			sales = ctrSale.getAllSalesForCustomer(id_customer);
		} catch (Exception e) {
			success = Errors.GET_ALL_SALES_C.getCode();
			sales = null;
		}
		if(sales != null) {
			//means the sales have been successfully retrieved
			for (Sale tmpSale : sales) {
				try {
					double tmpVar = ctrSale.getSaleTotalPrice(tmpSale.getId_sale());
					if (tmpVar < 0) {
						//means an error occurred
						//return the error code
						success = (int) tmpVar;
						break;
					}
					totalMoneySpent += tmpVar;
				} catch (Exception e) {
					success = Errors.GET_DISCOUNT_LOOP.getCode();
					break;
				}
			}
		}
		if(success == Errors.GET_DISCOUNT.getCode()) {
			//means that everything went smooth until now
			if(DiscountLevels.LEVEL_1.getMin() < totalMoneySpent &&	DiscountLevels.LEVEL_1.getMax() > totalMoneySpent)
				success = DiscountLevels.LEVEL_1.getPercentage();
			else if(DiscountLevels.LEVEL_2.getMin() < totalMoneySpent && DiscountLevels.LEVEL_2.getMax() > totalMoneySpent)
				success = DiscountLevels.LEVEL_2.getPercentage();
			else if(DiscountLevels.LEVEL_3.getMin() < totalMoneySpent && DiscountLevels.LEVEL_3.getMax() > totalMoneySpent)
				success = DiscountLevels.LEVEL_3.getPercentage();
			else if(DiscountLevels.LEVEL_4.getMin() < totalMoneySpent && DiscountLevels.LEVEL_4.getMax() > totalMoneySpent)
				success = DiscountLevels.LEVEL_4.getPercentage();
			else if(DiscountLevels.LEVEL_5.getMin() < totalMoneySpent && DiscountLevels.LEVEL_5.getMax() > totalMoneySpent)
				success = DiscountLevels.LEVEL_5.getPercentage();
			else success = 12;
		}
		return success;
	}

}
