package dbLayer;

import java.util.ArrayList;

import modelLayer.Item;

/**
 * DbInterface
 * 
 * @author Kool-kat
 * @version 1.0
 */

public interface DbItemInterface {
	
	public ArrayList<Item> getAllItems();
	public Item findItemById_Item(int id_item);
	public Item findItemByBarcode(String barcode);
	public ArrayList<Item> searchItemByName(String name);
	public int insertItem(Item i);
	public int updateItem(Item i);

}
