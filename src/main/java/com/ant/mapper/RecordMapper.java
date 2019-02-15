package com.ant.mapper;

import com.ant.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Ant
 * @Date: 2019/02/13 17:24
 * @Description:
 */
@Mapper
@Component
public interface RecordMapper {

    @Select("select * from record where book_id=#{book_id} and status=#{i}")
    List<Record> findAllByBookAndStatus(@Param("book_id") int book_id, @Param("i") int i);

    @Select("select price from record where book_id=#{book_id} and status=#{i}")
    List<Double> findAllPriceByBookAndStatus(@Param("book_id") int book_id, @Param("i") int i);

    @Select("select * from record where book_id=#{book_id} and status=#{i} and creater=#{user_id}")
    List<Record> findAllByBookAndStatusAndUser(@Param("book_id") int book_id, @Param("i") int i, @Param("user_id") String user_id);

    @Select("select price from record where book_id=#{book_id} and status=#{i} and creater=#{user_id}")
    List<Double> findAllPriceByBookAndStatusAndUser(@Param("book_id") int book_id, @Param("i") int i, @Param("user_id") String user_id);
}
