package com.accdays.service.security;

import org.springframework.security.access.prepost.PreAuthorize;

import com.accdays.model.Account;


public interface BankService {

    public Account readAccount(Long id);

    public Account[] findAccounts();

    @PreAuthorize(
            "hasRole('supervisor') or " +
            "hasRole('teller') and (#account.balance + #amount >= -#account.overdraft)" )
    public Account post(Account account, double amount);
}
