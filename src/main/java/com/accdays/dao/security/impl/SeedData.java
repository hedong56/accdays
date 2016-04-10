package com.accdays.dao.security.impl;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.util.Assert;

import com.accdays.dao.security.BankDao;
import com.accdays.model.Account;

public class SeedData implements InitializingBean{
    private BankDao bankDao;

    public void afterPropertiesSet() throws Exception {
        Assert.notNull(bankDao);
        bankDao.createOrUpdateAccount(new Account("rod"));
        bankDao.createOrUpdateAccount(new Account("dianne"));
        bankDao.createOrUpdateAccount(new Account("scott"));
        bankDao.createOrUpdateAccount(new Account("peter"));
    }

    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

}
