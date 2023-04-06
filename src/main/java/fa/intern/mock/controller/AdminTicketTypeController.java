package fa.intern.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fa.intern.mock.bean.TicketType;
import fa.intern.mock.service.TicketTypeService;

@Controller
public class AdminTicketTypeController {
    @Autowired
    private TicketTypeService ticketTypeService;

    @RequestMapping(value = "/admin/tickets/ticket-type", method = RequestMethod.GET)
    public String pageTicketTypeShow(
            Model model,
            @RequestParam(required = false) String q) {
        List<TicketType> data = ticketTypeService.getAllTicketType(q);
        model.addAttribute("searchQuery", q);
        model.addAttribute("ticketType", data);
        return "admin/ticketTypeManager";
    }

    @RequestMapping(value = "/admin/tickets/ticket-type/add", method = RequestMethod.GET)
    public String pageTicketTypeAdd(Model model) {
        return "admin/ticketTypeManagerEdit";
    }

    @RequestMapping(value = "/admin/tickets/ticket-type/add", method = RequestMethod.POST)
    public String actionTicketTypeAdd(Model model,
            @RequestParam(required = true) String name,
            @RequestParam(required = true) String desp) {
        TicketType t = new TicketType();
        t.setTicket_Type(name);
        t.setTicket_Description(desp);

        try {
			ticketTypeService.addTicketType(t);
			return "redirect:/admin/tickets/ticket-type";
        } catch (Exception ex) {
            ex.printStackTrace();
			return "redirect:/admin/tickets/ticket-type/add";
        }
    }

    @RequestMapping(value = "/admin/tickets/ticket-type/edit", method = RequestMethod.GET)
    public String pageTicketTypeEdit(
            Model model,
            @RequestParam(required = true) Integer id) {
        // TODO: Check if ticket is exist before return to edit page.
        // If id was not defined, will return to main page.
        if (id == null)
            return "redirect:/admin/tickets/ticket-type";

        // TODO: If not exist ticket with this id, will return to main page, too.
        TicketType data = ticketTypeService.getTicketTypeById(id.toString());
        if (data == null)
            return "redirect:/admin/tickets/ticket-type";

        // Return to edit page.
        model.addAttribute("ticketTypeId", id);
        model.addAttribute("ticketTypeData", data);
        return "admin/ticketTypeManagerEdit";
    }

    @RequestMapping(value = "/admin/tickets/ticket-type/edit", method = RequestMethod.POST)
    public String actionTicketTypeEdit(
        Model model,
        @RequestParam(required = true) Integer id,
        @RequestParam(required = true) String name,
        @RequestParam(required = true) String desp
    ) {
        TicketType data = ticketTypeService.getTicketTypeById(id.toString());
		if (data == null)
			return String.format("redirect:/admin/tickets/ticket-type/edit?id=", id);

        data.setTicket_Type(name);
		data.setTicket_Description(desp);

		try {
			ticketTypeService.editTicketType(data);
		} catch (Exception ex) {
			ex.printStackTrace();
			return String.format("redirect:/admin/tickets/ticket-type/edit?id=", id);
		}

		// If successful, will return to main page.
		return "redirect:/admin/tickets/ticket-type";
    }

    @RequestMapping(value = "/admin/tickets/ticket-type/delete", method = RequestMethod.POST)
    public String actionTicketTypeDelete(
            Model model,
            @RequestParam(required = true) Integer id) {
        // TODO: Delete here.
        // Use this for notify user for deletion was successful or failed.
        ticketTypeService.deleteTicketById(id.toString());

        // Any result will return to main page.
        return String.format("redirect:/admin/tickets/ticket-type?q=");
    }
}
