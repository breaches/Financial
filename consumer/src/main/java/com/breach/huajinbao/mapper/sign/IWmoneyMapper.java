package com.breach.huajinbao.mapper.sign;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Map;

@Repository
public interface IWmoneyMapper {


   BigDecimal wi(Integer id);

   Map<String,Object> blMoney(int id);

   //减钱操作


      //提现费加到公司账户
   void notarize(BigDecimal money);

   int getId(int id);

   void notarizes(@Param("blmoney") BigDecimal blmoney, @Param("id") int id);

}
