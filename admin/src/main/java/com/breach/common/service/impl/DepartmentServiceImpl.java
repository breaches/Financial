package com.breach.common.service.impl;

import com.breach.common.entity.Department;
import com.breach.common.mapper.IDepartmentMapper;
import com.breach.common.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shaokang
 * @since 2019-01-03
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<IDepartmentMapper, Department> implements IDepartmentService {
    //@Autowired
    //IDepartmentMapper departmentMapper;
}
