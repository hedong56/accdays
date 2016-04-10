package com.accdays.service.security.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.accdays.dao.security.BankDao;
import com.accdays.model.Account;
import com.accdays.service.security.BankService;

@Service
public class BankServiceImpl implements BankService {
	
	@Resource
    private BankDao bankDao;

    public Account[] findAccounts() {
        return this.bankDao.findAccounts();
    }

    public Account post(Account account, double amount) {
        Assert.notNull(account);

        // We read account back from DAO so it reflects the latest balance
        Account a = bankDao.readAccount(account.getId());
        if (a == null) {
            throw new IllegalArgumentException("Couldn't find requested account");
        }

        a.setBalance(a.getBalance() + amount);
        bankDao.createOrUpdateAccount(a);
        return a;
    }

    public Account readAccount(Long id) {
        return bankDao.readAccount(id);
    }
}
