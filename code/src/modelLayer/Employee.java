package modelLayer;

/**
 * Employee
 * 
 * @author futz
 * @version 1.2
 */

public class Employee {
	
	private String person_id;
	private String name;
	private Address address;
	private String phoneNr;
	private String email;
	private int rights;
	
	//constructor
	public Employee(
			String person_id,
			Address address,
			String street,
			String phoneNr,
			String email,
			int rights) {
		this.setPerson_id(person_id);
		this.setName(name);
		this.setAddress(address);
		this.setPhoneNr(phoneNr);
		this.setEmail(email);
		this.setRights(rights);
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
	
	//rights
	public int getRights() {
		return rights;
	}
	public void setRights(int rights) {
		this.rights = rights;
	}
	
}
