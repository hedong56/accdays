package com.accdays.action.security;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

import com.accdays.model.Account;
import com.accdays.service.security.BankService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("listAction")
public class ListAction extends ActionSupport {

	@Resource
    private BankService bankService;

    private Account[] accounts;
    
    public String listAccounts() throws Exception {
    	accounts=bankService.findAccounts();
        return "listAccounts";
    }

	/**
	 * @return the accounts
	 */
	public Account[] getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts the accounts to set
	 */
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

}
