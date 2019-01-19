package com.breach.huajinbao.service.bid.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.breach.common.entity.ConsumerInfo;
import com.breach.common.entity.ConsumerRepaymentType;
import com.breach.common.entity.UserBorrowBidApplyRecord;
import com.breach.common.mapper.IConsumerInfoMapper;
import com.breach.common.mapper.IConsumerRepaymentTypeMapper;
import com.breach.common.mapper.IUserBorrowBidApplyRecordMapper;
import com.breach.huajinbao.mapper.bid.IBidMapper;
import com.breach.huajinbao.service.bid.IBidService;
import com.breach.huajinbao.sysconst.ISystemConsts;
import com.breach.huajinbao.util.global.GlobalConsumerUtil;
import com.breach.huajinbao.util.global.SerialUtil;
import com.breach.huajinbao.util.global.TimeUtil;
import com.breach.huajinbao.util.sign.ConsumerSessionUtil;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    IConsumerInfoMapper consumerInfoMapper;

    @Autowired
    IConsumerRepaymentTypeMapper consumerRepaymentTypeMapper;

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

        if(GlobalConsumerUtil.isLogin()) {
            ConsumerInfo consumerInfo = consumerInfoMapper.selectOne(
                    new QueryWrapper<>(
                            new ConsumerInfo().setId(
                                    ConsumerSessionUtil.getConsumer()
                                            .getConsumerId()
                            )
                    )
            );

            System.out.println(consumerInfo);

            userBorrowBidApplyRecord.setBorrowNumber(SerialUtil.getRecordNumber());
            userBorrowBidApplyRecord.setUserId(ConsumerSessionUtil.getConsumer().getConsumerId());
            userBorrowBidApplyRecord.setName(consumerInfo.getName());
            userBorrowBidApplyRecord.setCreateTime(TimeUtil.getSqlTimeStamp());
            System.out.println(userBorrowBidApplyRecord);
            userBorrowBidApplyRecordMapper.insert(userBorrowBidApplyRecord);
            return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, "success");
        }
        return new ReturnUtil(ISystemConsts.AJAX_IS_NOT_LOGIN, "error");
    }

    /**
     * 获取数据库中的偿还方式
     * @return
     */
    @Override
    public ReturnUtil getRepayType() {
        List<ConsumerRepaymentType> consumerRepaymentTypes = consumerRepaymentTypeMapper.selectList(null);
        return new ReturnUtil(consumerRepaymentTypes);
    }
}
