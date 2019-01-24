package com.breach.common.service.impl;

import com.breach.common.entity.ConsumerAccount;
import com.breach.common.mapper.IConsumerAccountMapper;
import com.breach.common.service.IConsumerAccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 账户表
包含该用户的：全部余额，可用余额，冻结金额，
全部余额 = 可用余额 + 冻结金额
可用余额 = 全部余额 - 冻结金额
冻结金额 = 投标空缺期 服务实现类
 * </p>
 *
 * @author shaokang
 * @since 2019-01-22
 */
@Service
public class ConsumerAccountServiceImpl extends ServiceImpl<IConsumerAccountMapper, ConsumerAccount> implements IConsumerAccountService {

}
