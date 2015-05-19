package modelLayer;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Invoice
 * 
 * @author DarkSun + futz
 * @version 1.2
 */

public class Invoice {
	
	private int id_invoice;
	private String invoiceNr;
	private Timestamp dateCreated;
	private boolean isPaid;
	private Timestamp datePaid;
	private Customer customer;
	private ArrayList<Sale> sales;

	
	//constructor
	public Invoice(
			int id_invoice,
			String invoiceNr,
			Timestamp dateCreated,
			boolean isPaid,
			Timestamp datePaid,
			Customer customer,
			ArrayList<Sale> sales) {
		this.setId_invoice(id_invoice);
		this.setInvoiceNr(invoiceNr);
		this.setDateCreated(dateCreated);
		this.setPaid(isPaid);
		this.setCustomer(customer);
		this.setSales(sales);
	}
	
	//id_invocie
	public int getId_invoice() {
		return id_invoice;
	}
	public void setId_invoice(int id_invoice) {
		this.id_invoice = id_invoice;
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
