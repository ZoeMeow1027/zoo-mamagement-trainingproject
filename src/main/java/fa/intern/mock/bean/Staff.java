package fa.intern.mock.bean;

public class Staff {
	private int idStaff;
	private String staffName;
	private int salary;
	private int idContract;
	private int idStaffType;
	private String username;

	public int getIdStaff() {
		return idStaff;
	}

	public void setIdStaff(int idStaff) {
		this.idStaff = idStaff;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getIdContract() {
		return idContract;
	}

	public void setIdContract(int idContract) {
		this.idContract = idContract;
	}

	public int getIdStaffType() {
		return idStaffType;
	}

	public void setIdStaffType(int idStaffType) {
		this.idStaffType = idStaffType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Staff(int idStaff, String staffName, int salary, int idContract, int idStaffType, String username) {
		super();
		this.idStaff = idStaff;
		this.staffName = staffName;
		this.salary = salary;
		this.idContract = idContract;
		this.idStaffType = idStaffType;
		this.username = username;
	}

	@Override
	public String toString() {
		return "Staff [idStaff=" + idStaff + ", staffName=" + staffName + ", salary=" + salary + ", idContract="
				+ idContract + ", idStaffType=" + idStaffType + ", username=" + username + "]";
	}

	public Staff() {
		// TODO Auto-generated constructor stub
	}
}
