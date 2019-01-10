package com.breach.huajinbao.service.audit.impl;

import com.breach.huajinbao.mapper.audit.IAuditMapper;
import com.breach.huajinbao.service.audit.IAuditService;
import com.breach.huajinbao.util.audit.AuditQuery;
import com.breach.huajinbao.util.audit.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wanghehe on 2019年01月05日
 * 审核业务实现类
 *
 */
@Service
public class AuditServiceImpl implements IAuditService {
    @Autowired
    private IAuditMapper auditMapper;

    /*/**
     * @Description:获取待审核的 招标订单的信息 （分页+查询）
     * @Param:  * @param audit 
     * @return: java.util.Map<java.lang.String,java.lang.Object> 
     * @Author: wanghe
     * @Date: 2019/1/5 12:07
     */ 
    @Override
    public Map<String,Object> auditTenderee(AuditQuery audit) {
        //获取待审核的订单表
        List<Map<String, Object>> auditList = auditMapper.getauditTenderee(audit);
         //System.out.println(auditList.toString());
        //获取页码
        Integer total = auditMapper.getAuditTotal(audit);


        Map<String,Object> map = new HashMap<>();
        map.put("auditdata", auditList);
        map.put("audittotal", total);
        return map;
    }
    /**
     * @Description:  招标初审订单信息详情,
     * @Param:  * @param
     * @return:
     * @Author: wanghe
     * @Date: 2019/1/5 21:02
     */
    @Override
    public Map<String, Object> getAudit() {
        //获取用户的身份认证的信息
        // Map<String,Object>  userList= auditMapper.ge
        return null;
    }
}
