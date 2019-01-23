package com.breach.huajinbao.service.product.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.breach.common.entity.ConsumerAccount;
import com.breach.common.entity.ConsumerInfo;
import com.breach.common.entity.UserBorrowBidApplyRecord;
import com.breach.common.entity.UserBorrowTransactionRecord;
import com.breach.common.mapper.IConsumerAccountMapper;
import com.breach.common.mapper.IConsumerInfoMapper;
import com.breach.common.mapper.IUserBorrowBidApplyRecordMapper;
import com.breach.common.mapper.IUserBorrowTransactionRecordMapper;
import com.breach.huajinbao.mapper.product.IProductMapper;
import com.breach.huajinbao.service.product.IProductService;
import com.breach.huajinbao.sysconst.ISystemConsts;
import com.breach.huajinbao.util.global.GlobalConsumerUtil;
import com.breach.huajinbao.util.global.IPAddressUtil;
import com.breach.huajinbao.util.global.TimeUtil;
import com.breach.huajinbao.util.product.ProductUtil;
import com.breach.huajinbao.util.product.QueryProduct;
import com.breach.huajinbao.util.product.TradingInfo;
import com.breach.huajinbao.util.sign.ConsumerSessionUtil;
import com.breach.huajinbao.util.sign.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.Produces;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-19 14:30
 **/
