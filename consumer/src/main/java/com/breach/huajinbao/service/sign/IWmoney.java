package com.breach.huajinbao.service.sign;

import com.breach.huajinbao.util.sign.Result;
import com.breach.huajinbao.util.sign.Withdraw;

import java.math.BigDecimal;
import java.util.Map;

public interface IWmoney {
    Map<String,Object> wi();

    Map<String,Object> blMoney(BigDecimal money);

    Result notarize(Withdraw w);
}
