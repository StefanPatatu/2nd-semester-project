package controlLayer;

import java.sql.Timestamp;
import java.util.ArrayList;

import modelLayer.Sale;
import modelLayer.SaleLine;
import modelLayer.Employee;
import modelLayer.Customer;
import dbLayer.DbSaleInterface;
import dbLayer.DbSale;
import dbLayer.DbConnection;

/**
 * CtrSale
 * 
 * @author futz
 * @version 1.3
 */

public class CtrSale {
	
	private DbSaleInterface dbSale;
	private CtrSaleLine ctrSaleLine;
	
	//constructor
	public CtrSale() {
		dbSale = new DbSale();
		ctrSaleLine = new CtrSaleLine();
	}
	
	public ArrayList<Sale> getAllSales() throws Exception {
		ArrayList<Sale> sales = new ArrayList<>();
		sales = dbSale.getAllSales();
		return sales;
	}
	
	public Sale findSaleById_sale(int id_sale) throws Exception {
		return dbSale.findSaleById_sale(id_sale, true);
	}
	
	public Sale findSaleBySaleNr(String saleNr) throws Exception {
		return dbSale.findSaleBySaleNr(saleNr, true);
	}
	
	public ArrayList<Sale> searchSaleBySaleStatuses(boolean isPacked, boolean isSent, boolean isPaid) throws Exception {
		ArrayList<Sale> sales = new ArrayList<>();
		sales = dbSale.searchSaleBySaleStatuses(isPacked, isSent, isPaid);
		return sales;
	}
	
	public ArrayList<Sale> searchSaleByDateCreatedInterval(Timestamp dateCreatedMin, Timestamp dateCreatedMax) throws Exception {
		ArrayList<Sale> sales = new ArrayList<>();
		sales = dbSale.searchSaleByDateCreatedInterval(dateCreatedMin, dateCreatedMax);
		return sales;
	}
	
	//******************************************************************************************
	//INSERT SALE PART START
	//
	//Usage:
	//Call startSale() and keep the ArrayList<SaleLine> object
	//Call addSaleLineToSale() as many times as necessary
	//When done call insertSale()
	//Note that nothing is added to the database until insertSale()
	//That means you can remove a saleLine if needed
	//******************************************************************************************
	
	//creates an empty saleLine array and returns it
	public ArrayList<SaleLine> startSale() {
		ArrayList<SaleLine> saleLines = new ArrayList<>();
		return saleLines;
	}
	
	//creates and adds a saleLine to the arrayList
	//returns 1 if successful
	//returns -27 if unable to add the sale to the ArrayList
	public int addSaleLineToSale(int quantity, String barcode, ArrayList<SaleLine> saleLines) {
		int success = 1;
		SaleLine saleLine = ctrSaleLine.createSaleLine(quantity, barcode);
		if(saleLine == null) {
			success = Errors.ADD_SALELINE_TO_SALE.getCode();
		} else {
			saleLines.add(saleLine);
		}
		return success;
	}
	
	//SEND AN id_invoice = -1 IF THE SALE IS NOT PAID NOW. OTHERWISE SEND THE INVOICE ID
	//returns 1 if successful
	//returns -28 if error trying to find the customer
	//returns -29 if error trying to find the employee
	//returns -30 if could not insert sale
	//returns -31 if could not add sale to database
	//returns -32 if error when adding one of the saleLines to the database
	//throws Exception if rollbackTransaction() fails -> means something terribly wrong happened
	public int insertSale(
			String saleNr,
			boolean isPacked,
			Timestamp datePacked,
			boolean isSent,
			Timestamp dateSent,
			boolean isPaid,
			Timestamp datePaid,
			int id_employee,
			int id_customer,
			ArrayList<SaleLine> saleLines,
			int id_inv) throws Exception {
		int success = 1;
		//initialize
		CtrEmployee ctrEmployee = new CtrEmployee();
		CtrCustomer ctrCustomer = new CtrCustomer();
		Sale sale = null;
		//discount
		int discount = ctrCustomer.getDiscount(id_customer);
		//current date
		java.util.Date date= new java.util.Date();
		Timestamp dateCreated = new Timestamp(date.getTime());
		//get employee
		Employee employee = null;
		try {
			employee = ctrEmployee.findEmployeeById_employee(id_employee);
		} catch (Exception e1) {
			success = Errors.FIND_EMPLOYEE.getCode();
		}
		//get customer
		Customer customer = null;
		try {
			customer = ctrCustomer.findCustomer(id_customer);
		} catch (Exception e) {
			success = Errors.FIND_CUSTOMER.getCode();
		}
		//add sale to database
		if(success == 1 && employee != null && customer != null) {
			//means everything went smooth
			//create sale object and add it to the database
			sale = new Sale(saleNr, discount, dateCreated, isPacked, datePacked, isSent, dateSent, isPaid, datePaid, employee, customer, saleLines);
			try {
				DbConnection.startTransaction();
				dbSale.insertSale(sale, id_inv);
				DbConnection.comitTransaction();
			} catch (Exception e) {
				try {
					DbConnection.rollbackTransaction();
				} catch (Exception r) {
					throw new Exception("insertSale.CtrSale.controlLayer", r);
				}
				success = Errors.INSERT_SALE.getCode();
			}
		} else {
			success = Errors.ADD_SALE_TO_DB.getCode();
		}
		//add the salelines to the database
		if(success == 1 && employee != null && customer != null && saleLines != null && sale.getId_sale() != -1) {
			for (SaleLine saleLine : saleLines) {
				try {
					System.out.println(ctrSaleLine.insertSaleLine(saleLine.getQuantity(), saleLine.getItem().getBarcode(), sale.getId_sale()));
				} catch (Exception e) {
					success = Errors.INSERT_SALELINE_INTO_SALE.getCode();
					break;
				}
			}
			
		}
		return success;
	}
	
