package com.breach.api.alipay.service.impl;

import com.alipay.api.AlipayApiException;
import com.breach.api.alipay.bean.AlipayBean;
import com.breach.api.alipay.config.AlipayUtil;
import com.breach.api.alipay.service.PayService;
import org.springframework.stereotype.Service;

/**
 * @program: demoqq
 * @description:
 * @author: shaokang
 * @create: 2019-01-23 21:28
 **/

@Service(value = "alipayOrderService")
public class PayServiceImpl implements PayService {
    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return AlipayUtil.connect(alipayBean);
    }
}
