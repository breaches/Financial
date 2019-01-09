package com.breach.common.service;

import com.breach.common.entity.ConsumerAccount;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 账户表
包含该用户的：全部余额，可用余额，冻结金额，
全部余额 = 可用余额 + 冻结金额
可用余额 = 全部余额 - 冻结金额
冻结金额 = 投标空缺期 服务类
 * </p>
 *
 * @author shaokang
 * @since 2019-01-07
 */
public interface IConsumerAccountService extends IService<ConsumerAccount> {

}
