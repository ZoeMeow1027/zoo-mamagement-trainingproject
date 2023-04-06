package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Product;
import fa.intern.mock.dao.ProductDAO;


@Service
public class ProductService {
	@Autowired
	private ProductDAO productDAO;
	
	public List<Product> getAllProducts() {
		return productDAO.getAllProductcs();
	}
	
	public List<Product> getListProductcsByIDInventory(int id) {
		return productDAO.getListProductcsByIDInventory(id);
	}
	
	public List<Product> getProductcsByOption(String op, String value) {
		return productDAO.getProductcsByOption(op, value);
	}
	
	public void deleteProduct(int id) {
		productDAO.deleteProduct(id);
	}
}
