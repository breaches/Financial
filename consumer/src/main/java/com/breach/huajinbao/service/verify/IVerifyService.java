package com.breach.huajinbao.service.verify;

import com.breach.huajinbao.util.sign.ReturnUtil;

/**
 * @program: Financial
 * @description: 认证
 * @author: shaokang
 * @create: 2019-01-10 19:27
 **/
public interface IVerifyService {
    ReturnUtil listAllProvince();

    ReturnUtil listAllRegions();

}
