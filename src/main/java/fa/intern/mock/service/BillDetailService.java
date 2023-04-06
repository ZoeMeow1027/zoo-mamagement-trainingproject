package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Bill;
import fa.intern.mock.bean.BillDetail;
import fa.intern.mock.bean.Product;
import fa.intern.mock.dao.BillDetailDAO;

@Service
public class BillDetailService {
	@Autowired
	private BillDetailDAO billDetailDAO;
	
	public List<BillDetail> getAllBillDetail() {
		return billDetailDAO.getAllBillDetail();
	}
	
	public List<BillDetail> getBillDetailByOption(String op, String value) {
		return billDetailDAO.getBillDetailByOption(op, value);
	}
	
	public void deleteBillDetail(int id, int idBill) {
		billDetailDAO.deleteBillDetail(id, idBill);
	}
	
	public void saveBillDetail(Product p, Bill b, BillDetail d){   
		billDetailDAO.saveBillDetail(p, b, d);
	}
	
	public void updateAmountProduct(Product p, Bill b, BillDetail d) {
		billDetailDAO.updateAmountProduct(p, b, d);
	}
}
