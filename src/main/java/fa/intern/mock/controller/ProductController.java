package fa.intern.mock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fa.intern.mock.bean.Product;
import fa.intern.mock.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/viewProduct")
	public String showViewProduct(HttpServletRequest request, Model model) {
		String[] id = request.getParameter("id").split("-");
		
		List<Product> list = productService.getListProductcsByIDInventory(Integer.parseInt(id[0]));
		model.addAttribute("product", list);
		model.addAttribute("inventory", id[1]);
		return "admin/Product";
	}
	
	@RequestMapping("/searchProduct")
	public String searchProduct(HttpServletRequest request, Model model) {
		String op = request.getParameter("op");
		String search = request.getParameter("search");
		
		List<Product> list = productService.getProductcsByOption(op, search);
		model.addAttribute("product", list);
		return "admin/Product";
	}
	
	@RequestMapping("/deleteProduct")
	public String deleteProduct(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		productService.deleteProduct(Integer.parseInt(id));
		return "admin/Product";
	}
}