@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductMapper productMapper;
    @Autowired
    IUserBorrowBidApplyRecordMapper userBorrowBidApplyRecordMapper;
    @Autowired
    IConsumerAccountMapper consumerAccountMapper;
    @Autowired
    IConsumerInfoMapper consumerInfoMapper;
    @Autowired
    IUserBorrowTransactionRecordMapper userBorrowTransactionRecordMapper;


    /**
     * 散标列表页面加载后请求散标的数据
     *
     * @param queryProduct
     * @return
     */
    @Override
    public ReturnUtil disperseBid(QueryProduct queryProduct) {

        List<Map<String, Object>> result = productMapper.disperseBid(queryProduct);
        Integer integer = productMapper.disperseBidTotal(queryProduct);

        return new ReturnUtil(ISystemConsts.AJAX_SUCCESS, result, integer);
    }

    /**
     * 散标的详情数据页面的请求
     *
     * @param productID
     * @return
     */
    @Override
    public ReturnUtil personBidDetail(String productID) {
        Map<String, Object> data = productMapper.personBidDetail(productID);
        // 判空
        if (data == null) {
            return new ReturnUtil(
                    ISystemConsts.PRODUCT_LOAN_PERSON_BID_DETAIL_IS_NOT_EXIST,
                    "对不起，标不存在。"
            );
        } else {
            return new ReturnUtil(
                    ISystemConsts.PRODUCT_LOAN_PERSON_BID_DETAIL_SUCCESS,
                    ProductUtil.getData(data)
            );
        }

    }

    /**
     * 获取借款人信息
     *
     * @param borrowNumber
     * @param consumerID
     * @return
     */
    @Override
    public ReturnUtil getBorrowerInfo(String borrowNumber, String consumerID) {
        // 获取基础信息
        Map<String, Object> data = productMapper.getBorrowerInfo(borrowNumber, consumerID);
        System.out.println(data);

        return new ReturnUtil(
                ISystemConsts.PRODUCT_LOAN_PERSON_BID_DETAIL_GET_BORROWER_INFO_SUCCESS,
                ProductUtil.getBorrowerInfo(data)
        );
    }

    /**
     * 投标
     *
     * @param tradingInfo
     * @return
     */
    @Override
    public ReturnUtil trading(TradingInfo tradingInfo) {
        if (GlobalConsumerUtil.isLogin()) {
            Integer consumerId = ConsumerSessionUtil.getConsumer().getConsumerId();
            // 拿到单子编号，用户id，判断自己的余额是否足够，再判断该标的可买金额是否包含用户的购买金额，如果成立则判断该标的版本是否一致，一致则购买

            // 查询单子/标的信息
            UserBorrowBidApplyRecord queryUserBorrowBidApplyRecord = new UserBorrowBidApplyRecord();
            queryUserBorrowBidApplyRecord.setBorrowNumber(tradingInfo.getBorrowNumber());
            UserBorrowBidApplyRecord userBorrowBidApplyRecord = userBorrowBidApplyRecordMapper.selectOne(new QueryWrapper<>(queryUserBorrowBidApplyRecord));

            // 查询用户信息 得到账户表的id
            ConsumerInfo queryConsumerInfo = new ConsumerInfo();
            queryConsumerInfo.setId(consumerId);
            ConsumerInfo consumerInfo = consumerInfoMapper.selectOne(new QueryWrapper<>(queryConsumerInfo));

            // 查询用户的账户信息
            ConsumerAccount queryConsumerAccount = new ConsumerAccount();
            queryConsumerAccount.setId(consumerInfo.getAccountId());
            ConsumerAccount consumerAccount = consumerAccountMapper.selectOne(new QueryWrapper<>(queryConsumerAccount));
            // 得到信息后，对比可购买的金额是否大于用户购买的金额

            // 判断买标的人是不是发标的人
            if (consumerId != userBorrowBidApplyRecord.getUserId()) {
                // 如果不是购买人发的标
                if (consumerAccount.getAvailableBalance().compareTo(tradingInfo.getAmount()) >= 0) {
                    // 如果账户余额大于要购买的金额
                    if (userBorrowBidApplyRecord.getSurplusAmount().compareTo(tradingInfo.getAmount()) >= 0) {
                        // 进一步判断要购买的金额是否大于该标剩余可买金额，这里应该是  ---===可购买金额>购买金额===---
                        // 开始购买流程

                        // 先扣款 ---- 条件：发标id不能与投标id相同，标的版本要相同，
                        productMapper.tradingAccount(
                                consumerInfo.getAccountId(),
                                consumerAccount.getAvailableBalance().subtract(tradingInfo.getAmount()).setScale(2, BigDecimal.ROUND_HALF_UP),
                                consumerAccount.getVersion()
                        );

                        // 再扣标的可投金额
                        productMapper.tradingBid(
                                userBorrowBidApplyRecord.getId(),
                                userBorrowBidApplyRecord.getUserId(),
                                userBorrowBidApplyRecord.getBorrowNumber(),
                                userBorrowBidApplyRecord.getSurplusAmount().subtract(tradingInfo.getAmount()).setScale(2, BigDecimal.ROUND_HALF_UP),
                                userBorrowBidApplyRecord.getVersion()
                        );

                        // 最后插入购买记录
                        productMapper.tradingRecord(
                                consumerId,
                                userBorrowBidApplyRecord.getBorrowNumber(),
                                userBorrowBidApplyRecord.getId(),
                                tradingInfo.getAmount().setScale(2, BigDecimal.ROUND_HALF_UP),
                                userBorrowBidApplyRecord.getSurplusAmount().subtract(tradingInfo.getAmount()).setScale(2, BigDecimal.ROUND_HALF_UP),
                                IPAddressUtil.getClientIP(),
                                TimeUtil.getSqlTimeStamp()
                        );

                        // 再判断该标购买之后是否满足满标条件
                        if(userBorrowBidApplyRecord.getSurplusAmount().compareTo(tradingInfo.getAmount()) == 0) {
                            // 加入满标条件 full_tender_time满标的时间
                            productMapper.fullBid(
                                    userBorrowBidApplyRecord.getId(),
                                    userBorrowBidApplyRecord.getUserId(),
                                    userBorrowBidApplyRecord.getBorrowNumber(),
                                    TimeUtil.getSqlTimeStamp(),
                                    true
                            );
                            return new ReturnUtil(ISystemConsts.TRADING_BID_SUCCESS_AND_IS_FULL, "购买成功，该标已满");
                        }
                        return new ReturnUtil(ISystemConsts.TRADING_BID_SUCCESS, "购买成功");
                    } else {
                        // 投入金额超过可投金额，可投金额<投入金额
                        return new ReturnUtil(ISystemConsts.TRADING_BID_OUT_OF_SURPLUS_AMOUNT, "抱歉，投入金额已经超过可投金额");
                    }
                } else {
                    // 账户余额不足以购买，账户余额<输入的金额
                    return new ReturnUtil(ISystemConsts.TRADING_BID_OUT_OF_AVAILABLE_BALANCE, "抱歉，账户余额不足");
                }
            } else {
                // 买标的与招标的是同一个人
                return new ReturnUtil(ISystemConsts.TRADING_BID_IS_SAME_PEOPLE, "抱歉，您可以选择除自己招的标之外的范围");
            }
        }
        return new ReturnUtil(ISystemConsts.AJAX_IS_NOT_LOGIN, "请登录后再来操作");
    }

    /**
     * 获取投标记录
     * @param tradingInfo
     * @return
     */
    @Override
    public ReturnUtil getTradingRecord(TradingInfo tradingInfo) {
        List<Map<String, Object>> record = productMapper.getTradingRecord(tradingInfo);
        Integer totalTradingRecord = productMapper.getTotalTradingRecord(tradingInfo);
        Map tradingRecordInfo = ProductUtil.getTradingRecordInfo(record, totalTradingRecord);
        return new ReturnUtil(ISystemConsts.TRADING_BID_RECORD_GET_SUCCESS, tradingRecordInfo);
    }
}
