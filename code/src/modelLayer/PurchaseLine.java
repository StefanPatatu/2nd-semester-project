package modelLayer;

public class PurchaseLine {
	int id_purchaseLine;
	int quantity;
	double price;
	Purchase purchase;
	Item item;
	
	
	public PurchaseLine(int id_purchaseLine, int quantity, double price, Purchase purchase, Item item)
	{
		this.setId_purchaseLine(id_purchaseLine);
		this.setQuantity(quantity);
		this.setPrice(price);
		this.setPurchase(purchase);
		this.setItem(item);
		
	
	}
	
	
	public int getId_purchaseLine() {
		return id_purchaseLine;
	}


	public void setId_purchaseLine(int id_purchaseLine) {
		this.id_purchaseLine = id_purchaseLine;
	}


	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
