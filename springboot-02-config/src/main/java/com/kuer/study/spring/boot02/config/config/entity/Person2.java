package com.kuer.study.spring.boot02.config.config.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author kuer
 */
@Component
public class Person2 {

    // SPEL表达式取出配置文件
    @Value("${name}")
    private String name;
    @Value("${age}")
    private Integer age;

    private Boolean life;

    private Date birth;

    private LocalDate schoolDay;

    private Map<String, Object> info;

    private List<Object> relation;

    private Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getLife() {
        return life;
    }

    public void setLife(Boolean life) {
        this.life = life;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public LocalDate getSchoolDay() {
        return schoolDay;
    }

    public void setSchoolDay(LocalDate schoolDay) {
        this.schoolDay = schoolDay;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }

    public List<Object> getRelation() {
        return relation;
    }

    public void setRelation(List<Object> relation) {
        this.relation = relation;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", life=" + life +
                ", birth=" + birth +
                ", schoolDay=" + schoolDay +
                ", info=" + info +
                ", relation=" + relation +
                ", dog=" + dog +
                '}';
    }
}
