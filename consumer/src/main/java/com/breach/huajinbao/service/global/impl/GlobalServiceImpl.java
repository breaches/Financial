package com.breach.huajinbao.service.global.impl;

import com.aliyun.oss.internal.SignUtils;
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
import com.breach.huajinbao.util.global.IPAddressUtil;
import com.breach.huajinbao.util.sign.ConsumerSessionUtil;
import com.breach.huajinbao.util.sign.SignInUtil;
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

    /**
     * 获取登陆后用户的信息
     * @return
     */
    @Override
    public GlobalData getUserInfoAfterLogin() {
        ConsumerAuths consumer = ConsumerSessionUtil.getConsumer();

        if(consumer != null) {
            // get consumer info
            ConsumerInfo consumerInfo = consumerInfoMapper.selectById(consumer.getId());

            // set query parameter for account
            ConsumerAccount queryConsumerAccount = new ConsumerAccount();
            queryConsumerAccount.setId(consumerInfo.getAccountId());

            // result as account
            ConsumerAccount consumerAccount = consumerAccountMapper.selectOne(new QueryWrapper<>(queryConsumerAccount));

            // process userInfo
            List data = new ArrayList();
            Map map = new HashMap();
            map.put("id", consumer.getId());
            map.put("username", consumer.getUsername());
            map.put("account", consumerAccount.getId());
            data.add(map);

            /*ConsumerInfo queryConsumerInfo = new ConsumerInfo();
            queryConsumerInfo.setId(consumer.getId());
            ConsumerInfo consumerInfo = consumerInfoMapper.selectOne(new QueryWrapper<>(queryConsumerInfo));

            ConsumerAccount queryConsumerAccount = new ConsumerAccount();
            queryConsumerAccount.setId(consumerInfo.getAccountId());
            ConsumerAccount consumerAccount = consumerAccountMapper.selectOne(new QueryWrapper<>(queryConsumerAccount));*/

//            return new GlobalData(SignInUtil.processSignInInfo(consumerInfo, consumerAccount));
            return new GlobalData(data);
        }
        return null;
    }

    /**
     * 获取额度
     * @return
     */
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

    @Override
    public GlobalData getIP() {
        String clientIP = IPAddressUtil.getClientIP();
        return new GlobalData(200, clientIP);
    }
}
