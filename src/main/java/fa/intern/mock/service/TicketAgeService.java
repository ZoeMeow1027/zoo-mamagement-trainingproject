package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.TicketAge;
import fa.intern.mock.dao.TicketAgeDAO;

@Service
public class TicketAgeService {
    @Autowired
	private TicketAgeDAO ticketAgeDao;

    public List<TicketAge> getAllTicketAge(String searchQuery) {
        return ticketAgeDao.getAllTicketAge(searchQuery);
    }

    public TicketAge getTicketAgeById(String ticketAgeId) {
        return ticketAgeDao.getTicketAgeById(ticketAgeId);
    }

    public boolean addTicketAge(TicketAge ticketAge) {
        return ticketAgeDao.addTicketAge(ticketAge);
    }

    public boolean deleteTicketAgeById(String ticketAgeId) {
        return ticketAgeDao.deleteTicketAgeById(ticketAgeId);
    }

    public boolean editTicketAge(TicketAge ticketAge) {
        return ticketAgeDao.editTicketAge(ticketAge);
    }
}
