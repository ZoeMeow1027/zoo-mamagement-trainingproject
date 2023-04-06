package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Staff;
import fa.intern.mock.bean.StaffType;
import fa.intern.mock.dao.StaffDAO;

@Service
public class StaffService {
	@Autowired
	private StaffDAO staffDAO;

	public List<Staff> showStaff() {
		return staffDAO.showStaff();
	}

	public List<Staff> getStaffList() {
		return staffDAO.getStaffList();
	}

	public List<StaffType> getStaffTypeList() {
		return staffDAO.getStaffTypeList();
	}

	public List<Staff> getStaffById(int id) {
		return staffDAO.getStaffById(id);
	}

	public List<Staff> getStaffSearch(String searchString) {
		return staffDAO.getStaffSearch(searchString);
	}

	public void createStaff(Staff staff) {
		staffDAO.createStaff(staff);
	}

	public List<Staff> getStaffByIdStaffType(int id) {
		return staffDAO.getStaffByIdStaffType(id);
	}

	// ---------------------update----------------------
	public void updateStaff(Staff staff) {
		staffDAO.updateStaff(staff);
	}

	public void deleteStaff(int id) {
		staffDAO.deleteStaff(id);
	}
}
