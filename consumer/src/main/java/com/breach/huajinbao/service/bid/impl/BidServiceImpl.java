package com.breach.huajinbao.service.bid.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.breach.common.entity.ConsumerAccount;
import com.breach.common.entity.ConsumerInfo;
import com.breach.common.entity.ConsumerRepaymentType;
import com.breach.common.entity.UserBorrowBidApplyRecord;
import com.breach.common.mapper.IConsumerAccountMapper;
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

import java.math.BigDecimal;
import java.util.List;

import static com.breach.huajinbao.sysconst.ISystemConsts.CONSUMER_INFO_VERIFY_STATE_NEVER;

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

    @Autowired
    IConsumerAccountMapper consumerAccountMapper;

    /**
     * 标的申请
     * 招标的申请
     * 申请招标
     * 把标的申请记录，申请资料提交保存
     *
     * @param userBorrowBidApplyRecord
     * @return
     */
    @Override
    public ReturnUtil borrowApply(UserBorrowBidApplyRecord userBorrowBidApplyRecord) {

        if (GlobalConsumerUtil.isLogin()) {
            ConsumerInfo consumerInfo = consumerInfoMapper.selectOne(
                    new QueryWrapper<>(
                            new ConsumerInfo().setId(
                                    ConsumerSessionUtil.getConsumer()
                                            .getConsumerId()
                            )
                    )
            );
            System.out.println(consumerInfo);

            switch (consumerInfo.getVerifyState()) {
                case ISystemConsts.CONSUMER_INFO_VERIFY_STATE_NEVER:
                    // 用户从未申请额度
                    return new ReturnUtil(ISystemConsts.BORROW_BID_APPLY_RECORD_CREDIT_NEVER, "请您先申请额度再来发起招标");
                case ISystemConsts.CONSUMER_INFO_VERIFY_STATE_WAIT:
                    // 用户已申请额度，但是还未被处理
                    return new ReturnUtil(ISystemConsts.BORROW_BID_APPLY_RECORD_CREDIT_PROCESS, "您的额度申请正在处理，请稍后再来");
                case ISystemConsts.CONSUMER_INFO_VERIFY_STATE_NO_PASS:
                    // 用户申请额度未通过
                    return new ReturnUtil(ISystemConsts.BORROW_BID_APPLY_RECORD_CREDIT_FAILURE, "抱歉，由于您近期的额度申请未通过，此账户暂时不支持发起招标");
                case ISystemConsts.CONSUMER_INFO_VERIFY_STATE_PASS:
                    // 用户申请额度已通过

                    userBorrowBidApplyRecord.setBorrowNumber(SerialUtil.getRecordNumber()); // 设置单号
                    userBorrowBidApplyRecord.setUserId(ConsumerSessionUtil.getConsumer().getConsumerId()); // 设置用户id
                    userBorrowBidApplyRecord.setName(consumerInfo.getName()); // 设置用户姓名
                    userBorrowBidApplyRecord.setCreateTime(TimeUtil.getSqlTimeStamp()); // 设置当时创建的时间
                    userBorrowBidApplyRecord.setSurplusAmount(userBorrowBidApplyRecord.getBorrowMoney());
                    System.out.println(userBorrowBidApplyRecord);
                    userBorrowBidApplyRecordMapper.insert(userBorrowBidApplyRecord);

                    if (userBorrowBidApplyRecord.getId() > 0) {
                        // 插入成功，开始扣钱/扣信用

                        ConsumerAccount queryConsumerAccount = new ConsumerAccount();
                        queryConsumerAccount.setId(consumerInfo.getAccountId());
                        ConsumerAccount consumerAccount = consumerAccountMapper.selectOne(new QueryWrapper<>(queryConsumerAccount));// 查询用户的账户信息
                        System.out.println(consumerAccount);

                        System.out.println(consumerAccount.getCreditBalance());
                        System.out.println(userBorrowBidApplyRecord.getBorrowMoney());

                        if (consumerAccount.getCreditBalance().compareTo(userBorrowBidApplyRecord.getBorrowMoney()) > 0) {
                            // 如果这个人的信用余额足够，可用信用额度比招标的钱多

                            // 扣除可用信用余额
                            consumerAccount.setCreditBalance(
                                    consumerAccount.getCreditBalance()
                                            .subtract(userBorrowBidApplyRecord.getBorrowMoney())
                            );
                            int i = consumerAccountMapper.updateById(consumerAccount);
                            System.out.println(i);
                            return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, "提交招标预审，并扣除信用额度成功");
                        }
                        // 信用额度不足
                        return new ReturnUtil(ISystemConsts.BORROW_BID_APPLY_RECORD_LACK_OF_CREDIT, "抱歉，您的信用额度不足");
                    }
                    return new ReturnUtil(ISystemConsts.BORROW_BID_APPLY_RECORD_ERROR, "抱歉，您的招标预审资料提交失败");
            }


        }
        return new ReturnUtil(ISystemConsts.AJAX_IS_NOT_LOGIN, "抱歉，请登录后再进行操作");
    }

    /**
     * 获取数据库中的偿还方式
     *
     * @return
     */
    @Override
    public ReturnUtil getRepayType() {
        List<ConsumerRepaymentType> consumerRepaymentTypes = consumerRepaymentTypeMapper.selectList(null);
        return new ReturnUtil(consumerRepaymentTypes);
    }
}
