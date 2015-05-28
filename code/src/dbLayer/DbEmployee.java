package dbLayer;

import java.sql.*;
import java.util.ArrayList;

import modelLayer.Address;
import modelLayer.Employee;

/**
 * DbEmployee
 * 
 * @author DarkSun + futz
 * @version 1.3
 */

public class DbEmployee implements DbEmployeeInterface {
	
	private DbAddressInterface dbAddress = new DbAddress();

	@Override
	public ArrayList<Employee> getAllEmployees() throws Exception {
		return miscWhere("", false);
	}

	@Override
	public Employee findEmployeeById_employee(int id_employee) throws Exception {
		Employee emp = singleWhere("id_employee=" + id_employee, true);
		return emp;
	}
	
	@Override
	public Employee findEmployeeByPerson_id(String person_id) throws Exception {
		Employee emp = singleWhere("person_id=" + person_id, true);
		return emp;
	}

	@Override
	public ArrayList<Employee> searchEmployeeByName(String name) throws Exception {
		return miscWhere("name LIKE '%" + name + "%'", false);
	}
	
	@Override
	public ArrayList<Employee> searchEmployeeByRights(int rights) throws Exception {
		return miscWhere("rights LIKE '%" + rights + "%'", false);
	}
	
	@Override
	public String getEmployeePass(int person_id) throws Exception {
		Employee emp = singleWhere("person_id=" + person_id, false);
		if(emp == null) {
			return null;
		} else {
			return emp.getPass();
		}
	}
	
	@Override
	public String getEmployeeSalt(int person_id) throws Exception {
		Employee emp = singleWhere("person_id=" + person_id, false);
		if(emp == null) {
			return null;
		} else {
			return emp.getSalt();
		}
	}

	@Override
	public int insertEmployee(Employee emp) throws Exception {
		int result = 0;
		String string = "INSERT INTO " + authLayer.DbConfig.DBTablePrefix + "Employee (person_id, name, phoneNr, email, pass, salt, rights, e_address, street) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setString(1, emp.getPerson_id());
			statement.setString(2, emp.getName());
			statement.setString(3, emp.getPhoneNr());
			statement.setString(4, emp.getEmail());
			statement.setString(5, emp.getPass());
			statement.setString(6, emp.getSalt());
			statement.setInt(7, emp.getRights());
			statement.setInt(8, emp.getAddress().getId_address());
			statement.setString(9, emp.getStreet());
			result = statement.executeUpdate(string, Statement.RETURN_GENERATED_KEYS);
			int id_employee = new GeneratedKey().getGeneratedKey(statement);
			emp.setId_employee(id_employee);
		} catch (SQLException sqle) {
			throw new SQLException("insertEmployee.DbEmployee.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception("insertEmployee.DbEmployee.dbLayer", e); 
		}
		return result;
	}

	@Override
	public int updateEmployee(Employee emp) throws Exception {
		int result = 0;
		String string = "UPDATE " + authLayer.DbConfig.DBTablePrefix + "Employee SET person_id=?, name=?, phoneNr=?, email=?, pass=?, salt=?, rights=?, e_address=?, street=? WHERE id_employee=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement(string)) {
			statement.setString(1, emp.getPerson_id());
			statement.setString(2, emp.getName());
			statement.setString(3, emp.getPhoneNr());
			statement.setString(4, emp.getEmail());
			statement.setString(5, emp.getPass());
			statement.setString(6, emp.getSalt());
			statement.setInt(7, emp.getRights());
			statement.setInt(8, emp.getAddress().getId_address());
			statement.setString(9, emp.getStreet());
			statement.setInt(10,  emp.getId_employee());
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("updateEmployee.DbEmployee.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception ("updateEmployee.DbEmployee.dbLayer", e);
		}
		return result;
	}
	
	private String buildQuery(String where) {
		String string = "Select * FROM " + authLayer.DbConfig.DBTablePrefix + "Employee";
		if (where != null && where.length() > 0) {
			string += " WHERE " + where;
		}
		return string;
	}
	
	private Employee buildEmployee(ResultSet resultSet) throws Exception {
		Employee emp = null;
		try {
			emp = new Employee(
					resultSet.getInt("id_employee"),
					resultSet.getString("person_id"),
					resultSet.getString("name"),
					new Address(resultSet.getInt("e_address")),
					resultSet.getString("street"),
					resultSet.getString("phoneNr"),
					resultSet.getString("email"),
					resultSet.getString("pass"),
					resultSet.getString("salt"),
					resultSet.getInt("rights"));
		} catch (Exception e) {
			throw new Exception("buildEmployee.DbEmployee.dblayer");
		}
		return emp;
	}
	
	private Employee singleWhere(String where, boolean retrieveAssoc) throws Exception {
		ArrayList<Employee> employees = miscWhere(where, retrieveAssoc);
		if(employees.size() > 0) {
			if(retrieveAssoc) {
				employees.get(0).setAddress(dbAddress.findAddress(employees.get(0).getAddress().getId_address()));
			}
			return employees.get(0);
		} else {
			return null;
		}
	}
	
	private ArrayList<Employee> miscWhere(String where, boolean retrieveAssoc) throws Exception {
		ResultSet resultSet;
		ArrayList<Employee> employees = new ArrayList<>();
		String string = buildQuery(where);
		try (Statement statement = DbConnection.getInstance().getDbCon().createStatement()) {
			statement.setQueryTimeout(5);
			resultSet = statement.executeQuery(string);
			while(resultSet.next()) {
				Employee emp = buildEmployee(resultSet);
				if(retrieveAssoc) {
					//nothing
				}
				employees.add(emp);
			}
		} catch (Exception e) {
				throw new Exception("miscWhere.DbEmployee.dblayer", e);
			}
			return employees;
		}

}
