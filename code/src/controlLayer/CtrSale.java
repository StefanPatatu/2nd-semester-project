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
 * @version 1.0
 */

public class CtrSale {
	
	private DbSaleInterface dbSale;
	private CtrSaleLine ctrSaleLine;
	
	//constructor
	public CtrSale() {
		dbSale = new DbSale();
		ctrSaleLine = new CtrSaleLine();
	}
	
	public ArrayList<Sale> getAllSale() throws Exception {
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
	
	public int insertSale(
			String saleNr,
			boolean isPacked,
			Timestamp datePacked,
			boolean isSent,
			Timestamp dateSent,
			boolean isPaid,
			Timestamp datePaid,
			int id_employee,
			int id_customer) {
		return 0;
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
