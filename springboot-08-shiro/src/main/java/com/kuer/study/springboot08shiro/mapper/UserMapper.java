package com.kuer.study.springboot08shiro.mapper;

import com.kuer.study.springboot08shiro.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author kuer
 */
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    User queryUserByName(String name);
}
