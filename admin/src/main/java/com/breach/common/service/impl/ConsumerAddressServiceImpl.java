package com.breach.common.service.impl;

import com.breach.common.entity.ConsumerAddress;
import com.breach.common.mapper.IConsumerAddressMapper;
import com.breach.common.service.IConsumerAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 存放用户的地址信息 服务实现类
 * </p>
 *
 * @author shaokang
 * @since 2019-01-21
 */
@Service
public class ConsumerAddressServiceImpl extends ServiceImpl<IConsumerAddressMapper, ConsumerAddress> implements IConsumerAddressService {

}
