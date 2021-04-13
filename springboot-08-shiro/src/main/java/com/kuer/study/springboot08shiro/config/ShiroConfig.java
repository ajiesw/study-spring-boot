package com.kuer.study.springboot08shiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author kuer
 */
@Configuration
public class ShiroConfig {

    /**
     * ShiroFilterFactoryBean
     * @param defaultWebSecurityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        // 设置安全管理器
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultWebSecurityManager);
        // 添加shiro的内置过滤器
        /*
        anon: 无需认证就可以访问
        authc： 必须认真了才能访问
        user：必须拥有 记住我 功能才能用
        perms：拥有对某个资源的权限才能访问
        role：拥有某个角色权限才能访问
         */
        HashMap<String, String> filterChainDefinitionMap = new HashMap<>(16);
        // 登录拦截
        filterChainDefinitionMap.put("/show", "authc");
        filterChainDefinitionMap.put("/toLogin", "anon");
//        filterChainDefinitionMap.put("/info", "authc");

        // 授权，正常情况下，没有授权会跳转到未授权页面
        filterChainDefinitionMap.put("/info", "perms[info]");
        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        // 设置登录请求
        factoryBean.setLoginUrl("/toLogin");
        // 设置未授权请求
        factoryBean.setUnauthorizedUrl("/unauthorized");
        return factoryBean;
    }

    /**
     * DefaultWebSecurityManager
     * @return
     */
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public DefaultWebSessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    /**
     * 创建Realm对象
     * @return
     */
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
