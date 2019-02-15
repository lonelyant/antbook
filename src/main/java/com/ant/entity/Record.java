package com.ant.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Ant
 * @Date: 2019/02/13 16:56
 * @Description:
 */
public class Record {
    private String record_id;
    private int book_id;
    private int status; //1-待其他人确认 2-所有人已确认记录 3-已删除
    private String pname;   //商品名
    private double price;
    private int category;
    private String img;
    private String remark;
    private String creater;
    private Date createtime;
    private Date confirmtime;
    private Date deletetime;

    public String getRecord_id() {
        return record_id;
    }

    public void setRecord_id(String record_id) {
        this.record_id = record_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreatetime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(createtime);
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getConfirmtime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(confirmtime);
    }

    public void setConfirmtime(Date confirmtime) {
        this.confirmtime = confirmtime;
    }

    public String getDeletetime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(deletetime);
    }

    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }
}
