package com.enshub.personal.demo.spring_batch.helloworld;

import lombok.Data;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * Created by szty on 2018/9/20.
 */
@Data
public class WriteTasklet implements Tasklet {

    /** Message */
    private String message;

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
            throws Exception {
        System.out.println(message);
        return RepeatStatus.FINISHED;
    }

    public WriteTasklet addMessage(String message){
        this.setMessage(message);
        return this;
    }
}