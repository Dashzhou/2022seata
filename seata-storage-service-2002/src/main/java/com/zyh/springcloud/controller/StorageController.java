package com.zyh.springcloud.controller;

import com.zyh.spring.commons3.pojo.CommonResult;
import com.zyh.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

/**
 *
 */
@RestController
@Slf4j
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping(value = "/storage/decrease")
    CommonResult decrease(Long productId, Integer count) {
        log.info("---------------------productId=" + productId + "--------count=" + count);
        Boolean decrease = storageService.decrease(productId, count);
        if (!decrease) {
            new CommonResult(444, "库存不足，无法扣除库存数量");
        }
        return new CommonResult(200, "除库存数量成功");
    }

    ;

}
