//package com.enshub.personal.demo.spring_batch;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.tasklet.Tasklet;
//import org.springframework.batch.core.step.tasklet.TaskletStep;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.ParseException;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.mapping.DefaultLineMapper;
//import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.SimpleAsyncTaskExecutor;
//import org.springframework.transaction.PlatformTransactionManager;
//
///**
// * Created by szty on 2018/9/19.
// */
//@Configuration
//@EnableBatchProcessing
//@Slf4j
//public class BatchTaskConfiguration {
//    @Bean
//    DefaultLineMapper lineMapper(){
//        DefaultLineMapper lineMapper=new DefaultLineMapper();
//        lineMapper.setLineTokenizer(new DelimitedLineTokenizer());
//        lineMapper.setFieldSetMapper(new PersonMapper());
//        return lineMapper;
//    }
//
//    @Bean
//    ItemReader messageReader(){
//        ItemReader itemReader=new FlatFileItemReader();
//        return itemReader;
//    }
//
//    @Bean
//    TaskletStep messageStep(){
//        TaskletStep step=new TaskletStep();
//        return step;
//    }
//
//    @Bean
//    public Job importFileJob(JobBuilderFactory jobs, Step step1, JobExecutionListener listener, JobRepository jobRepository) {
//        return jobs.get("importFileJob")
//                .incrementer(new RunIdIncrementer())
//                .repository(jobRepository)
//                .listener(listener)
//                .flow(step1)
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step step1(StepBuilderFactory stepBuilderFactory, ItemReader<Person> reader,
//                      ItemWriter<Person> writer, ItemProcessor<Person, Person> processor, PlatformTransactionManager transactionManager) {
//        log.error("step1");
//        return stepBuilderFactory.get("step1")
//                .<Person, Person> chunk(500)
//                .reader(reader)
//                .processor(processor)
//                .writer(writer)
//                .faultTolerant()
//                .retry(Exception.class)   // 重试
//                .noRetry(ParseException.class)
//               // .retryLimit(1)           //每条记录重试一次
//               // .listener(new RetryFailuireItemListener())
//                .skip(Exception.class)
//                .skipLimit(500)         //一共允许跳过200次异常
//                .taskExecutor(new SimpleAsyncTaskExecutor()) //设置并发方式执行
//                .throttleLimit(10)        //并发任务数为 10,默认为4
//                .transactionManager(transactionManager)
//                .build();
//    }
//
//
//}
