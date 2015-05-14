

package modelLayer;


public class Item {
	
	private String barcode;
	private String name;
	private int price;
	private int stock;
	private String type;
	private String category;
	
	//constructor
	public Item(
			String barcode,
			String name,
			int price,
			int stock,
			String type,
			String category) {
		this.setBarcode(barcode);;
		this.setName(name);;
		this.setPrice(price);;
		this.setStock(stock);;;
		this.setType(type);;
		this.setCategory(category);;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	//stock
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	//type
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	//category
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}