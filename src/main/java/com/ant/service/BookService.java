package com.ant.service;

import com.ant.entity.Book;
import com.ant.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Ant
 * @Date: 2019/02/13 16:27
 * @Description:
 */
@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public List<Book> findByUser(String id) {
        return bookMapper.findByUser(id);
    }

    public int findUserCount(int id) {
        return bookMapper.findUserCount(id);
    }

    public void addBook(Book book) {
        // 新增记账本
        bookMapper.addBook(book);
        // 记录记账本与用户关联信息
        bookMapper.addUser_Book(book);
        // 新增用户在新建账本下的余额信息
        bookMapper.addBalance(book);
    }

    public Book findById(int book_id) {
        return bookMapper.findById(book_id);
    }

    public void cgUser_Balance(String user_id, String book_id, double balance) {
        bookMapper.updateBalance(user_id, book_id, balance);
    }

    public double findBalance(String user_id, int book_id){
        return bookMapper.findBalance(user_id, book_id);
    }
}
