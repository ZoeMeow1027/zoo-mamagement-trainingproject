package fa.intern.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fa.intern.mock.bean.TicketHistory;
import fa.intern.mock.service.TicketHistoryService;

@Controller
public class AdminTicketHistoryController {
    @Autowired
    private TicketHistoryService ticketHistoryService;

    @RequestMapping(value = "/admin/ticket-history", method = RequestMethod.GET)
    public String pageTicketHistoryShow(
        Model model,
        @RequestParam(required = false) String q
    ) {
        List<TicketHistory> data = ticketHistoryService.getAllTicketHistory(q);
        model.addAttribute("searchQuery", q);
        model.addAttribute("ticketHistoryList", data);
        return "admin/ticketHistoryManager";
    }
}