package com.breach.huajinbao.service.global.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.breach.common.entity.ConsumerAccount;
import com.breach.common.entity.ConsumerAuths;
import com.breach.common.entity.ConsumerInfo;
import com.breach.common.mapper.IConsumerAccountMapper;
import com.breach.common.mapper.IConsumerAuthsMapper;
import com.breach.common.mapper.IConsumerInfoMapper;
import com.breach.common.mapper.IRegionProvinceMapper;
import com.breach.huajinbao.service.global.IGlobalService;
import com.breach.huajinbao.sysconst.ISystemConsts;
import com.breach.huajinbao.util.global.GlobalConsumerUtil;
import com.breach.huajinbao.util.global.GlobalData;
import com.breach.huajinbao.util.sign.ConsumerSessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-08 13:08
 **/
@Service
public class GlobalServiceImpl implements IGlobalService {

    @Autowired
    IConsumerAuthsMapper consumerAuthsMapper;
    @Autowired
    IRegionProvinceMapper regionProvinceMapper;
    @Autowired
    IConsumerInfoMapper consumerInfoMapper;
    @Autowired
    IConsumerAccountMapper consumerAccountMapper;

    @Override
    public GlobalData getUserInfoAfterLogin() {
        ConsumerAuths consumer = ConsumerSessionUtil.getConsumer();

        if(consumer != null) {
            List data = new ArrayList();
            Map map = new HashMap();
            map.put("id", consumer.getId());
            map.put("username", consumer.getUsername());
            data.add(map);
            return new GlobalData(data);
        }
        return null;
    }

    @Override
    public GlobalData getAmount() {
        if(GlobalConsumerUtil.isLogin()) {
            // 登录过
            ConsumerInfo queryConsumerInfo = new ConsumerInfo();
            queryConsumerInfo.setId(ConsumerSessionUtil.getConsumer().getConsumerId());
            ConsumerInfo consumerInfo = consumerInfoMapper.selectOne(new QueryWrapper<>(queryConsumerInfo));
            ConsumerAccount queryConsumerAccount = new ConsumerAccount();
            queryConsumerAccount.setId(consumerInfo.getAccountId());
            ConsumerAccount consumerAccount = consumerAccountMapper.selectOne(new QueryWrapper<>(queryConsumerAccount));
            System.out.println(consumerAccount);
            return new GlobalData(ISystemConsts.AJAX_SUCCESS, consumerAccount);
        }
        return new GlobalData(ISystemConsts.AJAX_IS_NOT_LOGIN);
    }
}
