package com.breach.huajinbao.util.global;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-12 14:17
 **/
public class SerialUtil {

    /**
     * eg:<br><br/>
     * 2019011229822bb55edf0d9d4b1ab8d48982835d9409
     * @return
     */
    public static String getDateTimeUUID() {
        return getDateTime() + getUUID();
    }

    /**
     * 获取订单编号，提交编号，单子编号
     * 20190112204746
     * @return
     */
    public synchronized static String getRecordNumber() {
        StringBuilder sbOrderBatch = new StringBuilder();

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss"); // 设置日期格式
        String date = df.format(new Date()); // new Date()为获取当前系统时间，也可使用当前时间戳

        sbOrderBatch.append(date);
        sbOrderBatch.append(getUUID().substring(1,5));

        return sbOrderBatch.toString();
    }


    /**
     * 20190112 8345
     * 适合批次
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

    /**
     * 1e755d53054d4d69808a195b9c7019b2
     * @return
     */
    public static String getUUID() {
        Date date = new Date();
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return uuid;
    }

    /**
     * 15472741730230b86411fe07e47a5be951d0492e0adb8
     * @return
     */
    public static String getMSUUIDUtil() {
        Date date = new Date();
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return String.valueOf(date.getTime()) + uuid;
    }

}
