package com.ant.controller;

import com.ant.entity.Book;
import com.ant.entity.InviteMsg;
import com.ant.entity.SystemUser;
import com.ant.service.BookService;
import com.ant.service.InviteService;
import com.ant.service.SystemUserService;
import com.ant.service.UserService;
import com.ant.utils.CalcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: Ant
 * @Date: 2019/02/12 14:23
 * @Description: 控制页面跳转
 */
@Controller
public class PageController {

    @Autowired
    private BookService bookService;
    @Autowired
    private InviteService inviteService;
    @Autowired
    private SystemUserService userService;

    @RequestMapping("/login")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/")
    public String rootPage() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String homePage(HttpSession session, @RequestParam(value = "book_id", required = false) String book_id) {
        SystemUser systemUser = (SystemUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Book> bookList = bookService.findByUser(systemUser.getId());
        if (bookList.size() == 0) {
            session.setAttribute("nobook", true);
            session.setAttribute("bookList", bookList);
            return "home";
        }
        Book book = null;   // 主页Book
        if (book_id != null && !Objects.equals(book_id, "")) {
            int b_id;
            try {
                b_id = Integer.parseInt(book_id);
            }catch (Exception e){
                return "waring";
            }
            // 有book_id，则取出指定的Book作为主页显示book
            for (Book book1 : bookList) {
                if (book1.getBook_id() == b_id){
                    book = book1;
                    break;
                }
            }
            if (book == null)return "waring";
        } else {
            // 根据用户查询账本
            book = bookList.get(0);
        }

        // 计算当前用户在该账本下的资产结果
//        session.setAttribute("balance", calcUtils.calcBalance(systemUser.getId(), book.getBook_id()));
        session.setAttribute("balance", bookService.findBalance(systemUser.getId(),book.getBook_id()));
        session.setAttribute("book", book);
        session.setAttribute("nobook", false);

        session.setAttribute("bookList", bookList);
        return "home";
    }

    @RequestMapping("/newBook")
    public String newBookPage() {
        return "newBook";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/bookkeeping")
    public String bookKeeping(HttpSession session, @RequestParam(value = "book_id") String book_id){
        SystemUser systemUser = (SystemUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Book book = null;   // 操作的book
        // 校验用户是否属于传入的book_id
        List<Book> bookList = bookService.findByUser(systemUser.getId());
        int b_id;
        try {
            b_id = Integer.parseInt(book_id);
        }catch (Exception e){
            return "waring";
        }
        // 有book_id，则取出指定的Book作为主页显示book
        for (Book book1 : bookList) {
            if (book1.getBook_id() == b_id){
                book = book1;
                break;
            }
        }
        if (book == null)return "waring";

        session.setAttribute("book",book);
        return "bookkeeping";
    }

    @RequestMapping("/inviteConfirm")
    public String getInviteConfirmPage(){
        return "inviteConfirm";
    }

    @RequestMapping("/inviteDetail")
    public String getInviteDetailPage(HttpSession session, @RequestParam("invite_id")int invite_id){
        InviteMsg inviteMsg = inviteService.findById(invite_id);
        Book book = bookService.findById(inviteMsg.getBook_id());
        System.out.println(inviteMsg.getCreatetime());
        System.out.println(book.getCreatetime());
        session.setAttribute("invite",inviteMsg);
        session.setAttribute("book",book);
        session.setAttribute("creater",userService.findById(book.getCreater()));
        session.setAttribute("userCount",bookService.findUserCount(inviteMsg.getBook_id()));
        return "inviteDetail";
    }

}
