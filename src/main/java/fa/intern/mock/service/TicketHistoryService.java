package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Customer;
import fa.intern.mock.bean.TicketHistory;
import fa.intern.mock.dao.CustomerDAO;
import fa.intern.mock.dao.TicketHistoryDAO;

@Service
public class TicketHistoryService {
	@Autowired
	private TicketHistoryDAO ticketHistoryDAO;
	
	@Autowired
	private CustomerDAO customerDAO;
	
	public void insertTicketHistory(TicketHistory th) {
		ticketHistoryDAO.insertTicketHistory(th);
	}
	
	public void insertCustomer(Customer c) {
		customerDAO.insertCustomer(c);
	}
	
	public Customer getIDCustomer(String email, String phone) {
		return customerDAO.getIDCustomer(email, phone);
	}
	
	public Customer getCustomerByUsername(String username) {
		try {
			return customerDAO.getCustomerByUsername(username);
		} catch (Exception e) {
			return null;
		} 
	}
	
	public List<Customer> getAllCustomer(){
		return customerDAO.getAllCustomer();
	}
	
	public void insertCustomerByUsername(Customer c) {
		customerDAO.insertCustomerByUsername(c);
	}
	
	public void updateCustomerByUsername(Customer c) {
		customerDAO.updateCustomerByUsername(c);
	}

	public List<TicketHistory> getAllTicketHistory(String searchQuery) {
		return ticketHistoryDAO.getAllTicketHistory(searchQuery);
	}
	
	public List<TicketHistory> getAllTicketHistoryByCustomer(String searchQuery, int idCustomer) {
		return ticketHistoryDAO.getAllTicketHistoryByCustomer(searchQuery, idCustomer);
	}
	
	public List<TicketHistory> getAllTicketHistoryByCustomerPage(String searchQuery, int idCustomer, int pageid, int total) {
		return ticketHistoryDAO.getAllTicketHistoryByCustomerPage(searchQuery, idCustomer, pageid, total);
	}
}