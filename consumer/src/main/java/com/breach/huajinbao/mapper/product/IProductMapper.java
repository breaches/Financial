package com.breach.huajinbao.mapper.product;

import com.breach.common.entity.UserBorrowBidApplyRecord;
import com.breach.huajinbao.util.product.QueryProduct;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-19 14:31
 **/
public interface IProductMapper {
//    @Select("select * from user_borrow_bid_apply_record")
    List<Map<String, Object>> disperseBid(QueryProduct queryProduct);

}
