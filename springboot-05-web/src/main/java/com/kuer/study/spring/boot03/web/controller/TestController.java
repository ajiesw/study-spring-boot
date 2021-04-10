package com.kuer.study.spring.boot03.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author kuer
 */
@Controller
public class TestController {

    @RequestMapping("test")
    @ResponseBody
    public String test(){
        return "test hello";
    }

    @RequestMapping("main")
    public String main(@RequestParam Integer user, Model model, HttpSession session){
        if (user == 123){
            model.addAttribute("msg", "终于登陆了");
            session.setAttribute("user", "success");
            return "welcome";
        }else {
            model.addAttribute("msg", "需要登录");
            return "index";
        }
    }
}
