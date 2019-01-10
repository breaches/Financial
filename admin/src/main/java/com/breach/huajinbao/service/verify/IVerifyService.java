package com.breach.huajinbao.service.verify;

import com.breach.huajinbao.util.verify.VerifyQuery;

import java.util.Map;

/**
 * Created by wanghehe on 2019年01月05日
 * 认证信息业务层
 *
 */
public interface IVerifyService {


    Map<String, Object> getUserInfo(VerifyQuery info);
}
