package com.kuer.study.consumer;


import com.kuer.study.provider.TicketService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author kuer
 */
@Service
public class UserService {
    /**
     * 获取provide提供的服务，需要去注册中心拿到服务
     * 需要获取服务的引用
     * 1. 获取pom坐标
     * 2. 定义路径相同的接口名
     */
    @DubboReference
    TicketService ticketService;

    public void buyTicket(){
        String ticket = ticketService.getTicket();
        System.out.println("获取远程服务===>" + ticket);
    }
}
