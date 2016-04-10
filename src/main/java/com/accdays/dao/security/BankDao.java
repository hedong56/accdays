package com.accdays.dao.security;

import com.accdays.model.Account;

public interface BankDao {
    public Account readAccount(Long id);
    public void createOrUpdateAccount(Account account);
    public Account[] findAccounts();
}