	//******************************************************************************************
	//INSERT SALE PART END
	//******************************************************************************************
	
	//returns 1 if successful
	//returns negative value if unsuccessful
	//throws Exception if rollbackTransaction() fails -> means something terribly wrong happened
	public int updateSaleIsPacked(boolean isPacked, int id_sale) throws Exception {
		int success = 1;
		try {
			DbConnection.startTransaction();
			dbSale.updateSaleIsPacked(isPacked, id_sale);
			DbConnection.comitTransaction();
		} catch (Exception e) {
			try {
				DbConnection.rollbackTransaction();
			} catch (Exception r) {
				throw new Exception("updateSaleIsPacked.CtrSale.controlLayer", r);
			}
			success = Errors.UPDATE_ISPACKED.getCode();
		}
		return success;
	}
	
	//returns 1 if successful
	//returns negative value if unsuccessful
	//throws Exception if rollbackTransaction() fails -> means something terribly wrong happened
	public int updateSaleIsSent(boolean isSent, int id_sale) throws Exception {
		int success = 1;
		try {
			DbConnection.startTransaction();
			dbSale.updateSaleIsSent(isSent, id_sale);
			DbConnection.comitTransaction();
		} catch (Exception e) {
			try {
				DbConnection.rollbackTransaction();
			} catch (Exception r) {
				throw new Exception("updateSaleIsSent.CtrSale.controlLayer", r);
			}
			success = Errors.UPDATE_ISSENT.getCode();
		}
		return success;
	}
	
	//returns 1 if successful
	//returns negative value if unsuccessful
	//throws Exception if rollbackTransaction() fails -> means something terribly wrong happened
	public int updateSaleIsPaid(boolean isSent, int id_sale) throws Exception {
		int success = 1;
		try {
			DbConnection.startTransaction();
			dbSale.updateSaleIsPaid(isSent, id_sale);
			DbConnection.comitTransaction();
		} catch (Exception e) {
			try {
				DbConnection.rollbackTransaction();
			} catch (Exception r) {
				throw new Exception("updateSaleIsPaid.CtrSale.controlLayer", r);
			}
			success = Errors.UPDATE_ISPAID.getCode();
		}
		return success;
	}
	
	public ArrayList<Sale> getAllUnpaidSalesForCustomer(int id_customer) throws Exception {
		ArrayList<Sale> sales = new ArrayList<>();
		sales = dbSale.getAllUnpaidSalesForCustomer(id_customer);
		return sales;
	}
	public ArrayList<Sale> getAllSalesForCustomer(int id_customer) throws Exception {
		ArrayList<Sale> sales = new ArrayList<>();
		sales = dbSale.getAllSalesForCustomer(id_customer);
		return sales;
	}
	
	//returns the total price of the sale if successful
	//returns -24 if error trying to calculate the total
	//returns -23 if error trying to get the sale lines from the database
	public double getSaleTotalPrice(int id_sale) throws Exception {
		double success = Errors.SALE_TOTAL_PRICE.getCode();
		ArrayList<SaleLine> saleLines = new ArrayList<>();
		try {
			saleLines = ctrSaleLine.getAllSaleLinesForSale(id_sale);
		} catch (Exception e) {
			success = Errors.GET_ALL_SALELINES_FOR_SALE.getCode();
		}
		if(success == Errors.SALE_TOTAL_PRICE.getCode()) {
			//means an exception was not thrown at the previous step
			success = 0;
			for (SaleLine tmpSaleLine : saleLines) {
				success += tmpSaleLine.getPrice();
			}
		}
		return success;
	}
	
}
