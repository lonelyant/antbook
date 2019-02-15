package com.ant.service;

import com.ant.entity.SystemUser;
import com.ant.mapper.SystemUserMapper;
import com.ant.utils.MD5Util;
import com.ant.utils.ShortUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Ant
 * @Date: 2019/02/12 15:09
 * @Description:
 */

@Service
public class SystemUserService {
    @Autowired
    private SystemUserMapper systemUserMapper;

    public SystemUser queryByUserName(String username) {
        return systemUserMapper.queryByUserName(username);
    }

    public SystemUser findById(String id){
        return systemUserMapper.findById(id);
    }

    public void register(SystemUser user) {
        user.setId(ShortUUID.generateShortUuid());
        user.setPassword(MD5Util.encode(user.getPassword()));
        //TODO 后台检测用户名是否已被使用
        systemUserMapper.addUser(user);
    }

    public boolean checkUsername(String username) {
        int count = systemUserMapper.findUserCount(username);
        return count == 0;
    }

    public int getInviteNum(String id) {
        return systemUserMapper.getInviteNum(id);
    }
}
