package fa.intern.mock.bean;

import java.util.Date;

public class BillDetail {
	private int id;
	private int idBill;
	private int amountTransfer;
	private int idProduct;
	private Date transferDate;
	private Bill bill;
	private Product product;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public int getAmountTransfer() {
		return amountTransfer;
	}
	public void setAmountTransfer(int amountTransfer) {
		this.amountTransfer = amountTransfer;
	}
	public Date getTransferDate() {
		return transferDate;
	}
	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public BillDetail(int id, int idBill, int amountTransfer, int idProduct, Date transferDate, Bill bill,
			Product product) {
		super();
		this.id = id;
		this.idBill = idBill;
		this.amountTransfer = amountTransfer;
		this.idProduct = idProduct;
		this.transferDate = transferDate;
		this.bill = bill;
		this.product = product;
	}
	public BillDetail() {
		super();
	}
	public BillDetail(int id, int idBill, int amountTransfer, int idProduct, Date transferDate) {
		super();
		this.id = id;
		this.idBill = idBill;
		this.amountTransfer = amountTransfer;
		this.idProduct = idProduct;
		this.transferDate = transferDate;
	}
}
