package com.enshub.personal.demo.spring_batch;

import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by szty on 2018/9/19.
 */
public class MessagesItemWriter implements ItemWriter<Message> {
    public void write(List<? extends Message> messages) throws Exception {
        System.out.println("write results");
        for (Message m : messages) {
            System.out.println(m.getContent());
        }
    }
}