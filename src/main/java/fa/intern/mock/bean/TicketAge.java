package fa.intern.mock.bean;

public class TicketAge {
	private int id_Ticket_Age;
	private String age_Description;
	public int getId_Ticket_Age() {
		return id_Ticket_Age;
	}
	public void setId_Ticket_Age(int id_Ticket_Age) {
		this.id_Ticket_Age = id_Ticket_Age;
	}
	public String getAge_Description() {
		return age_Description;
	}
	public void setAge_Description(String age_Description) {
		this.age_Description = age_Description;
	}
	public TicketAge(int id_Ticket_Age, String age_Description) {
		super();
		this.id_Ticket_Age = id_Ticket_Age;
		this.age_Description = age_Description;
	}
	public TicketAge() {
		super();
	}
	
	
}
