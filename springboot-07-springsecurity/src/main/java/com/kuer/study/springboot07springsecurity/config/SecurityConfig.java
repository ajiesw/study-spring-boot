package com.kuer.study.springboot07springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/**
 * @author kuer
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 授权
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 请求授权的规则
        // 首页所有人可以访问
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2");

        // 没有权限会默认回到登录页
        http.formLogin()
                .loginPage("/index")
                .usernameParameter("user")
                .passwordParameter("pwd")
                .loginProcessingUrl("/login");

        // 开启注销功能
        http.logout();

        // 防跨站攻击
        http.cors().disable();

        // 开启remember me功能, 默认保存两周
        http.rememberMe();
    }

    /**
     * 认证
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.inMemoryAuthentication().passwordEncoder(encoder)
                .withUser("kuer").password(encoder.encode("123456")).roles("vip1", "vip2")
                .and()
                .withUser("wkj").password(encoder.encode("123")).roles("admin");
    }
}
