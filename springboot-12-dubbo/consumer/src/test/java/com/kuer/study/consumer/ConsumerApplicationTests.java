package com.kuer.study.consumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        userService.buyTicket();
    }

}
