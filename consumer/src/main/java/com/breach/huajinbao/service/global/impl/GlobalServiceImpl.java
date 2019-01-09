package com.breach.huajinbao.service.global.impl;

import com.breach.common.entity.ConsumerAuths;
import com.breach.common.mapper.IConsumerAuthsMapper;
import com.breach.huajinbao.service.global.IGlobalService;
import com.breach.huajinbao.util.global.GlobalData;
import com.breach.huajinbao.util.global.JsonUtil;
import com.breach.huajinbao.util.sign.ConsumerSessionUtil;
import jdk.nashorn.internal.objects.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-08 13:08
 **/
@Service
public class GlobalServiceImpl implements IGlobalService {

    @Autowired
    IConsumerAuthsMapper consumerAuthsMapper;

    @Override
    public GlobalData getUserInfoAfterLogin() {
        ConsumerAuths consumer = ConsumerSessionUtil.getConsumer();

        if(consumer != null) {
            List data = new ArrayList();
            Map map = new HashMap();
            map.put("id", consumer.getId());
            map.put("username", consumer.getUsername());
            data.add(map);
            return new GlobalData(data);
        }
        return null;
    }
}
