package com.ant.controller;

import com.ant.entity.Book;
import com.ant.entity.ReMsg;
import com.ant.entity.SystemUser;
import com.ant.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: Ant
 * @Date: 2019/02/13 18:41
 * @Description:
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/addNewBook")
    public @ResponseBody ReMsg addNewBook(Book book){
        ReMsg msg = new ReMsg();
        try {
            SystemUser systemUser = (SystemUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            book.setCreater(systemUser.getId());
            bookService.addBook(book);
            msg.setStatus(true);
            msg.setMsg("Success!");
        }catch (Exception e){
            msg.setStatus(false);
            msg.setMsg(e.getMessage());
        }
        return msg;
    }


}
