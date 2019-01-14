package com.breach.huajinbao.service.sign.impl;

import com.breach.common.entity.ConsumerAccount;
import com.breach.common.entity.ConsumerAuths;
import com.breach.common.entity.ConsumerInfo;
import com.breach.common.mapper.IConsumerAuthsMapper;
import com.breach.common.mapper.IConsumerInfoMapper;
import com.breach.huajinbao.mapper.sign.ISignUpMapper;
import com.breach.huajinbao.service.sign.ISignUpService;
import com.breach.huajinbao.sysconst.ISystemConsts;
import com.breach.huajinbao.sysconst.api.IApiConsts;
import com.breach.huajinbao.util.global.MessageUtil;
import com.breach.huajinbao.util.sign.RegisterData;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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



    @Override
    public ReturnUtil join(ConsumerAccount consumerAccount) {

        // 注册业务
        // 待完成

        return null;
    }

    @Override
    public ReturnUtil sendMessage(RegisterData registerData) {
        // 发送短信
        String phone = registerData.getPhone();
        if (phone != null && !phone.equals("")) {
            // 有电话号码
            MessageUtil.sendMessage(phone, IApiConsts.TEMPLATE_REGISTER);
            return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, "success");
        }
        return new ReturnUtil(ISystemConsts.AJAX_ERROR, "error");
    }

    @Override
    public ReturnUtil verifyCode(RegisterData registerData) {
        System.out.println("================================================");
        System.out.println(registerData);
        System.out.println("================================================");
        // 验证短信验证码是否正确
        String randomCode = MessageUtil.getRandomCode();
        String code = registerData.getCode();
        if (!code.equals("") && code != null) {
            if(randomCode.equals(code)) {
                // 验证成功 验证码正确
                return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, "success");
            }
            // 接收到的验证码是空的
            return new ReturnUtil(ISystemConsts.AJAX_ERROR, "error");
        }
        return new ReturnUtil(ISystemConsts.AJAX_ERROR, "error");
    }

    @Override
    public ReturnUtil register(RegisterData registerData) {
        // 把用户的注册信息添加进数据库中
        String username = registerData.getUsername();
        String password = registerData.getPassword();
        String phone = registerData.getPhone();

        // 需要把用户名and密码插入到 consumer_Auths表中
        // 把username与phone插入到 consumer_info 表中 把返回的id给 consumer_Auths

        ConsumerInfo consumerInfo = new ConsumerInfo();
        ConsumerAuths consumerAuths = new ConsumerAuths();

        consumerInfo.setPhone(phone);
        consumerInfo.setNickname(username);

        System.out.println(consumerInfo);
        // signUpMapper.addConsumer(consumerInfo);
        consumerInfoMapper.insert(consumerInfo);

        System.out.println("-----------------------------------------------");
        System.out.println("插入客户信息后");
        System.out.println(consumerInfo);
        System.out.println("-----------------------------------------------");

        // 保存用户名与密码
        consumerAuths.setUsername(username);
        consumerAuths.setPassword(password);
        consumerAuths.setConsumerId(consumerInfo.getId());

        consumerAuthsMapper.insert(consumerAuths);

        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, "register success");
    }
}
