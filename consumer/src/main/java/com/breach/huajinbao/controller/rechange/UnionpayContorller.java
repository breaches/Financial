package com.breach.huajinbao.controller.rechange;


import com.breach.huajinbao.service.rechange.IPayService;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UnionpayContorller {

    @Autowired
    private IPayService pay;

    @RequestMapping("/pass")
    public ReturnUtil pass( Integer password){
        return pay.pass(password);
    }

    @RequestMapping("/recharge")
    public ReturnUtil recharge(Integer money){
        return pay.recharge(money);
    }
}
