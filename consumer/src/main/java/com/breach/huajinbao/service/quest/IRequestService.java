package com.breach.huajinbao.service.quest;

import com.breach.common.entity.Questionnaire;
import org.springframework.stereotype.Component;

@Component
public interface IRequestService {

     void quest(Questionnaire q);
}
