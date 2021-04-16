package com.kuer.study.swagger.controller;

import com.kuer.study.swagger.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kuer
 */
@Controller
public class HelloController {

    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }


    /**
     * 只要接口中，返回值中存在实体类，就会扫描到Swagger中
     * @return
     */
    @GetMapping("user")
    @ResponseBody
    public User user(){
        return new User();
    }
}
