package com.bankapp.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountType;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.formbeans.TransferBean;
import com.bankapp.web.formbeans.WithdrawBean;


@Controller
public class AccountController {
	
	private AccountService accountService;
	
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	@GetMapping("home.do")
	public String home() {
		return "home";
	}


	@GetMapping("accountdetails.do")
	public ModelAndView allaccounts(HttpServletRequest req,ModelAndView mv) {
		mv.setViewName("showall");
		mv.addObject("accounts", accountService.getAllAccounts());
    	mv.addObject("user", req.getSession(false).getAttribute("user"));
		return mv;
	}
	

	@GetMapping("deleteaccount.do")
	public String delaccount(HttpServletRequest req) {
		int accountId=Integer.parseInt(req.getParameter("accountId"));
		accountService.deleteAccount(accountId);
		return "redirect:/accountdetails.do";
	}

	@GetMapping("updateaccount.do")
	public String updateaccount(HttpServletRequest req, ModelMap map) {
		int accountId=Integer.parseInt(req.getParameter("accountId"));
		Account account = accountService.getAccountById(accountId);
		map.addAttribute("account", account);
		return "updateaccount";
	}
	
	@GetMapping("transfer.do")
	public String transferGet(ModelMap map) {
		map.addAttribute("transferBean", new TransferBean());
		return "transfer";
	}
	
	@PostMapping("transfer.do") 
	public String transferPost(@ModelAttribute("transferBean") TransferBean transferBean) {
		int fromAccountId = transferBean.getFromAccountId();
		int toAccountId = transferBean.getToAccountId();
		Double amount = transferBean.getAmount();
		accountService.transfer(fromAccountId, toAccountId, amount);
		return "redirect:/accountdetails.do";
	}
	
	@GetMapping("withdraw.do")
	public String withdrawGet(ModelMap map) {
		map.addAttribute("withdrawBean", new WithdrawBean());
		return "withdraw";
	}
	
	@PostMapping("withdraw.do") 
	public String withdrawPost(@ModelAttribute("withdrawBean") WithdrawBean withdrawBean) {
		int accountId = withdrawBean.getAccountId();
		Double amount = withdrawBean.getAmount();
		accountService.withdraw(accountId, amount);
		return "redirect:/accountdetails.do";
	}
	
	@GetMapping("deposit.do")
	public String depositGet(ModelMap map) {
		map.addAttribute("depositBean", new WithdrawBean());
		return "deposit";
	}
	
	@PostMapping("deposit.do") 
	public String depositPost(@ModelAttribute("depositBean") WithdrawBean withdrawBean) {
		int accountId = withdrawBean.getAccountId();
		Double amount = withdrawBean.getAmount();
		accountService.deposit(accountId, amount);
		return "redirect:/accountdetails.do";
	}


	@GetMapping("addaccount.do")
	public String addBookGet(ModelMap map) {
		
		map.addAttribute("account", new Account());
	return "addaccount";
	}

	@PostMapping("addaccount.do")
	public String addaccountPost(@Valid @ModelAttribute(name = "account") Account account, BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "addaccount";
		} else {
			if (account.getAccountId() == 0) {
				accountService.addAccount(account);
			} else {
				accountService.updateAccount(account.getAccountId(),account);
		}
			return "redirect:/accountdetails.do";
		}
	}

	@ModelAttribute(value = "accountTypes")
	public AccountType[] accountType() {
		
		return AccountType.values();
	}
	@ExceptionHandler(com.bankapp.model.dao.AccountNotFoundException.class)
	public ModelAndView AccountNotFoundException (Exception ex, HttpServletRequest req) {
	
		ModelAndView mv=new ModelAndView();
		mv.setViewName("accountnotfound");
		mv.addObject("error", ex.getMessage());
		return mv;
	}

}
