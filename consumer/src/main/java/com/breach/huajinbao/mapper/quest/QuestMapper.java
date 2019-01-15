package com.breach.huajinbao.mapper.quest;

import com.breach.common.entity.Questionnaire;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


@Component
public interface QuestMapper {
    void Quest(Questionnaire q);

    List<Map<String, Object>> qqq();
}
