package com.breach.huajinbao.service.bid.impl;

import com.breach.common.entity.UserBorrowBidApplyRecord;
import com.breach.common.mapper.IUserBorrowBidApplyRecordMapper;
import com.breach.huajinbao.mapper.bid.IBidMapper;
import com.breach.huajinbao.service.bid.IBidService;
import com.breach.huajinbao.util.global.SerialUtil;
import com.breach.huajinbao.util.global.TimeUtil;
import com.breach.huajinbao.util.sign.ConsumerSessionUtil;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.codehaus.groovy.antlr.UnicodeEscapingReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-17 11:16
 **/
@Service
public class BidServiceImpl implements IBidService {

    @Autowired
    IBidMapper bidMapper;

    @Autowired
    IUserBorrowBidApplyRecordMapper userBorrowBidApplyRecordMapper;

    /**
     * 标的申请
     * 招标的申请
     * 申请招标
     * 把标的申请记录，申请资料提交保存
     * @param userBorrowBidApplyRecord
     * @return
     */
    @Override
    public ReturnUtil borrowApply(UserBorrowBidApplyRecord userBorrowBidApplyRecord) {
        userBorrowBidApplyRecord.setBorrowNumber(SerialUtil.getRecordNumber());
        userBorrowBidApplyRecord.setUserId(ConsumerSessionUtil.getConsumer().getConsumerId());
        userBorrowBidApplyRecord.setCreateTime(TimeUtil.getSqlTimeStamp());
        System.out.println(userBorrowBidApplyRecord);
        userBorrowBidApplyRecordMapper.insert(userBorrowBidApplyRecord);
        return null;
    }
}
