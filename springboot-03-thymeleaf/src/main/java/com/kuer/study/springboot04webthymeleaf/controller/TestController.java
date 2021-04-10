package com.kuer.study.springboot04webthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author kuer
 */
@Controller
public class TestController {

    @GetMapping("test")
    public String test(Model model){
        model.addAttribute("msg", "hello");
        return "test";
    }
}
