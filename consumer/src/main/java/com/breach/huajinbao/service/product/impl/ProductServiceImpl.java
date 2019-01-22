package com.breach.huajinbao.service.product.impl;

import com.breach.huajinbao.mapper.product.IProductMapper;
import com.breach.huajinbao.service.product.IProductService;
import com.breach.huajinbao.sysconst.ISystemConsts;
import com.breach.huajinbao.util.product.ProductUtil;
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


    /**
     * 散标列表页面加载后请求散标的数据
     *
     * @param queryProduct
     * @return
     */
    @Override
    public ReturnUtil disperseBid(QueryProduct queryProduct) {

        List<Map<String, Object>> result = productMapper.disperseBid(queryProduct);
        Integer integer = productMapper.disperseBidTotal(queryProduct);

        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, result, integer);
    }

    /**
     * 散标的详情数据页面的请求
     *
     * @param productID
     * @return
     */
    @Override
    public ReturnUtil personBidDetail(String productID) {
        Map<String, Object> data = productMapper.personBidDetail(productID);
        // 判空
        if (data == null) {
            return new ReturnUtil(
                    ISystemConsts.PRODUCT_LOAN_PERSON_BID_DETAIL_IS_NOT_EXIST,
                    "对不起，标不存在。"
            );
        } else {
            return new ReturnUtil(
                    ISystemConsts.PRODUCT_LOAN_PERSON_BID_DETAIL_SUCCESS,
                    ProductUtil.getData(data)
            );
        }

    }

    /**
     * 获取借款人信息
     * @param borrowNumber
     * @param consumerID
     * @return
     */
    @Override
    public ReturnUtil getBorrowerInfo(String borrowNumber, String consumerID) {
        // 获取基础信息
        Map<String, Object> data = productMapper.getBorrowerInfo(borrowNumber, consumerID);
        System.out.println(data);

        return new ReturnUtil(
                ISystemConsts.PRODUCT_LOAN_PERSON_BID_DETAIL_GET_BORROWER_INFO_SUCCESS,
                ProductUtil.getBorrowerInfo(data)
        );
    }
}
