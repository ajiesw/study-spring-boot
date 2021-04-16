package com.kuer.study.swagger.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author kuer
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docketA(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.kuer.study.swagger.controller"))
                .paths(PathSelectors.ant("/swagger/**"))
                .build().groupName("A");
    }
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.kuer.study.swagger.controller"))
                .build()
                .groupName("A");
    }
    @Bean
    public Docket docketB(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    /**
     * 配置swagger的Docket bean实例
     * @param environment 自己新增的参数，原来没有，用于实现指定环境的swagger配置
     * @return
     */
    @Bean
    public Docket docket(Environment environment){

        Profiles profiles = Profiles.of("dev", "test");
        // 当运行环境是dev 或 test 时返回true
        boolean b = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                // swagger分组，就是这个docket的名称
                // 可以在spring中注册多个docket实例都会被swagger识别
                // groupName就是这个docket的标识符
                .groupName("kuer")
                .apiInfo(apiInfo())
                .select()
                // RequestHandlerSelectors,配置接口扫描的方式
                // basePackage基于包扫描
                // any全扫描
                // none不扫描
                // withClassAnnotation扫描类上的注解
                // withMethodAnnotation扫描包上的注解
                .apis(RequestHandlerSelectors.basePackage("com.kuer.study.swagger.controller"))
                // paths 扫描url路径
                .paths(PathSelectors.ant("/swagger/**"))
                .build()
                // 控制swagger开关
                .enable(false);
    }

    /**
     * swagger信息 apiInfo
     * @return
     */
    private ApiInfo apiInfo(){
        // Contact是作者信息
        return new ApiInfo("Api Documentation",
                "Api Documentation",
                "1.0",
                "urn:tos",
                new Contact("", "", ""),
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0");

    }
}
