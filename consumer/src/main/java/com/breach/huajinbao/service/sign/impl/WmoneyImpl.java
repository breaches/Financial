package com.breach.huajinbao.service.sign.impl;

import com.breach.common.entity.ConsumerAuths;
import com.breach.huajinbao.mapper.sign.IWmoneyMapper;
import com.breach.huajinbao.service.sign.IWmoney;
import com.breach.huajinbao.util.sign.ConsumerSessionUtil;
import com.breach.huajinbao.util.sign.Result;
import com.breach.huajinbao.util.sign.Withdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


@Service
public class WmoneyImpl implements IWmoney {
    @Autowired
    private IWmoneyMapper iWmoneyMapper;

    @Override
    public Map<String,Object> wi() {
            //获取当前用户登录的id
        ConsumerAuths consumer = ConsumerSessionUtil.getConsumer();
        int id=consumer.getConsumerId();
        //int id = consumer.getId();

        //通过id查询用户可提现余额
        BigDecimal wi = iWmoneyMapper.wi(id);
        //System.out.println(1);
        System.out.println(wi);
        System.out.println(id);
        //新建map，把查到的值存到map中
        Map<String, Object> map = new HashMap<>();
        map.put("wi",wi);
        return map;

    }

    @Override
    public Map<String,Object> blMoney(BigDecimal money) {
        System.out.println(money);
        //获取登录者id
        ConsumerAuths consumer = ConsumerSessionUtil.getConsumer();
        int id=consumer.getConsumerId();
        //获取登录者信息
        Map<String,Object> data =iWmoneyMapper.blMoney(id);
        System.out.println(data);
        //客户输入的金额
        BigDecimal a=money;

        //计算出手续费c
        BigDecimal c= a.multiply(new BigDecimal(0.02));
        //计算出最终到账金额d
        BigDecimal d= a.subtract(c);
        //计算出最终提现金额


        Map<String, Object>map=new HashMap<>();
        map.put("aaa",data);
        map.put("ccc",c);
       map.put("ddd",d);


        return map;
    }

    @Override
    public Result notarize(Withdraw w) {
        //获取用户登录id
        ConsumerAuths consumer = ConsumerSessionUtil.getConsumer();
        int id=consumer.getConsumerId();

        //获取用户账户id
       int Id= iWmoneyMapper.getId(id);
        //提现总扣费
        BigDecimal blmoney=w.getCommission().add(w.getMoney());
        //提现费加到公司账户

        iWmoneyMapper.notarize(w.getMoney());
        //提现用户金额减掉
        iWmoneyMapper.notarizes(blmoney,Id);

        return new Result(200,"提现成功");
    }
}
