package modelLayer;

/**
 * SaleLine
 * 
 * @author DarkSun + futz
 * @version 1.3
 */

public class SaleLine {
	
	private int id_saleLine;
	private int quantity;
	private double price;
	private Item item;
	
	//constructor
	public SaleLine (
			int id_saleLine,
			int quantity,
			double price,
			Item item) {
		this.setId_saleLine(id_saleLine);
		this.setQuantity(quantity);
		this.setPrice(price);
		this.setItem(item);
	}
	
	//id_saleLine
    public int getId_saleLine() {
		return id_saleLine;
	}
	public void setId_saleLine(int id_saleLine) {
		this.id_saleLine = id_saleLine;
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

}
