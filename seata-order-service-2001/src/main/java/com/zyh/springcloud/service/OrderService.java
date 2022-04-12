package com.zyh.springcloud.service;

import com.zyh.spring.commons3.pojo.CommonResult;
import com.zyh.springcloud.domain.Order;

import org.apache.ibatis.annotations.Param;


/**
 *
 */
public interface OrderService {
     CommonResult create(Order order);

    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
