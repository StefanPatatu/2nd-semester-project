package modelLayer;

import java.sql.Timestamp;

public class Purchase {
	int id_purchase;
	Timestamp dateOrdered;
	Timestamp dateDelivered;
	Supplier supplier;
	
	public Purchase( int id_purchase, Timestamp dateOrdered, Timestamp dateDelivered, Supplier supplier)
	{	this.setId_purchase(id_purchase);
		this.setDateOrdered(dateOrdered);
		this.setDateDelivered(dateDelivered);
		this.setSupplier(supplier);
	}
	
	public int getId_purchase() {
		return id_purchase;
	}

	public void setId_purchase(int id_purchase) {
		this.id_purchase = id_purchase;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	
	
	
	public Timestamp getDateOrdered() {
		return dateOrdered;
	}
	public void setDateOrdered(Timestamp dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	public Timestamp getDateDelivered() {
		return dateDelivered;
	}
	public void setDateDelivered(Timestamp dateDelivered) {
		this.dateDelivered = dateDelivered;
	}
	
	

}
