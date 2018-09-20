package com.enshub.personal.demo.spring_batch.csv;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * Created by szty on 2018/9/20.
 */
public class CsvJobListener implements JobExecutionListener {
    long startTime;
    long endTime;

    //监听器实现JobExecutionListener接口，并重写其beforeJob、afterJob方法即可。
    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        System.out.println("任务处理开始");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        endTime = System.currentTimeMillis();
        System.out.println("任务处理结束");
        System.out.println("耗时:" + (endTime - startTime) + "ms");
    }
}