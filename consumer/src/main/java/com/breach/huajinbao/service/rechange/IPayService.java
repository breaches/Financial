package com.breach.huajinbao.service.rechange;


import com.breach.huajinbao.util.sign.ReturnUtil;

public interface IPayService {
    ReturnUtil pass(Integer password);

    ReturnUtil recharge(Integer money);
}
