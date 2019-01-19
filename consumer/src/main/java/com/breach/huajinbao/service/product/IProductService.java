package com.breach.huajinbao.service.product;

import com.breach.huajinbao.util.product.QueryProduct;
import com.breach.huajinbao.util.sign.ReturnUtil;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-19 14:30
 **/
public interface IProductService {
    ReturnUtil disperseBid(QueryProduct queryProduct);

}
