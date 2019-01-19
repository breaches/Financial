package com.breach.huajinbao.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @program: Financial
 * @description:
 * @author: shaokang
 * @create: 2019-01-16 13:11
 **/
@DisallowConcurrentExecution
public class JobQuartz extends QuartzJobBean {
    /**
     * 执行定时任务
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("[System] -> " + new Date());
    }
}
