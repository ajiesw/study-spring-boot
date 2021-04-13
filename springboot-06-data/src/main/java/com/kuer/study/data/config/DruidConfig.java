package com.kuer.study.data.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kuer
 */
@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    /**
     * 后台监控：就是web.xml
     * 因为springboot内置了servlet容器，所以没有web.xml，替代方法：ServletRegistrationBean
      */
    @Bean
    public ServletRegistrationBean<StatViewServlet> statViewServlet(){
        // 配置网页端访问路径
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<StatViewServlet>(new StatViewServlet(), "/druid/*");

        // 后台登录账号密码
        Map<String,String> initParams = new HashMap<String, String>(16) {{
            put("loginUsername", "admin");
            put("loginPassword", "123456");
            // 允许谁访问
            put("allow", "");
            // 禁止访问
            put("deny", "192.168.23.243");
        }};
        bean.setInitParameters(initParams);

        return bean;
    }

    /**
     * filter
     * @return
     */
    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter(){
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<>(new WebStatFilter());

        // 可以过滤的请求
        bean.setInitParameters(new HashMap<String, String>(16){{
            // 不进行统计
            put("exclusions", "*.js,*.css,/druid/**");
        }});

        return bean;
    }
}
