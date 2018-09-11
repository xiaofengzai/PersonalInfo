package com.enshub.personal.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvokeResult <T> {
    private String message;
    private Integer code=0;
    private Boolean succeeded;
    private T data;
    public static <T> InvokeResult succeeded(T data){
        return new InvokeResult(null,0,true,data);
    }
    public static <T> InvokeResult succeeded(){
        return succeeded(null);
    }

    public static <T> InvokeResult failed(String messaeg,Integer code ){
        return new InvokeResult(messaeg,code,false,null);
    }

    public static <T> InvokeResult failed(String messaeg ){
        return new InvokeResult(messaeg,-1,false,null);
    }


}
