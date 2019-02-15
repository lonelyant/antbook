package com.ant.mapper;

import com.ant.entity.InviteMsg;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Ant
 * @Date: 2019/02/15 13:06
 * @Description:
 */
@Mapper
@Component
public interface InviteMapper {

    @Select("select * from invite_msg where owner=#{id} order by createtime desc limit #{begin},#{count}")
    List<InviteMsg> findByUser(@Param("id") String id, @Param("begin") int begin, @Param("count") int count);

    @Select("select * from invite_msg where invite_id=#{invite_id}")
    InviteMsg findById(@Param("invite_id") int invite_id);
}
