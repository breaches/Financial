package com.breach.huajinbao.service.topup.impl;

import com.alipay.api.AlipayApiException;
import com.breach.api.alipay.service.PayService;
import com.breach.common.entity.ConsumerAccount;
import com.breach.common.entity.ConsumerInfo;
import com.breach.common.entity.ConsumerTopUpAlipayRecord;
import com.breach.common.mapper.IConsumerAccountMapper;
import com.breach.common.mapper.IConsumerInfoMapper;
import com.breach.common.mapper.IConsumerTopUpAlipayRecordMapper;
import com.breach.huajinbao.service.topup.ITopUpService;
import com.breach.huajinbao.util.global.TimeUtil;
import com.breach.huajinbao.util.pay.AlipayBackBean;
import com.breach.huajinbao.util.pay.AlipayBean;
import com.breach.huajinbao.util.pay.OrderUtil;
import com.breach.huajinbao.util.sign.ConsumerSessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-24 10:17
 **/
@Service
public class TopUpServiceImpl implements ITopUpService {
    @Resource
    private PayService payService;
    @Autowired
    private IConsumerTopUpAlipayRecordMapper consumerTopUpAlipayRecordMapper;
    @Autowired
    private IConsumerAccountMapper consumerAccountMapper;
    @Autowired
    private IConsumerInfoMapper consumerInfoMapper;

    /**
     * 调用 alipay 接口
     * @param alipayBean
     * @return
     */
    @Override
    public String alipay(AlipayBean alipayBean) throws AlipayApiException, AlipayApiException {
        System.out.println(alipayBean);
        String orderNumberOfAlipay = OrderUtil.getOrderNumberOfAlipay(alipayBean);
        // body 商品描述
        // out_trade_no 商户单号
        // total_amount 付款金额
        // subject 订单名称
        String s = payService.aliPay(new com.breach.api.alipay.bean.AlipayBean()
                .setBody("huajinbao")
                .setOut_trade_no(orderNumberOfAlipay)
                .setTotal_amount(new StringBuffer().append(alipayBean.getAmount()))
                .setSubject("online"));
        System.out.println("=============================================");
        System.out.println(s);
        System.out.println("=============================================");
        return s;
    }

    /**
     * 支付宝支付回调函数
     * @param consumerTopUpAlipayRecord
     * @return
     */
    @Override
    public String alipayBack(AlipayBackBean alipayBackBean) {
        System.out.println("-------------------------------------------");
        System.out.println(alipayBackBean);
        System.out.println("-------------------------------------------");

        // 查到用户的信息
        ConsumerInfo consumerInfo = consumerInfoMapper.selectById(ConsumerSessionUtil.getConsumer().getId());
        // 设置当前的用户
        ConsumerTopUpAlipayRecord consumerTopUpAlipayRecord = new ConsumerTopUpAlipayRecord();
        consumerTopUpAlipayRecord.setConsumerId(consumerInfo.getId());
        consumerTopUpAlipayRecord.setOutTradeNo(alipayBackBean.getOut_trade_no());
        consumerTopUpAlipayRecord.setTradeNo(alipayBackBean.getTrade_no());
        consumerTopUpAlipayRecord.setTotalAmount(alipayBackBean.getTotal_amount());
        consumerTopUpAlipayRecord.setAuthAppId(alipayBackBean.getAuth_app_id());
        consumerTopUpAlipayRecord.setAppId(alipayBackBean.getAuth_app_id());
        consumerTopUpAlipayRecord.setSellerId(alipayBackBean.getSeller_id());
        consumerTopUpAlipayRecord.setSignType(alipayBackBean.getSign_type());
        consumerTopUpAlipayRecord.setTimestamp(TimeUtil.getSqlTimeStamp());
        consumerTopUpAlipayRecord.setMethod(alipayBackBean.getMethod());
        System.out.println("11111111111111111111111111111111111111111111111111");
        System.out.println(consumerTopUpAlipayRecord);
        System.out.println("11111111111111111111111111111111111111111111111111");
        // 插入充值记录
        consumerTopUpAlipayRecordMapper.insert(consumerTopUpAlipayRecord);

        // 查出用户的账户信息
        ConsumerAccount consumerAccount = consumerAccountMapper.selectById(consumerInfo.getAccountId());
        consumerAccount.setAvailableBalance(
                consumerAccount.getAvailableBalance().add(
                        consumerTopUpAlipayRecord.getTotalAmount()
                ).setScale(2, BigDecimal.ROUND_HALF_UP)
        );
        // 增加余额
        int i = consumerAccountMapper.updateById(consumerAccount);

        if(i >0) {
            // 充值成功
            return "/topup/success";
        }

        return null;
    }
}
