package com.breach.huajinbao.controller.sign;



import com.breach.huajinbao.service.sign.IWmoney;
import com.breach.huajinbao.util.sign.Result;
import com.breach.huajinbao.util.sign.Withdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 提现
 */
@RestController
@RequestMapping("/bl")
public class WithdrawController {
    @Autowired
    private IWmoney moneyService;
    /*
    获取当前登录者的可提现金额
     */
    @RequestMapping("/getMoney")
    public Map<String,Object> wi() {
        return moneyService.wi();
    }

    /*
        获取当前登录者的所有提现信息，包括姓名，银行卡号，提现手续费，提现最终到账金额
       */
    @RequestMapping("/blMoney")
    public Map<String,Object> blMoney(BigDecimal money) {

        return moneyService.blMoney(money);
    }
    /*
   提现到账，把手续费加到公司余额上
     */
    @RequestMapping("/notarize")
    public Result notarize(@RequestBody Withdraw w) {

        return moneyService.notarize(w);
    }
}
