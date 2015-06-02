package tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import authLayer.DbConfig;
import controlLayer.CtrAddress;

public class TestCtrAddress {
	
	static CtrAddress ctrAddress;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		@SuppressWarnings("unused")
		DbConfig dbb = new DbConfig();
		ctrAddress = new CtrAddress();
		

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
	public void testCreateNewAddress() throws Exception {
		assertThat(ctrAddress.createNewAddress("TestCountry1", "TestCity1").getId_address(), not(equalTo(null)));
		assertThat(ctrAddress.createNewAddress("TestCountry1", "TestCity1").getId_address(), not(equalTo(0)));
		assertThat(ctrAddress.createNewAddress("TestCountry1", "TestCity1").getId_address(), not(equalTo(-1)));
	}

	@Test
	public void testGetAllAddresses() throws Exception {
		ctrAddress.createNewAddress("TestCountry2", "TestCity2");
		assertThat(ctrAddress.getAllAddresses(), not(equalTo(null)));
		assertThat(ctrAddress.getAllAddresses().size() == 0, not(true));
	}

	@Test
	public void testFindAddress() throws Exception {
		ctrAddress.createNewAddress("TestCountry3", "TestCity3");
		assertThat(ctrAddress.findAddress(ctrAddress.findAddressbyCountryAndCity("TestCountry3", "TestCity3").getId_address()).getCountry(), equalTo("TestCountry3"));
		assertThat(ctrAddress.findAddress(ctrAddress.findAddressbyCountryAndCity("TestCountry3", "TestCity3").getId_address()).getCity(), equalTo("TestCity3"));
	}

	@Test
	public void testSearchAddressByCountry() throws Exception {
		ctrAddress.createNewAddress("TestCountry4", "TestCity4");
		assertThat(ctrAddress.searchAddressByCountry("TestCountry4").size(), not(equalTo(0)));
	}

	@Test
	public void testSearchAddressByCity() throws Exception {
		ctrAddress.createNewAddress("TestCountry5", "TestCity5");
		assertThat(ctrAddress.searchAddressByCity("TestCity5").size(), not(equalTo(0)));
	}

	@Test
	public void testFindAddressbyCountryAndCity() throws Exception {
		ctrAddress.createNewAddress("TestCountry6", "TestCity6");
		assertThat(ctrAddress.findAddressbyCountryAndCity("TestCountry6", "TestCity6").getCountry(), equalTo("TestCountry6"));
		assertThat(ctrAddress.findAddressbyCountryAndCity("TestCountry6", "TestCity6").getCity(), equalTo("TestCity6"));
	}

	@Test
	public void testInsertAddress() throws Exception {
		ctrAddress.insertAddress("TestCountry7", "TestCity7");
		assertThat(ctrAddress.findAddressbyCountryAndCity("TestCountry7", "TestCity7").getCountry(), equalTo("TestCountry7"));
		assertThat(ctrAddress.findAddressbyCountryAndCity("TestCountry7", "TestCity7").getCity(), equalTo("TestCity7"));
	}

	@Test
	public void testUpdateAddress() throws Exception {
		ctrAddress.insertAddress("TestCountry8", "TestCity8");
		int tmpID = ctrAddress.findAddressbyCountryAndCity("TestCountry8", "TestCity8").getId_address();
		ctrAddress.updateAddress(tmpID, "TestCountry8updated", "TestCity8updated");
		assertThat(ctrAddress.findAddress(tmpID).getCountry(), equalTo("TestCountry8updated"));
		assertThat(ctrAddress.findAddress(tmpID).getCity(), equalTo("TestCity8updated"));
	}

	@Test
	public void testRemoveAddress() throws Exception {
		ctrAddress.insertAddress("TestCountry9", "TestCity9");
		int tmpID = ctrAddress.findAddressbyCountryAndCity("TestCountry9", "TestCity9").getId_address();
		ctrAddress.removeAddress(tmpID);
		assertThat(ctrAddress.findAddress(tmpID), equalTo(null));
	}

}
