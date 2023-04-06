package fa.intern.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fa.intern.mock.bean.Ticket;
import fa.intern.mock.bean.TicketAge;
import fa.intern.mock.bean.TicketType;
import fa.intern.mock.service.TicketAgeService;
import fa.intern.mock.service.TicketService;
import fa.intern.mock.service.TicketTypeService;

@Controller
public class AdminTicketController {
	@Autowired
	private TicketTypeService ticketTypeService;
	
	@Autowired
	private TicketAgeService ticketAgeService;

	@Autowired
	private TicketService ticketService;
	
	@RequestMapping(value="/admin/tickets/add", method = RequestMethod.GET)
	public String pageTicketAdd(Model model) {
		List<TicketType> data = ticketTypeService.getAllTicketType(null);
		model.addAttribute("ticketTypeList", data);
		List<TicketAge> ticketAgeList = ticketAgeService.getAllTicketAge(null);
		model.addAttribute("ticketAgeList", ticketAgeList);
		return "admin/ticketManagerEdit";
	}

	@RequestMapping(value="/admin/tickets/add", method = RequestMethod.POST)
	public String actionTicketAdd(
		Model model,
		@RequestParam(required = true) Integer typeid,
		@RequestParam(required = true) Integer typeageid,
		@RequestParam(required = true) Integer amount,
		@RequestParam(required = true) Integer price
	) {
		// TODO: Add here! If failed, return back to add ticket page
		TicketType ticketType = new TicketType();
		ticketType.setId_Ticket_Type(typeid);

		TicketAge ticketAge = new TicketAge();
		ticketAge.setId_Ticket_Age(typeageid);

		Ticket ticket = new Ticket();
		ticket.setTicket_Type(ticketType);
		ticket.setTicket_Age(ticketAge);
		ticket.setAmount(amount);
		ticket.setPrice(price);
		Boolean result = ticketService.addTicket(ticket);

		try {
			// If successful, will return to main page.
			if (result) {
				return "redirect:/admin/tickets";
			} else throw new Exception("Can't add ticket to database!");	
		} catch (Exception ex) {
			ex.printStackTrace();
			return "redirect:/admin/tickets/add";
		}
	}

	@RequestMapping(value="/admin/tickets/edit", method = RequestMethod.GET)
	public String pageTicketEdit(
		Model model,
		@RequestParam(required = true) Integer id
	) {
		// TODO: Check if ticket is exist before return to edit page.
		// If id was not defined, will return to main page.
		if (id == null)
			return "redirect:/admin/tickets";
		
		// TODO: If not exist ticket with this id, will return to main page, too.
		Ticket data = ticketService.getTicketById(id.toString());
		if (data == null)
			return "redirect:/admin/tickets";

		// Return to edit page.
		model.addAttribute("ticketId", id);
		model.addAttribute("ticketData", data);
		List<TicketType> ticketTypeList = ticketTypeService.getAllTicketType(null);
		model.addAttribute("ticketTypeList", ticketTypeList);
		List<TicketAge> ticketAgeList = ticketAgeService.getAllTicketAge(null);
		model.addAttribute("ticketAgeList", ticketAgeList);
		return "admin/ticketManagerEdit";
	}

	@RequestMapping(value="/admin/tickets/edit", method = RequestMethod.POST)
	public String actionTicketEdit(
		Model model,
		@RequestParam(required = true) Integer id,
		@RequestParam(required = true) Integer typeid,
		@RequestParam(required = true) Integer typeageid,
		@RequestParam(required = true) Integer amount,
		@RequestParam(required = true) Integer price
	) {
		// TODO: Edit here! If failed, return back to edit ticket page
		// return String.format("redirect:/admin/tickets/edit?id=%d", id);
		Ticket data = ticketService.getTicketById(id.toString());
		if (data == null)
			return String.format("redirect:/admin/tickets/edit?id=", id);
		
		TicketType ticketType = data.getTicket_Type();
		ticketType.setId_Ticket_Type(typeid);
		
		TicketAge ticketAge = new TicketAge();
		ticketAge.setId_Ticket_Age(typeageid);

		data.setTicket_Type(ticketType);
		data.setTicket_Age(ticketAge);
		data.setAmount(amount);
		data.setPrice(price);
		
		try {
			ticketService.editTicket(data);
		} catch (Exception ex) {
			ex.printStackTrace();
			return String.format("redirect:/admin/tickets/edit?id=", id);
		}

		// If successful, will return to main page.
		return "redirect:/admin/tickets";
	}

	@RequestMapping(value="/admin/tickets/delete", method = RequestMethod.POST)
	public String deleteTicket(
		Model model,
		@RequestParam(required = true) Integer id
	) {
		// TODO: Delete here.
		// Use this for notify user for deletion was successful or failed.
		ticketService.deleteTicketById(id.toString());

		// Any result will return to main page.
		return String.format("redirect:/admin/tickets?q=");
	}

	@RequestMapping(value="/admin/tickets", method = RequestMethod.GET)
	public String pageShowTickets(
		Model model,
		@RequestParam(required = false) String q
	) {
		// model.addAttribute("ticketTypeList", ticketTypeService.getAllTicketType());
		List<Ticket> data = ticketService.getAllTickets(q);
		model.addAttribute("searchQuery", q);
		model.addAttribute("tickets", data);
		return "admin/ticketManager";
	}
}
