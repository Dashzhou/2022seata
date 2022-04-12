package com.zyh.springcloud.servcie.impl;

import com.zyh.springcloud.dao.AccountDao;
import com.zyh.springcloud.servcie.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 *
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountDao accountDao;

    @Override
    public Boolean decrease(Long userId, BigDecimal money) {
        int i = accountDao.residue(userId).compareTo(money);
        if (i < 0) {
            return false;
        }
        ;
        accountDao.decrease(userId, money);
        return true;
    }
}
