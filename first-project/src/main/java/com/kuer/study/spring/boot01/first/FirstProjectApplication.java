package com.kuer.study.spring.boot01.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序主入口
 * /@SpringBootApplication 标注这个类是一个springboot应用 启动类下所有的资源被导入
 * @author kuer
 */
@SpringBootApplication
public class FirstProjectApplication {

    public static void main(String[] args) {
        // 启动springboot应用
        // SpringApplication类
        // run方法
        SpringApplication.run(FirstProjectApplication.class, args);
    }

}
