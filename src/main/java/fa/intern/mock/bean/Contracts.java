package fa.intern.mock.bean;

public class Contracts {
	private int id;
	private String details;
	public Contracts(int id, String details) {
		super();
		this.id = id;
		this.details = details;
	}
	public Contracts() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}
