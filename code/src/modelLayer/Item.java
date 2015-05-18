package modelLayer;

/**
 * Item
 * 
 * @author Kristis133 + futz
 * @version 1.2
 */

public class Item {
	
	private int id_item;
	private String barcode;
	private String name;
	private double price;
	private int stock;
	private String itemType;
	private String category;
	
	//constructor
	public Item(
			int id_item,
			String barcode,
			String name,
			double price,
			int stock,
			String itemType,
			String category) {
		this.setId_item(id_item);
		this.setBarcode(barcode);
		this.setName(name);
		this.setPrice(price);
		this.setStock(stock);
		this.setItemType(itemType);
		this.setCategory(category);
	}
	
	//id_item
	public int getId_item() {
		return id_item;
	}
	public void setId_item(int id_item) {
		this.id_item = id_item;
	}

	//barcode
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	//name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//price
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	//stock
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	//itemType
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	//category
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
