//package com.enshub.personal.demo.spring_batch.mongo;
//
//import com.enshub.personal.demo.spring_batch.simple.JobCompletionListener;
//import com.enshub.personal.demo.spring_batch.simple.Processor;
//import com.enshub.personal.demo.spring_batch.simple.Reader;
//import com.enshub.personal.demo.spring_batch.simple.Writer;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecutionListener;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * Created by szty on 2018/9/20.
// */
//@Configuration
//public class MongoBatchConfig {
//
//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Job processJob() {
//        return jobBuilderFactory.get("processJob")
//                .incrementer(new RunIdIncrementer()).listener(listener())
//                .flow(orderStep1()).end().build();
//    }
//
//    @Bean
//    @Qualifier("orderStep1")
//    public Step orderStep1() {
//        return stepBuilderFactory.get("orderStep1").<String, String> chunk(1)
//                .reader(new Reader()).processor(new Processor())
//                .writer(new Writer()).build();
//    }
//
//    @Bean
//    public JobExecutionListener listener() {
//        return new JobCompletionListener();
//    }
//
//}