package com.breach.huajinbao.util.sign;

import com.breach.common.entity.ConsumerAccount;
import com.breach.common.entity.ConsumerInfo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-23 13:15
 **/
public class SignInUtil {

    public static String getConvertMoneyToString(Object money) {
        BigDecimal bigDecimal = ((BigDecimal) money).setScale(2, BigDecimal.ROUND_HALF_UP);
        return bigDecimal.toString();
    }

    public static BigDecimal getConvertMoney(Object money) {
        return ((BigDecimal) money).setScale(2, BigDecimal.ROUND_HALF_UP);
    }


    public static Map processSignInInfo(Object consumerInfo, Object consumerAccount) {
        ConsumerInfo info = (ConsumerInfo) consumerInfo;
        ConsumerAccount account = (ConsumerAccount) consumerAccount;
        System.out.println(info);
        System.out.println(account);
        Map data = new HashMap();
        data.put("info", info);

        if(account.getAvailableBalance() != null) {
            account.setAvailableBalance(
                    getConvertMoney(account.getAvailableBalance())
            );
        }
        if(account.getCreditBalance() != null) {
            account.setCreditBalance(
                    getConvertMoney(account.getCreditBalance())
            );
        }
        if(account.getCreditAmount() != null) {
            account.setCreditBalance(
                    getConvertMoney(account.getCreditBalance())
            );
        }
        if(account.getFrozenCapital() != null) {
            account.setFrozenCapital(
                    getConvertMoney(account.getFrozenCapital())
            );
        }
        if(account.getPrincipalIncome() != null) {
            account.setPrincipalIncome(
                    getConvertMoney(account.getPrincipalMoney())
            );
        }
        if(account.getPrincipalMoney() != null) {
            account.setPrincipalMoney(
                    getConvertMoney(account.getPrincipalMoney())
            );
        }

        data.put("account", account);
        return data;
    }
}
