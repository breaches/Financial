package com.breach.huajinbao.mapper.verify;

import com.breach.common.entity.ConsumerIncomeRange;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-10 19:27
 **/
public interface IVerifyMapper {
    @Select("select * from consumer_income_range")
    List<ConsumerIncomeRange> listAllIncome();
}
