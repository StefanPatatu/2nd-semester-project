package dbLayer;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;

import authLayer.DbConfig;
import modelLayer.Item;
import modelLayer.Sale;
import modelLayer.SaleLine;
import controlLayer.CtrEmployee;
import controlLayer.CtrItem;
import controlLayer.CtrSale;

public class Maintestpreapredstatement {
	
	private static CtrItem ctrItem;
	private static CtrSale ctrSale;
	private static CtrEmployee ctrEmployee;
	private static DbConnection dbConnection;
	private static CheckConnection checkCOn;

	public static void main(String[] args) {
		
		
		
		
		
		ctrItem = new CtrItem();
		ctrSale = new CtrSale();
		ctrEmployee = new CtrEmployee();
		
		
		try {
			DbConfig dbconfing = new DbConfig();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*
		for(int i = 1; i<5; i++) {
			checkCOn = new CheckConnection();
			boolean bla = checkCOn.isValidd();
			if(bla) {
				System.out.println("is");
			} else {
				System.out.println("is not");
			}
		}
		*/
		try {
			System.out.println(ctrEmployee.insertEmployee("34", "emp210", "445s450", "ecmp@esmp0", "monkey0", 1, "Ro00000", "tralala00000", "street0000"));
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		/*
		System.out.println("-----------");
		
		Timestamp tms = null;
		
		ArrayList<SaleLine> saleLines = ctrSale.startSale();
		System.out.println(ctrSale.addSaleLineToSale(1, "barcode", saleLines));
		try {
			System.out.println("-----------");
			System.out.println("-----------");
			System.out.println("-----------");
			System.out.println(ctrSale.insertSale("101", true, tms, false, tms, false, tms, 1, 1, saleLines, -1));
			System.out.println("-----------");
			System.out.println("-----------");
			System.out.println("-----------");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		System.out.println("-----------");
		
		
		
		
		
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
	
	
	/////
	private static String checkConnection() {
		if(DbConnection.isValid()) {
			return "open";
		} else {
			return "closed";
		}
	}

}
