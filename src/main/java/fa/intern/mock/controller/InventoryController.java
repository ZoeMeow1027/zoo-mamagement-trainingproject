package fa.intern.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.intern.mock.bean.Inventory;
import fa.intern.mock.service.InventoryService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class InventoryController {
	@Autowired
	private InventoryService inventoryService;
	
	@RequestMapping("/viewInventory")
	public String showViewInventory(Model model) {
		List<Inventory> list = inventoryService.getAllInventory();
		model.addAttribute("inventory", list);
		return "admin/Inventory";
	}
	
	@RequestMapping("/SearchInventory")
	public String showSearchInventory(HttpServletRequest request, Model model) {
		String op = request.getParameter("op");
		String search = request.getParameter("search");
		
		List<Inventory> list = inventoryService.getInventoryByOption(op, search);
		model.addAttribute("inventory", list);
		return "admin/Inventory";
	}
	
	@RequestMapping("/deleteInventory")
	public String deleteInventory(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		inventoryService.deleteInventory(Integer.parseInt(id));
		return "admin/Inventory";
	}
}
