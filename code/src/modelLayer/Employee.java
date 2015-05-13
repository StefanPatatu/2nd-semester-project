package modelLayer;

/**
 * Employee
 * 
 * @author futz
 * @version 1.0
 */

public class Employee {
	
	private String person_id;
	private String city;
	private String street;
	private String phoneNr;
	private String email;
	private int rights;
	
	//constructor
	public Employee(String person_id, String city, String street, String phoneNr, String email, int rights) {
		this.person_id = person_id;
		this.city = city;
		this.street = street;
		this.phoneNr = phoneNr;
		this.email = email;
		this.rights = rights;
	}
	
	//person_id
	public String getPerson_id() {
		return person_id;
	}
	public void setPerson_id(String person_id) {
		this.person_id = person_id;
	}
	//city
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
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
	public String geteMail() {
		return email;
	}
	public void seteMail(String eMail) {
		this.email = eMail;
	}
	//rights
	public int getRights() {
		return rights;
	}
	public void setRights(int rights) {
		this.rights = rights;
	}
	
}
