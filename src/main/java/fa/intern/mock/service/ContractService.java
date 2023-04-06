package fa.intern.mock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Contracts;
import fa.intern.mock.dao.ContractsDAO;

@Service
public class ContractService {
	@Autowired
	private ContractsDAO contractsDAO;
	
	public void addContract(Contracts contracts) {
		contractsDAO.saveContracts(contracts);
	}
	
	public void updateContract(Contracts contracts) {
		contractsDAO.updateContracts(contracts);
	}
	
	public void deleteContract(int id) {
		contractsDAO.deleteContracts(id);
	}
	
	public void createContract() {
		contractsDAO.createContract();
	}
	
	public List<Contracts> getTheLastContract() {
		return contractsDAO.getTheLastContract();
	}
}
