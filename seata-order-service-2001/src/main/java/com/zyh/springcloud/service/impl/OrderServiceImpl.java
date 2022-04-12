package com.zyh.springcloud.service.impl;

import com.zyh.spring.commons3.pojo.CommonResult;
import com.zyh.springcloud.dao.OrderDao;
import com.zyh.springcloud.domain.Order;
import com.zyh.springcloud.service.AccountService;
import com.zyh.springcloud.service.OrderService;
import com.zyh.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 *
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private AccountService accountService;

    @Resource
    private StorageService storageService;

    @Override
    @GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
    public CommonResult create(Order order) {
        log.info("-------Order订单开始创建---------");
        orderDao.create(order);
        log.info("-------Order订单开始电影微服务库存--------");
        CommonResult storageDecrease = storageService.decrease(order.getProductId(), order.getCount());
        if (storageDecrease.getCode() == 444) {
            return storageDecrease;
        }
        log.info("-------Order订单开始电影微服务库存,库存扣减结束--------");
        log.info("--------------用户账户扣款-------------");
        CommonResult accountDecrease = accountService.decrease(order.getUserId(), order.getMoney());
        if (accountDecrease.getCode() == 444) {
            return accountDecrease;
        }
        log.info("--------------用户账户扣款 END-------------");

        log.info("-------修改订单状态 0->1---------");

        orderDao.update(order.getUserId(), 0);

        log.info("-------修改订单状态结束---------");
        return new CommonResult(200, "订单下单成功，等待配送。。。。。");
    }

    @Override
    public void update(Long userId, Integer status) {

    }
}
