package com.breach.huajinbao.mapper.sign;

import com.breach.common.entity.ConsumerInfo;

/**
 * @program: Financial
 * @description: 注册 Dao 层接口
 * @author: shaokang
 * @create: 2019-01-05 09:44
 **/
public interface ISignUpMapper {
    // 添加
    void addConsumer(ConsumerInfo consumerInfo);
}
