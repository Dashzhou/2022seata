package com.zyh.springcloud.controller;


import com.zyh.spring.commons3.pojo.CommonResult;
import com.zyh.springcloud.domain.Order;
import com.zyh.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

/**
 *
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult createOrder(Order order) {
        return orderService.create(order);
    }
}
