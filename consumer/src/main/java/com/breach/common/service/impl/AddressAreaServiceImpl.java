package com.breach.common.service.impl;

import com.breach.common.entity.AddressArea;
import com.breach.common.mapper.IAddressAreaMapper;
import com.breach.common.service.IAddressAreaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 该实体为行政区域划分等级 服务实现类
 * </p>
 *
 * @author shaokang
 * @since 2019-01-10
 */
@Service
public class AddressAreaServiceImpl extends ServiceImpl<IAddressAreaMapper, AddressArea> implements IAddressAreaService {

}
