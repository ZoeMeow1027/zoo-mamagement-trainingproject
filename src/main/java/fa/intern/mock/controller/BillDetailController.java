package fa.intern.mock.controller;

import java.util.List;

import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.intern.mock.bean.Bill;
import fa.intern.mock.bean.BillDetail;
import fa.intern.mock.bean.Inventory;
import fa.intern.mock.bean.Product;
import fa.intern.mock.bean.Supplier;
import fa.intern.mock.service.BillDetailService;
import fa.intern.mock.service.InventoryService;
import fa.intern.mock.service.ProductService;
import fa.intern.mock.service.SupplierService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BillDetailController {
	@Autowired
	private BillDetailService billDetailService;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/showAddBill")
	public String showAddBill(HttpServletRequest request, Model model) {
		List<Inventory> inventories = inventoryService.getAllInventory();
		List<Supplier> suppliers = supplierService.getAllSupplier();
		long millis=System.currentTimeMillis();  
		java.sql.Date date = new java.sql.Date(millis);  
		model.addAttribute("inventory", inventories);
		model.addAttribute("supplier", suppliers);
		model.addAttribute("dateNow", date);
		return "admin/AddBill";
	}
	
	@RequestMapping("/showAddBillAvailable")
	public String showAddBillAvailable(HttpServletRequest request, Model model) {
		List<Product> products = productService.getAllProducts();
		List<Supplier> suppliers = supplierService.getAllSupplier();
		long millis=System.currentTimeMillis();  
		java.sql.Date date = new java.sql.Date(millis);  
		model.addAttribute("products", products);
		model.addAttribute("supplier", suppliers);
		model.addAttribute("dateNow", date);
		return "admin/AddBillAvailable";
	}
	
	@RequestMapping("/addBill")
	public String addBill(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		int type = Integer.parseInt(request.getParameter("type"));
		int idSupplier = Integer.parseInt(request.getParameter("opSupplier"));
		int number = Integer.parseInt(request.getParameter("number"));
		java.util.Date date = new java.util.Date();    
		String nameProduct = request.getParameter("nameProduct");
		int idInventory = Integer.parseInt(request.getParameter("opInventory"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		Product product = new Product();
		product.setName(nameProduct);
		product.setAmount(number);
		product.setIdSupplier(idSupplier);
		product.setIdInventory(idInventory);
		product.setPrice(price);
		
		Bill bill = new Bill();
		bill.setBillType(type);
		bill.setName(name);
		bill.setIdSupplier(idSupplier);
		
		BillDetail billDetail = new BillDetail();
		billDetail.setAmountTransfer(number);
		billDetail.setTransferDate(date);
		
		billDetailService.saveBillDetail(product, bill, billDetail);
		return "redirect:/viewBillDetail";
	}
	
	@RequestMapping("/updateAmountProduct")
	public String updateAmountProduct(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		int type = Integer.parseInt(request.getParameter("type"));
		int idSupplier = Integer.parseInt(request.getParameter("opSupplier"));
		int number = Integer.parseInt(request.getParameter("number"));
		java.util.Date date = new java.util.Date();    
		int idProduct = Integer.parseInt(request.getParameter("opProduct"));
		
		Product product = new Product();
		product.setId(idProduct);
		product.setAmount(number);
		
		Bill bill = new Bill();
		bill.setBillType(type);
		bill.setName(name);
		bill.setIdSupplier(idSupplier);
		
		BillDetail billDetail = new BillDetail();
		billDetail.setAmountTransfer(number);
		billDetail.setTransferDate(date);
		
		billDetailService.updateAmountProduct(product, bill, billDetail);
		return "redirect:/viewBillDetail";
	}
	
	@RequestMapping("/viewBillDetail")
	public String showViewInventory(Model model) {
		List<BillDetail> list = billDetailService.getAllBillDetail();
		model.addAttribute("billDetail", list);
		return "admin/Bill";
	}
	
	@RequestMapping("/SearchBillDetail")
	public String showSearchInventory(HttpServletRequest request, Model model) {
		String op = request.getParameter("op");
		String search = request.getParameter("search");
		System.out.print(op + "---" + search);
		
		List<BillDetail> list = billDetailService.getBillDetailByOption(op, search);
		model.addAttribute("billDetail", list);
		return "admin/Bill";
	}
	
	@RequestMapping("/deleteBillDetail")
	public String deleteInventory(HttpServletRequest request, Model model) {
		String[] id = request.getParameter("id").split("-");
		
		billDetailService.deleteBillDetail(Integer.parseInt(id[0]), Integer.parseInt(id[1]));
		return "redirect:/viewBillDetail";
	}
}
