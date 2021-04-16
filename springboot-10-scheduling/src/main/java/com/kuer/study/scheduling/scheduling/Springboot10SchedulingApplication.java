package com.kuer.study.scheduling.scheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author kuer
 */
@EnableScheduling
@SpringBootApplication
public class Springboot10SchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot10SchedulingApplication.class, args);
    }

}
