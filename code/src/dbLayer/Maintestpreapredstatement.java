package dbLayer;

import authLayer.DbConfig;
import modelLayer.Item;

public class Maintestpreapredstatement {
	
	private static DbItem dbItem;

	public static void main(String[] args) {
		dbItem = new DbItem();
		try {
			DbConfig dbconfing = new DbConfig();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			insertItemTest(createItem());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	private static Item createItem() {
		Item item = new Item("barcode", "name", 12, 1, "type", "cat");
		return item;
	}
	
	private static int insertItemTest(Item item) throws Exception {
		dbItem.insertItem(item);
		return 0;
	}

}
