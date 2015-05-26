package dbLayer;

import java.util.ArrayList;

import modelLayer.Item;

/**
 * DbInterface
 * 
 * @author Kool-kat + futz
 * @version 1.1
 */

public interface DbItemInterface {
	
	public ArrayList<Item> getAllItems() throws Exception;
	public Item findItemById_Item(int id_item) throws Exception;
	public Item findItemByBarcode(String barcode) throws Exception;
	public ArrayList<Item> searchItemByName(String name) throws Exception;
	public ArrayList<Item> searchItemsByStockRange(int min, int max) throws Exception;
	public int insertItem(Item i) throws Exception;
	public int updateItem(Item i) throws Exception;

}
