package com.breach.huajinbao.service.rechange.Impl;

import com.breach.huajinbao.mapper.rechange.IUnionPayMapper;
import com.breach.huajinbao.service.rechange.IPayService;
import com.breach.huajinbao.util.sign.ConsumerSessionUtil;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PayServiceImpl implements IPayService {

    @Autowired
    IUnionPayMapper unionpay;

    @Override
    public ReturnUtil pass(Integer password) {
        Integer pass = unionpay.pass(password);

        if (pass != null) {
            return new ReturnUtil(200);
        }else{
            return new ReturnUtil(300);
        }
    }

    @Override
    public ReturnUtil recharge(Integer money) {
        Integer q = ConsumerSessionUtil.getConsumer().getConsumerId();
        unionpay.recharge(money,q);

        return new ReturnUtil(110);
    }
}
