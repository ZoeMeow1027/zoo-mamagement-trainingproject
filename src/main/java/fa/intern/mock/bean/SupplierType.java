package fa.intern.mock.bean;

public class SupplierType {
	private int id;
	private String supplierType;
	public SupplierType(int id, String supplierType) {
		super();
		this.id = id;
		this.supplierType = supplierType;
	}
	public SupplierType() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSupplierType() {
		return supplierType;
	}
	public void setSupplierType(String supplierType) {
		this.supplierType = supplierType;
	}
}
