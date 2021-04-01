package com.kuer.study.spring.boot02.config.config.entity;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;

/**
 * @author kuer
 */
@Component
@Validated
public class EmailEntity {

    @Value("123")
    @Email(message = "需要邮箱")
    private String address;

    private Date date;

    private Integer times;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "EmailEntity{" +
                "address='" + address + '\'' +
                ", date=" + date +
                ", times=" + times +
                '}';
    }
}
