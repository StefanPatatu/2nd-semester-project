package tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.sql.Timestamp;
import java.util.ArrayList;

import modelLayer.SaleLine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import authLayer.DbConfig;
import controlLayer.CtrCustomer;
import controlLayer.CtrEmployee;
import controlLayer.CtrItem;
import controlLayer.CtrSale;

/**
 * TestCtrSale
 * 
 * @author futz
 * @version 1.0
 */

public class TestCtrSale {
	
	static CtrSale ctrSale;
	static CtrEmployee ctrEmployee;
	static CtrCustomer ctrCustomer;
	static CtrItem ctrItem;
	static int testEmployeeID;
	static int testCustomerID;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		@SuppressWarnings("unused")
		DbConfig dbb = new DbConfig();
		ctrSale = new CtrSale();
		ctrEmployee = new CtrEmployee();
		ctrCustomer = new CtrCustomer();
		ctrItem = new CtrItem();
		
		ctrItem.insertItem("TestBarcode1", "TestItem1", 23, 1, "TestItemType", "TestItemCat");
		
		ctrEmployee.insertEmployee("TestEmpID", "TestEmpName", "TestEmpPhoneNr", "TestEmpEmail", "TestEmpPass", 3, "TestEmpCountry", "TestEmpCity", "TestEmpStreet");
		testEmployeeID = ctrEmployee.findEmployeeByPerson_id("TestEmpID").getId_employee();
		
		ctrCustomer.insertCustomer("TestCustName", "TestCustCountry", "TestCustCity", "TestCustStreet", "TestCustPhoneNr", "TestCustEmail");
		testCustomerID = ctrCustomer.searchCustomerByName("TestCustName").get(0).getId_customer();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetAllSales() throws Exception {
		ArrayList<SaleLine> saleLines = ctrSale.startSale();
		ctrSale.addSaleLineToSale(23, "TestBarcode1", saleLines);
		java.util.Date date= new java.util.Date();
		Timestamp dateTest = new Timestamp(date.getTime());
		ctrSale.insertSale("1001", true, dateTest, true, dateTest, true, dateTest, testEmployeeID, testCustomerID, saleLines, -1);
		assertThat(ctrSale.getAllSales(), not(equalTo(null)));
		assertThat(ctrSale.getAllSales().size() == 0, not(true));
	}

	@Test
	public void testFindSaleById_sale() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindSaleBySaleNr() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchSaleBySaleStatuses() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchSaleByDateCreatedInterval() {
		fail("Not yet implemented");
	}

	@Test
	public void testStartSale() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddSaleLineToSale() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertSale() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSaleIsPacked() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSaleIsSent() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSaleIsPaid() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllUnpaidSalesForCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllSalesForCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSaleTotalPrice() {
		fail("Not yet implemented");
	}

}
