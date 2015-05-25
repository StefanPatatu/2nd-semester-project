package modelLayer;

/**
 * 
 * @author Kool-kat
 * @version 1.0
 *
 */

public class Supplier {
	
	private int id_supplier;
	private String name;
	private String country;
	private String city;
	private String street;
	private String phoneNr;
	private String email;
	private boolean isActive;
	
	//constructor
	public Supplier (
			int id_supplier,
			String name,
			String country,
			String city,
			String street,
			String phoneNr,
			String email,
			boolean isActive) {
		this.setId_supplier(id_supplier);
		this.setName(name);
		this.setCountry(country);
		this.setCity(city);
		this.setStreet(street);
		this.setPhoneNr(phoneNr);
		this.setEmail(email);
		this.setActive(isActive);
		
	}

	//id_supplier
	public int getId_supplier() {
		return id_supplier;
	}
	public void setId_supplier(int id_supplier) {
		this.id_supplier = id_supplier;
	}
	
	//name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//country
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	//active
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
}
