package dbLayer;

import java.sql.*;
import java.util.ArrayList;

import modelLayer.Address;
import modelLayer.Employee;

/**
 * DbEmployee
 * 
 * @author DarkSun
 * @version 1.0
 */

public class DbEmployee implements DbEmployeeInterface {

	@Override
	public ArrayList<Employee> getAllEmployees() {
		return miscWhere("", false);
	}

	@Override
	public Employee findEmployee(int id_employee) {
		Employee emp = singleWhere("id_employee=" + id_employee, false);
		return emp;
	}

	@Override
	public ArrayList<Employee> searchEmployeeByName(String name) {
		return miscWhere("name LIKE '%" + name + "%'", false);
	}

	@Override
	public int insertEmployee(Employee emp) {
		int result = 0;
		String string = "INSERT INTO " + authLayer.DbConfig.getTablePrefix() + "Employee (person_id, name, phoneNr, email, street, rights) VALUES (?,?)";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon().prepareStatement()) {
			statement.setString(1, emp.getPerson_id());
			statement.setString(2, emp.getName());
			statement.setString(3, emp.getPhoneNr());
			statement.setString(4, emp.getEmail());
			statement.setString(5, emp.getStreet());
			statement.setInt(6, emp.getId_employee());
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
	public int updateEmployee(Employee emp) {
		int result = 0;
		String string = "UPDATE " + authLayer.DbConfig.getTablePrefix() + "Employee SET person_id=?, name=?, phoneNr=?, email=?, street=? rights=? WHERE id_employee=? ";
		try (PreparedStatement statement = DbConnection.getInstance().getDbCon.prepareStatement()) {
			statement.setString(1, emp.getPerson_id());
			statement.setString(2, emp.getName());
			statement.setObject(3, emp.getAddress());
			statement.setString(4, emp.getStreet());
			statement.setString(5, emp.getPhoneNr());
			statement.setString(6, emp.getEmail());
			statement.setInt(7, emp.getRights());
			statement.setInt(8, emp.getId_employee());
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("updateEmployee.DbEmployee.dbLayer", sqle);
		} catch (Exception e) {
			throw new Exception ("updateEmployee.DbEmployee.dbLayer", e);
		}
		
		return result;
	}

	@Override
	public int removeEmployee(Employee emp) {
		if (emp == null) {
		return 0;
		}
		int result = 0;
		String string = "DELETE FROM " + authLayer.DbConfig.getTablePrefix() + "Employee WHERE id_employee=?";
		try (PreparedStatement statement = DbConnection.getInstance().getDbon().prepareStatement()) {
			statement.setInt(1, emp.getId_employee());
			result = statement.executeUpdate();
		} catch (SQLException sqle) {
			throw new SQLException("removeEmployee.DbEmployee.dbLayer", sqle); 
		} catch (Exception e) { 
			throw new Exception("removeEmployee.DbEmployee.dbLayer", e);
		}
		return result;
	}
	
	private String buildQuery(String where) {
		String string = "Select * FROM " + authLayer.DbConfig.getTablePrefix() + "Employee";
		if (where!= null && where.length() > 0) {
			string += "WHERE" + where;
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
					(Address) resultSet.getObject("address"),
					resultSet.getString("street"),
					resultSet.getString("phoneNr"),
					resultSet.getString("email"),
					resultSet.getInt("rights"));
		} catch (Exception e) {
			throw new Exception("buildEmployee.DbEmployee.dblayer");
		}
		return emp;
	}
	
	private Employee singleWhere(String where, boolean retrieveAssoc) {
		ArrayList<Employee> employees = miscWhere(where, retrieveAssoc);
		if(employees.size() > 0) {
			return employees.get(0);
		} else {
			return null;
		}
	}
	
	private ArrayList<Employee> miscWhere(String where, boolean retrieveAssoc) {
		ResultSet rsresultSet;
		ArrayList<Employee> employees = new ArrayList<>();
		String string = buildQuery(where);
		try (Statement statement = DbConnection.getInstance().getDBcon()createStatement()) {
			statement.setQueryTimeout(5);
			rsresultSet = statement.executeQuery(string);
			while (rsresultSet.next()) {
				Employee emp = buildEmployee(rsresultSet);
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
