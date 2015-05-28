package dbLayer;

import java.util.ArrayList;

import modelLayer.Employee;

/**
*DbEmployeeInterface
*
*@author DarkSun
*@version 1.2
*/

public interface DbEmployeeInterface {
	
	public ArrayList<Employee> getAllEmployees() throws Exception;
	public Employee findEmployeeById_employee(int id_employee, boolean retrieveAssoc) throws Exception;
	public Employee findEmployeeByPerson_id(String person_id, boolean retrieveAssoc) throws Exception;
	public ArrayList<Employee> searchEmployeeByName(String name) throws Exception;
	public ArrayList<Employee> searchEmployeeByRights(int rights) throws Exception;
	public String getEmployeePass(int person_id) throws Exception;
	public String getEmployeeSalt(int person_id) throws Exception;
	public int insertEmployee(Employee e) throws Exception;
	public int updateEmployee(Employee e) throws Exception;

}
