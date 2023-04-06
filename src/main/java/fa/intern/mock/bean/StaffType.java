package fa.intern.mock.bean;

public class StaffType {
	private int idStaffType;
	private String staffType;
	private String details;
	public int getIdStaffType() {
		return idStaffType;
	}
	public void setIdStaffType(int idStaffType) {
		this.idStaffType = idStaffType;
	}
	public String getStaffType() {
		return staffType;
	}
	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public StaffType(int idStaffType, String staffType, String details) {
		super();
		this.idStaffType = idStaffType;
		this.staffType = staffType;
		this.details = details;
	}
	@Override
	public String toString() {
		return idStaffType + "-" + staffType;
	}
	
	public StaffType() {
		// TODO Auto-generated constructor stub
	}
}
