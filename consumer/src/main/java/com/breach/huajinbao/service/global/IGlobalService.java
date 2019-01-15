package com.breach.huajinbao.service.global;

import com.breach.huajinbao.util.global.GlobalData;

public interface IGlobalService {
    /** 获取登录后用户的信息 用户登录后获取用户信息 **/
    GlobalData getUserInfoAfterLogin();

    GlobalData getAmount();

}
