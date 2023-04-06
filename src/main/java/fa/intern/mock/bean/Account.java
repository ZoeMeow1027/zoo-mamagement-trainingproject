package fa.intern.mock.bean;

public class Account {
	private String username;
	private String password;
	private int id_Account_Type;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public int getId_Account_Type() {
		return id_Account_Type;
	}

	public void setId_Account_Type(int id_Account_Type) {
		this.id_Account_Type = id_Account_Type;
	}

	public Account(String userName, String passWord, int iD_Account_Type) {
		super();
		username = userName;
		password = passWord;
		id_Account_Type = iD_Account_Type;
	}

	public Account() {
		super();
	}
}
