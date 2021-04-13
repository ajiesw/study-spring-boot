package com.kuer.study.springboot08shiro.controller;

import com.kuer.study.springboot08shiro.config.UserRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kuer
 */
@Controller
public class MyController {

    @Autowired
    private UserRealm userRealm;

    @GetMapping({"/", "index"})
    public String test(Model model){
        model.addAttribute("msg", "这是后台信息");
        return "index";
    }

    @GetMapping("show")
    public String show(Model model){
        model.addAttribute("msg", "这是后台信息");
        return "user/show";
    }

    @GetMapping("info")
    public String info(Model model){
        model.addAttribute("msg", "这是后台信息");
        return "user/info";
    }

    @RequestMapping("toLogin")
    public String toLogin(Model model){
        model.addAttribute("msg", "这是后台信息");
        return "login";
    }
    @RequestMapping("login")
    public String login(String username, String password, Model model){
        // 获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行登陆方法 如果没有异常登陆成功 否则登陆失败
        try {
            subject.login(token);
            return "index";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "login";
        }
    }

    @RequestMapping("unauthorized")
    public String unauthorized(Model model){
        model.addAttribute("msg", "未授权");
        return "index";
    }
}
