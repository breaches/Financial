package com.breach.api.alipay.service;

import com.alipay.api.AlipayApiException;
import com.breach.api.alipay.bean.AlipayBean;

public interface PayService {
    /*支付宝*/
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;
}
