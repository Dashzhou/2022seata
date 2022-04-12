package com.zyh.springcloud.service;



/**
 *
 */
public interface StorageService {
    Boolean decrease(Long productId, Integer count);
}
