package com.ant.service;

import com.ant.entity.SystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author: Ant
 * @Date: 2019/02/12 15:07
 * @Description:
 */
@Component
public class UserService implements UserDetailsService {
    @Autowired
    private SystemUserService systemUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据用户名从数据库查询对应记录
        SystemUser systemUser = systemUserService.queryByUserName(s);
        if (systemUser == null) {
            throw new UsernameNotFoundException("username is not exists");
        }
        return systemUser;
    }
}
