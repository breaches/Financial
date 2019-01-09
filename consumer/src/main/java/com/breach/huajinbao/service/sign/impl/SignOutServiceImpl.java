package com.breach.huajinbao.service.sign.impl;

import com.breach.common.entity.ConsumerAuths;
import com.breach.huajinbao.service.sign.ISignOutService;
import com.breach.huajinbao.sysconst.ISystemConsts;
import com.breach.huajinbao.util.sign.ConsumerSessionUtil;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.stereotype.Service;

/**
 * @program: Financial
 * @description: 注销、退出登陆具体实现业务
 * @author: shaokang
 * @create: 2019-01-05 09:42
 **/
@Service
public class SignOutServiceImpl implements ISignOutService {
    @Override
    public ReturnUtil logout() {
        ConsumerAuths consumer = ConsumerSessionUtil.getConsumer();
        if(consumer != null) {
            // 有登录用户
            ConsumerSessionUtil.removeConsumer();
            return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, "success");
        }
        // 没有登录用户
        return new ReturnUtil(ISystemConsts.AJAX_ERROR, "error");
    }
}
