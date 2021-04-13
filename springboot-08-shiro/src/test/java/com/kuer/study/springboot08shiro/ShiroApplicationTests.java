package com.kuer.study.springboot08shiro;

import com.kuer.study.springboot08shiro.mapper.UserMapper;
import com.kuer.study.springboot08shiro.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShiroApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        User root = userMapper.queryUserByName("root");
        System.out.println(root);
    }

}
