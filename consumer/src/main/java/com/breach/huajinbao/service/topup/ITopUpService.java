package com.breach.huajinbao.service.topup;

import com.alipay.api.AlipayApiException;
import com.breach.huajinbao.util.pay.AlipayBackBean;
import com.breach.common.entity.ConsumerTopUpAlipayRecord;
import com.breach.huajinbao.util.pay.AlipayBean;
import com.breach.huajinbao.util.sign.ReturnUtil;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-24 10:12
 **/
public interface ITopUpService {
    String alipay(AlipayBean alipayBean) throws AlipayApiException;

    String alipayBack(AlipayBackBean alipayBackBean);

}
