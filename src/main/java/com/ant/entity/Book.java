package com.ant.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Ant
 * @Date: 2019/02/13 16:11
 * @Description: 账本实体类
 */
public class Book {
    private int book_id;
    private String book_name;
    private String descript;
    private Date createtime;
    private String creater;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getCreatetime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(createtime);
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", book_name='" + book_name + '\'' +
                ", descript='" + descript + '\'' +
                ", createtime=" + createtime +
                ", creater='" + creater + '\'' +
                '}';
    }
}
