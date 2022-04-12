package com.zyh.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
@MapperScan("com.zyh.springcloud.dao")
public class MybatisConfig {
}
