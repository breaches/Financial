package com.breach.huajinbao.mapper.quest;

import com.breach.common.entity.ConsumerQuestionnaire;
import com.breach.common.entity.Questionnaire;
import org.springframework.stereotype.Component;


@Component
public interface QuestMapper {
    void Quest(ConsumerQuestionnaire q);
}
