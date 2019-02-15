package com.ant.mapper;

import com.ant.entity.SystemUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: Ant
 * @Date: 2019/02/12 15:10
 * @Description:
 */
@Component
@Mapper
public interface SystemUserMapper {

    SystemUser queryByUserName(String username);

    @Insert("insert into system_user(id,username,password,role) values(#{user.id},#{user.username},#{user.password},'USER')")
    void addUser(@Param("user") SystemUser user);

    @Select("select count(*) from system_user where username=#{username}")
    int findUserCount(@Param("username") String username);

    @Select("select count(*) from invite_msg where owner=#{id} and status=0")
    int getInviteNum(@RequestParam("id") String id);

    @Select("select * from system_user where id=#{id}")
    SystemUser findById(@Param("id") String id);
}
