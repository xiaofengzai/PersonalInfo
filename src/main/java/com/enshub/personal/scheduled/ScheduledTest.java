package com.enshub.personal.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by szty on 2018/9/20.
 */
@Component
public class ScheduledTest {
    @Scheduled(cron = "${scheduled.corn.test}")
    public void testThread(){
        System.out.println("time"+System.currentTimeMillis());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000L);
                    System.out.println("time HH"+System.currentTimeMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
