package com.breach.huajinbao.service.zfq;

import com.breach.huajinbao.util.zfq.PrizeQuery;

import java.util.Map;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-02-27 21:06
 **/
public interface IPrizeService {
    Map fullScale(PrizeQuery p);

    Map recheck(PrizeQuery p);

    Map failure(PrizeQuery p);

    Map Invitation(PrizeQuery p);
}
