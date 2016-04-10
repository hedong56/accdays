package com.accdays.action.security;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;

import com.accdays.model.Account;
import com.accdays.service.security.BankService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("postAccountsAction")
public class PostAccountsAction extends ActionSupport {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private BankService bankService;

    public String listAccounts(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // Security check (this is unnecessary if Spring Security is performing the authorization)
//        if (!request.isUserInRole("ROLE_TELLER")) {
//            throw new AccessDeniedException("You must be a teller to post transactions (Spring Security message)");
//        }

        // Actual business logic
        Long id = ServletRequestUtils.getRequiredLongParameter(request, "id");
        Double amount = ServletRequestUtils.getRequiredDoubleParameter(request, "amount");
        Account a = bankService.readAccount(id);
        bankService.post(a, amount);

        return "listAccounts";
    }

}








