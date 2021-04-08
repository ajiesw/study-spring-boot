package com.kuer.study.spring.boot03.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kuer
 */
@RestController
public class TestController {

    @RequestMapping("test")
    public String test(){
        return "test hello";
    }
}
