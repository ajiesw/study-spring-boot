package com.kuer.study.provider.impl;

import com.kuer.study.provider.TicketService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * 要注册到注册中心时
 * @author kuer
 */
@DubboService
@Service
public class TicketServiceImpl implements TicketService {
    @Override
    public String getTicket() {
        return "你给一张票";
    }
}
