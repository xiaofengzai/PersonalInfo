package com.enshub.personal.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CommonExceptionHandler {
    @ExceptionHandler(Exception.class)

    @ResponseBody
    public InvokeResult exceptionHandler(Exception e){
        return InvokeResult.failed(e.getMessage(),500);

    }
}
