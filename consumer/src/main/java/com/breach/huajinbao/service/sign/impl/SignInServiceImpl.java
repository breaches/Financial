package com.breach.huajinbao.service.sign.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.breach.common.entity.ConsumerAccount;
import com.breach.common.mapper.IConsumerAccountMapper;
import com.breach.huajinbao.service.sign.ISignInService;
import com.breach.huajinbao.sysconst.ISystemConsts;
import com.breach.huajinbao.util.sign.ConsumerSessionUtil;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: Financial
 * @description: 登录业务具体实现类
 * @author: shaokang
 * @create: 2019-01-05 09:40
 * http://www.cnblogs.com/liuyangfirst/p/9738792.html
 **/
@Service
public class SignInServiceImpl implements ISignInService {

    @Autowired
    IConsumerAccountMapper consumerAccountMapper;

    @Override
    public ReturnUtil login(ConsumerAccount consumerAccount) {

        // 查询数据库中传来的条件
        ConsumerAccount result = consumerAccountMapper.selectOne(new QueryWrapper<ConsumerAccount>(consumerAccount));

        if(result != null) {
            // 登录成功
            ConsumerSessionUtil.setConsumer(result);
            return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, "success");
        }
        // 登录失败
        return new ReturnUtil(ISystemConsts.AJAX_ERROR, "error");
    }
}
