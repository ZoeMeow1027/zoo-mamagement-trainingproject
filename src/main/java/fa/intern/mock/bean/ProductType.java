package fa.intern.mock.bean;

public class ProductType {
	private int id;
	private String name;
	public ProductType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public ProductType() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
