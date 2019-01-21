package com.breach.huajinbao.service.product.impl;

import com.breach.common.entity.UserBorrowBidApplyRecord;
import com.breach.huajinbao.mapper.product.IProductMapper;
import com.breach.huajinbao.service.product.IProductService;
import com.breach.huajinbao.sysconst.ISystemConsts;
import com.breach.huajinbao.util.product.QueryProduct;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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


    /**
     * 散标列表页面加载后请求散标的数据
     * @param queryProduct
     * @return
     */
    @Override
    public ReturnUtil disperseBid(QueryProduct queryProduct) {

        List<Map<String, Object>> result =  productMapper.disperseBid(queryProduct);
        Integer integer = productMapper.disperseBidTotal(queryProduct);

        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, result, integer);
    }

    /**
     * 散标的详情数据页面的请求
     * @param productID
     * @return
     */
    @Override
    public ReturnUtil personBidDetail(String productID) {
        System.out.println(productID);
        Map<String, Object> data = productMapper.personBidDetail(productID);
        System.out.println(data);
        return new ReturnUtil(ISystemConsts.PRODUCT_LOAN_PERSON_BID_DETAIL_SUCCESS, data);
    }
}
