package com.enshub.personal.controller;

import com.enshub.personal.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test/")
@Slf4j
@Api(value = "测试接口")
public class TestConlloer {
    @GetMapping("greet/{name}")
    @ApiOperation(value = "greet")
    public String greet(@PathVariable ("name") String name){
        return "hello ".concat(name);
    }

    @GetMapping("user")
    @ApiOperation(value = "测试用户接口")
    public User getUser(){
        User user=User.builder().nickname("afeng").username("waziee").password("123").build();
        return user;
    }

    @GetMapping("add")
    @ApiOperation(value = "add")
    public String add(@ModelAttribute User user){
        String a=null;
        a.equals("cc");
        return user.getNickname().concat(user.getNickname());
    }
}
