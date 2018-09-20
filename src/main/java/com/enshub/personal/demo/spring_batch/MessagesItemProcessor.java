package com.enshub.personal.demo.spring_batch;

import org.springframework.batch.item.ItemProcessor;

/**
 * Created by szty on 2018/9/19.
 */
public class MessagesItemProcessor implements ItemProcessor<Person, Message> {
    public Message process(Person person) throws Exception {
        Message m = new Message();
        m.setContent("Hello " + person.getName()
                + ",please pay promptly at the end of this month.");
        return m;
    }

}