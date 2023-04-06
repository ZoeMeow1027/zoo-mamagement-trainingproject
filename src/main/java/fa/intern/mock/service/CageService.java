package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Cage;
import fa.intern.mock.dao.CageDAO;

@Service
public class CageService {
	@Autowired
	private CageDAO cageDAO;
	

	public boolean deleteCage(int idCage) {
		return cageDAO.deleteCage(idCage);
	}

	public List<Cage> searchCage(String option, String search) {
		return cageDAO.searchCage(option, search);
	}

	public List<Cage> showAllCage() {
		 return cageDAO.showAllCage();
	}

	public List<Cage> showCageInfo(int idCage) {
		 return cageDAO.showCageInfo(idCage);
	}

	public void editCage(int idCage, String nameCage, int limit, int staffName) throws Exception {
		cageDAO.editCage(idCage, nameCage, limit, staffName);
	}

	public void addCage(String cageName, int limit, int staffName) throws Exception {
		cageDAO.addCage(cageName, limit, staffName);
	}


}
