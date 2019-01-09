package com.breach.huajinbao.service.sign.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.breach.common.entity.ConsumerAccount;
import com.breach.common.entity.ConsumerAuths;
import com.breach.common.entity.ConsumerInfo;
import com.breach.common.mapper.IConsumerAccountMapper;
import com.breach.common.mapper.IConsumerAuthsMapper;
import com.breach.common.mapper.IConsumerInfoMapper;
import com.breach.huajinbao.service.sign.ISignInService;
import com.breach.huajinbao.sysconst.ISystemConsts;
import com.breach.huajinbao.util.sign.ConsumerSessionUtil;
import com.breach.huajinbao.util.sign.MobilePhoneUtil;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

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
    private IConsumerAuthsMapper consumerAuthsMapper;
    @Autowired
    private IConsumerInfoMapper consumerInfoMapper;

    /**
     * 直接登陆服务实现方法
     **/
    @Override
    public ReturnUtil login(ConsumerAuths consumerAuths) {
        // 判断该用户是否使用手机号码作为登陆账号
        if (MobilePhoneUtil.isMobilePhone(consumerAuths.getUsername())) { // 是使用手机号码作为登录账号
            // 封装查询用户条件
            ConsumerInfo queryConsumerInfo = new ConsumerInfo();
            queryConsumerInfo.setPhone(consumerAuths.getUsername());

            // 在用户信息表查找
            ConsumerInfo consumerInfo = consumerInfoMapper.selectOne(new QueryWrapper<ConsumerInfo>(queryConsumerInfo));

            if (consumerInfo != null) {
                // 进一步查询密码是否正确
                // 封装密码匹配条件
                ConsumerAuths queryConsumerAuths = new ConsumerAuths();
                queryConsumerAuths.setPassword(consumerAuths.getPassword());
                queryConsumerAuths.setConsumerId(consumerAuths.getId());

                // 查询密码是否正确
                ConsumerAuths result = consumerAuthsMapper.selectOne(new QueryWrapper<>(queryConsumerAuths));
                if (result != null) { // 如果有结果 则登录正确
                    // 登录成功
                    ConsumerSessionUtil.setConsumer(result);
                    return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, "success", result);
                } else {
                    // 用户名或密码错误 登录失败
                    return new ReturnUtil(ISystemConsts.AJAX_ERROR, "error");
                }
            } else {
                // 用户信息查询不到 说明没有人使用这个手机号码
                return new ReturnUtil(ISystemConsts.AJAX_ERROR, "error");
            }

        } else {
            // 那么这个分支就是使用用户名作为账号登录
            ConsumerAuths result = consumerAuthsMapper.selectOne(new QueryWrapper<>(consumerAuths));
            System.out.println("----------------------------------");
            System.out.println("result");
            System.out.println(result);
            System.out.println("----------------------------------");
            if (result != null) {
                // 登录成功
                ConsumerSessionUtil.setConsumer(result);
                return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, "success", result);
            } else {
                // 登录失败
                return new ReturnUtil(ISystemConsts.AJAX_ERROR, "error");
            }
        }
    }
}
