package com.kuer.study.springboot04webthymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * 扩展 SpringMVC
 * 如果需要增加新功能，只要写组件然后交给springboot，springboot会帮我们自动装配
 * @author kuer
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {



    /**
     * 视图跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("test");
    }

    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }


    /**
     * 自定义视图解析器
     */
    public static class MyViewResolver implements ViewResolver{

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }
}
