package com.ant.utils;

import com.ant.service.BookService;
import com.ant.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: Ant
 * @Date: 2019/02/13 17:02
 * @Description:
 */
@Component
public class CalcUtils {
    @Autowired
    private BookService bookService;
    @Autowired
    private RecordService recordService;
    /**
     * 计算给定用户在给定账本下的资产结果
     */
    public double calcBalance(String user_id, int book_id){
        double balance = 0.00;
        // 该账本下有几名用户
        int userCount = bookService.findUserCount(book_id);
        // 计算账单
        double totalPay = recordService.calcTotalPayByBook(book_id);
        double userPay = recordService.calcTotalPayByBookAndUser(book_id,user_id);
        balance = userPay - totalPay/userCount;
        // 计算内部转账

        return balance;
    }
}
