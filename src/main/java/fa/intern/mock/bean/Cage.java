package fa.intern.mock.bean;

public class Cage {
	private int idCage;
	protected String nameCage;
	protected int limit;
	protected Staff staffs;
	
	public int getIdCage() {
		return idCage;
	}



	public void setIdCage(int idCage) {
		this.idCage = idCage;
	}



	public String getNameCage() {
		return nameCage;
	}



	public void setNameCage(String nameCage) {
		this.nameCage = nameCage;
	}



	public int getLimit() {
		return limit;
	}



	public void setLimit(int limit) {
		this.limit = limit;
	}



	public Staff getStaffs() {
		return staffs;
	}



	public void setStaffs(Staff staffs) {
		this.staffs = staffs;
	}


	public Cage(String nameCage, int limit, Staff staffs) {
		super();
		this.nameCage = nameCage;
		this.limit = limit;
		this.staffs = staffs;
	}



	public Cage() {
		super();
	}

	
}