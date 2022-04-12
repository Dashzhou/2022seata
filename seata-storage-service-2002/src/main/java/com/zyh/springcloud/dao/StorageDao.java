package com.zyh.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 *
 */
@Mapper
public interface StorageDao {
    /*
     根据订单信息扣除库存数量
    * */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);


    /*查询当前剩余库存数量
     * */
    Integer residue(@Param("productId") Long productId);

}
