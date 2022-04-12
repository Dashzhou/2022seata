package com.zyh.springcloud.servcie;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 *
 */
public interface AccountService {
    Boolean decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

}
