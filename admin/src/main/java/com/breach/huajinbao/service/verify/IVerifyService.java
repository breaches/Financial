package com.breach.huajinbao.service.verify;

import com.breach.huajinbao.util.verify.Result;
import com.breach.huajinbao.util.verify.VerifyQuery;

import java.util.Map;

/**
 * Created by wanghehe on 2019年01月05日
 * 认证信息业务层
 *
 */
public interface IVerifyService {

    /**
     * 分页和查询（认证详情表）
     * @param
     * @return
     *
     */
    Map<String, Object> getUserInfo(VerifyQuery info);
    /**
     * 需要展示的个人的全部信息
     * @param
     * @return
     *
     */
    Map<String,Object> getDetailed(String record);
    /**
     * 提交成功请求
     * @param
     * @return
     *
     */
    Result submitReInfo(String recordNumber);
    /**
     * 提交失败请求
     * @param
     * @return
     *
     */
    Result submitNoInfo(String recordNumber);
}
