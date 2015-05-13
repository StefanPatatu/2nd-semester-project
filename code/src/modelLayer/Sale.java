package modelLayer;

import java.sql.Timestamp;

/**
 * Sale
 * 
 * @author futz
 * @version 1.0
 */

public class Sale {
	
	private Timestamp dateCreated;
	private boolean isPacked;
	private Timestamp datePacked;
	private boolean isSent;
	private Timestamp dateSent;
	private boolean isPaid;
	private Timestamp datePaid;
	
	//constructor
	public Sale(
			Timestamp dateCreated,
			boolean isPacked,
			Timestamp datePacked,
			boolean isSent,
			Timestamp dateSent,
			boolean isPaid,
			Timestamp datePaid) {
		this.setDateCreated(dateCreated);
		this.setPacked(isPacked);
		this.setDatePacked(datePacked);
		this.setSent(isSent);
		this.setDateSent(dateSent);
		this.setPaid(isPaid);
		this.setDatePaid(datePaid);
	}

	//dateCreated
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	//packed
	public boolean isPacked() {
		return isPacked;
	}
	public void setPacked(boolean isPacked) {
		this.isPacked = isPacked;
	}

	//datePacked
	public Timestamp getDatePacked() {
		return datePacked;
	}
	public void setDatePacked(Timestamp datePacked) {
		this.datePacked = datePacked;
	}

	//sent
	public boolean isSent() {
		return isSent;
	}
	public void setSent(boolean isSent) {
		this.isSent = isSent;
	}

	//dateSent
	public Timestamp getDateSent() {
		return dateSent;
	}
	public void setDateSent(Timestamp dateSent) {
		this.dateSent = dateSent;
	}

	//paid
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

}
