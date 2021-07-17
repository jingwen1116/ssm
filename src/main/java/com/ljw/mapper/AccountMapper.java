package com.ljw.mapper;

import com.ljw.domain.Account;

import java.util.List;

/**
 * @auther HP
 * @Date 2021/7/11 20:08
 */
public interface AccountMapper {

    void save(Account account);

    List<Account> findAll();

}
