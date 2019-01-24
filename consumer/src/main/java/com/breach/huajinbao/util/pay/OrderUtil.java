package com.breach.huajinbao.util.pay;

import org.apache.commons.lang.text.StrBuilder;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-24 10:18
 **/
@SuppressWarnings(value = "all")
public class OrderUtil {

    /**
     * 20190124000000000100000000010088888
     * @param alipayBean
     * @return
     */
    public synchronized static String getOrderNumberOfAlipay(AlipayBean alipayBean) {
        Integer consumerID = alipayBean.getConsumerID();
        Integer accountID = alipayBean.getAccountID();

        StrBuilder order = new StrBuilder();
        order.append(getDate());
        order.append(processConsumerID(consumerID));
        order.append(processAccountID(accountID));
        order.append(getTimeStamp());
        return order.toString();
    }

    public static String processAccountID(Object accountID) {
        String accountId = accountID.toString();
        switch (accountId.length()) {
            case 1:
                return "000000000" + accountId;
            case 2:
                return "00000000" + accountId;
            case 3:
                return "0000000" + accountId;
            case 4:
                return "000000" + accountId;
            case 5:
                return "00000" + accountId;
            case 6:
                return "0000" + accountId;
            case 7:
                return "000" + accountId;
            case 8:
                return "00" + accountId;
            case 9:
                return "0" + accountId;
            case 10:
                return "" + accountId;
        }
        return null;
    }

    public static String processConsumerID(Object consumerID) {
        String consumerId = consumerID.toString();
        switch (consumerId.length()) {
            case 1:
                return "000000000" + consumerId;
            case 2:
                return "00000000" + consumerId;
            case 3:
                return "0000000" + consumerId;
            case 4:
                return "000000" + consumerId;
            case 5:
                return "00000" + consumerId;
            case 6:
                return "0000" + consumerId;
            case 7:
                return "000" + consumerId;
            case 8:
                return "00" + consumerId;
            case 9:
                return "0" + consumerId;
            case 10:
                return "" + consumerId;
        }
        return null;
    }


    /**
     * 获取订单编号，提交编号，单子编号
     * 20190112204746
     *
     * @return
     */
    public synchronized static String getRecordNumber() {
        StringBuilder sbOrderBatch = new StringBuilder();

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); // 设置日期格式
        String date = df.format(new Date()); // new Date()为获取当前系统时间，也可使用当前时间戳

        sbOrderBatch.append(date);
        sbOrderBatch.append(getUUID().substring(1, 5));

        return sbOrderBatch.toString();
    }

    /**
     * 20190112 8345
     * 适合批次
     *
     * @return
     */
    public static String getDateTime() {
        StringBuilder sbOrderBatch = new StringBuilder();
        long time = new Date().getTime();

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd"); // 设置日期格式
        String date = df.format(new Date()); // new Date()为获取当前系统时间，也可使用当前时间戳

        String s = String.valueOf(time);
        String substring = s.substring(s.length() - 4, s.length());

        sbOrderBatch.append(date);
        sbOrderBatch.append(substring);

        return sbOrderBatch.toString();
    }

    public static String getTimeStamp() {
        String time = new Date().getTime() + "";
        return "000" + time.substring(time.length() - 5, time.length());
    }

    /**
     * 获取当前年月日
     * @return
     */
    public static String getDate() {
        StringBuilder date = new StringBuilder();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        date.append(df.format(new Date()));
        return date.toString();
    }

    /**
     * 1e755d53054d4d69808a195b9c7019b2
     *
     * @return
     */
    public static String getUUID() {
        Date date = new Date();
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }

    /**
     * 15472741730230b86411fe07e47a5be951d0492e0adb8
     *
     * @return
     */
    public static String getMSUUIDUtil() {
        Date date = new Date();
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return String.valueOf(date.getTime()) + uuid;
    }
}
