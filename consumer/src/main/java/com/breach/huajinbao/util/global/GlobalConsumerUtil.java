package com.breach.huajinbao.util.global;

import com.breach.huajinbao.util.sign.ConsumerSessionUtil;

/**
 * @program: Financial
 * @description: 全局用户工具
 * @author: shaokang
 * @create: 2019-01-12 14:39
 **/
public class GlobalConsumerUtil {

    public static boolean isLogin() {
        if (ConsumerSessionUtil.getConsumer() != null) {
            return true;
        } else {
            return false;
        }
    }

}
