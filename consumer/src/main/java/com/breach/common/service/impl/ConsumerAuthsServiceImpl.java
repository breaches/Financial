package com.breach.common.service.impl;

import com.breach.common.entity.ConsumerAuths;
import com.breach.common.mapper.IConsumerAuthsMapper;
import com.breach.common.service.IConsumerAuthsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户登录授权表
目前两种方式直接进行登录：
用户名
手机号码 服务实现类
 * </p>
 *
 * @author shaokang
 * @since 2019-01-10
 */
@Service
public class ConsumerAuthsServiceImpl extends ServiceImpl<IConsumerAuthsMapper, ConsumerAuths> implements IConsumerAuthsService {

}
