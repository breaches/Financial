package com.breach.common.service.impl;

import com.breach.common.entity.EmployeeAccount;
import com.breach.common.mapper.IEmployeeAccountMapper;
import com.breach.common.service.IEmployeeAccountService;
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
public class EmployeeAccountServiceImpl extends ServiceImpl<IEmployeeAccountMapper, EmployeeAccount> implements IEmployeeAccountService {

}
