package fa.intern.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fa.intern.mock.bean.TicketAge;
import fa.intern.mock.service.TicketAgeService;

@Controller
public class AdminTicketAgeController {
	@Autowired
	private TicketAgeService ticketAgeService;

	@RequestMapping(value = "/admin/tickets/ticket-age", method = RequestMethod.GET)
	public String pageTicketAgeShow(
			Model model,
			@RequestParam(required = false) String q) {
		List<TicketAge> data = ticketAgeService.getAllTicketAge(q);
		model.addAttribute("searchQuery", q);
		model.addAttribute("ticketAge", data);
		return "admin/ticketAgeManager";
	}

	@RequestMapping(value = "/admin/tickets/ticket-age/add", method = RequestMethod.GET)
	public String pageTicketAgeAdd(Model model) {
		return "admin/ticketAgeManagerEdit";
	}

	@RequestMapping(value = "/admin/tickets/ticket-age/add", method = RequestMethod.POST)
	public String actionTicketAgeAdd(
			Model model,
			@RequestParam(required = true) String desp) {
		TicketAge t = new TicketAge();
		t.setAge_Description(desp);

		try {
			ticketAgeService.addTicketAge(t);
			return "redirect:/admin/tickets/ticket-age";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "redirect:/admin/tickets/ticket-age/add";
		}
	}

	@RequestMapping(value = "/admin/tickets/ticket-age/delete", method = RequestMethod.POST)
	public String actionTicketAgeDelete(
			Model model,
			@RequestParam(required = true) Integer id) {
		// TODO: Delete here.
		// Use this for notify user for deletion was successful or failed.
		ticketAgeService.deleteTicketAgeById(id.toString());

		// Any result will return to main page.
		return String.format("redirect:/admin/tickets/ticket-age?q=");
	}

	@RequestMapping(value = "/admin/tickets/ticket-age/edit", method = RequestMethod.GET)
	public String pageTicketAgeEdit(
			Model model,
			@RequestParam(required = true) Integer id) {
		// TODO: Check if ticket is exist before return to edit page.
		// If id was not defined, will return to main page.
		if (id == null)
			return "redirect:/admin/tickets/ticket-age";

		// TODO: If not exist ticket with this id, will return to main page, too.
		TicketAge data = ticketAgeService.getTicketAgeById(id.toString());
		if (data == null)
			return "redirect:/admin/tickets/ticket-age";

		// Return to edit page.
		model.addAttribute("ticketAgeId", id);
		model.addAttribute("ticketAgeData", data);
		return "admin/ticketAgeManagerEdit";
	}

	@RequestMapping(value = "/admin/tickets/ticket-age/edit", method = RequestMethod.POST)
	public String actionTicketAgeEdit(
			Model model,
			@RequestParam(required = true) Integer id,
			@RequestParam(required = true) String desp) {
		TicketAge data = ticketAgeService.getTicketAgeById(id.toString());
		if (data == null)
			return String.format("redirect:/admin/tickets/ticket-age/edit?id=", id);

		data.setAge_Description(desp);

		try {
			ticketAgeService.editTicketAge(data);
		} catch (Exception ex) {
			ex.printStackTrace();
			return String.format("redirect:/admin/tickets/ticket-age/edit?id=", id);
		}

		// If successful, will return to main page.
		return "redirect:/admin/tickets/ticket-age";
	}
}
