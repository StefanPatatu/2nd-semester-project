package modelLayer;

/**
 * SaleLine
 * 
 * @author Monika
 * @version 1.0
 */

public class SaleLine {
	private int quantity;
	private double price;
	private int discount;
	private Item item;
	private Sale sale; 
	
	
  public SaleLine (
		  int quantity,
		  double price,
		  int discount,
		  Item item,
		  Sale sale) {
	  this.setQuantity(quantity);
	  this.setPrice(price);
	  this.setDiscount(discount);
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
	//discount
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
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
