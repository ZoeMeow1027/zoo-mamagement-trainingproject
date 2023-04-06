package fa.intern.mock.bean;

public class Product {
	private int id;
	private String name;
	private int amount;
	private int idSupplier;
	private int idInventory;
	private int price;
	private Supplier supplier;
	public Product(int id, String name, int amount, int idSupplier, int idInventory, int price) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.idSupplier = idSupplier;
		this.idInventory = idInventory;
		this.price = price;
	}
	public Product() {
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getIdSupplier() {
		return idSupplier;
	}
	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}
	public int getIdInventory() {
		return idInventory;
	}
	public void setIdInventory(int idInventory) {
		this.idInventory = idInventory;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public Product(int id, String name, int amount, int idSupplier, int idInventory, int price,
			Supplier supplier) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.idSupplier = idSupplier;
		this.idInventory = idInventory;
		this.price = price;
		this.supplier = supplier;
	}
	
}
