package modelLayer;

import java.sql.Timestamp;

/**
 * Invoice
 * 
 * @author Monika
 * @version 1.0
 */

public class Invoice {
	private String invoiceNr;
	private Timestamp paymentDate;
	
	//constructor
	public Invoice() {
		this.setInvoiceNr(invoiceNr);
		this.setInvoiceNr(invoiceNr);
	}
	
	//invoice number
	public String getInvoiceNr() {
		return invoiceNr;
	}
	public void setInvoiceNr(String invoiceNr) {
		this.invoiceNr = invoiceNr;
	}
	//paymentDate
	public Timestamp getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}

}
