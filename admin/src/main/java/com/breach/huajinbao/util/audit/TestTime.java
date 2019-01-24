package com.breach.huajinbao.util.audit;

import java.util.Date;

/**
 *
 * 测试
 * Created by wanghehe on 2019年01月21日
 */
public class TestTime {

    public static void main(String[] args) {

        System.out.println("开始时间" + new Date());
        // LocalDateTime localDateTime = TimeUtil.addSqlTimeStampByDays(TimeUtil.getSqlTimeStamp(), 0);
        //System.out.println("结束时间"+localDateTime.toLocalDate());

        String timesmorning = TimeUtil.getTimesmorning();

        System.out.println(timesmorning);

    }

}
