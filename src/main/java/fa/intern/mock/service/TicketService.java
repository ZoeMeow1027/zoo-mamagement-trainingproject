package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Ticket;
import fa.intern.mock.dao.TicketDAO;

@Service
public class TicketService {
	@Autowired
	public TicketDAO ticketDAO;
	
	public List<Ticket> getAllTicketByType(int idTicketType) {
		return ticketDAO.getAllTicketByType(idTicketType);
	}

	public List<Ticket> getAllTickets(String searchQuery) {
		return ticketDAO.getAllTickets(searchQuery);
	}

	public Ticket getTicketById(String ticketId) {
		return ticketDAO.getTicketById(ticketId);
	}

	public boolean addTicket(Ticket ticket) {
		return ticketDAO.addTicket(ticket);
	}

	public boolean editTicket(Ticket ticket) {
		return ticketDAO.editTicket(ticket);
	}

	public boolean deleteTicketById(String ticketId) {
		return ticketDAO.deleteTicketById(ticketId);
	}
	
	public Ticket getTicket(int idTicketType, int idTicketAge) {
		return ticketDAO.getTicket(idTicketType, idTicketAge);
	}
}
