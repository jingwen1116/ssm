package com.ljw.service;

import com.ljw.domain.Account;

import java.io.IOException;
import java.util.List;

/**
 * @auther HP
 * @Date 2021/7/11 20:38
 */
public interface AccountService {

    void save(Account account);

    List<Account> findAll();
}
