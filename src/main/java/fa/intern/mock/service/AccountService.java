package fa.intern.mock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.intern.mock.bean.Account;
import fa.intern.mock.dao.AccountDAO;

@Service
public class AccountService {
	@Autowired
	private AccountDAO accountDAO;
	
	public void createAccountThroughAddNewStaff(String string) {
		accountDAO.createAccountThroughAddNewStaff(string);
	}

	public Account getAccount(String username) {
		try {
			return accountDAO.getAccount(username);
		} catch (Exception e) {
			return null;
		}
	}
	
	public int loginAccount(String username, String password) {
		Account account;
		try {
			account = accountDAO.getAccount(username);
		} catch (Exception e) {
			account = null;
		}
		int check = 0;
		if (account != null) {
			if (account.getPassword().equals(password)) {
				check = 1;
			} 
			else check = -1;
		} 
		return check;
	}
	
	public void insertAccount(Account account) {
		accountDAO.insertAccount(account);
	}
}
