package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Contracts;
import fa.intern.mock.bean.Supplier;
import fa.intern.mock.bean.SupplierType;
import fa.intern.mock.dao.SupplierDAO;

@Service
public class SupplierService {
	@Autowired
	private SupplierDAO supplierDAO;
	
	public List<Supplier> getAllSupplier() {
		return supplierDAO.getAllSupplier();
	}
	
	public List<Supplier> getSupplierByOption(String op, String value) {
		return supplierDAO.getSupplierByOption(op, value);
	}
	
	public List<Supplier> getSupplierByOptionID(String op, int id) {
		return supplierDAO.getSupplierByOptionID(op, id);
	}
	
	public void addSupplier(Supplier supplier, Contracts contracts) {
		supplierDAO.saveSupplier(supplier, contracts);
	}
	
	public void updateSupplier(Supplier p, Contracts c) {
		supplierDAO.updateSupplier(p, c);
	}
	
	public void deleteSupplier(int id) {
		supplierDAO.deleteSupplier(id);
	}
	
	public SupplierType getSupplierTypeByName(String name) {
		return supplierDAO.getSupplierTypeByName(name);
	}
	
	public List<SupplierType> getAllSupplierType() {
		return supplierDAO.getAllSupplierType();
	}
	
	public Supplier getSupplierByID(int id) {
		return supplierDAO.getSupplierByID(id);
	}
}
