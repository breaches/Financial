package com.breach.huajinbao.service.sign.impl;

import com.breach.common.entity.ConsumerAccount;
import com.breach.common.entity.ConsumerAuths;
import com.breach.common.entity.ConsumerInfo;
import com.breach.common.mapper.IConsumerAccountMapper;
import com.breach.common.mapper.IConsumerAuthsMapper;
import com.breach.common.mapper.IConsumerInfoMapper;
import com.breach.huajinbao.mapper.sign.ISignUpMapper;
import com.breach.huajinbao.service.sign.ISignUpService;
import com.breach.huajinbao.sysconst.ISystemConsts;
import com.breach.huajinbao.sysconst.api.IApiConsts;
import com.breach.huajinbao.util.global.GlobalConsumerUtil;
import com.breach.huajinbao.util.global.MessageUtil;
import com.breach.huajinbao.util.sign.RegisterData;
import com.breach.huajinbao.util.sign.ReturnUtil;
import jdk.nashorn.internal.objects.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @program: Financial
 * @description: 注册具体实现类
 * @author: shaokang
 * @create: 2019-01-05 09:42
 **/
@Service
public class SignUpServiceImpl implements ISignUpService {

    @Autowired
    ISignUpMapper signUpMapper;
    @Autowired
    IConsumerInfoMapper consumerInfoMapper;
    @Autowired
    IConsumerAuthsMapper consumerAuthsMapper;
    @Autowired
    IConsumerAccountMapper consumerAccountMapper;

    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public ReturnUtil join(ConsumerAccount consumerAccount) {

        // 注册业务
        // 待完成

        return null;
    }

    /**
     * 发短信
     *
     * @param registerData
     * @return
     */
    @Override
    public ReturnUtil sendMessage(RegisterData registerData) {
        // 发送短信
        String phone = registerData.getPhone();
        if (phone != null && !phone.equals("")) {
            Object o = redisTemplate.opsForValue().get(phone);
            if(o != null) {
                // 有存
                redisTemplate.delete(phone);
            } else {
                // 有电话号码
                String code = MessageUtil.sendMessage(phone, IApiConsts.TEMPLATE_REGISTER);
                // 把 手机号码 与 随即验证码 一并存入 redis
                redisTemplate.opsForValue().set(phone, code);
                redisTemplate.expire("aaa", 5, TimeUnit.MINUTES);

                return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, "success");
            }
        }
        return new ReturnUtil(ISystemConsts.AJAX_ERROR, "error");
    }

    /**
     * 身份验证
     *
     * @param registerData
     * @return
     */
    @Override
    public ReturnUtil verifyCode(RegisterData registerData) {
        System.out.println("================================================");
        System.out.println("开始验证");
        System.out.println(registerData);
        System.out.println("================================================");
        // 验证短信验证码是否正确
        String randomCode = (String) redisTemplate.opsForValue().get(registerData.getPhone());
        System.out.println(registerData.getPhone());
        System.out.println(randomCode);
        if(randomCode == null) {
            System.out.println("手机号码错误");
            return new ReturnUtil(ISystemConsts.AJAX_ERROR, "手机号码错误");
        }
        String code = registerData.getCode();
        if (!code.equals("") && code != null) {
            if (randomCode.equals(code)) {
                // 验证成功 验证码正确

                System.out.println("验证成功");
                return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, "success");
            }

            System.out.println("错误验证码");
            return new ReturnUtil(ISystemConsts.AJAX_ERROR, "error");
        }
        // 接收到的验证码是空的
        System.out.println("空验证码");
        return new ReturnUtil(ISystemConsts.AJAX_ERROR, "error");
    }

    /**
     * 注册
     * 把用户信息插入用户信息表
     * 把账号密码插入授权表
     * 开通一个空的账户表
     * 最后把信息表的id给授权表跟账户表
     *
     * @param registerData
     * @return
     */
    @Override
    public ReturnUtil register(RegisterData registerData) {
        // 把用户的注册信息添加进数据库中
        String username = registerData.getUsername();
        String password = registerData.getPassword();
        String phone = registerData.getPhone();

        // 初始化用户账户
        ConsumerAccount consumerAccount = new ConsumerAccount();
        consumerAccount.setCreditAmount(new BigDecimal(0));
        consumerAccount.setCreditBalance(new BigDecimal(0));
        consumerAccount.setAvailableBalance(new BigDecimal(0));
        consumerAccount.setPrincipalMoney(new BigDecimal(0));
        consumerAccount.setPrincipalIncome(new BigDecimal(0));
        consumerAccount.setFrozenCapital(new BigDecimal(0));
        consumerAccountMapper.insert(consumerAccount);

        // 初始化用户信息
        ConsumerInfo consumerInfo = new ConsumerInfo();
        consumerInfo.setPhone(phone);
        consumerInfo.setNickname(username);
        consumerInfo.setAccountId(consumerAccount.getId()); // 账户id给用户信息绑定
        consumerInfoMapper.insert(consumerInfo);

        // 开通授权登陆信息
        ConsumerAuths consumerAuths = new ConsumerAuths();
        consumerAuths.setUsername(username);
        consumerAuths.setPassword(password);
        consumerAuths.setConsumerId(consumerInfo.getId()); // 用户信息id给授权登录绑定
        consumerAuthsMapper.insert(consumerAuths);

        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, "register success");
    }
}
