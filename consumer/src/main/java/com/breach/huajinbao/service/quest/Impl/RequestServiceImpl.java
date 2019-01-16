package com.breach.huajinbao.service.quest.Impl;

import com.breach.common.entity.ConsumerQuestionnaire;
import com.breach.common.mapper.IConsumerQuestionnaireMapper;
import com.breach.huajinbao.service.quest.IRequestService;
import com.breach.huajinbao.util.global.GlobalConsumerUtil;
import com.breach.huajinbao.util.quest.test;
import com.breach.huajinbao.util.sign.ConsumerSessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class RequestServiceImpl implements IRequestService {

    @Autowired
    private IConsumerQuestionnaireMapper consumerQuestionnaireMapper;

    @Override
    public Map quest1(ConsumerQuestionnaire q) {
        if(GlobalConsumerUtil.isLogin()) {
            q.setConsumerId(ConsumerSessionUtil.getConsumer().getConsumerId());
            q.setType(test.test1());
        consumerQuestionnaireMapper.insert(q);
        }else {
            HashMap map = new HashMap();
            map.put("cuowu", 200);
            return map;

        }
            return null;
    }


}
