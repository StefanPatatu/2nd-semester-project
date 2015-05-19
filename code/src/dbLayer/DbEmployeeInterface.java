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
	public Employee findEmployee(int id_employee);
	public ArrayList<Employee> searchEmployeeByName(String name);
	public int insertEmployee(Employee e);
	public int updateEmployee(Employee e);
	public int removeEmployee(Employee e);

}