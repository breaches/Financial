package com.breach.huajinbao.mapper.rechange;

import com.breach.huajinbao.util.sign.ReturnUtil;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Map;

public interface IUnionPayMapper {
    @Select("select * from consumer_security where pay_password=#{password}")
    Integer pass(Integer password);

    @Update("UPDATE consumer_account,consumer_info " +
            "set consumer_account.available_balance=available_balance+#{money} " +
            "where consumer_account.id=consumer_info.account_id AND " +
            "consumer_info.account_id in (select account_id from consumer_info where id=#{q})")
    void recharge(@Param("money") Integer money,@Param("q") Integer q);
}
