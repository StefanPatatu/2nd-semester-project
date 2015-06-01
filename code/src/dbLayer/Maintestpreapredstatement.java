package dbLayer;

import java.util.ArrayList;

import authLayer.DbConfig;
import modelLayer.Item;
import controlLayer.CtrItem;

public class Maintestpreapredstatement {
	
	private static CtrItem ctrItem;

	public static void main(String[] args) {
		ctrItem = new CtrItem();
		try {
			DbConfig dbconfing = new DbConfig();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			Item item = ctrItem.findItemByBarcode("barcode");
			
			ArrayList<Item> items = ctrItem.searchItemsByStockRange(1, 1);
			
			System.out.println(items.get(0).getName());
			
			System.out.println(item.getBarcode());
			System.out.println(item.getCategory());
			System.out.println(item.getId_item());
			System.out.println(item.getItemType());
			System.out.println(item.getName());
			System.out.println(item.getPrice());
			System.out.println(item.getStock());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		try {
			Item item = createItem();
			
			System.out.println(insertItemTest(item));
			
			item = ctrItem.findItemByBarcode("barcode");
			System.out.println(item.getBarcode());
			System.out.println(item.getCategory());
			System.out.println(item.getId_item());
			System.out.println(item.getItemType());
			System.out.println(item.getName());
			System.out.println(item.getPrice());
			System.out.println(item.getStock());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	*/
	}
	
	private static Item createItem() {
		Item item = new Item("barcode", "name", 12, 1, "type", "cat");
		return item;
	}
	
	private static int insertItemTest() throws Exception {
		return ctrItem.insertItem("12", "name", 12, 1, "type", "cat");
	}

}
