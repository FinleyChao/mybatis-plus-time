package com.foolish.swaggerdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author：chaoxianfei
 * @date：2020/1/13 9:32
 */
@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(String name){
        return "Hello " + name + "!";
    }


}
