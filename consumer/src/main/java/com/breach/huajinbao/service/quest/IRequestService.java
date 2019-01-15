package com.breach.huajinbao.service.quest;

import com.breach.common.entity.Questionnaire;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface IRequestService {

     void quest(Questionnaire q);

     List<Map<String, Object>> qqq();

}
