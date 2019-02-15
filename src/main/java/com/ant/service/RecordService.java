package com.ant.service;

import com.ant.mapper.RecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Ant
 * @Date: 2019/02/13 17:06
 * @Description:
 */
@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    public double calcTotalPayByBook(int book_id) {
        List<Double> priceList = recordMapper.findAllPriceByBookAndStatus(book_id,2);
        double total = 0.00;
        for (Double aDouble : priceList) {
            total += aDouble;
        }
        return total;
    }

    public double calcTotalPayByBookAndUser(int book_id, String user_id) {
        List<Double> priceList = recordMapper.findAllPriceByBookAndStatusAndUser(book_id,2,user_id);
        double total = 0.00;
        for (Double aDouble : priceList) {
            total += aDouble;
        }
        return total;
    }
}
