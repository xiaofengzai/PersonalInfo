package com.enshub.personal.demo.spring_batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * Created by szty on 2018/9/20.
 */
public class MyJobListener implements JobExecutionListener {
    @Override
    public void beforeJob(JobExecution jobExecution) {
        //Job开始前
    }
    @Override
    public void afterJob(JobExecution jobExecution) {
        //Job完成后
    }
}
