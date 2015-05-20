package modelLayer;

/**
 * Employee
 * 
 * @author futz
 * @version 1.4
 */

public class Employee {
	
	private int id_employee;
	private String person_id;
	private String name;
	private Address address;
	private String street;
	private String phoneNr;
	private String email;
	private String pass;
	private String salt;
	private int rights;
	
	//constructor
	public Employee(
			int id_employee,
			String person_id,
			String name,
			Address address,
			String street,
			String phoneNr,
			String email,
			String pass,
			String salt,
			int rights) {
		this.setId_employee(id_employee);
		this.setPerson_id(person_id);
		this.setName(name);
		this.setAddress(address);
		this.setStreet(street);
		this.setPhoneNr(phoneNr);
		this.setEmail(email);
		this.setRights(rights);
	}
	
	//id_employee
	public int getId_employee() {
		return id_employee;
	}
	public void setId_employee(int id_employee) {
		this.id_employee = id_employee;
	}

	//person_id
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	
	//name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//address
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	//street
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}

	//phoneNr
	public String getPhoneNr() {
		return phoneNr;
	}
	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}
	
	//email
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//pass
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	//salt
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}

	//rights
	public int getRights() {
		return rights;
	}
	public void setRights(int rights) {
		this.rights = rights;
	}
	
}
