package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.TicketType;
import fa.intern.mock.dao.TicketTypeDAO;

@Service
public class TicketTypeService {
	@Autowired
	private TicketTypeDAO ticketTypeDAO;
	
	public List<TicketType> getAllTicketType(String searchQuery){
		return ticketTypeDAO.getAllTicketType(searchQuery);
	}

	public TicketType getTicketTypeById(String ticketTypeId) {
		return ticketTypeDAO.getTicketTypeById(ticketTypeId);
	}

	public boolean addTicketType(TicketType ticketType) {
		return ticketTypeDAO.addTicketType(ticketType);
	}

	public boolean editTicketType(TicketType ticketType) {
		return ticketTypeDAO.editTicketType(ticketType);
	}

	public boolean deleteTicketById(String ticketTypeId) {
		return ticketTypeDAO.deleteTicketById(ticketTypeId);
	}
}
