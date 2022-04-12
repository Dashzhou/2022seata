package com.zyh.springcloud.controller;

import com.zyh.spring.commons3.pojo.CommonResult;
import com.zyh.springcloud.servcie.AccountService;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 *
 */
@RestController
public class AccountController {
    @Resource
    private AccountService accountService;

    @PostMapping("/account/decrease")
    CommonResult decrease(Long userId, BigDecimal money) {
        Boolean decrease = accountService.decrease(userId, money);
        if (!decrease) {
            return new CommonResult(444, "账户余额不足");
        }
        return new CommonResult(200, "账户余额扣除成功");
    }

    ;
}
