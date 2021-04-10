package com.kuer.study.spring.boot01.first.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kuer
 */
@RestController
public class FirstController {

    @RequestMapping("hello")
    public String hello(){
        return "你好，SpringBoot";
    }
}
