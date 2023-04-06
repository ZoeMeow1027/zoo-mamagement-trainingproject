package fa.intern.mock.bean;

public class TicketType {
	private int id_Ticket_Type;
	private String ticket_Type;
	private String ticket_Description;
	
	public int getId_Ticket_Type() {
		return id_Ticket_Type;
	}
	public void setId_Ticket_Type(int id_Ticket_Type) {
		this.id_Ticket_Type = id_Ticket_Type;
	}
	public String getTicket_Type() {
		return ticket_Type;
	}
	public void setTicket_Type(String ticket_Type) {
		this.ticket_Type = ticket_Type;
	}
	public String getTicket_Description() {
		return ticket_Description;
	}
	public void setTicket_Description(String ticket_Description) {
		this.ticket_Description = ticket_Description;
	}
	public TicketType(int id_Ticket_Type, String ticket_Type, String ticket_Description) {
		super();
		this.id_Ticket_Type = id_Ticket_Type;
		this.ticket_Type = ticket_Type;
		this.ticket_Description = ticket_Description;
	}
	public TicketType() {
		super();
	}
}

