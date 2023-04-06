package fa.intern.mock.bean;

public class Bill {
	private int id;
	private int billType;
	private String name;
	private int idSupplier;
	private Supplier supplier;
	public Bill(int id, int billType, String name, int idSupplier, Supplier supplier) {
		super();
		this.id = id;
		this.billType = billType;
		this.name = name;
		this.idSupplier = idSupplier;
		this.supplier = supplier;
	}
	public Bill(int id, int billType, String name, int idSupplier) {
		super();
		this.id = id;
		this.billType = billType;
		this.name = name;
		this.idSupplier = idSupplier;
	}
	public Bill() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBillType() {
		return billType;
	}
	public void setBillType(int billType) {
		this.billType = billType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIdSupplier() {
		return idSupplier;
	}
	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
