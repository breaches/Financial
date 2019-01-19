package com.breach.huajinbao.service.bid;

import com.breach.common.entity.UserBorrowBidApplyRecord;
import com.breach.huajinbao.util.sign.ReturnUtil;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-17 11:15
 **/
public interface IBidService {
    ReturnUtil borrowApply(UserBorrowBidApplyRecord userBorrowBidApplyRecord);

    ReturnUtil getRepayType();

}
