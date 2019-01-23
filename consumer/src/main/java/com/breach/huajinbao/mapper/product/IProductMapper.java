package com.breach.huajinbao.mapper.product;

import com.breach.huajinbao.util.product.QueryProduct;
import com.breach.huajinbao.util.product.TradingInfo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-19 14:31
 **/
public interface IProductMapper {

    List<Map<String, Object>> disperseBid(QueryProduct queryProduct);

    Integer disperseBidTotal(QueryProduct queryProduct);

    Map<String, Object> personBidDetail(@Param("productID") String productID);

    Map<String, Object> getBorrowerInfo(@Param("borrowNumber") String borrowNumber, @Param("consumerID") String consumerID);

    /**
     * 扣除账户的金额，购买标后的金额
     * @param consumerId
     * @param scale
     * @param setScale
     * @param version
     * @return
     */
    Integer tradingAccount(
            @Param("accountID") Integer consumerId,
            @Param("frozenCapital") BigDecimal scale,
            @Param("availableBalance") BigDecimal setScale,
            @Param("version") Integer version
    );

    /**
     * 扣除/修改/更新标的剩余可投金额
     * @param id
     * @param borrowConsumerID
     * @param borrowNumber
     * @param setScale
     * @param version
     * @return
     */
    Integer tradingBid(
            @Param("borrowID") Integer id,
            @Param("borrowConsumerID") Integer borrowConsumerID,
            @Param("borrowNumber") String borrowNumber,
            @Param("bidSurplusAmount") BigDecimal setScale,
            @Param("version") Integer version
    );

    /**
     * 插入购买记录
     * @param consumerId
     * @param borrowNumber
     * @param id
     * @param scale
     * @param setScale
     * @param clientIP
     * @param sqlTimeStamp
     * @return
     */
    Integer tradingRecord(
            @Param("consumerID") Integer consumerId,
            @Param("borrowNumber") String borrowNumber,
            @Param("borrowID") Integer id,
            @Param("tradingAmount") BigDecimal scale,
            @Param("surplusAmount") BigDecimal setScale,
            @Param("clientIP") String clientIP,
            @Param("createTime") LocalDateTime sqlTimeStamp
    );

    /**
     * 满足满标条件，更新状态为已满标
     *
     * @param id
     * @param userId
     * @param borrowNumber
     * @param sqlTimeStamp
     * @param b
     * @return
     */
    Integer fullBid(
            @Param("borrowID") Integer id,
            @Param("borrowConsumerID") Integer userId,
            @Param("borrowNumber") String borrowNumber,
            @Param("fullTime") LocalDateTime sqlTimeStamp,
            @Param("isFull") boolean b
    );

    /**
     * 获取投标记录
     * @param tradingInfo
     * @return
     */
    List<Map<String, Object>> getTradingRecord(TradingInfo tradingInfo);

    /**
     * 获取投标记录的总数
     * @param tradingInfo
     * @return
     */
    Integer getTotalTradingRecord(TradingInfo tradingInfo);

    Map getAccount(@Param("consumerID") Integer consumerId);
}
