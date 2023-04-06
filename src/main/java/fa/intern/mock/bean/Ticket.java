package fa.intern.mock.bean;

public class Ticket {
	private int id_Ticket;
	private TicketType ticket_Type;
	private int amount;
	private int price;
	private TicketAge ticket_Age;
	public int getId_Ticket() {
		return id_Ticket;
	}
	public void setId_Ticket(int id_Ticket) {
		this.id_Ticket = id_Ticket;
	}
	public TicketType getTicket_Type() {
		return ticket_Type;
	}
	public void setTicket_Type(TicketType ticket_Type) {
		this.ticket_Type = ticket_Type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public TicketAge getTicket_Age() {
		return ticket_Age;
	}
	public void setTicket_Age(TicketAge ticket_Age) {
		this.ticket_Age = ticket_Age;
	}
	
	
}
