package com.breach.huajinbao.controller.product;

import com.breach.huajinbao.service.product.IProductService;
import com.breach.huajinbao.util.product.QueryProduct;
import com.breach.huajinbao.util.sign.ReturnUtil;
import groovy.transform.AutoClone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Financial
 * @description: 产品
 * @author: shaokang
 * @create: 2019-01-19 14:29
 **/
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    /**商品列表页面加载后请求商品列表的数据**/
    @RequestMapping("/disperseBid")
    public ReturnUtil disperseBid(@RequestBody QueryProduct queryProduct) {
        return productService.disperseBid(queryProduct);
    }

    /**请求商品的详情页数据**/
    @RequestMapping("/loan/common")
    public ReturnUtil personBidDetail(@RequestBody String productID) {
        return productService.personBidDetail(productID.replace("=", ""));
    }

    /**请求借款人的资料**/
    @RequestMapping("/loan/common/getBorrowerInfo")
    public ReturnUtil getBorrowerInfo(String borrowNumber, String consumerID) {
        return productService.getBorrowerInfo(borrowNumber, consumerID);
    }


}
