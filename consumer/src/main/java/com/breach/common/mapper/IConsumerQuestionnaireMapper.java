package com.breach.common.mapper;

import com.breach.common.entity.ConsumerQuestionnaire;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author shaokang
 * @since 2019-01-15
 */
@Mapper
@Component
public interface IConsumerQuestionnaireMapper extends BaseMapper<ConsumerQuestionnaire> {
}
