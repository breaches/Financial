package com.breach.common.mapper;

import com.breach.common.entity.ConsumerAccount;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 账户表
包含该用户的：全部余额，可用余额，冻结金额，
全部余额 = 可用余额 + 冻结金额
可用余额 = 全部余额 - 冻结金额
冻结金额 = 投标空缺期 Mapper 接口
 * </p>
 *
 * @author shaokang
 * @since 2019-01-22
 */
public interface IConsumerAccountMapper extends BaseMapper<ConsumerAccount> {

}
