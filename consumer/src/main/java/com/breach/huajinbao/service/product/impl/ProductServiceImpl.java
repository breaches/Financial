package com.breach.huajinbao.service.product.impl;

import com.breach.common.entity.UserBorrowBidApplyRecord;
import com.breach.huajinbao.mapper.product.IProductMapper;
import com.breach.huajinbao.service.product.IProductService;
import com.breach.huajinbao.sysconst.ISystemConsts;
import com.breach.huajinbao.util.product.QueryProduct;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-19 14:30
 **/
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductMapper productMapper;


    @Override
    public ReturnUtil disperseBid(QueryProduct queryProduct) {
        System.out.println("=====================================");
        System.out.println("查询条件");
        System.out.println(queryProduct);
        System.out.println("=====================================");

        List<Map<String, Object>> result =  productMapper.disperseBid(queryProduct);
        Integer integer = productMapper.disperseBidTotal(queryProduct);

        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, result, integer);
    }
}
