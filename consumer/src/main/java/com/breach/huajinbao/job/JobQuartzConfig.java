package com.breach.huajinbao.job;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-16 13:13
 **/
@Configuration
public class JobQuartzConfig {
    @Bean
    public JobDetail testQuartzDetail() {
        return JobBuilder.newJob(JobQuartz.class)
                .withIdentity("test - job") // 当前任务叫什么名字
                .storeDurably()
                .requestRecovery(true)
                .build();
    }

    @Bean
    public Trigger testQuartzTrigger() {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("name", "admin");

        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(2)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(testQuartzDetail())
                .withIdentity("testQuartz")
                .withSchedule(simpleScheduleBuilder)
                .usingJobData(jobDataMap)
                .build();
    }
}
