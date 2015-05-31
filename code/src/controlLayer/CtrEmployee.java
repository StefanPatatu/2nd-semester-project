package controlLayer;

import java.util.ArrayList;

import modelLayer.Employee;
import dbLayer.DbEmployeeInterface;
import dbLayer.DbEmployee;
import dbLayer.DbConnection;

import authLayer.SystemLogin;

/**
 * CtrEmployee
 * 
 * @author futz
 * @version 1.2
 */

public class CtrEmployee {
	
	private SystemLogin systemLogin;
	private DbEmployeeInterface dbEmployee;
	private CtrAddress ctrAddress;
	
	//constructor
	public CtrEmployee() {
		systemLogin = new SystemLogin();
		dbEmployee = new DbEmployee();
		ctrAddress = new CtrAddress();
	}
	
	public ArrayList<Employee> getAllEmployees() throws Exception {
		ArrayList<Employee> employees = new ArrayList<>();
		employees = dbEmployee.getAllEmployees();
		return employees;
	}
	
	public Employee findEmployeeById_employee(int id_employee) throws Exception {
		return dbEmployee.findEmployeeById_employee(id_employee, false);
	}
	
	public Employee findEmployeeByPerson_id(String person_id) throws Exception {
		return dbEmployee.findEmployeeByPerson_id(person_id, false);
	}
	
	public ArrayList<Employee> searchEmployeeByName(String name) throws Exception {
		return dbEmployee.searchEmployeeByName(name);
	}
	
	public ArrayList<Employee> searchEmployeeByRights(int rights) throws Exception {
		return dbEmployee.searchEmployeeByRights(rights);
	}
	
	public String getEmployeePass(int person_id) throws Exception {
		return dbEmployee.getEmployeePass(person_id);
	}
	
	public String getEmployeeSalt(int person_id) throws Exception {
		return dbEmployee.getEmployeeSalt(person_id);
	}
	
	//returns 1 if successful
	//returns negative value if unsuccessful
	//throws Exception if rollbackTransaction() fails -> means something terribly wrong happened
	public int insertEmployee(String person_id, String name, String phoneNr, String email, String pass, int rights, String country, String city, String street ) throws Exception {
		int success = 1;
		ArrayList<String> passAndSalt = systemLogin.getHashedPasswordAndSalt(pass);
		Employee employee = new Employee(person_id, name, ctrAddress.createNewAddress(country, city), street, phoneNr, email, passAndSalt.get(0), passAndSalt.get(1), rights);
		try {
			DbConnection.startTransaction();
			dbEmployee.insertEmployee(employee);
			DbConnection.comitTransaction();
		} catch (Exception e) {
			try {
				DbConnection.rollbackTransaction();
			} catch (Exception r) {
				throw new Exception("insertEmployee.CtrEmployee.controlLayer", r);
			}
			success = Errors.INSERT_EMPLOYEE.getCode();
		}
		return success;	
	}
	
	//returns 1 if successful
	//returns negative value if unsuccessful
	//throws Exception if rollbackTransaction() fails -> means something terribly wrong happened
	public int updateEmployee(int id_employee, String person_id, String name, String phoneNr, String email, String pass, int rights, String country, String city, String street ) throws Exception {
		int success = 1;
		ArrayList<String> passAndSalt = systemLogin.getHashedPasswordAndSalt(pass);
		Employee employee = new Employee(id_employee, person_id, name, ctrAddress.createNewAddress(country, city), street, phoneNr, email, passAndSalt.get(0), passAndSalt.get(1), rights);
		try {
			DbConnection.startTransaction();
			dbEmployee.updateEmployee(employee);
			DbConnection.comitTransaction();
		} catch (Exception e) {
			try {
				DbConnection.rollbackTransaction();
			} catch (Exception r) {
				throw new Exception("updateEmployee.CtrEmployee.controlLayer", r);
			}
			success = Errors.UPDATE_EMPLOYEE.getCode();
		}
		return success;	
	}
	
	//returns 1 if employee is worker
	//returns 2 if employee is cashier
	//returns 3 if employee is manager
	//returns negative value if the user can not be authenticated
	public int authenticateEmployee(String person_id, String password) {
		int rights = Errors.UNAUTHENTICATED_USER.getCode();
		Employee employee = new Employee();
		try {
			employee = findEmployeeByPerson_id(person_id);
			try {
				rights = systemLogin.Authenticate(employee.getId_employee(), employee.getPass(), employee.getSalt());
			} catch (Exception e) {
				rights = Errors.AUTHENTICATE_FAILED.getCode();	
			}
		} catch (Exception e) {
			rights = Errors.AUTHENTICATE_FAILED.getCode();
		}
		return rights;
	}

}
