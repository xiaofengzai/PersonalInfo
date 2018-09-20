package com.enshub.personal.demo.spring_batch.helloworld;

import com.enshub.personal.demo.spring_batch.simple.JobCompletionListener;
import com.enshub.personal.demo.spring_batch.simple.Processor;
import com.enshub.personal.demo.spring_batch.simple.Reader;
import com.enshub.personal.demo.spring_batch.simple.Writer;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;

/**
 * Created by szty on 2018/9/20.
 */
@Configuration
public class HelloWorldBatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    @Qualifier("helloWorldJob")
    public Job helloWorldJob() {
        return jobBuilderFactory.get("helloWorldJob")
                .incrementer(new RunIdIncrementer()).listener(new JobCompletionListener())
                .flow(helloStep()).next(worldStep()).end().build();
    }

    @Bean
    @Qualifier("helloStep")
    public Step helloStep() {
        return stepBuilderFactory.get("helloStep").tasklet(hello()).build();
    }

    @Bean
    @Qualifier("worldStep")
    public Step worldStep() {
        return stepBuilderFactory.get("worldStep").tasklet(world()).build();
    }

    @Bean
    @Qualifier("hello")
    WriteTasklet hello(){
        return new WriteTasklet().addMessage("hello");
    }

    @Bean
    @Qualifier("world")
    WriteTasklet world(){
        return new WriteTasklet().addMessage("world");
    }
}
