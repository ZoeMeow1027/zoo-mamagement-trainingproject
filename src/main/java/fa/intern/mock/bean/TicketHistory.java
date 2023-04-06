package fa.intern.mock.bean;

import java.time.LocalDate;

public class TicketHistory {
	private int id_Ticket_History;
	private LocalDate purchase_Date;
	private int amount;
	private int id_Ticket;
	private int id_Customer;

	private Staff staff;
	private Ticket ticket;
	private Customer customer;

	public int getId_Ticket_History() {
		return id_Ticket_History;
	}

	public void setId_Ticket_History(int id_Ticket_History) {
		this.id_Ticket_History = id_Ticket_History;
	}

	public LocalDate getPurchase_Date() {
		return purchase_Date;
	}

	public void setPurchase_Date(LocalDate purchase_Date) {
		this.purchase_Date = purchase_Date;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getId_Ticket() {
		return id_Ticket;
	}

	public void setId_Ticket(int id_Ticket) {
		this.id_Ticket = id_Ticket;
	}

	public int getId_Customer() {
		return id_Customer;
	}

	public void setId_Customer(int id_Customer) {
		this.id_Customer = id_Customer;
	}

	public TicketHistory(int id_Ticket_History, LocalDate purchase_Date, int amount, int id_Ticket, int id_Customer) {
		super();
		this.id_Ticket_History = id_Ticket_History;
		this.purchase_Date = purchase_Date;
		this.amount = amount;
		this.id_Ticket = id_Ticket;
		this.id_Customer = id_Customer;
	}

	public TicketHistory() {
		super();
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}