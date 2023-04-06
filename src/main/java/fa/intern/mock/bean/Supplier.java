package fa.intern.mock.bean;

public class Supplier {
	private int id;
	private int idContract;
	private int idSupplierType;
	private String name;
	private Contracts contracts;
	private SupplierType supplierType;
	public Supplier(int id, int idContract, int idSupplierType, String name) {
		super();
		this.id = id;
		this.idContract = idContract;
		this.idSupplierType = idSupplierType;
		this.name = name;
	}
	public Supplier() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdContract() {
		return idContract;
	}
	public void setIdContract(int idContract) {
		this.idContract = idContract;
	}
	public int getIdSupplierType() {
		return idSupplierType;
	}
	public void setIdSupplierType(int idSupplierType) {
		this.idSupplierType = idSupplierType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Contracts getContracts() {
		return contracts;
	}
	public void setContracts(Contracts contracts) {
		this.contracts = contracts;
	}
	public SupplierType getSupplierType() {
		return supplierType;
	}
	public void setSupplierType(SupplierType supplierType) {
		this.supplierType = supplierType;
	}
	public Supplier(int id, int idContract, int idSupplierType, String name, Contracts contracts,
			SupplierType supplierType) {
		super();
		this.id = id;
		this.idContract = idContract;
		this.idSupplierType = idSupplierType;
		this.name = name;
		this.contracts = contracts;
		this.supplierType = supplierType;
	}
}
