package com.enshub.personal.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public void handleUncaughtException(Throwable e, Method method, Object... params) {
        logger.error("异步调用异常:"+method.getName(),e.getMessage(),e);
    }
}