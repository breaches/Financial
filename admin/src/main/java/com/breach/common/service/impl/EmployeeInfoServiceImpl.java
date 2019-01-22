package com.breach.common.service.impl;

import com.breach.common.entity.EmployeeInfo;
import com.breach.common.mapper.IEmployeeInfoMapper;
import com.breach.common.service.IEmployeeInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shaokang
 * @since 2019-01-21
 */
@Service
public class EmployeeInfoServiceImpl extends ServiceImpl<IEmployeeInfoMapper, EmployeeInfo> implements IEmployeeInfoService {

}
