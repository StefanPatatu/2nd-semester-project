package dbLayer;

import java.util.ArrayList;

import modelLayer.Employee;

/**
*DbEmployeeInterface
*
*@author DarkSun
*@version 1.0
*/

public interface DbEmployeeInterface {
	
	public ArrayList<Employee> getAllEmployees();
	public Employee findEmployeeById_employee(int id_employee);
	public Employee findEmployeeByPerson_id(String person_id);
	public ArrayList<Employee> searchEmployeeByName(String name);
	public ArrayList<Employee> searchEmployeeByRights(int rights);
	public String getEmployeePass(int person_id);
	public String getEmployeeSalt(int person_id);
	public int insertEmployee(Employee e);
	public int updateEmployee(Employee e);

}
