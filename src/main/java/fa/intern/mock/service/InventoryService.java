package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Inventory;
import fa.intern.mock.dao.InventoryDAO;

@Service
public class InventoryService {
	@Autowired
	private InventoryDAO inventoryDAO;
	
	public List<Inventory> getAllInventory() {
		return inventoryDAO.getAllInventory();
	}
	
	public List<Inventory> getInventoryByOption(String op, String value) {
		return inventoryDAO.getInventoryByOption(op, value);
	}
	
	public void deleteInventory(int id) {
		inventoryDAO.deleteInventory(id);
	}
}
