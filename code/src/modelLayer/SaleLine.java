package modelLayer;

/**
 * SaleLine
 * 
 * @author Monika +futz
 * @version 1.1
 */

public class SaleLine {
	private int quantity;
	private double price;
	private Item item;
	private Sale sale; 
	
	//constructor
	public SaleLine (
		  int quantity,
		  double price,
		  Item item,
		  Sale sale) {
	  this.setQuantity(quantity);
	  this.setPrice(price);
	  this.setItem(item);
	  this.setSale(sale); 
	}
	
    //quantity
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	//price
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	//item
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	
	//sale
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}

}
