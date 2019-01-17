package com.breach.huajinbao.service.topup.Impl;

import com.breach.huajinbao.mapper.topup.ITopUpMapper;
import com.breach.huajinbao.service.topup.ITopUpSerivice;
import com.breach.huajinbao.util.topup.MakeOrderNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wanghehe on 2019年01月11日
 */
@Service
public class TopUpSeriviceImpl  implements ITopUpSerivice {

    @Autowired
    private  ITopUpMapper topUpMapper;


    @Override
    public String orderNumber() {

        return  MakeOrderNum.makeOrderNum();

    }

}


