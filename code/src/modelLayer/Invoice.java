package modelLayer;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Invoice
 * 
 * @author Monika + futz
 * @version 1.1
 */

public class Invoice {
	
	private String invoiceNr;
	private Timestamp dateCreated;
	private boolean isPaid;
	private Timestamp datePaid;
	private Customer customer;
	private ArrayList<Sale> sales;

	
	//constructor
	public Invoice(
			String invoiceNr,
			Timestamp dateCreated,
			boolean isPaid,
			Timestamp datePaid,
			Customer customer,
			ArrayList<Sale> sales) {
		this.setInvoiceNr(invoiceNr);
		this.setDateCreated(dateCreated);
		this.setPaid(isPaid);
		this.setCustomer(customer);
		this.setSales(sales);
	}
	
	//invoiceNr
	public String getInvoiceNr() {
		return invoiceNr;
	}
	public void setInvoiceNr(String invoiceNr) {
		this.invoiceNr = invoiceNr;
	}

	//dateCreated
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	//isPaid
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	//datePaid
	public Timestamp getDatePaid() {
		return datePaid;
	}
	public void setDatePaid(Timestamp datePaid) {
		this.datePaid = datePaid;
	}

	//customer
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	//sales
	public ArrayList<Sale> getSales() {
		return sales;
	}
	public void setSales(ArrayList<Sale> sales) {
		this.sales = sales;
	}
	
}
