package com.kuer.study.springboot08shiro.config;

import com.kuer.study.springboot08shiro.mapper.UserMapper;
import com.kuer.study.springboot08shiro.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kuer
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;
    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了授权方法");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 添加权限
        authorizationInfo.addStringPermission("info");
        // 获取当前登录的对象
        Subject subject = SecurityUtils.getSubject();
        // 获取认证方法传递的信息，然后添加权限
        User user = (User) subject.getPrincipal();
        return authorizationInfo;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了认证方法");
        UsernamePasswordToken passwordToken = (UsernamePasswordToken) token;
        // 链接数据库
        User user = userMapper.queryUserByName(passwordToken.getUsername());

        if (user == null){
            // 抛出异常
            return null;
        }
        // 可以加密 MD5：    MD5盐值加密：
        // 密码认证shiro做
        // 第一个参数是传递的信息，如用户姓名、权限等
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
