package controlLayer;

import java.util.ArrayList;

import modelLayer.Item;
import dbLayer.DbItemInterface;
import dbLayer.DbItem;
import dbLayer.DbConnection;

/**
 * CtrItem
 * 
 * @author futz
 * @version 1.0
 */

public class CtrItem {
	
	private DbItemInterface dbItem;
	
	//constructor
	public CtrItem() {
		dbItem = new DbItem();
	}
	
	public ArrayList<Item> getAllItems() throws Exception {
		ArrayList<Item> items = new ArrayList<>();
		items = dbItem.getAllItems();
		return items;
	}
	
	public Item findItemById_item(int id_item) throws Exception {
		return dbItem.findItemById_Item(id_item);
	}
	
	public Item findItemByBarcode(String barcode) throws Exception {
		return dbItem.findItemByBarcode(barcode);
	}
	
	public ArrayList<Item> searchItemByName(String name) throws Exception {
		return dbItem.searchItemByName(name);
	}
	
	public ArrayList<Item> searchItemsByStockRange(int min, int max) throws Exception {
		min = Math.abs(min);
		max = Math.abs(max);
		if(max < min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		return dbItem.searchItemsByStockRange(min, max);
	}
	
	//returns 1 if successful
	//returns -12 if barcode already exists
	//returns -13 if the exact same name already exists
	//returns -14 if the conflict check could not be performed
	//returns -15 if the item could not be inserted
	//throws Exception if rollbackTransaction() fails -> means something terribly wrong happened
	public int insertItem(String barcode, String name, double price, int stock, String itemType, String category) throws Exception {
		int success;
		try {
			success = checkBarcodeAndNameIsUnique(-1, barcode, name);
		} catch (Exception e) {
			success = Errors.CONFLICT_CHECK.getCode();
		}
		if(success == 1) {
			//if we arrive here we can safely insert the item into the database
			Item item = new Item(barcode, name, price, stock, itemType, category);
			try {
				DbConnection.startTransaction();
				dbItem.insertItem(item);
				DbConnection.comitTransaction();
			} catch (Exception e) {
				try {
					DbConnection.rollbackTransaction();
				} catch (Exception r) {
					throw new Exception("insertItem.CtrItem.controlLayer", r);
				}
				success = Errors.INSERT_ITEM.getCode();
			}
		}
		//return the appropriate code
		return success;
	}
	
	//returns 1 if successful
	//returns -12 if barcode already exists
	//returns -13 if the exact same name already exists
	//returns -14 if the conflict check could not be performed
	//returns -16 if the item could not be inserted
	//throws Exception if rollbackTransaction() fails -> means something terribly wrong happened
	public int updateItem(int id_item, String barcode, String name, double price, int stock, String itemType, String category) throws Exception {
		int success;
		try {
			success = checkBarcodeAndNameIsUnique(id_item, barcode, name);
		} catch (Exception e) {
			success = Errors.CONFLICT_CHECK.getCode();
		}
		if(success == 1) {
			//if we arrive here we can safely insert the item into the database
			Item item = new Item(id_item, barcode, name, price, stock, itemType, category);
			try {
				DbConnection.startTransaction();
				dbItem.updateItem(item);
				DbConnection.comitTransaction();
			} catch (Exception e) {
				try {
					DbConnection.rollbackTransaction();
				} catch (Exception r) {
					throw new Exception("updatetItem.CtrItem.controlLayer", r);
				}
				success = Errors.UPDATE_ITEM.getCode();
			}
		}
		//return the appropriate code
		return success;
	}
		
	//check if an item with the exact same barcode or
	//with the exact same name already exists in the
	//database. If so, return appropriate error code
	//
	//returns 1 if there is no conflict
	//returns -12 if barcode already exists
	//returns -13 if the exact same name already exists
	private int checkBarcodeAndNameIsUnique(int id_item, String barcode, String name) throws Exception {
		int error = 1;
		Item item = findItemByBarcode(barcode);
		if(item != null) {
			if(item.getId_item() != id_item) {
				error = Errors.BARCODE_EXISTS.getCode();
			}
		} 
		ArrayList<Item> tmpArray = searchItemByName(name);
		for (Item tmpItem : tmpArray) {
			if(tmpItem.getName().equals(name) && tmpItem.getId_item() != id_item) {
				error = Errors.NAME_EXISTS.getCode();
				break;
			}
		}
		return error;
	}

}
