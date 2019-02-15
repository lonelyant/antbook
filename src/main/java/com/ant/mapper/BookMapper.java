package com.ant.mapper;

import com.ant.entity.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Ant
 * @Date: 2019/02/13 16:29
 * @Description:
 */
@Mapper
@Component
public interface BookMapper {
    @Select("select * from book where book_id in (select book_id from user_book where user_id=#{id})")
    List<Book> findByUser(@Param("id") String id);

    @Select("select count(*) from user_book where book_id=#{id}")
    int findUserCount(int id);

    @Insert("insert into book(book_name,creater,descript) values(#{book.book_name},#{book.creater},#{book.descript})")
    @Options(useGeneratedKeys = true, keyProperty = "book.book_id", keyColumn = "book_id")
    int addBook(@Param("book") Book book);

    @Insert("insert into user_book(book_id,user_id) values(#{book.book_id},#{book.creater})")
    void addUser_Book(@Param("book")Book book);

    @Select("select * from book where book_id=#{book_id}")
    Book findById(@Param("book_id") int book_id);

    @Insert("insert into balance(user_id,book_id,balance) values(#{book.creater},#{book.book_id},0.00)")
    void addBalance(@Param("book") Book book);

    @Update("update balance set balance=#{balance} where user_id=#{user_id} and book_id=#{book_id}")
    void updateBalance(@Param("user_id") String user_id, @Param("book_id") String book_id, @Param("balance") double balance);

    @Select("select balance from balance where user_id=#{user_id} and book_id=#{book_id}")
    double findBalance(@Param("user_id") String user_id, @Param("book_id") int book_id);
}
