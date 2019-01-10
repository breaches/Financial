package com.breach.huajinbao.service.verify.impl;

import com.breach.huajinbao.mapper.verify.IVerifyMapper;
import com.breach.huajinbao.service.verify.IVerifyService;
import com.breach.huajinbao.util.verify.VerifyQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.server.InactiveGroupException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghehe on 2019年01月05日
 * 认证信息业务实现类
 */
@Service
public class VerifyServiceImpl implements IVerifyService {
    @Autowired
    private IVerifyMapper verifyMapper;


    @Override
    public Map<String, Object> getUserInfo(VerifyQuery info) {


        //获取待审核的实名认证表
        List<Map<String, Object>> verifyList = verifyMapper.getAuthentication(info);

        //获取页码
        Integer total = verifyMapper.geTotal(info);


        Map<String,Object> map = new HashMap<>();
        map.put("data", verifyList);
        map.put("total", total);
        return map;

    }
}
