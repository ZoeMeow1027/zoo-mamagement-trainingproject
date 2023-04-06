package fa.intern.mock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fa.intern.mock.bean.Account;
import fa.intern.mock.service.AccountService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/")
	public String index(Model model, HttpSession session, HttpServletRequest request) {
		Account account = checkCookie(request);
		if (account != null) {
			if (accountService.loginAccount(account.getUsername(), account.getPassword()) == 1) {
				session.setAttribute("username", account.getUsername());
				account = accountService.getAccount(account.getUsername());
				if (account.getId_Account_Type() == 1) {
					return "customer/index";
				}
				if (account.getId_Account_Type() == 2) {
					return "admin/admin";
				}
			} 
		}
		return "customer/index";
	}
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String login(Model model, HttpSession session, HttpServletRequest request) {
		Account account = checkCookie(request);
		if (account == null) {
			model.addAttribute("account", new Account());
			return "admin/Login";
		} else {
			if (accountService.loginAccount(account.getUsername(), account.getPassword()) == 1) {
				session.setAttribute("username", account.getUsername());
				account = accountService.getAccount(account.getUsername());
				if (account.getId_Account_Type() == 1) {
					return "customer/index";
				}
				if (account.getId_Account_Type() == 2) {
					return "admin/admin";
				}
			}
			return "customer/index";
		}
	}
	
	@RequestMapping(value="register", method = RequestMethod.GET)
	public String register(Model model) {
		model.addAttribute("account", new Account());
		return "admin/Register";
	}
	
	@RequestMapping(value="register", method = RequestMethod.POST)
	public String register(@ModelAttribute("account")Account account, Model model) {
		Account a = accountService.getAccount(account.getUsername());
		if (a != null) {
			model.addAttribute("error", "Tên tài khoản đã tồn tại.");
			account.setPassword("");
			model.addAttribute("account", account);
			return "admin/Register";
		} else {
			account.setId_Account_Type(1);
			accountService.insertAccount(account);
			return "redirect:login";
		}
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute("account") Account account, Model model, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		if (accountService.loginAccount(account.getUsername(), account.getPassword()) == 1) {
			session.setAttribute("username", account.getUsername());
			
			if (request.getParameter("remember") == null) {
				Cookie ckUsername = new Cookie("username", account.getUsername());
				ckUsername.setMaxAge(3600);
				response.addCookie(ckUsername);
			}
			return "redirect:/";
		} else if (accountService.loginAccount(account.getUsername(), account.getPassword()) == -1) {
			model.addAttribute("error", "Bạn nhập sai mật khẩu.");
		} else {
			model.addAttribute("error", "Tên tài khoản không tồn tại.");
		}
		model.addAttribute("account", account);
		return "admin/Login";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.removeAttribute("username");
		
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equalsIgnoreCase("username")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
		return "redirect:/";
	}
	
	public Account checkCookie(HttpServletRequest request) {
		Account account = null;
		Cookie[] cookies = request.getCookies();
		String username = "";
		
		if (cookies.length != 0) {
			for(Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("username")) {
					username = cookie.getValue();
				}
			}
			if(!username.isEmpty()) {
				account = accountService.getAccount(username);
			}
		}
		
		return account;
	}
}
