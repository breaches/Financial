package com.breach.huajinbao.util.global;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 * @program: Logistics
 * @description: 封装时间、日期、随机时间戳、等等功能
 * @author: shaokang
 * @create: 2018-11-26 11:06
 **/
public class TimeUtil {

    //获取当前时间的LocalDateTime对象
    //LocalDateTime.now();

    //根据年月日构建LocalDateTime
    //LocalDateTime.of();

    //比较日期先后
    //LocalDateTime.now().isBefore(),
    //LocalDateTime.now().isAfter(),



    //Date转换为LocalDateTime
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    //LocalDateTime转换为Date
    public static Date convertLDTToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }


    //获取指定日期的毫秒
    public static Long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    //获取指定日期的秒
    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    //获取指定时间的指定格式
    public static String formatTime(LocalDateTime time,String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    //获取当前时间的指定格式
    public static String formatNow(String pattern) {
        return  formatTime(LocalDateTime.now(), pattern);
    }

    //日期加上一个数,根据field不同加不同值,field为ChronoUnit.*
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    //日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field){
        return time.minus(number,field);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     * @param startTime
     * @param endTime
     * @param field  单位(年月日时分秒)
     * @return
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) return period.getYears();
        if (field == ChronoUnit.MONTHS) return period.getYears() * 12 + period.getMonths();
        return field.between(startTime, endTime);
    }

    //获取一天的开始时间，2017,7,22 00:00
    public static LocalDateTime getDayStart(LocalDateTime time) {
        return time.withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);
    }

    //获取一天的结束时间，2017,7,22 23:59:59.999999999
    public static LocalDateTime getDayEnd(LocalDateTime time) {
        return time.withHour(23)
                .withMinute(59)
                .withSecond(59)
                .withNano(999999999);
    }

    /** 返回当前日期时间，经常用于创建订单的日期时间，创建各种日期等 **/
    public static LocalDateTime getSqlTimeStamp() {
        return convertDateToLDT(new Date());
    }

    /** LocalDateTime 加 x 天数 **/
    public static LocalDateTime addSqlTimeStampByDays(LocalDateTime localDateTime, Integer days) {
        return localDateTime.plus(Duration.ofDays(days));
    }

    /** 返回当前日期事件，经常用于创建订单的日期时间，创建各种日期等 **/
    /*public static java.sql.Timestamp getSqlTimeStamp() {
        return new java.sql.Timestamp(new Date().getTime());
    }*/

    /** 返回时间戳 **/
    public static long getTime() {
        return new Date().getTime();
    }

    /** 返回 4 位随机数 **/
    public static String getFourRandom() {
        String time = String.valueOf(TimeUtil.getTime());
        time = time.substring(time.length() - 4, time.length());
        return time;
    }

}