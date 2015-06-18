package tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import authLayer.DbConfig;
import controlLayer.CtrEmployee;

/**
 * TestCtrEmployee
 * 
 * @author futz
 * @version 1.0
 */

public class TestCtrEmployee {
	
	static CtrEmployee ctrEmployee;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		@SuppressWarnings("unused")
		DbConfig dbb = new DbConfig();
		ctrEmployee = new CtrEmployee();
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
	public void testCtrEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllEmployees() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindEmployeeById_employee() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindEmployeeByPerson_id() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchEmployeeByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSearchEmployeeByRights() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployeePass() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmployeeSalt() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testAuthenticateEmployee() {
		try {
			ctrEmployee.insertEmployee("futzid1", "futz22", "futz32", "futz42", "futzpass1", 1, "futz68", "futz78", "futz88");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertThat(ctrEmployee.authenticateEmployee("futzid1", "futzpass1"), equalTo(1));
	}

}
