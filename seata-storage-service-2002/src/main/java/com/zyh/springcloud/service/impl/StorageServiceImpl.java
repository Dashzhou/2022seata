package com.zyh.springcloud.service.impl;

import com.zyh.springcloud.dao.StorageDao;
import com.zyh.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 *
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public Boolean decrease(Long productId, Integer count) {

        if (storageDao.residue(productId) < count) {
            return false;
        }
        log.info("--------residue被执行----------------");
        storageDao.decrease(productId, count);
        log.info("--------decrease被执行----------------");
        return true;
    }
}
