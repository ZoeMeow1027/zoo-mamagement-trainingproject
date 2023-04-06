package fa.intern.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.intern.mock.bean.Contracts;
import fa.intern.mock.bean.Supplier;
import fa.intern.mock.bean.SupplierType;
import fa.intern.mock.service.SupplierService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
	@RequestMapping("/showAddSupplier")
	public String showAddSupplier(HttpServletRequest request, Model model) {
		List<SupplierType> list = supplierService.getAllSupplierType();
		model.addAttribute("supplierType", list);
		return "admin/AddSupplier";
	}
	
	@RequestMapping("/showEditSupplier")
	public String showEditSupplier(HttpServletRequest request, Model model) { 
		int id = Integer.parseInt(request.getParameter("id"));
		Supplier list1 = supplierService.getSupplierByID(id);
		List<SupplierType> list = supplierService.getAllSupplierType();
		model.addAttribute("supplierType", list);
		model.addAttribute("supplier", list1);
		return "admin/AddSupplier";
	}
	
	@RequestMapping("/addSupplier")
	public String addSupplier(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		int op = Integer.parseInt(request.getParameter("op"));
		String detail = request.getParameter("detail");
		
		Supplier s = new Supplier();
		s.setName(name);
		s.setIdSupplierType(op);
		
		Contracts c = new Contracts();
		c.setDetails(detail);
		
		supplierService.addSupplier(s, c);
		return "redirect:/viewSupplier";
	}
	
	@RequestMapping("/updateSupplier")
	public String updateSupplier(HttpServletRequest request, Model model) {
		int idSupplier = Integer.parseInt(request.getParameter("idSupplier"));
		int idContract = Integer.parseInt(request.getParameter("idContracts"));
		String name = request.getParameter("name");
		int op = Integer.parseInt(request.getParameter("op"));
		String detail = request.getParameter("detail");
		
		Supplier s = new Supplier();
		s.setId(idSupplier);
		s.setName(name);
		s.setIdSupplierType(op);
		
		Contracts c = new Contracts();
		c.setId(idContract);
		c.setDetails(detail);
		
		supplierService.updateSupplier(s, c);
		return "redirect:/viewSupplier";
	}
	
	@RequestMapping("/viewSupplier")
	public String showViewSupplier(Model model) {
		List<Supplier> list = supplierService.getAllSupplier();
		model.addAttribute("supplier", list);
		return "admin/Supplier";
	}
	
	@RequestMapping("/SearchSupplier")
	public String showSearchInventory(HttpServletRequest request, Model model) {
		String op = request.getParameter("op");
		String search = request.getParameter("search");
		
		if (op.equals("ID_Supplier_Type")) {
			SupplierType type = supplierService.getSupplierTypeByName(search);
			List<Supplier> list = supplierService.getSupplierByOptionID(op, type.getId());
			model.addAttribute("supplier", list);
			return "redirect:/viewSupplier";
		}
		else {
			List<Supplier> list = supplierService.getSupplierByOption(op, search);
			model.addAttribute("supplier", list);
			return "redirect:/viewSupplier";
		}
	}
	
	@RequestMapping("/deleteSupplier")
	public String deleteSupplier(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		supplierService.deleteSupplier(Integer.parseInt(id));
		return "redirect:/viewSupplier";
	}
}
