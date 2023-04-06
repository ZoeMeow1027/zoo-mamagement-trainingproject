package fa.intern.mock.controller;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fa.intern.mock.bean.Customer;
import fa.intern.mock.bean.TicketHistory;
import fa.intern.mock.service.TicketHistoryService;
import fa.intern.mock.service.TicketService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class TicketHistoryController {
	@Autowired
	private TicketHistoryService ticketHistoryService;
	
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping("checkout")
	public String showCheckoutTickets(Model model, HttpSession session) {
		String username = (String)session.getAttribute("username");
		
		if (username == null) {
			model.addAttribute("customer", new Customer());
		} else {
			Customer customer = ticketHistoryService.getCustomerByUsername(username);
			if (customer == null) {
				model.addAttribute("customer", new Customer());
			} else {
				model.addAttribute("customer", customer);
			}
		}
		return "customer/checkout";

	}
	
	@RequestMapping(value="ticket-history/{pageid}", method = RequestMethod.GET)
	public String showHistoryCustomer(Model model, HttpSession session, @PathVariable int pageid, @RequestParam(required = false) String search) {
		String username = (String)session.getAttribute("username");
		if (username != null) {
			Customer customer = ticketHistoryService.getCustomerByUsername(username);
			if (customer != null) {
				model.addAttribute("currentPage", pageid);
				int total = 7;
				if (pageid != 1) {
					pageid = (pageid - 1) * total + 1;
				}
				int pages = (ticketHistoryService.getAllTicketHistoryByCustomer(search, customer.getId_Customer()).size()%2 == 0) ? (ticketHistoryService.getAllTicketHistoryByCustomer(search, customer.getId_Customer()).size() / total) : (ticketHistoryService.getAllTicketHistoryByCustomer(search, customer.getId_Customer()).size() / total + 1);
				model.addAttribute("listHistory", ticketHistoryService.getAllTicketHistoryByCustomerPage(search, customer.getId_Customer(), pageid, total));
				model.addAttribute("totalPages", pages);
				
			} else {
				model.addAttribute("listHistory", null);
			}
		}
		model.addAttribute("searchQuery", search);
		return "customer/ticketHistory";
	}
	
	@RequestMapping(value = "/insertTicketHistory")
	public @ResponseBody String insertTicketHistory(HttpServletRequest request, HttpSession session) {
		Customer customer = new Customer();
		customer.setCustomer_Name(request.getParameter("customer_Name"));
		customer.setAddress(request.getParameter("address"));
		customer.setPhone(request.getParameter("phone"));
		customer.setEmail(request.getParameter("email"));
		
		if (customer.getAddress() != "" && customer.getCustomer_Name() != "" & customer.getEmail() != "" & customer.getPhone() != "") { 
			String username = (String)session.getAttribute("username");
			Customer c;
			if (username != null) {
				c = ticketHistoryService.getCustomerByUsername(username);
				customer.setUsername(username);
				if (c == null) {
					ticketHistoryService.insertCustomerByUsername(customer);
					c = ticketHistoryService.getAllCustomer().get(ticketHistoryService.getAllCustomer().size() - 1);
				} else {
					ticketHistoryService.updateCustomerByUsername(customer);
				}
			} else {
				ticketHistoryService.insertCustomer(customer);
				c = ticketHistoryService.getAllCustomer().get(ticketHistoryService.getAllCustomer().size() - 1);
			}
			
 			int amountTicket = Integer.parseInt(request.getParameter("ticket-amount"));
			for (int i = 1; i <= amountTicket; i++) {
				String date = request.getParameter("date" + i);
				int idTicket = Integer.parseInt(request.getParameter("idTicket" + date + i));
				int ageAmount = Integer.parseInt(request.getParameter("age-amount" + date + i));
				
				for (int j = 1; j <= ageAmount; j++) {
					int idTicketAge = Integer.parseInt(request.getParameter("idTicketAge" + date + i + j));
					int amount = Integer.parseInt(request.getParameter("amount" + date + i + j));
					
					int id_Ticket = ticketService.getTicket(idTicket, idTicketAge).getId_Ticket();
					TicketHistory th = new TicketHistory();
					th.setPurchase_Date(LocalDate.parse(date));
					th.setAmount(amount);
					th.setId_Ticket(id_Ticket);
					th.setId_Customer(c.getId_Customer());
					ticketHistoryService.insertTicketHistory(th);
				}
			}
			return "tickets"; 
		} else { 
			
		 	return "checkout"; 
		}
	}
}
