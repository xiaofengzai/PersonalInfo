package com.enshub.personal.demo.spring_batch;

import lombok.Data;

import javax.validation.constraints.Size;

/**
 * Created by szty on 2018/9/19.
 */
@Data
public class Person {
    @Size(max = 10, min = 2)
    private String name;
    private Integer age;
    private String nation;
    private String address;
}
