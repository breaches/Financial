package com.breach.huajinbao.mapper.product;

import com.breach.huajinbao.util.product.QueryProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-19 14:31
 **/
public interface IProductMapper {

    List<Map<String, Object>> disperseBid(QueryProduct queryProduct);

    Integer disperseBidTotal(QueryProduct queryProduct);

    Map<String, Object> personBidDetail(String productID);

    Map<String, Object> getBorrowerInfo(@Param("borrowNumber") String borrowNumber, @Param("consumerID") String consumerID);
}
