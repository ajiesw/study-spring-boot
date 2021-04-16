package com.kuer.study.scheduling.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author kuer
 */
@Service
public class ScheduledService {

    /**
     * 在指定时间执行这个方法
     * 秒 分 时 日 月 周几
     */
    @Scheduled(cron = "0 27 21 14 4 ?")
    public void hello(){
        System.out.println("hello Scheduled");
    }
}
