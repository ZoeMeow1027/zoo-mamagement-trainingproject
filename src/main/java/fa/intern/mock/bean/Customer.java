package fa.intern.mock.bean;

public class Customer {
	private int id_Customer;
	private String customer_Name;
	private String address;
	private String email;
	private String phone;
	private String username;
	
	public int getId_Customer() {
		return id_Customer;
	}
	
	public void setId_Customer(int id_Customer) {
		this.id_Customer = id_Customer;
	}
	
	public String getCustomer_Name() {
		return customer_Name;
	}
	
	public void setCustomer_Name(String customer_Name) {
		this.customer_Name = customer_Name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public Customer(int id_Customer, String customer_Name, String address, String email, String phone,
			String username) {
		super();
		this.id_Customer = id_Customer;
		this.customer_Name = customer_Name;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.username = username;
	}

	public Customer() {
		super();
	}
	
	
}	
