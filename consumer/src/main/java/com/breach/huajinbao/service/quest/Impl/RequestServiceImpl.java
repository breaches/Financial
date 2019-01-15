package com.breach.huajinbao.service.quest.Impl;

import com.breach.common.entity.Questionnaire;
import com.breach.huajinbao.mapper.quest.QuestMapper;
import com.breach.huajinbao.service.quest.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RequestServiceImpl implements IRequestService {

    @Autowired
    private QuestMapper mapper;

    @Override
    public void quest(Questionnaire q) {
        System.out.println("q -> " + q);
        mapper.Quest(q);
    }

    @Override
    public List<Map<String, Object>> qqq() {

        return mapper.qqq();
    }


}
