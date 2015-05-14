package modelLayer;

import java.sql.Timestamp;

/**
 * Customer
 * 
 * @author Monika
 * @version 1.0
 */

public class Invoice {
	private String invoiceNr;
	private Timestamp paymentDate;
	
	//invoice number
	public String getInvoiceNr() {
		return invoiceNr;
	}
	public void setInvoiceNr(String invoiceNr) {
		this.invoiceNr = invoiceNr;
	}
	//payment date
	public Timestamp getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}

}
